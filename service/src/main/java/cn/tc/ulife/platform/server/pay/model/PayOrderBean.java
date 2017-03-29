/**
 * 
 */
package cn.tc.ulife.platform.server.pay.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;

/**
 * 
 *         账号交易流水
 */
public class PayOrderBean extends BaseBean
{
	/**
	 * 序号
	 */
	private String lID;
	
	/**
	 * 小区id
	 */
	private String comid;
	
	/**
	 * 地区id
	 */
	private String arid;

	/**
	 * 业主、物业、商家、小站都可能
	 */
	private String uid;

	/**
	 * 用户账号
	 */
	private String ANAME;

	/**
	 * 客户账号 支付宝、银联、微信
	 */
	private String zaccount;

	/**
	 * 汇款编号 现下操作纪录汇单号
	 */
	private String hkbh;

	/**
	 * 账号类型（0=业主，2=物业,3=小站,）
	 */
	private String utype;

	/**
	 * 支付账号类型(0=支付宝，1银联，2=微信)
	 */
	private String atype;

	/**
	 * 交易类型
	 * 
	 * 1：购买太川套餐,
	 * 
	 * 2：购买太川产品,
	 * 
	 * 3:支付宝充值，
	 * 
	 * 4：退款，
	 * 
	 * 5：线下充值,
	 * 
	 * 6:太川手续费,
	 * 
	 * 7:线下充值纠错,
	 * 
	 * 8:退款纠错,
	 * 
	 * 9:赔偿付款,
	 * 
	 * 10:赔偿付款纠错 ,
	 * 
	 * 11:支付宝手续费,
	 * 
	 * 12:团购支付宝转账,
	 * 
	 * 13:积分兑换余额,
	 * 
	 * 14:余额兑换积分）
	 */
	private String dtype;

	/**
	 * 商品订单
	 */
	private String ddid;
	/**
	 * 订单编号
	 */
	private String ORDERBH;

	/**
	 * 交易 金额
	 * 
	 * 收入+，支出-
	 */
	private String dprice;

	/**
	 * 公司账号余额
	 */
	private String mprice;

	/**
	 * 太川账号
	 */
	private String taccount;

	/**
	 * 财务说明 到款入账
	 */
	private String wcdesc;

	/**
	 * 财务记账
	 */
	private String remark;

	/**
	 * 创建时间
	 */
	private String ctime;

	/**
	 * 修改时间
	 */
	private String utime;

	/**
	 * 产生类型
	 */
	private String ptype;

	/**
	 * 操作人名称 id
	 */
	private String oUser;

	/**
	 * 操作人IP
	 */
	private String oIp;

	/**
	 * 操作状态 1无效 0有效
	 */
	private String ustate;

	/**
	 * 与第三方交易的订单号
	 */
	private String payorder;

	/**
	 * @return the lID
	 */
	public String getlID()
	{
		return lID;
	}

	/**
	 * @param lID
	 *            the lID to set
	 */
	public void setlID(String lID)
	{
		this.lID = lID;
	}

	/**
	 * @return the aNAME
	 */
	public String getANAME()
	{
		return ANAME;
	}

	/**
	 * @param aNAME
	 *            the aNAME to set
	 */
	public void setANAME(String aNAME)
	{
		ANAME = aNAME;
	}

	/**
	 * @return the uid
	 */
	public String getUid()
	{
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(String uid)
	{
		this.uid = uid;
	}

	/**
	 * @return the zaccount
	 */
	public String getZaccount()
	{
		return zaccount;
	}

	/**
	 * @param zaccount
	 *            the zaccount to set
	 */
	public void setZaccount(String zaccount)
	{
		this.zaccount = zaccount;
	}

	/**
	 * @return the hkbh
	 */
	public String getHkbh()
	{
		return hkbh;
	}

	/**
	 * @param hkbh
	 *            the hkbh to set
	 */
	public void setHkbh(String hkbh)
	{
		this.hkbh = hkbh;
	}

	/**
	 * @return the utype
	 */
	public String getUtype()
	{
		return utype;
	}

	/**
	 * @param utype
	 *            the utype to set
	 */
	public void setUtype(String utype)
	{
		this.utype = utype;
	}

	/**
	 * @return the atype
	 */
	public String getAtype()
	{
		return atype;
	}

	/**
	 * @param atype
	 *            the atype to set
	 */
	public void setAtype(String atype)
	{
		this.atype = atype;
	}

	/**
	 * @return the dtype
	 */
	public String getDtype()
	{
		return dtype;
	}

	/**
	 * @param dtype
	 *            the dtype to set
	 */
	public void setDtype(String dtype)
	{
		this.dtype = dtype;
	}

	/**
	 * @return the ddid
	 */
	public String getDdid()
	{
		return ddid;
	}

	/**
	 * @param ddid
	 *            the ddid to set
	 */
	public void setDdid(String ddid)
	{
		this.ddid = ddid;
	}

	/**
	 * @return the dprice
	 */
	public String getDprice()
	{
		return dprice;
	}

	/**
	 * @param dprice
	 *            the dprice to set
	 */
	public void setDprice(String dprice)
	{
		this.dprice = dprice;
	}

	/**
	 * @return the mprice
	 */
	public String getMprice()
	{
		return mprice;
	}

	/**
	 * @param mprice
	 *            the mprice to set
	 */
	public void setMprice(String mprice)
	{
		this.mprice = mprice;
	}

	/**
	 * @return the taccount
	 */
	public String getTaccount()
	{
		return taccount;
	}

	/**
	 * @param taccount
	 *            the taccount to set
	 */
	public void setTaccount(String taccount)
	{
		this.taccount = taccount;
	}

	/**
	 * @return the wcdesc
	 */
	public String getWcdesc()
	{
		return wcdesc;
	}

	/**
	 * @param wcdesc
	 *            the wcdesc to set
	 */
	public void setWcdesc(String wcdesc)
	{
		this.wcdesc = wcdesc;
	}

	/**
	 * @return the remark
	 */
	public String getRemark()
	{
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	/**
	 * @return the ctime
	 */
	public String getCtime()
	{
		return ctime;
	}

	/**
	 * @param ctime
	 *            the ctime to set
	 */
	public void setCtime(String ctime)
	{
		this.ctime = ctime;
	}

	/**
	 * @return the utime
	 */
	public String getUtime()
	{
		return utime;
	}

	/**
	 * @param utime
	 *            the utime to set
	 */
	public void setUtime(String utime)
	{
		this.utime = utime;
	}

	/**
	 * @return the ptype
	 */
	public String getPtype()
	{
		return ptype;
	}

	/**
	 * @param ptype
	 *            the ptype to set
	 */
	public void setPtype(String ptype)
	{
		this.ptype = ptype;
	}

	/**
	 * @return the oUser
	 */
	public String getoUser()
	{
		return oUser;
	}

	/**
	 * @param oUser
	 *            the oUser to set
	 */
	public void setoUser(String oUser)
	{
		this.oUser = oUser;
	}

	/**
	 * @return the oIp
	 */
	public String getoIp()
	{
		return oIp;
	}

	/**
	 * @param oIp
	 *            the oIp to set
	 */
	public void setoIp(String oIp)
	{
		this.oIp = oIp;
	}

	/**
	 * @return the ustate
	 */
	public String getUstate()
	{
		return ustate;
	}

	/**
	 * @param ustate
	 *            the ustate to set
	 */
	public void setUstate(String ustate)
	{
		this.ustate = ustate;
	}

	/**
	 * @return the payorder
	 */
	public String getPayorder()
	{
		return payorder;
	}

	/**
	 * @param payorder
	 *            the payorder to set
	 */
	public void setPayorder(String payorder)
	{
		this.payorder = payorder;
	}

	public String getORDERBH()
	{
		return ORDERBH;
	}

	public void setORDERBH(String oRDERBH)
	{
		ORDERBH = oRDERBH;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "PayOrderBean [lID=" + lID + ", uid=" + uid + ", ANAME=" + ANAME
				+ ", zaccount=" + zaccount + ", hkbh=" + hkbh + ", utype="
				+ utype + ", atype=" + atype + ", dtype=" + dtype + ", ddid="
				+ ddid + ", dprice=" + dprice + ", mprice=" + mprice
				+ ", taccount=" + taccount + ", wcdesc=" + wcdesc + ", remark="
				+ remark + ", ctime=" + ctime + ", utime=" + utime + ", ptype="
				+ ptype + ", oUser=" + oUser + ", oIp=" + oIp + ", ustate="
				+ ustate + ", payorder=" + payorder + "]";
	}

	public String getComid()
	{
		return comid;
	}

	public void setComid(String comid)
	{
		this.comid = comid;
	}

	public String getArid()
	{
		return arid;
	}

	public void setArid(String arid)
	{
		this.arid = arid;
	}

}
