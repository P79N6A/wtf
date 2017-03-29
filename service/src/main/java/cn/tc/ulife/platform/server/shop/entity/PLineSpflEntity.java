/**
 * @Title: PLineSpflPage
 * @Package cn.tc.ulife.platform.server.ware.model
 * @Description: 产品线与商品分类关联表实体对象
 * @author cxs
 * @date 2017/2/21 13:36
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
 * @author cxs
 * @ClassName: PLineSpflPage
 * @Description: 产品线与商品分类关联表实体对象
 * @date 2017/2/21 13:36
 */
public class PLineSpflEntity {

    private String id;

    private String flid;

    private String plid;

    private String ctime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlid() {
        return flid;
    }

    public void setFlid(String flid) {
        this.flid = flid;
    }

    public String getPlid() {
        return plid;
    }

    public void setPlid(String plid) {
        this.plid = plid;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
