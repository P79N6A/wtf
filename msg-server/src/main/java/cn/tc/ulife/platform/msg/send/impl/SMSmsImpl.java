/**
 * 
 */
package cn.tc.ulife.platform.msg.send.impl;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import cn.tc.ulife.platform.msg.http.util.HttpUtils;
import cn.tc.ulife.platform.msg.send.SmsService;
import cn.tc.ulife.platform.msg.send.bean.SmsBean;
import cn.tc.ulife.platform.util.ConfigUtil;

/**
 * @author lpf 圣美短信平台
 */
public class SMSmsImpl implements SmsService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.tc.ulife.platform.msg.send.SmsService#sendSms(int,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public String sendSms(SmsBean sms) {

		StringBuilder params = new StringBuilder();
		params.append("&username=").append(ConfigUtil.getMsgProperties("SMS_SM_USERNAME"));
		params.append("&password=").append(ConfigUtil.getMsgProperties("SMS_SM_PWD"));
		params.append("&veryCode=").append(ConfigUtil.getMsgProperties("SMS_SM_veryCode"));
		params.append("&mobile=").append(sms.getRecNum());
		params.append("&content=").append(sms.getTxt());
		params.append("&msgtype=").append("2");
		params.append("&tempid=").append(sms.getTempCode());
		params.append("&code=").append("utf-8");

		try {
			HttpResponse response = HttpUtils.doGet(ConfigUtil.getMsgProperties("SMS_SM_URL"),
					ConfigUtil.getMsgProperties("SMS_SM_PATH") + params.toString(), sms.getMethod(), null, null);
			String resp = EntityUtils.toString(response.getEntity());
			if (resp.indexOf(ConfigUtil.getMsgProperties("SMS_RETURN_CODE")) != -1) {
				return "true";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";

	}

}
