package cn.tc.ulife.platform.agent.controller.marketing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tc.ulife.platform.agent.base.BaseController;
import cn.tc.ulife.platform.agent.componet.SystemLog;
import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.server.authorization.model.EntityModel;
import cn.tc.ulife.platform.server.marketing.model.ComCodeBean;
import cn.tc.ulife.platform.server.marketing.model.CouponBean;
import cn.tc.ulife.platform.server.marketing.model.CouponuUserBean;
import cn.tc.ulife.platform.server.marketing.model.MarketBean;
import cn.tc.ulife.platform.server.marketing.model.MarketingCategoryBean;
import cn.tc.ulife.platform.server.marketing.model.MspBean;
import cn.tc.ulife.platform.server.marketing.model.PromotionRulesBean;
import cn.tc.ulife.platform.server.marketing.model.SelectShopBean;
import cn.tc.ulife.platform.server.marketing.model.YxStyleBean;
import cn.tc.ulife.platform.server.marketing.model.YxViewBean;
import cn.tc.ulife.platform.server.marketing.model.YxViewPos;
import cn.tc.ulife.platform.server.marketing.service.MarketingService;
import cn.tc.ulife.platform.server.tree.model.TreeNode;
import cn.tc.ulife.platform.server.user.service.UserCacheService;
import cn.tc.ulife.platform.server.utils.dao.UtileDao;
import cn.tc.ulife.platform.server.utils.model.UploadBean;
import cn.tc.ulife.platform.server.utils.model.UtileBean;
import cn.tc.ulife.platform.server.utils.service.UtileService;
import cn.tc.ulife.platform.util.CRMUtil;
import cn.tc.ulife.platform.util.UploadFileUtil;
import cn.tc.ulife.platform.validators.Validate;

/**
 * 营销管理 日期 2017年2月21日 时间 下午4:09:47
 * 
 * @author Lcc
 *
 */
@Controller
@RequestMapping("/marketing")
public class MarketingController extends BaseController {
	@Autowired
	private MarketingService marketingServer;
	
	private JSONObject json;
	@Autowired
	private UtileDao utile;
	@Autowired
	private UtileService utileService;
	@Autowired
	private UserCacheService userCacheService;

	/**
	 * 获取营销规则
	 * 日期 2017年2月23日
	 * 时间 下午3:37:20
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	@RequestMapping("/getPromotionRules")
	@ResponseBody
	@SystemLog(description="查询全部营销规则")
	public ReturnMsg getPromotionRules(PromotionRulesBean bean) {
			/*
			 * 不要分页
			Map<String, Object> map = checkPage(String.valueOf(bean.getStart()), String.valueOf(bean.getLimit()));
			bean.setStart((Integer) map.get("ofset"));
			bean.setLimit((Integer) map.get("psize"));
			*/
		if (this.marketingServer.getPromotionRules(bean).size() >= 0)
			return AppResponseMsg.success(this.marketingServer.getPromotionRules(bean));
		else
			return AppResponseMsg.faild();
	}

	/**
	 * 编辑营销规则表
	 * 日期 2017年2月23日
	 * 时间 下午3:40:35
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	@RequestMapping("/editPromotionRules")
	@ResponseBody
	@SystemLog(description="新增,修改营销规则")
	public ReturnMsg editPromotionRules(PromotionRulesBean bean) {
		return AppResponseMsg.result(marketingServer.savePromotionRules(bean));
	}
	
	
	/**
	 * 删除营销规则
	 * 日期 2017年2月23日
	 * 时间 下午3:40:35
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	@RequestMapping("/removePromotionRules")
	@ResponseBody
	@SystemLog(description="支持批量删除营销规则")
	public ReturnMsg removePromotionRules(PromotionRulesBean bean) {
		int result = this.marketingServer.removePromotionRules(bean);
		if (result > 0) 
			return AppResponseMsg.success();
		else
			return AppResponseMsg.faild();
	}
	
	/**
	 * 获取营销类目列表
	 * 日期 2017年3月1日
	 * 时间 下午3:53:14
	 * 创建者 Lcc
	 * @param id 当前营销类目tree节点id
	 * @return
	 */
	@RequestMapping("/getYxTypeList")
	@ResponseBody
	@SystemLog(description="根据当前选择tree节点获取列表信息")
	public ReturnMsg getYxTypeList(@RequestParam String id) {
		MarketingCategoryBean bean = new MarketingCategoryBean();
		bean.setId(id);
		return AppResponseMsg.success(marketingServer.getYxTypeList(bean));
	}
	
	/**
	 * 新增,修改营销类目
	 * 日期 2017年3月1日
	 * 时间 上午10:30:24
	 * 创建者 Lcc
	 * @param bean 新增的时候uid必填,用于判断是否存在
	 * @return
	 */
	@RequestMapping("/saveAdminYxlm")
	@ResponseBody
	@SystemLog(description="包括admin登录的类目审核")
	public ReturnMsg saveAdminYxlm(MarketingCategoryBean bean) {
		return AppResponseMsg.result(marketingServer.saveOrUpYxGtype(bean));
	}
	
	/**
	 * 新增,修改营销类目
	 * 日期 2017年3月1日
	 * 时间 上午10:30:24
	 * 创建者 Lcc
	 * @param bean 新增的时候uid必填,用于判断是否存在
	 * @return
	 */
	@RequestMapping("/saveAgentYxlm")
	@ResponseBody
	@SystemLog(description="agent登录的新增修改停用启用")
	public ReturnMsg saveAgentYxlm(MarketingCategoryBean bean) {
		bean.setCid(userCacheService.getAgentInfo(bean.getCid()).getId());
		return AppResponseMsg.result(marketingServer.saveOrUpYxGtype(bean));
	}
	
	
	/**
	 * 停用启用营销类目
	 * 日期 2017年3月1日
	 * 时间 下午6:03:00
	 * 创建者 Lcc
	 * @param bean 营销类目id,zt
	 * @return
	 */
	@RequestMapping("/updYxGtype")
	@ResponseBody
	@SystemLog(description="停用启用营销类目")
	public ReturnMsg updYxGtype(MarketingCategoryBean bean) {
		return AppResponseMsg.result(marketingServer.updYxGtype(bean));
	}

 	/**
	 * 获取营销类目绑定的分类 
	 * 日期 2016-10-31 
	 * 时间 下午2:34:18 
	 * 创建者 lcc
	 * @param roleBean plid产品线id gtid营销类目id
	 * @return
	 */
	@RequestMapping("/getProductLineFl")
	@ResponseBody
	@SystemLog(description="获取营销类目绑定的商品分类")
	public ReturnMsg getProductLineFl(TreeNode node) {
		return AppResponseMsg.success(marketingServer.getProductLineFl(node));
	}
	
	
	/**
	 * 关联产品线的分类
	 * 日期 2017年2月24日
	 * 时间 上午11:29:46
	 * 创建者 Lcc
	 * @param gids 商品分类id数组
	 * @param gtid 营销类目id
	 * @param uid 用户id
	 * @return
	 */
	@RequestMapping("/saveMarketBandGood")
	@ResponseBody
	@SystemLog(description="根据当前产品线下的营销类目绑定商品分类")
	public ReturnMsg saveMaketingCategoryByProductLine(@RequestParam String[] gids,@RequestParam String gtid,@RequestParam String uid) {
		return AppResponseMsg.result(this.marketingServer.saveMaketingCategoryByProductLine(gids,gtid,uid));
	}
	
	/**
	 * 添加商品与类目关系
	 * 日期 2017年2月24日
	 * 时间 下午3:06:42
	 * 创建者 Lcc
	 * @param gtid 营销类目ID
	 * @param gsid 营销类目与商品映射关系表主键id
	 * @param type 映射类型
	 * @param url 链接URL
	 * @return
	 */
	@RequestMapping("/saveYxGoods")
	@ResponseBody
	@SystemLog(description="绑定url")
	public ReturnMsg saveYxGoods(@RequestParam String uid,String gtid,String gsid,
			String type, String url) {
		boolean flag = marketingServer.insertGtypeGoods(gtid, gsid, type, url,uid);// 绑定商品
		if(flag)
			return AppResponseMsg.success();
		else
			return AppResponseMsg.faild();
	}
	
	
	
	
	/**
	 * 删除营销主题
	 * 日期 2017年2月24日
	 * 时间 下午4:12:15
	 * 创建者 Lcc
	 * @param id 
	 * @return
	 */
	@RequestMapping("/delYxStyle")
	@ResponseBody
	@SystemLog(description="删除营销主题")
	public ReturnMsg delYxStyle(@RequestParam String id) {
		if(marketingServer.delYxStyle(id))
			return AppResponseMsg.success();
		else
			return AppResponseMsg.faild();
	}
	
	
	/**
	 * 复制联版
	 * 日期 2017年2月27日
	 * 时间 上午11:30:50
	 * 创建者 Lcc
	 * @param id
	 * @param commids
	 * @return
	 */
	@RequestMapping("/addCopyTheme")
	@ResponseBody
	@SystemLog(description="营销主题复制功能")
	public ReturnMsg addCopyTheme(String id,String[] commids) {
		json = new JSONObject();
		json=marketingServer.addCopyTheme(id,commids);										
		return AppResponseMsg.result(json);
	}
	
	/**
	 * 复制的时候获取联版小区
	 * 日期 2017年2月27日
	 * 时间 上午11:25:08
	 * 创建者 Lcc
	 * @param ID 营销主题id
	 * @param uid 用户id
	 * @return
	 */
	@RequestMapping("/getThemeCommList")
	@ResponseBody
	@SystemLog(description="获取联版小区")
	public ReturnMsg getThemeCommList(@RequestParam String id,@RequestParam String uid)
	{
		json =new JSONObject();
		uid = userCacheService.getAgentInfo(uid).getId();
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT U.COMID ID,C.NAME FROM T_SYS_UOCOM U ");
		sql.append("INNER JOIN t_community C ON U.COMID=C.CID ");
		sql.append("WHERE OID=").append(uid); 
		sql.append(" and U.RCODE='DLS' AND U.COMID NOT IN ( ").append("SELECT COMID FROM T_YX_STYLE WHERE ID=").append(id).append(")");
		sql.append(" ORDER BY C.CTIME ");
		return AppResponseMsg.success(utile.getListData(CRMUtil.getMap(sql.toString())));
	}
	
	/**
	 * 营销主题
	 * 日期 2017年2月27日
	 * 时间 上午9:55:10
	 * 创建者 Lcc
	 * @param xqid 小区id
	 * @param name 活动名称
	 * @param ofset 页数
	 * @param psize 条数
	 * @return
	 */
	@RequestMapping("/getMarketThemeList")
	@ResponseBody
	@SystemLog(description="根据小区获取营销主题列表")
	public ReturnMsg getMarketThemeList(@RequestParam String xqid,String name,String ofset,String psize){
			Map<String, Object> map = checkPage(ofset,psize);
			YxStyleBean bean=new YxStyleBean();
			bean.setStart((Integer) map.get("ofset"));
			bean.setLimit((Integer) map.get("psize"));
			bean.setXqid(xqid);
			bean.setTableName(name);		
		return AppResponseMsg.success(marketingServer.getMarketThemeList(bean).get("list"),marketingServer.getMarketThemeList(bean).get("count").toString());
	}
	
	/**
	 * 保存 营销主题
	 * 日期 2017年2月24日
	 * 时间 下午4:01:26
	 * 创建者 Lcc
	 * @param ids 商品ids
	 * @param gzcodes 选择的商品的促销编码
	 * @param xqid 小区id
	 * @param bean 营销主题(id,linkurl)
	 * @param uid 用户id
	 * @return
	 */
	@RequestMapping("/saveYxStyle")
	@ResponseBody
	@SystemLog(description="新增营销主题,修改营销主题")
	public ReturnMsg saveYxStyle(@RequestParam String uid,String[] ids,String[] gzcodes,String xqid,YxStyleBean bean)
	{
		JSONObject json = new JSONObject();
		bean.setXqid(xqid);
		bean.setCid(uid);				
		json=marketingServer.saveYxStyle(ids, gzcodes, bean);
		return AppResponseMsg.result(json);
	}
	
	/**
	 * 编辑 营销主题 状态
	 * 日期 2017年2月27日
	 * 时间 上午10:15:51
	 * 创建者 Lcc
	 * @param id 营销主题id
	 * @param zt 状态(0启用;1新建;2停用;3删除)
	 * @param xqid 小区id
	 * @param sort 联版位置(分别为联版1到8)
	 * @return
	 */
	@RequestMapping("/editYxStyle")
	@ResponseBody
	@SystemLog(description="更新营销主题状态")
	public ReturnMsg editYxStyle(String id,String zt,String xqid,String sort) {
		json = new JSONObject();
		json=marketingServer.editYxStyle(id, zt,xqid,sort);
		return AppResponseMsg.result(json);
	}
	
	/**
	 * 营销主题 选中商品(营销主题参与的商品)
	 * 日期 2017年2月27日
	 * 时间 上午10:41:19
	 * 创建者 Lcc
	 * @param yxid 营销主题id
	 * @return
	 */
	@RequestMapping("/getThemeSelectedSp")
	@ResponseBody
	@SystemLog(description="获取营销主题的商品选择")
	public ReturnMsg getThemeSelectedSp(String yxid)
	{
		json =new JSONObject();
		SelectShopBean bean=new SelectShopBean();
		bean.setId(yxid);
		return AppResponseMsg.success(marketingServer.getThemeSelectedSp(bean));				
	}
	/**
	 * 保存上传图片
	 * 日期 2016-5-10
	 * 时间 下午7:22:56
	 * 创建者 ydm
	 * @param response
	 * @param id 
	 * @param Fw 
	 * @param Fh 
	 * @param filetab 业务表
	 */
	@RequestMapping("/saveYxViewIcon")
	@ResponseBody
	@SystemLog(description="营销上传图片")
	public ReturnMsg saveYxViewIcon(HttpServletRequest request,HttpServletResponse response,@RequestParam String id, String Fw, String Fh,String filetab) {
		return AppResponseMsg.result(marketingServer.uploadMarketThemeImage(request, response, id, Fw, Fh, filetab));
	}
	
	
	/**
	 * 获取代理商下的商家
	 * 日期 2017年3月2日
	 * 时间 下午3:13:42
	 * 创建者 Lcc
	 * @param uid 代理商id
	 * @return
	 */
	@RequestMapping("/getSellCom")
	@ResponseBody
	@SystemLog(description="根据代理商id查询商家列表")
	public ReturnMsg getSellCom(String uid)
	{
		ComCodeBean comBean=new ComCodeBean();
		comBean.setCode(uid);
		return AppResponseMsg.success(marketingServer.getSellCom(comBean));				
	}
	
	/**
	 * 营销主题绑定商品的 选择商品列表
	 * 日期 2016-5-11
	 * 时间 下午5:22:55
	 * 创建者 lcc
	 * @param sjid 商家id
	 * @param name 商品名称
	 * @param ofset 页数
	 * @param psize 条数
	 * @return
	 */
	@RequestMapping("/getShowFloorPlaceSpList")
	@ResponseBody
	@SystemLog(description="营销主题绑定商品的 选择商品列表")
	public ReturnMsg getShowFloorPlaceSpList(String xqid,String sjid,String name,String ofset,String psize)
	{
		Map<String, Object> map = checkPage(ofset, psize);
		SelectShopBean bean=new SelectShopBean();
		bean.setName(name);	
		bean.setSjid(sjid);		
		bean.setStart((Integer) map.get("ofset"));
		bean.setLimit((Integer) map.get("psize"));
		return AppResponseMsg.success(marketingServer.getShowFloorSelectSp(bean),String.valueOf(marketingServer.getShowFloorSelectSpCount(bean)));
	}
	
	/**
	 * 获取优惠券列表
	 * 日期 2017年2月28日
	 * 时间 上午10:04:37
	 * 创建者 Lcc
	 * @param coupon
	 * @return
	 */
	@RequestMapping("/getCouponList")
	@ResponseBody
	@SystemLog(description="根据商家获取优惠券")
	public ReturnMsg getCouponList(CouponBean coupon) {
		if(StringUtils.isEmpty(coupon.getSjid())){
			return AppResponseMsg.paramIsNull();
		}
		JSONObject storeId = marketingServer.getStoreId(coupon.getSjid());
		if(storeId.getBoolean("flag")){
			coupon.setSjid(storeId.get("data").toString());
		}else{
			return AppResponseMsg.faild("没有查到商家id");
		}
		return AppResponseMsg.success(marketingServer.getCouponList(coupon),String.valueOf(marketingServer.getCouponTotalCount(coupon)));
	}
	
	/**
	 * 保存优惠券
	 * 日期 2017年2月28日
	 * 时间 上午11:05:55
	 * 创建者 Lcc
	 * @param coupon
	 * @return
	 */
	@RequestMapping("/saveCoupon")
	@ResponseBody
	@SystemLog(description="保存优惠券")
	public ReturnMsg saveCoupon(CouponBean coupon) {
		if(StringUtils.isEmpty(coupon.getSjid())){
			return AppResponseMsg.paramIsNull();
		}
		JSONObject storeId = marketingServer.getStoreId(coupon.getSjid());
		if(storeId.getBoolean("flag")){
			coupon.setSjid(storeId.get("data").toString());
			coupon.setCid(storeId.get("data").toString());
		}else{
			return AppResponseMsg.faild("没有查到商家id");
		}
		return AppResponseMsg.result(marketingServer.saveCoupon(coupon));
	}
	
	/**
	 * 发布停用优惠券
	 * 日期 2017年2月28日
	 * 时间 上午11:12:50
	 * 创建者 Lcc
	 * @param ids 优惠券id集合
	 * @param type 用于识别买赠活动
	 * @param sjid 商家id
	 * @return
	 */
	@RequestMapping("/pubCoupon")
	@ResponseBody
	@SystemLog(description="发布停用优惠券公用方法")
	public ReturnMsg pubCoupon(String ids, String type,@RequestParam String sjid) {
		StringBuffer sql = new StringBuffer();
		if(StringUtils.isNotEmpty(type) && !type.equals("2")){
			String[] split = ids.split(",");
			for (String s : split) {
				sql.append("SELECT ID FROM T_YX_MXQXX WHERE CXID = ").append(s).append(" and TJLX='2'");
				List <UtileBean> list= utileService.getListData(sql.toString());
				if(list.size() == 0){
					return AppResponseMsg.faild("请先设置小区！");
				}
			}
		}
		sql = new StringBuffer();
		//更新状态
		sql.append("UPDATE T_YX_YHJ SET ISFB= ").append(type).append(" WHERE ID IN(").append(ids).append(")");
		utileService.editData(sql.toString());
		MarketBean bean = new MarketBean();
		JSONObject storeId = marketingServer.getStoreId(sjid);
		if(storeId.getBoolean("flag")){
			bean.setStoreid(storeId.get("data").toString());
		}else{
			return AppResponseMsg.faild("没有查到商家id");
		}
		marketingServer.updateStore(bean);
		return AppResponseMsg.success();
	}
	
	
	/**
	 * 删除优惠券
	 * 日期 2017年2月28日
	 * 时间 下午1:40:49
	 * 创建者 Lcc
	 * @param ids 优惠券ids集合
	 * @return
	 */
	@RequestMapping("/delCoupon")
	@ResponseBody
	@SystemLog(description="删除多个优惠券")
	public ReturnMsg delCoupon(String ids) {
		marketingServer.delCoupon(ids);
		return AppResponseMsg.success();
	}
	
	/**
	 * 促销活动设置小区的小区列表
	 * 日期 2017年2月28日
	 * 时间 下午1:43:51
	 * 创建者 Lcc
	 * @param market
	 * @return
	 */
	@RequestMapping("/getProCommList")
	@ResponseBody
	@SystemLog(description="促销活动设置小区的小区列表")
	public ReturnMsg getProCommList(MarketBean market) {
		if(null == market || null == market.getUid()){
			return AppResponseMsg.faild("用户id为空!");
		}
		JSONObject storeId = marketingServer.getStoreId(market.getUid());
		if(storeId.getBoolean("flag")){
			market.setUid(storeId.get("data").toString());
		}else{
			return AppResponseMsg.faild("没有查到商家id");
		}
		return AppResponseMsg.success(marketingServer.getProCommList(market),String.valueOf(marketingServer.getProCommListTotal(market)));
	}
	
	/**
	 * 优惠券绑定小区
	 * 日期 2016-12-29
	 * 时间 下午4:32:35
	 * 创建者 lcc
	 * @param market XQID逗号隔开,优惠券ID
	 * @return
	 */
	@RequestMapping("/addyhqComm")
	@ResponseBody
	@SystemLog(description="优惠券绑定小区")
	public ReturnMsg addyhqComm(MarketBean market) {
		return AppResponseMsg.result(marketingServer.addYhqComm(market));
	}
	
	/**
	 * 删除优惠券与小区关系
	 * 日期 2016-12-29
	 * 时间 下午4:34:41
	 * 创建者 lcc
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delYhqComm")
	@ResponseBody
	@SystemLog(description="优惠券取消绑定小区")
	public ReturnMsg delYhqComm(String ids) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM T_YX_MXQXX WHERE ID IN (").append(ids).append(") and TJLX = '2'");
		utileService.delData(sql.toString());
		return AppResponseMsg.success();
	}
	
	/**
	 * 促销活动的商品选择列表
	 * 日期 2017年3月2日
	 * 时间 下午6:24:02
	 * 创建者 Lcc
	 * @param mspBean
	 * @param storeid * 商家id
	 * @return
	 */
	@RequestMapping("/getSpList")
	@ResponseBody
	public ReturnMsg getSpList(MspBean mspBean) {
			// 0生鲜;1拼团;2服务;4宅配
			/* LCC_TODO if("ADMIN".equals(getRcode())){
				mspBean.setIsst("1");	
			}else{
				mspBean.setIsst(getPlineXz());	
			}*/
			// 调用json工具类返回分页对象
		JSONObject storeId = marketingServer.getStoreId(mspBean.getUserId());
		if(storeId.getBoolean("flag")){
			mspBean.setStoreid(storeId.get("data").toString());
		}else{
			return AppResponseMsg.faild("没有查到商家id");
		}
		return AppResponseMsg.success(marketingServer.getSpList(mspBean),String.valueOf(marketingServer.getSpTotalCount(mspBean)));
	}
	
	/**
	 * 获取优惠券使用详情
	 * 日期 2016-12-20
	 * 时间 下午1:14:26
	 * 创建者 lcc
	 * @param coupon YID优惠券id,SFSY 0使用;1未使用,COMMNAME 小区id,KTIME开始时间,JTIME结束时间,limit,start
	 * @return
	 */
	@RequestMapping("/getCouponInfo")
	@ResponseBody
	@SystemLog(description="获取该优惠券的使用券")
	public ReturnMsg getCouponInfo(CouponuUserBean coupon) {
		return AppResponseMsg.success(marketingServer.getCouponInfo(coupon),String.valueOf(marketingServer.getCouponInfoTotalCount(coupon)));
	}
	
	
	/**
	 * 代理商营销活动楼层列表
	 * 日期 2017年3月3日
	 * 时间 下午3:20:28
	 * 创建者 Lcc
	 * @param xqid
	 * @param title
	 * @return
	 */
	@RequestMapping("/getShowFloorList")
	@ResponseBody
	@SystemLog(description="代理商获取营销活动楼层列表")
	public ReturnMsg getShowFloorList(String xqid,String title,@RequestParam String start,@RequestParam String limit)
	{
		YxViewBean bean=new YxViewBean();
		bean.setXqid(xqid);
		bean.setTitle(title);	
		bean.setStart(Integer.valueOf(start));
		bean.setLimit(Integer.valueOf(limit));
		return AppResponseMsg.success(marketingServer.getShowFloorList(bean), String.valueOf(marketingServer.getShowFloorListCount(bean)));
	}
	
	
	/**
	 * 保存活动楼层
	 * 日期 2017年3月3日
	 * 时间 下午5:57:17
	 * 创建者 Lcc
	 * @param xqId
	 * @param bean
	 * @param uid
	 * @return
	 */
	@RequestMapping("/saveYxView")
	@ResponseBody
	@SystemLog(description="保存活动楼层")
	public ReturnMsg saveYxView(String xqid,YxViewBean bean,@RequestParam String uid) {
		bean.setCid(uid);
		bean.setXqid(xqid);
		json=marketingServer.saveYxView(bean);	
		return AppResponseMsg.result(json);
	}
	
	/**
	 * 获取营销楼层 位置组
	 * 日期 2016-5-10
	 * 时间 上午10:13:21
	 * 创建者 ydm
	 * @param id
	 * @return
	 */
	@RequestMapping("/getSeoFloor")
	@ResponseBody
	@SystemLog(description="新增营销活动楼层选择营销楼层下拉选项")
	public ReturnMsg getSeoFloor()
	{
		return AppResponseMsg.success(marketingServer.getSeoFloor());				
	}
	
	
	/**
	 * 修改 营销活动楼层 状态
	 * 日期 2017年3月6日
	 * 时间 上午10:24:49
	 * 创建者 Lcc
	 * @param id 营销活动楼层id
	 * @param zt 状态
	 * @return
	 */
	@RequestMapping("/editYxView")
	@ResponseBody
	@SystemLog(description="停用启用营销活动楼层装填")
	public ReturnMsg editYxView(@RequestParam String id,@RequestParam String zt) {
		json = new JSONObject();
		json=marketingServer.editYxView(id, zt);										
		return AppResponseMsg.result(json);
	}
	
	
	/**
	 * 活动营销楼层  是否显示名称
	 * 日期 2017年3月6日
	 * 时间 上午10:41:14
	 * 创建者 Lcc
	 * @param id
	 * @param zt
	 * @param type
	 * @return
	 */
	@RequestMapping("/editIsShow")
	@ResponseBody
	@SystemLog(description="修改营销活动楼层是否显示名称")
	public ReturnMsg editIsShow(String id,String zt,String type) {
		json = new JSONObject();
		json=marketingServer.editIsShow(id,zt,type);													
		return AppResponseMsg.result(json);
	}
	
	
	/**
	 * 复制营销楼层选择小区
	 * 日期 2017年3月6日
	 * 时间 上午10:51:00
	 * 创建者 Lcc
	 * @param id 营销楼层id
	 * @param uid 用户id
	 * @return
	 */
	@RequestMapping("/getCommList")
	@ResponseBody
	@SystemLog(description="复制营销楼层选择小区")
	public ReturnMsg getCommList(@RequestParam String id,@RequestParam String uid)
	{
		
		json =new JSONObject();
		uid = userCacheService.getAgentInfo(uid).getId();
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT U.COMID ID,C.NAME FROM T_SYS_UOCOM U ");
		sql.append("INNER JOIN t_community C ON U.COMID=C.CID ");
		sql.append("WHERE OID=").append(uid); 
		sql.append(" and U.RCODE='DLS' AND U.COMID NOT IN ( ").append("SELECT COMID FROM t_yx_view WHERE ID=").append(id).append(")");
		sql.append(" ORDER BY C.CTIME ");
		return AppResponseMsg.success(utile.getListData(CRMUtil.getMap(sql.toString())));
	}
	
	
	/**
	 * 复制营销活动楼层
	 * 日期 2016-7-11
	 * 时间 下午3:51:44
	 * 创建者 lcc
	 * @param id 楼层id
	 * @param commids 小区id数组
	 * @return
	 */
	@RequestMapping("/addCopyYxView")
	@ResponseBody
	@SystemLog(description="复制营销楼层")
	public ReturnMsg addCopyYxView(String id,String[] commids) {
		json = new JSONObject();
		json=marketingServer.addCopyYxView(id,commids);										
		return AppResponseMsg.result(json);
	}
	
	
	/**
	 * 营销展示层位置信息
	 * 日期 2017年3月6日
	 * 时间 上午11:20:56
	 * 创建者 Lcc
	 * @param id 营销活动楼层id
	 * @param title	主标题名称
	 * @return
	 */
	@RequestMapping("/getShowFloorPlaceList")
	@ResponseBody
	@SystemLog(description="营销展示层位置信息")
	public ReturnMsg getShowFloorPlaceList(@RequestParam String id,String title,String ofset,String psize)
	{
		Map<String, Object> checkPage = checkPage(ofset, psize);
		YxViewPos bean=new YxViewPos();
	    bean.setVid(id);
		bean.setLimit((Integer)checkPage.get("psize"));
		bean.setStart((Integer)checkPage.get("ofset"));
		return AppResponseMsg.success(marketingServer.getShowFloorPlaceList(bean), String.valueOf(marketingServer.getShowFloorPlaceCount(bean)));
	}
	
	
	
	/**
	 * 营销楼层 位置信息
	 * 日期 2016-5-12
	 * 时间 上午11:06:14
	 * 创建者 ydm
	 * @param ids	商品ids
	 * @param gzcodes 促销编码
	 * @param vid	营销楼层id
	 * @param groupId 模版id
	 * @param bean
	 * @param uid 用户id
	 * @return
	 */
	@RequestMapping("/saveFloorPlace")
	@ResponseBody
	public ReturnMsg saveFloorPlace(String[] ids,String[] gzcodes,String vid,String groupId,YxViewPos bean,@RequestParam String uid) {
		json = new JSONObject();
	    bean.setLinkUrl(bean.getLinkUrl());
		bean.setVid(vid);
		bean.setGroupId(groupId);
		bean.setCid(uid);
		json=marketingServer.saveFloorPlace(ids, gzcodes, vid, groupId, bean);					
		return AppResponseMsg.result(json);
	}
	
	
	
	/**
	 * 代理商下的有效优惠券
	 * 日期 2017年3月6日
	 * 时间 下午2:48:50
	 * 创建者 Lcc
	 * @param coupon
	 * @param uid
	 * @return
	 */
	@RequestMapping("/getCouponDlsList")
	@ResponseBody
	@SystemLog(description="获取代理商下的有效优惠券")
	public ReturnMsg getCouponDlsList(CouponBean coupon,@RequestParam String uid) {
			coupon.setCid(uid);
			return AppResponseMsg.success(marketingServer.getCouponDlsList(coupon),
					String.valueOf(marketingServer.getCouponDlsTotalCount(coupon)));
		
	}
	
	
	/**
	 * 营销展示层位置信息   选中的优惠券
	 * 日期 2016-6-14
	 * 时间 下午5:36:57
	 * 创建者 ydm
	 * @param showPlaceId
	 * @return
	 */
	@RequestMapping("/getShowPlaceSelectedYhj")
	@ResponseBody
	@SystemLog(description="修改的时候营销展示层选中的优惠券")
	public ReturnMsg getShowPlaceSelectedYhj(String showPlaceId)
	{
		CouponBean bean=new CouponBean();
		bean.setId(showPlaceId);				
		return AppResponseMsg.success(marketingServer.getShowPlaceSelectedYhj(bean));				
	}
	
	
	 /**
	 * 营销展示层位置信息   选中的商品
	 * 日期 2016-5-13
	 * 时间 上午10:01:42
	 * 创建者 ydm
	 * @param yxid
	 * @return
	 */
	@RequestMapping("/getShowPlaceSelectedSp")
	@ResponseBody
	@SystemLog(description="营销位置信息展示层的选中商品")
	public ReturnMsg getShowPlaceSelectedSp(String showPlaceId)
	{
		SelectShopBean bean=new SelectShopBean();
		bean.setId(showPlaceId);				
		return AppResponseMsg.success(marketingServer.getShowPlaceSelectedSp(bean));				
	}
	
	
	
	/**
	 * 修改   营销楼层--位置信息
	 * 日期 2017年3月6日
	 * 时间 下午5:41:47
	 * 创建者 Lcc
	 * @param ids 商品或者优惠券id数组
	 * @param gzcodes	促销规则编码数组
	 * @param vid	//营销展示层id
	 * @param groupId	//模版id
	 * @param bean	
	 * @param lid//位置组id
	 * @return
	 */
	@RequestMapping("/saveUpdateFloorPlace")
	@ResponseBody
	@SystemLog(description="修改营销展示层位置信息")
	public ReturnMsg saveUpdateFloorPlace(String[] ids,String[] gzcodes,String vid,String groupId,YxViewPos bean,String lid,@RequestParam String uid) {
	    bean.setLinkUrl(bean.getLinkUrl());
		bean.setVid(vid);
		bean.setGroupId(groupId);
		bean.setCid(uid);
		return AppResponseMsg.result(marketingServer.saveUpdateFloorPlace(ids, gzcodes, vid, groupId, bean,lid));					
	}
	
	
	/**
	 * 删除营销展示层 位置信息
	 * 日期 2016-7-11
	 * 时间 下午2:03:36
	 * 创建者 lcc
	 * @param id 展示层位置id
	 * @return
	 */
	@RequestMapping("/delYxViewPos")
	@ResponseBody
	@SystemLog(description="删除营销展示层 位置信息 ")
	public ReturnMsg delYxViewPos(String id) {
			return AppResponseMsg.result(json=marketingServer.delYxViewPos(id));										
	}
	
	/**
	 * 删除营销展示层 
	 * 日期 2016-7-11
	 * 时间 下午2:03:36
	 * 创建者 lcc
	 * @param id
	 * @return
	 */
	@RequestMapping("/delYxView")
	@ResponseBody
	@SystemLog(description="删除营销展示层 ")
	public ReturnMsg delYxView(String id) {
			return AppResponseMsg.result(json=marketingServer.delYxView(id));										
	}
	

	
	/**
	 * 营销 楼层位置
	 * 日期 2017年3月7日
	 * 时间 上午10:25:15
	 * 创建者 Lcc
	 * @param id 位置组,表示是否是同一组位置标识
	 * @return
	 */
	@RequestMapping("/getSeoFloorPlace")
	@ResponseBody
	@SystemLog(description="根据位置id查询位置信息")
	public ReturnMsg getSeoFloorPlace(String id)
	{
		ComCodeBean comBean=new ComCodeBean();
		json =new JSONObject();
		comBean.setId(id);							
		return AppResponseMsg.success(marketingServer.getSeoFloorPlace(comBean));				
	}
	
	
	/**
	 * 编辑营销展示层位置状态
	 * 日期 2017年3月7日
	 * 时间 上午9:51:32
	 * 创建者 Lcc
	 * @param id 营销展示层位置信息id
	 * @param zt 状态
	 * @param vid	营销活动楼层营销展示层ID
	 * @param groupId 模版id
	 * @param locid	位置id
	 * @return
	 */
	@RequestMapping("/editYxViewPos")
	@ResponseBody
	@SystemLog(description="编辑营销展示层位置状态")
	public ReturnMsg editYxViewPos(@RequestParam String id,@RequestParam String zt,@RequestParam String vid,@RequestParam String  groupId,@RequestParam String locid) {
		json = new JSONObject();
		json=marketingServer.editYxViewPos(id, zt,vid,groupId,locid);
		return AppResponseMsg.result(json);
	}
	
	/*----------------------------------------------------------------促销活动---------------------------------------------------------------------------------------------*/
	
	/**
	 * 获取商品促销列表
	 * 日期 2017年3月7日
	 * 时间 上午11:09:15
	 * 创建者 Lcc
	 * @param market uid*,GZCODE 营销规则编码,NAME促销名称,start,limit
	 * @return
	 */
	@RequestMapping("/getGoodsProList")
	@ResponseBody
	@SystemLog(description="获取商品促销列表")
	public ReturnMsg getGoodsProList(MarketBean market) {
		if(StringUtils.isEmpty(market.getUid())){
			return AppResponseMsg.paramIsNull();
		}
		JSONObject storeId = marketingServer.getStoreId(market.getUid());
		if(storeId.getBoolean("flag")){
			market.setSJID(storeId.get("data").toString());
		}else{
			return AppResponseMsg.faild("没有查到商家id");
		}
		return AppResponseMsg.success(marketingServer.getGoodsProList(market),String.valueOf(marketingServer.getGoodsProTotalCount(market)));
	}
	
	
	/**
	 * 新增商品促销活动
	 * 日期 2017年3月7日
	 * 时间 下午3:33:02
	 * 创建者 Lcc
	 * @param market uid*
	 * @return
	 */
	@RequestMapping("/saveGoodsPro")
	@ResponseBody
	@SystemLog(description="新增商品促销活动")
	public ReturnMsg saveMarket(MarketBean market) {
		json = new JSONObject();
		EntityModel storeInfo = userCacheService.getStoreInfo(market.getUid());
		if (null == storeInfo) {
			return AppResponseMsg.faild("商家不存在");
		}
		market.setCID(market.getUid());
		market.setSJID(storeInfo.getId());
		json = marketingServer.saveGoodsPro(market);
		return AppResponseMsg.result(json);
	}
	
	
	/**
	 * 修改商品促销状态
	 * 日期 2017年3月7日
	 * 时间 下午4:02:12
	 * 创建者 Lcc
	 * @param market
	 * @return
	 */
	@RequestMapping("/editGoodsPro")
	@ResponseBody
	@SystemLog(description="更新商品促销活动状态")
	@Validate
	public ReturnMsg editGoodsPro(@Validate(isForm=true)MarketBean market) {
		json = new JSONObject();
		EntityModel storeInfo = userCacheService.getStoreInfo(market.getUid());
		if (null == storeInfo) {
			return AppResponseMsg.faild("商家不存在");
		}
		market.setCID(market.getUid());
		market.setStoreid(storeInfo.getId());
		json = marketingServer.editGoodsPro(market);
		return AppResponseMsg.result(json);
	}
	
	
	/**
	 * 删除商品促销
	 * 日期 2017年3月7日
	 * 时间 下午4:22:35
	 * 创建者 Lcc
	 * @param ids 商品促销id,逗号隔开
	 * @return
	 */
	@RequestMapping("/delGoodsPro")
	@ResponseBody
	@SystemLog(description="批量删除商品促销")
	public ReturnMsg delGoodsPro(@RequestParam String ids) {
		marketingServer.delGoodsPro(ids);
		return AppResponseMsg.success();
	}
	
	
	/**
	 * 商品促销绑定小区
	 * 日期 2017年3月7日
	 * 时间 下午4:56:31
	 * 创建者 Lcc
	 * @param market 
	 * @return
	 */
	@RequestMapping("/addProComm")
	@ResponseBody
	@Validate
	@SystemLog(description="促销活动绑定小区")
	public ReturnMsg addProComm(@Validate(isForm=true)MarketBean market) {
		json = new JSONObject();
		market.setCID(market.getUid());
		json = marketingServer.addProComm(market);
		return AppResponseMsg.result(json);
	}
	
	/**
	 * 删除商品促销与小区关系
	 * 日期 2017年3月7日
	 * 时间 下午5:10:25
	 * 创建者 Lcc
	 * @param ids 小区ids数组逗号隔开
	 * @return
	 */
	@RequestMapping("/delProComm")
	@ResponseBody
	@SystemLog(description="删除商品促销与小区关系")
	public ReturnMsg delProComm(@RequestParam String ids) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM T_YX_MXQXX WHERE ID IN (").append(ids)
				.append(")");
		utileService.delData(sql.toString());
		return AppResponseMsg.success();
	}
	
	/**
	 * 获取商品促销商品选择
	 * 日期 2017年3月7日
	 * 时间 下午5:13:48
	 * 创建者 Lcc
	 * @param market
	 * @return
	 */
	@RequestMapping("/getProGoodsList")
	@ResponseBody
	@Validate
	public ReturnMsg getProGoodsList(@Validate(isForm=true)MarketBean market) {
		EntityModel storeInfo = userCacheService.getStoreInfo(market.getUid());
		if (null == storeInfo) {
			return AppResponseMsg.faild("商家不存在");
		}
		market.setStoreid(storeInfo.getId());
		return AppResponseMsg.success(marketingServer.getProGoodsList(market),String.valueOf(marketingServer.getProGoodsTotalCount(market)));
	}
	
	/**
	 * 获取商品促销商品选择
	 * 日期 2017年3月7日
	 * 时间 下午5:13:48
	 * 创建者 Lcc
	 * @param market
	 * @return
	 */
	@RequestMapping("/getMzZpGoodsList")
	@ResponseBody
	@Validate
	public ReturnMsg getMzZpGoodsList(@Validate(isForm=true)MarketBean market) {
		EntityModel storeInfo = userCacheService.getStoreInfo(market.getUid());
		if (null == storeInfo) {
			return AppResponseMsg.faild("商家不存在");
		}
		market.setStoreid(storeInfo.getId());
		return AppResponseMsg.success(marketingServer.getMzGoodsList(market),String.valueOf(marketingServer.getMzGoodsListTotal(market)));
	}
	
	
	/**
	 * 保存商品促销与商品关系 日期 2016-7-18 时间 下午2:20:30 创建者 lcc
	 * 
	 * @param market
	 * @param SPIDS
	 * @param GGIDS
	 * @param HDSLS
	 * @return
	 */
	@RequestMapping("/addProGoods")
	@ResponseBody
	public ReturnMsg addProGoods(MarketBean market, String[] SPIDS,
		String[] GGIDS, String[] HDSLS, String ISST) {
		market.setCID(market.getUid());
		market.setISST(ISST);
		market.setSPID(SPIDS[0]);
		Map<String, String> map = new HashMap<String, String>();// 已商品id和规格id组合为key
		if (null != HDSLS && HDSLS.length > 0) {
			for (int i = 0; i < HDSLS.length; i++) {
				map.put(SPIDS[i] + "_" + GGIDS[i], HDSLS[i]);
			}
		}
		marketingServer.addProGoods(market, map);
		return AppResponseMsg.success();
	}
	
	/**
	 * 团购抢购绑定商品
	 * 日期 2017年3月21日
	 * 时间 下午3:01:04
	 * 创建者 Lcc
	 * @param market
	 * @param SPIDS
	 * @param GGIDS
	 * @param HDSLS
	 * @param MSJG
	 * @param ISST
	 * @return
	 */
	@RequestMapping("/addTqProGoods")
	@ResponseBody
	public ReturnMsg addTqProGoods(MarketBean market, String[] SPIDS,
		String[] GGIDS, String[] HDSLS,String[] MSJG) {
		market.setCID(market.getUid());
		market.setSPID(SPIDS[0]);
		Map<String, String> map = new HashMap<String, String>();// 已商品id和规格id组合为key
		if (null != HDSLS && HDSLS.length > 0) {
			for (int i = 0; i < HDSLS.length; i++) {
				map.put(SPIDS[i] + "_" + GGIDS[i] + "_" + MSJG[i], HDSLS[i]);
			}
		}
		marketingServer.addTqProGoods(market, map);
		return AppResponseMsg.success();
	}
	
	
	/**
	 * 修改抢购活动数量
	 * 日期 2017年3月21日
	 * 时间 下午3:02:53
	 * 创建者 Lcc
	 * @param cxid 促销id
	 * @param id	
	 * @param value
	 * @return
	 */
	@RequestMapping("/editQiangGouNumber")
	@ResponseBody
	public ReturnMsg editQiangGouNumber(@RequestParam String id, String hdsl) {
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE T_YX_MARKETSPMX SET CTIME=now(),HDSL= ").append(hdsl).append(" WHERE ID=").append(id);
			utileService.editData(sql.toString());
		return AppResponseMsg.success();
	}
	
	/**
	 * 删除商品促销与商品关系
	 * @param ids 明细ids
	 * @return
	 */
	@RequestMapping("/delProGoods")
	@ResponseBody
	public ReturnMsg delProGoods(String ids) {
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM T_YX_MARKETSPMX WHERE ID IN (").append(ids)
					.append(")");
			utileService.delData(sql.toString());
		return AppResponseMsg.success();
	}
	
	
	/**
	 * 团购抢购
	 * 日期 2017年3月21日
	 * 时间 下午1:36:13
	 * 创建者 Lcc
	 * @param market
	 * @return
	 */
	@RequestMapping("/saveTuangou")
	@ResponseBody
	public ReturnMsg saveTuangou(MarketBean market) {
		if(StringUtils.isEmpty(market.getUid())){
			return AppResponseMsg.paramIsNull();
		}
		EntityModel storeInfo = userCacheService.getStoreInfo(market.getUid());
		if(null != storeInfo && null != storeInfo.getId()){
			market.setSJID(storeInfo.getId());
		}
		return AppResponseMsg.result(marketingServer.saveTuangou(market));
	}
	
	
	/**
	 * 买赠列表
	 * 日期 2017年3月21日
	 * 时间 下午4:07:34
	 * 创建者 Lcc
	 * @param market
	 * @return
	 */
	@RequestMapping("/getGoodsMzList")
	@ResponseBody
	public ReturnMsg getGoodsMzList(MarketBean market) {
		EntityModel storeInfo = userCacheService.getStoreInfo(market.getUid());
		if(null != storeInfo && null != storeInfo.getId()){
			market.setSJID(storeInfo.getId());
		}
		return AppResponseMsg.success(marketingServer.getGoodsMzList(market),String.valueOf(marketingServer.getGoodsMzListCount(market)));
	}
	
	/**
	 * 买赠活动获取商品选择列表
	 * 
	 * @return
	 */
	@RequestMapping("/getMzGoodsList")
	@ResponseBody
	public ReturnMsg getMzGoodsList(MspBean mspBean) {
		EntityModel storeInfo = userCacheService.getStoreInfo(mspBean.getUserId());
		if(null != storeInfo && null != storeInfo.getId()){
			mspBean.setStoreid(storeInfo.getId());
		}
		return AppResponseMsg.success(marketingServer.getMzGoods(mspBean),
					String.valueOf(marketingServer.getMzGoodsTotalCount(mspBean)));
		
	}
	
	/**
	 * 保存买赠活动
	 * 日期 2016-12-20
	 * 时间 上午11:18:02
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	@RequestMapping("/saveMaizeng")
	@ResponseBody
	public ReturnMsg saveMaizeng(MarketBean market) {
		EntityModel storeInfo = userCacheService.getStoreInfo(market.getUid());
		if(null != storeInfo && null != storeInfo.getId()){
			market.setSJID(storeInfo.getId());
		}
		market.setCID(market.getUid());
		return AppResponseMsg.result(marketingServer.saveMz(market));
	}
	
	/**
	 * 买赠促销绑定商品
	 * 日期 2017年3月21日
	 * 时间 下午4:49:43
	 * 创建者 Lcc
	 * @param market
	 * @param SPIDS
	 * @param GGIDS
	 * @param HDSLS
	 * @param MSJG
	 * @param ISZT 0主商品;1赠品;2优惠券
	 * @return
	 */
	@RequestMapping("/addMzProGoods")
	@ResponseBody
	public ReturnMsg addMzProGoods(MarketBean market, String[] SPIDS,
		String[] GGIDS, String[] HDSLS,String[] MSJG,String ISZT) {
		EntityModel storeInfo = userCacheService.getStoreInfo(market.getUid());
		if(null != storeInfo && null != storeInfo.getId()){
			market.setSJID(storeInfo.getId());
		}
		market.setCID(market.getUid());
		market.setSPID(SPIDS[0]);
		Map<String, String> map = new HashMap<String, String>();// 已商品id和规格id组合为key
		if (null != HDSLS && HDSLS.length > 0) {
			for (int i = 0; i < HDSLS.length; i++) {
				map.put(SPIDS[i] + "_" + GGIDS[i] + "_" + MSJG[i] + "_" + ISZT, HDSLS[i]);
			}
		}
		return AppResponseMsg.result(marketingServer.addMzProGoods(market, map));
	}
	
	/**
	 * 获取已绑定买赠活动的优惠券
	 * 日期 2016-12-20
	 * 时间 下午5:34:14
	 * 创建者 lcc
	 * @param mspBean
	 * @return
	 */
	@RequestMapping("/getMzBandingYhqs")
	@ResponseBody
	public ReturnMsg getMzBandingYhqs(MspBean mspBean) {
		return AppResponseMsg.success(marketingServer.getMzBandingYhqs(mspBean));
	}
	
	/**
	 * 获取已绑定买赠活动的赠品
	 * 日期 2016-12-20
	 * 时间 下午5:34:44
	 * 创建者 lcc
	 * @param mspBean
	 * @return
	 */
	@RequestMapping("/getMzBandingGoods")
	@ResponseBody
	public ReturnMsg getMzBandingGoods(MspBean mspBean) {
		return AppResponseMsg.success(marketingServer.getMzBandingGoods(mspBean));
	}
	
	
	/**
	 * 保存优惠券 赠品
	 * 日期 2016-12-20
	 * 时间 下午4:33:49
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	@RequestMapping("/saveSetYh")
	@ResponseBody
	public ReturnMsg saveSetYh(MarketBean market) {
		return AppResponseMsg.result(marketingServer.saveSetYh(market));
	}
	
	
	/**
	 * 查看促销详情-小区信息
	 * 
	 * @return
	 */
	@RequestMapping("/getViewProComm")
	@ResponseBody
	public ReturnMsg getViewProComm(MarketBean market) {
		return AppResponseMsg.success(marketingServer.getViewProComm(market));
	}
	
	/**
	 * 保存买赠修改数量
	 * 日期 2016-12-21
	 * 时间 下午2:03:23
	 * 创建者 lcc
	 * @param cxid
	 * @param spid
	 * @param ggid
	 * @param hdsl
	 * @param iszt 0主体商品
	 * @return
	 */
	@RequestMapping("/editMzNumber")
	@ResponseBody
	public ReturnMsg editMzNumber(String cxid,String spid,String ggid,String hdsl,String iszt) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE T_YX_MARKETSPMX SET CTIME=now(),HDSL= ").append(hdsl).append(" WHERE CXID=").append(cxid).append(" AND SPID=");
		sql.append(spid).append(" AND GGID=").append(ggid).append(" and iszt=").append(iszt);
		utileService.editData(sql.toString());
		return AppResponseMsg.success();
	}
	
	/**
	 * 上传图片
	 * 日期 2017年3月24日
	 * 时间 上午9:33:49
	 * 创建者 Lcc
	 * @param request
	 * @param response
	 * @param bean
	 * @return
	 */
	public ReturnMsg uploadMarketImage(HttpServletRequest request,HttpServletResponse response, UploadBean bean){
		return AppResponseMsg.result(marketingServer.saveUploadFile(request, response, bean));
	}
	

}
