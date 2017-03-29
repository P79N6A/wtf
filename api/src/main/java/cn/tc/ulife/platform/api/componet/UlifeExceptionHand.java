package cn.tc.ulife.platform.api.componet;


import cn.tc.ulife.platform.api.msg.AppResponseMsg;
import cn.tc.ulife.platform.api.msg.ResponseMsg;
import cn.tc.ulife.platform.api.msg.ReturnMsg;
import cn.tc.ulife.platform.server.exception.PageException;
import cn.tc.ulife.platform.server.exception.VersionException;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.componet
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/1/8 0008
 * </p>
 * Time: 上午 9:40
 * </p>
 * Detail:统一异常处理
 * </p>
 */
@Component
public class UlifeExceptionHand extends SimpleMappingExceptionResolver {

    protected Logger logger = Logger.getLogger(UlifeExceptionHand.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {


//        e.printStackTrace();
        //版本不通过
        if (e instanceof VersionException) {
            return versionHandller(httpServletRequest, httpServletResponse, o, e);
        }
//        // token 验证
//        else if (e instanceof PermissionException) {
//            logger.error("验证失败:", e);
//            return permissionHandller(httpServletRequest, httpServletResponse, o, e);
//        }

        // 自定义
        else if (e instanceof PageException) {

            logger.error("自定义异常:", e);
//
// 微信端错误页面
//            ModelAndView mav = new ModelAndView("");
//
//            //得到错误信息 ,放在页面,或者注释采用固定页面格式
//            mav.addObject("msg", e.getLocalizedMessage());

//            return mav;
            //自定义异常信息返回
            return appHandller(AppResponseMsg.faild(e.getMessage()), httpServletRequest, httpServletResponse, o, e);
        } else if (e instanceof MissingServletRequestParameterException) {
            logger.error("参数为空:", e);
            logger.info(((MissingServletRequestParameterException) e).getParameterName());
//            httpServletRequest
            if (logger.isDebugEnabled()) {
                httpServletResponse.setHeader("null_param", ((MissingServletRequestParameterException) e).getParameterName());
            }
            return appHandller(AppResponseMsg.paramIsNull(), httpServletRequest, httpServletResponse, o, e);
        } else {
            logger.error("突发异常:", e);
            return appHandller(AppResponseMsg.faild(), httpServletRequest, httpServletResponse, o, e);
        }


//        return super.doResolveException(httpServletRequest, httpServletResponse, o, e);
    }


    /**
     * token 验证异常返回
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    private ModelAndView permissionHandller(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ResponseMsg rmsg = new AppResponseMsg();
        rmsg.setMsg("未经授权的请求...token");
        rmsg.setResultCode(ReturnMsg.RTN_16);

        return appHandller(rmsg, httpServletRequest, httpServletResponse, o, e);
    }

    /**
     * 版本异常统一返回
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    private ModelAndView versionHandller(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ResponseMsg rmsg = new AppResponseMsg();
        rmsg.setResultCode(ReturnMsg.RTN_99);
        rmsg.setMsg("您的版本过旧,请更新新版本");

        return appHandller(rmsg, httpServletRequest, httpServletResponse, o, e);
    }


    private ModelAndView appHandller(ResponseMsg rmsg, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView mv = new ModelAndView();

        //设置状态码  200 /防止app端报异常
        httpServletResponse.setStatus(HttpStatus.OK.value());

        //设置ContentType
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);

        //避免乱码
        httpServletResponse.setCharacterEncoding("UTF-8");

        httpServletResponse.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            Gson gson = new Gson();
            String rm = gson.toJson(rmsg);
            httpServletResponse.getWriter().write(rm);
        } catch (Exception io) {
//            io.printStackTrace();
            logger.error("拦截:" + "请求url:" + httpServletRequest.getRequestURI() + "\t 请求ip" + httpServletRequest.getRemoteAddr() + "报错原因", io);
            logger.error("拦截:" + "请求url:" + httpServletRequest.getRequestURI() + "\t 请求ip" + httpServletRequest.getRemoteAddr() + "处理原因", e);
        }
        return mv;
    }
}
