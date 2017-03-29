/**
 * @Title: ware
 * @Package cn.tc.ulife.platform.server.ware.model
 * @Description: TODO(用一句话来说明)
 * @author cxs
 * @date 2017/2/20 14:14
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
 * @ClassName: ware
 * @Description: TODO(用一句话来说明)
 * @date 2017/2/20 14:14
 */
public class DeliveryWarePage extends WarePage {

    private String psgz;

    private String sprice;

    private String pszq;

    private String pszqdw;

    public String getPsgz() {
        return psgz;
    }

    public void setPsgz(String psgz) {
        this.psgz = psgz;
    }

    public String getSprice() {
        return sprice;
    }

    public void setSprice(String sprice) {
        this.sprice = sprice;
    }

    public String getPszq() {
        return pszq;
    }

    public void setPszq(String pszq) {
        this.pszq = pszq;
    }

    public String getPszqdw() {
        return pszqdw;
    }

    public void setPszqdw(String pszqdw) {
        this.pszqdw = pszqdw;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
