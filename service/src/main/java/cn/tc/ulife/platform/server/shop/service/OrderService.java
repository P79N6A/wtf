package cn.tc.ulife.platform.server.shop.service;

import java.util.List;

import cn.tc.ulife.platform.server.shop.model.OrderBean;

import cn.tc.ulife.platform.server.shop.page.OrderPage;
import cn.tc.ulife.platform.server.user.model.UserFront;

import java.util.Map;
import java.util.concurrent.*;

import cn.tc.ulife.platform.server.shop.page.OrderPage;
import cn.tc.ulife.platform.server.user.model.UserFront;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * 订单模块业务接口
 * 日期 2017年3月22日
 * 时间 上午10:38:40
 * @author lwy
 *
 */
public interface OrderService {
    
    /**
     * 商家获取订单列表
     * 日期 2017年3月22日
     * 时间 上午10:39:04
     * 创建者 lwy
     * @return
     */
    public List<OrderBean> getStoreOrderList(OrderBean bean);
    public String getStoreOrderTotalCount(OrderBean bean);
    
    /**
     * 根据小区获取订单列表
     * 日期 2017年3月23日
     * 时间 上午10:30:12
     * 创建者 lwy
     * @param bean
     * @return
     */
    public List<OrderBean> getComOrderList(OrderBean bean);
    public String getComOrderTotalCount(OrderBean bean);


    /**
     * 生成订单
     *
     * @param orders    订单数据
     * @param userFront 用户信息
     * @param type      订单类型
     * @return
     * @throws Exception
     */
    Map<String,Object> generateOrder(String orders, UserFront userFront, String type) throws Exception;

    List<String> getDeviceTokens(Map<String, String> keyMap);
}
