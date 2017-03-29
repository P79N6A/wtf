/**
 * 
 */
package cn.tc.ulife.platform.server.social.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tc.ulife.platform.server.social.dao.BbsDao;
import cn.tc.ulife.platform.server.social.model.BbsModel;
import cn.tc.ulife.platform.server.social.service.BbsService;

/**
 * @author lpf
 *
 */
@Service("bbsService")
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsDao bbsDao;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.tc.ulife.platform.server.bbs.service.BbsService#getListActivits(cn.tc.
	 * ulife.platform.server.bbs.model.ActivityModel)
	 */
	@Override
	public List<BbsModel> getListBbs(BbsModel bbs) {
		return bbsDao.getListBbs(bbs);
	}

	/* (non-Javadoc)
	 * @see cn.tc.ulife.platform.server.social.service.BbsService#updateBbs(cn.tc.ulife.platform.server.social.model.BbsModel)
	 */
	@Override
	public int updateBbs(BbsModel bbs) {
		// TODO Auto-generated method stub
		return bbsDao.updateBbs(bbs);
	}

	/* (non-Javadoc)
	 * @see cn.tc.ulife.platform.server.social.service.BbsService#getListBbs_APP(cn.tc.ulife.platform.server.social.model.BbsModel)
	 */
	@Override
	public List<BbsModel> getListBbs_APP(BbsModel bbs) {
		// TODO Auto-generated method stub
		return bbsDao.getListBbs_APP(bbs);
	}

}
