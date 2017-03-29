package cn.tc.ulife.platform.agent.controller.shop;

import cn.tc.ulife.platform.server.shop.page.OrderPage;
import cn.tc.ulife.platform.server.user.model.UserFront;
import cn.tc.ulife.platform.server.user.service.BaseUserService;
import cn.tc.ulife.platform.util.GsonUtil;
import cn.tc.ulife.platform.util.UtilToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tc.ulife.platform.agent.base.BaseController;
import cn.tc.ulife.platform.agent.componet.SystemLog;
import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.server.shop.model.OrderBean;
import cn.tc.ulife.platform.server.shop.service.OrderService;

import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;

    @Autowired
    BaseUserService baseUserService;
    
    
    /**
     * 商家获取订单列表
     * 日期 2017年3月24日
     * 时间 上午10:40:39
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping(value = {"/getStoreOrderList"})
    @ResponseBody
    @SystemLog(description = "商家获取订单列表")
    public ReturnMsg getStoreOrderList(OrderBean bean) {
        return AppResponseMsg.success(orderService.getStoreOrderList(bean),orderService.getStoreOrderTotalCount(bean));
    }
    
    /**
     * 根据小区获取订单列表
     * 日期 2017年3月24日
     * 时间 下午1:36:49
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping(value = {"/getComOrderList"})
    @ResponseBody
    @SystemLog(description = "根据小区获取订单列表")
    public ReturnMsg getComOrderList(OrderBean bean) {
        return AppResponseMsg.success(orderService.getComOrderList(bean),orderService.getComOrderTotalCount(bean));
    }

    /**
     * 生成订单
     *
     * @param account   用户账号
     * @param orders    订单数据
     * @param type      产品线数据类型
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public ReturnMsg generateOrder(@RequestParam String account, @RequestParam String orders, String type) throws Exception {

        //从缓存中拿出用户信息--->只从缓存取出
        UserFront userFront = baseUserService.getUserFront(account);
        //用户信息是否失效
        if (userFront == null) {
            //用户信息失效
            return AppResponseMsg.userFaild();
        }else {
            //生成订单及附属属性,以及订单检测
            Map<String, Object> retMap = orderService.generateOrder(orders, userFront, type);

            //解析返回信息
            if (null != retMap) {
                return AppResponseMsg.success(retMap);
            } else {
                return AppResponseMsg.faild();
            }
        }
    }
}
