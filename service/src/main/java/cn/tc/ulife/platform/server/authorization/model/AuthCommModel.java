package cn.tc.ulife.platform.server.authorization.model;

import cn.tc.ulife.platform.util.UtilToString;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.model
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/3/1 0001
 * </p>
 * Time: 下午 5:42
 * </p>
 * Detail:
 * </p>
 */
public class AuthCommModel {

    private String id;

    private String commName;

    private String isCheck;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);

    }
}
