/**
 * @Title: OrderGoodsPage
 * @Package cn.tc.ulife.platform.server.shop.page
 * @Description: 订单商品page对象
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

/**
 * @author alliswell
 * @Title: OrderGoodsPage
 * @Package cn.tc.ulife.platform.server.shop.page
 * @Description: 订单商品page对象
 * @date 2017/3/24 11:12
 */
public class OrderGoodsPage {

    /**主键ID */
    private String id;
    /**主订单编号 */
    private String porderbh;
    /**主订单ID */
    private String pid;
    /**订单编号 */
    private String orderbh;
    /**商家ID */
    private String sjid;
    /**商家名称 */
    private String sjname;
    /**商品ID */
    private String spid;
    /**商品名称 */
    private String spname;
    /**订购数量 */
    private String dgsl;
    /**商品售价 */
    private String sprice;
    /**原总价 */
    private String yzj;
    /**折后总价 */
    private String zhzj;
    /**规格ID */
    private String ggid;
    /**规格数值 */
    private String ggsz;
    /**规格单位 */
    private String ggdw;
    /**购买时间 */
    private String gtime;
    /**订单状态 */
    private String ozt;
    /**订单异常终止说明 */
    private String ycsm;
    /**备注 */
    private String remark;
    /**修改时间 */
    private String mtime;
    /**创建者 */
    private String cid;
    /**状态 */
    private String zt;


    private String iscx;
    private String iszt;


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

    public String getOrderbh() {
        return orderbh;
    }

    public void setOrderbh(String orderbh) {
        this.orderbh = orderbh;
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

    public String getZhzj() {
        return zhzj;
    }

    public void setZhzj(String zhzj) {
        this.zhzj = zhzj;
    }

    public String getGgid() {
        return ggid;
    }

    public void setGgid(String ggid) {
        this.ggid = ggid;
    }

    public String getGgsz() {
        return ggsz;
    }

    public void setGgsz(String ggsz) {
        this.ggsz = ggsz;
    }

    public String getGgdw() {
        return ggdw;
    }

    public void setGgdw(String ggdw) {
        this.ggdw = ggdw;
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

    public String getYcsm() {
        return ycsm;
    }

    public void setYcsm(String ycsm) {
        this.ycsm = ycsm;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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


    public String getIscx() {
        return iscx;
    }

    public void setIscx(String iscx) {
        this.iscx = iscx;
    }

    public String getIszt() {
        return iszt;
    }

    public void setIszt(String iszt) {
        this.iszt = iszt;
    }
}
