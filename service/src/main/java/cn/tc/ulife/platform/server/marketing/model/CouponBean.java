/**
 * 
 */
package cn.tc.ulife.platform.server.marketing.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;

/**
 * @author lcc
 * 
 * 优惠卷对象
 */
public class CouponBean extends BaseBean
{
	/**
	 * ID
	 */
	private String id;

	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 优惠券领取URL
	 */
	private String url;

	/**
	 * 描述
	 */
	private String xxms;
	
	/**
	 * 优惠价有效期开始时间
	 */
	private String ktime;
	
	/**
	 * 优惠价有效期介绍时间
	 */
	private String jtime;
	
	/**
	 * 生成张数
	 */
	private String sczs;
	
	/**
	 * 每人限领张数
	 */
	private String xlzs;
	
	/**
	 * 是否发布
	 */
	private String isfb;
	/**
	 * 优惠规则
	 */
	private String yhgz;
	
	/**
	 * 使用范围
	 */
	private String syfw;
	
	/**
	 * 优惠券类型
	 */
	private String ytype;
	
	/**
	 * 直降
	 */
	private String zhij;
	
	/**
	 * 满金额
	 */
	private String mje;
	
	/**
	 * 减金额
	 */
	private String jje;
	
	/**
	 * 创建者ID
	 */
	private String cid;
	
	/**
	 * 优惠券性质0:需自己领取;1:无需领取所有人可用
	 */
	private String yhxz;
	
	/**
	 * 商品分类id
	 */
	private String[] ids;
	
	/**
	 * 有效类型
	 * 0:有起止时间无效计算有效期;1:根据用户领取日期计算有效期
	 */
	private String yxlx;

	/**
	 * 时间天数
	 */
	private String sjts;
	
	/**
	 * 红包规则id
	 */
	private String hbgzid;
	
	/**
	 * 是否优惠券0优惠券;1红包
	 */
	private String isyhq;
	
	/**
	 * 是否使用
	 */
	private String sfsy;
	
	/**
	 * 是否有效
	 */
	private String sfyx;
	
	/**
	 * 商家ID
	 */
	private String sjid;
	/**
	 * 商家名称
	 */
	private String sjname;
	
	/**
	 * 是否实体商品
	 */
	private String isst;
	
	/**
	 * 商品LOGO
	 */
	private String logo;
	
	/**
	 * storeid 
	 * @return
	 */
	private String storeid;
	/**
	 * 是否与折扣同享
	 */
	private String isenjoy;
	/**
	 * 是否提前领取
	 */
	private String isearlier;
	/**
	 * 区分是买赠优惠券还是普通优惠券
	 */
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsearlier() {
		return isearlier;
	}

	public void setIsearlier(String isearlier) {
		this.isearlier = isearlier;
	}

	public String getIsenjoy() {
		return isenjoy;
	}

	public void setIsenjoy(String isenjoy) {
		this.isenjoy = isenjoy;
	}

	public String getIsst() {
		return isst;
	}

	public void setIsst(String isst) {
		this.isst = isst;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getXxms()
	{
		return xxms;
	}

	public void setXxms(String xxms)
	{
		this.xxms = xxms;
	}

	public String getKtime()
	{
		return ktime;
	}

	public void setKtime(String ktime)
	{
		this.ktime = ktime;
	}

	public String getJtime()
	{
		return jtime;
	}

	public void setJtime(String jtime)
	{
		this.jtime = jtime;
	}

	public String getSczs()
	{
		return sczs;
	}

	public void setSczs(String sczs)
	{
		this.sczs = sczs;
	}

	public String getXlzs()
	{
		return xlzs;
	}

	public void setXlzs(String xlzs)
	{
		this.xlzs = xlzs;
	}

	public String getIsfb()
	{
		return isfb;
	}

	public void setIsfb(String isfb)
	{
		this.isfb = isfb;
	}

	public String getYhgz()
	{
		return yhgz;
	}

	public void setYhgz(String yhgz)
	{
		this.yhgz = yhgz;
	}

	public String getSyfw()
	{
		return syfw;
	}

	public void setSyfw(String syfw)
	{
		this.syfw = syfw;
	}

	public String getYtype()
	{
		return ytype;
	}

	public void setYtype(String ytype)
	{
		this.ytype = ytype;
	}

	public String getZhij()
	{
		return zhij;
	}

	public void setZhij(String zhij)
	{
		this.zhij = zhij;
	}

	public String getMje()
	{
		return mje;
	}

	public void setMje(String mje)
	{
		this.mje = mje;
	}

	public String getJje()
	{
		return jje;
	}

	public void setJje(String jje)
	{
		this.jje = jje;
	}

	public String getCid()
	{
		return cid;
	}

	public void setCid(String cid)
	{
		this.cid = cid;
	}

	public String getYhxz()
	{
		return yhxz;
	}

	public void setYhxz(String yhxz)
	{
		this.yhxz = yhxz;
	}

	public String[] getIds()
	{
		return ids;
	}

	public void setIds(String[] ids)
	{
		this.ids = ids;
	}

	public String getYxlx()
	{
		return yxlx;
	}

	public void setYxlx(String yxlx)
	{
		this.yxlx = yxlx;
	}

	public String getSjts()
	{
		return sjts;
	}

	public void setSjts(String sjts)
	{
		this.sjts = sjts;
	}

	public String getHbgzid()
	{
		return hbgzid;
	}

	public void setHbgzid(String hbgzid)
	{
		this.hbgzid = hbgzid;
	}

	public String getSfsy()
	{
		return sfsy;
	}

	public void setSfsy(String sfsy)
	{
		this.sfsy = sfsy;
	}

	public String getSfyx()
	{
		return sfyx;
	}

	public void setSfyx(String sfyx)
	{
		this.sfyx = sfyx;
	}

	public String getSjid()
	{
		return sjid;
	}

	public void setSjid(String sjid)
	{
		this.sjid = sjid;
	}

	public String getIsyhq()
	{
		return isyhq;
	}

	public void setIsyhq(String isyhq)
	{
		this.isyhq = isyhq;
	}

	public String getSjname() {
		return sjname;
	}

	public void setSjname(String sjname) {
		this.sjname = sjname;
	}

	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}
	
	
	

	
}
