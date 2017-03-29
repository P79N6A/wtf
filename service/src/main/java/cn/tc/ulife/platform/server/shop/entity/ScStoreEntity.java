package cn.tc.ulife.platform.server.shop.entity;
import java.io.Serializable;

import cn.tc.ulife.platform.util.UtilToString;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * 商家信息表 Persistence Object
 * 商家信息表 
 * @author taichuan Platform Group
 * @create 2017-03-10 */
public class ScStoreEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** id */
	protected String id;
	/** name */
	protected String name;
	/** address */
	protected String address;
	/** tel */
	protected String tel;
	/** account */
	protected String account;
	/** mobile */
	protected String mobile;
	/** sjms */
	protected String sjms;
	/** remark */
	protected String remark;
	/** sprice */
	protected String sprice;
	/** fare */
	protected String fare;
	/** fjf */
	protected String fjf;
	/** ktime */
	protected String ktime;
	/** jtime */
	protected String jtime;
	/** isps */
	protected String isps;
	/** stra */
	protected Integer stra;
	/** djl */
	protected String djl;
	/** ctime */
	protected String ctime;
	/** mtime */
	protected String mtime;
	/** isrs */
	protected String isrs;
	/** xh */
	protected Integer xh;
	/** 0生鲜;1拼团;2服务;4宅配;7U周边 */
	protected String xz;
	/** logo */
	protected String logo;
	/** image */
	protected String image;
	/** image2 */
	protected String image2;
	/** image3 */
	protected String image3;
	/** image4 */
	protected String image4;
	/** image5 */
	protected String image5;
	/** image6 */
	protected String image6;
	/** 0正常;1冻结;2关闭 */
	protected String zt;
	/** 0;支持;1不支持 */
	protected String type;
	/** 0积分;1配送费 */
	protected String isjf;
	/** jfje */
	protected String jfje;
	/** pline */
	protected String pline;
	/** zk */
	protected String zk;
	/** lat */
	protected String lat;
	/** lng */
	protected String lng;
	/** 1是0否,默认0否 */
	protected String isyhflag;
	/** creator */
	protected String creator;
	/** get id */
	public String getid() {
		return this.id;
	}
	
	/** set id */
	public void setId(String id) {
		this.id = id;
	}
	
	/** get name */
	public String getname() {
		return this.name;
	}
	
	/** set name */
	public void setName(String name) {
		this.name = name;
	}
	
	/** get address */
	public String getaddress() {
		return this.address;
	}
	
	/** set address */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/** get tel */
	public String gettel() {
		return this.tel;
	}
	
	/** set tel */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/** get account */
	public String getaccount() {
		return this.account;
	}
	
	/** set account */
	public void setAccount(String account) {
		this.account = account;
	}
	
	/** get mobile */
	public String getmobile() {
		return this.mobile;
	}
	
	/** set mobile */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/** get sjms */
	public String getsjms() {
		return this.sjms;
	}
	
	/** set sjms */
	public void setSjms(String sjms) {
		this.sjms = sjms;
	}
	
	/** get remark */
	public String getremark() {
		return this.remark;
	}
	
	/** set remark */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/** get sprice */
	public String getsprice() {
		return this.sprice;
	}
	
	/** set sprice */
	public void setSprice(String sprice) {
		this.sprice = sprice;
	}
	
	/** get fare */
	public String getfare() {
		return this.fare;
	}
	
	/** set fare */
	public void setFare(String fare) {
		this.fare = fare;
	}
	
	/** get fjf */
	public String getfjf() {
		return this.fjf;
	}
	
	/** set fjf */
	public void setFjf(String fjf) {
		this.fjf = fjf;
	}
	
	/** get ktime */
	public String getktime() {
		return this.ktime;
	}
	
	/** set ktime */
	public void setKtime(String ktime) {
		this.ktime = ktime;
	}
	
	/** get jtime */
	public String getjtime() {
		return this.jtime;
	}
	
	/** set jtime */
	public void setJtime(String jtime) {
		this.jtime = jtime;
	}
	
	/** get isps */
	public String getisps() {
		return this.isps;
	}
	
	/** set isps */
	public void setIsps(String isps) {
		this.isps = isps;
	}
	
	/** get stra */
	public Integer getstra() {
		return this.stra;
	}
	
	/** set stra */
	public void setStra(Integer stra) {
		this.stra = stra;
	}
	
	/** get djl */
	public String getdjl() {
		return this.djl;
	}
	
	/** set djl */
	public void setDjl(String djl) {
		this.djl = djl;
	}
	
	/** get ctime */
	public String getctime() {
		return this.ctime;
	}
	
	/** set ctime */
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
	/** get mtime */
	public String getmtime() {
		return this.mtime;
	}
	
	/** set mtime */
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	
	/** get isrs */
	public String getisrs() {
		return this.isrs;
	}
	
	/** set isrs */
	public void setIsrs(String isrs) {
		this.isrs = isrs;
	}
	
	/** get xh */
	public Integer getxh() {
		return this.xh;
	}
	
	/** set xh */
	public void setXh(Integer xh) {
		this.xh = xh;
	}
	
	/** get 0生鲜;1拼团;2服务;4宅配;7U周边 */
	public String getxz() {
		return this.xz;
	}
	
	/** set 0生鲜;1拼团;2服务;4宅配;7U周边 */
	public void setXz(String xz) {
		this.xz = xz;
	}
	
	/** get logo */
	public String getlogo() {
		return this.logo;
	}
	
	/** set logo */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	/** get image */
	public String getimage() {
		return this.image;
	}
	
	/** set image */
	public void setImage(String image) {
		this.image = image;
	}
	
	/** get image2 */
	public String getimage2() {
		return this.image2;
	}
	
	/** set image2 */
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	
	/** get image3 */
	public String getimage3() {
		return this.image3;
	}
	
	/** set image3 */
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	
	/** get image4 */
	public String getimage4() {
		return this.image4;
	}
	
	/** set image4 */
	public void setImage4(String image4) {
		this.image4 = image4;
	}
	
	/** get image5 */
	public String getimage5() {
		return this.image5;
	}
	
	/** set image5 */
	public void setImage5(String image5) {
		this.image5 = image5;
	}
	
	/** get image6 */
	public String getimage6() {
		return this.image6;
	}
	
	/** set image6 */
	public void setImage6(String image6) {
		this.image6 = image6;
	}
	
	/** get 0正常;1冻结;2关闭 */
	public String getzt() {
		return this.zt;
	}
	
	/** set 0正常;1冻结;2关闭 */
	public void setZt(String zt) {
		this.zt = zt;
	}
	
	/** get 0;支持;1不支持 */
	public String gettype() {
		return this.type;
	}
	
	/** set 0;支持;1不支持 */
	public void setType(String type) {
		this.type = type;
	}
	
	/** get 0积分;1配送费 */
	public String getisjf() {
		return this.isjf;
	}
	
	/** set 0积分;1配送费 */
	public void setIsjf(String isjf) {
		this.isjf = isjf;
	}
	
	/** get jfje */
	public String getjfje() {
		return this.jfje;
	}
	
	/** set jfje */
	public void setJfje(String jfje) {
		this.jfje = jfje;
	}
	
	/** get pline */
	public String getpline() {
		return this.pline;
	}
	
	/** set pline */
	public void setPline(String pline) {
		this.pline = pline;
	}
	
	/** get zk */
	public String getzk() {
		return this.zk;
	}
	
	/** set zk */
	public void setZk(String zk) {
		this.zk = zk;
	}
	
	/** get lat */
	public String getlat() {
		return this.lat;
	}
	
	/** set lat */
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	/** get lng */
	public String getlng() {
		return this.lng;
	}
	
	/** set lng */
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	/** get 1是0否,默认0否 */
	public String getisyhflag() {
		return this.isyhflag;
	}
	
	/** set 1是0否,默认0否 */
	public void setIsyhflag(String isyhflag) {
		this.isyhflag = isyhflag;
	}
	
	/** get creator */
	public String getcreator() {
		return this.creator;
	}
	
	/** set creator */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
    @Override
	public String toString() {
        return UtilToString.getString(this);
	}
}