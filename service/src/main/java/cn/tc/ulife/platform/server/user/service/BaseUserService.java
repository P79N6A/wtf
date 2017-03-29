package cn.tc.ulife.platform.server.user.service;


import java.util.List;
import java.util.Map;

import cn.tc.ulife.platform.server.user.model.BaseUserEntity;
import cn.tc.ulife.platform.server.user.model.SysBaseUser;
import cn.tc.ulife.platform.server.user.model.UserFront;
import cn.tc.ulife.platform.server.user.model.UserHouseBean;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.spring.wap.service
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/7 0007
 * </p>
 * Time: 上午 9:25
 * </p>
 * Detail:
 * </p>
 */
public interface BaseUserService {

    /**
     * 通过账号和密码查询用户信息
     * @param account
     * @param password
     * @return
     */
    UserFront queryUserByAccPwd(String account, String password);

    /**
     * 查询用户信息列表
     * @param xqid
     * @return
     */
    List<UserFront> queryUserList(String xqid, String roomid, String text, String role, String zt, Integer ofset, Integer psize);

    /**
     * 获取登录用户信息
     * @param account
     * @return
     */
    UserFront getUserFront(String account);

    /**
     * 查询登录小区公告
     * @param paramMap
     * @return
     */
    String queryXqggs(Map<String, Object> paramMap);

    List<BaseUserEntity> queryUserAll(Integer ofset, Integer psize);

    String countUser();

    boolean updOraddAdminUser(BaseUserEntity userFront);
    
    int insertUser(SysBaseUser baseUser);

    boolean resetUserPassword(BaseUserEntity userFront);

	int insertUserHouse(UserHouseBean uhouse);

    int updNewUserFlag(String id, String s);
}
