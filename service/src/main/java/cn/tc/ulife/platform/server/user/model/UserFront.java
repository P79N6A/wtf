package cn.tc.ulife.platform.server.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.tc.ulife.platform.util.GsonUtil;
import cn.tc.ulife.platform.util.UtilToString;
import cn.tc.ulife.platform.util.constance.CacheConstance;
import cn.tc.ulife.platform.util.jedis.JedisProxy;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.model.vo.user
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/7 0007
 * </p>
 * Time: 上午 10:45
 * </p>
 * Detail: 前端用户信息 vo
 * </p>
 */
public class UserFront {


    private String id;

    private String account;


    private String mobile;

    private String tel;

    private String nickName;

    @JsonIgnore
    private String name;

    private String identityNo;

    private String birthday;

    private String gender;

    private String address;

    @JsonIgnore
    private String regtime;

    @JsonIgnore
    private String lastModifytime;

    private String headImage;

    private String email;

    @JsonIgnore
    private String qq;
    @JsonIgnore
    private String wx;

    @JsonIgnore
    private String zt;

    @JsonIgnore
    private String remark;

    @JsonIgnore
    private String dtype;

    @JsonIgnore
    private String regmMthod;

    @JsonIgnore
    private String creator;

    private String comId;

    private String fjdz;


    private String communityName;


    private String isNewUser;


    public void setCache() {
        new JedisProxy().getJedisProxy().hset(CacheConstance.USER_INFO_KEY, this.getId(), GsonUtil.objectToJson(this));
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
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

    public String getLastModifytime() {
        return lastModifytime;
    }

    public void setLastModifytime(String lastModifytime) {
        this.lastModifytime = lastModifytime;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
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

    public String getRegmMthod() {
        return regmMthod;
    }

    public void setRegmMthod(String regmMthod) {
        this.regmMthod = regmMthod;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getFjdz() {
        return fjdz;
    }

    public void setFjdz(String fjdz) {
        this.fjdz = fjdz;
    }

    public String getIsNewUser() {
        return isNewUser;
    }

    public void setIsNewUser(String isNewUser) {
        this.isNewUser = isNewUser;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
