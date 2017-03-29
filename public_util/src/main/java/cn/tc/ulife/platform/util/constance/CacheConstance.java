package cn.tc.ulife.platform.util.constance;


import cn.tc.ulife.platform.util.GsonUtil;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.util
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/19 0019
 * </p>
 * Time: 下午 3:16
 * </p>
 * Detail:
 * </p>
 */
public class CacheConstance {


    /**
     * 对应商品key
     */
    public static final String COMMODITY_KEY = "commodity_";

    /**
     * 支付方式key
     */
    public static final String PAYMENT_KEY = "payment";

    /**
     * 默认小区 key
     */
    public static final String DEFAULT_COMMUNITY = "community";


    public static final String USER_STORE_KEY = "user:store";


    public static final String USER_PROPERTY_KEY = "user:property";

    public static final String USER_STATION_KEY = "user:station";


    public static final String USER_NATURAL_KEY = "user:natural";

    public static final String USER_AGENT_KEY = "user:agent";

    public static final String USER_INFO_KEY = "user:info";

    public static final String USER_MENU_KEY = "user:menu";

    public static void main(String[] args) {
        String s = "12";
        System.out.println(GsonUtil.jsonToObject(GsonUtil.objectToJson(s), String.class));
        System.out.println(GsonUtil.objectToJson(s));
    }
}
