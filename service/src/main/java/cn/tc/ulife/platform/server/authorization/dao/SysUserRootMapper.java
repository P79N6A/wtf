package cn.tc.ulife.platform.server.authorization.dao;


import cn.tc.ulife.platform.server.authorization.model.EntityModel;
import cn.tc.ulife.platform.server.authorization.model.UocomEntity;
import cn.tc.ulife.platform.server.authorization.model.UserMenuFront;

import java.util.List;
import java.util.Map;

public interface SysUserRootMapper {

    int deleteByPrimaryKey(String id);

    int insertRoot(UserMenuFront userMenuFront);


    UserMenuFront selectByPrimaryKey(String id);


    int insertEntity(EntityModel entityModel);

    int insertUserEntity(Map<String, String> userEntityMap);

    List<String> selectUocomComidsByKey(UocomEntity uocomEntity);

    List<String> selectUocomOidByKey(UocomEntity uocomEntity);

    List<EntityModel> selectEntityModelByPrimaryKey(Map<String, Object> paramMap);

    int insertUserComEntity(UocomEntity uocomEntity);

    List<EntityModel> selectNaturalPersonByIds(Map<String, String> paramMap);

    int checkUserIsBind(Map<String, String> paramMap);

    void deleteCommRelation(UocomEntity uocomEntity);
}