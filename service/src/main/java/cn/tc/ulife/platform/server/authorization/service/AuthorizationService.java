package cn.tc.ulife.platform.server.authorization.service;

import cn.tc.ulife.platform.server.authorization.model.*;
import cn.tc.ulife.platform.server.user.model.BaseUser;
import cn.tc.ulife.platform.server.user.model.UserFront;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.service
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/13 0013
 * </p>
 * Time: 上午 10:27
 * </p>
 * Detail:
 * </p>
 */
public interface AuthorizationService {


    int bindCommunity(String uid, String[] comIds, String rcode);


    int bindMenuAndResource(String uid, String opId, List<UserMenuFront> userMenuFronts);

    List<GroupRootRole> selectAuthMenuList(String opeid,String uid);

    int bindMenuAndResource(String uid, String opId, List<UserMenuFront> userMenuFronts, EntityModel entityModel);


    List<EntityModel> queryEntityList(UocomEntity opeUocomEntity, UocomEntity useUocomEntity);


    List<EntityModel> queryEntityList(String opeUid, String opeCode, String code);

    int bindEntityComm(String entityId, String[] comIds, String rcode, String opeId);

    int configEntityComm(String entityId, String[] comIds, String rcode, String opeId, Boolean check);

    UserFront getLoginAttr(UserFront userFront);

    int bindProductLine(String cid, List<EntityPLineRelation> pLineRelations, String rcode, Boolean flag);

    List<EntityPLineRelation> selectPLineRelation(EntityPLineRelation entityPLineRelation);

    List<GroupRootRole> selectAdminAuthMenuList(String opeId, String userId);

    int bindMenuAndResource(String uid, String opId, List<UserMenuFront> userMenuFronts, EntityModel entityModel, Boolean add);


    List<AuthCommModel> queryAuthCommList(String entityId, String rcode, String areaId);


    List<AuthCommModel> queryStoreAuthCommList(String entityId, String rcode, String areaId);

    List<EntityPLineRelation> selectPLineRelationAgent(EntityPLineRelation entityPLineRelation);

}

