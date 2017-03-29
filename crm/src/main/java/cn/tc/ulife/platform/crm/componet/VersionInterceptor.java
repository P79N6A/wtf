package cn.tc.ulife.platform.crm.componet;

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
