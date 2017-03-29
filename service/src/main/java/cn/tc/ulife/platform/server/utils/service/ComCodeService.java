/**
 * 
 */
package cn.tc.ulife.platform.server.utils.service;

import java.util.List;

import cn.tc.ulife.platform.server.marketing.model.ComCodeBean;

/**
 * @author lcc
 * 
 */
public interface ComCodeService
{
	/**
	 * 根据当前用户获取其小区
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
	
	
	/**
	 * 营销规则下拉框store
	 * @return 营销规则store
	 */
	public List<ComCodeBean> getyxgzStore(ComCodeBean code);
	
	
	/**
	 * 营销规则下拉框store
	 * @return 营销规则store
	 */
	public List<ComCodeBean> getStoreByPl(ComCodeBean code);
}
