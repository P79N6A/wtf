package cn.tc.ulife.platform.util.jedis;



import cn.tc.ulife.platform.util.localthread.SimpleThreadLocal;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.util.jedis
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/8/25 0025
 * </p>
 * Time: 上午 10:46
 * </p>
 * Detail:
 * </p>
 */
public class ApiStatCount {

    private static final String urlKey = "count:api:url:date";

    private static final String userLoginKey = "count:user:login:date";

    private static final String keyDatePattern = "yyyy-MM-dd ";


    public static void addUserLoginByDate(String account) {
        new  JedisProxy().getJedisProxy(JedisTool.getJedis()).hincrBy(userLoginKey + ":" + SimpleThreadLocal.format(new Date(), keyDatePattern), account, 1L);

    }

    public static boolean userIsLoginByDate(String account) {

        return new  JedisProxy().getJedisProxy(JedisTool.getJedis()).hexists(userLoginKey + ":" + SimpleThreadLocal.format(new Date(), keyDatePattern), account);
    }


    public static void addUrlCount(HttpServletRequest request) {
        String url = request.getRequestURI();
        new  JedisProxy().getJedisProxy(JedisTool.getJedis()).hincrBy(urlKey + ":" + SimpleThreadLocal.format(new Date(), keyDatePattern), url, 1L);
    }


    //慎用|仅供内部测试使用
    public static Map<String, String> getUrlCount(int sort) {

        //0升序 1降序
        ValueSortComparator valueSortComparator = new ValueSortComparator(new  JedisProxy().getJedisProxy(JedisTool.getJedis()).hgetAll(urlKey), sort);
        Map<String, String> treeMap = new TreeMap<String, String>(valueSortComparator);
        treeMap.putAll(new  JedisProxy().getJedisProxy(JedisTool.getJedis()).hgetAll(urlKey));
        return treeMap;
    }

    public static void main(String[] args) {
//        System.out.println(jedis);
//        jedis.hincrBy(urlKey, "aaa", 1L);
//        jedis.hincrBy(urlKey, "bbb", 2L);
//        jedis.hincrBy(urlKey, "ccc", 23L);
//
//        System.out.println(getUrlCount(1));
//        sortm resultMap= new SortedMap() {
//        }getUrlCount();l

//        resultMap.putAll();
//        System.out.println(resultMap);

        new  JedisProxy().getJedisProxy(JedisTool.getJedis()).get("a");


        System.out.println(userIsLoginByDate("11"));
    }


    static class ValueSortComparator implements Comparator<String> {

        Map<String, String> treeMap;

        int order;

        public ValueSortComparator(Map<String, String> treeMap, int order) {
            this.treeMap = treeMap;
            this.order = order;
        }


        @Override
        public int compare(String o1, String o2) {
            if (order == 0) {

                if (Integer.parseInt(treeMap.get(o1)) <= Integer.parseInt(treeMap.get(o2))) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                if (Integer.parseInt(treeMap.get(o1)) >= Integer.parseInt(treeMap.get(o2))) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }


}
