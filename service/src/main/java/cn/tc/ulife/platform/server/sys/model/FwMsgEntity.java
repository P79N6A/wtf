/**
 * @Title: FwMsgEntity
 * @Package cn.tc.ulife.platform.server.sys.model
 * @Description: 系统公告
 * @author cxs
 * @date 2017/2/14 14:05
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.sys.model;

import cn.tc.ulife.platform.util.UtilToString;

/**
 * @author cxs
 * @ClassName: FwMsgEntity
 * @Description: 系统公告
 * @date 2017/2/14 14:05
 */
public class FwMsgEntity {
    /**
     * 消息ID
     */
    private String id;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 消息状态
     */
    private String zt;

    /**
     * 消息类型
     */
    private String mtype;

    /**
     * 滚动速度
     */
    private String scroll;

    /**
     * 消息创建时间
     */
    private String ctime;

    /**
     * 消息创建人ID
     */
    private String cuid;

    /**
     * 消息创建人名称
     */
    private String cname;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getScroll() {
        return scroll;
    }

    public void setScroll(String scroll) {
        this.scroll = scroll;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
