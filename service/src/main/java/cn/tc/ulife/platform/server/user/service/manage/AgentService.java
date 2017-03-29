package cn.tc.ulife.platform.server.user.service.manage;

import cn.tc.ulife.platform.server.user.model.AgentEntity;

import java.util.List;
import java.util.Map;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.user.service.manage
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/22 0022
 * </p>
 * Time: 下午 2:05
 * </p>
 * Detail:
 * </p>
 */
public interface AgentService {


    int deleteByPrimaryKey(String id);

    int insertAgent(AgentEntity agentEntity);

    AgentEntity selectAgentByPrimaryKey(String id);

    int updateAgentByPrimaryKey(AgentEntity agentEntity);

    List<AgentEntity> selectAgentList(Integer ofset, Integer psize);

    int selectAgentCount();

    int checkAgentNameUnique(String name, String id);

    void updateEntityRelationAccountStatus(String entityId, String status, String rcode);


}
