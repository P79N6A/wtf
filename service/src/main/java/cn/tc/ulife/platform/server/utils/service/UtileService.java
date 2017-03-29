package cn.tc.ulife.platform.server.utils.service;

import java.util.List;
import java.util.Map;

import cn.tc.ulife.platform.server.utils.model.UploadBean;
import cn.tc.ulife.platform.server.utils.model.UtileBean;
public interface UtileService
{
	
	List<UtileBean> getRootGroups();
	
	
	/**
	 * 查询数据
	 * 
	 * @param sql
	 * @return list
	 */
	public List<UtileBean> getListData(String sql);
	/**
	 * 新增数据
	 * 
	 * @param sql 
	 */
	public void addData(String sql);

	/**
	 * 修改数据
	 * 
	 * @param sql 
	 */
	public void editData(String sql);
	
	public int updateData(Map<String,String> map);
	
	/**
	 * 删除数据
	 * 
	 * @param sql 
	 */
	public void delData(String sql);
	
	public void saveFileData(UploadBean uploadBean);

}
