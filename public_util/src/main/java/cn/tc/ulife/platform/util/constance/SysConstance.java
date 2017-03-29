package cn.tc.ulife.platform.util.constance;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.util
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/7 0007
 * </p>
 * Time: 上午 10:06
 * </p>
 * Detail:
 * </p>
 */
public enum SysConstance {
    /**
     * 系统角色变量
     */

    ADMIN("ADMIN"),//管理员
    DLS("DLS"),    //代理商
    SJGLY("SJGLY"),   //商家
    XZGLY("XZGLY"),         //小站
    WYGLY("WYGLY"),     //物业
    CGGLY("CGGLY"),     //采购
    CWGLY("CWGLY"),
    GYS("GYS"),
    FJZX("FJZX"),
    USER("USER"),   // 普通用户

    DEFAULT_NULL(null);

    private String value;


    private SysConstance(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * 积分获取类型常量
     */
    public enum IntegralGetType {
        REGISTER("0"),
        LOGIN("1"),
        UPDATE_DATA("2"),

        BUY("3"),

        RETURN("4"),

        SIGN("1");

        private String value;

        private IntegralGetType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 前端请求类型常量
     */
    public enum RequestOly {

        Android("1"), ios("2"), Wechat("3"), CRM("0");

        private String value;

        private RequestOly(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    /**
     * 前端请求类型常量
     */
    public enum RegistUser {

    	// PC后台开户   auto 用户主动注册
        PC("1"),  Auto("0");

        private String value;

        private RegistUser(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    /**
     * 前端请求类型常量
     */
    public enum APPType {

    	IOS_PAD("2"), Android("4"), ios("1"), Wechat("7"), PC("6"),Android_PAD("3"),U9("5");     
        private String value;

        private APPType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 验证码请求类型常量
     */
    public enum SmsCodeGet {

        REGIST("0"), UPDATE("1");

        private String value;

        private SmsCodeGet(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 是否是第三方账号
     */
    public enum IsThirdAccount {

        YES("0"), NO("1");

        private String value;

        private IsThirdAccount(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum UploadPath {

        OTHER_PATH("other"), SOCIAL_PATH("social"), MALL_PATH("mall");

        private String value;

        private UploadPath(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


    public enum PayWay {
        //支付宝
        ALI_PAY("2"),
        //微信
        WECHAT_PAY("3"),
        //货到付款
        DELIVERY_PAY("10"),

        DEFAULT_PAY("10");

        private String value;

        private PayWay(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum PayStatus {
        //已付款
        PAY_SUCCESS("0"),
        //支付失败
        PAY_ERROR("1"),
        //等待支付
        PAY_WAIT("2"),
        //支付结束(最终状态)
        PAY_FINISH("3"),
        //线下支付
        PAY_LINE("4");

        private String value;

        private PayStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum OrderStatus {
        /**
         * 订单完成 (卖家已发货，买家已确认收货)
         */
        ORDER_SUCCESS("00"),

        /**
         * 退单处理中
         */
        ORDER_RETURN("01"),

        /**
         * 退单处理完成
         */
         ORDER_RETURN_SUCCESS("02"),


        /**
         * 订单完成 (卖家已发货，客服已确认收货  )
         */
        ORDER_SUCCESS_ASSESS("04"),

        /**
         * 订单终止(异常)
         */
        ORDER_ERROR("99"),

        /**
         * 拒绝退货
         */
        ORDER_RETURN_REFUSE("77"),

        // ----------------------------买家 开头为1 -------------------------------

        /**
         * 等待买家付款
         */
        ORDER_BUYER_WATI_PAY("11"),

        /**
         * 买家已付款
         */
        ORDER_BUYER_PAY("12"),

        /**
         * 买家取消订单(已付款)
         */
        ORDER_BUYER_CANCEL_Y("13"),

        /**
         * 买家取消订单(未付款)
         */
        ORDER_BUYER_CANCEL_N("14"),

        /**
         * 买家订单超时未支付，订单取消
         */
        ORDER_BUYER_TIME_OUT("15"),

        /**
         * 买家拒绝收货
         */
        ORDER_BUYER_REFUSE("16"),

        /**
         * 买家申请退货
         */
        ORDER_BUYER_REFUSE_SP("17"),

        /**
         * 货到付款
         */
        ORDER_BUYER_COD("18"),

        // ----------------卖家为 2 -----------------------------

        /**
         * 卖家已发货
         */
        ORDER_SELLER_Send_Y("21"),

        /**
         * 卖家未发货
         */
        ORDER_SELLER_Send_N("22"),

        /**
         * 卖家取消订单 ，缺货
         */
        ORDER_SELLER_CANCEL("23"),

        /**
         * 卖家拒绝退货
         */
        ORDER_SELLER_REFUSE("24"),

        //------------------小站3 ---------------------

        /**
         *  小站配货
         */
        ORDER_XZ_SEND("31");

        private String value;

        private OrderStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


    public enum CheckStockType {
        //购买
        BUY("0"),

        //回归
        RETURN("1");

        private String value;

        private CheckStockType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}

