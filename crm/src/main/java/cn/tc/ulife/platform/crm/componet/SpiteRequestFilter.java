package cn.tc.ulife.platform.crm.componet;

import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.jedis.JedisTool;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * @author wy
 */
public class SpiteRequestFilter implements Filter {


    private static final String datePattern = "yyyy-MM-dd HH:mm:ss";

    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<Long>> map = new ConcurrentHashMap<String, CopyOnWriteArrayList<Long>>();

    private static final int MAX_COUNT = Integer.parseInt(ConfigUtil
            .getProperties("MAX_COUNT"));

    private static final int OUT_TIME = Integer.parseInt(ConfigUtil
            .getProperties("OUT_TIME"));

    protected static Logger logger = Logger.getLogger(SpiteRequestFilter.class);

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        logger.info("spite destroy ......");
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Long times = null;
        try {

            times = SimpleThreadLocal.parse(SimpleThreadLocal.format(new Date(), datePattern), datePattern).getTime();
        } catch (ParseException e) {
            logger.error("时间戳转换失败..", e);

        }
        // String ip = req.getRemoteAddr();

        HttpServletRequest servletRequest = (HttpServletRequest) request;

        String ip = RequestUtil.getIp(servletRequest);


        String requestUrl = req.getRequestURI();
        // 通过对IP ，url 和当前时间（精确到秒） ，得出唯一key
        String userIP = ip + requestUrl + times;

        // 把该次请求放入map中
        increment(userIP);

        // 判断本次请求是否超过请求最大数限制
        if (isUpCount(userIP)) {
            logger.debug("ip:" + ip + "," + "url  filter :" + requestUrl);
            Jedis jedis = null;
            try {
                jedis = JedisTool.getJedis();
                jedis.setex(ip, OUT_TIME, requestUrl);
            } catch (Exception e) {
                logger.error("判断请求次数失败", e);
            } finally {
//                InitServlet.returnJedis(jedis);
                JedisTool.returnResource(jedis);
            }
            // 403
//			((HttpServletResponse) response)
//					.sendError(HttpServletResponse.SC_FORBIDDEN);
//
//			return;
        }

        chain.doFilter(request, response);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        new Thread(new cleanMapThread()).start();
    }

    private void increment(String key) {
        CopyOnWriteArrayList<Long> list = map.get(key);
//        synchronized (map) {
        if (list == null) {
            map.put(key, new CopyOnWriteArrayList<Long>());
        }
//        }
        map.get(key).add(System.currentTimeMillis());

    }

    private boolean isUpCount(String key) {

        CopyOnWriteArrayList<Long> list = map.get(key);
        if (list == null) {
            return false;
        }

        return list.size() > MAX_COUNT;
    }


    private static class cleanMapThread implements Runnable {

        @Override
        public void run() {
            while (true) {

                try {
                    Thread.sleep(60000L);

                    for (String key : map.keySet()) {

                        CopyOnWriteArrayList<Long> list = map.get(key);

                        for (Long time : list) {
                            list.remove(time);
                        }

                    }
                } catch (InterruptedException e) {

//                    e.printStackTrace();
                    logger.error("清除缓存map失败..", e);
                }
            }
        }

    }

}
