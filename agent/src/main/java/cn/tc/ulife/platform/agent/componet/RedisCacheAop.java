package cn.tc.ulife.platform.agent.componet;

import cn.tc.ulife.platform.util.GsonUtil;
import cn.tc.ulife.platform.util.jedis.JedisProxy;
import cn.tc.ulife.platform.util.jedis.JedisTool;
import cn.tc.ulife.platform.util.jedis.RedisCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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


    @Around("@annotation(cn.tc.ulife.platform.util.jedis.RedisCache)")
    public Object redisAop(ProceedingJoinPoint point) throws Throwable {


        Method method = ((MethodSignature) point.getSignature()).getMethod();
        Object target = point.getTarget();
        Method realMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
        RedisCache redisCache = realMethod.getAnnotation(RedisCache.class);

        StringBuffer cacheKey = new StringBuffer();
        cacheKey.append(redisCache.key());


        //方法返回值
        Object value = null;


        String fieldKey = (String) point.getArgs()[0];

        switch (redisCache.level()) {
            case 1:
                cacheKey.append(fieldKey);
                break;
            default:

                break;
        }
        value = getValue(redisCache, cacheKey, value, fieldKey);

        if (null != value) {
            return value;

        }
        value = point.proceed();

        if (null != value) {
            String jsonValue = GsonUtil.objectToJson(value);
            setValueByType(redisCache.getType(), cacheKey.toString(), fieldKey, jsonValue);
        }


        return value;
    }


    private Object getValue(RedisCache redisCache, StringBuffer cacheKey, Object value, String fieldKey) {

        //json串
        String jsonValue = (String) getValueByType(redisCache.getType(), cacheKey.toString(), fieldKey);

        //单个对象
        if (redisCache.returnType() == 0) {

            value = GsonUtil.jsonToObject(jsonValue, redisCache.getClass());

        }
        //list
        else if (redisCache.returnType() == 1) {
            value = GsonUtil.jsonToList(jsonValue);
        }
        return value;
    }

    public Object getValueByType(String getType, String cacheKey, String fieldKey) {


        //  字符串
        if ("0".equals(getType)) {
            return new JedisProxy().getJedisProxy(JedisTool.getJedis()).get(cacheKey);
        } else if ("1".equals(getType)) {

        } else if ("2.".equals(getType)) {

            return new JedisProxy().getJedisProxy(JedisTool.getJedis()).hmget(cacheKey, fieldKey);
        } else if ("3".equals(getType)) {

        }
        return null;

    }

    public void setValueByType(String getType, String cacheKey, final String fieldKey, final String value) {

        //  字符串
        if ("0".equals(getType)) {
            new JedisProxy().getJedisProxy(JedisTool.getJedis()).set(cacheKey, value);
        } else if ("1".equals(getType)) {

        } else if ("2.".equals(getType)) {
            Map fieldMap = new HashMap() {
                {
                    put(fieldKey, value);
                }
            };
            new JedisProxy().getJedisProxy(JedisTool.getJedis()).hmset(cacheKey, fieldMap);
        } else if ("3".equals(getType)) {

        }

    }
}
