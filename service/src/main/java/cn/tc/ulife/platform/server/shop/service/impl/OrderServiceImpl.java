package cn.tc.ulife.platform.server.shop.service.impl;

import cn.tc.ulife.platform.server.SpringContextUtil;
import cn.tc.ulife.platform.server.exception.PageException;
import cn.tc.ulife.platform.server.remote.IQuartzOrderService;
import cn.tc.ulife.platform.server.shop.dao.OrderMapper;
import cn.tc.ulife.platform.server.shop.model.Market;
import cn.tc.ulife.platform.server.shop.model.OrderBean;
import cn.tc.ulife.platform.server.shop.page.OrderGoodsPage;
import cn.tc.ulife.platform.server.shop.page.OrderPage;
import cn.tc.ulife.platform.server.shop.runnable.PushOrderRunable;
import cn.tc.ulife.platform.server.shop.service.OrderService;
import cn.tc.ulife.platform.server.user.model.UserFront;
import cn.tc.ulife.platform.server.user.service.BaseUserService;
import cn.tc.ulife.platform.util.GsonUtil;
import cn.tc.ulife.platform.util.UtilToString;
import cn.tc.ulife.platform.util.constance.QuartzCallBackCodeConstance;
import cn.tc.ulife.platform.util.constance.SysConstance;
import cn.tc.ulife.platform.util.localthread.SimpleThreadLocal;
import cn.tc.ulife.platform.util.thread.CustomThreadPool;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.shop.service.impl
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/28 0028
 * </p>
 * Time: 下午 1:34
 * </p>
 * Detail:
 * </p>
 */
@Service("oService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    BaseUserService baseUserService;

    @Autowired
    IQuartzOrderService quartzOrderService;

    protected Logger logger = Logger.getLogger(OrderServiceImpl.class);

    @Override
    public List<OrderBean> getStoreOrderList(OrderBean bean) {
	return orderMapper.getStoreOrderList(bean);
    }

    @Override
    public String getStoreOrderTotalCount(OrderBean bean) {
	return orderMapper.getStoreOrderTotalCount(bean);
    }

    @Override
    public List<OrderBean> getComOrderList(OrderBean bean) {
	return orderMapper.getComOrderList(bean);
    }

    @Override
    public String getComOrderTotalCount(OrderBean bean) {
        return orderMapper.getComOrderTotalCount(bean);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Map<String, Object> generateOrder(String orders, UserFront userFront, String type) {
        //解析订单数据
        OrderPage orderPage = null;
        orderPage = this.parseOrderData(orders, type);
        //校验订单数据
        Future<Map<String, String>> orderFuture = this.checkOrderData(orderPage, type);

        //组装订单对象
        this.packOrderData(orderPage, userFront, type);

        //保存订单数据
        this.addOrder(orderPage);

        //校验任务6秒内已完成
        while (orderFuture.isDone()) {
            Map<String, String> nameMap = null;
            try {
                nameMap = orderFuture.get(6L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                logger.error("校验任务中断异常", e);
                throw new PageException("校验任务中断异常");
            } catch (ExecutionException e) {
                logger.error("校验任务执行异常", e);
                throw new PageException("校验任务执行异常");
            } catch (TimeoutException e) {
                logger.error("校验任务超时异常", e);
                throw new PageException("校验任务超时异常");
            }

            if (null == nameMap) {
                throw new PageException("参数错误");
            } else if (nameMap.get("code").equals("ERROR")) {
                throw new PageException(nameMap.get("name") + "超出购买数量");
            }
            break;
        }

        //根据支付方式选择添加订单超时或者直接推送订单
        this.addTimeOutAndPush(orderPage, orderPage.getOrderbh());
        //设置用户为老用户
        baseUserService.updNewUserFlag(userFront.getId(), "1");

        //返回参数
        Map<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("orderNum", orderPage.getOrderbh());
        retMap.put("orderId", orderPage.getId());

        return retMap;
    }

    @Override
    public List<String> getDeviceTokens(Map<String, String> paramMap) {
        return orderMapper.queryDeviceToken(paramMap);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void addOrder(OrderPage platOrder) throws RuntimeException {
        //插入平台订单数据
        orderMapper.insertOrder(platOrder);

        //用户使用优惠券抵扣
//        applyUserYhj(platOrder.getIsyhj(), platOrder.getHdyhjid(), "1");
        //用户使用积分抵扣
//        reduceUserItgl(platOrder.getUid(), storeOrder.getIsjf(), storeOrder.getJfje(), storeOrder.getId());

        for (OrderGoodsPage storeOrder : platOrder.getOrderGoodsPages()) {
            if (Integer.parseInt(storeOrder.getDgsl()) <= 0) {
                throw new PageException("商品订购数量不能为0");
            }
            orderMapper.insertOrderGoods(storeOrder);
        }

//        if ("0".equals(storeOrder.getIszt())) {// 非赠品
//            reduceStock(storeOrder.getIscx(), storeOrder.getCxid(), storeOrder.getSpid(),
//                    storeOrder.getGgid(), storeOrder.getDgsl(), storeOrder.getSpname(), SysConstance.CheckStockType.BUY.getValue());
//        } else {// 赠品
//        }
    }

    /**
     * 减少订单商品的库存
     *
     * @param iscx
     * @param cxId
     * @param spId
     * @param ggid
     * @param dgsl
     * @param spname
     * @param type
     * @throws PageException
     */
//    @Transactional
//    public void reduceStock(String iscx, String cxId, String spId, String ggid, String dgsl, String spname, String type) throws PageException {
//        //促销活动
//        if ("0".equals(iscx)) {
//            Map<String, Object> paramMap = new HashMap<String, Object>();
//            paramMap.put("cxId", cxId);
//            paramMap.put("spId", spId);
//            paramMap.put("ggId", ggid);
//            int hdsl = orderMapper.checkStockByMark(paramMap);
//            // 购买
//            if (SysConstance.CheckStockType.BUY.getValue().equals(type)) {
//                if (hdsl >= Integer.parseInt(dgsl)) {
//
//                    paramMap.put("hdsl", hdsl - Integer.parseInt(dgsl));
//
//
//                    orderMapper.updateStockByMark(paramMap);
//                    // 如果库存为0，则结束促销活动
//                    if (hdsl - Integer.parseInt(dgsl) == 0) {
//                        orderMapper.updateMarketStop(cxId);
//                    }
//                } else {
//                    throw new PageException(spname + "商品库存不足");
//                }
//            } else if (SysConstance.CheckStockType.RETURN.getValue().equals(type)) {
//                //回归
//                paramMap.put("hdsl", hdsl + Integer.parseInt(dgsl));
//                orderMapper.updateStockByMark(paramMap);
//            }
//        } else
//        //正常商品
//        {
//            Map<String, Object> paramMap = new HashMap<String, Object>();
//            paramMap.put("spId", spId);
//            paramMap.put("ggId", ggid);
//            int hdsl = orderMapper.checkStock(paramMap);
//            if (SysConstance.CheckStockType.BUY.getValue().equals(type)) {
//                if (hdsl >= Integer.parseInt(dgsl)) {
//                    paramMap.put("hdsl", hdsl - Integer.parseInt(dgsl));
//                    orderMapper.updateStock(paramMap);
//                } else {
//                    throw new PageException(spname + "商品库存不足");
//                }
//            } else if (SysConstance.CheckStockType.RETURN.getValue().equals(type)) {
//                paramMap.put("hdsl", hdsl + Integer.parseInt(dgsl));
//                orderMapper.updateStock(paramMap);
//            }
//        }
//    }

    /**
     * 根据支付方式选择添加订单超时或者直接推送订单
     *
     * @param orderPage
     * @param orderNum
     */
    public void addTimeOutAndPush(OrderPage orderPage, String orderNum) {
        //订单生成成功之后 -----> 若是线上支付-增加超时未支付取消功能
        if (orderPage.getZffs().equals("2") || orderPage.getZffs().equals("3")) {
            String retCode = quartzOrderService.processOrderJobByReturn(orderNum, UtilToString.getCron(new Date(), 2));

            if (retCode.equals(QuartzCallBackCodeConstance.SUCCESS_CODE)) {
                logger.info("Raw/service order open timeout success..." + orderNum + ",Timeout interval of two hours," +
                        "The current time:" + SimpleThreadLocal.format(new Date(), SimpleThreadLocal.dataPattern));
            } else {
                logger.error("Raw/service order open timeout failed..." + orderNum + ",Timeout interval of two hours," +
                        "The current time:" + SimpleThreadLocal.format(new Date(), SimpleThreadLocal.dataPattern));
            }
        }
        //线下支付时 ------>自动根据订单信息,推送到对应权限客服
        else if (orderPage.getZffs().equals("10")) {
            logger.info("push order, orderNum:" + orderNum);
            this.pushOrder(orderPage.getOrderbh(), orderPage.getType(), orderPage.getXqid(), null);
        }
    }

    /**
     * 推送订单到对应权限客服
     *
     * @param orderNo 订单编号
     * @param type    订单类型
     * @param comId   订单所属小区
     * @param fid
     */
    private void pushOrder(String orderNo, String type, String comId, String fid) {
        PushOrderRunable pushOrderRunable = new PushOrderRunable();

        Map<String, String> keyMap = new HashMap<String, String>();
        keyMap.put("orderNo", orderNo);
        keyMap.put("type", type);
        keyMap.put("comId", comId);
        keyMap.put("fid", fid);
        pushOrderRunable.setKeyMap(keyMap);
        pushOrderRunable.setComId(comId);
        pushOrderRunable.setType(type);
        pushOrderRunable.setFid(fid);
        pushOrderRunable.setOrderNum(orderNo);

        CustomThreadPool.execute(pushOrderRunable);
    }

    /**
     * 解析订单json数据
     *
     * @param orders 订单json数据
     * @param type   订单类型
     * @return
     */
    private OrderPage parseOrderData(String orders, String type) {
        // 解析参数---->生成订单对象
        OrderPage orderPage = GsonUtil.jsonToObject(orders, OrderPage.class);
        if (orderPage.getOrderGoodsPages().size() == 0) {
            return orderPage;
        }
        return null;
    }

    /**
     * 校验订单数据
     *
     * @param orderPage 订单对象
     * @param type      订单类型
     * @return
     */
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private Future<Map<String, String>> checkOrderData(OrderPage orderPage, String type) {
        if (null == orderPage) {
            logger.info("The main order data is null");
            return null;
        }
        if (null == orderPage.getOrderGoodsPages()) {
            logger.info("order goods data is null");
            return null;
        }

        for (OrderGoodsPage commodityOrder : orderPage.getOrderGoodsPages()) {
            Map<String, String> paramMap = new HashMap<String, String>();
            //商品id
            paramMap.put("comId", commodityOrder.getSpid());

            //规格id
            paramMap.put("speId", commodityOrder.getGgid());

            //商品是否参加了促销活动
            if ("0".equals(commodityOrder.getIscx())) {

                // 买赠活动中的赠品跳过
                if ("1".equals(commodityOrder.getIszt())) {
                    continue;
                }

                //活动数量
                Market market = orderMapper.queryComdiMarkCount(paramMap);

                //是否能找到对应活动
                if (null == market) {
                    logger.error("The order corresponding promotion is empty." +
                            "\n" + "comId:" + commodityOrder.getSpid() + ",speId:" + commodityOrder.getGgid() + ",userId:" + orderPage.getUid());

                    return null;
                }

                //判断当前商品购买数量是否超过限购数量
                if (Integer.parseInt(commodityOrder.getDgsl()) > Integer.parseInt(market.getXgsl())) {


                    Map<String, String> retMap = new HashMap<String, String>();
                    retMap.put("code", "ERROR");
                    retMap.put("name", commodityOrder.getSpname());
                    return new AsyncResult<Map<String, String>>(retMap);

                }
                paramMap.put("uid", orderPage.getUid());

                //已经购买数量
                String count = null;

                //每天限购
                if (market.getIsmtxg().equals("0")) {
                    paramMap.put("ktime", UtilToString.getNowDate(new Date()));
                    paramMap.put("jtime", SimpleThreadLocal.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
                    count = orderMapper.queryBuyComCount(paramMap);
                } else {
                    paramMap.put("ktime", market.getKtime());
                    paramMap.put("jtime", market.getJtime());
                    count = orderMapper.queryBuyComCount(paramMap);
                }
                if (null != count) {

                    if (Integer.parseInt(market.getXgsl()) - Integer.parseInt(count) <
                            Integer.parseInt(commodityOrder.getDgsl())) {
                        Map<String, String> retMap = new HashMap<String, String>();
                        retMap.put("code", "ERROR");
                        retMap.put("name", commodityOrder.getSpname());
                        return new AsyncResult<Map<String, String>>(retMap);
                    } else {
                        Map<String, String> retMap = new HashMap<String, String>();
                        retMap.put("code", "SUCCESS");
                        retMap.put("name", commodityOrder.getSpname());
                        return new AsyncResult<Map<String, String>>(retMap);
                    }
                } else {
                    Map<String, String> retMap = new HashMap<String, String>();
                    retMap.put("code", "SUCCESS");
                    retMap.put("name", commodityOrder.getSpname());
                    return new AsyncResult<Map<String, String>>(retMap);
                }
            }

        }

        Map<String, String> retMap = new HashMap<String, String>();
        retMap.put("code", "SUCESS");

        return new AsyncResult<Map<String, String>>(retMap);
    }

    /**
     * 组装订单数据
     *
     * @param orderPage 订单对象
     * @param userFront 用户信息
     * @param type      订单类型
     */
    private void packOrderData(OrderPage orderPage, UserFront userFront, String type) {
        //获取订单号
        String orderNum = UtilToString.getOrderNum();
        //订单编号
        orderPage.setOrderbh(orderNum);

        //订单类型
        orderPage.setType(type);
        //默认状态
        orderPage.setZt("0");

        //绑定订单用户
        orderPage.setUid(userFront.getId());
        //添加所在小区信息
        orderPage.setXqid(userFront.getComId());

        //支付方式为 2||3 时,表示线上支付,代表 支付宝支付/微信支付
        if (orderPage.getZffs().equals("2") || orderPage.getZffs().equals("3")) {
            orderPage.setZfzt(SysConstance.PayStatus.PAY_WAIT.getValue());
            orderPage.setOzt(SysConstance.OrderStatus.ORDER_BUYER_WATI_PAY.getValue());

        }
        //线下支付 ---->本期自动置为订单已确认状态
        else if (orderPage.getZffs().equals("10")) {
            orderPage.setZfzt(SysConstance.PayStatus.PAY_LINE.getValue());
            orderPage.setOzt(SysConstance.OrderStatus.ORDER_XZ_SEND.getValue());
        }

        for (OrderGoodsPage orderGoodsPage : orderPage.getOrderGoodsPages()) {
            //订单编号
            orderGoodsPage.setOrderbh(UtilToString.getOrderNum("p"));
            //上级id
            orderGoodsPage.setPid(orderPage.getId());
            //订单状态
            orderGoodsPage.setOzt(orderPage.getOzt());

//            String[] ktime = orderMapper.queryStoreSendTime(storeOrder.getSjid()).get("KTIME").split(":");
//            String[] jtime = orderMapper.queryStoreSendTime(storeOrder.getSjid()).get("JTIME").split(":");
//            //检测配送日期
//            storeOrder.setPsrq(UtilToString.checkDate(storeOrder.getPsrq(), Integer.parseInt(jtime[0]) * 100 + Integer.parseInt(jtime[1]), Integer.parseInt(ktime[0]) * 100 + Integer.parseInt(ktime[1])));
        }
    }

}