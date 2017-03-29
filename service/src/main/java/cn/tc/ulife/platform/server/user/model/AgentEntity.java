package cn.tc.ulife.platform.server.user.model;

import cn.tc.ulife.platform.util.UtilToString;

public class AgentEntity {

    private String id;

    private String name;

    private String address;

    private String tel;

    private String responsibleId;

    private String mobile;

    private String jkkd;

    private String skzh;

    private String jkpl;

    private String remark;

    private String ctime;

    private String mtime;

    private String image;

    private String appintype;

    private String appnatype;

    private String rcode;

    private String commNames;


    private String zt;

    private String relationAccount;


    public String getRelationAccount() {
        return relationAccount;
    }

    public void setRelationAccount(String relationAccount) {
        this.relationAccount = relationAccount;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getCommNames() {
        return commNames;
    }

    public void setCommNames(String commNames) {
        this.commNames = commNames;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

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

    public String getResponsibleId() {

        return responsibleId;
    }

    public void setResponsibleId(String responsibleId) {
        this.responsibleId = responsibleId;
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


    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}