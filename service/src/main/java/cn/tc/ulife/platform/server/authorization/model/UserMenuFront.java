package cn.tc.ulife.platform.server.authorization.model;

import cn.tc.ulife.platform.util.UtilToString;

import java.util.List;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.model
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/14 0014
 * </p>
 * Time: 上午 9:30
 * </p>
 * Detail:
 * </p>
 */
public class UserMenuFront {

    private String id;

    /**
     * 编码
     */
    private String rcode;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 资源id
     */
    private String rid;

    /**
     * 操作者id
     */
    private String cid;

    /**
     * 1：新增 2：删除
     */
    private String type;


    private List<ButtonFront> buttonFronts;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }




    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public List<ButtonFront> getButtonFronts() {
        return buttonFronts;
    }

    public void setButtonFronts(List<ButtonFront> buttonFronts) {
        this.buttonFronts = buttonFronts;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}

