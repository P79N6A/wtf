/**
 * @Title: RechargePage
 * @Package cn.tc.ulife.platform.server.shop.model
 * @Description: 充值商品view对象
 * @author alliswell
 * @date 2017/2/27 17:18
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.tc.ulife.platform.server.shop.page;

import cn.tc.ulife.platform.util.UtilToString;

/**
 * @author alliswell
 * @Title: RechargePage
 * @Package cn.tc.ulife.platform.server.shop.model
 * @Description: 充值商品view对象
 * @date 2017/2/27 17:18
 */
public class RechargePage {

    private String id;

    private String prodid;

    private String recsprice;

    private String dlsprice;

    private String floatvalue;

    private String sprice;

    private String prodisptype;

    private String proddelaytimes;

    private String prodprovinceid;

    private String prodtype;

    private String ctime;

    private String mtime;

    private String cid;

    private String zt;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    public String getRecsprice() {
        return recsprice;
    }

    public void setRecsprice(String recsprice) {
        this.recsprice = recsprice;
    }

    public String getDlsprice() {
        return dlsprice;
    }

    public void setDlsprice(String dlsprice) {
        this.dlsprice = dlsprice;
    }

    public String getFloatvalue() {
        return floatvalue;
    }

    public void setFloatvalue(String floatvalue) {
        this.floatvalue = floatvalue;
    }

    public String getSprice() {
        return sprice;
    }

    public void setSprice(String sprice) {
        this.sprice = sprice;
    }

    public String getProdisptype() {
        return prodisptype;
    }

    public void setProdisptype(String prodisptype) {
        this.prodisptype = prodisptype;
    }

    public String getProddelaytimes() {
        return proddelaytimes;
    }

    public void setProddelaytimes(String proddelaytimes) {
        this.proddelaytimes = proddelaytimes;
    }

    public String getProdprovinceid() {
        return prodprovinceid;
    }

    public void setProdprovinceid(String prodprovinceid) {
        this.prodprovinceid = prodprovinceid;
    }

    public String getProdtype() {
        return prodtype;
    }

    public void setProdtype(String prodtype) {
        this.prodtype = prodtype;
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

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
