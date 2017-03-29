package cn.tc.ulife.platform.server.datesouce;

/**
 * Created with springmvc.
 * </p>
 * PackageName:cn.njtc.ulife.api.aop
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/7 0007
 * </p>
 * Time: 下午 5:09
 * </p>
 * Detail:
 * </p>
 */
public class DynamicDataSourceHolder {

    private static enum DataSourceType {
        write, read;
    }

    public static final ThreadLocal<DataSourceType> holder = new ThreadLocal<DataSourceType>();


    /**
     * 标记为写数据源
     */
    public static void markWrite() {
        holder.set(DataSourceType.write);
    }

    /**
     * 标记为读数据源
     */
    public static void markRead() {
        holder.set(DataSourceType.read);
    }

    /**
     * 重置
     */
    public static void reset() {
        holder.set(null);
    }

    /**
     * 是否还未设置数据源
     *
     * @return
     */
    public static boolean isChoiceNone() {
        return null == holder.get();
    }

    /**
     * 当前是否选择了写数据源
     *
     * @return
     */
    public static boolean isChoiceWrite() {
        return DataSourceType.write == holder.get();
    }

    /**
     * 当前是否选择了读数据源
     */
    public static boolean isChoiceRead() {
        return DataSourceType.read == holder.get();
    }
}
