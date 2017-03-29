package cn.tc.ulife.platform.server.user.service;

import cn.tc.ulife.platform.server.user.model.AgentEntity;
import cn.tc.ulife.platform.server.user.model.StoreEntity;

import java.util.List;
import java.util.Map;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.user.service
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/22 0022
 * </p>
 * Time: 下午 2:08
 * </p>
 * Detail:
 * </p>
 */
public interface EntityService {

    /**
     * 查询代理商列表
     *
     * @param ofset
     * @param psize
     * @return map: key :list           List
     * key : totalConut    Integer
     */
    Map<String, Object> selectAgentList(Integer ofset, Integer psize, String serach);


    /**
     * 修改代理商信息
     *
     * @param agentEntity
     * @return 1 表示名称已存在 ,其余返回值表示成功
     */
    int updateAgentByPrimaryKey(AgentEntity agentEntity);


    /**
     * 查询商家列表
     *
     * @param ofset
     * @param psize
     * @return map: key :list           List
     * key : totalConut    Integer
     */
    Map<String, Object> selectStoreList(Integer ofset, Integer psize, String rcode, String cid);


    /**
     * 修改商家信息
     *
     * @param storeEntity
     * @return 1 表示名称已存在 ,其余返回值表示成功
     */
    int updateStoreByPrimaryKey(StoreEntity storeEntity);


    void updateAgentStatus(String entityId, String status);

    void updateStoreStatus(String entityId, String status);
}
