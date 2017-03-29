/**  
 * @Title:  ConstantUtil.java
 * @Package cn.tc.ulife.userver.util
 * @Description: 常量工具
 * @author cxs
 * @date  2016-8-13 下午3:02:42
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * ****************************************************
 */
package cn.tc.ulife.platform.util;

/**
 * @ClassName: ConstantUtil
 * @Description: 常量工具
 * @author cxs
 * @date 2016-8-13 下午3:02:42
 *
 */
public class ConstantUtil {

	//支付宝
    public static String ALI_PAY="2";
    //微信
    public static String WECHAT_PAY="3";
    //货到付款
    public static String DELIVERY_PAY="10";

    
    public enum PayWay {
        //支付宝
        ALI_PAY("2"),
        //微信
        WECHAT_PAY("3"),
        //货到付款
        DELIVERY_PAY("10");

        private String value;

        private PayWay(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


    /**
     * 客服账号已经新建，但是没有启用,无权限进行操作
     */
    public static final String ACCOUT_CREATE = "0";


    /**
     * 客服账号正常状态,有权限在本系统进行流程性操作
     */
    public static final String ACCOUNT_NORMAL = "1";


    /**
     * 客服账号在库里已有数据,但已被停用.
     */
    public static final String ACCOUT_STOP = "2";


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

    
}
