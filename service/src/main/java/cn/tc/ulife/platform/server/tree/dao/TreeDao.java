package cn.tc.ulife.platform.server.tree.dao;

import java.util.List;

import cn.tc.ulife.platform.server.tree.model.TreeNode;

/**
 * 公用树形结构数据接口
 * 日期 2017年2月16日
 * 时间 上午10:32:16
 * @author lwy
 *
 */
public interface TreeDao {
    public List<TreeNode> getAreaTree(TreeNode treeNode);
    public List<TreeNode> getAreaTreeChildren(TreeNode treeNode);

    List<TreeNode> getMarketingCategoryTree(TreeNode node);
	List<TreeNode> getMarketingCategoryChildrenTree(TreeNode node);

    /**
     * 树形结构根节点
     * @param treeNode
     * @return
     */
    public List<TreeNode> getLeadTypeTree(TreeNode treeNode);

    /**
     * 树形结构子节点
     * @param node
     * @return
     */
    public List<TreeNode> getChildTypeTree(TreeNode node);

    List<TreeNode> getPLineFlTree(TreeNode treeNode);

    List<TreeNode> getPLineFlTreeChildren(TreeNode treeNode);

    List<TreeNode> getStoreFlTree(TreeNode treeNode);

    List<TreeNode> getStoreFlTreeChildren(TreeNode treeNode);
}
