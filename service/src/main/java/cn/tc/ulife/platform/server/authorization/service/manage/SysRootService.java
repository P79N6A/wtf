package cn.tc.ulife.platform.server.authorization.service.manage;

import cn.tc.ulife.platform.server.authorization.model.EntityModel;
import cn.tc.ulife.platform.server.authorization.model.GroupRootRole;
import cn.tc.ulife.platform.server.authorization.model.ResourceFront;
import cn.tc.ulife.platform.server.authorization.model.SysRoot;

import java.util.List;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.service.manage
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/14 0014
 * </p>
 * Time: 下午 1:51
 * </p>
 * Detail:
 * </p>
 */
public interface SysRootService {


    int insertRoot(SysRoot sysRoot);

    SysRoot selectByPrimaryKey(String id);

    List<GroupRootRole> selectAuthMenuList(String opeid,String uid);

    List<ResourceFront> selectUserLoginAuthMenuList(String uid);


    EntityModel selectEntityModelByCodeAndUid(String uid, String code, String tableName);

    GroupRootRole queryResouceRootByCode(String code);

    EntityModel selectNaturalPersonComm(String uid, String code);

    List<String>  selectGroupRoleByComm(String code, String[] comids);

    List<GroupRootRole> selectAdminAuthMenuList(String userId);

    int deleteUserRootByCodeAndUid(String uid,String rcode);

    String queryEntityResId(String tableName,String id);

    GroupRootRole queryResouceRootById(String id);
}
