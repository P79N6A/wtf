package cn.tc.ulife.platform.server.marketing.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;

/**
 * 营销展示层位置信息表
 * 日期 2016-5-10
 * 时间 下午7:10:31
 * @author ydm
 *
 */
public class YxViewPos extends BaseBean{
	
	private String id;	
	private String title;
	/**
	 * 活动描述
	 */
	private String  depict;	
	private String vid;
	/**
	 * 模板id
	 */
	private String groupId;
	/**
	 * 位置id
	 */
	private String locid;
	
	private String location;
	/**
	 * 活动类型  1商品列表，2单品，3URL；
	 */
	private String type;	
	private String ktime;	
	private String jtime;	
	private String hight;	
	private String width;	
	private String cid;	
	/**
	 *状态    0启用;1新建;2停用;3删除
	 */
	private String zt;	
	/**
	 * 营销活动id(保存code)多个以,分割
	 */	
	private String yxid;
	/**
	 *是否展示   0展示;1不展示
	 */
	private String iszs;
	/**
	 * 图标地址
	 */
	private String url;
	/**
	 * 第三方链接地址
	 */
	private String linkUrl;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getLocid() {
		return locid;
	}
	public void setLocid(String locid) {
		this.locid = locid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getHight() {
		return hight;
	}
	public void setHight(String hight) {
		this.hight = hight;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
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
	public String getYxid() {
		return yxid;
	}
	public void setYxid(String yxid) {
		this.yxid = yxid;
	}
	public String getIszs() {
		return iszs;
	}
	public void setIszs(String iszs) {
		this.iszs = iszs;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getDepict() {
		return depict;
	}
	public void setDepict(String depict) {
		this.depict = depict;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}
