package cn.tc.ulife.platform.agent.controller.comm;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tc.ulife.platform.agent.base.BaseController;
import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.server.comm.model.ComStructureBean;
import cn.tc.ulife.platform.server.comm.model.CommunityBean;
import cn.tc.ulife.platform.server.comm.model.Constants;
import cn.tc.ulife.platform.server.comm.model.RoomBean;
import cn.tc.ulife.platform.server.comm.service.CommService;
import cn.tc.ulife.platform.validators.Validate;

@Controller
@RequestMapping("community")
public class CommController extends BaseController {
    
    @Autowired
    CommService commService;
    
    /**
     * 获取小区列表
     * 日期 2017年2月17日
     * 时间 上午10:21:33
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/getCommList")
    @ResponseBody
    public ReturnMsg getCommList(CommunityBean bean){
	return AppResponseMsg.success(commService.getCommList(bean),commService.getCommListTotalCount(bean));
    }
    
    /**
     * 根据当前用户类型获取其所属小区列表
     * 日期 2017年2月20日
     * 时间 下午2:52:14
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/getUserCommList")
    @ResponseBody
    public ReturnMsg getUserCommList(CommunityBean bean){
	return AppResponseMsg.success(commService.getUserCommList(bean),commService.getUserCommListTotalCount(bean));
    }
    
    /**
     * 查看社区详情
     * 日期 2017年2月21日
     * 时间 上午10:53:44
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/getCommInfo")
    @ResponseBody
    public ReturnMsg getCommInfo(CommunityBean bean){
	return AppResponseMsg.success(commService.getCommInfo(bean));
    }
    /**
     * 新增小区
     * 日期 2017年2月20日
     * 时间 下午2:55:39
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/addComm")
    @ResponseBody
    @Validate
    public ReturnMsg addComm(@Validate(isForm=true)CommunityBean bean){
	//校验名称是否存在
	String name=bean.getName();
	if(StringUtils.isNotEmpty(name)){
	    name=name.trim();
	    if(commService.checkUnique("SELECT COUNT(1) FROM t_community WHERE NAME ='"+name+"'", Constants.SYS_DDL_ADD)){
		commService.addComm(bean);
		return AppResponseMsg.success();
	    }else{
		return AppResponseMsg.faild(name+"已存在！");
	    }
	}else{
	    return AppResponseMsg.paramIsNull();
	}
    }
    
    /**
     * 修改小区
     * 日期 2017年2月20日
     * 时间 下午2:55:39
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/editComm")
    @ResponseBody
    public ReturnMsg editComm(CommunityBean bean){
	//校验名称是否存在
	String name=bean.getName();
	if(StringUtils.isNotEmpty(name)){
	    name=name.trim();
	    if(commService.checkUnique("SELECT COUNT(1) FROM t_community WHERE NAME ='"+name+"'", Constants.SYS_DDL_EDIT)){
		commService.editComm(bean);
		return AppResponseMsg.success();
	    }else{
		return AppResponseMsg.faild(name+"已存在！");
	    }
	}else{
	    return AppResponseMsg.paramIsNull();
	}
	
    }
    
    /**
     * 启用停用小区
     * 日期 2017年2月20日
     * 时间 下午2:55:39
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/startOrStopComm")
    @ResponseBody
    public ReturnMsg startOrStopComm(CommunityBean bean){
	if(StringUtils.isNotEmpty(bean.getCid())){
	    commService.eidtstartOrStopComm(bean);
	    return AppResponseMsg.success();
	}else{
	    return AppResponseMsg.paramIsNull();
	}
	
    }
    
    /**
     * 设置小区支付方式
     * 日期 2017年2月20日
     * 时间 下午2:55:39
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/addPayment")
    @ResponseBody
    public ReturnMsg addPayment(CommunityBean bean){
	if(StringUtils.isNotEmpty(bean.getCid())){
	    commService.addPayment(bean);
	    return AppResponseMsg.success();
	}else{
	    return AppResponseMsg.paramIsNull();
	}
    }
    
    /**
     * 设置小区门口机系列
     * 日期 2017年2月20日
     * 时间 下午2:55:39
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/saveDoorMachine")
    @ResponseBody
    public ReturnMsg saveDoorMachine(CommunityBean bean){
	if(StringUtils.isNotEmpty(bean.getCid())){
	    commService.saveDoorMachine(bean);
	    return AppResponseMsg.success();
	}else{
	    return AppResponseMsg.paramIsNull();
	}
    }

    /**
     * 获取社区结构那列表
     * 日期 2017年2月21日
     * 时间 下午1:58:00
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/getComStructureList")
    @ResponseBody
    public ReturnMsg getComStructureList(ComStructureBean bean){
	return AppResponseMsg.success(commService.getComStructureList(bean),commService.getComStructureTotalCount(bean));
    }
    
    /**
     * 新增社区结构
     * 日期 2017年2月21日
     * 时间 下午1:58:53
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/addComStru")
    @ResponseBody
    public ReturnMsg addComStru(ComStructureBean bean){
	//校验名称是否存在
	String name=bean.getName();
	if(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(bean.getCommunityId())){
	    name=name.trim();
	    if(commService.checkUnique("SELECT COUNT(1) FROM roombycommunity WHERE NAME ='"+name+"' and CommunityID="+bean.getCommunityId()+" and ParentID="+bean.getParentId(), Constants.SYS_DDL_ADD)){
		if("0".equals(bean.getParentId())){
		    bean.setFullName(bean.getName());
		}else{
		    bean.setFullName(bean.getParentName()+bean.getName());
		}
		commService.addComStru(bean);
		return AppResponseMsg.success();
	    }else{
		return AppResponseMsg.faild(name+"已存在！");
	    }
	}else{
	    return AppResponseMsg.paramIsNull();
	}
    }
    
    /**
     * 修改社区结构
     * 日期 2017年2月21日
     * 时间 下午1:58:53
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/editComStru")
    @ResponseBody
    public ReturnMsg editComStru(ComStructureBean bean){
	//校验名称是否存在
	String name=bean.getName();
	if(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(bean.getRid())){
	    name=name.trim();
	    if(commService.checkUnique("SELECT COUNT(1) FROM roombycommunity WHERE NAME ='"+name+"' and CommunityID="+bean.getCommunityId(), Constants.SYS_DDL_EDIT)){
		if("0".equals(bean.getParentId())){
		    bean.setFullName(bean.getName());
		}else{
		    bean.setFullName(bean.getParentName()+bean.getName());
		}
		commService.editComStru(bean);
		return AppResponseMsg.success();
	    }else{
		return AppResponseMsg.faild(name+"已存在！");
	    }
	}else{
	    return AppResponseMsg.paramIsNull();
	}
    }
    
    /**
     * 删除社区结构(系统下没有任何业务用到当前社区结构及该结构下的房间否则提醒当前社区结构不能删除)
     * 日期 2017年2月21日
     * 时间 下午1:58:53
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/delComStru")
    @ResponseBody
    public ReturnMsg delComStru(ComStructureBean bean){
	//校验当前结构是否可以删除
	String rid=bean.getRid();
	if(StringUtils.isNotEmpty(rid)){
	    //TODO 目前只校验是否有用户注册当前结构下的房间
	    if(commService.checkUnique("SELECT COUNT(1) FROM t_sys_room  R INNER JOIN t_u_baseuser U ON R.RID=U.ROOMID WHERE R.CommunityStructID IN ("+rid+")", Constants.SYS_DDL_DEL)){
		commService.delComStru(bean);
		return AppResponseMsg.success();
	    }else{
		return AppResponseMsg.faild("当前所选社区结构不能删除！");
	    }
	}else{
	    return AppResponseMsg.paramIsNull();
	}
    }
    
    /**
     * 根据社区ID获取房间信息
     * 日期 2017年2月21日
     * 时间 下午2:50:19
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/getRoomList")
    @ResponseBody
    public ReturnMsg getRoomList(RoomBean bean){
	return AppResponseMsg.success(commService.getRoomList(bean),commService.getRoomTotalCount(bean));
    }
    
    /**
     * 新增房间
     * 日期 2017年2月21日
     * 时间 下午3:02:51
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/addRoom")
    @ResponseBody
    public ReturnMsg addRoom(RoomBean bean){
	//校验名称是否存在
	String name=bean.getName();
	if(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(bean.getCommunityId()) && StringUtils.isNotEmpty(bean.getCommunityStructID())){
	    name=name.trim();
	    if(commService.checkUnique("SELECT COUNT(1) FROM t_sys_room WHERE NAME ='"+name+"' and CommunityStructID="+bean.getCommunityStructID(), Constants.SYS_DDL_ADD)){
		commService.addRoom(bean);
		return AppResponseMsg.success();
	    }else{
		return AppResponseMsg.faild(name+"已存在！");
	    }
	}else{
	    return AppResponseMsg.paramIsNull();
	}
    }
    
    /**
     * 修改房间
     * 日期 2017年2月21日
     * 时间 下午3:02:51
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/editRoom")
    @ResponseBody
    public ReturnMsg editRoom(RoomBean bean){
	//校验名称是否存在
	String name=bean.getName();
	if(StringUtils.isNotEmpty(name)){
	    name=name.trim();
	    if(commService.checkUnique("SELECT COUNT(1) FROM t_sys_room WHERE NAME ='"+name+"' and CommunityStructID="+bean.getCommunityStructID(), Constants.SYS_DDL_EDIT)){
		commService.editRoom(bean);
		return AppResponseMsg.success();
	    }else{
		return AppResponseMsg.faild(name+"已存在！");
	    }
	}else{
	    return AppResponseMsg.paramIsNull();
	}
    }
    
    /**
     * 删除社区房间号(只删除没有其他业务使用的房间号否则提示当前所选房间号不能删除！)
     * 日期 2017年2月21日
     * 时间 下午3:21:24
     * 创建者 lwy
     * @param bean
     * @return
     */
    @RequestMapping("/delRoom")
    @ResponseBody
    public ReturnMsg delRoom(RoomBean bean){
	//校验当前结构是否可以删除
	String rid=bean.getRid();
	if(StringUtils.isNotEmpty(rid)){
	    //TODO 目前只校验是否有用户注册当前房间下
	    if(commService.checkUnique("SELECT COUNT(1) FROM t_sys_room  R INNER JOIN t_u_baseuser U ON R.RID=U.ROOMID WHERE R.RID IN ("+rid+")", Constants.SYS_DDL_DEL)){
		commService.delRoom(bean);
		return AppResponseMsg.success();
	    }else{
		return AppResponseMsg.faild("当前所选房间号不能删除！");
	    }
	}else{
	    return AppResponseMsg.paramIsNull();
	}
    }
}
