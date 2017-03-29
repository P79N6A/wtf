/**
 * 
 */
package cn.tc.ulife.platform.server.utils.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tc.ulife.platform.server.marketing.model.ComCodeBean;
import cn.tc.ulife.platform.server.utils.dao.ComCodeDao;
import cn.tc.ulife.platform.server.utils.service.ComCodeService;

/**
 * @author lwy
 * 
 */
@Service("comCodeService")
public class ComCodeServiceImpl implements ComCodeService
{
	@Autowired
	private ComCodeDao comCodeDao;
	
	
	/**
	 * 根据当前用户角色获取其小区
	 * 
	 * @param ComCodeBean
	 * @return comCodeBean
	 */
	public List<ComCodeBean> getRoleComm(ComCodeBean comCodeBean){
		return comCodeDao.getRoleComm(comCodeBean);
	}	
	
	
	@Override
	public List<ComCodeBean> getDlsStore(ComCodeBean bean) {
		return comCodeDao.getDlsStore(bean);
	}
	
	@Override
	public List<ComCodeBean> getyxgzStore(ComCodeBean code)
	{
		return comCodeDao.getyxgzStore(code);
	}
	
	@Override
	public List<ComCodeBean> getStoreByPl(ComCodeBean code)
	{
		return comCodeDao.getStoreByPl(code);
	}
	
}
