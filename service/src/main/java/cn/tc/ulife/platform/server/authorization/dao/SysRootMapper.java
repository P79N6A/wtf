package cn.tc.ulife.platform.server.authorization.dao;

import cn.tc.ulife.platform.server.authorization.model.EntityModel;
import cn.tc.ulife.platform.server.authorization.model.GroupRootRole;
import cn.tc.ulife.platform.server.authorization.model.ResourceFront;
import cn.tc.ulife.platform.server.authorization.model.SysRoot;

import java.util.List;
import java.util.Map;

public interface SysRootMapper {
    int deleteUserRootByCodeAndUid(Map<String, String> paramMap);

    int insertRoot(SysRoot sysRoot);

    SysRoot selectByPrimaryKey(String id);

    List<GroupRootRole> selectAuthMenuList(Map<String, String> paramMap);


    List<ResourceFront> selectUserLoginAuthMenuList(Map<String, String> paramMap);

    GroupRootRole queryResouceRootByCode(String code);

    EntityModel selectEntityModelByCodeAndUid(Map<String, String> paramMap);

    EntityModel selectNaturalPersonComm(Map<String, String> paramMap);

    List<String> selectGroupRoleByComm(Map<String, Object> paramMap);


    List<GroupRootRole> selectAdminAuthMenuList(Map<String, String> paramMap);

    int deleteButtonByCodeAndUid(Map<String, String> paramMap);

    String queryEntityResId(Map<String, String> paramMap);

    GroupRootRole queryResouceRootById(String id);
}