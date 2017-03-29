package cn.tc.ulife.platform.server.sys.dao;

import java.util.List;

import cn.tc.ulife.platform.server.sys.model.MenuBean;
import cn.tc.ulife.platform.server.tree.model.TreeNode;

public interface MenuMapper
{
	
	List<TreeNode> getMenuTree(TreeNode treeNode);
	
	List<TreeNode> getMenuChildren(TreeNode treeNode);
	
	List<MenuBean> getMenuButton(MenuBean bean);
	
	List<MenuBean> getAdminMenuButton(MenuBean bean);
	
	List<TreeNode> getAdminMenu(TreeNode treeNode);
	
	List<TreeNode> getAdminMenuChildren(TreeNode treeNode);
	
	int saveMenu(MenuBean bean);
	
	int saveMenuBtton(MenuBean bean);
	
	int updateMenu(MenuBean bean);
	
	int updateMenuButton(MenuBean bean);
	
	int removeMenuButton(MenuBean bean);
	
	int removeMenu(MenuBean bean);
	
}
