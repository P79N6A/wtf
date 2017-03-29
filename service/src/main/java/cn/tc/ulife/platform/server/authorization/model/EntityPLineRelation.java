package cn.tc.ulife.platform.server.authorization.model;


import cn.tc.ulife.platform.server.utils.model.BaseBean;

public class EntityPLineRelation extends BaseBean {
    private String id;


    private String name;

    private String logo;

    private String pid;

    private String uid;

    private String zkl;

    private String cid;

//    private String ctime;

//    private String mtime;

    /**
     * 0 启用  1：删除
     */
    private String zt;

    private String rcode;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getZkl() {
        return zkl;
    }

    public void setZkl(String zkl) {
        this.zkl = zkl;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

//    public String getCtime() {
//        return ctime;
//    }
//
//    public void setCtime(String ctime) {
//        this.ctime = ctime;
//    }
//
//    public String getMtime() {
//        return mtime;
//    }
//
//    public void setMtime(String mtime) {
//        this.mtime = mtime;
//    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }
}