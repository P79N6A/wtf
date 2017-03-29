package cn.tc.ulife.platform.util.SerializeUtil;

import java.io.Closeable;
import java.io.IOException;

/**
 * redis 缓存   存入对象 ,对象数组
 * 公共类
 *
 * @author wy
 */
public abstract class ObjectSerializeUtil {


    public abstract byte[] serialize(Object value);

    public abstract Object unserialize(byte[] bytes);


    public void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}
