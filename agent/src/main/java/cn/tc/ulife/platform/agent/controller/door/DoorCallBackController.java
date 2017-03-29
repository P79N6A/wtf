/**
 * 
 */
package cn.tc.ulife.platform.agent.controller.door;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.door.mode.RKE_EquipmentBean;
import cn.tc.ulife.platform.door.mode.ViewRKEEquipmentBean;
import cn.tc.ulife.platform.door.service.DoorService;
import cn.tc.ulife.platform.util.jobutil.TokenUtil;
import cn.tc.ulife.platform.validators.Validate;

/**
 * @author lpf 门口机回调平台接口列表
 * 
 *         主动推送或者拉取数据
 */
@Controller
@RequestMapping("calldoor")
public class DoorCallBackController {

	@Autowired
	private DoorService doorService;
	
	/**
	 * 门口机登录平台
	 * 
	 * 返回设置的门口机信息 ,  token
	 * @returne
	 */
	@RequestMapping("/loginDoor")
	@ResponseBody
	@Validate
	public ReturnMsg doorLogin(@Validate(isForm = true) String account, String pwd) {
		
		System.out.println(account+ " =  = " +pwd);
		RKE_EquipmentBean rke = doorService.loginRkeEquipment(account, pwd);
		
		String token = TokenUtil.getEquipmentToken(rke.getAccountSid()+"*"+rke.getEQ_Num(), System.currentTimeMillis()+"");
		
		return AppResponseMsg.success("ok");
	}
	
	/**
	 * 上报设备信息
	 * 
	 * @param token 必须验证token的有效性
	 * 
	 * @param vrkeBean
	 * @return
	 */
	@RequestMapping("/put/equiptment")
	@ResponseBody	
	public ReturnMsg modifyEquipment(ViewRKEEquipmentBean vrkeBean)
	{
		return AppResponseMsg.success("ok");
	}
	
	/**
	 * 上报设备z状态信息
	 *  
	 * @param token 设备标识 
	 * @param status  设备状态  0 离线  1 在线
	 * @return 
	 */
	@RequestMapping("/put/status")
	@ResponseBody	
	public ReturnMsg modifyEquipmentStatus(String token, String status)
	{
		return AppResponseMsg.success("ok");
	}
	
	/**
	 * 设备主动拉取 设备所控的用户房间信息
	 *  
	 * @param token 设备标识 
	 * @return 
	 */
	@RequestMapping("/get/users")
	@ResponseBody	
	public ReturnMsg getEquipmentUsers(String token)
	{
		return AppResponseMsg.success("ok");
	}
	
	/**
	 * 设备主动拉取 设备所控的用户门卡信息
	 *  
	 * @param token 设备标识
	 * @return 
	 */
	@RequestMapping("/get/cards")
	@ResponseBody	
	public ReturnMsg getEquipmentCards(String token)
	{
		return AppResponseMsg.success("ok");
	}
	
	/**
	 * 设备主动拉取 设备 的广告、 公告、 帮助  等发布信息
	 *  
	 * @param token 设备标识
	 * @return 
	 */
	@RequestMapping("/get/viewdata")
	@ResponseBody	
	public ReturnMsg getEquipmentViewData(String token)
	{
		return AppResponseMsg.success("ok");
	}
}
