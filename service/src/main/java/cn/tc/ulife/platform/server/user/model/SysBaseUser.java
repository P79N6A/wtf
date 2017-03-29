/**
 * 
 */
package cn.tc.ulife.platform.server.user.model;

/**
 * @author lpf
 *
 */
public class SysBaseUser {

	// 主键ID
	private String ID;

	// 住户ID 与总部住户列表对接唯一标识
	private String HID;

	// 组织结构ID private String OR_ID;
	private String OR_ID;

	// 账号
	private String Account;
	// 密码
	private String Password;
	// 手机号码
	private String MOBILE;
	// 联系电话
	private String TEL;
	// 用户昵称
	private String NickName;
	// 姓名
	private String NAME;
	// 身份证
	private String IdentityNo;
	// 出生日期 格式如2015-06-17
	private String BirthDay;
	// 性别 0:男;1女
	private String Gender;
	// 家庭住址
	private String ADDRESS;
	// 注册时间 时间格式:yyyy-mm-dd hh:mm:ss
	private String REGTIME;
	// 修改时间
	private String LastModifyTime;
	// 头像存储路径
	private String HeadImage;
	/// 邮箱
	private String EMAIL;
	// QQ
	private String QQ;
	// 微信
	private String WX;
	// 账号状态 0:启用;1:停用;2注销
	private String ZT;
	// 备注
	private String REMARK;
	// 注册终端 1:IOS手机;2:IOS PAD;3安卓PAD;4安卓手机;5U9;6PC;7微信公众号;8 后台注册
	private String DTYPE;
	// 注册方式 0：用户注册；1:后台开户
	private String RegMethod;
	// 创建者信息 后台开户为后台管理员账户， 用户注册为小站客户ID
	private String Creator;
	// 客服ID
	private String KFID;
	// 证件类型  1 身份证 2 普通护照 3 居住证 4 中华人民共和国出入境通行证 0 其他
	private String IdentityType;
	// 新用户标识 0:新用户;1:老用户
	private String IsNewUser;
	// 社区ID
	private String COMID;
	// 房间ID
	private String ROOMID;
	// 对讲账号
	private String TalkAccount;
	// 对讲密码
	private String TalkPassword;
	// 智能家居密码
	private String UHomePassword;
	// 是否审核 0未审核/1已审核
	private String IsAudited;
	// 第三方开发者sid
	private String AccountSid;
	// 是否小孩子 是否小孩子，1为小孩，0为非小孩
	private String RKE_IsChild;
	// 住户指纹 住户指纹base64，这个需要设备来读取
	private String RKE_FingerPrint;
	// 呼叫电话 呼叫电话,固话请加上区号，如 07568665566
	private String RKE_CallPhone;
	// 最大卡数量
	private String RKE_MaxCardCount;

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
	 * @return the hID
	 */
	public String getHID() {
		return HID;
	}

	/**
	 * @param hID
	 *            the hID to set
	 */
	public void setHID(String hID) {
		HID = hID;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return Account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(String account) {
		Account = account;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		Password = password;
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
	 * @return the tEL
	 */
	public String getTEL() {
		return TEL;
	}

	/**
	 * @param tEL
	 *            the tEL to set
	 */
	public void setTEL(String tEL) {
		TEL = tEL;
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
	 * @return the aDDRESS
	 */
	public String getADDRESS() {
		return ADDRESS;
	}

	/**
	 * @param aDDRESS
	 *            the aDDRESS to set
	 */
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	/**
	 * @return the rEGTIME
	 */
	public String getREGTIME() {
		return REGTIME;
	}

	/**
	 * @param rEGTIME
	 *            the rEGTIME to set
	 */
	public void setREGTIME(String rEGTIME) {
		REGTIME = rEGTIME;
	}

	/**
	 * @return the lastModifyTime
	 */
	public String getLastModifyTime() {
		return LastModifyTime;
	}

	/**
	 * @param lastModifyTime
	 *            the lastModifyTime to set
	 */
	public void setLastModifyTime(String lastModifyTime) {
		LastModifyTime = lastModifyTime;
	}

	/**
	 * @return the headImage
	 */
	public String getHeadImage() {
		return HeadImage;
	}

	/**
	 * @param headImage
	 *            the headImage to set
	 */
	public void setHeadImage(String headImage) {
		HeadImage = headImage;
	}

	/**
	 * @return the eMAIL
	 */
	public String getEMAIL() {
		return EMAIL;
	}

	/**
	 * @param eMAIL
	 *            the eMAIL to set
	 */
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	/**
	 * @return the qQ
	 */
	public String getQQ() {
		return QQ;
	}

	/**
	 * @param qQ
	 *            the qQ to set
	 */
	public void setQQ(String qQ) {
		QQ = qQ;
	}

	/**
	 * @return the wX
	 */
	public String getWX() {
		return WX;
	}

	/**
	 * @param wX
	 *            the wX to set
	 */
	public void setWX(String wX) {
		WX = wX;
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
	 * @return the dTYPE
	 */
	public String getDTYPE() {
		return DTYPE;
	}

	/**
	 * @param dTYPE
	 *            the dTYPE to set
	 */
	public void setDTYPE(String dTYPE) {
		DTYPE = dTYPE;
	}

	/**
	 * @return the regMethod
	 */
	public String getRegMethod() {
		return RegMethod;
	}

	/**
	 * @param regMethod
	 *            the regMethod to set
	 */
	public void setRegMethod(String regMethod) {
		RegMethod = regMethod;
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
	 * @return the kFID
	 */
	public String getKFID() {
		return KFID;
	}

	/**
	 * @param kFID
	 *            the kFID to set
	 */
	public void setKFID(String kFID) {
		KFID = kFID;
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
	 * @return the isNewUser
	 */
	public String getIsNewUser() {
		return IsNewUser;
	}

	/**
	 * @param isNewUser
	 *            the isNewUser to set
	 */
	public void setIsNewUser(String isNewUser) {
		IsNewUser = isNewUser;
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
	 * @return the talkAccount
	 */
	public String getTalkAccount() {
		return TalkAccount;
	}

	/**
	 * @param talkAccount
	 *            the talkAccount to set
	 */
	public void setTalkAccount(String talkAccount) {
		TalkAccount = talkAccount;
	}

	/**
	 * @return the talkPassword
	 */
	public String getTalkPassword() {
		return TalkPassword;
	}

	/**
	 * @param talkPassword
	 *            the talkPassword to set
	 */
	public void setTalkPassword(String talkPassword) {
		TalkPassword = talkPassword;
	}

	/**
	 * @return the uHomePassword
	 */
	public String getUHomePassword() {
		return UHomePassword;
	}

	/**
	 * @param uHomePassword
	 *            the uHomePassword to set
	 */
	public void setUHomePassword(String uHomePassword) {
		UHomePassword = uHomePassword;
	}

	/**
	 * @return the isAudited
	 */
	public String getIsAudited() {
		return IsAudited;
	}

	/**
	 * @param isAudited
	 *            the isAudited to set
	 */
	public void setIsAudited(String isAudited) {
		IsAudited = isAudited;
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
	 * @return the rKE_IsChild
	 */
	public String getRKE_IsChild() {
		return RKE_IsChild;
	}

	/**
	 * @param rKE_IsChild
	 *            the rKE_IsChild to set
	 */
	public void setRKE_IsChild(String rKE_IsChild) {
		RKE_IsChild = rKE_IsChild;
	}

	/**
	 * @return the rKE_FingerPrint
	 */
	public String getRKE_FingerPrint() {
		return RKE_FingerPrint;
	}

	/**
	 * @param rKE_FingerPrint
	 *            the rKE_FingerPrint to set
	 */
	public void setRKE_FingerPrint(String rKE_FingerPrint) {
		RKE_FingerPrint = rKE_FingerPrint;
	}

	/**
	 * @return the rKE_CallPhone
	 */
	public String getRKE_CallPhone() {
		return RKE_CallPhone;
	}

	/**
	 * @param rKE_CallPhone
	 *            the rKE_CallPhone to set
	 */
	public void setRKE_CallPhone(String rKE_CallPhone) {
		RKE_CallPhone = rKE_CallPhone;
	}

	/**
	 * @return the rKE_MaxCardCount
	 */
	public String getRKE_MaxCardCount() {
		return RKE_MaxCardCount;
	}

	/**
	 * @param rKE_MaxCardCount
	 *            the rKE_MaxCardCount to set
	 */
	public void setRKE_MaxCardCount(String rKE_MaxCardCount) {
		RKE_MaxCardCount = rKE_MaxCardCount;
	}

	/**
	 * @return the oR_ID
	 */
	public String getOR_ID() {
		return OR_ID;
	}

	/**
	 * @param oR_ID
	 *            the oR_ID to set
	 */
	public void setOR_ID(String oR_ID) {
		OR_ID = oR_ID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SysBaseUser [ID=" + ID + ", HID=" + HID + ", Account=" + Account + ", MOBILE=" + MOBILE + ", TEL=" + TEL
				+ ", NickName=" + NickName + ", NAME=" + NAME + ", IdentityNo=" + IdentityNo + ", BirthDay=" + BirthDay
				+ ", Gender=" + Gender + ", ADDRESS=" + ADDRESS + ", REGTIME=" + REGTIME + ", LastModifyTime="
				+ LastModifyTime + ", HeadImage=" + HeadImage + ", EMAIL=" + EMAIL + ", QQ=" + QQ + ", WX=" + WX
				+ ", ZT=" + ZT + ", REMARK=" + REMARK + ", DTYPE=" + DTYPE + ", RegMethod=" + RegMethod + ", Creator="
				+ Creator + ", KFID=" + KFID + ", IdentityType=" + IdentityType + ", IsNewUser=" + IsNewUser
				+ ", COMID=" + COMID + ", ROOMID=" + ROOMID + ", TalkAccount=" + TalkAccount + ", TalkPassword="
				+ TalkPassword + ", UHomePassword=" + UHomePassword + ", IsAudited=" + IsAudited + ", AccountSid="
				+ AccountSid + ", RKE_IsChild=" + RKE_IsChild + ", RKE_FingerPrint=" + RKE_FingerPrint
				+ ", RKE_CallPhone=" + RKE_CallPhone + ", RKE_MaxCardCount=" + RKE_MaxCardCount + "]";
	}

}
