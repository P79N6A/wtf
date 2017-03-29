package cn.tc.ulife.platform.door.mode;
import java.io.Serializable;

import cn.tc.ulife.platform.util.UtilToString;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * 门口机公告类型表 Persistence Object
 * 门口机公告类型表 
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public class RkeAffichetypeEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 社区公告类别ID */
	protected String atId;
	/** 所属板块(0 物业通知 1社区公告 ) */
	protected String attype;
	/** 分类名 */
	protected String atname;
	/** 更新时间 */
	protected String atupdateTime;
	/** 公告类型图片路径 */
	protected String atimgUrl;
	/** creater */
	protected String creater;
	/** 开发者sid */
	protected String accountSid;
	/** get 社区公告类别ID */
	public String getAtId() {
		return this.atId;
	}
	
	/** set 社区公告类别ID */
	public void setAtId(String atId) {
		this.atId = atId;
	}
	
	/** get 所属板块(0 物业通知 1社区公告 ) */
	public String getAttype() {
		return this.attype;
	}
	
	/** set 所属板块(0 物业通知 1社区公告 ) */
	public void setAttype(String attype) {
		this.attype = attype;
	}
	
	/** get 分类名 */
	public String getAtname() {
		return this.atname;
	}
	
	/** set 分类名 */
	public void setAtname(String atname) {
		this.atname = atname;
	}
	
	/** get 更新时间 */
	public String getAtupdateTime() {
		return this.atupdateTime;
	}
	
	/** set 更新时间 */
	public void setAtupdateTime(String atupdateTime) {
		this.atupdateTime = atupdateTime;
	}
	
	/** get 公告类型图片路径 */
	public String getAtimgUrl() {
		return this.atimgUrl;
	}
	
	/** set 公告类型图片路径 */
	public void setAtimgUrl(String atimgUrl) {
		this.atimgUrl = atimgUrl;
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