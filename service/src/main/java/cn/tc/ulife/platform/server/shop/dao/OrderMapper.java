package cn.tc.ulife.platform.server.shop.dao;

import java.util.List;
import java.util.Map;

import cn.tc.ulife.platform.server.shop.model.Market;
import cn.tc.ulife.platform.server.shop.model.OrderBean;
import cn.tc.ulife.platform.server.shop.page.OrderGoodsPage;
import cn.tc.ulife.platform.server.shop.page.OrderPage;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.shop.dao.mapper
 * </p>
 * User: wangyue
 * </p>  
 * Date: 2016/4/27 0027
 * </p>
 * Time: 下午 5:58
 * </p>
 * Detail:
 * </p>
 */
public interface OrderMapper {

    public List<OrderBean> getStoreOrderList(OrderBean bean);
    public String getStoreOrderTotalCount(OrderBean bean);
    
    public List<OrderBean> getComOrderList(OrderBean bean);
    public String getComOrderTotalCount(OrderBean bean);

    void insertOrder(OrderPage platOrder);

    void insertOrderGoods(OrderGoodsPage storeOrder);

    Market queryComdiMarkCount(Map<String, String> paramMap);

    String queryBuyComCount(Map<String, String> paramMap);

    List<String> queryDeviceToken(Map<String, String> paramMap);
}