/**
 * 
 */
package cn.tc.ulife.platform.server.user.model;

import cn.tc.ulife.platform.validators.Must;

/**
 * @author lpf
 *
 *         提供前端展现的用户对象实体
 * 
 */
public class ViewUserBean {
	
	// 手机号码
	@Must
	private String MOBILE;

	// 用户昵称 （可选）
	private String NickName;

	// 姓名
	@Must
	private String NAME;

	// 证件类型 1 身份证 2 普通护照 3 居住证 4 中华人民共和国出入境通行证 0 其他
	@Must
	private String IdentityType;

	// 证件号码 身份证 (需要验证格式)
	@Must
	private String IdentityNo;

	// 出生日期 格式如2015-06-17 如果是身份证 应该自动读取日期
	@Must
	private String BirthDay;

	// 性别 0:男;1女
	@Must
	private String Gender;

	// 备注 （可选）
	private String REMARK;

	// 短信验证码
	@Must
	private String smsCode;

	// 社区ID
	@Must
	private String COMID;
	
	// 房间ID
	@Must
	private String ROOMID;

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
	 * @return the nickName
	 */
	public String getNickName() {
		return NickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		NickName = nickName;
	}

	/**
	 * @return the nAME
	 */
	public String getNAME() {
		return NAME;
	}

	/**
	 * @param nAME
	 *            the nAME to set
	 */
	public void setNAME(String nAME) {
		NAME = nAME;
	}

	/**
	 * @return the identityType
	 */
	public String getIdentityType() {
		return IdentityType;
	}

	/**
	 * @param identityType
	 *            the identityType to set
	 */
	public void setIdentityType(String identityType) {
		IdentityType = identityType;
	}

	/**
	 * @return the identityNo
	 */
	public String getIdentityNo() {
		return IdentityNo;
	}

	/**
	 * @param identityNo
	 *            the identityNo to set
	 */
	public void setIdentityNo(String identityNo) {
		IdentityNo = identityNo;
	}

	/**
	 * @return the birthDay
	 */
	public String getBirthDay() {
		return BirthDay;
	}

	/**
	 * @param birthDay
	 *            the birthDay to set
	 */
	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return Gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		Gender = gender;
	}

	/**
	 * @return the rEMARK
	 */
	public String getREMARK() {
		return REMARK;
	}

	/**
	 * @param rEMARK
	 *            the rEMARK to set
	 */
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}

	/**
	 * @return the smsCode
	 */
	public String getSmsCode() {
		return smsCode;
	}

	/**
	 * @param smsCode
	 *            the smsCode to set
	 */
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ViewUserBean [MOBILE=" + MOBILE + ", NickName=" + NickName + ", NAME=" + NAME + ", IdentityType="
				+ IdentityType + ", IdentityNo=" + IdentityNo + ", BirthDay=" + BirthDay + ", Gender=" + Gender
				+ ", REMARK=" + REMARK + ", smsCode=" + smsCode + ", COMID=" + COMID + ", ROOMID=" + ROOMID + "]";
	}

}
