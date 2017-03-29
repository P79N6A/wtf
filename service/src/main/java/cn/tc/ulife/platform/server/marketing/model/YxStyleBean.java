package cn.tc.ulife.platform.server.marketing.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;

/**
 * 营销主题
 * 日期 2017年2月24日
 * 时间 下午4:02:27
 * @author Lcc
 *
 */
public class YxStyleBean extends BaseBean{
	
	private String xqid;
	private String id;	
	private String ktime;	
	private String jtime;
	/**
	 * 活动描述
	 */
	private String depict;
	/**
	 * 活动类型   1商品列表，2单品，3URL；
	 */
	private String type;
	/**
	 * 营销活动code多个以,分割
	 */
	private String yxid;
	/**
	 * 活动名称
	 */
	private String tableName;
	/**
	 * 展示图片连接
	 */
	private String tableUrl;
	/**
	 * 联版位置  分别为联版1到8
	 */
	private String sort;
	/**
	 *连接类型    0 : 本地连接 1:第三方网页
	 */
	private String stype;
	/**
	 * 第三方链接地址
	 */
	private String linkUrl;
	
	private String cid;
	/**
	 * 0启用;1新建;2停用;3删除
	 */
	private String zt;
	/**
	 * 是否展示 0展示;1不展示
	 */
	private String iszs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getYxid() {
		return yxid;
	}

	public void setYxid(String yxid) {
		this.yxid = yxid;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableUrl() {
		return tableUrl;
	}

	public void setTableUrl(String tableUrl) {
		this.tableUrl = tableUrl;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getIszs() {
		return iszs;
	}

	public void setIszs(String iszs) {
		this.iszs = iszs;
	}

	public String getXqid() {
		return xqid;
	}

	public void setXqid(String xqid) {
		this.xqid = xqid;
	}
	
	

}
