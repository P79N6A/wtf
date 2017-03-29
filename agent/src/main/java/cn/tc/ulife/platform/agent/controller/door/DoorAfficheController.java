/**
 * @Title: AfficheController
 * @Package cn.tc.ulife.platform.agent.controller.door
 * @Description: 门口机公告controller层
 * @author alliswell
 * @date 2017/3/20 14:27
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.tc.ulife.platform.agent.controller.door;

import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author alliswell
 * @Title: AfficheController
 * @Package cn.tc.ulife.platform.agent.controller.door
 * @Description: 门口机公告controller层
 * @date 2017/3/20 14:27
 */
@Controller
@RequestMapping("doorAffiche")
public class DoorAfficheController {

    /**
     * 新增门口机公告类型
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doAddType")
    @ResponseBody
    public ReturnMsg doAddAfficheType(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 删除门口机公告类型
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doDelType")
    @ResponseBody
    public ReturnMsg doDelAfficheType(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 修改门口机公告类型
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doUpdType")
    @ResponseBody
    public ReturnMsg doUpdAfficheType(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 查询门口机公告类型
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doShowType")
    @ResponseBody
    public ReturnMsg doShowAfficheType(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 查询门口机公告类型列表
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doShowTypeList")
    @ResponseBody
    public ReturnMsg doShowAfficheTypeList(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 新增门口机公告
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doAdd")
    @ResponseBody
    public ReturnMsg doAddAffiche(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 删除门口机公告
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doDel")
    @ResponseBody
    public ReturnMsg doDelAffiche(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 修改门口机公告
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doUpd")
    @ResponseBody
    public ReturnMsg doUpdAffiche(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 查询门口机公告
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doShow")
    @ResponseBody
    public ReturnMsg doShowAffiche(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 查询门口机公告列表
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doShowList")
    @ResponseBody
    public ReturnMsg doShowAfficheList(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 新增门口机公告发布
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doAddRelease")
    @ResponseBody
    public ReturnMsg doAddAfficheRelease(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 删除门口机公告发布
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doDelRelease")
    @ResponseBody
    public ReturnMsg doDelAfficheRelease(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 修改门口机公告发布
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doUpdRelease")
    @ResponseBody
    public ReturnMsg doUpdAfficheRelease(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 查询门口机公告发布
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doShowRelease")
    @ResponseBody
    public ReturnMsg doShowAfficheRelease(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 查询门口机公告列表发布
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doShowReleaseList")
    @ResponseBody
    public ReturnMsg doShowAfficheReleaseList(String account, String pageJson) {

        return AppResponseMsg.success();
    }
}
