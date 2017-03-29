package cn.tc.ulife.platform.api.msg;


/**
 * @author wy
 */
public class AppResponseMsg extends ResponseMsg {
    public AppResponseMsg() {

    }

    public AppResponseMsg(String resultCode, String msg, Object data) {
        super(resultCode, msg, data);
    }

    public static AppResponseMsg success(String msg, Object data) {

        return new AppResponseMsg( ReturnMsg.SUCCESSS, msg, data);
    }

    public static AppResponseMsg success(String msg) {

        return new AppResponseMsg( ReturnMsg.SUCCESSS, msg, null);
    }

    public static AppResponseMsg success(Object data) {

        return new AppResponseMsg(SUCCESSS, "成功", data);
    }

    public static AppResponseMsg success() {

        return new AppResponseMsg(SUCCESSS, "成功", null);
    }

    public static AppResponseMsg faild() {
        return new AppResponseMsg( ReturnMsg.FALID, "系统异常", null);
    }

    public static AppResponseMsg faild(String msg) {
        return new AppResponseMsg(FALID, msg, null);
    }

    public static AppResponseMsg paramIsNull() {
        return new AppResponseMsg( ReturnMsg.PARAM_IS_NULL, "参数为空", null);
    }

    public static AppResponseMsg userFaild() {
        return new AppResponseMsg(USER_INVALID, "用户信息失效,请重新登录", null);
    }
}
