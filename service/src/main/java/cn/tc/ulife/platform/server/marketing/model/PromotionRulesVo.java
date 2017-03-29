/**
 * 
 */
package cn.tc.ulife.platform.server.marketing.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;

/**
 * 营销规则对象
 * 日期 2017年2月21日
 * 时间 下午1:20:41
 * @author Lcc
 *
 */
public class PromotionRulesVo extends BaseBean
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
	 * 描述
	 */
	private String miaos;


	/**
	 * 状态 0 正常 1 删除
	 */
	private String zt;


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



	public String getMiaos() {
		return miaos;
	}


	public void setMiaos(String miaos) {
		this.miaos = miaos;
	}


	public String getZt() {
		return zt;
	}


	public void setZt(String zt) {
		this.zt = zt;
	}
	
	
	
}
