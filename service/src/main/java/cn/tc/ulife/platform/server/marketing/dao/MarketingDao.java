package cn.tc.ulife.platform.server.marketing.dao;

import java.util.List;

import cn.tc.ulife.platform.server.marketing.model.ComCodeBean;
import cn.tc.ulife.platform.server.marketing.model.CouponBean;
import cn.tc.ulife.platform.server.marketing.model.CouponuUserBean;
import cn.tc.ulife.platform.server.marketing.model.MarketBean;
import cn.tc.ulife.platform.server.marketing.model.MarketingCategoryBean;
import cn.tc.ulife.platform.server.marketing.model.MspBean;
import cn.tc.ulife.platform.server.marketing.model.PromotionRulesBean;
import cn.tc.ulife.platform.server.marketing.model.PromotionRulesVo;
import cn.tc.ulife.platform.server.marketing.model.SelectShopBean;
import cn.tc.ulife.platform.server.marketing.model.YxGtypeGoods;
import cn.tc.ulife.platform.server.marketing.model.YxStyleBean;
import cn.tc.ulife.platform.server.marketing.model.YxViewBean;
import cn.tc.ulife.platform.server.marketing.model.YxViewPos;
import cn.tc.ulife.platform.server.tree.model.TreeNode;


/**
 * 营销管理
 * @author lcc
 * 
 */
public interface MarketingDao
{
	
	List<PromotionRulesVo> getPromotionRules(PromotionRulesBean bean);
	
	int savePromotionRules(PromotionRulesBean bean);
	
	int updatePromotionRules(PromotionRulesBean bean);
	
	int removePromotionRules(PromotionRulesBean bean);
	
	void insertGtypeGoods(YxGtypeGoods bean);
	
	void updGtypeGoods(YxGtypeGoods bean);
	
	void insertYxGtype(MarketingCategoryBean bean);
	
	void editYxGtype(MarketingCategoryBean bean);
	
	/**
	 * 营销类目列表
	 */
	List<MarketingCategoryBean> getYxTypeList(MarketingCategoryBean bean);
	
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
	 * 复制联版数据
	 * 日期 2017年2月24日
	 * 时间 下午4:38:35
	 * 创建者 Lcc
	 * @param pos
	 */
	public void addCopyTheme(YxStyleBean pos);
	
	/**
	 * 复制楼层位置数据
	 * 日期 2016-7-11
	 * 时间 下午5:23:11
	 * 创建者 lcc
	 * @param bean
	 */
	public void addCopyViewPos(YxViewPos pos);
	
	/**
	 * 复制楼层
	 * 日期 2016-7-11
	 * 时间 下午5:23:11
	 * 创建者 lcc
	 * @param bean
	 */
	public void addCopyView(YxViewBean bean);	
	
	/**
	 * 营销展示层 列表
	 * 日期 2016-5-9
	 * 时间 下午3:59:22
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<YxViewBean> getShowFloorList(YxViewBean bean);	
	/**
	 * 营销展示层 所有列
	 * 日期 2016-5-9
	 * 时间 下午3:59:35
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public int getShowFloorListCount(YxViewBean bean);
	
	/**
	 * 位置组
	 * 日期 2016-5-10
	 * 时间 下午1:56:18
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<ComCodeBean> getSeoFloor();
	
	/**
	 * 营销楼层位置
	 * 日期 2016-5-10
	 * 时间 上午9:45:57
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<ComCodeBean> getSeoFloorPlace(ComCodeBean bean);
	
	/**
	 * 营销展示层位置信息
	 * 日期 2016-5-10
	 * 时间 下午7:27:16
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<YxViewPos> getShowFloorPlaceList(YxViewPos bean);	
	public int getShowFloorPlaceCount(YxViewPos bean);
	
	public void addYxView(YxViewBean bean);

	
	public void updateYxView(YxViewBean bean);
	
	/**
	 * 展示层位置  选择商品列表
	 * 日期 2016-5-11
	 * 时间 下午4:17:36
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<SelectShopBean> getShowFloorSelectSp(SelectShopBean bean);
	public int getShowFloorSelectSpCount(SelectShopBean bean);
	
	/**
	 * 根据代理商获取商家
	 */
	public List<ComCodeBean> getSellCom(ComCodeBean bean);
	
	public void addYxViewPos(YxViewPos bean);
	
	public void updateYxViewPos(YxViewPos bean);
	/**
	 * 营销主题
	 * 日期 2016-5-12
	 * 时间 下午4:15:32
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<YxStyleBean> getMarketThemeList(YxStyleBean   bean);
	public int getMarketThemeListCount(YxStyleBean   bean);
	
	public void addYxStyle(YxStyleBean   bean);
	
	/**
	 * 营销主题参与的商品
	 * 日期 2016-5-13
	 * 时间 上午9:34:26
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<SelectShopBean> getThemeSelectedSp(SelectShopBean bean);
	
	/**
	 * 营销展示层位置信息   选中的商品
	 * 日期 2016-5-13
	 * 时间 上午10:00:29
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<SelectShopBean> getShowPlaceSelectedSp(SelectShopBean bean);
	/**
	 * 营销展示层位置信息   选中的优惠券
	 * 日期 2016-6-14
	 * 时间 下午5:35:34
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<CouponBean>getShowPlaceSelectedYhj (CouponBean bean);
	
	/**
	 * 获取优惠券列表
	 * 日期 2017年2月27日
	 * 时间 下午5:53:01
	 * 创建者 Lcc
	 * @param coupon
	 * @return
	 */
	public List<CouponBean> getCouponList(CouponBean coupon);
	
	/**
	 * 获取优惠券列表总数
	 * 日期 2017年3月1日
	 * 时间 下午1:29:12
	 * 创建者 Lcc
	 * @param coupon
	 * @return
	 */
	public int getCouponTotalCount(CouponBean coupon);
	
	/**
	 * 保存优惠券
	 * 日期 2017年2月28日
	 * 时间 上午11:02:54
	 * 创建者 Lcc
	 * @param coupon
	 */
	public void saveCoupon(CouponBean coupon);
	
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
	 * 促销活动的商品选择
	 * 日期 2017年3月2日
	 * 时间 下午6:15:06
	 * 创建者 Lcc
	 * @param mspBean
	 * @return
	 */
	public List<MspBean> getSpList(MspBean mspBean);
	
	/**
	 * 促销活动的商品选择总数
	 * 日期 2017年3月2日
	 * 时间 下午6:20:06
	 * 创建者 Lcc
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
	List<CouponBean> getGoodsProList(MarketBean market);
	
	/**
	 * 获取商品促销列表总数
	 * 日期 2016-4-28
	 * 时间 下午1:35:15
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	int getGoodsProTotalCount(MarketBean market);
	
	
	/**
	 * 保存商品促销
	 * 日期 2016-4-28
	 * 时间 下午1:36:11
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public void saveGoodsPro(MarketBean market);
	
	
	/**
	 * 发布前判断当前商品是否已经在已发布的活动中
	 * 日期 2016-12-22
	 * 时间 下午2:51:29
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public int getIsRepeat(MarketBean market);
	
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
	 * 抢购团购
	 * 日期 2017年3月21日
	 * 时间 下午1:39:52
	 * 创建者 Lcc
	 * @param market
	 */
	public void saveTuangou(MarketBean market);
	
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
	public void saveMz(MarketBean market);
	
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
	 * 查看促销详情-小区信息
	 * 日期 2016-4-28
	 * 时间 下午1:35:15
	 * 创建者 lwy
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
	
	
	
}
