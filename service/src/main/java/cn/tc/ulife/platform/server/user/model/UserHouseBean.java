/**
 * 
 */
package cn.tc.ulife.platform.server.user.model;

/**
 * @author lpf
 * 
 *         用户房间对象
 */
public class UserHouseBean {

	/**
	 * 
	 */
	private String ID;

	/**
	 * 用户ID
	 */
	private String UID;

	/**
	 * 小区ID
	 */
	private String COMID;

	/**
	 * 房间ID
	 */
	private String ROOMID;

	/**
	 * 是否默认房间 0 不默认 1默认
	 */
	private String ISDEF;

	private String CTIME;

	private String MTIME;

	/**
	 * 是否审核
	 */
	private String IS_Audited;

	/**
	 * 原总部数据ID
	 */
	private String HRID;

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
	 * @return the cOMID
	 */
	public String getCOMID() {
		return COMID;
	}

	/**
	 * @param cOMID
	 *            the cOMID to set
	 */
	public void setCOMID(String cOMID) {
		COMID = cOMID;
	}

	/**
	 * @return the rOOMID
	 */
	public String getROOMID() {
		return ROOMID;
	}

	/**
	 * @param rOOMID
	 *            the rOOMID to set
	 */
	public void setROOMID(String rOOMID) {
		ROOMID = rOOMID;
	}

	/**
	 * @return the iSDEF
	 */
	public String getISDEF() {
		return ISDEF;
	}

	/**
	 * @param iSDEF
	 *            the iSDEF to set
	 */
	public void setISDEF(String iSDEF) {
		ISDEF = iSDEF;
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
	 * @return the hRID
	 */
	public String getHRID() {
		return HRID;
	}

	/**
	 * @param hRID
	 *            the hRID to set
	 */
	public void setHRID(String hRID) {
		HRID = hRID;
	}

	/**
	 * @return the iS_Audited
	 */
	public String getIS_Audited() {
		return IS_Audited;
	}

	/**
	 * @param iS_Audited
	 *            the iS_Audited to set
	 */
	public void setIS_Audited(String iS_Audited) {
		IS_Audited = iS_Audited;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserHouseBean [ID=" + ID + ", UID=" + UID + ", COMID=" + COMID + ", ROOMID=" + ROOMID + ", ISDEF="
				+ ISDEF + ", CTIME=" + CTIME + ", MTIME=" + MTIME + ", HRID=" + HRID + "]";
	}

}
