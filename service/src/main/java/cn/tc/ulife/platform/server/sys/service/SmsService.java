/**
 * 
 */
package cn.tc.ulife.platform.server.sys.service;

import java.util.List;

import cn.tc.ulife.platform.server.sys.model.SmsCodeBean;

/**
 * @author lpf
 *
 */
public interface SmsService {
	/**
	 * 查询短信记录
	 * 
	 * @param smsCode
	 * @return
	 */
	public List<SmsCodeBean> querySmscode(String mobile);

	/**
	 * 插入短信信息
	 * 
	 * @param smsCode
	 * @return
	 */
	public int insertSmscode(SmsCodeBean smsCode);
}
