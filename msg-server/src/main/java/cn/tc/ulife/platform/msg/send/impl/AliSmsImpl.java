/**
 * 
 */
package cn.tc.ulife.platform.msg.send.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import cn.tc.ulife.platform.msg.http.util.HttpUtils;
import cn.tc.ulife.platform.msg.send.SmsService;
import cn.tc.ulife.platform.msg.send.bean.SmsBean;
import cn.tc.ulife.platform.util.ConfigUtil;

/**
 * @author lpf 阿里短信平台
 */
public class AliSmsImpl implements SmsService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.tc.ulife.platform.msg.send.SmsService#sendSms(int,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public String sendSms(SmsBean sms) {
		// String host = "http://sms.market.alicloudapi.com";
		// String path = "/singleSendSms";
		// String method = "GET";
		Map<String, String> headers = new HashMap<String, String>();
		// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
		// 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", ConfigUtil.getMsgProperties("SMS_ALI_APP_CODE"));
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("ParamString", sms.getTxt());
		querys.put("RecNum", sms.getRecNum());
		querys.put("SignName", sms.getSignName());
		querys.put("TemplateCode", sms.getTempCode());

		try {
			/**
			 * 重要提示如下: HttpUtils请从
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
			 * 下载
			 *
			 * 相应的依赖请参照
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
			 */
			HttpResponse response = HttpUtils.doGet(ConfigUtil.getMsgProperties("SMS_ALI_URL"),
					ConfigUtil.getMsgProperties("SMS_ALI_PATH"), sms.getMethod(), headers, querys);

			JSONObject rsp = new JSONObject(EntityUtils.toString(response.getEntity()));
			if ((boolean) rsp.get("success"))
			{
				return "true";
			}

			// 获取response的body
			// System.out.println(EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
	}

}
