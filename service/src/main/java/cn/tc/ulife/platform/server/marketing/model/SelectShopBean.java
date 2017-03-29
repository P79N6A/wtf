package cn.tc.ulife.platform.server.marketing.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;

public class SelectShopBean extends BaseBean{
	
	private String xqid;
	
	private String sjid;
	
	private String sjmc;
	
	private String id;
	
	private String name;
	
	private String cxid;
	
	private String cxName;
	
	private String ggid;
	/**
	 * 规格标准
	 */
	private String ggbz;
	
	private String ktime;
	
	private String jtime;
	
	private String gzcode;
	
	private String type;
	
	/**
	 * 商品类型(0实体商品;1服务商品;2积分商品)
	 */
	private String isst;
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSjid() {
		return sjid;
	}

	public void setSjid(String sjid) {
		this.sjid = sjid;
	}

	public String getSjmc() {
		return sjmc;
	}

	public void setSjmc(String sjmc) {
		this.sjmc = sjmc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCxid() {
		return cxid;
	}

	public void setCxid(String cxid) {
		this.cxid = cxid;
	}

	public String getCxName() {
		return cxName;
	}

	public void setCxName(String cxName) {
		this.cxName = cxName;
	}

	public String getGgid() {
		return ggid;
	}

	public void setGgid(String ggid) {
		this.ggid = ggid;
	}

	public String getGgbz() {
		return ggbz;
	}

	public void setGgbz(String ggbz) {
		this.ggbz = ggbz;
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

	public String getGzcode() {
		return gzcode;
	}

	public void setGzcode(String gzcode) {
		this.gzcode = gzcode;
	}

	public String getXqid() {
		return xqid;
	}

	public void setXqid(String xqid) {
		this.xqid = xqid;
	}

	public String getIsst() {
		return isst;
	}

	public void setIsst(String isst) {
		this.isst = isst;
	}
	

}
