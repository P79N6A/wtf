package cn.tc.ulife.platform.server.comm.model;

import cn.tc.ulife.platform.server.utils.model.BaseBean;
import cn.tc.ulife.platform.validators.Must;

/**
 * 社区对象
 * 日期 2017年2月15日
 * 时间 下午2:39:18
 * @author lwy
 *
 */
public class CommunityBean  extends BaseBean
{

    /**
     * 社区id
     */
    private String cid;

    /**
     * 对接数据id
     */
    private String id;

    /**
     * 社区名
     */
    @Must
    private String name;

    /**
     * 地址
     */
    private String address;
    /**
     * 行政地址
    */
    private String stdAddress;
    
    /**
     * 电话
     */
    @Must
    private String tel;
    
    /**
     * 社区logo
     */
    
    private String logo;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 区域id
     */
    @Must
    private String areaid;
    
    /**
     * 维度
     */
    @Must
    private String lat;
    
    /**
     * 经度
     */
    @Must
    private String lng;
    
    /**
     * 更新时间
     */
    private String lastModifyTime;
    
    /**
     * 是否可用
     */
    private String enable;
    
    /**
     * 社区是否开通套餐(0 未开通，1 已开通)
     */
    private String zt;
    
    /**
     * 创建人账号
     */
    private String creator;
    
    /**
     * 介绍
     */
    private String summary;
    
    /**
     * 小区简称
     */
    private String jc;
    
    /**
     * 是否测试数据
     */
    private String isTest;
    
    /**
     * 首字母简写
     */
    @Must
    private String szmjx;
    
    /**
     * 是否开通小区(0启用 1未启用)
     * 日期 2016-4-12
     * 时间 下午3:05:10
     * 创建者 ydm
     * @return
     */
    private String deleted;
    
    /**
     * 门口机类型(未知0 2000为1 3000为2 u9为3)
     */
    private String co_eqserial;
    /**
     * 开发者ID
     */
    private String accountsid;
    
    /**
     * 支付方法(0:不限;1:仅限线上支付;2:仅限货到付款)
     */
    private String zffs;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public String getStdAddress() {
        return stdAddress;
    }

    public void setStdAddress(String stdAddress) {
        this.stdAddress = stdAddress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    public String getIsTest() {
        return isTest;
    }

    public void setIsTest(String isTest) {
        this.isTest = isTest;
    }

    public String getSzmjx() {
        return szmjx;
    }

    public void setSzmjx(String szmjx) {
        this.szmjx = szmjx;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getCo_eqserial() {
        return co_eqserial;
    }

    public void setCo_eqserial(String co_eqserial) {
        this.co_eqserial = co_eqserial;
    }

    public String getAccountsid() {
        return accountsid;
    }

    public void setAccountsid(String accountsid) {
        this.accountsid = accountsid;
    }

    public String getZffs() {
        return zffs;
    }

    public void setZffs(String zffs) {
        this.zffs = zffs;
    }
    
    
    
	
}
