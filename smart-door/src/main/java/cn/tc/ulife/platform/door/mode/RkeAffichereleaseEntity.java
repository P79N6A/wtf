package cn.tc.ulife.platform.door.mode;
import java.io.Serializable;

import cn.tc.ulife.platform.util.UtilToString;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * 门口机发布公告关系表 Persistence Object
 * 门口机发布公告关系表 
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public class RkeAffichereleaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** afrId */
	protected String afrId;
	/** 公告内容ID */
	protected String afrAcId;
	/** 社区ID */
	protected String afrCoid;
	/** afrcreator */
	protected String afrcreator;
	/** 开发者sid */
	protected String accountSid;
	/** get afrId */
	public String getAfrId() {
		return this.afrId;
	}
	
	/** set afrId */
	public void setAfrId(String afrId) {
		this.afrId = afrId;
	}
	
	/** get 公告内容ID */
	public String getAfrAcId() {
		return this.afrAcId;
	}
	
	/** set 公告内容ID */
	public void setAfrAcId(String afrAcId) {
		this.afrAcId = afrAcId;
	}
	
	/** get 社区ID */
	public String getAfrCoid() {
		return this.afrCoid;
	}
	
	/** set 社区ID */
	public void setAfrCoid(String afrCoid) {
		this.afrCoid = afrCoid;
	}
	
	/** get afrcreator */
	public String getAfrcreator() {
		return this.afrcreator;
	}
	
	/** set afrcreator */
	public void setAfrcreator(String afrcreator) {
		this.afrcreator = afrcreator;
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