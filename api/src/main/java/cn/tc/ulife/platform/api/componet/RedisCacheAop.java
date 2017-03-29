package cn.tc.ulife.platform.api.componet;


import cn.tc.ulife.platform.util.jedis.JedisTool;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.componet
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/19 0019
 * </p>
 * Time: 下午 3:36
 * </p>
 * Detail:
 * </p>
 */
@Aspect
@Component
public class RedisCacheAop {


    //    @Around("@annotation(RedisCache)")
    public Object getkey(ProceedingJoinPoint point) throws Throwable {


        Method method = ((MethodSignature) point.getSignature()).getMethod();
        Object target = point.getTarget();
        Method realMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
        RedisCache redisCache = realMethod.getAnnotation(RedisCache.class);

        StringBuffer cacheKey = new StringBuffer();
        cacheKey.append(redisCache.key());
        Class c = ((MethodSignature) point.getSignature()).getReturnType();

        Object value = null;


        switch (redisCache.level()) {
            case 1:
                cacheKey.append(point.getArgs()[0]);
                break;
            default:

                break;
        }
        // 0 单个对象 ， 1：list
        switch (redisCache.dataType()) {
            case 0:
                value = JedisTool.getObject(cacheKey.toString(), c);
                if (null != value) {
                    return value;
                }
                value = point.proceed();
                JedisTool.put(cacheKey.toString(), value, redisCache.expireTime());
                return value;

            case 1:
                List<Object> lists = JedisTool.getList(cacheKey.toString());
                if (null != lists) {
                    return lists;
                }
                value = point.proceed();
                JedisTool.put(cacheKey.toString(), value, redisCache.expireTime());
                return value;

        }

        return null;
    }
}
