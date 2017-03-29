package cn.tc.ulife.platform.server.authorization.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.tc.ulife.platform.server.comm.model.CommunityBean;
import cn.tc.ulife.platform.server.utils.model.BaseBean;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.model
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/16 0016
 * </p>
 * Time: 下午 2:12
 * </p>
 * Detail: 商家,物业,小站等虚拟对象
 * </p>
 */
public class EntityModel extends BaseBean{

    private String id;

    private String name;

    private String address;

    private String phone;

    private String rcode;

    /**
     * 实体责任人,下属账号权限不得高或多于责任人权限
     */
    private String responsible;

    private String tableName;

    /**
     *
     */
    private String comId;

    @JsonIgnore
    private List<String> comIds;

    private String cid;

    private List<CommunityBean> communityBeans;

    public List<CommunityBean> getCommunityBeans() {
        return communityBeans;
    }

    public void setCommunityBeans(List<CommunityBean> communityBeans) {
        this.communityBeans = communityBeans;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public List<String> getComIds() {
        return comIds;
    }

    public void setComIds(List<String> comIds) {
        this.comIds = comIds;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }
}
