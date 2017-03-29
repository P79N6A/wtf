/**
 * @Title: WareSpecEntity
 * @Package cn.tc.ulife.platform.server.ware.model
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2017/2/23 14:49
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.entity;

import cn.tc.ulife.platform.util.UtilToString;

/**
 * @author alliswell008
 * @ClassName: WareSpecEntity
 * @Description: TODO(用一句话来说明)
 * @date 2017/2/23 14:49
 */
public class WareSpecEntity
{
    /**
     * 主键
     */
    private String id;

    /**
     * 商品id
     */
    private String spid;

    /**
     * 商品条码
     */
    private String sptm;

    /**
     * 积分
     */
    private String jf;

    /**
     * 规格数字
     */
    private String ggsz;

    /**
     * 规格单位
     */
    private String ggdw;

    /**
     * 规格备注
     */
    private String ggbz;

    /**
     * 商品销售价
     */
    private String sprice;

    /**
     * 成本价
     */
    private String cost;

    /**
     * 商品库存
     */
    private String spkc;

    /**
     * 锁定数量
     */
    private String freecount;

    /**
     * 是否上架 1 上架 0 下架
     */
    private String issj;

    /**
     * 预警值
     */
    private String yjz;

    /**
     * 是否 预警 0 预警
     */
    private String isyj;

    /**
     * 采购库存
     */
    private String cgkc;

    /**
     * 序号
     */
    private String xh;

    /**
     * 商品重量
     */
    private String spzl;

    /**
     * 时间
     */
    private String ctime;

    private String mtime;

    /**
     * 操作IP
     */
    private String mip;

    /**
     * 操作用户id
     */
    private String muid;

    /**
     * 是否默认选择
     */
    private String isdefault;

    /**
     * 售卖方式
     */
    private String smjsz;
    /**
     * 配送次数
     */
    private String pscs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpid()
    {
        return spid;
    }

    public void setSpid(String spid)
    {
        this.spid = spid;
    }

    public String getSptm() {
        return sptm;
    }

    public void setSptm(String sptm) {
        this.sptm = sptm;
    }

    public String getJf() {
        return jf;
    }

    public void setJf(String jf) {
        this.jf = jf;
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

    public String getGgbz() {
        return ggbz;
    }

    public void setGgbz(String ggbz) {
        this.ggbz = ggbz;
    }

    public String getSprice()
    {
        return sprice;
    }

    public void setSprice(String sprice)
    {
        this.sprice = sprice;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getSpkc() {
        return spkc;
    }

    public void setSpkc(String spkc) {
        this.spkc = spkc;
    }

    public String getFreecount() {
        return freecount;
    }

    public void setFreecount(String freecount) {
        this.freecount = freecount;
    }

    public String getIssj() {
        return issj;
    }

    public void setIssj(String issj) {
        this.issj = issj;
    }

    public String getYjz() {
        return yjz;
    }

    public void setYjz(String yjz) {
        this.yjz = yjz;
    }

    public String getIsyj() {
        return isyj;
    }

    public void setIsyj(String isyj) {
        this.isyj = isyj;
    }

    public String getCgkc() {
        return cgkc;
    }

    public void setCgkc(String cgkc) {
        this.cgkc = cgkc;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getSpzl() {
        return spzl;
    }

    public void setSpzl(String spzl) {
        this.spzl = spzl;
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

    public String getMip() {
        return mip;
    }

    public void setMip(String mip) {
        this.mip = mip;
    }

    public String getMuid() {
        return muid;
    }

    public void setMuid(String muid) {
        this.muid = muid;
    }

    public String getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault;
    }

    public String getSmjsz() {
        return smjsz;
    }

    public void setSmjsz(String smjsz) {
        this.smjsz = smjsz;
    }

    public String getPscs() {
        return pscs;
    }

    public void setPscs(String pscs) {
        this.pscs = pscs;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
