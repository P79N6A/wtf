/**
 *
 */
package cn.tc.ulife.platform.agent.componet;

import cn.tc.ulife.platform.util.jedis.JedisTool;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author wy
 */
public class IpFilter implements Filter {

    protected Logger logger = Logger.getLogger(IpFilter.class);

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        logger.info("destroy ...");
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


        HttpServletRequest servletRequest = (HttpServletRequest) request;
        // String requestIp = request.getRemoteAddr();

        String ip = RequestUtil.getIp(servletRequest);
        logger.info(ip);
        Jedis jedis = null;
        try {
            jedis = JedisTool.getJedis();
            if (jedis.exists(ip)) {
//                chain.doFilter(request, response);
                logger.info("ip filter ");
            } else {
//                chain.doFilter(request, response);

//				System.out.println("ip filter ");
//				// 403错误
//                ((HttpServletResponse) response)
//                        .sendError(HttpServletResponse.SC_FORBIDDEN);

//				RequestDispatcher dispatcher  = servletRequest.getRequestDispatcher("app/");


            }
        } catch (Exception e) {
            logger.error("IPFILETER 拦截失败:", e);
        } finally {
//            InitServlet.returnJedis(jedis);
            JedisTool.returnResource(jedis);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init....");
    }


}
