/**
 * 
 */
package cn.tc.ulife.platform.server.marketing.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;
import cn.tc.ulife.platform.validators.Must;

/**
 * 营销规则对象
 * 日期 2017年2月21日
 * 时间 下午1:20:41
 * @author Lcc
 *
 */
public class PromotionRulesBean extends BaseBean
{
	/**
	 * ID
	 */
	private String id;

	/**
	 * 规则名称
	 */
	private String name;
	
	/**
	 * 规则唯一编码
	 */
	@Must
	private String code;

	/**
	 * 描述
	 */
	private String miaos;

	/**
	 * 创建时间
	 */
	private String ctime;

	/**
	 * 修改时间
	 */
	private String mtime;


	/**
	 * 状态 0 正常 1 删除
	 */
	private String zt;
	
	private String ids;
	
	public String getIds() {
		return ids;
	}


	public void setIds(String ids) {
		this.ids = ids;
	}


	public String getId()
	{
		return id;
	}


	public void setId(String id)
	{
		this.id = id;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String getCode()
	{
		return code;
	}


	public void setCode(String code)
	{
		this.code = code;
	}


	public String getMiaos()
	{
		return miaos;
	}


	public void setMiaos(String miaos)
	{
		this.miaos = miaos;
	}


	public String getCtime()
	{
		return ctime;
	}


	public void setCtime(String ctime)
	{
		this.ctime = ctime;
	}


	public String getMtime()
	{
		return mtime;
	}


	public void setMtime(String mtime)
	{
		this.mtime = mtime;
	}


	public String getZt()
	{
		return zt;
	}


	public void setZt(String zt)
	{
		this.zt = zt;
	}


	
	

}
