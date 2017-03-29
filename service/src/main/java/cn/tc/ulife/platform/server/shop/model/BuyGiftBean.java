/**
 * @Title: BuyGiftBean
 * @Package cn.tc.ulife.platform.server.shop.model
 * @Description: 买赠活动赠品对象
 * @author alliswell008
 * @date 2016/12/20 17:53
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.model;

/**
 * @author alliswell008
 * @ClassName: BuyGiftBean
 * @Description: 买赠活动赠品对象
 * @date 2016/12/20 17:53
 */
public class BuyGiftBean {
    /** 买赠活动id*/
    private String id;

    /** 买赠活动明细id*/
    private String cxId;

    /** 赠品类型，1赠商品，2赠优惠券*/
    private String zpType;

    /** 赠品数量*/
    private String zpCount;

    /** 赠品id，所赠商品id/所赠优惠券id*/
    private String zpId;

    /** 所赠商品名称*/
    private String zpName;

    /** 所赠商品logo*/
    private String zpLogo;

    /** 所赠商品规格id*/
    private String zpGgid;

    /** 所赠商品规格数值*/
    private String zpGgsz;

    /** 所赠商品规格单位*/
    private String zpGgdw;

    /** 所赠商品规格备注*/
    private String zpGgbz;

    /** 所赠商品规格售价*/
    private String zpSprice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCxId() {
        return cxId;
    }

    public void setCxId(String cxId) {
        this.cxId = cxId;
    }

    public String getZpId() {
        return zpId;
    }

    public void setZpId(String zpId) {
        this.zpId = zpId;
    }

    public String getZpName() {
        return zpName;
    }

    public void setZpName(String zpName) {
        this.zpName = zpName;
    }

    public String getZpLogo() {
        return zpLogo;
    }

    public void setZpLogo(String zpLogo) {
        this.zpLogo = zpLogo;
    }

    public String getZpType() {
        return zpType;
    }

    public void setZpType(String zpType) {
        this.zpType = zpType;
    }

    public String getZpCount() {
        return zpCount;
    }

    public void setZpCount(String zpCount) {
        this.zpCount = zpCount;
    }

    public String getZpGgid() {
        return zpGgid;
    }

    public void setZpGgid(String zpGgid) {
        this.zpGgid = zpGgid;
    }

    public String getZpGgsz() {
        return zpGgsz;
    }

    public void setZpGgsz(String zpGgsz) {
        this.zpGgsz = zpGgsz;
    }

    public String getZpGgdw() {
        return zpGgdw;
    }

    public void setZpGgdw(String zpGgdw) {
        this.zpGgdw = zpGgdw;
    }

    public String getZpGgbz() {
        return zpGgbz;
    }

    public void setZpGgbz(String zpGgbz) {
        this.zpGgbz = zpGgbz;
    }

    public String getZpSprice() {
        return zpSprice;
    }

    public void setZpSprice(String zpSprice) {
        this.zpSprice = zpSprice;
    }
}
