package cn.tc.ulife.platform.server.datesouce;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with springmvc.
 * </p>
 * PackageName:cn.njtc.ulife.api.aop
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/7 0007
 * </p>
 * Time: 下午 5:08
 * </p>
 * Detail:
 * </p>
 */
public class DateSourceAspect {


//        Logger logger = LogManager.getLogManager().getRunLog();
//    Logger logger = Logger.getLogger(this.getClass());

    Logger logger = Logger.getLogger(DateSourceAspect.class);
    /**
     * 缓存
     */
    private static ConcurrentHashMap<String, Boolean> methodIsReadCache = new ConcurrentHashMap<String, Boolean>();

//    private Logger logger =logm

    /**
     * 决策是否只读
     *
     * @param pjp 织入点
     * @return 方法执行结果
     * @throws Throwable
     */
    public Object determineReadOrWriteDB(ProceedingJoinPoint pjp) throws Throwable {


        logger.debug("决策使用数据库类型...");
        StopWatch clock = new StopWatch();
        clock.start();

        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        Object target = pjp.getTarget();
        String cacheKey = target.getClass().getName() + "." + method.getName();


        Boolean isReadCacheValue = methodIsReadCache.get(cacheKey);

        logger.debug("方法：" + cacheKey + "是否只读:" + isReadCacheValue);

        if (isReadCacheValue == null) {


            // 重新获取方法，否则传递的是接口的方法信息
            Method realMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());

            logger.debug(cacheKey + "---首次决策是否只读....");

            isReadCacheValue = isChoiceReadDB(realMethod);

            logger.debug(cacheKey + "---决策成功...." + isReadCacheValue);

            methodIsReadCache.put(cacheKey, isReadCacheValue);
        }

        if (isReadCacheValue) {

            logger.debug(cacheKey + "切换读库");

            DynamicDataSourceHolder.markRead();
        } else {

            logger.info(cacheKey + "切换写库");

            DynamicDataSourceHolder.markWrite();
        }
        clock.stop();
        logger.debug("切库时间......" + clock.getTime());
        try {

            logger.debug("切库成功,进行正常业务流程操作....");

            return pjp.proceed();
        } finally {
            DynamicDataSourceHolder.reset();


        }
    }

    /**
     * 判断是否只读方法
     *
     * @param method 执行方法
     * @return 当前方法是否只读
     */
    private boolean isChoiceReadDB(Method
                                           method) {
        Transactional transactionalAnno = AnnotationUtils.findAnnotation(method, Transactional.class);
        if (transactionalAnno == null) {

            return true;
        }
        // 如果之前选择了写库，则现在还选择写库
        if (DynamicDataSourceHolder.isChoiceWrite()) {
            return false;
        }
        if (transactionalAnno.readOnly()) {
            return true;
        }
        return false;
    }
}
