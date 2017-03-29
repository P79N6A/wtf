/**
 * 
 */
package cn.tc.ulife.platform.server.social.model;

/**
 * @author lpf
 *
 *         活动表
 */
public class ActivityModel {

	/**
	 * 主键
	 */
	private String ID;

	/**
	 * 发起者
	 */
	private String UID;

	/**
	 * 活动主题
	 */
	private String HDZT;

	/**
	 * 开始时间
	 */
	private String KSSJ;

	/**
	 * 结束时间
	 */
	private String JSSJ;

	/**
	 * 小区ID
	 */
	private String XQID;

	/**
	 * 详细地址
	 */
	private String XXDZ;

	/**
	 * 活动海报
	 */
	private String HBURL;

	/**
	 * 主办方介绍
	 */
	private String ZBFJS;

	/**
	 * 活动介绍
	 */
	private String HDJS;

	/**
	 * 报名须知
	 */
	private String BMXZ;

	/**
	 * 费用信息
	 */
	private String FYXX;

	/**
	 * 宣传照片
	 */
	private String HDZP;

	/**
	 * 是否报名 '0可以报名;1不可报名';
	 */
	private String ISBM;

	/**
	 * 发起类型 '0小站;1物业;2管理员;3其他';
	 */
	private String FQLX;

	/**
	 * 外部链接
	 */
	private String LJURL;

	/**
	 * 创建时间
	 */
	private String CTIME;

	/**
	 * 修改时间
	 */
	private String MTIME;

	/**
	 * 活动状态 '0新建;1已发布';
	 */
	private String ZT;

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
	 * @return the hDZT
	 */
	public String getHDZT() {
		return HDZT;
	}

	/**
	 * @param hDZT
	 *            the hDZT to set
	 */
	public void setHDZT(String hDZT) {
		HDZT = hDZT;
	}

	/**
	 * @return the kSSJ
	 */
	public String getKSSJ() {
		return KSSJ;
	}

	/**
	 * @param kSSJ
	 *            the kSSJ to set
	 */
	public void setKSSJ(String kSSJ) {
		KSSJ = kSSJ;
	}

	/**
	 * @return the jSSJ
	 */
	public String getJSSJ() {
		return JSSJ;
	}

	/**
	 * @param jSSJ
	 *            the jSSJ to set
	 */
	public void setJSSJ(String jSSJ) {
		JSSJ = jSSJ;
	}

	/**
	 * @return the xQID
	 */
	public String getXQID() {
		return XQID;
	}

	/**
	 * @param xQID
	 *            the xQID to set
	 */
	public void setXQID(String xQID) {
		XQID = xQID;
	}

	/**
	 * @return the xXDZ
	 */
	public String getXXDZ() {
		return XXDZ;
	}

	/**
	 * @param xXDZ
	 *            the xXDZ to set
	 */
	public void setXXDZ(String xXDZ) {
		XXDZ = xXDZ;
	}

	/**
	 * @return the hBURL
	 */
	public String getHBURL() {
		return HBURL;
	}

	/**
	 * @param hBURL
	 *            the hBURL to set
	 */
	public void setHBURL(String hBURL) {
		HBURL = hBURL;
	}

	/**
	 * @return the zBFJS
	 */
	public String getZBFJS() {
		return ZBFJS;
	}

	/**
	 * @param zBFJS
	 *            the zBFJS to set
	 */
	public void setZBFJS(String zBFJS) {
		ZBFJS = zBFJS;
	}

	/**
	 * @return the hDJS
	 */
	public String getHDJS() {
		return HDJS;
	}

	/**
	 * @param hDJS
	 *            the hDJS to set
	 */
	public void setHDJS(String hDJS) {
		HDJS = hDJS;
	}

	/**
	 * @return the bMXZ
	 */
	public String getBMXZ() {
		return BMXZ;
	}

	/**
	 * @param bMXZ
	 *            the bMXZ to set
	 */
	public void setBMXZ(String bMXZ) {
		BMXZ = bMXZ;
	}

	/**
	 * @return the fYXX
	 */
	public String getFYXX() {
		return FYXX;
	}

	/**
	 * @param fYXX
	 *            the fYXX to set
	 */
	public void setFYXX(String fYXX) {
		FYXX = fYXX;
	}

	/**
	 * @return the hDZP
	 */
	public String getHDZP() {
		return HDZP;
	}

	/**
	 * @param hDZP
	 *            the hDZP to set
	 */
	public void setHDZP(String hDZP) {
		HDZP = hDZP;
	}

	/**
	 * @return the iSBM
	 */
	public String getISBM() {
		return ISBM;
	}

	/**
	 * @param iSBM
	 *            the iSBM to set
	 */
	public void setISBM(String iSBM) {
		ISBM = iSBM;
	}

	/**
	 * @return the fQLX
	 */
	public String getFQLX() {
		return FQLX;
	}

	/**
	 * @param fQLX
	 *            the fQLX to set
	 */
	public void setFQLX(String fQLX) {
		FQLX = fQLX;
	}

	/**
	 * @return the lJURL
	 */
	public String getLJURL() {
		return LJURL;
	}

	/**
	 * @param lJURL
	 *            the lJURL to set
	 */
	public void setLJURL(String lJURL) {
		LJURL = lJURL;
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
	 * @return the mTIME
	 */
	public String getMTIME() {
		return MTIME;
	}

	/**
	 * @param mTIME
	 *            the mTIME to set
	 */
	public void setMTIME(String mTIME) {
		MTIME = mTIME;
	}

	/**
	 * @return the zT
	 */
	public String getZT() {
		return ZT;
	}

	/**
	 * @param zT
	 *            the zT to set
	 */
	public void setZT(String zT) {
		ZT = zT;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActivityModel [ID=" + ID + ", UID=" + UID + ", HDZT=" + HDZT + ", KSSJ=" + KSSJ + ", JSSJ=" + JSSJ
				+ ", XQID=" + XQID + ", XXDZ=" + XXDZ + ", HBURL=" + HBURL + ", ZBFJS=" + ZBFJS + ", HDJS=" + HDJS
				+ ", BMXZ=" + BMXZ + ", FYXX=" + FYXX + ", HDZP=" + HDZP + ", ISBM=" + ISBM + ", FQLX=" + FQLX
				+ ", LJURL=" + LJURL + ", CTIME=" + CTIME + ", MTIME=" + MTIME + ", ZT=" + ZT + "]";
	}

}
