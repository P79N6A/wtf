package cn.tc.ulife.platform.server.shop.model;

import cn.tc.ulife.platform.util.StringUtil;
import cn.tc.ulife.platform.util.UtilToString;

public class RechareDTO {

    /**
     * 话费充值产品id
     */
    protected String prodContent;
    /**
     * 产品面额
     */
    protected String prodPrice;
    /**
     * 产品支付价格
     */
    protected String prodIsptype;
    /**
     * 运营商类别
     */
    protected String prodDelaytimes;
    /**
     * 充值处理时间
     */
    protected String prodProvinceid;
    /**
     * 省份名称
     */
    protected String prodType;
    /**
     * 产品类型
     */
    protected String prodId;

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdContent() {
        return prodContent;
    }

    public void setProdContent(String prodContent) {
        this.prodContent = prodContent;
    }

    public String getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(String prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdIsptype() {
        return prodIsptype;
    }

    public void setProdIsptype(String prodIsptype) {
        this.prodIsptype = prodIsptype;
    }

    public String getProdDelaytimes() {
        return prodDelaytimes;
    }

    public void setProdDelaytimes(String prodDelaytimes) {
        this.prodDelaytimes = prodDelaytimes;
    }

    public String getProdProvinceid() {
        return prodProvinceid;
    }

    public void setProdProvinceid(String prodProvinceid) {
        this.prodProvinceid = prodProvinceid;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
