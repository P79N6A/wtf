package cn.tc.ulife.platform.server.user.service.manage.impl;

import cn.tc.ulife.platform.server.user.dao.AgentEntityMapper;
import cn.tc.ulife.platform.server.user.model.AgentEntity;
import cn.tc.ulife.platform.server.user.service.manage.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.user.service.manage.impl
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/22 0022
 * </p>
 * Time: 下午 2:06
 * </p>
 * Detail:
 * </p>
 */
@Service("agentServiceImpl")
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentEntityMapper agentEntityMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return agentEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertAgent(AgentEntity agentEntity) {
        return agentEntityMapper.insertAgent(agentEntity);
    }

    @Override
    public AgentEntity selectAgentByPrimaryKey(String id) {
        return agentEntityMapper.selectAgentByPrimaryKey(id);
    }

    @Override
    public int updateAgentByPrimaryKey(AgentEntity agentEntity) {
        return agentEntityMapper.updateAgentByPrimaryKey(agentEntity);
    }

    @Override
    public List<AgentEntity> selectAgentList(Integer ofset, Integer psize) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ofset", ofset);
        paramMap.put("psize", psize);
        return agentEntityMapper.selectAgentList(paramMap);
    }

    @Override
    public int selectAgentCount() {
        return agentEntityMapper.selectAgentCount();
    }

    @Override
    public int checkAgentNameUnique(String name, String id) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("name", name);
        return agentEntityMapper.checkAgentNameUnique(paramMap);
    }


    @Override
    public void updateEntityRelationAccountStatus(String entityId, String status, String rcode) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("entityId", entityId);
        paramMap.put("status", status);
        paramMap.put("rcode", rcode);
        agentEntityMapper.updateEntityRelationAccountStatus(paramMap);
    }
}
