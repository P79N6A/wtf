/**
 * 
 */
package cn.tc.ulife.platform.door.mode;

import java.util.Arrays;

import cn.tc.ulife.platform.validators.Must;

/**
 * @author lpf
 *
 */
public class ViewUserDoorAuthorBean {
	/**
	 * t_sys_urcom 关系主表
	 * 
	 */
	@Must
	private String U_RID;

	/**
	 * 用户ID 给授权的用户
	 */
	@Must
	private String uid;

	/**
	 * 操作人ID
	 */
	@Must
	private String account;

	/**
	 * 手机号码
	 */
	@Must
	private String mobile;

	/**
	 * 小区名称
	 */
	private String comName;

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
	 * RKE 住户指纹base64，这个需要设备来读取
	 */
	private String RH_FingerPrintCode1;

	/**
	 * 是否审核 0 未审核 1审核
	 */
	@Must
	private String RH_IsAudited;

	/**
	 * 小区ID
	 */
	@Must
	private String commId;

	/**
	 * 结构列表 用于存放门口机关系的结构 包括小区ID
	 */
	@Must
	private String ids;

	/**
	 * @return the u_RID
	 */
	public String getU_RID() {
		return U_RID;
	}

	/**
	 * @param u_RID
	 *            the u_RID to set
	 */
	public void setU_RID(String u_RID) {
		U_RID = u_RID;
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
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
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
	 * @return the commId
	 */
	public String getCommId() {
		return commId;
	}

	/**
	 * @param commId
	 *            the commId to set
	 */
	public void setCommId(String commId) {
		this.commId = commId;
	}

	/**
	 * @return the ids
	 */
	public String getIds() {
		return ids;
	}

	/**
	 * @param ids
	 *            the ids to set
	 */
	public void setIds(String ids) {
		this.ids = ids;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the comName
	 */
	public String getComName() {
		return comName;
	}

	/**
	 * @param comName
	 *            the comName to set
	 */
	public void setComName(String comName) {
		this.comName = comName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ViewUserDoorAuthorBean [U_RID=" + U_RID + ", uid=" + uid + ", account=" + account + ", mobile=" + mobile
				+ ", comName=" + comName + ", RH_IsShowMKJ=" + RH_IsShowMKJ + ", RH_AppTalkable=" + RH_AppTalkable
				+ ", RH_PhoneTalkable=" + RH_PhoneTalkable + ", RH_IsVideoCall=" + RH_IsVideoCall
				+ ", RH_PowerStartTime=" + RH_PowerStartTime + ", RH_PowerEndTime=" + RH_PowerEndTime
				+ ", RH_FingerPrintCode1=" + RH_FingerPrintCode1 + ", RH_IsAudited=" + RH_IsAudited + ", commId="
				+ commId + ", ids=" + ids + "]";
	}

}
