/**
 * 
 */
package cn.tc.ulife.platform.hard.service.impl;

import org.springframework.stereotype.Service;

import cn.tc.ulife.platform.hard.service.HardService;

/**
 * @author lpf
 *
 */
@Service("hardService")
public class HardServiceImpl implements HardService {

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

}
