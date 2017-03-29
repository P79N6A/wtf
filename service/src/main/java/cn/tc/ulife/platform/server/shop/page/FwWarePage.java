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
public class FwWarePage extends WarePage {

    private String fwdj;

    private String wyjbl;

    public String getWyjbl() {
        return wyjbl;
    }

    public void setWyjbl(String wyjbl) {
        this.wyjbl = wyjbl;
    }

    public String getFwdj() {
        return fwdj;
    }

    public void setFwdj(String fwdj) {
        this.fwdj = fwdj;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
