package cn.tc.ulife.platform.server.marketing.model;

public class ComCodeBean
{

	// ID
	private String id;
	// 显示文本
	@SuppressWarnings("unused")
	private String text;
	// 名称
	private String name;
	// 级别
	private String level;
	// 类型
	private String tyle;
	
	private String bizid;
	
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 角色code
	 */
	private String rcode;
	// 简称
	private String jc;
	
	/**
	 *小区id
	 */
	private String comid;
	
	/**
	 * 模板
	 * 
	 */
	private String temp;
	

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getText()
	{
		return this.name;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLevel()
	{
		return level;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}

	public String getTyle()
	{
		return tyle;
	}

	public void setTyle(String tyle)
	{
		this.tyle = tyle;
	}

	public String getJc()
	{
		return jc;
	}

	public void setJc(String jc)
	{
		this.jc = jc;
	}

	public String getRcode()
	{
		return rcode;
	}

	public void setRcode(String rcode)
	{
		this.rcode = rcode;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getBizid()
	{
		return bizid;
	}

	public void setBizid(String bizid)
	{
		this.bizid = bizid;
	}

}
