/**
 * @Title: ProductLinePage
 * @Package cn.tc.ulife.platform.server.ware.model.productline
 * @Description: 产品线view对象
 * @author cxs
 * @date 2017/2/20 14:01
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.page;

import cn.tc.ulife.platform.util.UtilToString;

/**
 * @author cxs
 * @ClassName: ProductLinePage
 * @Description: 产品线view对象
 * @date 2017/2/20 14:01
 */
public class ProductLinePage {
    /**
     * 主键
     */
    private String id;
    /**
     * 产品线名称
     */
    private String name;
    /**
     * logo图
     */
    private String logo;
    /**
     * 购买方式(0:不限;1仅购物车;2仅直接购买)
     */
    private String gmfs;
    /**
     * 性质(0实体;1服务;2积分3拼团;4宅配;5充值;9其他)
     */
    private String xz;
    /**
     * 序号
     */
    private String sort;
    /**
     * 描述
     */
    private String ms;
    /**
     * 业务流程ID
     */
    private String bid;
    /**
     * 业务流程CODE
     */
    private String bcode;
    /**
     * 生成结构ID
     */
    private String cid;
    /**
     * 生成结构CODE
     */
    private String ccode;
    /**
     * 创建时间
     */
    private String ctime;
    /**
     * 状态(0有效;1无效)
     */
    private String zt;

    /**
     * 3三层类;1一层类
     */
    private String corder;
    /**
     * 资源ID
     */
    private String rtid;

    /**
     * 资源ID
     */
    private String[] rtids;
    /**
     * 子节点id
     */
    private String childid;

    private String uid;


    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getChildid() {
        return childid;
    }
    public void setChildid(String childid) {
        this.childid = childid;
    }
    public String getRtid() {
        return rtid;
    }
    public void setRtid(String rtid) {
        this.rtid = rtid;
    }
    public String[] getRtids() {
        return rtids;
    }
    public void setRtids(String[] rtids) {
        this.rtids = rtids;
    }
    public String getCorder() {
        return corder;
    }
    public void setCorder(String corder) {
        this.corder = corder;
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
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getGmfs() {
        return gmfs;
    }
    public void setGmfs(String gmfs) {
        this.gmfs = gmfs;
    }
    public String getXz() {
        return xz;
    }
    public void setXz(String xz) {
        this.xz = xz;
    }
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }
    public String getMs() {
        return ms;
    }
    public void setMs(String ms) {
        this.ms = ms;
    }
    public String getBid() {
        return bid;
    }
    public void setBid(String bid) {
        this.bid = bid;
    }
    public String getBcode() {
        return bcode;
    }
    public void setBcode(String bcode) {
        this.bcode = bcode;
    }
    public String getCid() {
        return cid;
    }
    public void setCid(String cid) {
        this.cid = cid;
    }
    public String getCcode() {
        return ccode;
    }
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    public String getCtime() {
        return ctime;
    }
    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
    public String getZt() {
        return zt;
    }
    public void setZt(String zt) {
        this.zt = zt;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
