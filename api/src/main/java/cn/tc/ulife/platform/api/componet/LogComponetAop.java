/**
 *
 */
package cn.tc.ulife.platform.api.componet;


import cn.tc.ulife.platform.util.GsonUtil;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author wy
 */
@Aspect
@Component
public class LogComponetAop {

    protected Logger logger = Logger.getLogger(LogComponetAop.class);


//    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

//    @Autowired
//    BaseUserService baseUserService;

    /**
     *
     */
    public LogComponetAop() {
        logger.info("我加载了...");
    }

    /**
     * param point 切点
     *
     * @return
     * @throws Throwable
     */
    @Around("execution(* cn.tc.ulife.platform.apiserver.*.controller*..*(..))  ")
    public Object controllerAopLog(ProceedingJoinPoint point) throws Throwable {
        //计时开始
        StopWatch clock = new StopWatch();
        clock.start();

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();

        ServletRequestAttributes sra = (ServletRequestAttributes) ra;

        //请求ip
        String requestIp = sra.getRequest().getRemoteAddr();
        // 获取请求地址
        String requestUrl = sra.getRequest().getRequestURI();

//        ApiStatCount.addUrlCount(sra.getRequest());
        // 请求所在类
//        String className = point.getSignature().getDeclaringTypeName();

//        Method method = ((MethodSignature) point.getSignature()).getMethod();
//        Object target = point.getTarget();
//        Method realMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
//        SystemLog systemLog = method.getAnnotation(SystemLog.class);

//        String description = null;
//        int ozt = 0;
//        if (null != systemLog) {
//            description = systemLog.description();
//
//            ozt = Integer.parseInt(systemLog.ozt());
//        }
        logger.info("requestUrl:" + requestUrl + "\n" + "requestIp:" + requestIp);


        Object[] args = point.getArgs();

//        String publicKey = sra.getRequest().getHeader("publicKey");

        Object result;
//        if (requestUrl.endsWith("app/order/getRedView")) {
//
//            result = point.proceed(args);
//            return result;
//        }


        String params = GsonUtil.objectToJson(sra.getRequest().getParameterMap());

//        Map<String, String[]> map = sra.getRequest().getParameterMap();

//        for(map.entrySet():map.entrySet())

//        for (Map.Entry<String, String[]> entry : map.entrySet()) {
//            System.out.println("key:" + entry.getKey() + "-----value:" + entry.getValue()[0]);
//        }
        logger.info("请求参数:" + params.toString());

        try {

            result = point.proceed(args);
        } catch (Exception e) {

            clock.stop();
//            setLog(params.toString(), className, method.getName(), AppResponseMsg.faild(), ozt,
//                    e.getMessage(), publicKey, description, requestUrl,
//                    requestIp, clock.getTime());
            logger.info("请求参数:" + params.toString());
            logger.info("该次请求所用时间为..." + clock.getTime());
            throw e;
        }
        //计时结束
        clock.stop();
//        setLog(params.toString(), className, method.getName(), result, ozt, null,
//                publicKey, description, requestUrl, requestIp, clock.getTime());

        logger.info(GsonUtil.objectToJson(result));
        logger.info("该次请求所用时间为:" + clock.getTime());
        return result;
    }


//    public void setLog(String params, String className, String methodName,
//                       Object result, int czlx, String rdesc, String userName,
//                       String description, String url, String ip, Long responseTime) {
//        try {
//            UserLogBean ulog = new UserLogBean();
//            if (StringUtils.isNotEmpty(userName)) {
//                UserFront userFront = baseUserService.getUserFront(userName);
//                if (null != userFront) {
//                    // 用户id
//                    ulog.setYhid(userFront.getId());
//
//
//                    // 客户端类型
//                    ulog.setKhdlx(userFront.getDtype());
//                }
//            }
//            // 请求ip
//            ulog.setReqIP(ip);
//
//            // 方法描述
//            ulog.setDescription(description);
//            // 相应时间
//            ulog.setResponsetime(responseTime.toString());
//
//            // 请求url
//            ulog.setReqUrl(url);
//
//            // 操作类型
//            ulog.setCzlx(czlx);
//
//            // 操作类
//            ulog.setCzdx(className);
//
//            // 操作函数
//            ulog.setCzhs(methodName);
//
//            ulog.setParam(params);
//
//            ulog.setReqtime(SimpleThreadLocal.format(new Date(), dateFormat));
//
//            if (result instanceof ReturnMsg) {
//                ResponseMsg appResponseMsg = (AppResponseMsg) result;
//                // 返回结果
//                ulog.setRturn(appResponseMsg.getResultCode());
//
//
//                if (null != rdesc) {//NOPMD
//                    // 返回说明
//                    ulog.setRdesc(rdesc);
//                } else {
//                    ulog.setRdesc(appResponseMsg.getMsg());
//                }
//
//            }
//            SysLogThread.getInstance().addTask(ulog);
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("插入日志报异常啦....", e);
//
//        }
//
//    }

    public static void main(String[] args) throws InterruptedException {
        // 0 登录 1查询 2添加创建/ 3修改更新 4 删除 5 退出


    }
}
