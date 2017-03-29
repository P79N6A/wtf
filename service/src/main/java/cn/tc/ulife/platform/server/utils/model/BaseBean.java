package cn.tc.ulife.platform.server.utils.model;
/**
 * 公用基础对象
 * 日期 2017年2月15日
 * 时间 下午2:40:39
 * @author lwy
 *
 */
public class BaseBean {
    private int limit;
   
    private int start;
    
    private String code;
    
    private String userId;
    
    private String oid;
   
    private String ctime;
    
    private String mtime;
   
    public int getLimit() {
        return limit !=0 ? limit:10;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getStart() {
        return start==1? start:0;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
    
    
}
