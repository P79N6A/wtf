/**
 * 
 */
package cn.tc.ulife.platform.server.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tc.ulife.platform.server.sys.dao.SmsDao;
import cn.tc.ulife.platform.server.sys.model.SmsCodeBean;
import cn.tc.ulife.platform.server.sys.service.SmsService;

/**
 * @author lpf
 *
 */
@Service("smsService")
public class SmsServiceImpl implements SmsService {

	@Autowired
	private SmsDao smsDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.tc.ulife.platform.server.sys.service.SmsService#querySmscode(cn.tc.
	 * ulife.platform.server.sys.model.SmsCodeBean)
	 */
	@Override
	public List<SmsCodeBean> querySmscode(String mobile) {
		return smsDao.querySmscode(mobile);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.tc.ulife.platform.server.sys.service.SmsService#insertSmscode(cn.tc.
	 * ulife.platform.server.sys.model.SmsCodeBean)
	 */
	@Override
	public int insertSmscode(SmsCodeBean smsCode) {
		return smsDao.insertSmscode(smsCode);
	}

}
