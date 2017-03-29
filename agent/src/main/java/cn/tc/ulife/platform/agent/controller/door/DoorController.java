/**
 * 
 */
package cn.tc.ulife.platform.agent.controller.door;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.door.manager.HardWareService;
import cn.tc.ulife.platform.door.mode.RKE_EquipmentBean;
import cn.tc.ulife.platform.door.mode.RKE_User_EquipmentBean;
import cn.tc.ulife.platform.door.mode.ViewRKEEquipmentBean;
import cn.tc.ulife.platform.door.mode.ViewUserDoorAuthorBean;
import cn.tc.ulife.platform.door.service.DoorService;
import cn.tc.ulife.platform.msg.send.SmsFactory;
import cn.tc.ulife.platform.msg.send.bean.SmsBean;
import cn.tc.ulife.platform.server.user.model.ViewUserBean;
import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.constance.Constance;
import cn.tc.ulife.platform.validators.Validate;

/**
 * @author lpf 涉及 门口机设备管理
 * 
 *         用户与门口机关系
 */
@Controller
@RequestMapping("door")
public class DoorController {

	@Autowired
	DoorService doorService;

	@RequestMapping("/view")
	@ResponseBody
	public String door() {
		System.out.println("start door.");
		doorService.testDoor();
		return "sss";
	}

	/**
	 * 注册设备
	 * 
	 * @return
	 */
	@RequestMapping("/addEquipment")
	@ResponseBody
	public ReturnMsg addEquipment(String RkeJson) {

		Gson gson = new Gson();

		ViewRKEEquipmentBean viewRke = gson.fromJson(RkeJson, ViewRKEEquipmentBean.class);

		if (viewRke.isEmpty()) {
			return AppResponseMsg.faild("创建失败，参数为空");
		}

		int idx = doorService.checkRkeAccount(viewRke.getEQ_UserName());
		if (idx > 0) {
			return AppResponseMsg.faild("创建失败,设备账户已存在");
		}

		// TODO 创建门口机账户的时候，必须先获取门口机设备机身号和设备码
		// TODO 申请视频对讲账户
		// TODO 将设备信息推送到硬件平台绑定， 完成入库

		StringBuffer url = new StringBuffer();
		url.append(Constance.HARDWARE_Binding_Device);
		url.append("num=").append(viewRke.getEQ_Num());
		url.append("&code=").append(viewRke.getEQ_DevCode());

		JSONObject devJson = HardWareService.getHardService(url.toString(), null);
		if (null == devJson || 0 != (Integer) devJson.get("code")) {
			return AppResponseMsg.faild("创建失败,设备号无法绑定");
		}

		// 请求对讲服务
		JSONObject json = HardWareService.getHardService(Constance.HARDWARE_CreateAccount + viewRke.getEQ_UserName(),
				null);

		if (null == json) {
			return AppResponseMsg.faild("创建失败,对讲账户失败");

		}

		// 10 已经绑定，可能是二次绑定
		if (0 != (Integer) json.get("code")) {

			if (3 == (Integer) json.get("code")) {
				return AppResponseMsg.faild("创建失败,系统未授权视频服务");
			}
			return AppResponseMsg.faild("创建失败,对讲账户失败");

		}

		JSONObject data = json.getJSONObject("data");
		if (null == data || null == data.get("userId")) {
			return AppResponseMsg.faild("创建失败,对讲账户失败");
		}

		RKE_EquipmentBean rke = new RKE_EquipmentBean();
		rke.setEQ_CommunityID(viewRke.getEQ_CommunityID());
		rke.setEQ_CS_ID(viewRke.getEQ_CS_ID());
		rke.setEQ_Name(viewRke.getEQ_Name());
		rke.setEQ_Num(viewRke.getEQ_Num());
		rke.setEQ_DevCode(viewRke.getEQ_DevCode());
		rke.setEQ_UserName(viewRke.getEQ_UserName());
		rke.setEQ_UserPwd(viewRke.getEQ_UserPwd());
		rke.setEQ_Type(viewRke.getEQ_Type());
		// rke.setEQ_IP(viewRke.getEQ_IP());
		rke.setEQ_Bell(viewRke.getEQ_Bell());
		rke.setEQ_MediaDay(viewRke.getEQ_MediaDay());
		rke.setEQ_MediaNight(viewRke.getEQ_MediaDay());
		rke.setEQ_NightEndHour(viewRke.getEQ_NightEndHour());
		rke.setEQ_NightEndMinute(viewRke.getEQ_NightEndMinute());
		rke.setEQ_NightStartHour(viewRke.getEQ_NightStartHour());
		rke.setEQ_NightStartMinute(viewRke.getEQ_NightStartMinute());
		rke.setEQ_IsPlayImage(viewRke.getEQ_IsPlayImage());
		rke.setEQ_IsPlayVideo(viewRke.getEQ_IsPlayVideo());
		rke.setEQ_ImageInterval(viewRke.getEQ_ImageInterval());
		rke.setEQ_CallPriority(viewRke.getEQ_CallPriority());
		rke.setEQ_StartTime(viewRke.getEQ_StartTime());
		rke.setEQ_AlarmTimeDelay(viewRke.getEQ_AlarmTimeDelay());
		rke.setEQ_SystemPwd(viewRke.getEQ_SystemPwd());
		rke.setEQ_SharePwd(viewRke.getEQ_SharePwd());
		rke.setEQ_Volume(viewRke.getEQ_Volume());
		// rke.setEQ_ModelNumber(viewRke.getEQ_ModelNumber());
		// EQ_KernelVersion

		// EQ_SoftwareVersion
		// rke.setEQ_IsClosed(viewRke.getEQ_IsClosed());
		// EQ_IsOnline
		// EQ_IsEnable
		rke.setEQ_IsEnable(viewRke.getEQ_IsEnable());
		rke.setEQ_IsNeedPwd(viewRke.getEQ_IsNeedPwd());
		rke.setEQ_CalibrateTime(viewRke.getEQ_CallPriority());
		// EQ_PoliceRecordID

		// EQ_LastOpenTime
		rke.setEQ_OpenByIdCard(viewRke.getEQ_OpenByIdCard());
		rke.setEQ_OpenByBluetooth(viewRke.getEQ_OpenByBluetooth());
		rke.setEQ_IsDoorStateCheck(viewRke.getEQ_IsDoorStateCheck());
		// EQ_AddTime
		// EQ_MAC
		rke.setCreater(viewRke.getAccount());
		rke.setAccountSid(Constance.HARDWARE_CLOUD_APPID);
		// EQ_FaceIP
		// EQ_FacePwd

		rke.setEQ_TalkName(data.get("userId").toString());
		rke.setEQ_TalkPwd(data.get("loginToken").toString());

		int code = doorService.insertEquipment(rke);
		if (0 == code) {
			AppResponseMsg.faild("创建失败");
		}
		return AppResponseMsg.success("创建成功");
	}

	/**
	 * 查询某一个用户 在 房间 的 授权用户门禁
	 * 
	 * @return
	 */
	@RequestMapping("/queryUserDoor")
	@ResponseBody
	@Validate
	public String queryAuthorUserDoor(RKE_User_EquipmentBean rkeUser) {
		doorService.queryUserEquipment(rkeUser);
		return "";
	}

	/**
	 * 授权用户门禁
	 * 
	 * @param rkeUser
	 *            用户授权的基础信息
	 * @param roomComms
	 *            用户房间所在的结构信息 数组
	 * @return
	 */
	@RequestMapping("/authorUserDoor")
	@ResponseBody
	@Validate
	public ReturnMsg authorUserDoor(@Validate(isForm = true) ViewUserDoorAuthorBean viewUser) {

		RKE_User_EquipmentBean rkeUser = new RKE_User_EquipmentBean();
		rkeUser.setAccountSid(Constance.HARDWARE_CLOUD_APPID);
		rkeUser.setCreator(viewUser.getAccount());
		rkeUser.setUID(viewUser.getUid());
		rkeUser.setRH_R_ID(viewUser.getU_RID());
		rkeUser.setRH_AddrAuthCode("");
		rkeUser.setRH_AppTalkable(viewUser.getRH_AppTalkable());
		rkeUser.setRH_FingerPrintCode1(viewUser.getRH_FingerPrintCode1());
		rkeUser.setRH_IsAudited(viewUser.getRH_IsAudited());
		rkeUser.setRH_IsShowMKJ(viewUser.getRH_IsShowMKJ());
		rkeUser.setRH_IsVideoCall(viewUser.getRH_IsVideoCall());
		rkeUser.setRH_PhoneTalkable(viewUser.getRH_PhoneTalkable());
		rkeUser.setRH_PowerEndTime(viewUser.getRH_PowerEndTime());
		rkeUser.setRH_PowerStartTime(viewUser.getRH_PowerStartTime());

		// 授权门禁，先更新数据库， 然后同步到门口机对象中(主动推送到门口机)
		int code = doorService.insertUserEquipment(rkeUser);
		if (code > 0 && Constance.DEFAULT_ONE.equals(viewUser.getRH_IsShowMKJ())) {
			// 通过小区ID 和社区结构ID集合 查询门禁列表
			Map<String, String> map = new HashMap<String, String>();
			map.put("EQ_CommunityID", viewUser.getCommId());
			map.put("EQ_CS_ID", viewUser.getIds());
			List<RKE_EquipmentBean> rkes = doorService.queryRKeEquipment(map);
			if (null != rkes && !rkes.isEmpty()) {

				JSONObject data = new JSONObject();
				data.put("data", new JSONObject(rkeUser).toString());
				for (RKE_EquipmentBean rke : rkes) {

					// 循环推送到门口机 走线程池操作 无需返回结果
					HardWareService.sendHardService(Constance.HARDWARE_SendDeviceInfo_NOBack + rke.getEQ_Num(),
							data.toString());

				}
			}
		} else {
			return AppResponseMsg.faild("授权失败");
		}

		if (Constance.DEFAULT_ONE.equals(viewUser.getRH_IsAudited())) {

			SmsBean sb = new SmsBean();
			if (1 == sb.getSms_type()) {
				// ali
				Map<String, String> txt = new HashMap<String, String>();
				txt.put("comname", viewUser.getComName());
				txt.put("number", viewUser.getMobile());
				String contxt = JSONObject.valueToString(txt);
				sb.setSignName(ConfigUtil.getMsgProperties("SMS_ALI_SIGNNAME_1"));
				sb.setTempCode(ConfigUtil.getMsgProperties("SMS_ALI_DOOR_AOTHOR"));
				sb.setTxt(contxt);

			} else if (2 == sb.getSms_type()) {
				// sm
				StringBuffer contxt = new StringBuffer();
				contxt.append("@1@=").append(viewUser.getComName());
				contxt.append(",@2@=").append(viewUser.getMobile());
			 
				sb.setTempCode(ConfigUtil.getMsgProperties("SMS_SM_DOOR_AUTOR"));
				sb.setTxt(contxt.toString());

			}
			sb.setRecNum(viewUser.getMobile());
			SmsFactory.send(sb);
			// StringBuffer contxt = new StringBuffer();
			// contxt.append("@1@=").append(viewUser.getComName());
			// contxt.append(",@2@=").append(viewUser.getMobile());
			// 当状态是审核的，默认发送短信通知
			// TODO 测试可发送短信
			// SendSMS.sendTemplateSms(viewUser.getMobile(), "JSM41047-0012",
			// contxt.toString());
		}

		return AppResponseMsg.success("授权成功");

	}

	/**
	 * 修改授权用户门禁
	 * 
	 * @return
	 */
	@RequestMapping("/updAuthorUserDoor")
	@ResponseBody
	@Validate
	public String updAuthorUserDoor(RKE_User_EquipmentBean rkeUser) {
		doorService.updateUserEquipment(rkeUser);
		return "";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ViewUserBean vub = new ViewUserBean();
		vub.setNAME("lpf");
		vub.setNickName("111");
		System.out.println(new JSONObject(vub).toString());
	}

}
