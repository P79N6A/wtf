package cn.tc.ulife.platform.door.mode;
import java.io.Serializable;

import cn.tc.ulife.platform.util.UtilToString;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * 门口机广告内容表 Persistence Object
 * 门口机广告内容表 
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public class RkeAdDataEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 广告ID */
	protected String addId;
	/** 广告名称 */
	protected String addname;
	/** 广告文件存放项目路径 */
	protected String addpath;
	/** addfileSize */
	protected String addfileSize;
	/** 广告资源类型（0 图片，1 视频） */
	protected String addtype;
	/** 最后一次修改人登录名 */
	protected String addlastLoginName;
	/** 最后一次修改时间 */
	protected String addlastEditDate;
	/** 最后一次修改IP */
	protected String addlastLoginIp;
	/** creater */
	protected String creater;
	/** 开发者sid */
	protected String accountSid;
	/** get 广告ID */
	public String getAddId() {
		return this.addId;
	}
	
	/** set 广告ID */
	public void setAddId(String addId) {
		this.addId = addId;
	}
	
	/** get 广告名称 */
	public String getAddname() {
		return this.addname;
	}
	
	/** set 广告名称 */
	public void setAddname(String addname) {
		this.addname = addname;
	}
	
	/** get 广告文件存放项目路径 */
	public String getAddpath() {
		return this.addpath;
	}
	
	/** set 广告文件存放项目路径 */
	public void setAddpath(String addpath) {
		this.addpath = addpath;
	}
	
	/** get addfileSize */
	public String getAddfileSize() {
		return this.addfileSize;
	}
	
	/** set addfileSize */
	public void setAddfileSize(String addfileSize) {
		this.addfileSize = addfileSize;
	}
	
	/** get 广告资源类型（0 图片，1 视频） */
	public String getAddtype() {
		return this.addtype;
	}
	
	/** set 广告资源类型（0 图片，1 视频） */
	public void setAddtype(String addtype) {
		this.addtype = addtype;
	}
	
	/** get 最后一次修改人登录名 */
	public String getAddlastLoginName() {
		return this.addlastLoginName;
	}
	
	/** set 最后一次修改人登录名 */
	public void setAddlastLoginName(String addlastLoginName) {
		this.addlastLoginName = addlastLoginName;
	}
	
	/** get 最后一次修改时间 */
	public String getAddlastEditDate() {
		return this.addlastEditDate;
	}
	
	/** set 最后一次修改时间 */
	public void setAddlastEditDate(String addlastEditDate) {
		this.addlastEditDate = addlastEditDate;
	}
	
	/** get 最后一次修改IP */
	public String getAddlastLoginIp() {
		return this.addlastLoginIp;
	}
	
	/** set 最后一次修改IP */
	public void setAddlastLoginIp(String addlastLoginIp) {
		this.addlastLoginIp = addlastLoginIp;
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