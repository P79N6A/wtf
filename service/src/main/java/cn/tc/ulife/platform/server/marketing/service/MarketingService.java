package cn.tc.ulife.platform.server.marketing.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import cn.tc.ulife.platform.server.marketing.model.ComCodeBean;
import cn.tc.ulife.platform.server.marketing.model.CouponBean;
import cn.tc.ulife.platform.server.marketing.model.CouponuUserBean;
import cn.tc.ulife.platform.server.marketing.model.MarketBean;
import cn.tc.ulife.platform.server.marketing.model.MarketingCategoryBean;
import cn.tc.ulife.platform.server.marketing.model.MspBean;
import cn.tc.ulife.platform.server.marketing.model.PromotionRulesBean;
import cn.tc.ulife.platform.server.marketing.model.PromotionRulesVo;
import cn.tc.ulife.platform.server.marketing.model.SelectShopBean;
import cn.tc.ulife.platform.server.marketing.model.YxStyleBean;
import cn.tc.ulife.platform.server.marketing.model.YxViewBean;
import cn.tc.ulife.platform.server.marketing.model.YxViewPos;
import cn.tc.ulife.platform.server.tree.model.TreeNode;
import cn.tc.ulife.platform.server.utils.model.UploadBean;

/**
 * 营销管理server层接口类
 * 
 * @author lcc
 *
 */
public interface MarketingService {
	/**
	 * 
	 * 日期 2017年2月23日 时间 下午3:28:14 创建者 Lcc
	 * 
	 * @param specBean
	 * @return
	 */
	public List<PromotionRulesVo> getPromotionRules(PromotionRulesBean specBean);

	/**
	 * 保存营销规格 日期 2017年2月23日 时间 下午3:28:21 创建者 Lcc
	 * 
	 * @param specBean
	 * @return
	 */
	public JSONObject savePromotionRules(PromotionRulesBean specBean);
	
	/**
	 * 批量删除营销规则
	 * 日期 2017年2月23日
	 * 时间 下午4:30:44
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	public int removePromotionRules(PromotionRulesBean bean);
	
	/**
	 * 营销类目列表
	 * 日期 2017年3月1日
	 * 时间 下午4:00:55
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	public List<MarketingCategoryBean> getYxTypeList(MarketingCategoryBean bean);
	
	/**
	 * 包括admin登录的类目审核,agent登录的新增修改停用启用
	 * 日期 2017年3月1日
	 */
	public JSONObject saveOrUpYxGtype(MarketingCategoryBean bean);
	
	/**
	 * 停用启用营销类目
	 * 日期 2017年3月1日
	 * 时间 下午6:02:22
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	public JSONObject updYxGtype(MarketingCategoryBean bean);
	
	/**
	 * 获取产品线绑定的分类
	 * 日期 2016-10-31
	 * 时间 下午2:32:28
	 * 创建者 lcc
	 * @param node
	 * @return
	 */
	public List<TreeNode> getProductLineFl(TreeNode node);
	
	/**
	 * 关联产品线的分类
	 * 日期 2016-10-31
	 * 时间 下午3:36:48
	 * 创建者 lcc
	 * @param gids
	 * @param gtid
	 * @return
	 */
	public boolean saveMaketingCategoryByProductLine(String[] gids,String gtid,String uid);
	
	
	public boolean insertGtypeGoods(String gtid,String gsid,String type,String url,String userid);
	
	
	/**
	 * 删除营销主题
	 * 日期 2017年2月24日
	 * 时间 下午4:11:23
	 * 创建者 Lcc
	 * @param id
	 * @return
	 */
	public boolean delYxStyle(String id);	
	
	/**
	 * 复制联版
	 * 日期 2016-7-11
	 * 时间 下午3:57:54
	 * 创建者 lwy
	 * @param id
	 * @param commids
	 * @param userid
	 * @return
	 */
	public JSONObject addCopyTheme(String id,String[] commids);
	
	/**
	 * 复制楼层
	 * 日期 2016-7-11
	 * 时间 下午3:57:54
	 * 创建者 lwy
	 * @param id
	 * @param commids
	 * @param userid
	 * @return
	 */
	public JSONObject addCopyYxView(String id,String[] commids);
	
	/**
	 * 删除营销展示层 位置信息
	 * 日期 2016-7-11
	 * 时间 下午2:04:58
	 * 创建者 lwy
	 * @param id
	 * @return
	 */
	public JSONObject delYxViewPos(String id);	
	
	/**
	 * 删除营销展示层 
	 * 日期 2016-7-11
	 * 时间 下午2:04:58
	 * 创建者 lwy
	 * @param id
	 * @return
	 */
	public JSONObject delYxView(String id);	

	/**
	 * 营销展示层 列表
	 * 日期 2016-5-9
	 * 时间 下午3:59:22
	 * 创建者 ydm
	 * @param bean
	 * @return
	 */
	public List<YxViewBean> getShowFloorList(YxViewBean bean);	
	/**
	 * 营销展示层 所有列
	 * 日期 2016-5-9
	 * 时间 下午3:59:35
	 * 创建者 ydm
	 * @param bean
	 * @return
	 */
	public int getShowFloorListCount(YxViewBean bean);
	
	/**
	 * 营销展示层位置信息
	 * 日期 2016-5-10
	 * 时间 下午7:27:16
	 * 创建者 ydm
	 * @param bean
	 * @return
	 */
	public List<YxViewPos> getShowFloorPlaceList(YxViewPos bean);	
	public int getShowFloorPlaceCount(YxViewPos bean);
	
	
	
	
	/**
	 * 位置组
	 * 日期 2016-5-10
	 * 时间 下午1:56:18
	 * 创建者 ydm
	 * @param bean
	 * @return
	 */
	public List<ComCodeBean> getSeoFloor();
	
	/**
	 * 营销楼层位置
	 * 日期 2016-5-10
	 * 时间 上午9:45:57
	 * 创建者 ydm
	 * @param bean
	 * @return
	 */
	public List<ComCodeBean> getSeoFloorPlace(ComCodeBean bean);
	
	/**
	 * 保存营销 展示层
	 * 日期 2016-5-10
	 * 时间 上午10:17:21
	 * 创建者 ydm
	 * @param xqId
	 * @param bean
	 * @return
	 */
	public JSONObject saveYxView(YxViewBean bean);
	
	/**
	 * 活动位管理  是否显示名称
	 * 日期 2016-6-2
	 * 时间 下午4:42:12
	 * 创建者 ydm
	 * @param id
	 * @param zt
	 * @param type
	 * @return
	 */
	public JSONObject editIsShow(String id,String zt,String type);
	/**
	 * 修改 营销表示层 状态
	 * 日期 2016-5-10
	 * 时间 下午3:44:02
	 * 创建者 ydm
	 * @param id
	 * @param zt
	 * @return
	 */
	public JSONObject editYxView(String id,String zt);

	
	public String saveAttachment(InputStream inputStream,YxViewBean bean,String filetab) 
			throws FileNotFoundException, IOException;
  
	/**
	 * 展示层位置  选择商品列表
	 * 日期 2016-5-11
	 * 时间 下午4:17:36
	 * 创建者 ydm
	 * @param bean
	 * @return
	 */
	public List<SelectShopBean> getShowFloorSelectSp(SelectShopBean bean);
	public int getShowFloorSelectSpCount(SelectShopBean bean);
	
	/**
	 * 获取商家
	 */
	public List<ComCodeBean> getSellCom(ComCodeBean bean);
	/**
	 * 保存 营销展示层 位置信息
	 * 日期 2016-5-12
	 * 时间 上午10:15:04
	 * 创建者 ydm
	 * @param ids
	 * @param gzcodes
	 * @param xqId
	 * @param groupId
	 * @param bean
	 * @return
	 */
	public JSONObject saveFloorPlace(String[] ids,String[] gzcodes,String vid,String groupId,YxViewPos bean);
	
	public JSONObject saveUpdateFloorPlace(String[] ids,String[] gzcodes,String vid,String groupId,YxViewPos bean,String lid);
	/**
	 * 编辑营销展示层位置 状态
	 * 日期 2016-5-12
	 * 时间 下午2:13:12
	 * 创建者 ydm
	 * @param id
	 * @param zt
	 * @return
	 */
	public JSONObject editYxViewPos(String id,String zt,String vid,String groupId,String locid);
	
	/**
	 * 营销主题
	 * 日期 2016-5-12
	 * 时间 下午4:15:32
	 * 创建者 ydm
	 * @param bean
	 * @return
	 */
	public Map<String, Object> getMarketThemeList(YxStyleBean   bean);
	
	/**
	 * 保存 营销主题
	 */
	public JSONObject saveYxStyle(String[] ids,String[] gzcodes,YxStyleBean bean);
	
	/**
	 *编辑营销主题 状态
	 * 日期 2016-5-12
	 * 时间 下午2:14:31
	 * 创建者ydm
	 */
	public JSONObject editYxStyle(String id,String zt,String xqid,String sort);
	
	/**
	 * 营销主题参与的商品
	 * 日期 2016-5-13
	 * 时间 上午9:34:26
	 * 创建者 ydm
	 * @param bean
	 * @return
	 */
	public List<SelectShopBean> getThemeSelectedSp(SelectShopBean bean);
	
	/**
	 * 营销展示层位置信息   选中的商品
	 * 日期 2016-5-13
	 * 时间 上午10:00:29
	 * 创建者 ydm
	 * @param bean
	 * @return
	 */
	public List<SelectShopBean> getShowPlaceSelectedSp(SelectShopBean bean);
	/**
	 * 营销展示层位置信息   选中的优惠券
	 * 日期 2016-6-14
	 * 时间 下午5:35:34
	 * 创建者 ydm
	 * @param bean
	 * @return
	 */
	public List<CouponBean>getShowPlaceSelectedYhj (CouponBean bean);	
	
	
	/**
	 * 营销主题上传图片
	 * 日期 2017年2月27日
	 * 时间 下午3:37:34
	 * 创建者 Lcc
	 * @param response
	 * @param id
	 * @param Fw
	 * @param Fh
	 * @param filetab
	 * @return
	 */
	public JSONObject uploadMarketThemeImage(HttpServletRequest request,HttpServletResponse response,String id, String Fw, String Fh,String filetab);

	/**
	 * 获取优惠券列表
	 * 日期 2017年2月27日
	 * 时间 下午5:50:29
	 * 创建者 Lcc
	 * @param coupon
	 * @return
	 */
	public List<CouponBean> getCouponList(CouponBean coupon);
	
	/**
	 * 获取优惠券总记录条数
	 * 日期 2017年3月1日
	 * 时间 下午1:28:02
	 * 创建者 Lcc
	 * @param coupon
	 * @return
	 */
	public int getCouponTotalCount(CouponBean coupon);
	
	/**
	 * 根据id查询商家id
	 * 日期 2017年3月20日
	 * 时间 下午2:58:55
	 * 创建者 Lcc
	 * @param uid
	 * @return
	 */
	public JSONObject getStoreId(String uid);
	
	/**
	 * 保存优惠券
	 * 日期 2017年2月28日
	 * 时间 上午10:59:59
	 * 创建者 Lcc
	 * @param coupon
	 * @return
	 */
	public JSONObject saveCoupon(CouponBean coupon);
	
	/**
	 * 更新商家是否显示优惠标识
	 * 日期 2017年2月28日
	 * 时间 上午11:27:09
	 * 创建者 Lcc
	 * @param market
	 */
	public void updateStore(MarketBean market);
	
	/**
	 * 删除优惠券
	 * 日期 2017年2月28日
	 * 时间 下午1:34:22
	 * 创建者 Lcc
	 * @param ids
	 */
	public void delCoupon(String ids);
	
	/**
	 * 获取促销活动小区选择
	 * 日期 2017年2月28日
	 * 时间 下午1:57:51
	 * 创建者 Lcc
	 * @param market
	 * @return
	 */
	public List<MarketBean> getProCommList(MarketBean market);
	
	public List<MarketBean> getProCommListTotal(MarketBean market);
	
	/**
	 * 优惠券绑定小区
	 * 日期 2016-12-29
	 * 时间 下午4:32:14
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public JSONObject addYhqComm(MarketBean market);
	
	/**
	 * 获取促销活动的商品选择
	 * 日期 2016-5-4
	 * 时间 下午4:00:20
	 * 创建者 lcc
	 * @param mspBean
	 * @return
	 */
	List<MspBean> getSpList(MspBean mspBean);
	
	
	/**
	 * 获取促销活动的商品选择总数
	 * 日期 2016-5-4
	 * 时间 下午4:00:20
	 * 创建者 lcc
	 * @param mspBean
	 * @return
	 */
	public int getSpTotalCount(MspBean mspBean);
	
	/**
	 * 获取优惠券使用详情
	 * 日期 2016-12-20
	 * 时间 下午1:17:52
	 * 创建者 lcc
	 * @param coupon
	 * @return
	 */
	public List<CouponuUserBean> getCouponInfo(CouponuUserBean coupon);
	/**
	 * 获取优惠券使用详情 总记录
	 * 日期 2016-12-20
	 * 时间 下午1:17:55
	 * 创建者 lcc
	 * @param coupon
	 * @return
	 */
	public int getCouponInfoTotalCount(CouponuUserBean coupon);
	
	/**
	 * 获取代理商下的有效优惠券
	 * 日期 2017年3月6日
	 * 时间 下午2:43:58
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	public List<CouponBean> getCouponDlsList(CouponBean bean);
	
	
	public int getCouponDlsTotalCount(CouponBean bean);
	
	/**
	 * 获取商品促销列表
	 * 日期 2016-4-28
	 * 时间 下午1:35:15
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public List<CouponBean> getGoodsProList(MarketBean market);
	
	/**
	 * 获取商品促销列表总数
	 * 日期 2016-4-28
	 * 时间 下午1:35:15
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public int getGoodsProTotalCount(MarketBean market);
	
	/**
	 * 保存商品促销
	 * 日期 2016-4-28
	 * 时间 下午1:36:11
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public JSONObject saveGoodsPro(MarketBean market);
	
	/**
	 * 修改商品促销
	 * 日期 2016-4-28
	 * 时间 下午1:36:11
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public JSONObject editGoodsPro(MarketBean market);
	
	/**
	 * 批量删除商品促销
	 * 日期 2017年3月7日
	 * 时间 下午4:24:45
	 * 创建者 Lcc
	 * @param ids
	 */
	public void delGoodsPro(String ids);
	
	/**
	 * 保存商品促销与小区信息
	 * 日期 2016-4-28
	 * 时间 下午1:36:11
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public JSONObject addProComm(MarketBean market);
	
	
	/**
	 * 获取商品促销商品选择
	 * 日期 2016-4-28
	 * 时间 下午1:35:15
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public List<MarketBean> getProGoodsList(MarketBean market);
	/**
	 * 获取商品促销列表总记录条数
	 * 日期 2016-4-28
	 * 时间 下午1:35:15
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public int getProGoodsTotalCount(MarketBean market);
	
	/**
	 * 保存商品促销与商品信息
	 * 日期 2016-4-28
	 * 时间 下午1:36:11
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public JSONObject addProGoods(MarketBean market,Map<String, String> map);
	/**
	 * 保存抢购团购绑定商品
	 * 日期 2017年3月21日
	 * 时间 下午3:11:55
	 * 创建者 Lcc
	 * @param market
	 * @param map
	 * @return
	 */
	public JSONObject addTqProGoods(MarketBean market,Map<String, String> map);
	
	/**
	 * 保存抢购团购促销
	 * 日期 2017年3月21日
	 * 时间 下午1:45:24
	 * 创建者 Lcc
	 * @param market
	 * @return
	 */
	public JSONObject saveTuangou(MarketBean market);
	
	/**
	 * 获取买赠活动列表
	 * 日期 2016-12-21
	 * 时间 上午11:27:33
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public List<MarketBean> getGoodsMzList(MarketBean market);
	
	public int getGoodsMzListCount(MarketBean market);
	
	/**
	 * 获取买赠商品
	 * 日期 2016-12-20
	 * 时间 上午10:37:53
	 * 创建者 lcc
	 * @param mspBean
	 * @return
	 */
	public List<MspBean> getMzGoods(MspBean mspBean);
	
	/**
	 * 获取买赠商品总数
	 * 日期 2016-12-20
	 * 时间 上午10:42:37
	 * 创建者 lcc
	 * @param mspBean
	 * @return
	 */
	public int getMzGoodsTotalCount(MspBean mspBean);
	
	/**
	 * 保存买赠
	 * 日期 2016-12-20
	 * 时间 上午11:14:50
	 * 创建者 lcc
	 * @param market
	 */
	public JSONObject saveMz(MarketBean market);
	
	
	public JSONObject addMzProGoods(MarketBean market,Map<String, String> map);
	
	/**
	 * 获取已绑定买赠活动的优惠券
	 * 日期 2016-12-20
	 * 时间 下午5:31:55
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<MspBean> getMzBandingYhqs(MspBean bean);
	
	/**
	 * 获取已绑定买赠活动的赠品
	 * 日期 2016-12-20
	 * 时间 下午5:32:06
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<MspBean> getMzBandingGoods(MspBean bean);
	
	/**
	 * 保存优惠券 赠品
	 * 日期 2016-12-20
	 * 时间 下午4:35:14
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public JSONObject saveSetYh(MarketBean market);
	
	/**
	 * 查看促销详情-小区信息
	 * 日期 2016-4-28
	 * 时间 下午1:35:15
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public List<MarketBean> getViewProComm(MarketBean market);
	
	/**
	 * 买赠赠品商品
	 * 日期 2017年3月22日
	 * 时间 下午6:06:17
	 * 创建者 Lcc
	 * @param market
	 * @return
	 */
	public List<MarketBean> getMzGoodsList(MarketBean market);
	
	public int getMzGoodsListTotal(MarketBean market);
	
	public JSONObject saveUploadFile(HttpServletRequest request,HttpServletResponse response,UploadBean bean);
	
}
