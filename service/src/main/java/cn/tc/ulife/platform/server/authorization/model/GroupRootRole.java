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
 * Date: 2017/2/15 0015
 * </p>
 * Time: 下午 1:04
 * </p>
 * Detail:
 * </p>
 */
public class GroupRootRole {

    private  String id;

    private String roleName;

    private String roleCode;

    private String createTable;

    private String tableName;

    private  String changeShare;

    private List<ResourceFront> resouceFronts;

    public String getChangeShare() {
        return changeShare;
    }

    public void setChangeShare(String changeShare) {
        this.changeShare = changeShare;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getCreateTable() {
        return createTable;
    }

    public void setCreateTable(String createTable) {
        this.createTable = createTable;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ResourceFront> getResouceFronts() {
        return resouceFronts;
    }

    public void setResouceFronts(List<ResourceFront> resouceFronts) {
        this.resouceFronts = resouceFronts;
    }


    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
