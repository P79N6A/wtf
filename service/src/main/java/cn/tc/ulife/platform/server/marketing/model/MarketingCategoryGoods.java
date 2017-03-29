package cn.tc.ulife.platform.server.marketing.model;
/**
 * 商品与类目映射表
 * 日期 2016-8-3
 * 时间 下午2:36:56
 * @author wbx
 *
 */
public class MarketingCategoryGoods {
    private String id;
    
    private String gid;
    
    private String gtid;
    
    private String type;
    
    private String ctime;
    
    private String mtime;
    
    private String cid;
    
    private String url;

    private String fid;
    
	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getGtid() {
		return gtid;
	}

	public void setGtid(String gtid) {
		this.gtid = gtid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getMtime() {
		return mtime;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	
	

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
    
}
