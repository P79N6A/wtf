package cn.tc.ulife.platform.door.mode;
import java.io.Serializable;

import cn.tc.ulife.platform.util.UtilToString;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * 门口机公告内容表 Persistence Object
 * 门口机公告内容表 
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public class RkeAffichecontentEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 社区公告内容ID */
	protected String acId;
	/** 社区公告类别ID */
	protected String acAtId;
	/** 标题 */
	protected String accaption;
	/** 正文内容 */
	protected String accontext;
	/** 创建时间 */
	protected String accreateTime;
	/** 更新时间 */
	protected String acupdateTime;
	/** 是否有效 */
	protected String acenable;
	/** 终端类型，0住户手机公告，1门口机公告 */
	protected String acscope;
	/** creater */
	protected String creater;
	/** 开发者sid */
	protected String accountSid;
	/** get 社区公告内容ID */
	public String getAcId() {
		return this.acId;
	}
	
	/** set 社区公告内容ID */
	public void setAcId(String acId) {
		this.acId = acId;
	}
	
	/** get 社区公告类别ID */
	public String getAcAtId() {
		return this.acAtId;
	}
	
	/** set 社区公告类别ID */
	public void setAcAtId(String acAtId) {
		this.acAtId = acAtId;
	}
	
	/** get 标题 */
	public String getAccaption() {
		return this.accaption;
	}
	
	/** set 标题 */
	public void setAccaption(String accaption) {
		this.accaption = accaption;
	}
	
	/** get 正文内容 */
	public String getAccontext() {
		return this.accontext;
	}
	
	/** set 正文内容 */
	public void setAccontext(String accontext) {
		this.accontext = accontext;
	}
	
	/** get 创建时间 */
	public String getAccreateTime() {
		return this.accreateTime;
	}
	
	/** set 创建时间 */
	public void setAccreateTime(String accreateTime) {
		this.accreateTime = accreateTime;
	}
	
	/** get 更新时间 */
	public String getAcupdateTime() {
		return this.acupdateTime;
	}
	
	/** set 更新时间 */
	public void setAcupdateTime(String acupdateTime) {
		this.acupdateTime = acupdateTime;
	}
	
	/** get 是否有效 */
	public String getAcenable() {
		return this.acenable;
	}
	
	/** set 是否有效 */
	public void setAcenable(String acenable) {
		this.acenable = acenable;
	}
	
	/** get 终端类型，0住户手机公告，1门口机公告 */
	public String getAcscope() {
		return this.acscope;
	}
	
	/** set 终端类型，0住户手机公告，1门口机公告 */
	public void setAcscope(String acscope) {
		this.acscope = acscope;
	}
	
	/** get creater */
	public String getCreater() {
		return this.creater;
	}
	
	/** set creater */
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