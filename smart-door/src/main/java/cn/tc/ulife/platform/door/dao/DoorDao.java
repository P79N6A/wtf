/**
 * 
 */
package cn.tc.ulife.platform.door.dao;

import java.util.List;
import java.util.Map;

import cn.tc.ulife.platform.door.mode.RKE_EquipmentBean;
import cn.tc.ulife.platform.door.mode.RKE_User_EquipmentBean;

/**
 * @author lpf
 *
 */
public interface DoorDao {

	/**
	 * 插入用户 所在房间 与门口机 权限
	 * 
	 * @param rueBean
	 * @return
	 */
	public int insertUserEquipment(RKE_User_EquipmentBean rueBean);

	/**
	 * 查询 用户房间 与门口机权限
	 * 
	 * @param rueBean
	 * @return
	 */
	public RKE_User_EquipmentBean queryUserEquipment(RKE_User_EquipmentBean rueBean);

	/**
	 * x修改 门口机权限
	 * 
	 * @param rueBean
	 * @return
	 */
	public int updateUserEquipment(RKE_User_EquipmentBean rueBean);
	
	/**
	 * 查询门禁列表
	 * @param rkeBean
	 * @return
	 */
	public List<RKE_EquipmentBean> queryRKeEquipment(Map<String, String> map);
	
	/**
	 * 创建设备
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
	public RKE_EquipmentBean loginRkeEquipment(Map<String, String> map);
	
	/**
	 * 检查用户
	 * 
	 * @param EQ_UserName
	 * @return
	 */
	public int checkRkeAccount(String EQ_UserName);
	
}
