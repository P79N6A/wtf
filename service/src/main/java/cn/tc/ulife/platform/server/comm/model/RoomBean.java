package cn.tc.ulife.platform.server.comm.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;
/**
 * 房间对象
 * 日期 2017年2月21日
 * 时间 下午1:24:22
 * @author lwy
 *
 */
public class RoomBean extends BaseBean{
	
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
	 * 房间名称
	 */
	private String name;
	
	/**
	 * 社区结构
	 */
	private String communityStruct;
	/**
	 * 社区结构id
	 */
	private String communityStructID;
	
	/**
	 * 社区结构name
	 */
	private String communityStructName;
	/**
	 * 房号地址
	 */
	private String fjdz;
	
	/**
	 * 是否入住
	 */
	private String isrz;
	
	/**
	 * 居住状态
	 */
	private String jzzt;
	
	/**
	 * 帐号数量
	 */
	private String zhsl;
	
	/**
	 * 最后更新时间
	 */
	private String lastModifyTime;
	
	/**
	 * 创建者
	 */	
	private String creator;
	
	/**
	 * 状态
	 */
	private String zt;

	/**
	 * 结构格式开始
	 */
	private String  patternSt;
	/**
	 * 结构格式结束
	 */
	private String  patternEn;
	/**
	 * 单位
	 */
	private String unit;
	
	/**
	 * 房间号全称
	 */
	private String fname;
	
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

	public String getCommunityStructID() {
		return communityStructID;
	}

	public void setCommunityStructID(String communityStructID) {
		this.communityStructID = communityStructID;
	}

	public String getFjdz() {
		return fjdz;
	}

	public void setFjdz(String fjdz) {
		this.fjdz = fjdz;
	}

	public String getIsrz() {
		return isrz;
	}

	public void setIsrz(String isrz) {
		this.isrz = isrz;
	}

	public String getJzzt() {
		return jzzt;
	}

	public void setJzzt(String jzzt) {
		this.jzzt = jzzt;
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

	public String getCommunityStruct() {
		return communityStruct;
	}

	public void setCommunityStruct(String communityStruct) {
		this.communityStruct = communityStruct;
	}

	public String getCommunityStructName() {
		return communityStructName;
	}

	public void setCommunityStructName(String communityStructName) {
		this.communityStructName = communityStructName;
	}

	public String getPatternSt() {
		return patternSt;
	}

	public void setPatternSt(String patternSt) {
		this.patternSt = patternSt;
	}

	public String getPatternEn() {
		return patternEn;
	}

	public void setPatternEn(String patternEn) {
		this.patternEn = patternEn;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getZhsl() {
	    return zhsl;
	}

	public void setZhsl(String zhsl) {
	    this.zhsl = zhsl;
	}

}
