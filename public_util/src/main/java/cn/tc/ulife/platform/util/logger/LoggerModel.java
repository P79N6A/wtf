/**
 *
 */
package cn.tc.ulife.platform.util.logger;

/**
 * @author lpf
 *
 */
public class LoggerModel {

	/**
	 * 时间
	 */
	private String dateTime;

	/**
	 * 响应时间
	 */
	private String respTime;

	/**
	 * 类名
	 */
	private String className;

	/**
	 * 函数名
	 */
	private String mainName;

	/**
	 * 请求URL
	 */
	private String reqUrl;

	/**
	 * 请求IP
	 */
	private String reqIP;

	/**
	 * 用户ID
	 */
	private String uid;

	/**
	 * 操作的业务 【add、update、delete、query】
	 */
	private String oprs;

	/**
	 * 参数
	 */
	private String params;

	/**
	 * 业务描述
	 */
	private String text;

	/**
	 * 异常结果
	 */
	private String excMsg;

	/**
	 * 正常结果
	 */
	private String resMsg;

	/**
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime
	 *            the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the mainName
	 */
	public String getMainName() {
		return mainName;
	}

	/**
	 * @param mainName
	 *            the mainName to set
	 */
	public void setMainName(String mainName) {
		this.mainName = mainName;
	}

	/**
	 * @return the oprs
	 */
	public String getOprs() {
		return oprs;
	}

	/**
	 * @param oprs
	 *            the oprs to set
	 */
	public void setOprs(String oprs) {
		this.oprs = oprs;
	}

	/**
	 * @return the params
	 */
	public String getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(String params) {
		this.params = params;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the excMsg
	 */
	public String getExcMsg() {
		return excMsg;
	}

	/**
	 * @param excMsg
	 *            the excMsg to set
	 */
	public void setExcMsg(String excMsg) {
		this.excMsg = excMsg;
	}

	/**
	 * @return the resMsg
	 */
	public String getResMsg() {
		return resMsg;
	}

	/**
	 * @param resMsg
	 *            the resMsg to set
	 */
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	/**
	 * @return the respTime
	 */
	public String getRespTime() {
		return respTime;
	}

	/**
	 * @param respTime
	 *            the respTime to set
	 */
	public void setRespTime(String respTime) {
		this.respTime = respTime;
	}

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}



	/**
	 * @return the reqUrl
	 */
	public String getReqUrl() {
		return reqUrl;
	}

	/**
	 * @param reqUrl the reqUrl to set
	 */
	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}

	/**
	 * @return the reqIP
	 */
	public String getReqIP() {
		return reqIP;
	}

	/**
	 * @param reqIP the reqIP to set
	 */
	public void setReqIP(String reqIP) {
		this.reqIP = reqIP;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[dateTime=" + dateTime + ", respTime=" + respTime + ", className=" + className
				+ ", mainName=" + mainName + ", reqUrl=" + reqUrl + ", reqIP=" + reqIP + ", uid=" + uid + ", oprs="
				+ oprs + ", params=" + params + ", text=" + text + ", excMsg=" + excMsg + ", resMsg=" + resMsg + "]";
	}




//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see java.lang.Object#toString()
//	 */
//	@Override
//	public String toString() {
//		return "[" + dateTime + "=,=" + uid + "=,=" + className + "=,=" + mainName + "=,=" + oprs + "=,=" + params
//				+ "=,=" + text + "=,=" + excMsg + "=,=" + resMsg + "=,=" + respTime + "]";
//	}
}
