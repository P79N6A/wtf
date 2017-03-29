package cn.tc.ulife.platform.server.authorization.model;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.model
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/14 0014
 * </p>
 * Time: 上午 9:34
 * </p>
 * Detail:
 * </p>
 */
public class ButtonFront {

    private String id;

    /**
     * 资源菜单表id
     */
    private String rid;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 操作id
     */
    private String cid;

    /**
     * 按钮id
     */
    private String aid;

    /**
     * 1：新增 2：删除
     */
    private String type;

    private String rcode;

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
