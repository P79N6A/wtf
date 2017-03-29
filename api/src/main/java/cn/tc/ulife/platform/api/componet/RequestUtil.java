package cn.tc.ulife.platform.api.componet;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.cn.componet
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/7/22 0022
 * </p>
 * Time: 下午 4:11
 * </p>
 * Detail:
 * </p>
 */
public final class RequestUtil {


    /**
     * 获取不同来源真实ipo
     *
     * @param servletRequest
     * @return
     */
    public static String getIp(final HttpServletRequest servletRequest) {

        String ip = servletRequest.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = servletRequest.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = servletRequest.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = servletRequest.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = servletRequest.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = servletRequest.getRemoteAddr();
        }

        return ip;
    }
}
