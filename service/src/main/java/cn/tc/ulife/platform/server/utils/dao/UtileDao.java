/**
 * 
 */
package cn.tc.ulife.platform.server.utils.dao;

import java.util.List;
import java.util.Map;

import cn.tc.ulife.platform.server.utils.model.UtileBean;

/**
 * @author lwy
 * 
 */
public interface UtileDao
{
	/**
	 * 查询数据
	 * 
	 * @param map
	 * @return list
	 */
	public List<UtileBean> getListData( Map<String,String> map);
	/**
	 * 新增数据
	 * 
	 * @param sql 
	 */
	public void addData( Map<String,String> map);

	/**
	 * 修改数据
	 * 
	 * @param sql 
	 */
	public void editData( Map<String,String> map);
	
	public int updateData(Map<String,String> map);
	
	/**
	 * 删除数据
	 * 
	 * @param sql 
	 */
	public void delData( Map<String,String> map);
}
