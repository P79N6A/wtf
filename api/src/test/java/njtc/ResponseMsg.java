/**
 *
 */
package njtc;


import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.UtilToString;


public   class ResponseMsg   {
    /**
     * 结果代码，0、1等
     */
    private String resultCode;

    /**
     * 页数,表示第几页页
     */
    private String pageIndex;

    /**
     * 注册成功
     */
    private String msg;

    /**
     * {数据}
     */
    private Object data;


    private String token;


    private String idnName;

    public ResponseMsg() {

    }

    public ResponseMsg(String resultCode, String msg, Object data) {
        this.resultCode = resultCode;
        this.msg = msg;
        this.data = data;
    }


//

    public String getIdnName() {
        return ConfigUtil.getProperties("DOMAIN");
    }

    public void setIdnName(String idnName) {
        this.idnName = idnName;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the resultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * @param resultCode the resultCode to set
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * @return the pageIndex
     */
    public String getPageIndex() {
        return pageIndex;
    }

    /**
     * @param pageIndex the pageIndex to set
     */
    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }


    //	public
    /*
     * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
        return UtilToString.getString(this);
    }

}
