/**
 * @Title: WareSortPage
 * @Package cn.tc.ulife.platform.server.ware.model.waresort
 * @Description: TODO(用一句话来说明)
 * @author cxs
 * @date 2017/2/20 13:53
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
 * @ClassName: WareSortPage
 * @Description: 商品分类view对象
 * @date 2017/2/20 13:53
 */
public class WareSortPage {

    /**
     * ID
     */
    private String id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 上级分类名称
     */
    private String pname;

    /**
     * 父ID
     */
    private String pid;

    /**
     * 序号
     */
    private String xh;

    /**
     * 创建时间
     */
    private String ctime;

    /**
     * 修改时间
     */
    private String mtime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 操作IP
     */
    private String mip;

    /**
     * 用户ID
     */
    private String uid;

    /**
     * 状态 0：删除；1：禁用；2：启用
     */
    private String zt;

    /**
     * 商品类别编号
     */
    private String code;

    /**
     * 类型,0:实体;1虚拟
     */
    private String type;

    /**
     * 是否叶子节点 0不是;1是
     */
    private String isleaf;

    private String logo;

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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMip() {
        return mip;
    }

    public void setMip(String mip) {
        this.mip = mip;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(String isleaf) {
        this.isleaf = isleaf;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
