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
 * Detail: app端调起支付所需字段(签名已生成,客户端直接取用)
 * </p>
 */
public class CallOrderBean extends CallOrderModel {

    /**
     * 公众号id
     */
    private String appid;

    /**
     * 随机字符串
     */
    private String noncestr;

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

    /**
     * 时间
     */
    private Long timestamp;

    /**
     * 私钥(服务端拥有,不应返回客户端)
     */
    private String key;

    /**
     * 签名
     */
    private String sign;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
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

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


    public CallOrderBean toBean() {
        this.setAppid(ConfigUtil.getProperties("app_appid"));
        this.setPartnerid(ConfigUtil.getProperties("app_mch_id"));
        this.setNoncestr(UtilToString.getRandomString());
        this.setTimestamp(System.currentTimeMillis() / 1000);
        this.setPackageValue("Sign=WXPay");
//        this.setPackageValue("prepay_id=" + this.getPrepayid());
        String creatSign = UtilToString.getXmlstr(this);
        String str = creatSign + "key=" + ConfigUtil.getProperties("app_key");
        String sign = MD5.cell32(str).toUpperCase();
        this.setSign(sign);
        this.setKey(null);
        return this;
    }


    public static void main(String[] args) {
        String s = "56G1KMQSG8EAKI3HMPPWJ77S";
//4215   57
        System.out.println(UtilToString.getRandomString());

    }
}
