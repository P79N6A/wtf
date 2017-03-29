/**
 * 
 */
package cn.tc.ulife.platform.server.marketing.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;

/**
 * 拼团对象
 * 日期 2016-5-5
 * 时间 下午5:04:56
 * @author lwy
 *
 */
public class FightGroupsBean extends BaseBean
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
	 * 成团人数
	 */
	private String CTRS;

	/**
	 * 拼团价格
	 */
	private String PTJG;

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
	 * 最大成团数量
	 */
	private String CTSL;
	
	/**
	 * 拼团简介
	 */
	private String PTJJ;
	
	/**
	 * 拼团详情
	 */
	private String PTXQ;
	
	/**
	 * 组团次数
	 */
	private String ZTCS;
	
	/**
	 * 团长优惠
	 */
	private String TZYH;
	
	/**
	 * 拼团logo
	 */
	private String LOGO;
	
	/**
	 * 拼团图片详情
	 */
	private String XQT;
	
	/**
	 * 每人最大拼团数
	 */
	private String MRZDPTS;
	
	/**
	 * 创建者ID或商家id
	 */
	private String CID;
	
	/**
	 * 成团有效期
	 */
	private String CTYXQ;
	
	/**
	 * 状态0:新建;1已发布;2停用
	 */
	private String ZT;
	
	/**
	 * 配送费
	 */
	private String PSF;
	
	/**
	 * 规格ID
	 */
	private String GGID;
	
	/**
	 * 商品id
	 */
	private String SPID;
	
	/**
	 * 商品名称
	 */
	private String SPNAME;
	
	/**
	 * 规格名称
	 */
	private String GGNAME;
	
	/**
	 * 商家id
	 */
	private String SJID;
	/**
	 * 购买数量
	 */
	private String GMRS;
	
	/**
	 * 商家id
	 * @return
	 */
    private String storeid;

	public String getGMRS() {
		return GMRS;
	}

	public void setGMRS(String gMRS) {
		GMRS = gMRS;
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

	public String getCTRS()
	{
		return CTRS;
	}

	public void setCTRS(String cTRS)
	{
		CTRS = cTRS;
	}

	public String getPTJG()
	{
		return PTJG;
	}

	public void setPTJG(String pTJG)
	{
		PTJG = pTJG;
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

	public String getCTSL()
	{
		return CTSL;
	}

	public void setCTSL(String cTSL)
	{
		CTSL = cTSL;
	}

	public String getPTJJ()
	{
		return PTJJ;
	}

	public void setPTJJ(String pTJJ)
	{
		PTJJ = pTJJ;
	}

	public String getPTXQ()
	{
		return PTXQ;
	}

	public void setPTXQ(String pTXQ)
	{
		PTXQ = pTXQ;
	}

	public String getZTCS()
	{
		return ZTCS;
	}

	public void setZTCS(String zTCS)
	{
		ZTCS = zTCS;
	}

	public String getTZYH()
	{
		return TZYH;
	}

	public void setTZYH(String tZYH)
	{
		TZYH = tZYH;
	}

	public String getLOGO()
	{
		return LOGO;
	}

	public void setLOGO(String lOGO)
	{
		LOGO = lOGO;
	}

	public String getXQT()
	{
		return XQT;
	}

	public void setXQT(String xQT)
	{
		XQT = xQT;
	}

	public String getMRZDPTS()
	{
		return MRZDPTS;
	}

	public void setMRZDPTS(String mRZDPTS)
	{
		MRZDPTS = mRZDPTS;
	}

	public String getCID()
	{
		return CID;
	}

	public void setCID(String cID)
	{
		CID = cID;
	}

	public String getCTYXQ()
	{
		return CTYXQ;
	}

	public void setCTYXQ(String cTYXQ)
	{
		CTYXQ = cTYXQ;
	}

	public String getZT()
	{
		return ZT;
	}

	public void setZT(String zT)
	{
		ZT = zT;
	}

	public String getPSF()
	{
		return PSF;
	}

	public void setPSF(String pSF)
	{
		PSF = pSF;
	}

	public String getGGID()
	{
		return GGID;
	}

	public void setGGID(String gGID)
	{
		GGID = gGID;
	}

	public String getSPID()
	{
		return SPID;
	}

	public void setSPID(String sPID)
	{
		SPID = sPID;
	}

	public String getSPNAME()
	{
		return SPNAME;
	}

	public void setSPNAME(String sPNAME)
	{
		SPNAME = sPNAME;
	}

	public String getGGNAME()
	{
		return GGNAME;
	}

	public void setGGNAME(String gGNAME)
	{
		GGNAME = gGNAME;
	}

	public String getSJID()
	{
		return SJID;
	}

	public void setSJID(String sJID)
	{
		SJID = sJID;
	}

	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}
	
	
	
	
	
}
