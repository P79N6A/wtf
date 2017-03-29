package cn.tc.ulife.platform.door.mode;
import java.io.Serializable;

import cn.tc.ulife.platform.util.UtilToString;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * 门口机发布广告关系表 Persistence Object
 * 门口机发布广告关系表 
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public class RkeAdReleaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 广告发布ID */
	protected String adrId;
	/** 广告位ID */
	protected String adrAdlid;
	/** 广告内容ID */
	protected String adrAddid;
	/** 发布的社区id */
	protected String adrCoid;
	/** 发布时间 */
	protected String adraddDate;
	/** 广告连接地址 */
	protected String adrlink;
	/** 相同广告位的广告排序 */
	protected String adrsortNo;
	/** 0 未审核  1 已审核 2 已删除 */
	protected String adrstate;
	/** 最后一次修改人登录名 */
	protected String adrlastLoginName;
	/** 最后一次操作员登录IP */
	protected String adrlastLoginIp;
	/** 最后一次修改时间 */
	protected String adrlastEditDate;
	/** 发布者账号 */
	protected String creater;
	/** 开发者sid */
	protected String accountSid;
	/** get 广告发布ID */
	public String getAdrId() {
		return this.adrId;
	}
	
	/** set 广告发布ID */
	public void setAdrId(String adrId) {
		this.adrId = adrId;
	}
	
	/** get 广告位ID */
	public String getAdrAdlid() {
		return this.adrAdlid;
	}
	
	/** set 广告位ID */
	public void setAdrAdlid(String adrAdlid) {
		this.adrAdlid = adrAdlid;
	}
	
	/** get 广告内容ID */
	public String getAdrAddid() {
		return this.adrAddid;
	}
	
	/** set 广告内容ID */
	public void setAdrAddid(String adrAddid) {
		this.adrAddid = adrAddid;
	}
	
	/** get 发布的社区id */
	public String getAdrCoid() {
		return this.adrCoid;
	}
	
	/** set 发布的社区id */
	public void setAdrCoid(String adrCoid) {
		this.adrCoid = adrCoid;
	}
	
	/** get 发布时间 */
	public String getAdraddDate() {
		return this.adraddDate;
	}
	
	/** set 发布时间 */
	public void setAdraddDate(String adraddDate) {
		this.adraddDate = adraddDate;
	}
	
	/** get 广告连接地址 */
	public String getAdrlink() {
		return this.adrlink;
	}
	
	/** set 广告连接地址 */
	public void setAdrlink(String adrlink) {
		this.adrlink = adrlink;
	}
	
	/** get 相同广告位的广告排序 */
	public String getAdrsortNo() {
		return this.adrsortNo;
	}
	
	/** set 相同广告位的广告排序 */
	public void setAdrsortNo(String adrsortNo) {
		this.adrsortNo = adrsortNo;
	}
	
	/** get 0 未审核  1 已审核 2 已删除 */
	public String getAdrstate() {
		return this.adrstate;
	}
	
	/** set 0 未审核  1 已审核 2 已删除 */
	public void setAdrstate(String adrstate) {
		this.adrstate = adrstate;
	}
	
	/** get 最后一次修改人登录名 */
	public String getAdrlastLoginName() {
		return this.adrlastLoginName;
	}
	
	/** set 最后一次修改人登录名 */
	public void setAdrlastLoginName(String adrlastLoginName) {
		this.adrlastLoginName = adrlastLoginName;
	}
	
	/** get 最后一次操作员登录IP */
	public String getAdrlastLoginIp() {
		return this.adrlastLoginIp;
	}
	
	/** set 最后一次操作员登录IP */
	public void setAdrlastLoginIp(String adrlastLoginIp) {
		this.adrlastLoginIp = adrlastLoginIp;
	}
	
	/** get 最后一次修改时间 */
	public String getAdrlastEditDate() {
		return this.adrlastEditDate;
	}
	
	/** set 最后一次修改时间 */
	public void setAdrlastEditDate(String adrlastEditDate) {
		this.adrlastEditDate = adrlastEditDate;
	}
	
	/** get 发布者账号 */
	public String getCreater() {
		return this.creater;
	}
	
	/** set 发布者账号 */
	public void setCreater(String creater) {
		this.creater = creater;
	}
	
	/** get 开发者sid */
	public String getAccountSid() {
		return this.accountSid;
	}
	
	/** set 开发者sid */
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	
    @Override
	public String toString() {
        return UtilToString.getString(this);
	}
}