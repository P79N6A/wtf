package cn.tc.ulife.platform.agent.controller.sys;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tc.ulife.platform.agent.base.BaseController;
import cn.tc.ulife.platform.agent.componet.SystemLog;
import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.server.sys.model.MenuBean;
import cn.tc.ulife.platform.server.sys.service.MenuService;
import cn.tc.ulife.platform.server.tree.model.TreeNode;
import cn.tc.ulife.platform.server.utils.service.UtileService;
import cn.tc.ulife.platform.validators.Validate;

@Controller
@RequestMapping("menu")
public class MenuController extends BaseController {
	
	@Resource  
	MenuService menuService;
	
	@Autowired
	UtileService utileService;
	
	

	/**
	 * 获取功能菜单
	 * 日期 2017年2月14日
	 * 时间 下午3:09:21
	 * 创建者 Lcc
	 * @return
	 */
	@RequestMapping("/getMenu")
	@ResponseBody
	@SystemLog(description="获取功能菜单")
	public ReturnMsg getMenu(TreeNode treeNode){
		if(menuService.getMenuTree(treeNode).size() >= 0)
			return AppResponseMsg.success(menuService.getMenuTree(treeNode));
		else
			return AppResponseMsg.faild();
	}
	
	
	
	/**
	 * 获取功能菜单按钮
	 * 日期 2017年2月14日
	 * 时间 下午3:07:41
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	@RequestMapping("/getMenuButton")
	@ResponseBody
	@SystemLog(description="获取功能菜单按钮")
	public ReturnMsg getMenuButton(MenuBean bean){
		if(menuService.getMenuButton(bean).size() >= 0)
			return AppResponseMsg.success(menuService.getMenuButton(bean));
		else
			return AppResponseMsg.faild();
	}
	
	
	/**
	 * 获取菜单资源分组
	 * 日期 2017年2月15日
	 * 时间 下午2:03:32
	 * 创建者 Lcc
	 * @return
	 */
	@RequestMapping("/getRootGroups")
	@ResponseBody
	@SystemLog(description="获取菜单资源分组")
	public ReturnMsg getRootGroups(){
		if(utileService.getRootGroups().size() >= 0)
			return AppResponseMsg.success(utileService.getRootGroups());
		else
			return AppResponseMsg.faild();
	} 
	
	/**
	 * 编辑菜单
	 * 日期 2017年2月14日
	 * 时间 下午3:54:08
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	@RequestMapping("/editMenu")
	@ResponseBody
	@SystemLog(description="新增 修改菜单功能")
	public ReturnMsg editMenu(MenuBean bean){
		if(menuService.editMenu(bean))
			return AppResponseMsg.success();
		else
			return AppResponseMsg.faild();
	}
	
	
	/**
	 * 编辑菜单功能
	 * 日期 2017年2月15日
	 * 时间 上午9:19:35
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	@RequestMapping("/editMenuButton")
	@ResponseBody
	@SystemLog(description="新增修改 菜单按钮功能")
	public ReturnMsg editMenuButton(MenuBean bean){
		if(menuService.editMenuButton(bean))
			return AppResponseMsg.success();
		else
			return AppResponseMsg.faild();
	}
	
	/**
	 * 删除菜单功能
	 * 日期 2017年2月15日
	 * 时间 上午9:29:42
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	@RequestMapping("/removeMenu")
	@ResponseBody
	@SystemLog(description="物理删除菜单")
	@Validate
	public ReturnMsg removeMenu(@Validate(isForm=true)MenuBean bean){
		if (StringUtils.isNotEmpty(bean.getId())) {
			if(menuService.removeMenu(bean))
				return AppResponseMsg.success();
			else
				return AppResponseMsg.faild();
		}else{
			return AppResponseMsg.paramIsNull();
		}
	}
	
	
	/**
	 * 删除菜单功能
	 * 日期 2017年2月15日
	 * 时间 上午9:29:58
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	@RequestMapping("/removeMenuButton")
	@ResponseBody
	@SystemLog(description="物理删除菜单功能按钮")
	public ReturnMsg removeMenuButton(MenuBean bean){
		if (StringUtils.isNotEmpty(bean.getId())) {
			if(menuService.removeMenuButton(bean))
				return AppResponseMsg.success();
			else
				return AppResponseMsg.faild();
		}else{
			return AppResponseMsg.paramIsNull();
		}
	}
	
	
}
