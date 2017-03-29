package cn.tc.ulife.platform.door.mode;

import java.io.Serializable;

import cn.tc.ulife.platform.util.UtilToString;
import cn.tc.ulife.platform.validators.Must;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */

/**
 * 用户必须有房间， 才能绑定门禁卡 Persistence Object
 * 用户必须有房间， 才能绑定门禁卡
 *
 * @author taichuan Platform Group
 * @create 2017-03-13
 */
public class DoorCardEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * cdautoId
     */
    protected String cdautoId;
    /**
     * 卡的名称 后台输入
     */
    protected String cdname;
    /**
     * 编号 读卡器读写
     */
    @Must
    protected String cdnum;
    /**
     * 卡的类型 0 身份证，1 居住证，2 IC卡
     */
    @Must
    protected String cdcardType;
    /**
     * 账号类型 0 管理员，1 城际商，2 商家，3 物业，4 U家小站，5 住户
     */
    @Must
    protected String cdtype;
    /**
     * 住户ID
     */
    protected String cdhouseId;
    /**
     * 用户房间ID 用户必须有房间关系的ID
     */
    protected String cdUhid;
    /**
     * 添加时间
     */
    protected String cdaddTime;
    /**
     * 有效时段开始时
     */
    @Must
    protected String cdyxsdstart;
    /**
     * 有效时段结束时
     */
    @Must
    protected String cdyxsdend;
    /**
     * 有效期开始时间
     */
    @Must
    protected String cdyxqstart;
    /**
     * 有效期结束时间
     */
    @Must
    protected String cdyxqend;
    /**
     * 归属类型 0本人，1家属
     */
    @Must
    protected String cdownerType;
    /**
     * 归属人备注
     */
    protected String cdownerName;
    /**
     * 卡等级 0普通卡 1管理卡
     */
    @Must
    protected String cdcardLevel;
    /**
     * 开发者
     */
    @Must
    protected String accountSid;
    /**
     * 操作人
     */
    @Must
    protected String creater;
    /**
     * cdlastModifyTime
     */
    @Must
    protected String cdlastModifyTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCdautoId() {
        return cdautoId;
    }

    public void setCdautoId(String cdautoId) {
        this.cdautoId = cdautoId;
    }

    public String getCdname() {
        return cdname;
    }

    public void setCdname(String cdname) {
        this.cdname = cdname;
    }

    public String getCdnum() {
        return cdnum;
    }

    public void setCdnum(String cdnum) {
        this.cdnum = cdnum;
    }

    public String getCdcardType() {
        return cdcardType;
    }

    public void setCdcardType(String cdcardType) {
        this.cdcardType = cdcardType;
    }

    public String getCdtype() {
        return cdtype;
    }

    public void setCdtype(String cdtype) {
        this.cdtype = cdtype;
    }

    public String getCdhouseId() {
        return cdhouseId;
    }

    public void setCdhouseId(String cdhouseId) {
        this.cdhouseId = cdhouseId;
    }

    public String getCdUhid() {
        return cdUhid;
    }

    public void setCdUhid(String cdUhid) {
        this.cdUhid = cdUhid;
    }

    public String getCdaddTime() {
        return cdaddTime;
    }

    public void setCdaddTime(String cdaddTime) {
        this.cdaddTime = cdaddTime;
    }

    public String getCdyxsdstart() {
        return cdyxsdstart;
    }

    public void setCdyxsdstart(String cdyxsdstart) {
        this.cdyxsdstart = cdyxsdstart;
    }

    public String getCdyxsdend() {
        return cdyxsdend;
    }

    public void setCdyxsdend(String cdyxsdend) {
        this.cdyxsdend = cdyxsdend;
    }

    public String getCdyxqstart() {
        return cdyxqstart;
    }

    public void setCdyxqstart(String cdyxqstart) {
        this.cdyxqstart = cdyxqstart;
    }

    public String getCdyxqend() {
        return cdyxqend;
    }

    public void setCdyxqend(String cdyxqend) {
        this.cdyxqend = cdyxqend;
    }

    public String getCdownerType() {
        return cdownerType;
    }

    public void setCdownerType(String cdownerType) {
        this.cdownerType = cdownerType;
    }

    public String getCdownerName() {
        return cdownerName;
    }

    public void setCdownerName(String cdownerName) {
        this.cdownerName = cdownerName;
    }

    public String getCdcardLevel() {
        return cdcardLevel;
    }

    public void setCdcardLevel(String cdcardLevel) {
        this.cdcardLevel = cdcardLevel;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCdlastModifyTime() {
        return cdlastModifyTime;
    }

    public void setCdlastModifyTime(String cdlastModifyTime) {
        this.cdlastModifyTime = cdlastModifyTime;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}