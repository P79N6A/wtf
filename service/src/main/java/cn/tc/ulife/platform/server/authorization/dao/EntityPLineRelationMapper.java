package cn.tc.ulife.platform.server.authorization.dao;


import cn.tc.ulife.platform.server.authorization.model.EntityPLineRelation;

import java.util.List;

public interface EntityPLineRelationMapper {

    int insertPLRelation(EntityPLineRelation entityPLineRelation);


    int updatePLRelationByPrimaryKey(EntityPLineRelation entityPLineRelation);

    List<EntityPLineRelation> selectPLineRelation(EntityPLineRelation entityPLineRelation);

    int checkPLisExit(EntityPLineRelation entityPLineRelation);

    void delectPlByKey(EntityPLineRelation entityPLineRelation);

    int queryPLRelationExit(String uid);

    List<EntityPLineRelation> queryAgentPLRelation(EntityPLineRelation entityPLineRelation);

    List<EntityPLineRelation> queryStorePlRelation(EntityPLineRelation entityPLineRelation);
}