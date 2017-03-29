/**
 * 
 */
package cn.tc.ulife.platform.agent.controller.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tc.ulife.platform.agent.base.BaseController;
import cn.tc.ulife.platform.agent.componet.SystemLog;
import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.server.marketing.model.ComCodeBean;
import cn.tc.ulife.platform.server.utils.service.ComCodeService;

/**
 * 公用下拉框
 * 
 * @author lcc
 * 
 */
@Controller
@RequestMapping("/comcode")
public class ComCodeController extends BaseController {
	@Autowired
	private ComCodeService comCodeService;
	
	private ComCodeBean comCodeBean;


	/**
	 * 根据当前用户获取其小区
	 * 日期 2017年2月27日
	 * 时间 下午2:20:01
	 * 创建者 Lcc
	 * @param uid
	 * @param comCodeBean
	 * @return
	 */
	@RequestMapping("/getRoleComm")
	@ResponseBody
	@SystemLog(description="公用的根据用户获取小区")
	public ReturnMsg getRoleComm(@RequestParam String uid) {
		comCodeBean = new ComCodeBean();
		comCodeBean.setBizid(uid);
		return AppResponseMsg.success(comCodeService.getRoleComm(comCodeBean));
	}
	
	
	
	/**
	 * 查询代理商
	 * 日期 2017年2月28日
	 * 时间 下午6:00:27
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	@RequestMapping("/getDlsStore")
	@ResponseBody
	@SystemLog(description="查询全部代理商,没有查询条件")
	public ReturnMsg getDlsStore(ComCodeBean bean){
		return AppResponseMsg.success(comCodeService.getDlsStore(bean));
	}
	
	
	/**
	 * 营销规则下拉框
	 * 
	 * @return
	 */
	@RequestMapping("/getyxgzStore")
	@ResponseBody
	public ReturnMsg getyxgzStore(ComCodeBean code) {
		return AppResponseMsg.success(comCodeService.getyxgzStore(code));
	}
	
	/**
	 * 根据产品线获取商家
	 * 日期 2017年3月17日
	 * 时间 上午9:11:54
	 * 创建者 Lcc
	 * @param id
	 * @return
	 */
	@RequestMapping("/getStoreByPl")
	@ResponseBody
	public ReturnMsg getStoreByPl(ComCodeBean code) {
		return AppResponseMsg.success(comCodeService.getStoreByPl(code));
	}
	
	
}
