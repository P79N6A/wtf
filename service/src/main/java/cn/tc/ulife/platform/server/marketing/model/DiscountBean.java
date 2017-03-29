/**
 * 
 */
package cn.tc.ulife.platform.server.marketing.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;

/**
 * @author lcc
 * 
 *         折扣率对象
 */
public class DiscountBean extends BaseBean {
	/**
	 * ID
	 */
	private String id;

	/**
	 * 折扣率
	 */
	private String zk;

	/**
	 * 创建时间
	 */
	private String ctime;
	/**
	 * 修改时间
	 */
	private String mtime;

	/**
	 * 折扣有效期开始时间
	 */
	private String ktime;

	/**
	 * 备注
	 */
	private String remark;
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZk() {
		return zk;
	}

	public void setZk(String zk) {
		this.zk = zk;
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

	public String getKtime() {
		return ktime;
	}

	public void setKtime(String ktime) {
		this.ktime = ktime;
	}

	public String getJtime() {
		return jtime;
	}

	public void setJtime(String jtime) {
		this.jtime = jtime;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}

	/**
	 * 折扣有效期介绍时间
	 */
	private String jtime;

	private String zt;
	/**
	 * storeid
	 * 
	 * @return
	 */
	private String storeid;

}
