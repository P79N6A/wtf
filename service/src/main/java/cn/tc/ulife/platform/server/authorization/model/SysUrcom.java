package cn.tc.ulife.platform.server.authorization.model;

import cn.tc.ulife.platform.util.UtilToString;

import java.util.Date;

public class SysUrcom {


    private String id;

    /**
     * 用户ID
     */
    private String uid;

    /**
     * 角色ID
     */
    private String rid;

    /**
     * 角色编码
     */
    private String rcode;

    /**
     * 社区ID
     */
    private String comId;

    /**
     * 房间ID
     */
    private String roomId;

    /**
     * 是否默认登陆小区 0 不默认登陆， 1 默认登陆
     */
    private String isDef;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 修改时间
     */
    private Date mtime;

    /**
     * 是否注册小区   0是;1不是
     */
    private String isReg;

    /**
     * 住户ID与所属房间id
     */
    private String hrid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getIsDef() {
        return isDef;
    }

    public void setIsDef(String isDef) {
        this.isDef = isDef;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getIsReg() {
        return isReg;
    }

    public void setIsReg(String isReg) {
        this.isReg = isReg;
    }

    public String getHrid() {
        return hrid;
    }

    public void setHrid(String hrid) {
        this.hrid = hrid;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}