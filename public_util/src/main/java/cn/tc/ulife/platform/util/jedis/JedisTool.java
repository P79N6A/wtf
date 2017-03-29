package cn.tc.ulife.platform.util.jedis;


import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.GsonUtil;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.List;
import java.util.Set;

/**
 * @author wy
 */
public final class JedisTool {


    private static Logger logger = Logger.getLogger(JedisTool.class);

    private static JedisPool jpool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        //连接耗尽时是否阻塞, true 阻塞,直到超时
        config.setBlockWhenExhausted(true);

        config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
        config.setMaxIdle(Integer.valueOf(ConfigUtil
                .getProperties("MaxIdle")));
        config.setMaxWaitMillis(10l);
        config.setTimeBetweenEvictionRunsMillis(100);
        config.setMaxTotal(Integer.valueOf(ConfigUtil
                .getProperties("MaxTotal")));
        config.setTestOnBorrow(true);


        jpool = new JedisPool(config, ConfigUtil.getProperties("JEDIS_IP"),
                Integer.valueOf(ConfigUtil.getProperties("JEDIS_PORT")));

    }

    /**
     * 获取 cn.tc.ulife.platform.util.jedis
     *
     * @return
     */
    public static Jedis getJedis() {
        logger.info("获取redis连接{}");
        Jedis jedis = null;
        try {
            jedis = jpool.getResource();
        } catch (JedisConnectionException e) {
            logger.error("获取redis连接异常{}", e);

        } finally {


            if (jedis == null) {
                logger.info("获取redis连接失败,重试一次{}");
                jedis = jpool.getResource();
                return jedis;
            }
        }

        return jedis;
    }


    /**
     * 释放jedis资源
     *
     * @param jedis
     */
    @SuppressWarnings("deprecation")
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            try {
                logger.info("释放redis连接{}");
                if (jedis.isConnected()) {
                    jpool.returnResource(jedis);
                    logger.info("释放redis连接成功{}");
                }
            } catch (JedisConnectionException e) {
                if (jedis != null) {
                    logger.info("释放redis连接失败,重试一次{}");
                    jpool.returnBrokenResource(jedis);
                }
            }
        }
    }

    public static void put(String key, Object value) {
        Jedis jedis = null;
        try {
            jedis = JedisTool.getJedis();
            jedis.set(key, GsonUtil.objectToJson(value));
        } finally {
            JedisTool.returnResource(jedis);
        }
    }

    public static void put(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = JedisTool.getJedis();
            jedis.set(key, value);
        } finally {
            JedisTool.returnResource(jedis);
        }
    }

    public static void put(String key, Object value, int expritime) {
        Jedis jedis = null;
        try {
            jedis = JedisTool.getJedis();
            jedis.set(key, GsonUtil.objectToJson(value));
            if (-1 != expritime) {
                jedis.expire(key, expritime);
            }

        } finally {
            JedisTool.returnResource(jedis);
        }
    }

    /**
     * @param key
     * @param c
     * @return
     */
    public static <T> T getObject(String key, Class<T> c) {
        Jedis jedis = null;
        try {
            jedis = JedisTool.getJedis();
            if (jedis.exists(key)) {
                String value = jedis.get(key);
                if (null != value) {
                    return GsonUtil.jsonToObject(value, c);
                } else {
                    return null;
                }
            }
//            cn.tc.ulife.platform.util.jedis.set(key,);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JedisTool.returnResource(jedis);
        }
        return null;
    }


    public static String getString(String key) {
        Jedis jedis = null;
        try {
            jedis = JedisTool.getJedis();
            if (jedis.exists(key)) {
                return jedis.get(key);
            }
        } finally {
            JedisTool.returnResource(jedis);
        }
        return null;
    }

    public static List<Object> getList(String key) {
        Jedis jedis = null;
        try {
            jedis = JedisTool.getJedis();
            if (jedis.exists(key)) {
                return GsonUtil.jsonToList(JedisTool.getString(key));
            }
        } finally {
            JedisTool.returnResource(jedis);
        }
        return null;
    }


    public static void rpushMark(String key, int length, int ttl) {
        Jedis jedis = null;
        try {
            jedis = JedisTool.getJedis();
            for (int i = 0; i < length; i++) {
                jedis.lpush(key, i + "");
            }

            jedis.expire(key, ttl);
        } finally {
            JedisTool.returnResource(jedis);
        }
    }

    public static void sadd(String key, String value, int ttl) {
        Jedis jedis = null;
        try {
            jedis = JedisTool.getJedis();
            jedis.sadd(key, value);

            jedis.expire(key, ttl);
        } finally {
            JedisTool.returnResource(jedis);
        }
    }

    public static void srem(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = JedisTool.getJedis();
            jedis.srem(key, value);
        } finally {
            JedisTool.returnResource(jedis);
        }
    }

    public static Set<String> smembers(String key) {
        Jedis jedis = null;
        try {
            jedis = JedisTool.getJedis();
            return jedis.smembers(key);
        } finally {
            JedisTool.returnResource(jedis);
        }

    }

    public static boolean containKey(String key) {
        Jedis jedis = null;
        try {
            jedis = JedisTool.getJedis();
            return jedis.exists(key);

        } finally {
            JedisTool.returnResource(jedis);
        }

    }

//------------------------------------map---------------------

    public static void hset() {

    }

    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        //连接耗尽时是否阻塞, true 阻塞,直到超时
        config.setBlockWhenExhausted(true);

        config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
        config.setMaxIdle(Integer.valueOf("1000"));
        config.setMaxWaitMillis(10l);
        config.setTimeBetweenEvictionRunsMillis(100);
        config.setMaxTotal(Integer.valueOf("1000"));
        config.setTestOnBorrow(true);


        jpool = new JedisPool(config, "192.168.0.253",
                6379);
        Jedis jedis = null;
        try {
            jedis = jpool.getResource();

            jedis.zunionstore("store4", "store1", "store");
        } finally {
            JedisTool.returnResource(jedis);
        }
    }

}
