package cn.tc.ulife.platform.server.marketing.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;

/**
 * 营销展示层
 * 日期 2017年2月24日
 * 时间 下午4:44:32
 * @author Lcc
 *
 */
public class YxViewBean extends BaseBean {
	
	private String xqid;
	
	private String id;
	/**
	 * 楼层名称
	 */
	private String title;	
	/**
	 * 详情
	 */
	private String detail;
	/**
	 * 
	 */
	private String viewLevel;	
	
	/**
	 * 
	 */
	private String group;
	/**
	 * 模板id
	 */
	private String groupId;
	/**
	 * 模板标识
	 */
	private String groupLogo;	
	private String cid;	
	private String zt;
	/**
	 * 是否显示
	 */
	private String isShow;	
	private String hight;	
	private String width;
	/**
	 * 图标
	 */
	private String icon;

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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getViewLevel() {
		return viewLevel;
	}

	public void setViewLevel(String viewLevel) {
		this.viewLevel = viewLevel;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
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

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getGroupLogo() {
		return groupLogo;
	}

	public void setGroupLogo(String groupLogo) {
		this.groupLogo = groupLogo;
	}

	public String getXqid() {
		return xqid;
	}

	public void setXqid(String xqid) {
		this.xqid = xqid;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	

}
