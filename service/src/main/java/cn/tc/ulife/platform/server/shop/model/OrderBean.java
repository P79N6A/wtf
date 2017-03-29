package cn.tc.ulife.platform.server.shop.model;


import cn.tc.ulife.platform.server.utils.model.BaseBean;
import cn.tc.ulife.platform.util.UtilToString;
/**
 * 订单信息对象
 * 日期 2017年3月20日
 * 时间 下午2:17:27
 * @author lwy
 *
 */
public class OrderBean extends BaseBean {

    /**
     * 主键ID
     */
    private String id;
    /**
     * 上级订单编号
     */
    private String porderbh;
    /**
     * 父节点ID
     */
    private String pid;
    /**
     * 买家账号
     */
    private String buyeraccount;
    /**
     * 订单编号
     */
    private String orderbh;
    /**
     * 第三方交易号
     */
    private String alipayorder;
    /**
     * 用户ID
     */
    private String uid;
    /**
     * 客户姓名
     */
    private String uname;
    /**
     * 客户电话
     */
    private String tel;
    /**
     * 客户地址
     */
    private String dz;
    /**
     * 商家ID
     */
    private String sjid;
    /**
     * 商家名称
     */
    private String sjname;
    /**
     * 商品ID
     */
    private String spid;
    /**
     * 商品名称
     */
    private String spname;
    /**
     * 订购数量
     */
    private String dgsl;
    /**
     * 商品售价
     */
    private String sprice;
    /**
     * 原总价
     */
    private String yzj;
    /**
     * 规格ID
     */
    private String ggid;
    /**
     * 规格单位
     */
    private String ggdw;
    /**
     * 规格数值
     */
    private String ggsz;
    /**
     * 自提点ID
     */
    private String ztd;
    /**
     * 折后总价
     */
    private String zhzj;
    /**
     * 购买时间
     */
    private String gtime;
    
    /**
     * 配送费
     */
    private String psf;
    /**
     * 订单状态
     */
    private String ozt;
    /**
     * 订单来源
     */
    private String oly;
   
    /**
     * 订单异常终止说明
     */
    private String ycsm;
    /**
     * 订单所属小区
     */
    private String xqid;
    
    /**
     * 是否使用积分
     */
    private String isjf;
    /**
     * 积分金额
     */
    private String jfje;
   
    /**
     * 支付状态
     */
    private String zfzt;
    /**
     * 支付方式
     */
    private String zffs;
    /**
     * 配送方式
     */
    private String psfs;
    /**
     * 备注
     */
    private String remark;
    /**
     * 客服ID
     */
    private String kfid;
    /**
     * 抢单时间
     */
    private String qdsj;
    /**
     * 创建者
     */
    private String cid;
    /**
     * 状态
     */
    private String zt;
   
    /**
     * 订单配送日期
     */
    private String psrq;
    /**
     * 订单类型
     */
    private String type;
    /**
     * 小站地址
     */
    private String xzdz;
    
    /**
     * 产品线
     */
    private String pline;
    /**
     * 优惠券信息
     */
    private String yhjxx;

    public String getYhjxx() {
		return yhjxx;
	}

	public void setYhjxx(String yhjxx) {
		this.yhjxx = yhjxx;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPorderbh() {
        return porderbh;
    }

    public void setPorderbh(String porderbh) {
        this.porderbh = porderbh;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getBuyeraccount() {
        return buyeraccount;
    }

    public void setBuyeraccount(String buyeraccount) {
        this.buyeraccount = buyeraccount;
    }

    public String getOrderbh() {
        return orderbh;
    }

    public void setOrderbh(String orderbh) {
        this.orderbh = orderbh;
    }

    public String getAlipayorder() {
        return alipayorder;
    }

    public void setAlipayorder(String alipayorder) {
        this.alipayorder = alipayorder;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getSjid() {
        return sjid;
    }

    public void setSjid(String sjid) {
        this.sjid = sjid;
    }

    public String getSjname() {
        return sjname;
    }

    public void setSjname(String sjname) {
        this.sjname = sjname;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public String getDgsl() {
        return dgsl;
    }

    public void setDgsl(String dgsl) {
        this.dgsl = dgsl;
    }

    public String getSprice() {
        return sprice;
    }

    public void setSprice(String sprice) {
        this.sprice = sprice;
    }

    public String getYzj() {
        return yzj;
    }

    public void setYzj(String yzj) {
        this.yzj = yzj;
    }

    public String getGgdw() {
        return ggdw;
    }

    public void setGgdw(String ggdw) {
        this.ggdw = ggdw;
    }

    public String getGgsz() {
        return ggsz;
    }

    public void setGgsz(String ggsz) {
        this.ggsz = ggsz;
    }

    public String getZtd() {
        return ztd;
    }

    public void setZtd(String ztd) {
        this.ztd = ztd;
    }

    public String getZhzj() {
        return zhzj;
    }

    public void setZhzj(String zhzj) {
        this.zhzj = zhzj;
    }

    public String getGtime() {
        return gtime;
    }

    public void setGtime(String gtime) {
        this.gtime = gtime;
    }

    

    public String getPsf() {
        return psf;
    }

    public void setPsf(String psf) {
        this.psf = psf;
    }

    public String getOzt() {
        return ozt;
    }

    public void setOzt(String ozt) {
        this.ozt = ozt;
    }

    public String getOly() {
        return oly;
    }

    public void setOly(String oly) {
        this.oly = oly;
    }

   

    public String getYcsm() {
        return ycsm;
    }

    public void setYcsm(String ycsm) {
        this.ycsm = ycsm;
    }

    public String getXqid() {
        return xqid;
    }

    public void setXqid(String xqid) {
        this.xqid = xqid;
    }

    public String getIsjf() {
        return isjf;
    }

    public void setIsjf(String isjf) {
        this.isjf = isjf;
    }

    public String getJfje() {
        return jfje;
    }

    public void setJfje(String jfje) {
        this.jfje = jfje;
    }
    
    public String getZfzt() {
        return zfzt;
    }

    public void setZfzt(String zfzt) {
        this.zfzt = zfzt;
    }

    public String getZffs() {
        return zffs;
    }

    public void setZffs(String zffs) {
        this.zffs = zffs;
    }

    public String getPsfs() {
        return psfs;
    }

    public void setPsfs(String psfs) {
        this.psfs = psfs;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getKfid() {
        return kfid;
    }

    public void setKfid(String kfid) {
        this.kfid = kfid;
    }

    public String getQdsj() {
        return qdsj;
    }

    public void setQdsj(String qdsj) {
        this.qdsj = qdsj;
    }

    public String getGgid() {
        return ggid;
    }

    public void setGgid(String ggid) {
        this.ggid = ggid;
    }


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }


    public String getPsrq() {
        return psrq;
    }

    public void setPsrq(String psrq) {
        this.psrq = psrq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getXzdz() {
        return xzdz;
    }

    public void setXzdz(String xzdz) {
        this.xzdz = xzdz;
    }


    public String getPline() {
        return pline;
    }

    public void setPline(String pline) {
        this.pline = pline;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}