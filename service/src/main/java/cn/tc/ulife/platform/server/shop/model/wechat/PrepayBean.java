package cn.tc.ulife.platform.server.shop.model.wechat;


import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.MD5;
import cn.tc.ulife.platform.util.UtilToString;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.model.wechat
 * </p>
 * User: wangyue
 * </p>
 * Date: 2015/12/3 0003
 * </p>
 * Time: 下午 3:13
 * </p>
 * Detail:  微信预处理订单       (未经允许不得修改此类)
 * </p>
 */
public class PrepayBean {

    /**
     * 公众账号ID
     */
    private String appid;

    /**
     * 附加数据，用于返回
     */
    private String attach;

    /**
     * 支付商品描述
     */
    private String body;

    /**
     * 商品详情
     */
    private String detail;

    private String device_info;

    /**
     * 货币类型
     */
    private String fee_type;

    /**
     * 商品标记，代金券或立减优惠功能的参数
     */
    private String goods_tag;

    /**
     * 私钥
     */
    private String key;

    /**
     * 指定支付方式  no_credit
     */
    private String limit_pay;

    /**
     * 商户号
     */
    private String mch_id;

    /**
     * 随机字符串
     */
    private String nonce_str;

    /**
     * 回调地址
     */
    private String notify_url;


    /**
     * 用户微信号
     */
    private String openid;

    /**
     * 本库订单编号
     */
    private String out_trade_no;

    /**
     * 商品id
     */
    private String product_id;


    /**
     * 支付人id
     */
    private String spbill_create_ip;

    /**
     * 订单失效时间
     */
    private String time_expire;

    /**
     * 订单生成时间
     */
    private String time_start;


    /**
     * 总金额
     */
    private String total_fee;


    /**
     * 交易类型
     */
    private String trade_type;

    /**
     * 签名,根据算法
     */
    private String sign;

    public String getFee_type() {
        return fee_type;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public void setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
    }

    public String getAppid() {
        return appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public String getNonce_str() {
        return UtilToString.getRandomString();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }


    /**
     * 通过反射直接转成正确报文
     *
     * @return
     */
    public String toXml(String oly) {
        synchronized (this) {
            if (oly.equals("7")) {
//                this.setAppid(ConfigUtil.getProperties("appid"));
                this.setAppid("wxe6351c3d00bf245e");
//                this.setMch_id(ConfigUtil.getProperties("mch_id"));
                this.setMch_id("1284682501");
            } else {
                this.setAppid(ConfigUtil.getProperties("app_appid"));
                this.setMch_id(ConfigUtil.getProperties("app_mch_id"));
            }
            this.setNonce_str(UtilToString.getRandomString());
            if (this.notify_url == null) {
//                this.setNotify_url(ConfigUtil.getProperties("WX_NOTIFY_URL"));
                this.setNotify_url("http://app.myulife.com.cn/app/n_order/wxPayCallBack");
            }
            String creatSign = UtilToString.getXmlstr(this);
            String key = null;
            if (oly.equals("7")) {
//                key = ConfigUtil.getProperties("key");
                key = "18a97d59889cd26880c59473e391f3dc";
            } else {
                key = ConfigUtil.getProperties("app_key");
            }
            String str = creatSign + "&key=" + key;
            String sign = MD5.cell32(str).toUpperCase();
            this.setSign(sign);
            this.setKey(null);

            return UtilToString.getXml(this);
        }
    }
}

