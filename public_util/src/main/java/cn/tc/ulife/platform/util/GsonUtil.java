package cn.tc.ulife.platform.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.util
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/3/17 0017
 * </p>
 * Time: 下午 1:14
 * </p>
 * Detail:
 * </p>
 */
public class GsonUtil {


    private static Gson gson = new Gson();

//    private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;


    public static String objectToJson(Object obj) {
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static <T> T jsonToObject(String json, Class<T> c) {
        if (null == json) {
            throw new NullPointerException();
        }
        try {
            Object object = gson.fromJson(json, c);
            return Primitives.wrap(c).cast(object);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static <T> List<T> jsonToList(String json) {
        try {
            return gson.fromJson(json, new TypeToken<List<T>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static <T extends Object> List<T> jsonToList(String json, T t) {
        try {
            Type type = new TypeToken<List<T>>() {
            }.getType();
            System.out.println(type);
//            T t = (T) c.getClass().getSuperclass();
            return gson.fromJson(json, new TypeToken<List<T>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static void main(String[] args) {

    }
}
