package cn.tc.ulife.platform.server.shop.model;

import org.apache.commons.lang3.StringUtils;

import cn.tc.ulife.platform.server.utils.model.BaseBean;

/**
 * 订单操作日志
 * 
 * @author cxs
 * 
 */
public class OrderLogBean extends BaseBean
{

	/**
	 * 主键ID
	 */
	private String id;
	/**
	 * 订单ID
	 */
	private String ddid;
	/**
	 * 订单编号
	 */
	private String ddbh;
	/**
	 * 上级订单ID
	 */
	private String pddid;
	/**
	 * 上级订单编号
	 */
	private String pddbh;
	/**
	 * 操作类型
	 */
	private String czlx;
	/**
	 * 操作时间
	 */
	private String czsj;
	/**
	 * 操作人
	 */
	private String czr;
	/**
	 * 操作IP
	 */
	private String czip;
	/**
	 * 操作来源
	 */
	private String czly;
	/**
	 * 用户类型
	 */
	private String userlx;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getDdbh() {
		return ddbh;
	}

	public void setDdbh(String ddbh) {
		this.ddbh = ddbh;
	}

	public String getPddid() {
		return pddid;
	}

	public void setPddid(String pddid) {
		this.pddid = pddid;
	}

	public String getPddbh() {
		return pddbh;
	}

	public void setPddbh(String pddbh) {
		this.pddbh = pddbh;
	}

	public String getCzlx() {
		return czlx;
	}

	public void setCzlx(String czlx) {
		this.czlx = czlx;
	}

	public String getCzsj() {
		return czsj;
	}

	public void setCzsj(String czsj) {
		this.czsj = czsj;
	}

	public String getCzr() {
		return czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	public String getCzip() {
		return czip;
	}

	public void setCzip(String czip) {
		this.czip = czip;
	}

	public String getCzly() {
		return czly;
	}

	public void setCzly(String czly) {
		this.czly = czly;
	}

	public String getUserlx() {
		return userlx;
	}

	public void setUserlx(String userlx) {
		this.userlx = userlx;
	}

	public String getCzlx_const() {
		if (StringUtils.equals(czlx, "1")) {
			return "申请提交";
		} else if (StringUtils.equals(czlx, "2")) {
			return "审核通过";
		} else if (StringUtils.equals(czlx, "3")) {
			return "审核不通过";
		} else {
			return "未知状态";
		}
	}

	public String getCzly_const() {
		if (StringUtils.equals(czly, "1")) {
			return "苹果手机";
		} else if (StringUtils.equals(czly, "4")) {
			return "安卓手机";
		} else if (StringUtils.equals(czly, "7")) {
			return "小站后台";
		} else if (StringUtils.equals(czly, "8")) {
			return "微信平台";
		} else {
			return "未知状态";
		}
	}
}

