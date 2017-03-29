/**
 * 
 */
package cn.tc.ulife.platform.server.sys.model;

/**
 * @author lpf
 *
 */
public class SmsCodeBean {

	/**
	 * id
	 */
	private String ID;

	/**
	 * 发送短信的操作人ID
	 */
	private String UID;

	/**
	 * 接收短信内容的手机
	 */
	private String MOBILE;

	/**
	 * 接收的内容
	 */
	private String CODE;

	/**
	 * 发送时间
	 */
	private String CTIME;

	/**
	 * 短信有效期 只针对验证码通知类有效
	 */
	private String MAXTIME;

	/**
	 * 发送短信的客户端类型
	 */
	private String APP;

	/**
	 * 发送短信类型， 0 注册 1 修改 2 内容
	 */
	private String SEND_TYPE;

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the uID
	 */
	public String getUID() {
		return UID;
	}

	/**
	 * @param uID
	 *            the uID to set
	 */
	public void setUID(String uID) {
		UID = uID;
	}

	/**
	 * @return the mOBILE
	 */
	public String getMOBILE() {
		return MOBILE;
	}

	/**
	 * @param mOBILE
	 *            the mOBILE to set
	 */
	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}

	/**
	 * @return the cODE
	 */
	public String getCODE() {
		return CODE;
	}

	/**
	 * @param cODE
	 *            the cODE to set
	 */
	public void setCODE(String cODE) {
		CODE = cODE;
	}

	/**
	 * @return the cTIME
	 */
	public String getCTIME() {
		return CTIME;
	}

	/**
	 * @param cTIME
	 *            the cTIME to set
	 */
	public void setCTIME(String cTIME) {
		CTIME = cTIME;
	}

	/**
	 * @return the mAXTIME
	 */
	public String getMAXTIME() {
		return MAXTIME;
	}

	/**
	 * @param mAXTIME
	 *            the mAXTIME to set
	 */
	public void setMAXTIME(String mAXTIME) {
		MAXTIME = mAXTIME;
	}

	/**
	 * @return the aPP
	 */
	public String getAPP() {
		return APP;
	}

	/**
	 * @param aPP
	 *            the aPP to set
	 */
	public void setAPP(String aPP) {
		APP = aPP;
	}

	/**
	 * @return the sEND_TYPE
	 */
	public String getSEND_TYPE() {
		return SEND_TYPE;
	}

	/**
	 * @param sEND_TYPE
	 *            the sEND_TYPE to set
	 */
	public void setSEND_TYPE(String sEND_TYPE) {
		SEND_TYPE = sEND_TYPE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SmsCodeBean [ID=" + ID + ", UID=" + UID + ", MOBILE=" + MOBILE + ", CODE=" + CODE + ", CTIME=" + CTIME
				+ ", MAXTIME=" + MAXTIME + ", APP=" + APP + ", SEND_TYPE=" + SEND_TYPE + "]";
	}

}
