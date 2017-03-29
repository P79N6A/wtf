/**
 * 
 */
package cn.tc.ulife.platform.server.social.model;

/**
 * @author lpf
 * 
 *         邻居圈
 */
public class BbsModel {

	private String ID;

	/**
	 * 如果有小站或者物业，发起者就是小站或者物业人员id
	 */
	private String UID;

	/**
	 * 昵称
	 */
	private String UNAME;

	/**
	 * 主题
	 */
	private String HDZT;

	/**
	 * 活动类型
	 */
	private String LXID;

	/**
	 * 发布时间
	 */
	private String KSSJ;

	/**
	 * 小区ID
	 */
	private String XQID;

	/**
	 * 小区编码
	 */
	private String XQCODE;

	/**
	 * 帖子内容
	 */
	private String HDJS;

	/**
	 * 是否展现
	 */
	private String ISZS;

	/**
	 * 是否推送
	 */
	private String ISTS;

	/**
	 * 是否匿名
	 */
	private String ISNM;

	/**
	 * 
	 */
	private String TP1;

	private String TP2;
	private String TP3;
	/**
	 * 0:用户发起;后台发起(1小站,2物业,3系统管理员等)'
	 */
	private String FQLX;
	/**
	 * 
	 */
	private String MTIME;
	/**
	 * 
	 */
	private String MUID;
	/**
	 * 帖子类型
	 */
	private String TYPE;
	/**
	 * 帖子状态
	 */
	private String ZT;
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
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
	 * @param uID the uID to set
	 */
	public void setUID(String uID) {
		UID = uID;
	}
	/**
	 * @return the uNAME
	 */
	public String getUNAME() {
		return UNAME;
	}
	/**
	 * @param uNAME the uNAME to set
	 */
	public void setUNAME(String uNAME) {
		UNAME = uNAME;
	}
	/**
	 * @return the hDZT
	 */
	public String getHDZT() {
		return HDZT;
	}
	/**
	 * @param hDZT the hDZT to set
	 */
	public void setHDZT(String hDZT) {
		HDZT = hDZT;
	}
	/**
	 * @return the lXID
	 */
	public String getLXID() {
		return LXID;
	}
	/**
	 * @param lXID the lXID to set
	 */
	public void setLXID(String lXID) {
		LXID = lXID;
	}
	/**
	 * @return the kSSJ
	 */
	public String getKSSJ() {
		return KSSJ;
	}
	/**
	 * @param kSSJ the kSSJ to set
	 */
	public void setKSSJ(String kSSJ) {
		KSSJ = kSSJ;
	}
	/**
	 * @return the xQID
	 */
	public String getXQID() {
		return XQID;
	}
	/**
	 * @param xQID the xQID to set
	 */
	public void setXQID(String xQID) {
		XQID = xQID;
	}
	/**
	 * @return the xQCODE
	 */
	public String getXQCODE() {
		return XQCODE;
	}
	/**
	 * @param xQCODE the xQCODE to set
	 */
	public void setXQCODE(String xQCODE) {
		XQCODE = xQCODE;
	}
	/**
	 * @return the hDJS
	 */
	public String getHDJS() {
		return HDJS;
	}
	/**
	 * @param hDJS the hDJS to set
	 */
	public void setHDJS(String hDJS) {
		HDJS = hDJS;
	}
	/**
	 * @return the iSZS
	 */
	public String getISZS() {
		return ISZS;
	}
	/**
	 * @param iSZS the iSZS to set
	 */
	public void setISZS(String iSZS) {
		ISZS = iSZS;
	}
	/**
	 * @return the iSTS
	 */
	public String getISTS() {
		return ISTS;
	}
	/**
	 * @param iSTS the iSTS to set
	 */
	public void setISTS(String iSTS) {
		ISTS = iSTS;
	}
	/**
	 * @return the iSNM
	 */
	public String getISNM() {
		return ISNM;
	}
	/**
	 * @param iSNM the iSNM to set
	 */
	public void setISNM(String iSNM) {
		ISNM = iSNM;
	}
	/**
	 * @return the tP1
	 */
	public String getTP1() {
		return TP1;
	}
	/**
	 * @param tP1 the tP1 to set
	 */
	public void setTP1(String tP1) {
		TP1 = tP1;
	}
	/**
	 * @return the tP2
	 */
	public String getTP2() {
		return TP2;
	}
	/**
	 * @param tP2 the tP2 to set
	 */
	public void setTP2(String tP2) {
		TP2 = tP2;
	}
	/**
	 * @return the tP3
	 */
	public String getTP3() {
		return TP3;
	}
	/**
	 * @param tP3 the tP3 to set
	 */
	public void setTP3(String tP3) {
		TP3 = tP3;
	}
	/**
	 * @return the fQLX
	 */
	public String getFQLX() {
		return FQLX;
	}
	/**
	 * @param fQLX the fQLX to set
	 */
	public void setFQLX(String fQLX) {
		FQLX = fQLX;
	}
	/**
	 * @return the mTIME
	 */
	public String getMTIME() {
		return MTIME;
	}
	/**
	 * @param mTIME the mTIME to set
	 */
	public void setMTIME(String mTIME) {
		MTIME = mTIME;
	}
	/**
	 * @return the mUID
	 */
	public String getMUID() {
		return MUID;
	}
	/**
	 * @param mUID the mUID to set
	 */
	public void setMUID(String mUID) {
		MUID = mUID;
	}
	/**
	 * @return the tYPE
	 */
	public String getTYPE() {
		return TYPE;
	}
	/**
	 * @param tYPE the tYPE to set
	 */
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	/**
	 * @return the zT
	 */
	public String getZT() {
		return ZT;
	}
	/**
	 * @param zT the zT to set
	 */
	public void setZT(String zT) {
		ZT = zT;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BbsModel [ID=" + ID + ", UID=" + UID + ", UNAME=" + UNAME + ", HDZT=" + HDZT + ", LXID=" + LXID
				+ ", KSSJ=" + KSSJ + ", XQID=" + XQID + ", XQCODE=" + XQCODE + ", HDJS=" + HDJS + ", ISZS=" + ISZS
				+ ", ISTS=" + ISTS + ", ISNM=" + ISNM + ", TP1=" + TP1 + ", TP2=" + TP2 + ", TP3=" + TP3 + ", FQLX="
				+ FQLX + ", MTIME=" + MTIME + ", MUID=" + MUID + ", TYPE=" + TYPE + ", ZT=" + ZT + "]";
	}
	
	
}
