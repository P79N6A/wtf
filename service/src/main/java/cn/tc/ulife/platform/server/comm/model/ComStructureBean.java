package cn.tc.ulife.platform.server.comm.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;

/**
 * 社区结构对象
 * 日期 2017年2月21日
 * 时间 下午1:23:03
 * @author lwy
 *
 */
public class ComStructureBean extends BaseBean{

	/**
	 * 主键id
	 */
	private String rid;
	/**
	 * 数据对接id
	 */
	private String id;
	/**
	 * 社区id
	 */
	private String communityId;
	
	/**
	 * 结构名称
	 */
	private String name;	
	/**
	 * 结构全称
	 */
	private String fullName;
	/**
	 * 是否末级
	 */
	private String isLast;
	
	/**
	 * 最后修改时间
	 */
	private String  lastModifyTime;
	
	/**
	 * 创建者
	 */
	private String creator;
	
	/**
	 * 状态
	 */
	private String zt;
	
	/**
	 * 结构格式 开始
	 */
	private String  patternStra;
	
	 /**
	 *结构格式  结束 
	 */
	private String  patternEnd;
	/**
	 * 父节点ID
	 */
	private String parentId;
	
        /**
         * 父节点名称
         * @return
         */
	private String  parentName;
 
	/**
	 * 父级
	 */
	private String  parentLevel;
	
	/**
	 * 单位
	 */
	private String unit;
   
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIsLast() {
		return isLast;
	}

	public void setIsLast(String isLast) {
		this.isLast = isLast;
	}

	public String getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getPatternStra() {
		return patternStra;
	}

	public void setPatternStra(String patternStra) {
		this.patternStra = patternStra;
	}

	public String getPatternEnd() {
		return patternEnd;
	}

	public void setPatternEnd(String patternEnd) {
		this.patternEnd = patternEnd;
	}

	public String getParentLevel() {
		return parentLevel;
	}

	public void setParentLevel(String parentLevel) {
		this.parentLevel = parentLevel;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
}
