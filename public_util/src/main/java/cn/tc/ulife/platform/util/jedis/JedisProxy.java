package cn.tc.ulife.platform.util.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.cn.componet.jedis
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/8/25 0025
 * </p>
 * Time: 下午 4:12
 * </p>
 * Detail:
 * </p>
 */
public class JedisProxy implements InvocationHandler {

    private Object object;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        Jedis jedis = (Jedis) object;
        try {
            result = method.invoke(jedis, args);
        } finally {
            JedisTool.returnResource(jedis);
        }

        return result;
    }

    /**
     * 获取jedis代理对象,避免每次操作时手动关闭连接池
     *
     * @param jedis
     * @return
     */
    public JedisCommands getJedisProxy(Object jedis) {
        this.object = jedis;
        return (JedisCommands) Proxy.newProxyInstance(jedis.getClass().getClassLoader(), jedis.getClass().getInterfaces(), this);
    }

    public JedisCommands getJedisProxy() {
        return new JedisProxy().getJedisProxy(JedisTool.getJedis());
    }
}