package cn.tc.ulife.platform.server.authorization.service.manage;

import cn.tc.ulife.platform.server.authorization.model.EntityModel;
import cn.tc.ulife.platform.server.authorization.model.UocomEntity;
import cn.tc.ulife.platform.server.authorization.model.UserMenuFront;

import java.util.List;
import java.util.Map;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.service.manage
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/14 0014
 * </p>
 * Time: 上午 10:00
 * </p>
 * Detail:
 * </p>
 */
public interface SysUserRootService {

    int deleteByPrimaryKey(String id);

    int insertRoot(UserMenuFront userMenuFront);


    UserMenuFront selectByPrimaryKey(String id);

    int insertEntity(EntityModel entityModel);

    int insertUserEntity(Map<String, String> userEntityMap);

    List<String> selectUocomComidsByKey(UocomEntity uocomEntity);

    List<String> selectUocomOidByKey(UocomEntity uocomEntity);

    List<EntityModel> selectEntityModelByPrimaryKey(Map<String, Object> paramMap);

    int insertUserComEntity(UocomEntity uocomEntity);


    List<EntityModel> selectNaturalPersonByIds(String code, String cid);


    int checkUserIsBind(String uid,String tableName,String rcode);

    void deleteCommRelation(UocomEntity uocomEntity);
}
