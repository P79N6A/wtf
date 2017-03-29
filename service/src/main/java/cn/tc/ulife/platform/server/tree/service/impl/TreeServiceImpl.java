package cn.tc.ulife.platform.server.tree.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tc.ulife.platform.server.tree.dao.TreeDao;
import cn.tc.ulife.platform.server.tree.model.TreeNode;
import cn.tc.ulife.platform.server.tree.service.TreeService;
/**
 * 公用树形结构业务实现类
 * 日期 2017年2月16日
 * 时间 上午10:32:02
 * @author lwy
 *
 */
@Service("treeService")
public class TreeServiceImpl implements TreeService {

    @Autowired
    TreeDao treeDao;

    /**
     * 地区树形结构
     * 日期 2017年2月16日
     * 时间 上午9:59:15
     * 创建者 lwy
     * @param treeNode
     * @return
     */
    @Override
    public List<TreeNode> getAreaTree(TreeNode treeNode) {
        // 获取省
        List<TreeNode> root = treeDao.getAreaTree(treeNode);
        // 市
        List<TreeNode> sec;
        for (TreeNode node : root) {
            sec = new ArrayList<TreeNode>();
            node.setPid(node.getId());
            // 获取市
            sec = treeDao.getAreaTreeChildren(node);
            if (null != sec && sec.size() > 0) {
                node.setChildren(sec);
            }

        }
        return root;
    }

    @Override
    public List<TreeNode> getSpflTree(TreeNode treeNode) {
        List<TreeNode> root = treeDao.getLeadTypeTree(treeNode);
        List<TreeNode> result=new ArrayList<TreeNode>();
        List<TreeNode> second = null;
        List<TreeNode> third = null;
        for (TreeNode node : root) {
            second = new ArrayList<TreeNode>();
            node.setPid(node.getId());
            second = treeDao.getChildTypeTree(node);
            if (null != second && second.size() > 0)
            {
                node.setChildren(second);
                for (TreeNode snode : second) {
                    snode.setPid(snode.getId());
                    third = treeDao.getChildTypeTree(snode);
                    if (null != third && third.size() > 0)
                    {
                        snode.setChildren(third);
                    }
                }
                result.add(node);
            }else
            {
                result=root;
            }
        }
        return root;
    }

    @Override
    public List<TreeNode> getPLineFlTree(TreeNode treeNode) {
        List<TreeNode> result=new ArrayList<TreeNode>();
        List<TreeNode> root = null;
        List<TreeNode> sec;
        List<TreeNode> third;
        root = treeDao.getPLineFlTree(treeNode);
        for (TreeNode node : root) {
            sec = new ArrayList<TreeNode>();
            treeNode.setPid(node.getId());
            sec = treeDao.getPLineFlTreeChildren(treeNode);
            if (null != sec && sec.size() > 0) {
                node.setChildren(sec);
                for (TreeNode snode : sec) {
                    treeNode.setPid(snode.getId());
                    third = treeDao.getPLineFlTreeChildren(treeNode);
                    if (null != third && third.size() > 0)
                    {
                        snode.setChildren(third);
                    }
                }
                result.add(node);
            }else
            {
                result=root;
            }
        }
        return result;
    }

    @Override
    public List<TreeNode> getStoreFlTree(TreeNode treeNode) {
        List<TreeNode> result=new ArrayList<TreeNode>();
        List<TreeNode> root = null;
        List<TreeNode> sec;
        List<TreeNode> third;
        root = treeDao.getStoreFlTree(treeNode);
        for (TreeNode node : root) {
            sec = new ArrayList<TreeNode>();
            treeNode.setPid(node.getId());
            sec = treeDao.getStoreFlTreeChildren(treeNode);
            if (null != sec && sec.size() > 0) {
                node.setChildren(sec);
                for (TreeNode snode : sec) {
                    treeNode.setPid(snode.getId());
                    third = treeDao.getStoreFlTreeChildren(treeNode);
                    if (null != third && third.size() > 0)
                    {
                        snode.setChildren(third);
                    }
                }
                result.add(node);
            }else
            {
                result=root;
            }
        }
        return result;
    }


    public List<TreeNode> getMarketingCategoryTree(TreeNode node){

    	List<TreeNode> root = treeDao.getMarketingCategoryTree(node);
		List<TreeNode> second;
		for (TreeNode nodes : root) {
			second = new ArrayList<TreeNode>();
			nodes.setPid(nodes.getId());
			second = treeDao.getMarketingCategoryChildrenTree(nodes);
			if (null != second && second.size() > 0)
			{
				nodes.setChildren(second);
			}
		}
		return root;
    }

}
