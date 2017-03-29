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
 * Date: 2015/12/4 0004
 * </p>
 * Time: 上午 9:34
 * </p>
 * Detail: 网页端调起支付所需字段(签名已生成,客户端直接取用)
 * </p>
 */
public class CallOrderJsBean extends CallOrderModel {

    /**
     * 公众号id
     */
    private String appId;

    /**
     * 随机字符串
     */
    private String nonceStr;

    /**
     * 默认值
     */
    private String packageValue;

    /**
     * 商户号
     */
    private String partnerid;


    /**
     * 预支付id (微信返回)
     */
    private String prepayid;

    private String signType;
    /**
     * 时间
     */
    private Long timeStamp;


    /**
     * 私钥(服务端拥有,不应返回客户端)
     */
    private String key;

    /**
     * 签名
     */
    private String paySign;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    public CallOrderJsBean toBean() {
        this.setAppId(ConfigUtil.getProperties("appid"));
//        this.setPartnerid(ConfigUtil.getProperties("mch_id"));
        this.setNonceStr(UtilToString.getRandomString());
        this.setTimeStamp(System.currentTimeMillis() / 1000);
        this.setSignType("MD5");
//        this.setPackageValue("Sign=WXPay");
        this.setPackageValue("prepay_id=" + this.getPrepayid());
        this.setPrepayid(null);
        String creatSign = UtilToString.getXmlstr(this);
        String str = creatSign + "key=" + ConfigUtil.getProperties("key");
        String sign = MD5.cell32(str).toUpperCase();
        this.setPaySign(sign);
        this.setKey(null);
        return this;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }

    public static void main(String[] args) {
        String s = "56G1KMQSG8EAKI3HMPPWJ77S";
//4215   57
        System.out.println(UtilToString.getRandomString());

    }
}
