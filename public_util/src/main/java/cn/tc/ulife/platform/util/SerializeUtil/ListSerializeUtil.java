package cn.tc.ulife.platform.util.SerializeUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * redis 缓存 存入list对象
 *
 * @author wy
 */
public class ListSerializeUtil<Obj extends Serializable> extends
        ObjectSerializeUtil {

    /*
     * (non-Javadoc)
     *
     * @see cn.tc.ulife.util.SerializeUtil.ObjectSerializeUtil#serialize(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    public byte[] serialize(Object value) {
        if (value == null) {
            throw new NullPointerException("value is null ");
        }
        List<Obj> list = (List<Obj>) value;
        byte[] bytes = null;
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);

            for (Obj o : list) {
                oos.writeObject(o);

            }
            bytes = baos.toByteArray();
            baos.close();
            oos.close();
        } catch (IOException e) {
            // e.printStackTrace();
        } finally {
            close(oos);
            close(baos);
        }
        return bytes;
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.tc.ulife.util.SerializeUtil.ObjectSerializeUtil#unserialize(byte[])
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Obj> unserialize(byte[] bytes) {
        List<Obj> list = new ArrayList<Obj>();
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            if (bytes != null) {

                bais = new ByteArrayInputStream(bytes);
                ois = new ObjectInputStream(bais);

                while (true) {
                    // try {
                    Obj obj = (Obj) ois.readObject();
                    // System.out.println(obj);
                    if (obj == null) {
                        break;
                    }

                    list.add(obj);

                }

                bais.close();
                ois.close();

            }

        } catch (EOFException e) {
            // eof異常, 目前未解決
            // e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            close(ois);
            close(bais);
        }
        return list;
    }

}
