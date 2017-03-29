/**
 * 
 */
package cn.tc.ulife.platform.server.utils.dao;

import java.util.List;

import cn.tc.ulife.platform.server.marketing.model.ComCodeBean;

/**
 * @author lcc
 * 
 */
public interface ComCodeDao
{
	
	/**
	 * 根据当前用户id获取其小区
	 * 
	 * @param ComCodeBean
	 * @return comCodeBean
	 */
	public List<ComCodeBean> getRoleComm(ComCodeBean comCodeBean);
	
	/**
	 * 查询代理商
	 * 日期 2017年2月28日
	 * 时间 下午5:40:56
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	public List<ComCodeBean> getDlsStore(ComCodeBean bean);
	
	
	List<ComCodeBean> getyxgzStore(ComCodeBean code);
	
	List<ComCodeBean> getStoreByPl(ComCodeBean code);
}
