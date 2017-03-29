/**
 *
 */
package cn.tc.ulife.platform.agent.msg;

/**
 * @author lpf
 */
public interface ReturnMsg {
    /**
     * 成功
     */
    public final String RTN_0 = "0";


    /**
     * 网络异常
     */
    public final String RTN_2 = "2";

    /**
     * 参数为空
     */
    public final String RTN_3 = "3";

    /**
     * 参数不正确
     */
    public final String RTN_4 = "4";

    /**
     * 短信请求次数已经达到3次
     */
    public final String RTN_5 = "5";

    /**
     * 系统异常
     */
    public final String RTN_6 = "6";

    /**
     * 验证码不正确
     */
    public final String RTN_7 = "7";

    /**
     * 验证码超过有效期
     */
    public final String RTN_8 = "8";


    /**
     * 上报失败
     */
    public final String RTN_13 = "13";

    /**
     * 操作失败
     */
    public final String RTN_14 = "14";

    /**
     * 门禁没有授权
     */
    public final String RTN_15 = "15";

    /**
     * 未经授权的请求
     */
    public final String RTN_16 = "16";


    /**
     * 门禁已经注册还未审核
     */
    public final String RTN_18 = "18";


    /**
     * 已经领取过红包
     */
    public final String RTN_21 = "21";

    /**
     * 红包不存在
     */
    public final String RTN_22 = "22";


    /**
     * 版本号过老需要升级
     */
    public final String RTN_99 = "99";

    public final String USER_INVALID = "31";

    public final String SUCCESSS = "0";


    public final String FALID = "6";

    public final String PARAM_IS_NULL = "3";


}
