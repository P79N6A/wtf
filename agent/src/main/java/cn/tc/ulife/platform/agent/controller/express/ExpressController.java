/**
 * @Title: ExpressController
 * @Package cn.tc.ulife.platform.agent.controller.express
 * @Description: 快递模块controller层
 * @author alliswell008
 * @date 2017/2/16 14:50
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.agent.controller.express;

import cn.tc.ulife.platform.agent.base.BaseController;
import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.server.shop.page.ExpressPage;
import cn.tc.ulife.platform.server.shop.service.ExpressService;
import cn.tc.ulife.platform.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author alliswell008
 * @ClassName: ExpressController
 * @Description: 快递模块controller层
 * @date 2017/2/16 14:50
 */
@Controller
@RequestMapping("/express")
public class ExpressController extends BaseController {

    @Autowired
    private ExpressService expressService;

    /**
     * 获取快递公司信息
     *
     * @param account 用户账号
     * @param app 终端类型
     * @param id 快递公司ID
     * @return
     */
    @RequestMapping("getCompany")
    public ReturnMsg getExpressCompany(String account, String app, String id) {
        ExpressPage expressPage = expressService.queryExpressInfo(account, app, id);
        return AppResponseMsg.success(expressPage);
    }

    /**
     * 获取快递公司信息列表
     *
     * @param account 用户账号
     * @param app 终端类型
     * @param kdmc 快递公司名称
     * @param ofset 页数
     * @param psize 条数
     * @return
     */
    @RequestMapping("getCompanyList")
    public ReturnMsg getExpressComanyList(String account, String app, String kdmc, String ofset, String psize) {
        List<ExpressPage> pageList = new ArrayList<>();

        Map<String, Object> pageMap = checkPage(ofset, psize);
        pageList = expressService.queryAll(account, app, kdmc, (Integer) pageMap.get("ofset"), (Integer) pageMap.get("psize"));
        return AppResponseMsg.success(pageList);
    }

    /**
     * 新增快递公司信息
     *
     * @param account 用户账号
     * @param app 终端类型
     * @param json 快递公司信息{}
     * @return
     */
    @RequestMapping("addCompany")
    public ReturnMsg addExpressCompany(String account, String app, String json) {
        ExpressPage page = new ExpressPage();
        page = GsonUtil.jsonToObject(json, ExpressPage.class);
        boolean flag = expressService.addExpressInfo(account, app, page);
        if (flag) {
            return AppResponseMsg.success("新增快递公司信息成功");
        } else {
            return AppResponseMsg.faild("新增快递公司信息失败");
        }
    }
}
