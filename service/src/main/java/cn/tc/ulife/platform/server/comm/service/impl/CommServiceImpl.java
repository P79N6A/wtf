package cn.tc.ulife.platform.server.comm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tc.ulife.platform.server.comm.dao.CommDao;
import cn.tc.ulife.platform.server.comm.model.ComStructureBean;
import cn.tc.ulife.platform.server.comm.model.CommunityBean;
import cn.tc.ulife.platform.server.comm.model.Constants;
import cn.tc.ulife.platform.server.comm.model.RoomBean;
import cn.tc.ulife.platform.server.comm.service.CommService;
import cn.tc.ulife.platform.util.CRMUtil;
/**
 * 社区模块管理业务实现类
 * 日期 2017年2月15日
 * 时间 下午1:26:15
 * @author lwy
 *
 */
@Service("commService")
public class CommServiceImpl implements CommService {
    
    @Autowired
    CommDao commDao;

    /**
     * 根据地区id获取小区列表
     * 日期 2017年2月17日
     * 时间 上午9:26:52
     * 创建者 lwy
     * @param communityBean
     * @return
     */
    @Override
    public List<CommunityBean> getCommList(CommunityBean communityBean) {
	return commDao.getCommList(communityBean);
    }

    /**
     * 根据地区id获取小区列表 总记录
     * 日期 2017年2月17日
     * 时间 上午9:26:52
     * 创建者 lwy
     * @param communityBean
     * @return
     */
    @Override
    public String getCommListTotalCount(CommunityBean communityBean) {
	
	return commDao.getCommListTotalCount(communityBean);
    }

    /**
     * 根据当前用户获取其所属小区
     * 日期 2017年2月20日
     * 时间 上午11:09:04
     * 创建者 lwy
     * @param communityBean
     * @return
     */
    @Override
    public List<CommunityBean> getUserCommList(CommunityBean communityBean) {
	
	return commDao.getUserCommList(communityBean);
    }

    /**
     * 根据当前用户获取其所属小区 总记录
     * 日期 2017年2月20日
     * 时间 上午11:09:22
     * 创建者 lwy
     * @param communityBean
     * @return
     */
    @Override
    public String getUserCommListTotalCount(CommunityBean communityBean) {
	
	return commDao.getUserCommListTotalCount(communityBean);
    }

    /**
     * 新增小区
     * 日期 2017年2月20日
     * 时间 下午1:59:57
     * 创建者 lwy
     * @param bean
     * @return
     */
    @Override
    public void addComm(CommunityBean bean) {
	
	 commDao.addComm(bean);
    }
    /**
     * 修改小区
     * 日期 2017年2月20日
     * 时间 下午2:00:15
     * 创建者 lwy
     * @param bean
     * @return
     */
    @Override
    public void editComm(CommunityBean bean) {
	 commDao.editComm(bean);
    }
    /**
     * 启用停用小区
     * 日期 2017年2月20日
     * 时间 下午2:00:22
     * 创建者 lwy
     * @param bean
     * @return
     */
    @Override
    public void eidtstartOrStopComm(CommunityBean bean) {
	 commDao.eidtstartOrStopComm(bean);
    }
    /**
     * 设置小区支付方式
     * 日期 2017年2月20日
     * 时间 下午2:00:31
     * 创建者 lwy
     * @param bean
     * @return
     */
    @Override
    public void addPayment(CommunityBean bean) {
	 commDao.addPayment(bean);
    }
    /**
     * 设置小区门口机系列
     * 日期 2017年2月20日
     * 时间 下午2:00:42
     * 创建者 lwy
     * @param bean
     * @return
     */
    @Override
    public void saveDoorMachine(CommunityBean bean) {
	 commDao.saveDoorMachine(bean);
    }

    /**
     * 新增校验唯一
     * 日期 2017年2月20日
     * 时间 下午3:29:25
     * 创建者 lwy
     * @param sql
     * @return
     */
    @Override
    public boolean checkUnique(String sql,String type) {
	int num=commDao.checkUnique(CRMUtil.getMap(sql.toString().trim()));
	if(Constants.SYS_DDL_ADD.equals(type)){
	    if(0==num){
		    return true;
		}else{
		    return false;
		}
	}else if(Constants.SYS_DDL_EDIT.equals(type)){
	    if(2>num){
		    return true;
		}else{
		    return false;
	    }
	}else{
	    if(0==num){
		return true;
	    }else{
		return false;
	    }
	}
	    
    }

    /**
     * 查看社区详情
     * 日期 2017年2月21日
     * 时间 上午10:49:59
     * 创建者 lwy
     * @param communityBean
     * @return
     */
    @Override
    public CommunityBean getCommInfo(CommunityBean communityBean) {
	return commDao.getCommInfo(communityBean);
    }

    /**
     * 获取社区结构列表
     * 日期 2017年2月21日
     * 时间 下午1:25:52
     * 创建者 lwy
     * @param bean
     * @return
     */
    @Override
    public List<ComStructureBean> getComStructureList(ComStructureBean bean) {
	return commDao.getComStructureList(bean);
    }
    /**
     * 获取结构列表中记录
     * 日期 2017年2月21日
     * 时间 下午1:26:10
     * 创建者 lwy
     * @param bean
     * @return
     */
    @Override
    public String getComStructureTotalCount(ComStructureBean bean) {
	return commDao.getComStructureTotalCount(bean);
    }
    /**
     * 新增社区结构
     * 日期 2017年2月21日
     * 时间 下午1:30:23
     * 创建者 lwy
     * @param bean
     */
    @Override
    public void addComStru(ComStructureBean bean) {
	commDao.addComStru(bean);
	
    }
    /**
     * 修改社区结构
     * 日期 2017年2月21日
     * 时间 下午1:30:30
     * 创建者 lwy
     * @param bean
     */
    @Override
    public void editComStru(ComStructureBean bean) {
	commDao.editComStru(bean);
	
    }
    /**
     * 删除社区结构
     * 日期 2017年2月21日
     * 时间 下午1:30:39
     * 创建者 lwy
     * @param bean
     */
    @Override
    @Transactional
    public void delComStru(ComStructureBean bean) {
	//1删除当前结构下的房间
	commDao.delRoomById(bean);
	//删除当前结构
	commDao.delComStru(bean);
	
    }
    /**
     * 获取房间列表
     * 日期 2017年2月21日
     * 时间 下午1:25:52
     * 创建者 lwy
     * @param bean
     * @return
     */
    @Override
    public List<RoomBean> getRoomList(RoomBean bean) {
	return commDao.getRoomList(bean);
    }
    /**
     * 获取房间列表总记录
     * 日期 2017年2月21日
     * 时间 下午1:26:10
     * 创建者 lwy
     * @param bean
     * @return
     */
    @Override
    public String getRoomTotalCount(RoomBean bean) {
	return commDao.getRoomTotalCount(bean);
    }
    /**
     * 新增房间
     * 日期 2017年2月21日
     * 时间 下午1:32:24
     * 创建者 lwy
     * @param bean
     */
    @Override
    public void addRoom(RoomBean bean) {
	commDao.addRoom(bean);
	
    }
    /**
     * 修改房间
     * 日期 2017年2月21日
     * 时间 下午1:32:29
     * 创建者 lwy
     * @param bean
     */
    @Override
    public void editRoom(RoomBean bean) {
	commDao.editRoom(bean);
	
    }
    /**
     * 删除房间
     * 日期 2017年2月21日
     * 时间 下午1:32:36
     * 创建者 lwy
     * @param bean
     */
    @Override
    public void delRoom(RoomBean bean) {
	commDao.delRoom(bean);
	
    }
    
    



}
