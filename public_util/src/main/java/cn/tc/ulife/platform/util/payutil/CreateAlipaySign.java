package cn.tc.ulife.platform.util.payutil;



import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.util.payutil
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/11/8 0008
 * </p>
 * Time: 下午 5:52
 * </p>
 * Detail:
 * </p>
 */
public class CreateAlipaySign {


    private static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    /**
     * create the order info. 创建订单信息
     */
    private static String getOrderInfo(String subject, String body, String price, String orderNo, String notifyURL) {
        StringBuffer sb = new StringBuffer();

        // 签约合作者身份ID
        sb.append("partner=" + "\"" + AlipayConfig.partner + "\"");

        // 签约卖家支付宝账号
        sb.append("&seller_id=" + "\"" + AlipayConfig.seller_email + "\"");

        // 商户网站唯一订单号
        sb.append("&out_trade_no=" + "\"" + orderNo + "\"");

        // 商品名称
        sb.append("&subject=" + "\"" + subject + "\"");

        // 商品详情
        sb.append("&body=" + "\"" + body + "\"");

        // 商品金额
        sb.append("&total_fee=" + "\"" + price + "\"");

        // 服务器异步通知页面路径
        sb.append("&notify_url=" + "\"" + notifyURL
                + "\"");

        // 服务接口名称， 固定值
        sb.append("&service=\"mobile.securitypay.pay\"");

        // 支付类型， 固定值
        sb.append("&payment_type=\"1\"");

        // 参数编码， 固定值
        sb.append("&_input_charset=\"utf-8\"");

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        sb.append("&it_b_pay=\"30m\"");

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        sb.append("&return_url=\"m.alipay.com\"");

        // 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
        // orderInfo += "&paymethod=\"expressGateway\"";

        return sb.toString();
    }

    private static String sign(String content) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
                     Base64.decode(AlipayConfig.key));
            KeyFactory keyf = KeyFactory.getInstance(AlipayConfig.sign_type);
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update(content.getBytes(AlipayConfig.input_charset));

            byte[] signed = signature.sign();

            return Base64.encode(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 对外生成签名方法,直接生成支付宝签名
     *
     * @param subject
     * @param body
     * @param price
     * @param orderNo
     * @param notifyURL
     * @return
     */
    public static String getSignResult(String subject, String body, String price, String orderNo, String notifyURL) {

        StringBuffer sb = new StringBuffer();
        String orderInfo = CreateAlipaySign.getOrderInfo(subject, body, price, orderNo, notifyURL);
        sb.append(orderInfo);
        String sign = CreateAlipaySign.sign(orderInfo);

        sb.append("&sign=\"");

        try {
            sb.append(URLEncoder.encode(sign, "UTF-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

            return null;

        }
        sb.append("\"&sign_type=\"RSA\"");
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(CreateAlipaySign.getSignResult("hello", "test", "2", "20161111111111111", "http://jzsw.myulife.com.cn/uApp/app/n_order/payCallBack"));
    }

}
