package cn.tc.ulife.platform.server.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.tc.ulife.platform.server.user.model.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tc.ulife.platform.server.user.dao.BaseUserMapper;
import cn.tc.ulife.platform.server.user.service.BaseUserService;
import cn.tc.ulife.platform.util.MD5;
import cn.tc.ulife.platform.util.constance.Constance;
import cn.tc.ulife.platform.util.jedis.JedisTool;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.spring.wap.service.impl
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/7 0007
 * </p>
 * Time: 上午 9:26
 * </p>
 * Detail:
 * </p>
 */
@Service("baseUserService")
public class BaseUserServiceImpl implements BaseUserService {

	@Autowired
	BaseUserMapper baseUserMapper;

	@Override
	public UserFront queryUserByAccPwd(String account, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("account", account);
		map.put("password", password);

		return baseUserMapper.queryUserByAccPwd(map);
	}

	@Override
	public List<UserFront> queryUserList(String xqid, String roomid, String text, String role, String zt, Integer ofset,
			Integer psize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xqid", xqid);
		map.put("roomid", roomid);
		map.put("text", text);
		map.put("role", role);
		map.put("zt", zt);
		map.put("ofset", ofset);
		map.put("psize", psize);

		return baseUserMapper.queryUserList(map);
	}

	public UserFront getUserFront(String account) {
		try {
			if (account != null) {

				return JedisTool.getObject(account, UserFront.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public String queryXqggs(Map<String, Object> paramMap) {
		return baseUserMapper.queryXqggs(paramMap);
	}

	@Override
	public List<BaseUserEntity> queryUserAll(Integer ofset, Integer psize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ofset", ofset);
		map.put("psize", psize);
		return baseUserMapper.queryUserAll(map);
	}

	@Override
	public String countUser() {
		return baseUserMapper.countUser();
	}

	@Override
	public boolean updOraddAdminUser(BaseUserEntity userFront) {
		if (StringUtils.isNotEmpty(userFront.getId())) {// 修改
			baseUserMapper.updAdminUser(userFront);
		} else {// 新增
			baseUserMapper.addAdminUser(userFront);
            System.out.println("=========uid==========" + userFront.getId());
        }
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.tc.ulife.platform.server.user.service.BaseUserService#insertUser(cn.tc
	 * .ulife.platform.server.user.model.SysBaseUser)
	 */
	@Override
	@Transactional
	public int insertUser(SysBaseUser baseUser) {
		int code = baseUserMapper.insertUser(baseUser);
		if (code > 0 && !StringUtils.isEmpty(baseUser.getROOMID())) {
			UserHouseBean uHouse = new UserHouseBean();
			uHouse.setUID(baseUser.getID());
			uHouse.setCOMID(baseUser.getCOMID());
			uHouse.setROOMID(baseUser.getROOMID());
			// 是否默认小区
			uHouse.setISDEF(Constance.DEFAULT_ONE);
			// 是否审核 1默认审核
			uHouse.setIS_Audited(Constance.DEFAULT_ONE);
			code = baseUserMapper.insertUserHouse(uHouse);
		}
		return code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.tc.ulife.platform.server.user.service.BaseUserService#insertUserHouse(
	 * cn.tc.ulife.platform.server.user.model.UserHouseBean)
	 */
	@Override
	public int insertUserHouse(UserHouseBean uhouse) {
		return baseUserMapper.insertUserHouse(uhouse);
	}

    @Override
    public int updNewUserFlag(String uid, String isNewUser) {
        BaseUser baseUser = baseUserMapper.selUserByPk(uid);
        if (baseUser != null && "0".equals(baseUser.getIsNewUser())) {
            //修改新用户标识
            BaseUser userTemp = new BaseUser();
            userTemp.setId(uid);
            userTemp.setIsNewUser(isNewUser);
            baseUserMapper.updBaseUserByPk(userTemp);

            //刷新缓存
//            UserFront userFront = this.getUserFront(baseUser.getAccount());
//            userFront.setIsNewUser(isNewUser);
//            JedisTool.put(baseUser.getAccount(), userFront);
        }

        return 0;
    }

    @Override
	public boolean resetUserPassword(BaseUserEntity userFront) {
		if (StringUtils.isNotEmpty(userFront.getId())) {
			userFront.setPassword(MD5.encryption("123456"));
			baseUserMapper.updAdminUser(userFront);
			return true;
		}
		return false;
	}

	// @Override
	// public List<?> listAgentCom(String account) {
	// return baseUserMapper.listAgentCom(account, "DLS");
	// }

	// StopWatch clock = new StopWatch();
	// clock.start();
	// if (StringUtils.isNotEmpty(account)) {
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("token", account);
	// String retStr = null;
	// try {
	// retStr = HttpUtil.sendHttpPost(ConfigUtil.getProperties("PROJECT_URL") +
	// ConfigUtil.getProperties("PROJECT_SID") + "/" +
	// ConfigUtil.getProperties("PROJECT_TOKEN") +
	// "/Api/House/GetByToken", map);
	// } catch (IOException e) {
	//// e.printStackTrace();
	// logger.error("请求第三方用户信息失败 :" + retStr);
	// return null;
	// }
	//
	// if(null==retStr){
	// return null;
	// }
	// TokenAccount tokenAccount = GsonUtil.jsonToObject(retStr,
	// TokenAccount.class);
	// if (!Boolean.parseBoolean(tokenAccount.getState())) {
	// return null;
	// }
	// BaseUser baseUser = null;
	// if (null != tokenAccount && null != tokenAccount.getId()) {
	//
	// baseUser = baseUserMapper.queryUserByToken(tokenAccount.getId());
	// }
	// UserFront userFront = new UserFront();
	//
	//
	// if (baseUser != null) {
	//
	// //登录成功复制属性 ---->避免用户表类模板和前端使用用户信息模板相同
	//
	// try {
	// BeanUtils.copyProperties(userFront, baseUser);
	// } catch (IllegalAccessException e) {
	// e.printStackTrace();
	// } catch (InvocationTargetException e) {
	// e.printStackTrace();
	// }
	// if (null == JedisTool.getString(userFront.getAccount() + "-" +
	// fdf.format(new Date()))) {
	//
	// JedisTool.put(userFront.getAccount() + "-" + fdf.format(new Date()),
	// GsonUtil.objectToJson(userFront), 86400);
	//
	// //插入用户登录积分
	// // 增加积分签到功能，取消原来的登录送积分功能
	//// this.addLoginItgl(baseUser, SysConstance.IntegralGetType.LOGIN, null,
	// 0);
	// }
	// userFront.setAccount(account);
	// clock.stop();
	// logger.info("获取用户信息所需时间：" + clock.getTime());
	// return userFront;
	// }
	// clock.stop();
	// logger.info("获取用户信息所需时间：" + clock.getTime());
	// return null;
	// } else {
	// clock.stop();
	// logger.info("获取用户信息所需时间：" + clock.getTime());
	//
	// return null;
	// }
	// }
}