/**
 * 
 */
package cn.tc.ulife.platform.door.mode;

import cn.tc.ulife.platform.util.StringUtil;
import cn.tc.ulife.platform.validators.Must;

/**
 * @author lpf 二次封装门口机设备信息
 */
public class ViewRKEEquipmentBean {

	private String account;

	/**
	 * 小区ID
	 */
	@Must
	private String EQ_CommunityID;

	/**
	 * 结构ID 可以是小区ID ， 可以是社区结构
	 */
	@Must
	private String EQ_CS_ID;

	/**
	 * 设备名称
	 */
	@Must
	private String EQ_Name;

	/**
	 * 设备机身编号
	 */
	@Must
	private String EQ_Num;

	/**
	 * 设备码
	 */
	@Must
	private String EQ_DevCode;

	/**
	 * 设备登录账户 3-15 数字+字母
	 */
	@Must
	private String EQ_UserName;

	/**
	 * 设备登录密码
	 */
	@Must
	private String EQ_UserPwd;

	/**
	 * 门禁类型 0 旧改 1 U9
	 */
	@Must
	private String EQ_Type;

	/**
	 * 视频IP
	 */
	private String EQ_IP;

	/**
	 * 视频对讲账户
	 */
	private String EQ_TalkName;

	/**
	 * 视频对讲密码 / token
	 */
	private String EQ_TalkPwd;

	/**
	 * 铃声0-7（默认5）
	 */
	@Must
	private String EQ_Bell;

	/**
	 * 白天媒体0-15（默认11）
	 */
	@Must
	private String EQ_MediaDay;

	/**
	 * 夜间媒体0-15（默认0）
	 */
	@Must
	private String EQ_MediaNight;

	/**
	 * 夜间开始时间小时（默认0
	 */
	@Must
	private String EQ_NightStartHour;

	/**
	 * 夜间开始时间分钟（默认0）
	 */
	@Must
	private String EQ_NightStartMinute;

	/**
	 * 夜间结束时间小时（默认0）
	 */
	@Must
	private String EQ_NightEndHour;

	/**
	 * 夜间结束时间分钟（默认0）
	 */
	@Must
	private String EQ_NightEndMinute;

	/**
	 * 是否播放图片（0不播 1播 ；默认为0不播放）
	 */
	@Must
	private String EQ_IsPlayImage;

	/**
	 * 是否播放视频（0不播 1播 ；默认为0不播放）
	 * 
	 */
	@Must
	private String EQ_IsPlayVideo;

	/**
	 * 图片轮播间隔（1-100秒 ；默认为5秒）
	 */
	@Must
	private String EQ_ImageInterval;

	/**
	 * 呼叫优先级（0 先APP再电话, 1 先电话再APP, 2 仅APP 3仅电话 ； 默认为0）
	 * 
	 */
	@Must
	private String EQ_CallPriority;

	/**
	 * 自动重启时间（0-23、-1为不重启 ； 默认为-1）
	 */
	@Must
	private String EQ_StartTime;

	/**
	 * 关门报警延时（10-255 ； 默认120）
	 */
	@Must
	private String EQ_AlarmTimeDelay;

	/**
	 * 系统配置密码（6位纯数字 ； 默认111111）
	 */
	@Must
	private String EQ_SystemPwd;

	/**
	 * 公共开锁密码（6位纯数字 ； 默认111111）
	 */
	@Must
	private String EQ_SharePwd;

	/**
	 * 通话音量0-5（默认4）
	 */
	@Must
	private String EQ_Volume;

	/**
	 * 设备型号
	 */
	private String EQ_ModelNumber;

	/**
	 * 内核版本
	 */
	private String EQ_KernelVersion;

	/**
	 * 软件版本
	 */
	private String EQ_SoftwareVersion;

	/**
	 * 是否关好
	 */
	private String EQ_IsClosed;

	/**
	 * 是否在线
	 */
	private String EQ_IsOnline;

	/**
	 * 是否启用
	 */
	@Must
	private String EQ_IsEnable;

	/**
	 * 是否密码开锁
	 */
	@Must
	private String EQ_IsNeedPwd;

	/**
	 * 是否自动校准时间
	 */
	@Must
	private String EQ_CalibrateTime;

	/**
	 * 公安局备案ID
	 */
	private String EQ_PoliceRecordID;

	/**
	 * 最后开门时间
	 */
	private String EQ_LastOpenTime;

	/**
	 * 是否允许身份证直接开锁
	 */
	@Must
	private String EQ_OpenByIdCard;

	/**
	 * 是否蓝牙开锁
	 */
	@Must
	private String EQ_OpenByBluetooth;

	/**
	 * 是否能操作门禁卡
	 */
	@Must
	private String EQ_IsDoorStateCheck;

	/**
	 * 
	 */
	private String EQ_AddTime;

	/**
	 * 门口机MAC
	 */
	private String EQ_MAC;

	/**
	 * 人脸识别设备IP
	 */
	private String EQ_FaceIP;

	/**
	 * 人脸识别设备密码
	 */
	private String EQ_FacePwd;

	/**
	 * @return the eQ_CS_ID
	 */
	public String getEQ_CS_ID() {
		return EQ_CS_ID;
	}

	/**
	 * @param eQ_CS_ID
	 *            the eQ_CS_ID to set
	 */
	public void setEQ_CS_ID(String eQ_CS_ID) {
		EQ_CS_ID = eQ_CS_ID;
	}

	/**
	 * @return the eQ_Name
	 */
	public String getEQ_Name() {
		return EQ_Name;
	}

	/**
	 * @param eQ_Name
	 *            the eQ_Name to set
	 */
	public void setEQ_Name(String eQ_Name) {
		EQ_Name = eQ_Name;
	}

	/**
	 * @return the eQ_Num
	 */
	public String getEQ_Num() {
		return EQ_Num;
	}

	/**
	 * @param eQ_Num
	 *            the eQ_Num to set
	 */
	public void setEQ_Num(String eQ_Num) {
		EQ_Num = eQ_Num;
	}

	/**
	 * @return the eQ_UserName
	 */
	public String getEQ_UserName() {
		return EQ_UserName;
	}

	/**
	 * @param eQ_UserName
	 *            the eQ_UserName to set
	 */
	public void setEQ_UserName(String eQ_UserName) {
		EQ_UserName = eQ_UserName;
	}

	/**
	 * @return the eQ_UserPwd
	 */
	public String getEQ_UserPwd() {
		return EQ_UserPwd;
	}

	/**
	 * @param eQ_UserPwd
	 *            the eQ_UserPwd to set
	 */
	public void setEQ_UserPwd(String eQ_UserPwd) {
		EQ_UserPwd = eQ_UserPwd;
	}

	/**
	 * @return the eQ_Type
	 */
	public String getEQ_Type() {
		return EQ_Type;
	}

	/**
	 * @param eQ_Type
	 *            the eQ_Type to set
	 */
	public void setEQ_Type(String eQ_Type) {
		EQ_Type = eQ_Type;
	}

	/**
	 * @return the eQ_IP
	 */
	public String getEQ_IP() {
		return EQ_IP;
	}

	/**
	 * @param eQ_IP
	 *            the eQ_IP to set
	 */
	public void setEQ_IP(String eQ_IP) {
		EQ_IP = eQ_IP;
	}

	/**
	 * @return the eQ_TalkName
	 */
	public String getEQ_TalkName() {
		return EQ_TalkName;
	}

	/**
	 * @param eQ_TalkName
	 *            the eQ_TalkName to set
	 */
	public void setEQ_TalkName(String eQ_TalkName) {
		EQ_TalkName = eQ_TalkName;
	}

	/**
	 * @return the eQ_TalkPwd
	 */
	public String getEQ_TalkPwd() {
		return EQ_TalkPwd;
	}

	/**
	 * @param eQ_TalkPwd
	 *            the eQ_TalkPwd to set
	 */
	public void setEQ_TalkPwd(String eQ_TalkPwd) {
		EQ_TalkPwd = eQ_TalkPwd;
	}

	/**
	 * @return the eQ_Bell
	 */
	public String getEQ_Bell() {
		return EQ_Bell;
	}

	/**
	 * @param eQ_Bell
	 *            the eQ_Bell to set
	 */
	public void setEQ_Bell(String eQ_Bell) {
		EQ_Bell = eQ_Bell;
	}

	/**
	 * @return the eQ_MediaDay
	 */
	public String getEQ_MediaDay() {
		return EQ_MediaDay;
	}

	/**
	 * @param eQ_MediaDay
	 *            the eQ_MediaDay to set
	 */
	public void setEQ_MediaDay(String eQ_MediaDay) {
		EQ_MediaDay = eQ_MediaDay;
	}

	/**
	 * @return the eQ_MediaNight
	 */
	public String getEQ_MediaNight() {
		return EQ_MediaNight;
	}

	/**
	 * @param eQ_MediaNight
	 *            the eQ_MediaNight to set
	 */
	public void setEQ_MediaNight(String eQ_MediaNight) {
		EQ_MediaNight = eQ_MediaNight;
	}

	/**
	 * @return the eQ_NightStartHour
	 */
	public String getEQ_NightStartHour() {
		return EQ_NightStartHour;
	}

	/**
	 * @param eQ_NightStartHour
	 *            the eQ_NightStartHour to set
	 */
	public void setEQ_NightStartHour(String eQ_NightStartHour) {
		EQ_NightStartHour = eQ_NightStartHour;
	}

	/**
	 * @return the eQ_NightStartMinute
	 */
	public String getEQ_NightStartMinute() {
		return EQ_NightStartMinute;
	}

	/**
	 * @param eQ_NightStartMinute
	 *            the eQ_NightStartMinute to set
	 */
	public void setEQ_NightStartMinute(String eQ_NightStartMinute) {
		EQ_NightStartMinute = eQ_NightStartMinute;
	}

	/**
	 * @return the eQ_NightEndHour
	 */
	public String getEQ_NightEndHour() {
		return EQ_NightEndHour;
	}

	/**
	 * @param eQ_NightEndHour
	 *            the eQ_NightEndHour to set
	 */
	public void setEQ_NightEndHour(String eQ_NightEndHour) {
		EQ_NightEndHour = eQ_NightEndHour;
	}

	/**
	 * @return the eQ_NightEndMinute
	 */
	public String getEQ_NightEndMinute() {
		return EQ_NightEndMinute;
	}

	/**
	 * @param eQ_NightEndMinute
	 *            the eQ_NightEndMinute to set
	 */
	public void setEQ_NightEndMinute(String eQ_NightEndMinute) {
		EQ_NightEndMinute = eQ_NightEndMinute;
	}

	/**
	 * @return the eQ_IsPlayImage
	 */
	public String getEQ_IsPlayImage() {
		return EQ_IsPlayImage;
	}

	/**
	 * @param eQ_IsPlayImage
	 *            the eQ_IsPlayImage to set
	 */
	public void setEQ_IsPlayImage(String eQ_IsPlayImage) {
		EQ_IsPlayImage = eQ_IsPlayImage;
	}

	/**
	 * @return the eQ_IsPlayVideo
	 */
	public String getEQ_IsPlayVideo() {
		return EQ_IsPlayVideo;
	}

	/**
	 * @param eQ_IsPlayVideo
	 *            the eQ_IsPlayVideo to set
	 */
	public void setEQ_IsPlayVideo(String eQ_IsPlayVideo) {
		EQ_IsPlayVideo = eQ_IsPlayVideo;
	}

	/**
	 * @return the eQ_ImageInterval
	 */
	public String getEQ_ImageInterval() {
		return EQ_ImageInterval;
	}

	/**
	 * @param eQ_ImageInterval
	 *            the eQ_ImageInterval to set
	 */
	public void setEQ_ImageInterval(String eQ_ImageInterval) {
		EQ_ImageInterval = eQ_ImageInterval;
	}

	/**
	 * @return the eQ_CallPriority
	 */
	public String getEQ_CallPriority() {
		return EQ_CallPriority;
	}

	/**
	 * @param eQ_CallPriority
	 *            the eQ_CallPriority to set
	 */
	public void setEQ_CallPriority(String eQ_CallPriority) {
		EQ_CallPriority = eQ_CallPriority;
	}

	/**
	 * @return the eQ_StartTime
	 */
	public String getEQ_StartTime() {
		return EQ_StartTime;
	}

	/**
	 * @param eQ_StartTime
	 *            the eQ_StartTime to set
	 */
	public void setEQ_StartTime(String eQ_StartTime) {
		EQ_StartTime = eQ_StartTime;
	}

	/**
	 * @return the eQ_AlarmTimeDelay
	 */
	public String getEQ_AlarmTimeDelay() {
		return EQ_AlarmTimeDelay;
	}

	/**
	 * @param eQ_AlarmTimeDelay
	 *            the eQ_AlarmTimeDelay to set
	 */
	public void setEQ_AlarmTimeDelay(String eQ_AlarmTimeDelay) {
		EQ_AlarmTimeDelay = eQ_AlarmTimeDelay;
	}

	/**
	 * @return the eQ_SystemPwd
	 */
	public String getEQ_SystemPwd() {
		return EQ_SystemPwd;
	}

	/**
	 * @param eQ_SystemPwd
	 *            the eQ_SystemPwd to set
	 */
	public void setEQ_SystemPwd(String eQ_SystemPwd) {
		EQ_SystemPwd = eQ_SystemPwd;
	}

	/**
	 * @return the eQ_SharePwd
	 */
	public String getEQ_SharePwd() {
		return EQ_SharePwd;
	}

	/**
	 * @param eQ_SharePwd
	 *            the eQ_SharePwd to set
	 */
	public void setEQ_SharePwd(String eQ_SharePwd) {
		EQ_SharePwd = eQ_SharePwd;
	}

	/**
	 * @return the eQ_Volume
	 */
	public String getEQ_Volume() {
		return EQ_Volume;
	}

	/**
	 * @param eQ_Volume
	 *            the eQ_Volume to set
	 */
	public void setEQ_Volume(String eQ_Volume) {
		EQ_Volume = eQ_Volume;
	}

	/**
	 * @return the eQ_ModelNumber
	 */
	public String getEQ_ModelNumber() {
		return EQ_ModelNumber;
	}

	/**
	 * @param eQ_ModelNumber
	 *            the eQ_ModelNumber to set
	 */
	public void setEQ_ModelNumber(String eQ_ModelNumber) {
		EQ_ModelNumber = eQ_ModelNumber;
	}

	/**
	 * @return the eQ_KernelVersion
	 */
	public String getEQ_KernelVersion() {
		return EQ_KernelVersion;
	}

	/**
	 * @param eQ_KernelVersion
	 *            the eQ_KernelVersion to set
	 */
	public void setEQ_KernelVersion(String eQ_KernelVersion) {
		EQ_KernelVersion = eQ_KernelVersion;
	}

	/**
	 * @return the eQ_SoftwareVersion
	 */
	public String getEQ_SoftwareVersion() {
		return EQ_SoftwareVersion;
	}

	/**
	 * @param eQ_SoftwareVersion
	 *            the eQ_SoftwareVersion to set
	 */
	public void setEQ_SoftwareVersion(String eQ_SoftwareVersion) {
		EQ_SoftwareVersion = eQ_SoftwareVersion;
	}

	/**
	 * @return the eQ_IsClosed
	 */
	public String getEQ_IsClosed() {
		return EQ_IsClosed;
	}

	/**
	 * @param eQ_IsClosed
	 *            the eQ_IsClosed to set
	 */
	public void setEQ_IsClosed(String eQ_IsClosed) {
		EQ_IsClosed = eQ_IsClosed;
	}

	/**
	 * @return the eQ_IsOnline
	 */
	public String getEQ_IsOnline() {
		return EQ_IsOnline;
	}

	/**
	 * @param eQ_IsOnline
	 *            the eQ_IsOnline to set
	 */
	public void setEQ_IsOnline(String eQ_IsOnline) {
		EQ_IsOnline = eQ_IsOnline;
	}

	/**
	 * @return the eQ_IsEnable
	 */
	public String getEQ_IsEnable() {
		return EQ_IsEnable;
	}

	/**
	 * @param eQ_IsEnable
	 *            the eQ_IsEnable to set
	 */
	public void setEQ_IsEnable(String eQ_IsEnable) {
		EQ_IsEnable = eQ_IsEnable;
	}

	/**
	 * @return the eQ_IsNeedPwd
	 */
	public String getEQ_IsNeedPwd() {
		return EQ_IsNeedPwd;
	}

	/**
	 * @param eQ_IsNeedPwd
	 *            the eQ_IsNeedPwd to set
	 */
	public void setEQ_IsNeedPwd(String eQ_IsNeedPwd) {
		EQ_IsNeedPwd = eQ_IsNeedPwd;
	}

	/**
	 * @return the eQ_CalibrateTime
	 */
	public String getEQ_CalibrateTime() {
		return EQ_CalibrateTime;
	}

	/**
	 * @param eQ_CalibrateTime
	 *            the eQ_CalibrateTime to set
	 */
	public void setEQ_CalibrateTime(String eQ_CalibrateTime) {
		EQ_CalibrateTime = eQ_CalibrateTime;
	}

	/**
	 * @return the eQ_PoliceRecordID
	 */
	public String getEQ_PoliceRecordID() {
		return EQ_PoliceRecordID;
	}

	/**
	 * @param eQ_PoliceRecordID
	 *            the eQ_PoliceRecordID to set
	 */
	public void setEQ_PoliceRecordID(String eQ_PoliceRecordID) {
		EQ_PoliceRecordID = eQ_PoliceRecordID;
	}

	/**
	 * @return the eQ_LastOpenTime
	 */
	public String getEQ_LastOpenTime() {
		return EQ_LastOpenTime;
	}

	/**
	 * @param eQ_LastOpenTime
	 *            the eQ_LastOpenTime to set
	 */
	public void setEQ_LastOpenTime(String eQ_LastOpenTime) {
		EQ_LastOpenTime = eQ_LastOpenTime;
	}

	/**
	 * @return the eQ_OpenByIdCard
	 */
	public String getEQ_OpenByIdCard() {
		return EQ_OpenByIdCard;
	}

	/**
	 * @param eQ_OpenByIdCard
	 *            the eQ_OpenByIdCard to set
	 */
	public void setEQ_OpenByIdCard(String eQ_OpenByIdCard) {
		EQ_OpenByIdCard = eQ_OpenByIdCard;
	}

	/**
	 * @return the eQ_OpenByBluetooth
	 */
	public String getEQ_OpenByBluetooth() {
		return EQ_OpenByBluetooth;
	}

	/**
	 * @param eQ_OpenByBluetooth
	 *            the eQ_OpenByBluetooth to set
	 */
	public void setEQ_OpenByBluetooth(String eQ_OpenByBluetooth) {
		EQ_OpenByBluetooth = eQ_OpenByBluetooth;
	}

	/**
	 * @return the eQ_IsDoorStateCheck
	 */
	public String getEQ_IsDoorStateCheck() {
		return EQ_IsDoorStateCheck;
	}

	/**
	 * @param eQ_IsDoorStateCheck
	 *            the eQ_IsDoorStateCheck to set
	 */
	public void setEQ_IsDoorStateCheck(String eQ_IsDoorStateCheck) {
		EQ_IsDoorStateCheck = eQ_IsDoorStateCheck;
	}

	/**
	 * @return the eQ_AddTime
	 */
	public String getEQ_AddTime() {
		return EQ_AddTime;
	}

	/**
	 * @param eQ_AddTime
	 *            the eQ_AddTime to set
	 */
	public void setEQ_AddTime(String eQ_AddTime) {
		EQ_AddTime = eQ_AddTime;
	}

	/**
	 * @return the eQ_MAC
	 */
	public String getEQ_MAC() {
		return EQ_MAC;
	}

	/**
	 * @param eQ_MAC
	 *            the eQ_MAC to set
	 */
	public void setEQ_MAC(String eQ_MAC) {
		EQ_MAC = eQ_MAC;
	}

	/**
	 * @return the eQ_FaceIP
	 */
	public String getEQ_FaceIP() {
		return EQ_FaceIP;
	}

	/**
	 * @param eQ_FaceIP
	 *            the eQ_FaceIP to set
	 */
	public void setEQ_FaceIP(String eQ_FaceIP) {
		EQ_FaceIP = eQ_FaceIP;
	}

	/**
	 * @return the eQ_FacePwd
	 */
	public String getEQ_FacePwd() {
		return EQ_FacePwd;
	}

	/**
	 * @param eQ_FacePwd
	 *            the eQ_FacePwd to set
	 */
	public void setEQ_FacePwd(String eQ_FacePwd) {
		EQ_FacePwd = eQ_FacePwd;
	}

	/**
	 * @return the eQ_CommunityID
	 */
	public String getEQ_CommunityID() {
		return EQ_CommunityID;
	}

	/**
	 * @param eQ_CommunityID
	 *            the eQ_CommunityID to set
	 */
	public void setEQ_CommunityID(String eQ_CommunityID) {
		EQ_CommunityID = eQ_CommunityID;
	}

	/**
	 * @return the eQ_DevCode
	 */
	public String getEQ_DevCode() {
		return EQ_DevCode;
	}

	/**
	 * @param eQ_DevCode
	 *            the eQ_DevCode to set
	 */
	public void setEQ_DevCode(String eQ_DevCode) {
		EQ_DevCode = eQ_DevCode;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ViewRKEEquipmentBean [EQ_CommunityID=" + EQ_CommunityID + ", EQ_CS_ID=" + EQ_CS_ID + ", EQ_Name="
				+ EQ_Name + ", EQ_Num=" + EQ_Num + ", EQ_DevCode=" + EQ_DevCode + ", EQ_UserName=" + EQ_UserName
				+ ", EQ_UserPwd=" + EQ_UserPwd + ", EQ_Type=" + EQ_Type + ", EQ_IP=" + EQ_IP + ", EQ_TalkName="
				+ EQ_TalkName + ", EQ_TalkPwd=" + EQ_TalkPwd + ", EQ_Bell=" + EQ_Bell + ", EQ_MediaDay=" + EQ_MediaDay
				+ ", EQ_MediaNight=" + EQ_MediaNight + ", EQ_NightStartHour=" + EQ_NightStartHour
				+ ", EQ_NightStartMinute=" + EQ_NightStartMinute + ", EQ_NightEndHour=" + EQ_NightEndHour
				+ ", EQ_NightEndMinute=" + EQ_NightEndMinute + ", EQ_IsPlayImage=" + EQ_IsPlayImage
				+ ", EQ_IsPlayVideo=" + EQ_IsPlayVideo + ", EQ_ImageInterval=" + EQ_ImageInterval + ", EQ_CallPriority="
				+ EQ_CallPriority + ", EQ_StartTime=" + EQ_StartTime + ", EQ_AlarmTimeDelay=" + EQ_AlarmTimeDelay
				+ ", EQ_SystemPwd=" + EQ_SystemPwd + ", EQ_SharePwd=" + EQ_SharePwd + ", EQ_Volume=" + EQ_Volume
				+ ", EQ_ModelNumber=" + EQ_ModelNumber + ", EQ_KernelVersion=" + EQ_KernelVersion
				+ ", EQ_SoftwareVersion=" + EQ_SoftwareVersion + ", EQ_IsClosed=" + EQ_IsClosed + ", EQ_IsOnline="
				+ EQ_IsOnline + ", EQ_IsEnable=" + EQ_IsEnable + ", EQ_IsNeedPwd=" + EQ_IsNeedPwd
				+ ", EQ_CalibrateTime=" + EQ_CalibrateTime + ", EQ_PoliceRecordID=" + EQ_PoliceRecordID
				+ ", EQ_LastOpenTime=" + EQ_LastOpenTime + ", EQ_OpenByIdCard=" + EQ_OpenByIdCard
				+ ", EQ_OpenByBluetooth=" + EQ_OpenByBluetooth + ", EQ_IsDoorStateCheck=" + EQ_IsDoorStateCheck
				+ ", EQ_AddTime=" + EQ_AddTime + ", EQ_MAC=" + EQ_MAC + ", EQ_FaceIP=" + EQ_FaceIP + ", EQ_FacePwd="
				+ EQ_FacePwd + "]";
	}

	/**
	 * 判断空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (StringUtil.isEmpty(EQ_CommunityID) || StringUtil.isEmpty(EQ_CS_ID) || StringUtil.isEmpty(EQ_Name)
				|| StringUtil.isEmpty(EQ_Num) || StringUtil.isEmpty(EQ_DevCode) || StringUtil.isEmpty(EQ_UserName)
				|| StringUtil.isEmpty(EQ_UserPwd) || StringUtil.isEmpty(EQ_TalkPwd) || StringUtil.isEmpty(EQ_Bell)
				|| StringUtil.isEmpty(EQ_MediaDay) || StringUtil.isEmpty(EQ_IsPlayImage)
				|| StringUtil.isEmpty(EQ_IsPlayVideo) || StringUtil.isEmpty(EQ_ImageInterval)
				|| StringUtil.isEmpty(EQ_SystemPwd) || StringUtil.isEmpty(EQ_SharePwd) || StringUtil.isEmpty(EQ_Volume)
				|| StringUtil.isEmpty(EQ_IsDoorStateCheck) || StringUtil.isEmpty(EQ_OpenByIdCard)
				|| StringUtil.isEmpty(EQ_CalibrateTime) || StringUtil.isEmpty(EQ_IsNeedPwd)) {
			return true;
		}

		return false;
	}
}
