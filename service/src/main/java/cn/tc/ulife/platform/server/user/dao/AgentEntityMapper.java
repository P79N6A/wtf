package cn.tc.ulife.platform.server.user.dao;


import cn.tc.ulife.platform.server.user.model.AgentEntity;

import java.util.List;
import java.util.Map;

public interface AgentEntityMapper {
    int deleteByPrimaryKey(String id);

    int insertAgent(AgentEntity agentEntity);

    AgentEntity selectAgentByPrimaryKey(String id);

    int updateAgentByPrimaryKey(AgentEntity agentEntity);

    List<AgentEntity> selectAgentList(Map<String, Object> paramMap);

    int selectAgentCount();

    int checkAgentNameUnique(Map<String, String> paramMap);

    void updateEntityRelationAccountStatus(Map<String, String> paramMap);
}