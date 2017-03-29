package cn.tc.ulife.platform.agent.controller.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.tc.ulife.platform.agent.base.BaseController;
import cn.tc.ulife.platform.agent.componet.SystemLog;
import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.door.manager.HardWareService;
import cn.tc.ulife.platform.server.authorization.model.BackGroundUser;
import cn.tc.ulife.platform.server.authorization.service.AuthorizationService;
import cn.tc.ulife.platform.server.sys.model.SmsCodeBean;
import cn.tc.ulife.platform.server.sys.service.SmsService;
import cn.tc.ulife.platform.server.user.model.BaseUserEntity;
import cn.tc.ulife.platform.server.user.model.SysBaseUser;
import cn.tc.ulife.platform.server.user.model.UserFront;
import cn.tc.ulife.platform.server.user.model.ViewUserBean;
import cn.tc.ulife.platform.server.user.service.BaseUserService;
import cn.tc.ulife.platform.util.ExceptionUtil;
import cn.tc.ulife.platform.util.GsonUtil;
import cn.tc.ulife.platform.util.MD5;
import cn.tc.ulife.platform.util.constance.Constance;
import cn.tc.ulife.platform.util.constance.SysConstance;
import cn.tc.ulife.platform.validators.Validate;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.agent.controller
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/8 0008
 * </p>
 * Time: 下午 5:45
 * </p>
 * Detail:
 * </p>
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private BaseUserService baseUserService;

	@Autowired
	AuthorizationService authorizationService;

	@Autowired
	private SmsService smsService;

	/**
	 * 用户登录
	 *
	 * @param app
	 *            app类型
	 * @param account
	 *            用户账号
	 * @param password
	 *            用户密码
	 * @return
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public ReturnMsg login(String app, String account, String password) {
		UserFront userFront = baseUserService.queryUserByAccPwd(account, password);
		// 登录账号不存在
		if (userFront == null) {
			return AppResponseMsg.faild("账号或密码不正确，请重新输入");
		} else {

			userFront.setCache();
			BackGroundUser backGroundUser = (BackGroundUser) authorizationService.getLoginAttr(userFront);
			backGroundUser.setCache();
			logger.info("登录成功");
			return AppResponseMsg.success(backGroundUser);
		
			/*userFront = baseUserService.queryUserByAccPwd(account, password);

			// 登录密码不正确
			if (userFront == null) {
				return AppResponseMsg.faild("登录密码不正确");
			} else {
				userFront.setCache();
				BackGroundUser backGroundUser = (BackGroundUser) authorizationService.getLoginAttr(userFront);
				backGroundUser.setCache();
				logger.info("登录成功");
				return AppResponseMsg.success(backGroundUser);
			}*/
		}
	}

	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	@ResponseBody
	public ReturnMsg adminLogin(String app, String account, String password) {
		UserFront userFront = baseUserService.queryUserByAccPwd(account, null);
		// 登录账号不存在
		if (userFront == null) {
			return AppResponseMsg.faild(ExceptionUtil.getProperties("100001"));
		} else {
			userFront = baseUserService.queryUserByAccPwd(account, password);
			// userFront = authorizationService.getLoginAttr(userFront);
			// 登录密码不正确
			if (userFront == null) {
				logger.info(ExceptionUtil.getProperties("100002"));
				return AppResponseMsg.faild(ExceptionUtil.getProperties("100002"));
			} else {
				logger.info("登录成功");
				return AppResponseMsg.success(userFront);
			}
		}
	}

	/**
	 * 获取用户列表
	 *
	 * @param app
	 *            app类型
	 * @param xqid
	 *            小区id
	 * @param roomid
	 *            房间id
	 * @param text
	 *            手机号/用户名称/用户昵称
	 * @param role
	 *            角色id
	 * @param zt
	 *            用户状态
	 * @param ofset
	 *            页数
	 * @param psize
	 *            条数
	 * @return
	 */
	@RequestMapping("/getUserList")
	@ResponseBody
	public ReturnMsg getUserList(String app, String xqid, String roomid, String text, String role, String zt,
			String ofset, String psize) {
		Map<String, Object> map = checkPage(ofset, psize);
		List<UserFront> userFrontList = baseUserService.queryUserList(xqid, roomid, text, role, zt,
				(Integer) map.get("ofset"), (Integer) map.get("psize"));

		if (userFrontList == null || userFrontList.size() <= 0) {
			// 用户信息列表不存在
			logger.info(ExceptionUtil.getProperties("100003"));
			return AppResponseMsg.faild(ExceptionUtil.getProperties("100003"));
		} else {
			logger.info("查询用户列表成功");
			return AppResponseMsg.success(userFrontList);
		}
	}

	/**
	 * 管理员获取用户列表
	 *
	 * @param account
	 *            用户账号
	 * @param app
	 *            app类型
	 * @param ofset
	 *            页数
	 * @param psize
	 *            条数
	 * @return
	 */
	@RequestMapping("/getAdminUserList")
	@ResponseBody
	@SystemLog(description = "管理员获取用户列表")
	public ReturnMsg getAdminUserList(String account, String app, String ofset, String psize) {
		Map<String, Object> map = checkPage(ofset, psize);
		List<BaseUserEntity> userFrontList = baseUserService.queryUserAll((Integer) map.get("ofset"),
				(Integer) map.get("psize"));

		if (userFrontList != null) {
			return AppResponseMsg.success(userFrontList, baseUserService.countUser());
		} else {
			return AppResponseMsg.faild("管理员获取用户列表失败");
		}
	}

	/**
	 * 管理员修改用户信息
	 *
	 * @param account
	 *            用户账号
	 * @param app
	 *            app类型
	 * @param pageJson
	 *            用户信息
	 * @return
	 */
	@RequestMapping("/updAdminUser")
	@ResponseBody
	@SystemLog(description = "管理员修改用户信息")
	public ReturnMsg updAdminUser(String account, String app, String pageJson) {
		BaseUserEntity userFront = GsonUtil.jsonToObject(pageJson, BaseUserEntity.class);
		boolean flag = baseUserService.updOraddAdminUser(userFront);
		if (flag) {
			return AppResponseMsg.success("管理员修改用户信息成功");
		} else {
			return AppResponseMsg.faild("管理员修改用户信息失败");
		}
	}

	/**
	 * 管理员修改用户信息
	 *
	 * @param account
	 *            用户账号
	 * @param app
	 *            app类型
	 * @param uid
	 *            用户信息
	 * @return
	 */
	@RequestMapping("/resetUserPassword")
	@ResponseBody
	@SystemLog(description = "管理员重置用户密码")
	public ReturnMsg resetUserPassword(String account, String app, @Param("id") String uid) {
		BaseUserEntity userFront = new BaseUserEntity();
		userFront.setId(uid);
		boolean flag = baseUserService.resetUserPassword(userFront);
		if (flag) {
			return AppResponseMsg.success("管理员重置用户密码成功");
		} else {
			return AppResponseMsg.faild("管理员重置用户密码失败");
		}
	}

	/**
	 * 管理员新增用户信息
	 *
	 * @param account
	 * @param app
	 * @param pageJson
	 * @return
	 */
	@RequestMapping("/addAdminUser")
	@ResponseBody
	@SystemLog(description = "管理员新增用户信息")
	public ReturnMsg addAdminUser(String account, String app, String pageJson) {
		BaseUserEntity userFront = GsonUtil.jsonToObject(pageJson, BaseUserEntity.class);
		boolean flag = baseUserService.updOraddAdminUser(userFront);
		if (flag) {
			return AppResponseMsg.success("管理员新增用户信息成功");
		} else {
			return AppResponseMsg.faild("管理员新增用户信息失败");
		}
	}

	/**
	 * 后台开户
	 *
	 * @param sbuser
	 *            用户信息对象
	 * @param account
	 *            操作用户id
	 * @return
	 */
	@RequestMapping("/createUser")
	@ResponseBody
	@Validate
	public ReturnMsg createUser(@Validate(isForm=true)ViewUserBean vUser, String account) {
		// 已知用户信息都正常， 先要判断验证码是否正确
		List<SmsCodeBean> smsCodes = smsService.querySmscode(vUser.getMOBILE());
		if (null != smsCodes && !smsCodes.isEmpty()) {
			SmsCodeBean sCode = smsCodes.get(0);
			if (sCode.getCODE().equals(vUser.getSmsCode())) {
				SysBaseUser baseUser = new SysBaseUser();
				baseUser.setAccount(vUser.getMOBILE());
				baseUser.setPassword(MD5.encryption("123456"));
				baseUser.setMOBILE(vUser.getMOBILE());
				baseUser.setTEL("");
				baseUser.setNickName(vUser.getNickName());
				baseUser.setNAME(vUser.getNAME());
				baseUser.setIdentityType(vUser.getIdentityType());
				baseUser.setIdentityNo(vUser.getIdentityNo());
				baseUser.setBirthDay(vUser.getBirthDay());
				baseUser.setGender(vUser.getGender());
				baseUser.setREMARK(vUser.getREMARK());
				baseUser.setCOMID(vUser.getCOMID());
				baseUser.setROOMID(vUser.getROOMID());
				baseUser.setRegMethod(SysConstance.RegistUser.Auto.getValue() + "");
				baseUser.setDTYPE(SysConstance.APPType.PC.getValue() + "");
				baseUser.setCreator(account);
				baseUser.setKFID("");
				baseUser.setIsNewUser("0");
				// 注册用户是否为小孩 1 非 0 是
				baseUser.setRKE_IsChild("1");
				// 指纹码
				baseUser.setRKE_FingerPrint("");

				// 请求对讲服务
				JSONObject json = HardWareService.getHardService(Constance.HARDWARE_CreateAccount+vUser.getMOBILE(),
						null);

				if (null == json) {
					return AppResponseMsg.faild("开户失败,创建对讲账户失败");
				}
				if (0 != (Integer)json.get("code")) {
					
					if(3 ==  (Integer)json.get("code"))
					{
						return AppResponseMsg.faild("开户失败,系统未授权视频服务");
					}
					
					return AppResponseMsg.faild("开户失败,创建对讲账户失败");
				}

				JSONObject data = json.getJSONObject("data");
				if (null == data || null == data.get("userId")) {
					return AppResponseMsg.faild("开户失败,创建对讲账户失败");
				}
				baseUser.setTalkAccount(data.get("userId").toString());
				baseUser.setTalkPassword(data.get("loginToken").toString());

				int code = baseUserService.insertUser(baseUser);
				if (code > 0) {
					return AppResponseMsg.success("开户成功");
				} else {
					return AppResponseMsg.faild("开户失败");
				}

			}

		}

		return AppResponseMsg.faild("验证码不正确");
	}

}
