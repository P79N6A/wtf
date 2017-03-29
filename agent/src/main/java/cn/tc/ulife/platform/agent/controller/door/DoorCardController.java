/**
 * @Title: DoorCardController
 * @Package cn.tc.ulife.platform.agent.controller.door
 * @Description: 用户门卡controller层
 * @author alliswell
 * @date 2017/3/14 10:09
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.tc.ulife.platform.agent.controller.door;

import cn.tc.ulife.platform.agent.base.BaseController;
import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.door.manager.HardWareService;
import cn.tc.ulife.platform.door.mode.DoorCardEntity;
import cn.tc.ulife.platform.door.mode.DoorCardPage;
import cn.tc.ulife.platform.door.mode.RKE_EquipmentBean;
import cn.tc.ulife.platform.door.service.DoorCardService;
import cn.tc.ulife.platform.door.service.DoorService;
import cn.tc.ulife.platform.util.constance.Constance;
import cn.tc.ulife.platform.validators.Validate;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alliswell
 * @Title: DoorCardController
 * @Package cn.tc.ulife.platform.agent.controller.door
 * @Description: 用户门卡controller层
 * @date 2017/3/14 10:09
 */
@Controller
@RequestMapping("doorCard")
public class DoorCardController extends BaseController {

    @Autowired
    DoorCardService doorCardService;

    @Autowired
    DoorService doorService;

    /**
     * 新增门卡
     * @param page
     * @return
     */
    @RequestMapping("/doAdd")
    @ResponseBody
    public ReturnMsg doAdd(@Validate(isForm = true) DoorCardPage page) {
        // 判断住户是否已与该门卡绑定
        boolean isCard = doorCardService.checkDoorCard(page);
        if (isCard) {
            return AppResponseMsg.faild("新增失败,设备住户已存在该门卡");
        }

        page.setAccountSid(Constance.HARDWARE_CLOUD_APPID);

        boolean flag = doorCardService.saveRkeCard(page);

        if (flag) {
            // 通过住户ID 查询门口机列表
            Map<String, String> map = new HashMap<String, String>();
            map.put("EQ_CommunityID", page.getCommId());
            map.put("EQ_CS_ID", page.getIds());
            List<RKE_EquipmentBean> rkes = doorService.queryRKeEquipment(map);
            // 同步用户门卡到门口机
            JSONObject data = new JSONObject();
            // 推送数据的操作类型
            data.put("opt", "add");
            data.put("data", new JSONObject(page));
            for (RKE_EquipmentBean rke : rkes) {
                // 循环推送到门口机 走线程池操作 无需返回结果
                HardWareService.sendHardService(Constance.HARDWARE_SendDeviceInfo_NOBack + rke.getEQ_Num(), data.toString());
            }

            return AppResponseMsg.success("新增门卡成功");
        } else {
            return AppResponseMsg.faild();
        }
    }

    /**
     * 删除门卡
     * @param page
     * @return
     */
    @RequestMapping("/doDel")
    @ResponseBody
    public ReturnMsg doDel(DoorCardPage page) {
        boolean flag = false;
        if (StringUtils.isNotEmpty(page.getCdautoId())) {
            flag = doorCardService.delRkeCard(page);
        }

        if (flag) {
            // 通过住户ID 查询门口机列表
            Map<String, String> map = new HashMap<String, String>();
            map.put("EQ_CommunityID", page.getCommId());
            map.put("EQ_CS_ID", page.getIds());
            List<RKE_EquipmentBean> rkes = doorService.queryRKeEquipment(map);
            // 同步用户门卡到门口机
            JSONObject data = new JSONObject();
            data.put("opt", "del");
            data.put("data", new JSONObject(page));
            for (RKE_EquipmentBean rke : rkes) {
                // 循环推送到门口机 走线程池操作 无需返回结果
                HardWareService.sendHardService(Constance.HARDWARE_SendDeviceInfo_NOBack + rke.getEQ_Num(), data.toString());
            }

            return AppResponseMsg.success("删除门卡成功");
        } else {
            return AppResponseMsg.faild();
        }
    }

    /**
     * 修改门卡
     * @param page
     * @return
     */
    @RequestMapping("/doUpd")
    @ResponseBody
    public ReturnMsg doUpd(DoorCardPage page) {
        boolean flag = false;
        if (StringUtils.isNotEmpty(page.getCdautoId())) {
            flag = doorCardService.updRkeCard(page);
        }

        doorCardService.countRkeCard("CD_CardLevel = '1'");

        if (flag) {
            // 通过住户ID 查询门口机列表
            Map<String, String> map = new HashMap<String, String>();
            map.put("EQ_CommunityID", page.getCommId());
            map.put("EQ_CS_ID", page.getIds());
            List<RKE_EquipmentBean> rkes = doorService.queryRKeEquipment(map);
            // 同步用户门卡到门口机
            JSONObject data = new JSONObject();
            data.put("opt", "upd");
            data.put("data", new JSONObject(page));
            for (RKE_EquipmentBean rke : rkes) {
                // 循环推送到门口机 走线程池操作 无需返回结果
                HardWareService.sendHardService(Constance.HARDWARE_SendDeviceInfo_NOBack + rke.getEQ_Num(), data.toString());
            }

            return AppResponseMsg.success("修改门卡成功");
        } else {
            return AppResponseMsg.faild();
        }
    }

    /**
     * 查询门卡
     * @param page
     * @return
     */
    @RequestMapping("/doShow")
    @ResponseBody
    public ReturnMsg doShow(DoorCardPage page) {

        DoorCardEntity entity = doorCardService.getRkeCard(page);

        if (entity != null) {
            return AppResponseMsg.success("查询门卡成功", entity);
        } else {
            return AppResponseMsg.faild();
        }
    }

    /**
     * 查询门卡列表
     * @param page
     * @return
     */
    @RequestMapping("/doShowList")
    @ResponseBody
    public ReturnMsg doShowList(DoorCardPage page) {
        Map<String, Object> map = checkPage(page.getPageNum(), page.getPageSize());

        if (ReturnMsg.SUCCESSS.equals(map.get("code"))) {
            StringBuffer sb = new StringBuffer();
            sb.append("1=1 ").append("limit ").append(map.get("ofset")).append(", ").append(map.get("psize"));

            String condition = sb.toString();
            List list = doorCardService.listRkeCard(condition);
            String count = doorCardService.countRkeCard(condition).toString();

            if (list != null && list.size() > 0) {
                return AppResponseMsg.success("查询门卡成功", list, count);
            } else {
                return AppResponseMsg.faild();
            }
        } else {
            return AppResponseMsg.faild(map.get("msg").toString());
        }
    }
}


