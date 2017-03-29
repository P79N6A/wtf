/**
 * @Title: WarePicture
 * @Package cn.tc.ulife.platform.server.ware.model
 * @Description: 业务图片信息实体类
 * @author alliswell008
 * @date 2017/2/23 14:52
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
 * @author alliswell008
 * @ClassName: WarePicture
 * @Description: 业务图片信息实体类
 * @date 2017/2/23 14:52
 */
public class PictureEntity {

    /**
     * 主键
     */
    private String id;

    /**
     * 类型
     */
    private String type;

    /**
     * 操作人ID
     */
    private String uid;

    /**
     * 文件路径
     */
    private String url;

    /**
     * 所属主键
     */
    private String tid;

    /**
     * 所属表
     */
    private String tname;

    /**
     * 创建时间
     */
    private String ctime;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getTid()
    {
        return tid;
    }

    public void setTid(String tid)
    {
        this.tid = tid;
    }

    public String getTname()
    {
        return tname;
    }

    public void setTname(String tname)
    {
        this.tname = tname;
    }

    public String getCtime()
    {
        return ctime;
    }

    public void setCtime(String ctime)
    {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
