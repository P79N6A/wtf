package cn.tc.ulife.platform.api.componet;

import cn.tc.ulife.platform.server.exception.VersionException;
import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.jedis.JedisTool;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.componet
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/1/7 0007
 * </p>
 * Time: 下午 2:07
 * </p>
 * Detail:
 * </p>
 */
public class VersionInterceptor extends HandlerInterceptorAdapter {

    protected Logger logger = Logger.getLogger(VersionInterceptor.class);

    private static String turnOncheck = ConfigUtil.getProperties("turnOncheck");


    public VersionInterceptor() {
        logger.debug("注入失败");
    }



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //验证url

        String requestUrl = request.getRequestURI();
        if (requestUrl.endsWith("/taken") || requestUrl.endsWith("app/appvr") || requestUrl.endsWith("app/order/wxPayCallBack") || requestUrl.endsWith("app/order/payCallBack") || requestUrl.endsWith("app/order/getRedView")) {
            return true;
        }
        if (request.getHeader("X-Requested-With") != null) {
            return true;
        }
        //验证版本
        if (Boolean.parseBoolean(turnOncheck)) {
            if (!isVersion(request)) {
                throw new VersionException();
            }
        }
        return true;
    }


    public boolean isVersion(HttpServletRequest request) {
//        String version = null;
//        String app = null;
//        try {
//
//            version = request.getHeader("version");
//            app = request.getHeader("app");
//        } catch (Exception e) {
//            logger.error("错误原因为版本过老,消息头没有版本和类型", e);
//            //todo 你的版本太老了,拒绝访问
//            return false;
//        }
//        if (version == null || app == null) {
//            logger.info("app:" + app + ",version:" + version);
//            return false;
//        }
//        //表示微信 不予判断
//        if (app.equals("7")) {
//            return true;
//        }
////        synchronized (this) {
//        Jedis jedis = null;
//        try {
//            jedis = JedisTool.getJedis();
//            String versionJson = jedis.get(app);
//            if (null == versionJson) {
//
////            }
////            } else {
//                //TODO             防止初始化失败,自动重试   |目前不需要
//                List<AppVersion> iosAppVersions = appService.queryTVersion("1");
//                List<AppVersion> andorAppVersions = appService.queryTVersion("4");
//                Map<String, String> iosMap = new TreeMap<String, String>();
//                Map<String, String> andorMap = new TreeMap<String, String>();
//
//
//                for (AppVersion appVersion : iosAppVersions) {
//                    iosMap.put(appVersion.getAPPVR(), appVersion.getALEVE());
////                map.
//                }
//                for (AppVersion appVersion : andorAppVersions) {
//                    andorMap.put(appVersion.getAPPVR(), appVersion.getALEVE());
////                map.
//                }
//
//
//                Gson gson = new Gson();
//                String iosString = gson.toJson(iosMap);
//                String andorString = gson.toJson(andorMap);
//                jedis.set("1", iosString);
//                jedis.set("4", andorString);
//                versionJson = jedis.get(app);
//            }
//
//            Gson gson = new Gson();
//            TreeMap<String, String> treeMap = gson.fromJson(versionJson, TreeMap.class);
//            if (treeMap.containsKey(version)) {
//                if (version.equals(treeMap.lastKey())) {
//
//                    return true;
//                }
//            } else {
//
//
//                Set<String> set = treeMap.keySet();
//
//                for (String versionKey : set) {
//                    if (Integer.parseInt(versionKey) > Integer.parseInt(version)) {
//                        if ("1".equals(treeMap.get(versionKey))) {
//                            return false;
//                        }
//
//                    }
//                }
//                return true;
//                //                }
//
//
//            }
//
//        } catch (Exception e) {
//            logger.error("判断版本错误", e);
//            return false;
//        } finally {
//            JedisTool.returnResource(jedis);
//        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(Boolean.parseBoolean("true"));
        Jedis jedis = JedisTool.getJedis();
        String versionJson = jedis.get("4");
        System.out.println(versionJson);
//        Gson gson = new Gson();


//      TreeMap<String, String> treeMap = gson.fromJson(versionJson, TreeMap.class);


    }
}
