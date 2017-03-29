package cn.tc.ulife.platform.api.componet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 */
public final class SimpleThreadLocal {
    private static final Object objecLock = new Object();

    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    private static SimpleDateFormat getSdf(final String pattern) {

        ThreadLocal<SimpleDateFormat> tsdf = sdfMap.get(pattern);
        if (tsdf == null) {
            synchronized (objecLock) {
                tsdf = sdfMap.get(pattern);
                if (tsdf == null) {

                    tsdf = new ThreadLocal<SimpleDateFormat>() {

                        @Override
                        protected SimpleDateFormat initialValue() {

                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern, tsdf);
                }
            }
        }

        return tsdf.get();
    }

    public static String format(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    public static Date parse(String dateStr, String pattern)
            throws ParseException {
        return getSdf(pattern).parse(dateStr);
    }


}
