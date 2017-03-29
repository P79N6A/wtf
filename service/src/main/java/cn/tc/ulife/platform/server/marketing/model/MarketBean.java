/**
 * 
 */
package cn.tc.ulife.platform.server.marketing.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;
import cn.tc.ulife.platform.validators.Must;

/**
 * @author lcc
 * 
 * 商品促销对象
 */
public class MarketBean extends BaseBean
{
	/**
	 * ID
	 */
	private String ID;

	/**
	 * 名称
	 */
	private String NAME;
	
	/**
	 * 促销分组ID
	 */
	private String FZID;

	/**
	 * 描述
	 */
	private String MIAOS;

	/**
	 * 创建时间
	 */
	private String CTIME;

	/**
	 * 修改时间
	 */
	private String MTIME;
	
	/**
	 * 优惠价有效期开始时间
	 */
	private String KTIME;
	
	/**
	 * 优惠价有效期介绍时间
	 */
	private String JTIME;
	
	/**
	 * 营销规则编码
	 */
	private String GZCODE;
	
	/**
	 * 营销规则ID
	 */
	private String GZID;
	
	/**
	 * 促销类型
	 */
	private String TYPE;
	/**
	 * 直降金额
	 */
	private String ZHIJE;
	
	/**
	 * 折扣率
	 */
	private String ZHIKL;
	
	/**
	 * 优惠券类型
	 */
	private String YTYPE;
	
	/**
	 * 直降
	 */
	private String ZHIJ;
	
	/**
	 * 满金额
	 */
	private String MANJE;
	
	/**
	 * 减金额
	 */
	private String JIANJE;
	
	/**
	 * 满购件数
	 */
	private String MANGJS;
	
	/**
	 * 限购数量
	 */
	private String XGSL;
	
	/**
	 * 创建者ID或商家id
	 */
	private String CID;
	
	/**
	 * 全场促销
	 */
	private String QCCX;
	
	/**
	 * 状态
	 */
	private String ZT;
	
	/**
	 * 是否每天限购
	 */
	private String ISMTXG;
	
	/**
	 * 优惠卷ids
	 */
	private String[] YHJIDS;
	
	/**
	 * 优惠信息ids
	 */
	private String[] YHZPIDS;
	
	/**
	 * 0;不推荐首页;1推荐首页
	 */
	private String ISTJ;
	
	/**
	 * 商家名称
	 */
	private String SJMC;
	
	/**
	 * 商品数量
	 */
	private String SPID;
	
	/**
	 * 促销推荐与小区明细表ID
	 */
	private String CXID;
	
	/**
	 * 小区id
	 */
	private String XQID;
	
	/**
	 * 推荐类型0:首页推荐;1:U管家推荐
	 */
	private String TJLX;
	
	/**
	 * 所属地区
	 */
	private String SSDQ;
	
	/**
	 * 秒杀活动数量
	 */
	private String 	HDSL;
	
	/**
	 * 秒杀价格
	 */
	private String MSJG;
	
	/**
	 * 套餐价格
	 */
	private String TCJG;
	
	/**
	 * 套餐商品件数
	 */
	private String TCSPJS;
	
	/**
	 * 商家ID
	 */
	private String SJID;
	
	/**
	 * 全部用户0;1新注册用户;2老用户
	 */
	private String MEMTYPE;
	
	/**
	 * 是否实体商品
	 */
	private String ISST;
	
	/**
	 * 商品LOGO
	 */
	private String LOGO;
	
	/**
	 * 商家id
	 */
	private String storeid;
	
	/**
	 * 图片地址
	 */
	private String PSY;
	
	/**
	 * 主体商品名称
	 */
	private String spname;
	
	/**
	 * 规格单位
	 */
	private String ggdw;
	/**
	 * 规格id
	 */
	private String SPGZID;
	
	/**
	 * 用户id
	 */
	private String uid;
	
	public String getPSY() {
		return PSY;
	}

	public void setPSY(String pSY) {
		PSY = pSY;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getSPGZID() {
		return SPGZID;
	}

	public void setSPGZID(String sPGZID) {
		SPGZID = sPGZID;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public String getGgdw() {
		return ggdw;
	}

	public void setGgdw(String ggdw) {
		this.ggdw = ggdw;
	}

	public String[] getYHZPIDS() {
		return YHZPIDS;
	}

	public void setYHZPIDS(String[] yHZPIDS) {
		YHZPIDS = yHZPIDS;
	}

	public String getISST() {
		return ISST;
	}

	public void setISST(String iSST) {
		ISST = iSST;
	}

	public String getLOGO() {
		return LOGO;
	}

	public void setLOGO(String lOGO) {
		LOGO = lOGO;
	}

	public String getHDSL() {
		return HDSL;
	}

	public void setHDSL(String hDSL) {
		HDSL = hDSL;
	}

	public String getMSJG() {
		return MSJG;
	}

	public void setMSJG(String mSJG) {
		MSJG = mSJG;
	}

	public String getMEMTYPE() {
		return MEMTYPE;
	}

	public void setMEMTYPE(String mEMTYPE) {
		MEMTYPE = mEMTYPE;
	}

	public String getSSDQ() {
		return SSDQ;
	}

	public void setSSDQ(String sSDQ) {
		SSDQ = sSDQ;
	}

	public String getSPID() {
		return SPID;
	}

	public void setSPID(String sPID) {
		SPID = sPID;
	}

	public String getID()
	{
		return ID;
	}

	public void setID(String iD)
	{
		ID = iD;
	}

	public String getNAME()
	{
		return NAME;
	}

	public void setNAME(String nAME)
	{
		NAME = nAME;
	}

	public String getFZID()
	{
		return FZID;
	}

	public void setFZID(String fZID)
	{
		FZID = fZID;
	}

	public String getMIAOS()
	{
		return MIAOS;
	}

	public void setMIAOS(String mIAOS)
	{
		MIAOS = mIAOS;
	}

	public String getCTIME()
	{
		return CTIME;
	}

	public void setCTIME(String cTIME)
	{
		CTIME = cTIME;
	}

	public String getMTIME()
	{
		return MTIME;
	}

	public void setMTIME(String mTIME)
	{
		MTIME = mTIME;
	}

	public String getKTIME()
	{
		return KTIME;
	}

	public void setKTIME(String kTIME)
	{
		KTIME = kTIME;
	}

	public String getJTIME()
	{
		return JTIME;
	}

	public void setJTIME(String jTIME)
	{
		JTIME = jTIME;
	}

	public String getGZCODE()
	{
		return GZCODE;
	}

	public void setGZCODE(String gZCODE)
	{
		GZCODE = gZCODE;
	}

	public String getGZID()
	{
		return GZID;
	}

	public void setGZID(String gZID)
	{
		GZID = gZID;
	}

	public String getTYPE()
	{
		return TYPE;
	}

	public void setTYPE(String tYPE)
	{
		TYPE = tYPE;
	}

	public String getZHIJE()
	{
		return ZHIJE;
	}

	public void setZHIJE(String zHIJE)
	{
		ZHIJE = zHIJE;
	}

	public String getZHIKL()
	{
		return ZHIKL;
	}

	public void setZHIKL(String zHIKL)
	{
		ZHIKL = zHIKL;
	}

	public String getYTYPE()
	{
		return YTYPE;
	}

	public void setYTYPE(String yTYPE)
	{
		YTYPE = yTYPE;
	}

	public String getZHIJ()
	{
		return ZHIJ;
	}

	public void setZHIJ(String zHIJ)
	{
		ZHIJ = zHIJ;
	}

	public String getMANJE()
	{
		return MANJE;
	}

	public void setMANJE(String mANJE)
	{
		MANJE = mANJE;
	}

	public String getJIANJE()
	{
		return JIANJE;
	}

	public void setJIANJE(String jIANJE)
	{
		JIANJE = jIANJE;
	}

	public String getMANGJS()
	{
		return MANGJS;
	}

	public void setMANGJS(String mANGJS)
	{
		MANGJS = mANGJS;
	}

	public String getXGSL()
	{
		return XGSL;
	}

	public void setXGSL(String xGSL)
	{
		XGSL = xGSL;
	}

	public String getCID()
	{
		return CID;
	}

	public void setCID(String cID)
	{
		CID = cID;
	}

	public String[] getYHJIDS()
	{
		return YHJIDS;
	}

	public void setYHJIDS(String[] yHJIDS)
	{
		YHJIDS = yHJIDS;
	}

	public String getQCCX()
	{
		return QCCX;
	}

	public void setQCCX(String qCCX)
	{
		QCCX = qCCX;
	}

	public String getZT()
	{
		return ZT;
	}

	public void setZT(String zT)
	{
		ZT = zT;
	}

	public String getISTJ()
	{
		return ISTJ;
	}

	public void setISTJ(String iSTJ)
	{
		ISTJ = iSTJ;
	}

	public String getSJMC()
	{
		return SJMC;
	}

	public void setSJMC(String sJMC)
	{
		SJMC = sJMC;
	}

	public String getCXID()
	{
		return CXID;
	}

	public void setCXID(String cXID)
	{
		CXID = cXID;
	}

	public String getXQID()
	{
		return XQID;
	}

	public void setXQID(String xQID)
	{
		XQID = xQID;
	}

	public String getTJLX()
	{
		return TJLX;
	}

	public void setTJLX(String tJLX)
	{
		TJLX = tJLX;
	}

	public String getISMTXG()
	{
		return ISMTXG;
	}

	public void setISMTXG(String iSMTXG)
	{
		ISMTXG = iSMTXG;
	}

	public String getSJID()
	{
		return SJID;
	}

	public void setSJID(String sJID)
	{
		SJID = sJID;
	}

	public String getTCJG()
	{
		return TCJG;
	}

	public void setTCJG(String tCJG)
	{
		TCJG = tCJG;
	}

	public String getTCSPJS()
	{
		return TCSPJS;
	}

	public void setTCSPJS(String tCSPJS)
	{
		TCSPJS = tCSPJS;
	}

	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}
	
	
}
