package cn.tc.ulife.platform.door.mode;
import java.io.Serializable;

import cn.tc.ulife.platform.util.UtilToString;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * 门口机广告位置表 Persistence Object
 * 门口机广告位置表 
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public class RkeAdLocationEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 广告位ID */
	protected String adlId;
	/** 终端设备类型ID，譬如：手机端，门口机等 */
	protected String adldevTypeId;
	/** 广告位标识ID */
	protected String adldevLid;
	/** 广告位描述 */
	protected String adlname;
	/** 图片尺寸 */
	protected String adlimageSize;
	/** 广告类型 */
	protected String adladtype;
	/** 最后一次修改人登录名 */
	protected String adllastLoginName;
	/** 最后一次修改时间 */
	protected String adleditDate;
	/** 最后一次修改IP */
	protected String adllastEditIp;
	/** creater */
	protected String creater;
	/** 开发者sid */
	protected String accountSid;
	/** get 广告位ID */
	public String getAdlId() {
		return this.adlId;
	}
	
	/** set 广告位ID */
	public void setAdlId(String adlId) {
		this.adlId = adlId;
	}
	
	/** get 终端设备类型ID，譬如：手机端，门口机等 */
	public String getAdldevTypeId() {
		return this.adldevTypeId;
	}
	
	/** set 终端设备类型ID，譬如：手机端，门口机等 */
	public void setAdldevTypeId(String adldevTypeId) {
		this.adldevTypeId = adldevTypeId;
	}
	
	/** get 广告位标识ID */
	public String getAdldevLid() {
		return this.adldevLid;
	}
	
	/** set 广告位标识ID */
	public void setAdldevLid(String adldevLid) {
		this.adldevLid = adldevLid;
	}
	
	/** get 广告位描述 */
	public String getAdlname() {
		return this.adlname;
	}
	
	/** set 广告位描述 */
	public void setAdlname(String adlname) {
		this.adlname = adlname;
	}
	
	/** get 图片尺寸 */
	public String getAdlimageSize() {
		return this.adlimageSize;
	}
	
	/** set 图片尺寸 */
	public void setAdlimageSize(String adlimageSize) {
		this.adlimageSize = adlimageSize;
	}
	
	/** get 广告类型 */
	public String getAdladtype() {
		return this.adladtype;
	}
	
	/** set 广告类型 */
	public void setAdladtype(String adladtype) {
		this.adladtype = adladtype;
	}
	
	/** get 最后一次修改人登录名 */
	public String getAdllastLoginName() {
		return this.adllastLoginName;
	}
	
	/** set 最后一次修改人登录名 */
	public void setAdllastLoginName(String adllastLoginName) {
		this.adllastLoginName = adllastLoginName;
	}
	
	/** get 最后一次修改时间 */
	public String getAdleditDate() {
		return this.adleditDate;
	}
	
	/** set 最后一次修改时间 */
	public void setAdleditDate(String adleditDate) {
		this.adleditDate = adleditDate;
	}
	
	/** get 最后一次修改IP */
	public String getAdllastEditIp() {
		return this.adllastEditIp;
	}
	
	/** set 最后一次修改IP */
	public void setAdllastEditIp(String adllastEditIp) {
		this.adllastEditIp = adllastEditIp;
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