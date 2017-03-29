/**
 * 
 */
package cn.tc.ulife.platform.server.social.dao;

import java.util.List;

import cn.tc.ulife.platform.server.social.model.BbsModel;

/**
 * @author lpf
 * 活动库
 */
public interface BbsDao {
	public List<BbsModel> getListBbs(BbsModel bbs);
	
	/**
	 * 修改邻居圈信息
	 * 
	 * @param bbs
	 * @return
	 */
	public int updateBbs(BbsModel bbs);
	
	/**
	 * APP 用户获取小区的帖子
	 * 
	 * @param bbs
	 * @return
	 */
	public List<BbsModel> getListBbs_APP(BbsModel bbs);
}
