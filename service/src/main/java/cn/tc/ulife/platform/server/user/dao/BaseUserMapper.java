package cn.tc.ulife.platform.server.user.dao;

import cn.tc.ulife.platform.server.user.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseUserMapper {

    /**
     * 通过账号和密码查询用户信息
     *
     * @return
     */
    UserFront queryUserByAccPwd(Map<String, Object> map);

    /**
     * 查询用户信息列表
     *
     * @return
     */
    List<UserFront> queryUserList(Map<String, Object> map);

    /**
     * 查询登录小区公告
     *
     * @param paramMap
     * @return
     */
    String queryXqggs(Map<String, Object> paramMap);

    List<BaseUserEntity> queryUserAll(Map<String, Object> map);

    String countUser(String... params);

    int updAdminUser(BaseUserEntity userFront);

    int addAdminUser(BaseUserEntity userFront);

    int insertUser(SysBaseUser baseUser);

	int insertUserHouse(UserHouseBean uhouse);

    BaseUser selUserByPk(String uid);

    int updBaseUserByPk(BaseUser userTemp);
}