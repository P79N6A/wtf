/**
 * 
 */
package cn.tc.ulife.platform.door.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tc.ulife.platform.door.dao.DoorDao;
import cn.tc.ulife.platform.door.mode.RKE_EquipmentBean;
import cn.tc.ulife.platform.door.mode.RKE_User_EquipmentBean;
import cn.tc.ulife.platform.door.service.DoorService;

/**
 * @author lpf
 *
 */
@Service("doorService")
public class DoorServiceImpl implements DoorService {

	@Autowired
	private DoorDao doorDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.tc.ulife.platform.door.service.DoorService#testDoor()
	 */
	@Override
	public String testDoor() {
		System.out.println("start server.");
		return "service";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.tc.ulife.platform.door.service.DoorService#insertUserEquipment(cn.tc.
	 * ulife.platform.door.mode.RKE_User_EquipmentBean)
	 */
	@Override
	public int insertUserEquipment(RKE_User_EquipmentBean rueBean) {

		return doorDao.insertUserEquipment(rueBean);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.tc.ulife.platform.door.service.DoorService#queryUserEquipment(cn.tc.
	 * ulife.platform.door.mode.RKE_User_EquipmentBean)
	 */
	@Override
	public RKE_User_EquipmentBean queryUserEquipment(RKE_User_EquipmentBean rueBean) {

		return doorDao.queryUserEquipment(rueBean);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.tc.ulife.platform.door.service.DoorService#updateUserEquipment(cn.tc.
	 * ulife.platform.door.mode.RKE_User_EquipmentBean)
	 */
	@Override
	public int updateUserEquipment(RKE_User_EquipmentBean rueBean) {
		return doorDao.updateUserEquipment(rueBean);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.tc.ulife.platform.door.service.DoorService#queryRKeEquipment(cn.tc.
	 * ulife.platform.door.mode.RKE_EquipmentBean)
	 */
	@Override
	public List<RKE_EquipmentBean> queryRKeEquipment(Map<String, String> map) {
		return doorDao.queryRKeEquipment(map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.tc.ulife.platform.door.service.DoorService#insertEquipment(cn.tc.ulife
	 * .platform.door.mode.RKE_EquipmentBean)
	 */
	@Override
	public int insertEquipment(RKE_EquipmentBean rkeBean) {
		return doorDao.insertEquipment(rkeBean);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.tc.ulife.platform.door.service.DoorService#loginRkeEquipment(java.util
	 * .Map)
	 */
	@Override
	public RKE_EquipmentBean loginRkeEquipment(String account, String pwd) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("EQ_UserName", account);
		map.put("EQ_UserPwd", pwd);
		return doorDao.loginRkeEquipment(map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.tc.ulife.platform.door.service.DoorService#checkRkeAccount(java.lang.
	 * String)
	 */
	@Override
	public int checkRkeAccount(String EQ_UserName) {
		return doorDao.checkRkeAccount(EQ_UserName);
	}

}
