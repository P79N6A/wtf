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
 * Time: 下午 5:55
 * </p>
 * Detail:
 * </p>
 */
public class ResourceFront {

    private String resouceId;

    private String resouceGroupId;

    private String resouceName;

    private String resouceRoleCode;

    private String resouceSort;

    private String resouceIssued;

    private String resouceIsleaf;

    private String resouceUrl;

    private String resoucePid;

    private String resouceCheck;

    private List<SysRoot> sysRoots;

    public String getResouceCheck() {
        return resouceCheck;
    }

    public void setResouceCheck(String resouceCheck) {
        this.resouceCheck = resouceCheck;
    }

    public String getResoucePid() {
        return resoucePid;
    }

    public void setResoucePid(String resoucePid) {
        this.resoucePid = resoucePid;
    }

    public String getResouceUrl() {
        return resouceUrl;
    }

    public void setResouceUrl(String resouceUrl) {
        this.resouceUrl = resouceUrl;
    }

    public String getResouceIsleaf() {
        return resouceIsleaf;
    }

    public void setResouceIsleaf(String resouceIsleaf) {
        this.resouceIsleaf = resouceIsleaf;
    }

    public List<SysRoot> getSysRoots() {
        return sysRoots;
    }

    public void setSysRoots(List<SysRoot> sysRoots) {
        this.sysRoots = sysRoots;
    }

    public String getResouceId() {
        return resouceId;
    }

    public void setResouceId(String resouceId) {
        this.resouceId = resouceId;
    }

    public String getResouceGroupId() {
        return resouceGroupId;
    }

    public void setResouceGroupId(String resouceGroupId) {
        this.resouceGroupId = resouceGroupId;
    }

    public String getResouceName() {
        return resouceName;
    }

    public void setResouceName(String resouceName) {
        this.resouceName = resouceName;
    }

    public String getResouceRoleCode() {
        return resouceRoleCode;
    }

    public void setResouceRoleCode(String resouceRoleCode) {
        this.resouceRoleCode = resouceRoleCode;
    }

    public String getResouceSort() {
        return resouceSort;
    }

    public void setResouceSort(String resouceSort) {
        this.resouceSort = resouceSort;
    }

    public String getResouceIssued() {
        return resouceIssued;
    }

    public void setResouceIssued(String resouceIssued) {
        this.resouceIssued = resouceIssued;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }


}
