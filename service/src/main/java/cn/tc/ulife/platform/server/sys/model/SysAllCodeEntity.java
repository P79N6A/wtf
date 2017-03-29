/**
 * @Title: SysAllCode
 * @Package cn.tc.ulife.platform.server.sys.model
 * @Description: 系统公共代码表
 * @author alliswell
 * @date 2017/2/28 16:59
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.tc.ulife.platform.server.sys.model;

/**
 * @author alliswell
 * @Title: SysAllCode
 * @Package cn.tc.ulife.platform.server.sys.model
 * @Description: 系统公共代码表
 * @date 2017/2/28 16:59
 */
public class SysAllCodeEntity {

    /** 主键ID*/
    private String id     ;
    /** 代码编码 */
    private String codeCode;
    /** 代码名称 */
    private String codeName;
    /** 代码类型 */
    private String codeType;
    /** 代码值 */
    private String codeValue;
    /** 代码描述 */
    private String codeDesc;
    /** 代码状态 */
    private String validStatus;
    /** 创建时间 */
    private String ctime;
    /** 修改时间 */
    private String mtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeCode() {
        return codeCode;
    }

    public void setCodeCode(String codeCode) {
        this.codeCode = codeCode;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
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
}
