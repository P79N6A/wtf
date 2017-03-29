package cn.tc.ulife.platform.server.user.service.impl;

import cn.tc.ulife.platform.server.shop.service.StoreService;
import cn.tc.ulife.platform.server.user.model.AgentEntity;
import cn.tc.ulife.platform.server.user.model.StoreEntity;
import cn.tc.ulife.platform.server.user.service.EntityService;
import cn.tc.ulife.platform.server.user.service.manage.AgentService;
import cn.tc.ulife.platform.server.user.service.manage.StoreEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.user.service.impl
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/22 0022
 * </p>
 * Time: 下午 2:10
 * </p>
 * Detail:
 * </p>
 */
@Service("entityService")
public class EntityServiceImpl implements EntityService {

    @Autowired
    AgentService agentService;

    @Autowired
    StoreEntityService storeEntityService;

    @Override
    public Map<String, Object> selectAgentList(Integer ofset, Integer psize, String search) {
        List<AgentEntity> agentEntities = agentService.selectAgentList(ofset, psize);
        int totalCount = agentService.selectAgentCount();

        Map<String, Object> retMap = new HashMap<>();
        retMap.put("list", agentEntities);
        retMap.put("totalCount", totalCount);
        return retMap;
    }

    @Override
    public int updateAgentByPrimaryKey(AgentEntity agentEntity) {
        int nameIsExit = agentService.checkAgentNameUnique(agentEntity.getName(), agentEntity.getId());
        if (nameIsExit > 0) {
            return 1;
        }
        agentService.updateAgentByPrimaryKey(agentEntity);
        return 0;
    }

    @Override
    public Map<String, Object> selectStoreList(Integer ofset, Integer psize, String code, String cid) {
        //参数map
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ofset", ofset);
        paramMap.put("psize", psize);
//        paramMap.put("code", code);
        paramMap.put("cid", cid);

        List<StoreEntity> storeEntities = storeEntityService.selectStore(paramMap);
        int totalCount = storeEntityService.selectStoreCount(cid);

        //返回值map
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("list", storeEntities);
        retMap.put("totalCount", totalCount);
        return retMap;
    }

    @Override
    public int updateStoreByPrimaryKey(StoreEntity storeEntity) {

        int nameIsExit = agentService.checkAgentNameUnique(storeEntity.getName(), storeEntity.getId());
        if (nameIsExit > 0) {
            return 1;
        }
        storeEntityService.updateStoreByPrimaryKey(storeEntity);
        return 0;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateAgentStatus(String entityId, String status) {
        //首先修改代理商实体状态
        AgentEntity agentEntity = new AgentEntity();
        agentEntity.setZt(status);
        agentEntity.setId(entityId);
        agentService.updateAgentByPrimaryKey(agentEntity);
        //修改代理商关联账号状态
        agentService.updateEntityRelationAccountStatus(entityId, status, "DLS");

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateStoreStatus(String entityId, String status) {
        //修改商家实体状态
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setZt(status);
        storeEntity.setId(entityId);
        storeEntityService.updateStoreByPrimaryKey(storeEntity);

        //修改商家关联账号状态
        agentService.updateEntityRelationAccountStatus(entityId, status, "SJGLY");
    }
}
