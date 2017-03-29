/**
 * @Title: ShopController
 * @Package cn.tc.ulife.platform.agent.controller.shop
 * @Description: 商城模块controller层
 * @author cxs
 * @date 2017/2/17 15:35
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.agent.controller.shop;

import cn.tc.ulife.platform.agent.base.BaseController;
import cn.tc.ulife.platform.agent.componet.SystemLog;
import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.server.authorization.model.EntityModel;
import cn.tc.ulife.platform.server.shop.entity.ProductLineEntity;
import cn.tc.ulife.platform.server.shop.entity.ScAgentEntity;
import cn.tc.ulife.platform.server.shop.entity.ScStoreEntity;
import cn.tc.ulife.platform.server.shop.page.*;
import cn.tc.ulife.platform.server.shop.service.ProductLineService;
import cn.tc.ulife.platform.server.shop.service.WareService;
import cn.tc.ulife.platform.server.shop.service.WareSortService;
import cn.tc.ulife.platform.server.user.service.UserCacheService;
import cn.tc.ulife.platform.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author cxs
 * @ClassName: ShopController
 * @Description: 商城模块controller层
 * @date 2017/2/17 15:35
 */
@Controller
@RequestMapping("/shop")
public class ShopController extends BaseController {

    @Autowired
    private WareService wareService;

    @Autowired
    private WareSortService wareSortService;

    @Autowired
    private ProductLineService productLineService;


    // TODO 管理员操作

    /**
     * 查询管理员的商品列表
     *
     * @param account 用户账号
     * @param app     app类型
     * @param spxz    商品性质，0：生鲜，1：拼团，2：服务，3：充值，4：宅配，5：积分
     * @param ofset   页数
     * @param psize   条数
     * @return
     */
    @RequestMapping(value = {"/getAdminWareList"})
    @ResponseBody
    @SystemLog(description = "查询管理员的商品列表")
    public ReturnMsg getAdminWareList(String account, String app, String spxz, WarePage page, String ofset, String psize) {
        Map<String, Object> pageMap = checkPage(ofset, psize);
        List list = wareService.queryAll(account, app, "0", spxz, page, (Integer) pageMap.get("ofset"), (Integer) pageMap.get("psize"));
        String count = wareService.countWare(account, "0", spxz, page);
        return AppResponseMsg.success(list, count);
    }

    /**
     * 查询管理员的所有商家
     *
     * @param account 用户账号
     * @param app     app类型
     * @param sjxz    商家性质，0：生鲜，1：拼团，2：服务，3：充值，4：宅配，5：积分
     * @param ofset   页数
     * @param psize   条数
     * @return
     */
    @RequestMapping(value = {"/getAdminStoreList"})
    @ResponseBody
    @SystemLog(description = "查询管理员的所有商家")
    public ReturnMsg getAdminStoreList(String account, String app, String sjxz, String ofset, String psize) {
        Map<String, Object> pageMap = checkPage(ofset, psize);
        List list = wareService.listStore(account, app, "0", sjxz, (Integer) pageMap.get("ofset"), (Integer) pageMap.get("psize"));
        String count = wareService.countStore(account, "0", sjxz);
        return AppResponseMsg.success(list, count);
    }

    /**
     * 管理员添加商品分类
     *
     * @param account
     * @param app
     * @param pageJson
     * @return
     */
    @RequestMapping("/addWareSort")
    @ResponseBody
    @SystemLog(description = "管理员添加商品分类")
    public ReturnMsg addWareSort(String account, String app, String pageJson) {
        WareSortPage page = GsonUtil.jsonToObject(pageJson, WareSortPage.class);
        boolean flag = wareSortService.addWareSortInfo(account, app, page);
        if (flag) {
            return AppResponseMsg.success("新增商品分类成功");
        } else {
            return AppResponseMsg.faild("新增商品分类失败");
        }
    }

    /**
     * 管理员删除商品分类
     *
     * @param account
     * @param app
     * @param page
     * @return
     */
    @RequestMapping("/delWareSort")
    @ResponseBody
    @SystemLog(description = "管理员删除商品分类")
    public ReturnMsg delWareSort(String account, String app, WareSortPage page) {
        boolean flag = wareSortService.delWareSortInfo(account, app, page.getId());
        if (flag) {
            return AppResponseMsg.success("删除商品分类成功");
        } else {
            return AppResponseMsg.faild("删除商品分类失败");
        }
    }

    /**
     * 管理员修改商品分类
     *
     * @param account
     * @param app
     * @param pageJson
     * @return
     */
    @RequestMapping("/updWareSort")
    @ResponseBody
    @SystemLog(description = "管理员修改商品分类")
    public ReturnMsg updWareSort(String account, String app, String pageJson) {
        WareSortPage page = GsonUtil.jsonToObject(pageJson, WareSortPage.class);
        boolean flag = wareSortService.updWareSortInfo(account, app, page);
        if (flag) {
            return AppResponseMsg.success("修改商品分类成功");
        } else {
            return AppResponseMsg.faild("修改商品分类失败");
        }
    }

    /**
     * 查询管理员的商品分类列表
     *
     * @param account
     * @param app
     * @param page
     * @param ofset
     * @param psize
     * @return
     */
    @RequestMapping("/getAdminWareSortList")
    @ResponseBody
    @SystemLog(description = "查询管理员的商品分类列表")
    public ReturnMsg getAdminWareSortList(String account, String app, WareSortPage page, String ofset, String psize) {
        Map<String, Object> pageMap = checkPage(ofset, psize);
        List list = wareSortService.queryAll(account, app, page.getPid(), (Integer) pageMap.get("ofset"), (Integer) pageMap.get("psize"));
        String count = wareSortService.getWareSortTotal(page.getPid());
        return AppResponseMsg.success(list, count);
    }

    /**
     * 管理员新增产品线
     *
     * @param account
     * @param app
     * @param pageJson
     * @return
     */
    @RequestMapping("/addProductLine")
    @ResponseBody
    @SystemLog(description = "管理员新增产品线")
    public ReturnMsg addProductLine(String account, String app, String pageJson) {
        ProductLinePage page = GsonUtil.jsonToObject(pageJson, ProductLinePage.class);
        boolean flag = productLineService.addProductLineInfo(account, app, page);
        if (flag) {
            return AppResponseMsg.success("新增产品线成功");
        } else {
            return AppResponseMsg.faild("新增产品线失败");
        }
    }

    /**
     * 管理员删除产品线
     *
     * @param account
     * @param app
     * @param pageJson
     * @return
     */
    @RequestMapping("/delProductLine")
    @ResponseBody
    @SystemLog(description = "管理员删除产品线")
    public ReturnMsg delProductLine(String account, String app, String pageJson) {
        ProductLinePage page = GsonUtil.jsonToObject(pageJson, ProductLinePage.class);
        boolean flag = productLineService.delProductLineInfo(account, app, page.getId());
        if (flag) {
            return AppResponseMsg.success("删除产品线成功");
        } else {
            return AppResponseMsg.faild("删除产品线失败");
        }
    }

    /**
     * 管理员修改产品线
     *
     * @param account
     * @param app
     * @param pageJson
     * @return
     */
    @RequestMapping("/updProductLine")
    @ResponseBody
    @SystemLog(description = "管理员修改产品线")
    public ReturnMsg updProductLine(String account, String app, String pageJson) {
        ProductLinePage page = GsonUtil.jsonToObject(pageJson, ProductLinePage.class);
        boolean flag = productLineService.updProductLineInfo(account, app, page);
        if (flag) {
            return AppResponseMsg.success("修改产品线成功");
        } else {
            return AppResponseMsg.faild("修改产品线失败");
        }
    }

    /**
     * 查询管理员产品线列表
     *
     * @param account
     * @param app
     * @param page
     * @param ofset
     * @param psize
     * @return
     */
    @RequestMapping("/getProductLineList")
    @ResponseBody
    @SystemLog(description = "查询管理员产品线列表")
    public ReturnMsg getProductLineList(String account, String app, ProductLinePage page, String ofset, String psize) {
        Map<String, Object> pageMap = checkPage(ofset, psize);
        List list = productLineService.queryAll(account, app, page.getName(), (Integer) pageMap.get("ofset"), (Integer) pageMap.get("psize"));
        return AppResponseMsg.success(list, productLineService.getProductLineTotal());
    }

    /**
     * 管理员绑定产品线与商品分类
     *
     * @param account
     * @param app
     * @param plid
     * @param flid
     * @return
     */
    @RequestMapping("/bindPLineWSort")
    @ResponseBody
    @SystemLog(description = "管理员绑定产品线与商品分类")
    public ReturnMsg bindPLineWSort(String account, String app, String plid, String flid) {
        boolean flag = productLineService.addPLineWSort(account, app, plid, flid);
        if (flag) {
            return AppResponseMsg.success("绑定产品线和商品分类成功");
        } else {
            return AppResponseMsg.faild("绑定产品线和商品分类失败");
        }
    }

    /**
     * 管理员下发产品线给代理商
     *
     * @param account
     * @param app
     * @param plid
     * @param uid
     * @return
     */
    @RequestMapping("/bindAdminPLineUser")
    @ResponseBody
    @SystemLog(description = "管理员下发产品线给代理商")
    public ReturnMsg bindAdminPLineUser(String account, String app, String plid, String uid) {
        boolean flag = productLineService.addPLineUser(account, app, plid, uid);
        if (flag) {
            return AppResponseMsg.success("管理员下发产品线给代理商成功");
        } else {
            return AppResponseMsg.faild("管理员下发产品线给代理商失败");
        }
    }

    /**
     * 管理员审核商品
     *
     * @param account
     * @param app
     * @param spid    商品id
     * @return
     */
    @RequestMapping("/auditAdminWare")
    @ResponseBody
    @SystemLog(description = "管理员审核商品")
    public ReturnMsg auditAdminWare(String account, String app, String spid) {
        boolean flag = wareService.auditWare(account, app, spid);
        if (flag) {
            return AppResponseMsg.success("审核商品成功");
        } else {
            return AppResponseMsg.faild("审核商品失败");
        }
    }

    /**
     * 管理员调取充值平台接口刷新充值商品
     *
     * @param uid
     * @return
     */
    @RequestMapping("/syncRecharge")
    @ResponseBody
    @SystemLog(description = "管理员调取充值平台接口刷新充值商品")
    public ReturnMsg loadRecharge(String uid) {
        boolean flag = wareService.syncRecharge(uid);
        if (flag) {
            return AppResponseMsg.success("同步数据成功");
        } else {
            return AppResponseMsg.faild("同步数据失败");
        }
    }

    /**
     * 管理员查询充值商品列表
     *
     * @param uid
     * @return
     */
    @RequestMapping("/getRechargeList")
    @ResponseBody
    @SystemLog(description = "管理员查询充值商品列表")
    public ReturnMsg getRechargeList(String uid, String recsprice, String ofset, String psize) {
        Map<String, Object> pageMap = checkPage(ofset, psize);
        List list = wareService.listRecharge(uid, recsprice, (Integer) pageMap.get("ofset"), (Integer) pageMap.get("psize"));
        String count = wareService.countRecharge(recsprice);
        return AppResponseMsg.success(list, count);
    }

    /**
     * 管理员设置充值商品浮动值
     *
     * @param uid
     * @param floatValue
     * @return
     */
    @RequestMapping("/updRechargeFloat")
    @ResponseBody
    @SystemLog(description = "管理员设置充值商品浮动值")
    public ReturnMsg updRechargeFloat(String uid, String floatValue) {
        boolean flag = wareService.saveRechargeFloat(uid, floatValue);
        if (flag) {
            return AppResponseMsg.success("设置充值商品浮动值成功");
        } else {
            return AppResponseMsg.faild("设置充值商品浮动值失败");
        }
    }

    // TODO 代理商操作

    /**
     * 查询代理商的商品列表
     *
     * @param account 用户账号
     * @param app     app类型
     * @param spxz    商品性质，0：生鲜，1：拼团，2：服务，3：充值，4：宅配，5：积分
     * @param ofset   页数
     * @param psize   条数
     * @return
     */
    @RequestMapping(value = {"/getAgentWareList"})
    @ResponseBody
    @SystemLog(description = "查询代理商的商品列表")
    public ReturnMsg getAgentWareList(String account, String app, String spxz, WarePage page, String ofset, String psize) {
        Map<String, Object> pageMap = checkPage(ofset, psize);
        List list = wareService.queryAll(account, app, "1", spxz, page, (Integer) pageMap.get("ofset"), (Integer) pageMap.get("psize"));
        String count = wareService.countWare(account, "1", spxz, page);
        return AppResponseMsg.success(list, count);
    }

    /**
     * 查询代理商的所有商家
     *
     * @param account 用户账号
     * @param app     app类型
     * @param sjxz    商家性质，0：生鲜，1：拼团，2：服务，3：充值，4：宅配，5：积分
     * @param ofset   页数
     * @param psize   条数
     * @return
     */
    @RequestMapping(value = {"/getAgentStoreList"})
    @ResponseBody
    @SystemLog(description = "查询代理商的所有商家")
    public ReturnMsg getAgentStoreList(String account, String app, String sjxz, String ofset, String psize) {
        Map<String, Object> pageMap = checkPage(ofset, psize);
        List list = wareService.listStore(account, app, "1", sjxz, (Integer) pageMap.get("ofset"), (Integer) pageMap.get("psize"));
        String count = wareService.countStore(account, "1", sjxz);
        return AppResponseMsg.success(list, count);
    }

    /**
     * 查询代理商的商品分类列表
     *
     * @param account
     * @param app
     * @param page
     * @param ofset
     * @param psize
     * @return
     */
    @RequestMapping("/getStoreWareSortList")
    @ResponseBody
    @SystemLog(description = "查询代理商的商品分类列表")
    public ReturnMsg getStoreWareSortList(String account, String app, WareSortPage page, String ofset, String psize) {
        Map<String, Object> pageMap = checkPage(ofset, psize);
        List list = wareSortService.queryAll(account, app, page.getPid(), (Integer) pageMap.get("ofset"), (Integer) pageMap.get("psize"));
        String count = wareSortService.getWareSortTotal(page.getPid());
        return AppResponseMsg.success(list, count);
    }

    /**
     * 代理商下发产品线给商家
     *
     * @param account
     * @param app
     * @param plid
     * @param uid
     * @return
     */
    @RequestMapping("/bindAgentPLineUser")
    @ResponseBody
    @SystemLog(description = "代理商下发产品线给商家")
    public ReturnMsg bindAgentPLineUser(String account, String app, String plid, String uid) {
        boolean flag = productLineService.addPLineUser(account, app, plid, uid);
        if (flag) {
            return AppResponseMsg.success("代理商下发产品线给商家成功");
        } else {
            return AppResponseMsg.faild("代理商下发产品线给商家失败");
        }
    }

    /**
     * 代理商审核商品
     *
     * @param account
     * @param app
     * @param spid    商品id
     * @return
     */
    @RequestMapping("/auditAgentWare")
    @ResponseBody
    @SystemLog(description = "代理商审核商品")
    public ReturnMsg auditAgentWare(String account, String app, String spid) {
        boolean flag = wareService.auditWare(account, app, spid);
        if (flag) {
            return AppResponseMsg.success("审核商品成功");
        } else {
            return AppResponseMsg.faild("审核商品失败");
        }
    }

    @RequestMapping("/addIntegralWare")
    @ResponseBody
    public ReturnMsg addIntegralWare(String account, String app, String pageJson) {
        // 根据用户id获取代理商id
        ScAgentEntity agentEntity = wareService.getAgentIdByUid(account);
        String agentId = agentEntity.getId();

        WarePage page = GsonUtil.jsonToObject(pageJson, IntegralWarePage.class);
        page.setStoreid(agentId);
        page.setIsst("5");
        boolean flag = wareService.addWareInfo(account, app, page);
        if (flag) {
            return AppResponseMsg.success("新增商品成功");
        } else {
            return AppResponseMsg.faild("新增商品失败");
        }
    }

    @RequestMapping("/delIntegralWare")
    @ResponseBody
    public ReturnMsg delIntegralWare(String account, String app, String spid) {
        boolean flag = wareService.delWareInfo(account, app, spid);
        if (flag) {
            return AppResponseMsg.success("删除商品成功");
        } else {
            return AppResponseMsg.faild("删除商品失败");
        }
    }

    @RequestMapping("/updIntegralWare")
    @ResponseBody
    @SystemLog(description = "商家修改商品")
    public ReturnMsg updIntegralWare(String account, String app, String pageJson) {
        WarePage page = GsonUtil.jsonToObject(pageJson, IntegralWarePage.class);
        boolean flag = wareService.updWareInfo(account, app, page);
        if (flag) {
            return AppResponseMsg.success("修改商品成功");
        } else {
            return AppResponseMsg.faild("修改商品失败");
        }
    }

    @RequestMapping(value = {"/getIntegralWareList"})
    @ResponseBody
    @SystemLog(description = "查询代理商的积分商品列表")
    public ReturnMsg getIntegralWareList(String account, String app, String spxz, WarePage page, String ofset, String psize) {
        // 根据用户id获取代理商id
        ScAgentEntity agentEntity = wareService.getAgentIdByUid(account);
        String agentId = agentEntity.getId();

        Map pageMap = checkPage(ofset, psize);
        List list = wareService.queryAll(agentId, app, "2", spxz, page, (Integer) pageMap.get("ofset"), (Integer) pageMap.get("psize"));
        String count = wareService.countWare(agentId, "2", spxz, page);
        return AppResponseMsg.success(list, count);
    }

    @RequestMapping("/addIntegralWareSort")
    @ResponseBody
    public ReturnMsg addIntegralWareSort(String account, IntegralWareSortPage page) {
        page.setCid(account);
        page.setZt("2");
        boolean flag = wareSortService.addIntegralWareSort(page);

        if (flag) {
            return AppResponseMsg.success("新增商品分类成功");
        } else {
            return AppResponseMsg.faild("新增商品分类失败");
        }
    }

    @RequestMapping("/updIntegralWareSort")
    @ResponseBody
    public ReturnMsg updIntegralWareSort(String account, IntegralWareSortPage page) {
        boolean flag = wareSortService.updIntegralWareSort(page);

        if (flag) {
            return AppResponseMsg.success("修改商品分类成功");
        } else {
            return AppResponseMsg.faild("修改商品分类失败");
        }
    }

    @RequestMapping("/getIntegralWareSortList")
    @ResponseBody
    public ReturnMsg getIntegralWareSortList(String account, IntegralWareSortPage page) {
        page.setCid(account);
        List list = wareSortService.getIntegralWareSortList(page);
        String count = wareSortService.getIntegralWareSortCount(page);
        return AppResponseMsg.success(list, count);
    }

    @RequestMapping("/getIntegralRecordList")
    @ResponseBody
    public ReturnMsg getIntegralRecordList(String account, IntegralWarePage page) {

        return null;
    }

    // TODO 商家操作

    /**
     * 商家添加商品
     *
     * @param account
     * @param app
     * @param pageJson
     * @param type
     * @return
     */
    @RequestMapping("/addWare")
    @ResponseBody
    @SystemLog(description = "商家添加商品")
    public ReturnMsg addWare(String account, String app, String pageJson, String type) {
        // 根据用户id获取商家id
        ScStoreEntity storeEntity = wareService.getStoreIdByUid(account);
        String storeId = storeEntity.getid();

        WarePage page = null;
        if ("0".equals(type)) {
            page = GsonUtil.jsonToObject(pageJson, WarePage.class);
        } else if ("2".equals(type)) {
            page = GsonUtil.jsonToObject(pageJson, FwWarePage.class);
        } else if ("4".equals(type)) {
            page = GsonUtil.jsonToObject(pageJson, DeliveryWarePage.class);
        }
        page.setStoreid(storeId);
        page.setIsst(type);
        boolean flag = wareService.addWareInfo(account, app, page);
        if (flag) {
            return AppResponseMsg.success("新增商品成功");
        } else {
            return AppResponseMsg.faild("新增商品失败");
        }
    }

    /**
     * 商家删除商品
     *
     * @param account
     * @param app
     * @param spid
     * @return
     */
    @RequestMapping("/delWare")
    @ResponseBody
    @SystemLog(description = "商家删除商品")
    public ReturnMsg delWare(String account, String app, String spid) {
        boolean flag = wareService.delWareInfo(account, app, spid);
        if (flag) {
            return AppResponseMsg.success("删除商品成功");
        } else {
            return AppResponseMsg.faild("删除商品失败");
        }
    }

    /**
     * 商家修改商品
     *
     * @param account
     * @param app
     * @param pageJson
     * @return
     */
    @RequestMapping("/updWare")
    @ResponseBody
    @SystemLog(description = "商家修改商品")
    public ReturnMsg updWaret(String account, String app, String pageJson, String type) {
        WarePage page = null;
        if ("0".equals(type)) {
            page = GsonUtil.jsonToObject(pageJson, WarePage.class);
        } else if ("2".equals(type)) {
            page = GsonUtil.jsonToObject(pageJson, FwWarePage.class);
        } else if ("4".equals(type)) {
            page = GsonUtil.jsonToObject(pageJson, DeliveryWarePage.class);
        }
        boolean flag = wareService.updWareInfo(account, app, page);
        if (flag) {
            return AppResponseMsg.success("修改商品成功");
        } else {
            return AppResponseMsg.faild("修改商品失败");
        }
    }

    /**
     * 商家修改商品时删除商品图片
     *
     * @param account
     * @param app
     * @param id      图片id
     * @return
     */
    @RequestMapping("/delWarePic")
    @ResponseBody
    @SystemLog(description = "商家修改商品时删除商品图片")
    public ReturnMsg delWarePicture(String account, String app, String id) {
        boolean flag = wareService.delPicture(account, app, id);
        if (flag) {
            return AppResponseMsg.success("删除商品图片成功");
        } else {
            return AppResponseMsg.faild("删除商品图片失败");
        }
    }

    /**
     * 商家查询商品信息
     *
     * @param account
     * @param app
     * @param page
     * @return
     */
    @RequestMapping("/getWare")
    @ResponseBody
    @SystemLog(description = "商家查询商品信息")
    public ReturnMsg getWare(String account, String app, WarePage page, String type) {
        page = wareService.queryWareInfo(account, app, page.getId(), type);
        return AppResponseMsg.success(page);
    }


    /**
     * 查询商家的商品列表
     *
     * @param account 用户账号
     * @param app     app类型
     * @param spxz    商品性质，0：生鲜，1：拼团，2：服务，3：充值，4：宅配，5：积分
     * @param name    商品名称
     * @param type    商品分类
     * @param issj    是否上架 1上架，0下架
     * @param zffs    支付方式 0:不限;1:仅限线上支付;2:仅限货到付款;3定金支付
     * @param ofset   页数
     * @param psize   条数
     * @return
     */
    @RequestMapping(value = {"/getStoreWareList"})
    @ResponseBody
    @SystemLog(description = "查询商家的商品列表")
    public ReturnMsg getStoreWareList(HttpServletRequest request, String account, String app, String spxz, WarePage page, String ofset, String psize) {
        // 根据用户id获取商家id
        ScStoreEntity storeEntity = wareService.getStoreIdByUid(account);
        String storeId = storeEntity.getid();

        Map pageMap = checkPage(ofset, psize);
        List list = wareService.queryAll(storeId, app, "2", spxz, page, (Integer) pageMap.get("ofset"), (Integer) pageMap.get("psize"));
        String count = wareService.countWare(storeId, "2", spxz, page);
        return AppResponseMsg.success(list, count);
    }

    /**
     * 商家上/下架商品
     *
     * @param account 用户账号
     * @param app
     * @param spid    商品id
     * @param issj    是否上架 1上架，0下架
     * @param spxz    商品性质
     * @return
     */
    @RequestMapping("/shelveWare")
    @ResponseBody
    @SystemLog(description = "商家上/下架商品")
    public ReturnMsg shelveWare(String account, String app, @RequestParam String spid, @RequestParam String issj, @RequestParam String spxz) {
        boolean flag = wareService.shelveWare(account, app, spid, issj, spxz);
        if (flag) {
            return AppResponseMsg.success("商品上/下架成功");
        } else {
            return AppResponseMsg.faild("商品上/下架失败");
        }

    }

    /**
     * 商家上/下架规格
     *
     * @param account
     * @param app
     * @param ggid    规格id
     * @return
     */
    @RequestMapping("/shelveSpec")
    @ResponseBody
    @SystemLog(description = "商家上/下架规格")
    public ReturnMsg shelveSpecification(String account, String app, String ggid, String issj, String spxz) {
        // 根据用户id获取商家id
        ScStoreEntity storeEntity = wareService.getStoreIdByUid(account);
        String storeId = storeEntity.getid();

        boolean flag = wareService.shelveSpecification(storeId, app, ggid, issj, spxz);
        if (flag) {
            return AppResponseMsg.success("规格上/下架成功");
        } else {
            return AppResponseMsg.faild("规格上/下架失败");
        }
    }

    /**
     * 查询商家下的商品分类列表
     *
     * @param account
     * @param app
     * @return
     */
    @RequestMapping("/listStoreSort")
    @ResponseBody
    @SystemLog(description = "查询商家下的商品分类列表")
    public ReturnMsg listStoreSort(String account, String app) {
        // 根据用户id获取商家id
        ScStoreEntity storeEntity = wareService.getStoreIdByUid(account);
        List<?> list = wareSortService.listStoreSort(storeEntity);
        return AppResponseMsg.success(list);
    }

    /**
     * 产品线运费
     *
     * @param account 用户账号
     * @param xqid    小区ID
     * @param ofset   页数
     * @param psize   条数
     * @return
     */
    @RequestMapping("getPlinecom")
    @ResponseBody
    public ReturnMsg getPlinecom(String account, String xqid, String ofset, String psize) {
        Map<String, Object> pageMap = checkPage(ofset, psize);
        List list = wareService.listPLine(account, xqid, (Integer) pageMap.get("ofset"), (Integer) pageMap.get("psize"));
        return AppResponseMsg.success(list);
    }

    /**
     * 获取代理商的产品线
     * 日期 2017年2月24日
     * 时间 下午3:40:05
     * 创建者 Lcc
     *
     * @param uid 当前用户id
     * @return
     */
    @RequestMapping("/getAgentPlinesByUser")
    @ResponseBody
    @SystemLog(description = "获取用户的产品线")
    public ReturnMsg getAgentPlinesByUser(@RequestParam String uid) {
        ProductLineEntity bean = new ProductLineEntity();
        EntityModel agentInfo = userCacheService.getAgentInfo(uid);
        if (null != agentInfo) {
            uid = agentInfo.getId();
        }
        bean.setUid(uid);
        return AppResponseMsg.success(this.productLineService.getLeadProductLineYxTypeTree(bean));
    }


    /**
     * 获取商家的产品线
     * 日期 2017年2月24日
     * 时间 下午3:40:05
     * 创建者 Lcc
     *
     * @param uid 当前用户id
     * @return
     */
    @RequestMapping("/getStorePlinesByUser")
    @ResponseBody
    @SystemLog(description = "获取用户的产品线")
    public ReturnMsg getStorePlinesByUser(@RequestParam String uid) {
        ProductLineEntity bean = new ProductLineEntity();
        EntityModel storeInfo = userCacheService.getStoreInfo(uid);
        if (null != storeInfo) {
            uid = storeInfo.getId();
        }
        bean.setUid(uid);
        return AppResponseMsg.success(this.productLineService.getLeadProductLineYxTypeTree(bean));
    }

    @Autowired
    private UserCacheService userCacheService;

    /**
     * 查询代理商下的小区列表
     *
     * @param account
     * @param app
     * @return
     */
    @RequestMapping("/listAgentCom")
    @ResponseBody
    @SystemLog(description = "查询代理商下的小区列表")
    public ReturnMsg listAgentCom(String account, String app) {
//        String agentId = userCacheService.getAgentInfo(account).getId();
        return AppResponseMsg.success(wareService.listAgentCom(account));
    }
}
