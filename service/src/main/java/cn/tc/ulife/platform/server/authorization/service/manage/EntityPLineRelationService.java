package cn.tc.ulife.platform.server.authorization.service.manage;

import cn.tc.ulife.platform.server.authorization.model.EntityPLineRelation;

import java.util.List;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.service.manage
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/22 0022
 * </p>
 * Time: 下午 4:56
 * </p>
 * Detail:
 * </p>
 */
public interface EntityPLineRelationService {

    int insertPLRelation(EntityPLineRelation entityPLineRelation);


    int updatePLRelationByPrimaryKey(EntityPLineRelation entityPLineRelation);

    List<EntityPLineRelation> selectPLineRelation(EntityPLineRelation entityPLineRelation);

    int checkPLisExit(EntityPLineRelation entityPLineRelation);


    void delectPlByKey(EntityPLineRelation entityPLineRelation);

    int queryPLRelationExit(String uid);


    List<EntityPLineRelation> selectPLineRelationAgent(EntityPLineRelation entityPLineRelation);

}
