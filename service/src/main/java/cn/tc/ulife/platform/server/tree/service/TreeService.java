package cn.tc.ulife.platform.server.tree.service;

import java.util.List;

import cn.tc.ulife.platform.server.tree.model.TreeNode;

/**
 * 公用树形机构业务结构
 * 日期 2017年2月16日
 * 时间 上午10:30:54
 * @author lwy
 *
 */
public interface TreeService {
    /**
     * 地区树形结构
     * 日期 2017年2月16日
     * 时间 上午9:59:15
     * 创建者 lwy
     * @param treeNode
     * @return
     */
    public List<TreeNode> getAreaTree(TreeNode treeNode);
    
    /**
     * 获取营销类目树
     * 日期 2017年2月23日
     * 时间 下午5:44:15
     * 创建者 Lcc
     * @param node
     * @return
     */
    public List<TreeNode> getMarketingCategoryTree(TreeNode node);

    /**
     * 商品分类树形结构
     * @param treeNode
     * @return
     */
    public List<TreeNode> getSpflTree(TreeNode treeNode);

    /**
     * 产品线对应的商品分类
     * @param treeNode
     * @return
     */
    public List<TreeNode> getPLineFlTree(TreeNode treeNode);

    /**
     * 商家对应商品分类
     * @param treeNode
     * @return
     */
    public List<TreeNode> getStoreFlTree(TreeNode treeNode);
}
