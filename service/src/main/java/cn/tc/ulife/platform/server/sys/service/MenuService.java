package cn.tc.ulife.platform.server.sys.service;

import java.util.List;

import cn.tc.ulife.platform.server.sys.model.MenuBean;
import cn.tc.ulife.platform.server.tree.model.TreeNode;
public interface MenuService
{
	List<TreeNode> getMenuTree(TreeNode treeNode);
	
	List<MenuBean> getMenuButton(MenuBean bean);
	
	boolean editMenu(MenuBean bean);
	
	boolean editMenuButton(MenuBean bean);
	
	boolean removeMenu(MenuBean bean);
	
	boolean removeMenuButton(MenuBean bean);
	
}
