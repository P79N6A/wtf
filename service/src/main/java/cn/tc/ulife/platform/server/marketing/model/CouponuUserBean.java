/**
 * 
 */
package cn.tc.ulife.platform.server.marketing.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;

/**
 * @author lwy
 * 
 * 优惠卷使用情况对象
 */
public class CouponuUserBean extends BaseBean
{
	/**
	 * ID
	 */
	private String ID;

	/**
	 * 账号
	 */
	private String ACCOUNT;
	
	/**
	 * 姓名
	 */
	private String NAME;

	/**
	 * 开始时间
	 */
	private String KTIME;
	/**
	 * 结束时间
	 */
	private String JTIME;

	/**
	 * 购买时间
	 */
	private String GTIME;
	
	/**
	 * 是否使用
	 */
	private String SFSY;
	
	/**
	 * 订单编号
	 */
	private String ORDERBH;
	
	/**
	 * 优惠券ID
	 */
	private String YID;
	
	/**
	 * 小区名称
	 */
	private String COMMNAME;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getACCOUNT() {
		return ACCOUNT;
	}

	public void setACCOUNT(String aCCOUNT) {
		ACCOUNT = aCCOUNT;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getKTIME() {
		return KTIME;
	}

	public void setKTIME(String kTIME) {
		KTIME = kTIME;
	}

	public String getJTIME() {
		return JTIME;
	}

	public void setJTIME(String jTIME) {
		JTIME = jTIME;
	}

	public String getGTIME() {
		return GTIME;
	}

	public void setGTIME(String gTIME) {
		GTIME = gTIME;
	}

	public String getSFSY() {
		return SFSY;
	}

	public void setSFSY(String sFSY) {
		SFSY = sFSY;
	}

	public String getORDERBH() {
		return ORDERBH;
	}

	public void setORDERBH(String oRDERBH) {
		ORDERBH = oRDERBH;
	}


	public String getYID() {
		return YID;
	}

	public void setYID(String yID) {
		YID = yID;
	}

	public String getCOMMNAME() {
		return COMMNAME;
	}

	public void setCOMMNAME(String cOMMNAME) {
		COMMNAME = cOMMNAME;
	}
	
	
	

	
}
