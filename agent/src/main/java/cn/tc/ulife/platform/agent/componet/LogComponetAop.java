/**
 *
 */
package cn.tc.ulife.platform.agent.componet;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.tc.ulife.platform.util.DateStyle;
import cn.tc.ulife.platform.util.DateUtil;
import cn.tc.ulife.platform.util.GsonUtil;
import cn.tc.ulife.platform.util.logger.LoggerModel;
import cn.tc.ulife.platform.util.logger.UserOperatorFactory;

/**
 * @author wy
 */
@Component
@Aspect
public class LogComponetAop {

    protected Logger logger = Logger.getLogger(LogComponetAop.class);

    // private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    // @Autowired
    // BaseUserService baseUserService;

    /**
     *
     */
    public LogComponetAop() {
        logger.info("我加载了...");
    }

    // //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
    // @Pointcut("execution(* cn.tc.ulife.platform.agent.controller..*(..)) ")
    // public void aspect(){
    //
    // }

    /**
     * param point 切点
     *
     * @return
     * @throws Throwable
     */
    @Around("execution(* cn.tc.ulife.platform.agent.controller..*(..))  ")
    public Object controllerAopLog(ProceedingJoinPoint point) throws Throwable {
        LoggerModel userLog = new LoggerModel();
        // 计时开始
        StopWatch clock = new StopWatch();
        clock.start();
        userLog.setDateTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS));

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();

        ServletRequestAttributes sra = (ServletRequestAttributes) ra;

        // 请求ip
        String requestIp = sra.getRequest().getRemoteAddr();
        // 获取请求地址
        String requestUrl = sra.getRequest().getRequestURI();

        // ApiStatCount.addUrlCount(sra.getRequest());
        // 请求所在类
        String className = point.getSignature().getDeclaringTypeName();

        Method method = ((MethodSignature) point.getSignature()).getMethod();
        // Object target = point.getTarget();
        // Method realMethod = target.getClass().getMethod(method.getName(),
        // method.getParameterTypes());
        SystemLog systemLog = method.getAnnotation(SystemLog.class);

        String description = null;

        if (null != systemLog) {
            description = systemLog.description();

            // ozt = Integer.parseInt(systemLog.ozt());
        }

        Object[] args = point.getArgs();

        Object result;

        String params = GsonUtil.objectToJson(sra.getRequest().getParameterMap());

        Map<String, String[]> map = sra.getRequest().getParameterMap();

        //
        if (null != map && !map.isEmpty()) {
            for (Map.Entry<String, String[]> entry : map.entrySet()) {
                if ("userid".equalsIgnoreCase(entry.getKey())) {
                    userLog.setUid(entry.getValue()[0]);
                    break;
                }
            }
        }
        userLog.setClassName(className);
        userLog.setMainName(method.getName());
        userLog.setParams(params.toString());
        userLog.setOprs(description);
        logger.info("requestUrl:" + requestUrl + "\n" + "requestIp:" + requestIp + "请求参数:" + params.toString());

        try {

            result = point.proceed(args);

        } catch (Exception e) {

            clock.stop();
            // setLog(params.toString(), className, method.getName(),
            // AppResponseMsg.faild(), ozt,
            // e.getMessage(), publicKey, description, requestUrl,
            // requestIp, clock.getTime());
            userLog.setExcMsg(e.toString());
            throw e;
        }
        // 计时结束
        clock.stop();

        // 操作描述
        userLog.setText(GsonUtil.objectToJson(result));
        userLog.setRespTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS));

        // 用户行为日志，记录用户 操作从service到dao 然后返回结果的一个完整事物流程
        UserOperatorFactory.getInstance().writeUserLogger(userLog);
        logger.info(GsonUtil.objectToJson(result) + " 该次请求所用时间为:" + clock.getTime());

        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        // 0 登录 1查询 2添加创建/ 3修改更新 4 删除 5 退出

    }
}
