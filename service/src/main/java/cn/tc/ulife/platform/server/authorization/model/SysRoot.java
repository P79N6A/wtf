package cn.tc.ulife.platform.server.authorization.model;

import cn.tc.ulife.platform.util.UtilToString;

import java.util.List;

public class SysRoot {

    private String id;


    /**
     * 资源分组id
     */
    private String groupid;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源编码
     */
    private String code;

    /**
     * 资源级别 1及(应用/系统)2级(模块);3级(功能)
     */
    private String level;

    /**
     * 是否叶子节点
     */
    private String isleaf;


    private String url;

    /**
     * 上级资源ID
     */
    private String pid;

    /**
     * 序号
     */
    private String sort;

    /**
     * 创建者ID
     */
    private String cid;

    /**
     * 创建时间
     */
    private String ctime;

    /**
     * 修改时间
     */
    private String mtime;

    /**
     * 状态
     */
    private String zt;

    /**
     * 资源类型
     */
    private String type;

    /**
     * 是否可下发    0不限;1不能下发;2不能2次下发
     */
    private String issued;

    private String rootCheck;



    private List<SysRootActionModel> sysRootActionModelList;


    public String getRootCheck() {
        return rootCheck;
    }

    public void setRootCheck(String rootCheck) {
        this.rootCheck = rootCheck;
    }

    public List<SysRootActionModel> getSysRootActionModelList() {
        return sysRootActionModelList;
    }

    public void setSysRootActionModelList(List<SysRootActionModel> sysRootActionModelList) {
        this.sysRootActionModelList = sysRootActionModelList;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(String isleaf) {
        this.isleaf = isleaf;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}