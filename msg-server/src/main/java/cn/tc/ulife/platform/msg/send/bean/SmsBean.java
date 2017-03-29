/**
 * 
 */
package cn.tc.ulife.platform.msg.send.bean;

import cn.tc.ulife.platform.util.ConfigUtil;

/**
 * @author lpf
 *
 */
public class SmsBean {
	// 采用那个短信平台 1 阿里 2圣美
	private int sms_type = Integer.valueOf(ConfigUtil.getMsgProperties("SMS_TYPE"));
	// 短信内容
	private String txt;
	// 接收者
	private String RecNum;
	// 发送方式
	private String method;
	// 短信签名
	private String signName;
	// 模板码
	private String tempCode;

	/**
	 * @return the sms_type
	 */
	public int getSms_type() {
		return sms_type;
	}

	/**
	 * @param sms_type
	 *            the sms_type to set
	 */
	public void setSms_type(int sms_type) {
		this.sms_type = sms_type;
	}

	/**
	 * @return the txt
	 */
	public String getTxt() {
		return txt;
	}

	/**
	 * @param txt
	 *            the txt to set
	 */
	public void setTxt(String txt) {
		this.txt = txt;
	}

	/**
	 * @return the recNum
	 */
	public String getRecNum() {
		return RecNum;
	}

	/**
	 * @param recNum
	 *            the recNum to set
	 */
	public void setRecNum(String recNum) {
		RecNum = recNum;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method
	 *            the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the signName
	 */
	public String getSignName() {
		return signName;
	}

	/**
	 * @param signName
	 *            the signName to set
	 */
	public void setSignName(String signName) {
		this.signName = signName;
	}

	/**
	 * @return the tempCode
	 */
	public String getTempCode() {
		return tempCode;
	}

	/**
	 * @param tempCode
	 *            the tempCode to set
	 */
	public void setTempCode(String tempCode) {
		this.tempCode = tempCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SmsBean [sms_type=" + sms_type + ", txt=" + txt + ", RecNum=" + RecNum + ", method=" + method
				+ ", signName=" + signName + ", tempCode=" + tempCode + "]";
	}

}
