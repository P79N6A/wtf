/**
 * @Title: BaseUserEntity
 * @Package cn.tc.ulife.platform.server.user.model
 * @Description: 用户基础信息表
 * @author alliswell
 * @date 2017/3/8 14:28
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.tc.ulife.platform.server.user.model;

import cn.tc.ulife.platform.util.UtilToString;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author alliswell
 * @Title: BaseUserEntity
 * @Package cn.tc.ulife.platform.server.user.model
 * @Description: 用户基础信息表
 * @date 2017/3/8 14:28
 */
public class BaseUserEntity {

    private String id;
    @JsonIgnore
    private String hid;
    @JsonIgnore
    private String or_id;
    private String account;
    @JsonIgnore
    private String password;
    private String mobile;
    private String tel;
    private String nickname;
    private String name;
    private String identityno;
    private String birthday;
    private String gender;
    private String address;
    private String regtime;
    private String lastmodifytime;
    private String headimage;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String qq;
    @JsonIgnore
    private String wx;
    private String zt;
    private String remark;
    private String dtype;
    private String regmethod;
    private String creator;
    private String kfid;
    private String identitytype;
    private String isnewuser;
    private String comid;
    private String roomid;
    private String talkaccount;
    private String talkpassword;
    private String uhomepassword;
    private String isaudited;
    private String accountsid;
    private String rke_ischild;
    private String rke_fingerprint;
    private String rke_callphone;
    private String rke_maxcardcount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getOr_id() {
        return or_id;
    }

    public void setOr_id(String or_id) {
        this.or_id = or_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityno() {
        return identityno;
    }

    public void setIdentityno(String identityno) {
        this.identityno = identityno;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(String lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getRegmethod() {
        return regmethod;
    }

    public void setRegmethod(String regmethod) {
        this.regmethod = regmethod;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getKfid() {
        return kfid;
    }

    public void setKfid(String kfid) {
        this.kfid = kfid;
    }

    public String getIdentitytype() {
        return identitytype;
    }

    public void setIdentitytype(String identitytype) {
        this.identitytype = identitytype;
    }

    public String getIsnewuser() {
        return isnewuser;
    }

    public void setIsnewuser(String isnewuser) {
        this.isnewuser = isnewuser;
    }

    public String getComid() {
        return comid;
    }

    public void setComid(String comid) {
        this.comid = comid;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getTalkaccount() {
        return talkaccount;
    }

    public void setTalkaccount(String talkaccount) {
        this.talkaccount = talkaccount;
    }

    public String getTalkpassword() {
        return talkpassword;
    }

    public void setTalkpassword(String talkpassword) {
        this.talkpassword = talkpassword;
    }

    public String getUhomepassword() {
        return uhomepassword;
    }

    public void setUhomepassword(String uhomepassword) {
        this.uhomepassword = uhomepassword;
    }

    public String getIsaudited() {
        return isaudited;
    }

    public void setIsaudited(String isaudited) {
        this.isaudited = isaudited;
    }

    public String getAccountsid() {
        return accountsid;
    }

    public void setAccountsid(String accountsid) {
        this.accountsid = accountsid;
    }

    public String getRke_ischild() {
        return rke_ischild;
    }

    public void setRke_ischild(String rke_ischild) {
        this.rke_ischild = rke_ischild;
    }

    public String getRke_fingerprint() {
        return rke_fingerprint;
    }

    public void setRke_fingerprint(String rke_fingerprint) {
        this.rke_fingerprint = rke_fingerprint;
    }

    public String getRke_callphone() {
        return rke_callphone;
    }

    public void setRke_callphone(String rke_callphone) {
        this.rke_callphone = rke_callphone;
    }

    public String getRke_maxcardcount() {
        return rke_maxcardcount;
    }

    public void setRke_maxcardcount(String rke_maxcardcount) {
        this.rke_maxcardcount = rke_maxcardcount;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
