package cn.tc.ulife.platform.util.SerializeUtil;

import java.io.*;

/**
 * 为了实现存放缓存对象
 *
 * @author wy
 */
public class SerializeUtil<Obj extends Serializable> extends
        ObjectSerializeUtil {

    /**
     * redis 缓存对象序列化
     *
     * @param object
     * @return
     */
    @SuppressWarnings("unchecked")
    public byte[] serialize(Object object) {

        if (object == null) {
            throw new NullPointerException("object is null  ");
        }
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        byte[] bytes = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            Obj obj = (Obj) object;
            oos.writeObject(obj);
            bytes = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(oos);
            close(baos);

        }
        return bytes;
    }

    @SuppressWarnings("unchecked")
    public Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        Obj o = null;

        try {

            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            o = (Obj) ois.readObject();
            bais.close();
            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(ois);
            close(bais);
        }
        return o;
    }


}
