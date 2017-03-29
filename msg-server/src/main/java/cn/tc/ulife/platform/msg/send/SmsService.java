/**
 * 
 */
package cn.tc.ulife.platform.msg.send;

import cn.tc.ulife.platform.msg.send.bean.SmsBean;

/**
 * @author lpf
 *
 */
public interface SmsService {

	/**
	 * 统一封装的短信发送方法
	 * 
	 * @param sms_type
	 * @param txt
	 * @param method
	 * @return
	 */
	public String sendSms(SmsBean sms);
}
