/**
 * @Title: OrderPage
 * @Package cn.tc.ulife.platform.server.shop.page
 * @Description: 订单page对象
 * @author alliswell
 * @date 2017/3/24 11:12
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.tc.ulife.platform.server.shop.page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alliswell
 * @Title: OrderPage
 * @Package cn.tc.ulife.platform.server.shop.page
 * @Description: 订单page对象
 * @date 2017/3/24 11:12
 */
public class OrderPage {

    /**主键ID */
    private String id;
    /**买家账号 */
    private String buyeraccount;
    /**订单编号 */
    private String orderbh;
    /**第三方交易号 */
    private String alipayorder;
    /**用户ID */
    private String uid;
    /**客户姓名 */
    private String uname;
    /**客户电话 */
    private String tel;
    /**客户地址 */
    private String dz;
    /**原总价 */
    private String yzj;
    /**配送费 */
    private String psf;
    /**折后总价 */
    private String zhzj;
    /**购买时间 */
    private String gtime;
    /**订单状态 */
    private String ozt;
    /**订单来源 */
    private String oly;
    /**订单异常终止说明 */
    private String ycsm;
    /**订单所属小区 */
    private String xqid;
    /**使用积分 */
    private String jfje;
    /**支付状态 */
    private String zfzt;
    /**支付方式 */
    private String zffs;
    /**配送方式 */
    private String psfs;
    /**备注 */
    private String remark;
    /**自提点ID */
    private String ztd;
    /**客服ID */
    private String kfid;
    /**抢单时间 */
    private String qdsj;
    /**修改时间 */
    private String mtime;
    /**创建者 */
    private String cid;
    /**状态 */
    private String zt;
    /**订单配送日期 */
    private String psrq;
    /**订单类型 */
    private String type;
    /**产品线 */
    private String pline;
    /**订单商品 */
    List<OrderGoodsPage> orderGoodsPages = new ArrayList<>();
    /**订单促销 */
    OrderMarkPage orderMarkPage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getYzj() {
        return yzj;
    }

    public void setYzj(String yzj) {
        this.yzj = yzj;
    }

    public String getPsf() {
        return psf;
    }

    public void setPsf(String psf) {
        this.psf = psf;
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

    public String getZtd() {
        return ztd;
    }

    public void setZtd(String ztd) {
        this.ztd = ztd;
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

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
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

    public String getPline() {
        return pline;
    }

    public void setPline(String pline) {
        this.pline = pline;
    }

    public List<OrderGoodsPage> getOrderGoodsPages() {
        return orderGoodsPages;
    }

    public void setOrderGoodsPages(List<OrderGoodsPage> orderGoodsPages) {
        this.orderGoodsPages = orderGoodsPages;
    }

    public OrderMarkPage getOrderMarkPage() {
        return orderMarkPage;
    }

    public void setOrderMarkPage(OrderMarkPage orderMarkPage) {
        this.orderMarkPage = orderMarkPage;
    }
}
