package cn.tc.ulife.platform.door.mode;

import cn.tc.ulife.platform.util.UtilToString;
import cn.tc.ulife.platform.validators.Must;

import java.io.Serializable;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */

/**
 * 用户必须有房间， 才能绑定门禁卡 Persistence Object
 * 用户必须有房间， 才能绑定门禁卡
 *
 * @author taichuan Platform Group
 * @create 2017-03-13
 */
public class DoorCardPage extends DoorCardEntity {
    /**
     * 小区ID
     */
    @Must
    protected String commId;

    /**
     * 结构列表 用于存放门口机关系的结构 包括小区ID
     */
    @Must
    protected String ids;

    /**
     * 当前页数
     */
    protected String pageNum;

    /**
     * 每页条数
     */
    protected String pageSize;


    public String getCommId() {
        return commId;
    }

    public void setCommId(String commId) {
        this.commId = commId;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}