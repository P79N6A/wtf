package cn.tc.ulife.platform.server.tree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lwy
 * 树节点对象
 */
@SuppressWarnings("serial")
public class TreeNode implements Serializable {
	// ID
	private String id;
	// aID
	private String aid;
	// 显示文本
	private String text;
	// 是否叶子节点
	private String isleaf;
	@SuppressWarnings("unused")
	private boolean leaf;
	// 父节点
	private String pid;
	// Css类
	private String cls;
	// 其他属性列表
	private Map<String,String> otherAttribute;
	private String icon;
	//用户id
	private String uid;
	//序号
	private String xh;
	//状态
	private String zt;
	//url
	private String url;
	
	private String code;
	
	private String groupid;//资源分组id
	
	//产品线id
	private String plid;
	
	//营销类目id
	private String gtid;
	
	//是否支持下发
	private String issued;
	
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getIssued() {
		return issued;
	}

	public void setIssued(String issued) {
		this.issued = issued;
	}

	public String getGtid() {
		return gtid;
	}

	public void setGtid(String gtid) {
		this.gtid = gtid;
	}

	public String getPlid() {
		return plid;
	}

	public void setPlid(String plid) {
		this.plid = plid;
	}
	// 子节点
	private List<TreeNode> children = new ArrayList<TreeNode>();
	// 默认构造方法
	public TreeNode(){
		
	}
	
	/***
	 * 初始化构造方法
	 * @param id
	 * @param text
	 * @param pid
	 * @param leaf
	 */
	public TreeNode(String id,String text,String pid,String isleaf,String url,String code){
		this.id = id;
		this.text = text;
		this.pid = pid;
		this.isleaf = isleaf;
		this.url = url;
		this.code = code;
	}
	
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public Map<String,String> getOtherAttribute() {
		return otherAttribute;
	}

	public void setOtherAttribute(Map<String,String> otherAttribute) {
		this.otherAttribute = otherAttribute;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getIsleaf()
	{
		return isleaf;
	}

	public void setIsleaf(String isleaf)
	{
		this.isleaf = isleaf;
	}

	public String getPid()
	{
		return pid;
	}

	public void setPid(String pid)
	{
		this.pid = pid;
	}

	public String getXh()
	{
		return xh;
	}

	public void setXh(String xh)
	{
		this.xh = xh;
	}

	public String getZt()
	{
		return zt;
	}

	public void setZt(String zt)
	{
		this.zt = zt;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public boolean isLeaf() {
		if("0".equals(this.isleaf)){
			return false;
		}else{
			return true;
		}
	}
	public void setLeaf(boolean leaf)
	{
		this.leaf = leaf;
	}

	public String getAid() {
	    return aid;
	}

	public void setAid(String aid) {
	    this.aid = aid;
	}

}
