package cn.tc.ulife.platform.server.shop.entity;

import cn.tc.ulife.platform.util.UtilToString;

import java.io.Serializable;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */

/**
 * 商家信息表 Persistence Object
 * 商家信息表
 *
 * @author taichuan Platform Group
 * @create 2017-03-10
 */
public class ScAgentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**  */
    private String id;
    /**  */
    private String name;
    /**  */
    private String address;
    /**  */
    private String tel;
    /**  */
    private String account;
    /**  */
    private String mobile;
    /**  */
    private String jkkd;
    /**  */
    private String skzh;
    /**  */
    private String jkpl;
    /**  */
    private String remark;
    /**  */
    private String ctime;
    /**  */
    private String mtime;
    /**  */
    private String image;
    /**  */
    private String appintype;
    /**  */
    private String appnatype;
    /**  */
    private String creator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getJkkd() {
        return jkkd;
    }

    public void setJkkd(String jkkd) {
        this.jkkd = jkkd;
    }

    public String getSkzh() {
        return skzh;
    }

    public void setSkzh(String skzh) {
        this.skzh = skzh;
    }

    public String getJkpl() {
        return jkpl;
    }

    public void setJkpl(String jkpl) {
        this.jkpl = jkpl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAppintype() {
        return appintype;
    }

    public void setAppintype(String appintype) {
        this.appintype = appintype;
    }

    public String getAppnatype() {
        return appnatype;
    }

    public void setAppnatype(String appnatype) {
        this.appnatype = appnatype;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}