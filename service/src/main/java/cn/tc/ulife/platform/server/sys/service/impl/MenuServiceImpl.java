package cn.tc.ulife.platform.server.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tc.ulife.platform.server.comm.service.CommService;
import cn.tc.ulife.platform.server.sys.dao.MenuMapper;
import cn.tc.ulife.platform.server.sys.model.MenuBean;
import cn.tc.ulife.platform.server.sys.service.MenuService;
import cn.tc.ulife.platform.server.tree.model.TreeNode;
import cn.tc.ulife.platform.util.Constants;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private CommService commService;

	@Override
	public List<TreeNode> getMenuTree(TreeNode treeNode) {
		List<TreeNode> root = new ArrayList<TreeNode>();
		if("-1".equals(treeNode.getUid())){// -1为管理员
			root = new ArrayList<TreeNode>();
			// 一级菜单
			root = menuMapper.getAdminMenu(treeNode);
			// 二级菜单
			List<TreeNode> sec;
			for (TreeNode node : root) {
				sec = new ArrayList<TreeNode>();
				if (Constants.ZT_YX.equals(node.getIsleaf())) {// 是否叶子节点
					node.setPid(node.getId());
					node.setUid(treeNode.getUid());
					// 获取二级菜单
					sec = menuMapper.getAdminMenuChildren(node);
					if (null != sec && sec.size() > 0) {
						node.setChildren(sec);
					}
				}
			}

		}else{    	//用户
			// 一级菜单
			root = new ArrayList<TreeNode>();
			root = menuMapper.getMenuTree(treeNode);
			// 二级菜单
			List<TreeNode> sec;
			for (TreeNode node : root) {
				sec = new ArrayList<TreeNode>();
				if (Constants.ZT_YX.equals(node.getIsleaf())) {// 是否叶子节点
					node.setPid(node.getId());
					node.setUid(treeNode.getUid());
					// 获取二级菜单
					sec = menuMapper.getMenuChildren(node);
					if (null != sec && sec.size() > 0) {
						node.setChildren(sec);
					}
				}
			}
		}
		return root;
	}

	/**
	 * 删除菜单 日期 2017年2月13日 时间 下午3:32:00 创建者Lcc
	 */
	public boolean removeMenu(MenuBean bean) {
		if(this.menuMapper.removeMenu(bean) > 0)
			return true;
		else
			return false;
	}

	/**
	 * 编辑菜单 日期 2017年2月14日 时间 下午3:51:43 创建者 Lcc
	 * 
	 * @param bean
	 * @return
	 */
	public boolean editMenu(MenuBean bean) {
		String sql = "select count(1) from T_SYS_ROOT where zt='0' and ISLEAF = '"+bean.getIsleaf()+"' and name = '"+bean.getName()+"'";
		if (StringUtils.isEmpty(bean.getId())) {
			boolean flag = commService.checkUnique(sql, cn.tc.ulife.platform.server.comm.model.Constants.SYS_DDL_ADD);
			if (flag) {
				if (this.menuMapper.saveMenu(bean) > 0)
					return true;
				else
					return false;
			}
		} else {
			boolean flag = commService.checkUnique(sql, cn.tc.ulife.platform.server.comm.model.Constants.SYS_DDL_EDIT);
			if (flag) {
				if (this.menuMapper.updateMenu(bean) > 0)
					return true;
				else
					return false;
			}
		}
		return false;
	}
	
	
	/**
	 * 编辑菜单功能
	 * 日期 2017年2月15日
	 * 时间 上午9:10:27
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	public boolean editMenuButton(MenuBean bean) {
		String sql = "select count(1) from T_SYS_ROOTACTION where zt='0' and name = '"+bean.getName()+"' and rid = '"+bean.getRid()+"'";
		if (StringUtils.isEmpty(bean.getId())) {
			boolean flag = commService.checkUnique(sql, cn.tc.ulife.platform.server.comm.model.Constants.SYS_DDL_ADD);
			if (flag) {
				if (this.menuMapper.saveMenuBtton(bean) > 0)
					return true;
				else
					return false;
			}
		} else {
			boolean flag = commService.checkUnique(sql, cn.tc.ulife.platform.server.comm.model.Constants.SYS_DDL_EDIT);
			if (flag) {
				if (this.menuMapper.updateMenuButton(bean) > 0)
					return true;
				else
					return false;
			}
		}
		return false;
	}

	/**
	 * 删除菜单功能按钮 日期 2017年2月13日 时间 下午5:41:14 创建者Lcc
	 */
	@Override
	public boolean removeMenuButton(MenuBean bean) {
		if(this.menuMapper.removeMenuButton(bean) > 0)
			return  true;
		else
			return false;
	}

	/**
	 * 查询菜单功能按钮 日期 2017年2月14日 时间 下午1:30:13 创建者Lcc
	 */
	@Override
	public List<MenuBean> getMenuButton(MenuBean bean) {
		if("-1".equals(bean.getUid()))
			return this.menuMapper.getAdminMenuButton(bean);
		else
			return this.menuMapper.getMenuButton(bean);
	}

}
