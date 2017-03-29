/**
 * 
 */
package cn.tc.ulife.platform.msg.send;

import cn.tc.ulife.platform.msg.send.bean.SmsBean;
import cn.tc.ulife.platform.msg.send.impl.AliSmsImpl;
import cn.tc.ulife.platform.msg.send.impl.SMSmsImpl;

/**
 * @author lpf
 *
 */
public final class SmsFactory {

	public static String send(SmsBean sb) {
		SmsService sms;
		switch (sb.getSms_type()) {
		// ali
		case 1:
			sms = new AliSmsImpl();
			return sms.sendSms(sb);
		// 圣美平台
		case 2:
			sms = new SMSmsImpl();
			return sms.sendSms(sb);
		// 默认阿里
		default:
			sms = new AliSmsImpl();
			return sms.sendSms(sb);
		}
	}
}
