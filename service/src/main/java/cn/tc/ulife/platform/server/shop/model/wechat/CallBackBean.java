package cn.tc.ulife.platform.server.shop.model.wechat;


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
 * Time: 下午 2:18
 * </p>
 * Detail: 微信回调解析对象(app支付后,微信端返回支付信息)
 * </p>
 */
public class CallBackBean {


    /**
     * 返回消息
     */
    private String return_msg;


    /**
     * SUCCESS/FAIL  success 的时候返回下面字段
     */
    private String return_code;


    /**
     * SUCCESS/FAIL  业务结果
     */
    private String result_code;

    /**
     * 微信分配的公众账号ID（企业号corpid即为此appId）
     */
    private String appid;

    /**
     * 商家数据包，原样返回
     */
    private String attach;

    /**
     * 微信支付分配的终端设备号
     */
    private String device_info;

    /**
     * 签名
     */
    private String sign;


    /**
     * e:SYSTEMERROR
     * 错误返回的信息描述
     */
    private String err_code;

    /**
     * e: 系统错误
     * 错误返回的信息描述
     */
    private String err_code_desc;

    /**
     * 用户在商户appid下的唯一标识
     */
    private String openid;

    /**
     * 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     */
    private String is_subscribe;

    /**
     * JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付
     */
    private String trade_type;

    /**
     * 银行类型，采用字符串类型的银行标识
     */
    private String bank_type;

    /**
     * 订单总金额，单位为分
     */
    private String total_fee;

    /**
     * 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY
     */
    private String fee_type;

    /**
     * 现金支付金额订单现金支付金额
     */
    private String cash_fee;

    /**
     * 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，
     */
    private String cash_fee_type;

    /**
     * 代金券或立减优惠金额<=订单总金额，订单总金额-代金券或立减优惠金额=现金支付金额
     */
    private String coupon_fee;

    /**
     * 代金券或立减优惠使用数量
     */
    private String coupon_count;

    /**
     * 代金券或立减优惠ID,$n为下标，从0开始编号
     */
    private String coupon_id_$n;

    /**
     * 单个代金券或立减优惠支付金额,$n为下标，从0开始编号
     */
    private String coupon_fee_$n;

    /**
     * SUCCESS/FAIL
     */
    private String mch_id;

    /**
     * 随机字符串，不长于32位
     */
    private String nonce_str;

    /**
     * 商户系统的订单号，与请求一致。
     */
    private String out_trade_no;


    private String sub_mch_id;

    /**
     * 支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其
     */
    private String time_end;

    /**
     * 微信支付订单号
     */
    private String transaction_id;


    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_desc() {
        return err_code_desc;
    }

    public void setErr_code_desc(String err_code_desc) {
        this.err_code_desc = err_code_desc;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getCash_fee() {
        return cash_fee;
    }

    public void setCash_fee(String cash_fee) {
        this.cash_fee = cash_fee;
    }

    public String getCash_fee_type() {
        return cash_fee_type;
    }

    public void setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
    }

    public String getCoupon_fee() {
        return coupon_fee;
    }

    public void setCoupon_fee(String coupon_fee) {
        this.coupon_fee = coupon_fee;
    }

    public String getCoupon_count() {
        return coupon_count;
    }

    public void setCoupon_count(String coupon_count) {
        this.coupon_count = coupon_count;
    }

    public String getCoupon_id_$n() {
        return coupon_id_$n;
    }

    public void setCoupon_id_$n(String coupon_id_$n) {
        this.coupon_id_$n = coupon_id_$n;
    }

    public String getCoupon_fee_$n() {
        return coupon_fee_$n;
    }

    public void setCoupon_fee_$n(String coupon_fee_$n) {
        this.coupon_fee_$n = coupon_fee_$n;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }


    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
