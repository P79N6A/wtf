/**
 * @Title: AppSignedEntity
 * @Package cn.tc.ulife.platform.server.integral.model
 * @Description: 积分签到规则
 * @author cxs
 * @date 2017/2/14 11:25
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
 * @ClassName: AppSignedEntity
 * @Description: 积分规则
 * @date 2017/2/14 11:25
 */
public class AppSignedEntity {
    /** 主键ID*/
    private String id;

    /** 规则名称*/
    private String name;

    /** 连续签到天数*/
    private String DayNum;

    /** 连续签到天数对应的签到积分*/
    private String integral;

    /** 创建时间*/
    private String ctime;

    /** 修改时间*/
    private String mtime;

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

    public String getDayNum() {
        return DayNum;
    }

    public void setDayNum(String dayNum) {
        DayNum = dayNum;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
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

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
