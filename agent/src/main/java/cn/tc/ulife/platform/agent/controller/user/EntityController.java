package cn.tc.ulife.platform.agent.controller.user;

import cn.tc.ulife.platform.agent.base.BaseController;
import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.server.user.model.AgentEntity;
import cn.tc.ulife.platform.server.user.model.StoreEntity;
import cn.tc.ulife.platform.server.user.service.EntityService;
import cn.tc.ulife.platform.util.GsonUtil;
import cn.tc.ulife.platform.util.constance.Constance;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisSentinelPool;

import java.util.*;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.agent.controller.authorization
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/22 0022
 * </p>
 * Time: 上午 10:16
 * </p>
 * Detail:  代理商|商家|小站 基础信息,配置 控制类
 * </p>
 */
@RestController
@RequestMapping("/entity")
public class EntityController extends BaseController {

    @Autowired
    EntityService entityService;

    @RequestMapping("/agentList")
    public ReturnMsg queryAgentList(@RequestParam String uid, String search, @RequestParam String ofset, @RequestParam String psize) {
        Map<String, Object> pageMap = checkPage(ofset, psize);
        if (pageMap.get("code").equals(ReturnMsg.RTN_6)) {

            // 分页错误.
            return AppResponseMsg.faild((String) pageMap.get(("msg")));
        }

        //查询列表
        Map<String, Object> retMap = entityService.selectAgentList((Integer) pageMap.get("ofset"), (Integer) pageMap.get("psize"), search);
        if (!CollectionUtils.isEmpty(retMap)) {

            //list表示返回的多条数据,total多少行
            return AppResponseMsg.success(retMap.get("list"), retMap.get("totalCount") + "");

        }

        return AppResponseMsg.success();
    }


    @RequestMapping("/updAgent")
    public ReturnMsg updateAgent(@RequestParam String agent) {
        //转换对象
        AgentEntity agentEntity = GsonUtil.jsonToObject(agent, AgentEntity.class);
        int retCode = entityService.updateAgentByPrimaryKey(agentEntity);
        if (retCode == 1) {
            return AppResponseMsg.faild("名称已存在");
        }

        return AppResponseMsg.success();
    }


    /**
     * 启用/禁用代理商功能
     *
     * @param opeId
     * @param entityId
     * @return
     */
    @RequestMapping("/updAgentStatus")
    public ReturnMsg disableOrEnableAgent(@RequestParam String opeId, @RequestParam String entityId, String status) {
        entityService.updateAgentStatus(entityId, status);

        return AppResponseMsg.success("成功");
    }


    @RequestMapping("queryStoreList")
    public ReturnMsg queryStoreList(@RequestParam String cid, @RequestParam String ofset, @RequestParam String psize) {
        Map<String, Object> pageMap = checkPage(ofset, psize);
        if (pageMap.get("code").equals(ReturnMsg.RTN_6)) {

            // 分页错误.
            return AppResponseMsg.faild((String) pageMap.get(("msg")));
        }
        //查询列表
        Map<String, Object> retMap = entityService.selectStoreList((Integer) pageMap.get("ofset")
                , (Integer) pageMap.get("psize"), null, cid);
        if (!CollectionUtils.isEmpty(retMap)) {
            //list表示返回的多条数据,total多少行
            return AppResponseMsg.success(retMap.get("list"), retMap.get("totalCount") + "");

        }

        return AppResponseMsg.success();
    }


    @RequestMapping("/updStore")
    public ReturnMsg updStore(@RequestParam String store) {
        //转换对象
        StoreEntity storeEntity = GsonUtil.jsonToObject(store, StoreEntity.class);
        int retCode = entityService.updateStoreByPrimaryKey(storeEntity);
        if (retCode == 1) {
            return AppResponseMsg.faild("名称已存在");
        }

        return AppResponseMsg.success();
    }


    @RequestMapping("/updStoreStatus")
    public ReturnMsg disableOrEnableStoreStatus(String opeId, String storeId, String status) {
        entityService.updateStoreStatus(storeId, status);

        return AppResponseMsg.success("成功");
    }

    public static void main(String[] args) {
        AgentEntity agentEntity = new AgentEntity();
        agentEntity.setAddress("地址");
        agentEntity.setName("名称");
        //
        agentEntity.setAppintype("APP首页类型 0新版;1o2o版");
        agentEntity.setAppnatype("APP导航类型 1个;2个;3个");
        agentEntity.setSkzh("收款账号");
        agentEntity.setTel("电话号码");

        agentEntity.setId("你选择了哪个代理就用哪个代理商的id");

        System.out.println(GsonUtil.objectToJson(agentEntity));
    }


}
