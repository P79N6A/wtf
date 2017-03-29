package cn.tc.ulife.platform.server.shop.model;


import cn.tc.ulife.platform.util.StringUtil;
import cn.tc.ulife.platform.util.UtilToString;

/**
 * 产品线与小区运费信息表 日期 2016-10-26 时间 上午10:17:12
 * 
 * @author lcc
 * 
 */
public class Plinecom {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 产品线下发ID
	 */
	private String psid;
	/**
	 * 产品线id
	 */
	private String pid;
	/**
	 * 产品线名称
	 */
	private String lname;
	/**
	 * 小区id
	 */
	private String comid;
	/**
	 * 小区名称
	 */
	private String cname;
	/**
	 * 默认运费
	 */
	private String freight;
	/**
	 * 起免金额
	 */
	private String qmje;
	/**
	 * 创建时间
	 */
	private String ctime;
	/**
	 * 操作时间
	 */
	private String mtime;
	/**
	 * 积分抵运费
	 */
	private String jf;
	
	/**
	 * 是否使用积分
	 */
	private String isjf;
	
	
	
	public String getIsjf() {
		return isjf;
	}

	public void setIsjf(String isjf) {
		this.isjf = isjf;
	}

	public String getJf() {
		return jf;
	}

	public void setJf(String jf) {
		this.jf = jf;
	}

	private String cid;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPsid() {
		return psid;
	}

	public void setPsid(String psid) {
		this.psid = psid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getQmje() {
		return qmje;
	}

	public void setQmje(String qmje) {
		this.qmje = qmje;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getMtime() {
		return mtime;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }

}
