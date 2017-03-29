/**
 * 
 */
package cn.tc.ulife.platform.server.social.service;

import java.util.List;

import cn.tc.ulife.platform.server.social.model.BbsModel;

/**
 * @author Administrator
 *
 */
public interface BbsService {
	/**
	 * 获取邻居圈列表
	 * 
	 * @param Bbs
	 * @return
	 */
	public List<BbsModel> getListBbs(BbsModel Bbs);
	 
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
