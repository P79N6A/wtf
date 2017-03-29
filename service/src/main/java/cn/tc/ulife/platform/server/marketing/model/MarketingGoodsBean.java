/**
 * 
 */
package cn.tc.ulife.platform.server.marketing.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;

/**
 * @author lwy
 * 
 * 营销模块商品对象
 */
public class MarketingGoodsBean extends BaseBean
{
	/**
	 * ID
	 */
	private String ID;
	
	/**
	 * 促销商品明细id
	 */
	private String MSPID;

	/**
	 * 名称
	 */
	private String NAME;
	
	/**
	 * 商品编码
	 */
	private String SPCODE;
	
	/**
	 * 商品促销id
	 */
	private String CXID;
	
	/**
	 * 商品规格
	 */
	private String SPGZ;
	
	/**
	 * 商品规格ID
	 */
	private String SPGZID;
	
	/**
	 * 活动数量
	 */
	private String HDSL;
	
	/**
	 * 秒杀数量
	 */
	private String MSJG;
	
	/**
	 * 商品价格
	 */
	private String SPRICE;
	
	/**
	 * 是否拼团商品0否;1是
	 */
	private String ISPT;
	
	/**
	 * 商家id
	 */
	private String storeid;
	
	/**
	 * 性质
	 * @return
	 */
	private String isst;
	public String getSPRICE() {
		return SPRICE;
	}

	public void setSPRICE(String sPRICE) {
		SPRICE = sPRICE;
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

	public String getSPCODE()
	{
		return SPCODE;
	}

	public void setSPCODE(String sPCODE)
	{
		SPCODE = sPCODE;
	}

	public String getCXID()
	{
		return CXID;
	}

	public void setCXID(String cXID)
	{
		CXID = cXID;
	}

	public String getMSPID()
	{
		return MSPID;
	}

	public void setMSPID(String mSPID)
	{
		MSPID = mSPID;
	}

	public String getSPGZ()
	{
		return SPGZ;
	}

	public void setSPGZ(String sPGZ)
	{
		SPGZ = sPGZ;
	}

	public String getSPGZID()
	{
		return SPGZID;
	}

	public void setSPGZID(String sPGZID)
	{
		SPGZID = sPGZID;
	}

	public String getISPT()
	{
		return ISPT;
	}

	public void setISPT(String iSPT)
	{
		ISPT = iSPT;
	}

	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}

	public String getIsst() {
		return isst;
	}

	public void setIsst(String isst) {
		this.isst = isst;
	}

	
}
