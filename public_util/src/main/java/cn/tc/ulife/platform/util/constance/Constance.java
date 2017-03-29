package cn.tc.ulife.platform.util.constance;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.tc.ulife.platform.util.ConfigUtil;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.util
 * </p>
 * User: wangyue
 * </p>
 * Date: 2015/12/3 0003
 * </p>
 * Time: 下午 2:02
 * </p>
 * Detail: 系统公用常量
 * </p>
 */
public class Constance {

	/**
	 * 微信后台回调成功返回code 成功
	 */
	public static final String WECHAT_CODE_SUCCESS = "SUCCESS";

	/**
	 * 微信后台回调成功返回code 失败
	 */
	public static final String WECHAT_CODE_ERROR = "ERROR";

	/**
	 * 微信后台回调返回消息 msg 成功
	 */
	public static final String WECHAT_MSG_SUCCESS = "成功";

	/**
	 * 微信后台回调返回消息 msg 失败
	 */
	public static final String WECHAT_MSG_ERROR = "成功";

	/**
	 * true
	 */
	public static final String RESP_TRUE = "true";

	/**
	 * false
	 */
	public static final String RESP_FALSE = "false";

	/**
	 * 微信支付
	 */
	public static final String PAY_WAY_WECHAT = "3";

	public static final String DEFAULT_ZERO = "0";

	public static final String DEFAULT_ONE = "1";

	public static final String DEFAULT_TWO = "2";

	public static final String DEFAULT_THREE = "3";

	public static final String SYS_ACCOUNT_DISABLE_STATUS = "1";

	public static final String SYS_ACCOUNT_ENABLE_STATUS = "0";

	public static final String DEFAULT_ENTITY_TABLE = "T_U_BASEUSER";

	public static final String WECHAT_CALLBACK_RETURN = "<xml>\n" + "  <return_code><![CDATA[SUCCESS]]></return_code>\n"
			+ "  <return_msg><![CDATA[OK]]></return_msg>\n" + "</xml>";

	public static final Map<String, String> ztMap = new HashMap<String, String>();

	static {
		ztMap.put("00", "订单完成");
		ztMap.put("01", "退单处理中");
		ztMap.put("11", "等待买家付款");
		ztMap.put("02", "退单处理完成");
		ztMap.put("04", "订单完成 (买家未评价)");
		ztMap.put("12", "买家已付款");
		ztMap.put("13", "买家取消订单(已付款)");
		ztMap.put("14", "买家取消订单(未付款)");
		ztMap.put("15", "买家超时未支付,订单取消");
		ztMap.put("16", "买家拒绝收货");
		ztMap.put("17", "买家申请退货");
		ztMap.put("18", "买家货到付款");
		ztMap.put("21", "卖家已发货");
		ztMap.put("22", "卖家未发货");
		ztMap.put("23", "卖家取消订单,缺货");
		ztMap.put("24", "卖家拒绝退货");
		ztMap.put("31", "小站配货");
		ztMap.put("99", "订单已中止");
	}

	/**
	 * 系统目录
	 */
	public static final String SYS_PATH = null;

	public static final ConcurrentHashMap<String, Object> kMap = new ConcurrentHashMap<String, Object>();

	public static final String SYS_MODULE = "SYSMODULE_XQID_";

	public static final String HARDWARE_CLOUD_APPID = ConfigUtil.getProperties("HARDWARE_CLOUD_APPID");

	public static final String HARDWARE_CLOUD_TOKEN = ConfigUtil.getProperties("HARDWARE_CLOUD_TOKEN");

	// 获取用户 视频对讲账户
	public static final String HARDWARE_CreateAccount = ConfigUtil.getProperties("HARDWARE_CreateAccount");

	/**
	 * 想设备推送消息不放
	 */
	public static final String HARDWARE_SendDeviceInfo_NOBack = ConfigUtil.getProperties("HARDWARE_POST_Data");

	/**
	 * 向硬件云平台绑定设备
	 */
	public static final String HARDWARE_Binding_Device = ConfigUtil.getProperties("HARDWARE_BindingDevice");

}
