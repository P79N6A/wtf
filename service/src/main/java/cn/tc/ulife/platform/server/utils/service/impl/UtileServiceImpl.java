package cn.tc.ulife.platform.server.utils.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tc.ulife.platform.server.utils.dao.UtileDao;
import cn.tc.ulife.platform.server.utils.model.UploadBean;
import cn.tc.ulife.platform.server.utils.model.UtileBean;
import cn.tc.ulife.platform.server.utils.service.UtileService;
import cn.tc.ulife.platform.util.CRMUtil;

@Service("utileService")
public class UtileServiceImpl implements UtileService {
	@Autowired
	private UtileDao utileDao;

	@Override
	public List<UtileBean> getRootGroups() {
		StringBuffer sql = new StringBuffer();
		sql.append("select ID,NAME,CODE from T_SYS_GROOT");
		List<UtileBean> list = utileDao.getListData(CRMUtil.getMap(sql.toString().trim()));
		return list;
	}

	
	/**
	 * 查询数据
	 * 
	 * @param sql
	 * @return list
	 */
	public List<UtileBean> getListData(String sql){
		return utileDao.getListData(CRMUtil.getMap(sql.toString().trim()));
	}
	/**
	 * 新增数据
	 * 
	 * @param sql 
	 */
	public void addData(String sql){
		utileDao.addData(CRMUtil.getMap(sql.toString().trim()));
	}

	/**
	 * 修改数据
	 * 
	 * @param sql 
	 */
	public void editData(String sql){
		utileDao.editData(CRMUtil.getMap(sql.toString().trim()));
	}
	
	public int updateData(Map<String,String> map){
		return utileDao.updateData(map);
	}
	
	
	/**
	 * 删除数据
	 * 
	 * @param sql 
	 */
	public void delData(String sql){
		utileDao.delData(CRMUtil.getMap(sql.toString().trim()));
	}

	/**
	 * 保存文件路径到主表
	 * 日期 2017年3月23日
	 * 时间 上午11:29:36
	 * 创建者 Lcc
	 * @param uploadBean
	 */
	public void saveFileData(UploadBean uploadBean){
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE ").append(uploadBean.getTableName()).append(" SET ");
		sql.append(uploadBean.getCols()).append("='").append(uploadBean.getPath());
		if("t_community".equals(uploadBean.getTableName()))
		{
			sql.append("' WHERE CID=").append(uploadBean.getId());
		}else
		{
			sql.append("' WHERE ID=").append(uploadBean.getId());
		}		
		utileDao.editData(CRMUtil.getMap(sql.toString().trim()));
	}
	
	/**
	 * 保存到附件表
	 * 日期 2017年3月24日
	 * 时间 下午1:07:30
	 * 创建者 Lcc
	 * @param uploadBean
	 */
	public void saveAttachmentTable(UploadBean uploadBean)
	{
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO ").append(uploadBean.getTableName())
				.append("(URL,TNAME,TID,CTIME)VALUES ");
		sql.append("(").append("'").append(uploadBean.getPath()).append("',");
		sql.append("'").append(uploadBean.getServiceTableName()).append("',");
		sql.append(uploadBean.getId()).append(",");
		sql.append(" now() ");
		sql.append(")");

		/*if ("T_SC_SPFL".equals(uploadBean.getTableName()))
		{
			Jedis jedis = JedisTool.getJedis();
			if (null != jedis)
			{
				JedisTool.clearKey(jedis, "spfl");
			}
		}*/

		utileDao.addData(CRMUtil.getMap(sql.toString().trim()));
	}


}
