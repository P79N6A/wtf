package cn.tc.ulife.platform.server.shop.model;

import cn.tc.ulife.platform.util.UtilToString;

import java.util.List;

public class Market {
    private String id;

    private String marketName;

    private String gzCode;

    private String gzId;

    private String ktime;

    private String jtime;


    private String zhiJe;

    private String zhiKl;

    private String manJe;

    private String jianJe;

    private String manGjs;

    private String xgsl;


    private String miaos;

    private String sjid;

    private String ismtxg;

    private String memtype;

    private String hdsl;

    private String msjg;


    private String specificationId;

    private String cxId;

    private String xqId;

    private List<BuyGiftBean> buyGifts;

    public String getXqId() {
        return xqId;
    }

    public void setXqId(String xqId) {
        this.xqId = xqId;
    }

    public String getCxId() {
        return cxId;
    }

    public void setCxId(String cxId) {
        this.cxId = cxId;
    }

    public String getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(String specificationId) {
        this.specificationId = specificationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getGzCode() {
        return gzCode;
    }

    public void setGzCode(String gzCode) {
        this.gzCode = gzCode;
    }

    public String getGzId() {
        return gzId;
    }

    public void setGzId(String gzId) {
        this.gzId = gzId;
    }

    public String getKtime() {
        return ktime;
    }

    public void setKtime(String ktime) {
        this.ktime = ktime;
    }

    public String getJtime() {
        return jtime;
    }

    public void setJtime(String jtime) {
        this.jtime = jtime;
    }


    public String getZhiJe() {
        return zhiJe;
    }

    public void setZhiJe(String zhiJe) {
        this.zhiJe = zhiJe;
    }

    public String getZhiKl() {
        return zhiKl;
    }

    public void setZhiKl(String zhiKl) {
        this.zhiKl = zhiKl;
    }

    public String getManJe() {
        return manJe;
    }

    public void setManJe(String manJe) {
        this.manJe = manJe;
    }

    public String getJianJe() {
        return jianJe;
    }

    public void setJianJe(String jianJe) {
        this.jianJe = jianJe;
    }

    public String getManGjs() {
        return manGjs;
    }

    public void setManGjs(String manGjs) {
        this.manGjs = manGjs;
    }

    public String getXgsl() {
        return xgsl;
    }

    public void setXgsl(String xgsl) {
        this.xgsl = xgsl;
    }


    public String getMiaos() {
        return miaos;
    }

    public void setMiaos(String miaos) {
        this.miaos = miaos;
    }

    public String getSjid() {
        return sjid;
    }

    public void setSjid(String sjid) {
        this.sjid = sjid;
    }


    public String getIsmtxg() {
        return ismtxg;
    }

    public void setIsmtxg(String ismtxg) {
        this.ismtxg = ismtxg;
    }

    public String getMemtype() {
        return memtype;
    }

    public void setMemtype(String memtype) {
        this.memtype = memtype;
    }


    public String getHdsl() {
        return hdsl;
    }

    public void setHdsl(String hdsl) {
        this.hdsl = hdsl;
    }

    public String getMsjg() {
        return msjg;
    }

    public void setMsjg(String msjg) {
        this.msjg = msjg;
    }

    public List<BuyGiftBean> getBuyGifts() {
        return buyGifts;
    }

    public void setBuyGifts(List<BuyGiftBean> buyGifts) {
        this.buyGifts = buyGifts;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}