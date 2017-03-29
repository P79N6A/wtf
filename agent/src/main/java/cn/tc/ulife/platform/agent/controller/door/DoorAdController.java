/**
 * @Title: AdvertisementController
 * @Package cn.tc.ulife.platform.agent.controller.door
 * @Description: 门口机广告controller层
 * @author alliswell
 * @date 2017/3/20 14:30
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
import cn.tc.ulife.platform.door.dao.RkeAdLocationDao;
import cn.tc.ulife.platform.door.mode.RkeAdLocationEntity;
import cn.tc.ulife.platform.door.mode.page.RkeAdLocationPage;
import cn.tc.ulife.platform.door.service.RkeAdDataService;
import cn.tc.ulife.platform.door.service.RkeAdLocationService;
import cn.tc.ulife.platform.door.service.RkeAdReleaseService;
import cn.tc.ulife.platform.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author alliswell
 * @Title: AdvertisementController
 * @Package cn.tc.ulife.platform.agent.controller.door
 * @Description: 门口机广告controller层
 * @date 2017/3/20 14:30
 */
@Controller
@RequestMapping("doorAd")
public class DoorAdController {

    @Autowired
    private RkeAdLocationService rkeAdLocationService;

    @Autowired
    private RkeAdDataService rkeAdDataService;

    @Autowired
    private RkeAdReleaseService rkeAdReleaseService;

    /**
     * 新增门口机广告位置
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doAddLocation")
    @ResponseBody
    public ReturnMsg doAddAdLocation(String account, String pageJson) {
        RkeAdLocationPage page = GsonUtil.jsonToObject(pageJson, RkeAdLocationPage.class);
        boolean flag = rkeAdLocationService.saveRkeAdLocation(page);
        if (flag) {
            return AppResponseMsg.success();
        } else {
            return AppResponseMsg.faild();
        }
    }

    /**
     * 删除门口机广告位置
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doDelLocation")
    @ResponseBody
    public ReturnMsg doDelAdLocation(String account, String pageJson) {
        RkeAdLocationPage page = GsonUtil.jsonToObject(pageJson, RkeAdLocationPage.class);
        boolean flag = rkeAdLocationService.delRkeAdLocation(page);
        if (flag) {
            return AppResponseMsg.success();
        } else {
            return AppResponseMsg.faild();
        }
    }

    /**
     * 修改门口机广告位置
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doUpdLocation")
    @ResponseBody
    public ReturnMsg doUpdAdLocation(String account, String pageJson) {
        RkeAdLocationPage page = GsonUtil.jsonToObject(pageJson, RkeAdLocationPage.class);
        boolean flag = rkeAdLocationService.updRkeAdLocation(page);
        if (flag) {
            return AppResponseMsg.success();
        } else {
            return AppResponseMsg.faild();
        }
    }

    /**
     * 查询门口机广告位置
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doShowLocation")
    @ResponseBody
    public ReturnMsg doShowAdLocation(String account, String pageJson) {
        RkeAdLocationPage page = GsonUtil.jsonToObject(pageJson, RkeAdLocationPage.class);
        RkeAdLocationEntity entity = rkeAdLocationService.getRkeAdLocation(page);
        if (entity != null) {
            return AppResponseMsg.success();
        } else {
            return AppResponseMsg.faild();
        }
    }

    /**
     * 查询门口机广告位置列表
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doShowLocationList")
    @ResponseBody
    public ReturnMsg doShowAdLocationList(String account, String pageJson) {
        RkeAdLocationPage page = GsonUtil.jsonToObject(pageJson, RkeAdLocationPage.class);
        String condition = null;
        List list = rkeAdLocationService.listRkeAdLocation(condition);
        if (list != null && list.size() > 0) {
            return AppResponseMsg.success();
        } else {
            return AppResponseMsg.faild();
        }
    }

    /**
     * 新增门口机广告
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doAdd")
    @ResponseBody
    public ReturnMsg doAddAd(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 删除门口机广告
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doDel")
    @ResponseBody
    public ReturnMsg doDelAd(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 修改门口机广告
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doUpd")
    @ResponseBody
    public ReturnMsg doUpdAd(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 查询门口机广告
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doShow")
    @ResponseBody
    public ReturnMsg doShowAd(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 查询门口机广告列表
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doShowList")
    @ResponseBody
    public ReturnMsg doShowAdList(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 新增门口机广告发布
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doAddRelease")
    @ResponseBody
    public ReturnMsg doAddAdRelease(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 删除门口机广告发布
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doDelRelease")
    @ResponseBody
    public ReturnMsg doDelAdRelease(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 修改门口机广告发布
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doUpdRelease")
    @ResponseBody
    public ReturnMsg doUpdAdRelease(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 查询门口机广告发布
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doShowRelease")
    @ResponseBody
    public ReturnMsg doShowAdRelease(String account, String pageJson) {

        return AppResponseMsg.success();
    }

    /**
     * 查询门口机广告列表发布
     * @param account
     * @param pageJson
     * @return
     */
    @RequestMapping("/doShowReleaseList")
    @ResponseBody
    public ReturnMsg doShowAdReleaseList(String account, String pageJson) {

        return AppResponseMsg.success();
    }

}
