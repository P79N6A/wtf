package cn.tc.ulife.platform.api.base;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;


public class InitServlet extends HttpServlet {

//    Logger loger = LogManager.getLogManager().getOperateLog();

    /**
     *
     */
    private static final long serialVersionUID = -3148547481265407896L;

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws javax.servlet.ServletException if an error occurs
     */
    public void init() throws ServletException {
        getVersion();
//        getWaitOrder();

    }


//    public void getWaitOrder() {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                logger.info("系统启动获取所有未支付订单,置为超时取消");
//                Set<String> orderSet = JedisTool.smembers("waitOrder");
//                OrderService orderService = (OrderService) SpringContextUtil.getBean("oService");
//                orderService.updateWaitOrderByInit(orderSet);
//
//                logger.info("系统启动获取所有已经超出失效拼团活动,进行退单业务处理；");
////                SpeGroupService speGroupService = (SpeGroupService) SpringContextUtil.getBean("speGroupService");
////                Set<String> groupOrderSet = JedisTool.smembers("groupOrder");
////                for (String groupOrder : groupOrderSet) {
////                    String[] str = groupOrder.split("-");
////                    speGroupService.processUserSpeGroupOrder(str[0], str[1]);
////                    JedisTool.srem("groupOrder", str[0] + "-" + str[1]);
////                }
//
//
//            }
//        }).start();
////
////
////            }
////        }).start();
//
////    }

    public void getVersion() {
//        Map<String,String>
//
//        AppService appService = (AppService) SpringContextUtil.getBean("appService");
//        List<AppVersion> iosAppVersions = appService.queryTVersion("1");
//        List<AppVersion> andorAppVersions = appService.queryTVersion("4");
//        Map<String, String> iosMap = new TreeMap<String, String>();
//        Map<String, String> andorMap = new TreeMap<String, String>();
//
//
//        for (AppVersion appVersion : iosAppVersions) {
//            iosMap.put(appVersion.getAPPVR(), appVersion.getALEVE());
////                map.
//        }
//        for (AppVersion appVersion : andorAppVersions) {
//            andorMap.put(appVersion.getAPPVR(), appVersion.getALEVE());
////                map.
//        }
//
//
//        Gson gson = new Gson();
//        String iosString = gson.toJson(iosMap);
//        String andorString = gson.toJson(andorMap);
//        Jedis jedis = null;
//        try {
//            jedis = JedisTool.getJedis();
//            jedis.set("1", iosString);
//            jedis.set("4", andorString);
//        } finally {
//            JedisTool.returnResource(jedis);
//        }

//        Set<Entry<String,String>>entrySet=map.entrySet();
//        for(Entry<String,String>entry:entrySet){            entry.getValue();        }
    }

//    public void getMgc() {
//        Jedis jedis = null;
//        try {
//
//            jedis = JedisTool.getJedis();
//
//            SysMgzBean mgzBean = new SysMgzBean();
//
//            TUserService tuserService = (TUserService) SpringContextUtil
//                    .getBean("tuserService");
//
//            List<SysMgzBean> beans = tuserService.queryMgc(mgzBean);
//
//            if (null != beans) {
//                ListSerializeUtil<SysMgzBean> listSerializeUtil = new ListSerializeUtil<SysMgzBean>();
//                jedis.set("mgc".getBytes(), listSerializeUtil.serialize(beans));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            InitServlet.returnJedis(jedis);
//        }
//
//    }


    public static void main(String[] args) {
        System.out.println((1010 & 1101) != 0);

        System.out.println();

        Map<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("a", "1");
        retMap.put("b", 1);
        if (retMap.get("a").equals(retMap.get("b"))) {
            System.out.println("111");
        }

    }


}
