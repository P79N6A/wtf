package cn.tc.ulife.platform.server.authorization.service.manage.impl;

import cn.tc.ulife.platform.server.authorization.dao.EntityPLineRelationMapper;
import cn.tc.ulife.platform.server.authorization.model.EntityPLineRelation;
import cn.tc.ulife.platform.server.authorization.service.manage.EntityPLineRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.service.manage.impl
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
@Service("entityPLineRelationService")
public class EntityPLineRelationServiceImpl implements EntityPLineRelationService {

    @Autowired
    EntityPLineRelationMapper entityPLineRelationMapper;

    @Override
    public int insertPLRelation(EntityPLineRelation entityPLineRelation) {
        return entityPLineRelationMapper.insertPLRelation(entityPLineRelation);
    }

    @Override
    public int updatePLRelationByPrimaryKey(EntityPLineRelation entityPLineRelation) {
        return entityPLineRelationMapper.updatePLRelationByPrimaryKey(entityPLineRelation);
    }

    @Override
    public List<EntityPLineRelation> selectPLineRelation(EntityPLineRelation entityPLineRelation) {
        return entityPLineRelationMapper.selectPLineRelation(entityPLineRelation);
    }

    @Override
    public int checkPLisExit(EntityPLineRelation entityPLineRelation) {
        return entityPLineRelationMapper.checkPLisExit(entityPLineRelation);
    }


    @Override
    public void delectPlByKey(EntityPLineRelation entityPLineRelation) {
        entityPLineRelationMapper.delectPlByKey(entityPLineRelation);
    }

    @Override
    public int queryPLRelationExit(String uid) {
        return entityPLineRelationMapper.queryPLRelationExit(uid);
    }

    @Override
    public List<EntityPLineRelation> selectPLineRelationAgent(EntityPLineRelation entityPLineRelation) {

        List<EntityPLineRelation> entityPLineRelations = entityPLineRelationMapper.queryAgentPLRelation(entityPLineRelation);
        List<EntityPLineRelation> storePlRelation = entityPLineRelationMapper.queryStorePlRelation(entityPLineRelation);

        if (CollectionUtils.isEmpty(storePlRelation)) {

            return entityPLineRelations;
        }
        for (EntityPLineRelation entityPLineRelation1 : entityPLineRelations) {

            for (EntityPLineRelation entityPLineRelation2 : storePlRelation) {
                if (entityPLineRelation1.getPid().equals(entityPLineRelation2.getPid())) {
                    entityPLineRelation1.setCid(entityPLineRelation2.getCid());
                    entityPLineRelation1.setId(entityPLineRelation2.getId());
                }
            }
            System.out.println(entityPLineRelation1);
        }

//        for(entityPLineRelation)
        return entityPLineRelations;
    }


}
