package cn.tc.ulife.platform.server.authorization.model;

import cn.tc.ulife.platform.util.UtilToString;

public class SysRootActionModel {

    private String id;

    /**
     * 菜单资源id
     */
    private String rid;

    /**
     * 菜单资源CODE
     */
    private String rcode;

    /**
     * 功能名称
     */
    private String name;

    /**
     * 功能code
     */
    private String code;

    /**
     * 功能URL
     */
    private String url;

    /**
     * 序号
     */
    private String sort;

    /**
     * 创建者ID
     */
    private String cid;

    private String ctime;

    private String mtime;

    /**
     * 状态
     */
    private String zt;

    /**
     * JS脚本
     */
    private String js;

    private String buttonCheck;

    public String getButtonCheck() {
        return buttonCheck;
    }

    public void setButtonCheck(String buttonCheck) {
        this.buttonCheck = buttonCheck;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}