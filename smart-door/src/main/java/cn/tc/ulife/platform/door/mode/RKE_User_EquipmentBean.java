/**
 * 
 */
package cn.tc.ulife.platform.door.mode;

import cn.tc.ulife.platform.validators.Must;

/**
 * @author lpf
 *
 *         用户 房间与门口机关系
 */
public class RKE_User_EquipmentBean {

	/**
	 * 主键
	 */
	private String RH_ID;

	/**
	 * t_sys_urcom 关系主表
	 * 
	 */
	@Must
	private String RH_R_ID;

	/**
	 * 用户ID
	 */
	@Must
	private String UID;

	/**
	 * 创建时间
	 */
	private String RH_CreateTime;

	/**
	 * 最后修改时间
	 */
	private String RH_LastModifyTime;

	/**
	 * 开发者ID
	 */
	private String AccountSid;

	/**
	 * 操作人ID
	 */
	@Must
	private String Creator;

	/**
	 * 用户是否同步到门口机 1显示，0不显示
	 */
	@Must
	private String RH_IsShowMKJ;

	/**
	 * RKE 是否App通话授权,1通话，0不通话
	 */
	@Must
	private String RH_AppTalkable;

	/**
	 * RKE SIP 是否语音通话授权，1通话，0不通话
	 */
	@Must
	private String RH_PhoneTalkable;

	/**
	 * RKE 是否开启视频对讲，1可以对讲，0禁止对讲
	 */
	@Must
	private String RH_IsVideoCall;

	/**
	 * 开始时间
	 */	
	private String RH_PowerStartTime;

	/**
	 * 结束时间
	 */
	private String RH_PowerEndTime;

	/**
	 * RKE 公安局地址授权码,限珠海地区会用到这个字段
	 */
	private String RH_AddrAuthCode;

	/**
	 * RKE 住户指纹base64，这个需要设备来读取
	 */
	private String RH_FingerPrintCode1;

	/**
	 * 是否审核 0 未审核 1审核
	 */
	@Must
	private String RH_IsAudited;

	/**
	 * @return the rH_ID
	 */
	public String getRH_ID() {
		return RH_ID;
	}

	/**
	 * @param rH_ID
	 *            the rH_ID to set
	 */
	public void setRH_ID(String rH_ID) {
		RH_ID = rH_ID;
	}

	/**
	 * @return the rH_R_ID
	 */
	public String getRH_R_ID() {
		return RH_R_ID;
	}

	/**
	 * @param rH_R_ID
	 *            the rH_R_ID to set
	 */
	public void setRH_R_ID(String rH_R_ID) {
		RH_R_ID = rH_R_ID;
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
	 * @return the rH_LastModifyTime
	 */
	public String getRH_LastModifyTime() {
		return RH_LastModifyTime;
	}

	/**
	 * @param rH_LastModifyTime
	 *            the rH_LastModifyTime to set
	 */
	public void setRH_LastModifyTime(String rH_LastModifyTime) {
		RH_LastModifyTime = rH_LastModifyTime;
	}

	/**
	 * @return the accountSid
	 */
	public String getAccountSid() {
		return AccountSid;
	}

	/**
	 * @param accountSid
	 *            the accountSid to set
	 */
	public void setAccountSid(String accountSid) {
		AccountSid = accountSid;
	}

	/**
	 * @return the creator
	 */
	public String getCreator() {
		return Creator;
	}

	/**
	 * @param creator
	 *            the creator to set
	 */
	public void setCreator(String creator) {
		Creator = creator;
	}

	/**
	 * @return the rH_IsShowMKJ
	 */
	public String getRH_IsShowMKJ() {
		return RH_IsShowMKJ;
	}

	/**
	 * @param rH_IsShowMKJ
	 *            the rH_IsShowMKJ to set
	 */
	public void setRH_IsShowMKJ(String rH_IsShowMKJ) {
		RH_IsShowMKJ = rH_IsShowMKJ;
	}

	/**
	 * @return the rH_AppTalkable
	 */
	public String getRH_AppTalkable() {
		return RH_AppTalkable;
	}

	/**
	 * @param rH_AppTalkable
	 *            the rH_AppTalkable to set
	 */
	public void setRH_AppTalkable(String rH_AppTalkable) {
		RH_AppTalkable = rH_AppTalkable;
	}

	/**
	 * @return the rH_PhoneTalkable
	 */
	public String getRH_PhoneTalkable() {
		return RH_PhoneTalkable;
	}

	/**
	 * @param rH_PhoneTalkable
	 *            the rH_PhoneTalkable to set
	 */
	public void setRH_PhoneTalkable(String rH_PhoneTalkable) {
		RH_PhoneTalkable = rH_PhoneTalkable;
	}

	/**
	 * @return the rH_IsVideoCall
	 */
	public String getRH_IsVideoCall() {
		return RH_IsVideoCall;
	}

	/**
	 * @param rH_IsVideoCall
	 *            the rH_IsVideoCall to set
	 */
	public void setRH_IsVideoCall(String rH_IsVideoCall) {
		RH_IsVideoCall = rH_IsVideoCall;
	}

	/**
	 * @return the rH_PowerStartTime
	 */
	public String getRH_PowerStartTime() {
		return RH_PowerStartTime;
	}

	/**
	 * @param rH_PowerStartTime
	 *            the rH_PowerStartTime to set
	 */
	public void setRH_PowerStartTime(String rH_PowerStartTime) {
		RH_PowerStartTime = rH_PowerStartTime;
	}

	/**
	 * @return the rH_PowerEndTime
	 */
	public String getRH_PowerEndTime() {
		return RH_PowerEndTime;
	}

	/**
	 * @param rH_PowerEndTime
	 *            the rH_PowerEndTime to set
	 */
	public void setRH_PowerEndTime(String rH_PowerEndTime) {
		RH_PowerEndTime = rH_PowerEndTime;
	}

	/**
	 * @return the rH_AddrAuthCode
	 */
	public String getRH_AddrAuthCode() {
		return RH_AddrAuthCode;
	}

	/**
	 * @param rH_AddrAuthCode
	 *            the rH_AddrAuthCode to set
	 */
	public void setRH_AddrAuthCode(String rH_AddrAuthCode) {
		RH_AddrAuthCode = rH_AddrAuthCode;
	}

	/**
	 * @return the rH_FingerPrintCode1
	 */
	public String getRH_FingerPrintCode1() {
		return RH_FingerPrintCode1;
	}

	/**
	 * @param rH_FingerPrintCode1
	 *            the rH_FingerPrintCode1 to set
	 */
	public void setRH_FingerPrintCode1(String rH_FingerPrintCode1) {
		RH_FingerPrintCode1 = rH_FingerPrintCode1;
	}

	/**
	 * @return the rH_IsAudited
	 */
	public String getRH_IsAudited() {
		return RH_IsAudited;
	}

	/**
	 * @param rH_IsAudited
	 *            the rH_IsAudited to set
	 */
	public void setRH_IsAudited(String rH_IsAudited) {
		RH_IsAudited = rH_IsAudited;
	}

	/**
	 * @return the rH_CreateTime
	 */
	public String getRH_CreateTime() {
		return RH_CreateTime;
	}

	/**
	 * @param rH_CreateTime
	 *            the rH_CreateTime to set
	 */
	public void setRH_CreateTime(String rH_CreateTime) {
		RH_CreateTime = rH_CreateTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RKE_User_EquipmentBean [RH_ID=" + RH_ID + ", RH_R_ID=" + RH_R_ID + ", UID=" + UID
				+ ", RH_LastModifyTime=" + RH_LastModifyTime + ", AccountSid=" + AccountSid + ", Creator=" + Creator
				+ ", RH_IsShowMKJ=" + RH_IsShowMKJ + ", RH_AppTalkable=" + RH_AppTalkable + ", RH_PhoneTalkable="
				+ RH_PhoneTalkable + ", RH_IsVideoCall=" + RH_IsVideoCall + ", RH_PowerStartTime=" + RH_PowerStartTime
				+ ", RH_PowerEndTime=" + RH_PowerEndTime + ", RH_AddrAuthCode=" + RH_AddrAuthCode
				+ ", RH_FingerPrintCode1=" + RH_FingerPrintCode1 + ", RH_IsAudited=" + RH_IsAudited + "]";
	}

}
