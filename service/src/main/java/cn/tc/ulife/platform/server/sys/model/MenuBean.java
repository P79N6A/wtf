package cn.tc.ulife.platform.server.sys.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;
import cn.tc.ulife.platform.validators.Must;

/**
 * @author lcc
 * 树节点对象
 */
public class MenuBean extends BaseBean{
	
	/**
	 * menu主键id
	 */
	@Must
	private String id;
	
	/**
	 * 资源分组ID
	 */
	private String groupid;
	
	/**
	 * 资源名称
	 */
	private String name;

	/**
	 *父资源名称 
	 */
	private String pname;
	/**
	 * 资源级别   1级应用 /系统 2级模块 3级功能
	 */
	private String level;
	
	/**
	 * 资源url
	 */
	private String url;
	
	/**
	 * 上级资源
	 */
	private String pid;
	
	/**
	 *序号 
	 */
	private String sort;
	
	/**
	 * 创建者id
	 */
	private String cid;
	
	/**
	 *状态 
	 */
	private String zt;
	
	/**
	 *资源类型 
	 */
	private String type;
	
	/**
	 * 是否叶子节点
	 */
	private String isleaf;
	
	/**
	 * 脚本js
	 */
	private String js;
	
	/**
	 * 菜单资源ID
	 */
	private String rid;
	
	/**
	 * 菜单资源CODE
	 */
	private String rcode;
	
	/**
	 * 是否可下发 0不限;1不能下发;2不能2次下发
	 */
	private String issued;
	
	/**
	 * 用户id
	 */
	private String uid;
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getIssued() {
		return issued;
	}

	public void setIssued(String issued) {
		this.issued = issued;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getJs() {
		return js;
	}

	public void setJs(String js) {
		this.js = js;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the mname
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param mname the mname to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * @return the zt
	 */
	public String getZt() {
		return zt;
	}

	/**
	 * @param zt the zt to set
	 */
	public void setZt(String zt) {
		this.zt = zt;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the isleaf
	 */
	public String getIsleaf() {
		return isleaf;
	}

	/**
	 * @param isleaf the isleaf to set
	 */
	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}
	
}
