/**
 * 
 */
package cn.tc.ulife.platform.server.pay.model;

/**
 * @author lpf
 * 
 */
public class UpayFsBean
{
	/**
	 * 序号
	 */
	private String ZID;

	/**
	 * 支付名称
	 */
	private String zmc;

	/**
	 * 状态
	 */
	private String zt;

	/**
	 * 时间
	 */
	private String ctime;

	/**
	 * 用户ID
	 */
	private String uid;

	/**
	 * 手续费
	 */
	private String zfee;

	/**
	 * @return the zID
	 */
	public String getZID()
	{
		return ZID;
	}

	/**
	 * @param zID
	 *            the zID to set
	 */
	public void setZID(String zID)
	{
		ZID = zID;
	}

	/**
	 * @return the zmc
	 */
	public String getZmc()
	{
		return zmc;
	}

	/**
	 * @param zmc
	 *            the zmc to set
	 */
	public void setZmc(String zmc)
	{
		this.zmc = zmc;
	}

	/**
	 * @return the zt
	 */
	public String getZt()
	{
		return zt;
	}

	/**
	 * @param zt
	 *            the zt to set
	 */
	public void setZt(String zt)
	{
		this.zt = zt;
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
	 * @return the zfee
	 */
	public String getZfee()
	{
		return zfee;
	}

	/**
	 * @param zfee
	 *            the zfee to set
	 */
	public void setZfee(String zfee)
	{
		this.zfee = zfee;
	}

}
