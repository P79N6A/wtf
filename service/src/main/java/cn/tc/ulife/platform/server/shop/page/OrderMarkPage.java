/**
 * @Title: OrderPage
 * @Package cn.tc.ulife.platform.server.shop.page
 * @Description: 订单促销信息page对象
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
 * @Description: 订单促销信息page对象
 * @date 2017/3/24 11:12
 */
public class OrderMarkPage {

    /**主键ID */
    private String id;
    /**订单ID */
    private String oid;
    /**促销ID */
    private String mid;
    /**优惠金额 */
    private String yhje;
    /**促销类型 */
    private String type;
    /**活动对应主体类型 */
    private String motype;
    /**活动对应主体ID */
    private String moid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getYhje() {
        return yhje;
    }

    public void setYhje(String yhje) {
        this.yhje = yhje;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMotype() {
        return motype;
    }

    public void setMotype(String motype) {
        this.motype = motype;
    }

    public String getMoid() {
        return moid;
    }

    public void setMoid(String moid) {
        this.moid = moid;
    }
}
