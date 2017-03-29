package cn.tc.ulife.platform.agent.controller.pay;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cxs
 * @ClassName: OrderController
 * @Description: 订单模块controller层
 * @date 2017/2/17 15:35
 */
@Controller
@RequestMapping("/pay")
public class PayController {































//    @Autowired
//    OrderService orderService;
//
//    @Autowired
//    BaseUserService baseUserService;
//
//    @Autowired
//    UserAccessoryService userAccessoryService;
//
//
//    @Autowired
//    IQuartzOrderService quartzOrderService;
//
//
//    /**
//     * 微信支付超时间隔 -5分钟
//     */
//    private static final int wechatMinInterTime = 300000;
//
//    /**
//     * 微信支付超时间隔 -120分钟
//     */
//    private static final int wechatMaxInterTime = 7200000;
//
//
//    protected Logger logger = Logger.getLogger(OrderController.class);
//
//
//    /**
//     * 支付订单
//     *
//     * @param account  用户账号
//     * @param orderNum 订单编号
//     * @param zffs     支付方式
//     * @param app      来源
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/goPay", method = RequestMethod.POST)
//    @ResponseBody
//    public ReturnMsg goPay(@RequestParam String account, @RequestParam String orderNum, String zffs, String app, String openId) throws Exception {
//        UserFront userFront = baseUserService.getUserFront(account);
//
//        //判断用户信息是否失效
//        if (null != userFront) {
//
//
//            //生成订单时默认支付方式与去支付时支付方式不一致，则变更订单的支付方式
//            orderService.updateOrderZffs(orderNum, zffs);
//            //获取订单金额
//            String paySprice = getOrderPrice(orderNum, zffs);
//
//            //生成签名信息
//            Map<String, Object> retMap = getSignParam(orderNum, zffs, app, openId, paySprice);
//            if (null != retMap && retMap.size() > 0) {
//                return AppResponseMsg.success(retMap);
//            } else {
//                logger.error("User-generated pay signature failure ,by orderNum {} " + orderNum);
//                return AppResponseMsg.faild("生成签名失败");
//            }
//
//
//        } else {
//            return AppResponseMsg.userFaild();
//        }
//    }
//
//    /**
//     * 根据支付方式生成签名
//     *
//     * @param orderNum
//     * @param zffs
//     * @param app
//     * @param openId
//     * @param paySprice
//     * @return
//     */
//    private Map<String, Object> getSignParam(String orderNum, String zffs, String app, String openId, String paySprice) {
//
//        Map<String, Object> retMap = new HashMap<String, Object>();
//        //如果是微信支付,异步线程请求微信端生成预支付订单
//        Future<CallOrderModel> callOrderModelFuture = null;
//        if (zffs.equals(SysConstance.PayWay.WECHAT_PAY.getValue())) {
//            callOrderModelFuture = orderService.wxPrepayOrder(orderNum, app, paySprice, openId);
//            retMap.put("notifyUrl", ConfigUtil.getProperties("WX_NOTIFY_URL"));
//            //微信支付取回预处理结果
//            if (zffs.equals(SysConstance.PayWay.WECHAT_PAY.getValue())) {
//
//                while (true) {
//                    if (callOrderModelFuture.isDone()) {
//                        CallOrderModel callOrderModel = null;
//
//                        try {
//                            //6秒内取回结果,及时释放线程
//                            callOrderModel = callOrderModelFuture.get(6L, TimeUnit.SECONDS);
//
//                        } catch (Exception e) {
//                            logger.error("WeChat preprocessing failure,By Call Asynchronous threading", e);
//
//                            return null;
//                        }
//
//                        //取回微信结果
//                        if (null != callOrderModel) {
//                            retMap.put("callOrder", callOrderModel);
//
//                        } else {
//                            logger.error("WeChat preprocessing failure, By  Asynchronous threading   no return value");
//                            return null;
//                        }
//                        break;
//                    }
//                }
//            }
//        } else {
//
//            retMap.put("notifyUrl", ConfigUtil.getProperties("NOTIFY_URL"));
//            retMap.put("sign", CreateAlipaySign.getSignResult("U家生活", "美好生活,天天拥有", paySprice, orderNum, ConfigUtil.getProperties("NOTIFY_URL")));
//        }
//
//        return retMap;
//    }
//
//    /**
//     * 获取订单金额 ,除物业订单之外,如果选择支付方式不同于生成订单默认方式,修改订单成新的支付方式
//     *
//     * @param orderNum
//     * @param zffs
//     * @return
//     */
//    private String getOrderPrice(String orderNum, String zffs) {
//        String paySprice;
//        //物业缴费
//        if (orderNum.startsWith("PWYB")) {
//
//            WyPropayPo wyPropayPo = orderService.queryWyPropay(orderNum);
//            paySprice = wyPropayPo.getYjje();
//        }
//
//        //物业报修
//        else if (orderNum.startsWith("PWYA")) {
//            WyRepairPo wyRepairPo = orderService.queryWyRepair(orderNum);
//            paySprice = wyRepairPo.getBxje();
//        }
//
//        //其余订单正常缴费
//        else {
//            //生成订单时默认支付方式与去支付时支付方式不一致，则变更订单的支付方式
//            PlatOrder platOrder = orderService.queryPlatOrderByNum(orderNum);
//            paySprice = platOrder.getZhzj();
//
//            if (!platOrder.getZffs().equals(zffs)) {
//                PlatOrder updPlatOrder = new PlatOrder();
//                updPlatOrder.setOrderbh(orderNum);
//                updPlatOrder.setZffs(zffs);
//
//                orderService.updOrderByPk(updPlatOrder);
//            }
//        }
//        return paySprice;
//    }
//
//
//    /**
//     * 生成订单
//     *
//     * @param account 用户账号
//     * @param orders  订单数据
//     * @param type    产品线数据类型
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
//    @ResponseBody
//    public ReturnMsg generateOrder(@RequestParam String account, @RequestParam String orders, String type) throws Exception {
//
//        //从缓存中拿出用户信息--->只从缓存取出
//        UserFront userFront = baseUserService.getUserFront(account);
//
//        //用户信息是否失效
//        if (null != userFront) {
//
//            // 解析参数---->生成订单对象
//            PlatOrder platOrder = GsonUtil.jsonToObject(orders, PlatOrder.class);
//            if (platOrder.getStoreOrderList().size() == 0 || platOrder.getStoreOrderList().get(0).getCommodityOrders().size() == 0) {
//
//                return AppResponseMsg.faild("订单信息有误");
//            }
//
//            //获取订单号
//            String orderNum = UtilToString.getOrderNum();
//
//
//            //生成订单及附属属性,以及订单检测
//            Map<String, Object> retMap = orderService.generateOrder(platOrder, userFront, orderNum, type);
////
//
//            //解析返回信息
//            if (null != retMap) {
//
//                //根据支付方式选择添加订单超时或者直接推送订单
//                addTimeOutAndPush(platOrder, orderNum);
//
//
//                //设置用户为老用户
//                baseUserService.updNewUserFlag(userFront.getId(), "1");
//
//                return AppResponseMsg.success(retMap);
//            } else {
//
//                return AppResponseMsg.faild();
//
//            }
//        } else {
//
//            //用户信息失效
//            return AppResponseMsg.userFaild();
//        }
//    }
//
//
//    /**
//     * 根据支付方式选择添加订单超时或者直接推送订单
//     *
//     * @param platOrder
//     * @param orderNum
//     */
//    private void addTimeOutAndPush(PlatOrder platOrder, String orderNum) {
//        //订单生成成功之后 -----> 若是线上支付-增加超时未支付取消功能
//        if (platOrder.getZffs().equals("2") || platOrder.getZffs().equals("3")) {
//
//            String retCode = quartzOrderService.processOrderJobByReturn(orderNum, UtilToString.getCron(new Date(), 2));
//
//            if (retCode.equals(QuartzCallBackCodeConstance.SUCCESS_CODE)) {
//                logger.info("Raw/service order open timeout success..." + orderNum + ",Timeout interval of two hours," +
//                        "The current time:" + SimpleThreadLocal.format(new Date(), SimpleThreadLocal.dataPattern));
//            } else {
//                logger.error("Raw/service order open timeout failed..." + orderNum + ",Timeout interval of two hours," +
//                        "The current time:" + SimpleThreadLocal.format(new Date(), SimpleThreadLocal.dataPattern));
//            }
//
//        }
//
//        //线下支付时 ------>自动根据订单信息,推送到对应权限客服
//        else if (platOrder.getZffs().equals("10")) {
//
//            logger.info("push order, orderNum:" + orderNum);
//            orderService.pushOrder(platOrder.getOrderbh(), platOrder.getType(), platOrder.getXqid(), platOrder.getFwsid());
//        }
//    }
//
//
//    /**
//     * U洗衣.U维修.U生鲜,U拼团,U宅配 取消订单
//     *
//     * @param account
//     * @param app
//     * @param orderNo
//     * @param orderId
//     * @param request
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/backOrder", method = RequestMethod.POST)
//    @ResponseBody
//    public ReturnMsg backOrder(@RequestParam String account, @RequestParam String app, @RequestParam String orderNo, @RequestParam String orderId, HttpServletRequest request) throws Exception {
//        UserFront userFront = baseUserService.getUserFront(account);
//        if (null != userFront) {
//
//            /*
//            by 2016/11/25 功能, 未支付订单可以取消支付
//             */
//
//            PlatOrder platOrder = orderService.queryPlatOrderByNum(orderNo);
//
//            //状态检测
//            if (null != platOrder && platOrder.getOzt().equals(OrderStatus.ORDER_BUYER_WATI_PAY)) {
//
//
//                //修改订单为用户取消支付订单
//                orderService.updateOrder(userFront.getId(), OrderConstance.EXIT_ORDER_INTEGER, app,
//                        request.getRemoteAddr(), orderNo, SysConstance.PayWay.DEFAULT_PAY.getValue(), "");
//
//                return AppResponseMsg.success("取消成功");
//            } else {
//
//                return AppResponseMsg.faild("订单信息无效....");
////                return AppResponseMsg.success("请联系小站人员:" + userAccessoryService.queryServiceTel(userFront.getComId()));
//            }
//
////            orderService.updateOrder(orderId, userFront.getId(), pid, "1", app, request.getRemoteAddr(), orderNo);
//
//
//        } else {
//
//            return AppResponseMsg.userFaild();
//        }
//
//
//    }
//
//    @RequestMapping(value = "/confOrder", method = RequestMethod.POST)
//    @ResponseBody
//    public ReturnMsg confOrder(@RequestParam String account, @RequestParam String orderNo, String app, @RequestParam String orderId,
//                               HttpServletRequest request) throws Exception {
//        UserFront userFront = baseUserService.getUserFront(account);
//        if (null != userFront) {
//
//            //确认订单完成
//            orderService.updateOrder(userFront.getId(), OrderConstance.VERIFY_ORDER_INTEGER, app,
//                    request.getRemoteAddr(), orderNo, SysConstance.PayWay.DEFAULT_PAY.getValue(), "");
//        } else {
//
//            return AppResponseMsg.userFaild();
//        }
//
//
//        return AppResponseMsg.success();
//    }
//
//
//    @SuppressWarnings(
//            {"rawtypes", "unused"})
//    @RequestMapping("/payCallBack")
//    @ResponseBody
//    @SystemLog(description = "支付宝回调", ozt = "3")
//    public ReturnMsg payCallBack(HttpServletRequest request,
//                                 HttpServletResponse response) throws UnsupportedEncodingException {
//        logger.info("AliPay treasure to the callback{}");
//
//
//        Map requestParams = request.getParameterMap();
//        if (requestParams == null) {
//            return null;
//        }
//
//        logger.info("AliPay requestParams:" + requestParams.toString() + "{}");
//
//
//        PrintWriter out;
//        try {
//            out = response.getWriter();
//            // 获取支付宝返回信息,并生成校验签名串
//            Map<String, String> params = getAliPayCallbackSignMap(requestParams);
//
//            // 支付宝交易号
//            String tradeNo = request.getParameter("trade_no");
//
//            // 获取订单号
//            String orderNo = request.getParameter("out_trade_no");
//
//            // 获取总金额
//            String totalFee = request.getParameter("total_fee");
//
//            // 商品名称、订单名称
//            //            String subject = new String(request.getParameter("subject")
//            //                    .getBytes("UTF-8"), "UTF-8");
//
//            // 买家支付宝账号
//            String buyer_email = request.getParameter("buyer_email");
//
//            String seller_email = request.getParameter("seller_email");
//
//            // 交易状态
//            String trade_status = request.getParameter("trade_status");
//
//            if (AlipayNotify.verify(params)) {// 验证成功
//                // true : 支付宝支付成功 , 可以修改本地订单状态
//                if (trade_status.equals("TRADE_FINISHED")
//                        || trade_status.equals("TRADE_SUCCESS")) {
//
//                    logger.info("Enter the AliPay  local callback methods, orderNum:" + orderNo);
//
//                    orderService.callBackOrder(tradeNo, orderNo,
//                            buyer_email, totalFee, seller_email, "0", "2");
////
//                    logger.info("Back the AliPay  local callback methods,orderNum:" + orderNo + ",return success");
//                    out.println("success");
//
//                } else {
//                    logger.error("AliPay treasure to callback fails, return to coding errors");
//                    logger.error("orderNum:" + orderNo + ",return code :" + trade_status);
//                    out.println("fail");
//                }
//
//            } else {
//
//                logger.error("AliPay treasure to callback and fail, fail validation parameters..." + "\n" + "orderNum:" + orderNo);
//                // 验证失败
//                out.println("fail");
//            }
//        } catch (Exception e) {
////            e.printStackTrace();
//            logger.error("AliPay CallBack fail {}", e);
//        }
//        return null;
//    }
//
//
//    /**
//     * 根据回调参数生成校验签名
//     *
//     * @param requestParams
//     * @return
//     * @throws java.io.UnsupportedEncodingException
//     */
//    private Map<String, String> getAliPayCallbackSignMap(Map requestParams) throws UnsupportedEncodingException {
//        Map<String, String> params = new HashMap<String, String>();
//        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
//            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
//            params.put(name, valueStr);
//        }
//        return params;
//    }
//
//    /**
//     * 领取红包
//     *
//     * @return
//     */
//    @RequestMapping("/getRedpacket")
//    @ResponseBody
//    public ReturnMsg getRedPacket(String m, String orderId) {
//        ResponseMsg rmsg = new AppResponseMsg();
//        if (StringUtils.isNotEmpty(m) && StringUtils.isNotEmpty(orderId)) {
//            String uid = orderService.queryUserIsExit(m);
//
//            //用户不存在,新增用户并且设置用户小区为分享红包用户小区
//            if (null == uid) {
//
//                logger.info(m + "用户未注册,进入注册领取业务");
//
//                // 分享红包用户信息
//                String comId = orderService.queryShareRpUser(orderId);
//                uid = redPacketAddUser(m, comId);
//
//            } else {
//
//                //已注册用户
//                Map<String, String> paramMap = new HashMap<String, String>();
//                paramMap.put("uid", uid);
//                paramMap.put("orderId", orderId);
//                int isGet = orderService.queryIsGetRP(paramMap);
//
//                //是否领取过
//                if (isGet > 0) {
//                    logger.info(m + "已经领取过订单为" + orderId + "的红包");
//                    rmsg.setMsg("您已经领取过");
//                    rmsg.setResultCode(ReturnMsg.RTN_21);
//                    return rmsg;
//                }
//
//            }
//            if (null == uid) {
//                rmsg.setMsg("领取失败");
//                rmsg.setResultCode(ReturnMsg.RTN_6);
//                return rmsg;
//            }
//            OrderRedPacket userRedPacket = getOrderRedPacket(orderId);
//            if (null == userRedPacket) {
//                rmsg.setMsg("红包已领完");
//                rmsg.setResultCode(ReturnMsg.RTN_21);
//                return rmsg;
//            }
//            int i = orderService.userGetOrderRp(userRedPacket, uid);
//            if (i > 0) {
//
//                rmsg.setMsg("领取成功");
//                rmsg.setData(userRedPacket);
//                rmsg.setResultCode(ReturnMsg.RTN_0);
//            } else {
//                rmsg.setMsg("领取失败");
//                rmsg.setData(userRedPacket);
//                rmsg.setResultCode(ReturnMsg.RTN_6);
//            }
//
//
//        } else {
//            rmsg.setMsg("参数为空");
//            rmsg.setResultCode(ReturnMsg.RTN_3);
//        }
//
//
//        return rmsg;
//    }
//
//
//    @RequestMapping("/getRedView")
//    public ModelAndView getRedView(String orderId) {
//        ModelAndView mav = new ModelAndView("taken");
//        mav.addObject("orderId", orderId);
//
//        return mav;
//    }
//
//    @RequestMapping(value = "/redView")
//    @ResponseBody
//    public ReturnMsg redPacketView(String m, String orderId) {
//        ResponseMsg rmsg = new AppResponseMsg();
//        if (StringUtils.isNotEmpty(orderId)) {
//            int redPIsexit = orderService.queryRedPIsExit(orderId);
//
//            //如果红包存在
//            if (redPIsexit > 0) {
//                List<RedPacketView> redPacketViews = orderService.queryOrderRedP(orderId);
//                rmsg.setResultCode(ReturnMsg.RTN_0);
//                rmsg.setData(redPacketViews);
//            } else {
//                rmsg.setResultCode(ReturnMsg.RTN_22);
//                rmsg.setMsg("该红包不存在");
//            }
//
//            return rmsg;
//        } else {
//            rmsg.setResultCode(ReturnMsg.RTN_6);
//            rmsg.setMsg("页面有误");
//            return rmsg;
//        }
//    }
//
//    private OrderRedPacket getOrderRedPacket(String orderId) {
//        List<OrderRedPacket> orderRedPackets = orderService.queryOrderRp(orderId);
//
//        List<OrderRedPacket> getRedPackets = new ArrayList<OrderRedPacket>();
//
//        for (OrderRedPacket orderRedPacket : orderRedPackets) {
//            try {
//                for (int i = 0; i < Integer.parseInt(orderRedPacket.getGetCount()); i++) {
//                    getRedPackets.add((OrderRedPacket) BeanUtilsBean.getInstance().cloneBean(orderRedPacket));
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                logger.error("获取红包失败...", e);
//            }
//        }
//        if (getRedPackets.size() <= 0) {
//            return null;
//        }
//        Random random = new Random();
//
//        return getRedPackets.get(random.nextInt(getRedPackets.size()));
//    }
//
//
//    private String redPacketAddUser(String m, String comId) {
//        BaseUser baseUser = new BaseUser();
//        baseUser.setPassword(MD5.cell32("123456"));
//        baseUser.setAccount(m);
//        baseUser.setTel(m);
//        baseUser.setDtype("8");
//        baseUser.setRegMethod("0");
//        baseUser.setZt("0");
//        baseUser.setIsNewUser("0");
//        Map<String, String> retMap = baseUserService.addUser(baseUser, SysConstance.USER.getValue(), comId, null);
//        if (null != retMap && retMap.size() > 0) {
//            return retMap.get("uid");
//        } else {
//            return null;
//        }
//    }
//
//
//    /**
//     * 微信支付回调
//     *
//     * @param request  请求
//     * @param response 响应
//     * @return
//     */
//    @RequestMapping("/wxPayCallBack")
//    @SystemLog(description = "微信支付回调", ozt = "3")
//    public String wxOrderCallBack(HttpServletRequest request, HttpServletResponse response) {
//
//        logger.info("start WeChat CallBack {}");
//        //获取微信回调返回信息,拼接成String
//        String requestString = getWechatCallBackToString(request);
//
//        //读取输入流失败
//        if (null == requestString) {
//            logger.error("Reads the input stream is empty");
//            return null;
//        }
//
//        //根据回调字符串生成回调消息模板
//        CallBackBean callBackBean = new CallBackBean();
//        XmlUtil.parseXml(requestString, callBackBean);
//
//        logger.info("WeChat CallBack message model{}" + callBackBean);
//
//
//        // 微信订单请求失败
//        if (!Constance.WECHAT_CODE_SUCCESS.equals(callBackBean.getReturn_code())) {
//
//            logger.info("WeChat CallBack error ,return code is :" + callBackBean.getReturn_code());
//            return null;
//        }
//
//        // 表示微信业务支付成功
//        if (Constance.WECHAT_CODE_SUCCESS.equals(callBackBean.getResult_code())) {
//            try {
//
//                logger.info("Enter WeChat CallBack service process{}");
//                //回调订单
//                try {
//
//                    //本地订单操作处理
//                    orderService.callBackOrder(callBackBean.getTransaction_id(), callBackBean.getOut_trade_no()
//                            , callBackBean.getOpenid(), callBackBean.getTotal_fee(), callBackBean.getMch_id(), "0", "3");
//                } catch (Exception e) {
////                        e.printStackTrace();
//
//                    logger.error("WeChat CallBack local order process is fail,error :{} ", e);
//                    return null;
//                }
//
//
//                //发送微信端成功标识
//                response.getOutputStream().println(Constance.WECHAT_CALLBACK_RETURN);
//                logger.info("WeChat CallBack success{}");
//            } catch (IOException e) {
//                e.printStackTrace();
//                logger.error("WeChat Callback fail ,by IoException{}", e);
//            }
//
//        } else {
//            logger.error("WeChat CallBack is fail ,because operation code is  fail:" + callBackBean.getResult_code());
//        }
//        return null;
//
//    }
//
//
//    /**
//     * 解析微信回调成消息模板字符串
//     *
//     * @param request
//     * @return
//     */
//    private String getWechatCallBackToString(HttpServletRequest request) {
//        StringBuilder sb = new StringBuilder();
//        try {
//            //获取输入流
//            BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                sb.append(line);
//            }
//        } catch (IOException e) {
////            e.printStackTrace();
//            logger.error("微信回调解析失败", e);
//            return null;
//        }
//        return sb.toString();
//    }
//
//
//    /**
//     * 计算订单数据
//     *
//     * @param account
//     * @param moneyMap json 数据格式
//     * @return
//     */
//    @RequestMapping("/calculateOrder")
//    @ResponseBody
//    public ReturnMsg calculateOrder(String account, String lineId, String moneyMap, String allMoney) {
//        UserFront userFront = baseUserService.getUserFront(account);
//        if (null != userFront) {
//
//            //计算该用户生成该订单所拥有支付方式/优惠券/积分/收货地址等有效信息
//            Map<String, Object> retMap = orderService.calculateOrder(userFront, moneyMap, allMoney, lineId);
//
//            //配送限制  几天内
////            retMap.put("psxz", "3");
//
//            return AppResponseMsg.success(retMap);
//        } else {
//            return AppResponseMsg.faild("用户信息失效,请重新登录");
//        }
//    }
//
//
//    @RequestMapping("/getRecAddr")
//    @ResponseBody
//    public ReturnMsg getRecAddress(@RequestParam String account, String app) {
//        UserFront userFront = baseUserService.getUserFront(account);
//        if (null != userFront) {
//
//            //查询用户当前所绑定小区内收货地址
//            return AppResponseMsg.success(userAccessoryService.queryRecAddress(userFront.getComId(), userFront.getId()));
//        } else {
//            return AppResponseMsg.userFaild();
//        }
//
//    }
//
//
//    @RequestMapping("/updRecAddr")
//    @ResponseBody
//    public ReturnMsg updRecAddress(@RequestParam String account, String id, @RequestParam String mobile, @RequestParam String uname, @RequestParam String address, @RequestParam String isDef, String zt, @RequestParam String type) {
//        UserFront userFront = baseUserService.getUserFront(account);
//        if (null != userFront) {
//
//            // 1是新增 2是修改 及删除
//            switch (Integer.parseInt(type)) {
//                case 1:
//                    int retCode = userAccessoryService.addRecAddress(userFront.getId(), userFront.getComId(), address, uname, mobile);
//                    if (retCode == 99) {
//                        return AppResponseMsg.faild("最多添加五条收货地址");
//                    }
//                    break;
//                case 2:
//                    userAccessoryService.updRecAddress(id, address, isDef, zt, uname, mobile, userFront.getComId(), userFront.getId());
//                    break;
//
//                default:
//                    return AppResponseMsg.paramIsNull();
//            }
//
//        } else {
//            return AppResponseMsg.userFaild();
//        }
//
//        return AppResponseMsg.success();
//    }
//
//
//    @RequestMapping("/againPay")
//    @ResponseBody
//    @SystemLog(description = "再次支付", ozt = "3")
//    public ReturnMsg againPay(@RequestParam String account, @RequestParam String orderBh, @RequestParam String app,
//                              @RequestParam String zffs, String openId, HttpServletRequest request) throws Exception {
//
//        UserFront userFront = baseUserService.getUserFront(account);
//        if (null != userFront) {
//
//
//            Map<String, Object> map = orderService.updateOrder(userFront.getId(), OrderConstance.AGAIN_PAY_INTEGER,
//                    app, request.getRemoteAddr(), orderBh, zffs, openId);
//            if (null == map) {
//                return AppResponseMsg.faild("调起支付失败");
//            }
//
//            return AppResponseMsg.success(map);
//        } else
//
//        {
//            return AppResponseMsg.userFaild();
//        }
//    }
//
//
////    /**
////     * 页面回调
////     *
////     * @param m             用户账号
////     * @param orderBh       订单编号
////     * @param aliaPay       第三方流水号
////     * @param buyerAccount  买家账号
////     * @param sellerAccount 卖家账号
////     * @param money         价钱
////     * @return AppResponseMsg
////     */
////    @RequestMapping(value = "/webCallBack", method = RequestMethod.POST)
////    @ResponseBody
////    @SystemLog(description = "支付页面回调", ozt = "1")
////    public ReturnMsg webCallBack(@RequestParam String m, @RequestParam String orderBh, String aliaPay,
////                                 String buyerAccount, String sellerAccount, String money) {
////        ResponseMsg rmsg = new AppResponseMsg();
////
////        PlatOrder platformOrder = orderService.queryPlatOrderByNum(orderBh);
////        if (null != platformOrder) {
////            if (platformOrder.getOzt().equals(OrderStatus.ORDER_BUYER_WATI_PAY)) {
////
//////                orderService.callBackOrder(aliaPay, orderBh, buyerAccount,
//////                        money, sellerAccount, "1", "2");
////                rmsg.setMsg("回调成功");
////                rmsg.setResultCode(ReturnMsg.RTN_0);
////
////
////            } else {
////                rmsg.setMsg("回调失败");
////                rmsg.setResultCode(ReturnMsg.RTN_0);
////
////            }
//////            int sum = orderService.queryRedPIsExit(platformOrder.getId());
//////            if (sum > 0) {
//////                Map<String, String> returnMap = new HashMap<String, String>();
//////                returnMap.put("url", ConfigUtil.getProperties("REDPACKET_URL") + "?orderId=" + platformOrder.getId());
//////                returnMap.put("sum", sum + "");
//////                rmsg.setData(returnMap);
//////            }
////        }
////
////        return rmsg;
////    }
//
//
//    @RequestMapping("getPayWay")
//    @ResponseBody
//    public ReturnMsg queryPayWay() {
//
//
//        return AppResponseMsg.success(orderService.queryPayWay());
//    }
//
//    @RequestMapping(value = "/rechargeCallBack", method = RequestMethod.POST)
//    @ResponseBody
//    @SystemLog(description = "充值回调", ozt = "1")
//    public String rechargeCallBack(HttpServletRequest request, HttpServletResponse response) {
//        String orderid = request.getParameter("orderid");
//        String status = request.getParameter("status");
//        String ordermoney = request.getParameter("ordermoney");
//        String verifystring = request.getParameter("verifystring");
//        String mobileBalance = request.getParameter("mobileBalance");
//
//        String merchantKey = ConfigUtil.getProperties("MERCHANTKEY");
//        String verStr =
//                "orderid=" + orderid + "&status=" + status + "&ordermoney="
//                        + ordermoney + "&merchantKey=" + merchantKey;
//        verStr = KeyedDigestMD5.getKeyedDigest(verStr, "");
//
//        if (verStr.equals(verifystring)) {
//            logger.info("确认充值回调验证码成功，验证码：" + verStr);
////            ResponseMsg rmsg = new AppResponseMsg();
//
//            PlatOrder platformOrder = orderService.queryPlatOrderByNum(orderid);
//            if (null != platformOrder && OrderStatus.ORDER_BUYER_PAY.equals(platformOrder.getOzt())) {
//                orderService.callBackRecharge(orderid, status, ordermoney,
//                        mobileBalance);
//                logger.info("充值回调成功,返回码：" + ReturnMsg.RTN_0);
////                    rmsg.setMsg("充值回调成功,返回码：" + ReturnMsg.RTN_0);
//            }
//        }
//
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//
//            out.println(status);
//            out.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            logger.error("充值回调异常...回写数据失败", e);
//        } finally {
//            if (out != null)
//                out.close();
//        }
//
//        return null;
//    }
//
//
//    @RequestMapping("/paytest")
//    @ResponseBody
//    public ReturnMsg test11() {
////        Main main = new Main();
////        main.test_trade_precreate();
//
//        return AppResponseMsg.success();
//    }
//
//
//    @RequestMapping("getPayCodePic")
//    @ResponseBody
//    public ReturnMsg getPayCodePic(@RequestParam String account, @RequestParam String orderNo, @RequestParam String zffs,
//                                   @RequestParam String type, HttpServletRequest request) {
//        UserFront userFront = baseUserService.getUserFront(account);
//        if (null != userFront) {
//
//            //获取支付金额
//            String money = getOrderPrice(orderNo, zffs);
//            if (money == null) {
//                return AppResponseMsg.faild("订单金额有误");
//            }
//
//            //判断是否已经生产同类型支付图片,避免重复生成
//            String url = null;
//            List<String> urls = new JedisProxy().getJedisProxy(JedisTool.getJedis()).
//                    hmget(ConfigUtil.getProperties("REDIS_PAY_CODE"), orderNo + "_" + zffs);
//            if (null != urls && urls.size() > 0) {
//
//                url = urls.get(0);
//                if (StringUtils.isNotEmpty(url)) {
//                    return AppResponseMsg.success(url);
//                }
//
//            }
//
//            //缓存没有命中,重新生成
//            url = getCodePicByPayWay(zffs, orderNo, money, request.getRemoteAddr(), type);
//            if (StringUtils.isNotEmpty(url)) {
//                return AppResponseMsg.success(url);
//            } else {
//                return AppResponseMsg.faild("生成支付二维码失败");
//            }
//        } else
//
//        {
//            return AppResponseMsg.userFaild();
//        }
//
//    }
//
//
//    public String getCodePicByPayWay(final String zffs, final String orderNo, String money, String ip, String type) {
//
//        String path = null;
//
//        String expireTime;
//
//        //支付宝扫码
//        if (zffs.equals(SysConstance.PayWay.ALI_PAY.getValue())) {
//            if (type.equals(OrderTypeConstance.GROUP_ORDER)) {
//                expireTime = "5m";
//            } else {
//                expireTime = "120m";
//            }
//
//            path = AliPayCodeUtil.trade_precreate(orderNo, money, ConfigUtil.getProperties("ALIPAY_CODE_SUBJECT"),
//                    ConfigUtil.getProperties("ALIPAY_CODE_BODY"), "001", "001", expireTime);
//            logger.info("alipay code create success");
//        }
//        //微信扫码
//        else if (zffs.equals(SysConstance.PayWay.WECHAT_PAY.getValue())) {
//            Date interDate = null;
//            if (type.equals(OrderTypeConstance.GROUP_ORDER)) {
//                interDate = new Date(new Date().getTime() + wechatMinInterTime);
//
//            } else {
//                interDate = new Date(new Date().getTime() + wechatMaxInterTime);
//            }
//
//            expireTime = SimpleThreadLocal.format(interDate, SimpleThreadLocal.dataPattern2);
//            PrepayBean prepayBean = new PrepayBean();
//            prepayBean.setTrade_type("NATIVE");
//            prepayBean.setBody(ConfigUtil.getProperties("WECHAT_CODE_BODY"));
//
//            BigDecimal bigDecimal = new BigDecimal(money);
//
//            prepayBean.setTotal_fee(bigDecimal.multiply(new BigDecimal(100)).intValue() + "");
//            prepayBean.setSpbill_create_ip(ip);
//            prepayBean.setProduct_id("pay");
//            prepayBean.setTime_expire(expireTime);
//            prepayBean.setOut_trade_no(orderNo);
//            // 发送预处理订单请求
//            try {
//                String callbackStr = HttpUtil.sentPostXml(prepayBean.toXml("7"),
//                        ConfigUtil.getProperties("PREPAY_URL"));
//                PrepayCallBackBean prepayCallBackBean = new PrepayCallBackBean();
//                XmlUtil.parseXml(callbackStr, prepayCallBackBean);
//                if (Constance.WECHAT_CODE_SUCCESS.equals(prepayCallBackBean
//                        .getResult_code())) {
//                    path = WxPayCodeUtil.getUrl(prepayCallBackBean.getCode_url());
//
//                } else {
//                    logger.error("微信返回信息:" + callbackStr);
//                    logger.error("err_desc:" + prepayCallBackBean.getErr_code_des());
//                    return null;
//                }
////
//            } catch (Exception e) {
//                logger.error("微信生成二维码支付失败", e);
//            }
//        } else {
//            return null;
//        }
//
//        final String finalPath = path;
//        new JedisProxy().getJedisProxy(JedisTool.getJedis()).hmset(ConfigUtil.getProperties("REDIS_PAY_CODE"), new HashMap<String, String>() {{
//            put(orderNo + "_" + zffs, finalPath);
//        }});
//        return path;
//    }

}