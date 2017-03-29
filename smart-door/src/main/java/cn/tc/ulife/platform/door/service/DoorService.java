/**
 * 
 */
package cn.tc.ulife.platform.door.service;

import java.util.List;
import java.util.Map;

import cn.tc.ulife.platform.door.mode.RKE_EquipmentBean;
import cn.tc.ulife.platform.door.mode.RKE_User_EquipmentBean;

/**
 * @author lpf
 *
 */
public interface DoorService {
	public String testDoor();

	/**
	 * 插入用户房间绑定的门禁
	 * 
	 * @param rueBean
	 * @return
	 */
	public int insertUserEquipment(RKE_User_EquipmentBean rueBean);

	/**
	 * 查询用户房间门禁权限
	 * 
	 * @param rueBean
	 * @return
	 */
	public RKE_User_EquipmentBean queryUserEquipment(RKE_User_EquipmentBean rueBean);

	/**
	 * 修改用户绑定的门禁
	 * 
	 * @param rueBean
	 * @return
	 */
	public int updateUserEquipment(RKE_User_EquipmentBean rueBean);

	/**
	 * 查询门禁列表
	 * 
	 * @param rkeBean
	 * @return
	 */
	public List<RKE_EquipmentBean> queryRKeEquipment(Map<String, String> map);

	/**
	 * 创建设备
	 * 
	 * @param rkeBean
	 * @return
	 */
	public int insertEquipment(RKE_EquipmentBean rkeBean);

	/**
	 * 登录门口机
	 * 
	 * @param map
	 * @return
	 */
	public RKE_EquipmentBean loginRkeEquipment(String account, String pwd);
	
	/**
	 * 检查用户
	 * 
	 * @param EQ_UserName
	 * @return
	 */
	public int checkRkeAccount(String EQ_UserName);
}
