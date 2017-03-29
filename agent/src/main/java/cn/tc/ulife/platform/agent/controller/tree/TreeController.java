package cn.tc.ulife.platform.agent.controller.tree;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tc.ulife.platform.agent.base.BaseController;
import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.server.tree.model.TreeNode;
import cn.tc.ulife.platform.server.tree.service.TreeService;
import cn.tc.ulife.platform.server.user.service.UserCacheService;

@Controller
@RequestMapping("tree")
public class TreeController extends BaseController {
    
    @Autowired
    TreeService treeService;
    
    @Autowired
    UserCacheService userCacheService;
    
    /**
     * 获取地区树形结构数据
     * 日期 2017年2月16日
     * 时间 下午2:00:47
     * 创建者 lwy
     * @param treeNode
     * @return
     */
    @RequestMapping("/getAreaTree")
    @ResponseBody
    public ReturnMsg getAreaTree(TreeNode treeNode){
	return AppResponseMsg.success(treeService.getAreaTree(treeNode));
    }
    
    
    /**
     * 获取营销类目树形数据
     * 日期 2017年2月24日
     * 时间 上午10:36:08
     * 创建者 Lcc
     * @param cid
     * @param plid
     * @return
     */
    @RequestMapping("/getAdminMarketingCategoryTree")
	@ResponseBody
	public ReturnMsg getAdminMarketingCategoryTree(String cid, String plid) {
			TreeNode node = new TreeNode();
			/*if (Constants.R_CJYYS.equals(getRcode())) {
				node.setCode(getUserId());
			} else {
				node.setCode(cid);
			}*/
			node.setCode(cid);
			node.setPlid(plid);
		return AppResponseMsg.success(treeService.getMarketingCategoryTree(node));
	}
    
    /**
     * 获取营销类目树形数据(代理商)
     * 日期 2017年2月24日
     * 时间 上午10:36:08
     * 创建者 Lcc
     * @param cid
     * @param plid
     * @return
     */
    @RequestMapping("/getMarketingCategoryTree")
	@ResponseBody
	public ReturnMsg getMarketingCategoryTree(String cid, String plid) {
			TreeNode node = new TreeNode();
			/*if (Constants.R_CJYYS.equals(getRcode())) {
				node.setCode(getUserId());
			} else {
				node.setCode(cid);
			}*/
			node.setCode(userCacheService.getAgentInfo(cid).getId());
			node.setPlid(plid);
		return AppResponseMsg.success(treeService.getMarketingCategoryTree(node));
	}

    /**
     * 获取地区树形结构数据
     * 日期 2017年2月16日
     * 时间 下午2:00:47
     * 创建者 lwy
     * @param treeNode
     * @return
     */
    @RequestMapping("/getSpflTree")
    @ResponseBody
    public ReturnMsg getSpflTree(TreeNode treeNode){
	return AppResponseMsg.success(treeService.getSpflTree(treeNode));
    }

    /**
     * 获取产品线分类树
     *
     * @return
     */
    @RequestMapping("/getPLineFlTree")
    @ResponseBody
    public ReturnMsg getPLineFlTree(TreeNode treeNode) {
        return AppResponseMsg.success(treeService.getPLineFlTree(treeNode));
    }

    /**
     * 获取商家分类树
     *
     * @return
     */
    @RequestMapping("/getStoreFlTree")
    @ResponseBody
    public ReturnMsg getStoreFlTree(TreeNode treeNode) {
        return AppResponseMsg.success(treeService.getStoreFlTree(treeNode));
    }

}
