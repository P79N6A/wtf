package cn.tc.ulife.platform.server.exception;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.model.exception
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/1/11 0011
 * </p>
 * Time: 下午 4:26
 * </p>
 * Detail: 验证token ,不通过抛出此异常
 * </p>
 */
public class PermissionException  extends  Exception{

    public PermissionException() {
    }

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionException(Throwable cause) {
        super(cause);
    }
}
