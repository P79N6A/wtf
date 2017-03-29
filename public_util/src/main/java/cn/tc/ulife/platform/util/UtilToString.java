package cn.tc.ulife.platform.util;
import cn.tc.ulife.platform.util.localthread.SimpleThreadLocal;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 工具类
 *
 * @author wy
 */
public final class UtilToString {


//    private static Logger logger = LogManager.getLogManager().getRunLog();

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    private static String strBase = "ABCDEFGHIJKOMNOPQRSTUVWXYZ123456789";

    private static Calendar calendar = Calendar.getInstance();

    /**
     * 重写toString 方法 (实体类,应优先使用此方法)
     *
     * @param object
     * @return
     */
    public static String getString(Object object) {
        try {
            if (null == object) {
                return null;
            } else {
                // 获取此类所有声明的字段
                Field[] field = object.getClass().getDeclaredFields();

                // 用来拼接所需保存的字符串
                StringBuffer sb = new StringBuffer();

                // 循环此字段数组，获取属性的值
                for (int i = 0; i < field.length && field.length > 0; i++) {

                    field[i].setAccessible(true);


                    if (i == field.length - 1) {
                        sb.append(field[i].getName() + ": "
                                + field[i].get(object) + ".");

                    } else {
                        sb.append(field[i].getName() + ": "
                                + field[i].get(object) + ", ");
                    }
                }
                return sb.toString();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 生成微信需要签名的字符串(优先使用此类)
     *
     * @param object
     * @return
     */
    public static String getXmlstr(Object object) {
        try {
            if (null == object) {
                return null;
            } else {
                // 获取此类所有声明的字段
                Field[] field = object.getClass().getDeclaredFields();

                // 用来拼接所需保存的字符串
                StringBuffer sb = new StringBuffer();

                // 循环此字段数组，获取属性的值
                for (int i = 0; i < field.length && field.length > 0; i++) {

                    field[i].setAccessible(true);

                    if (i == field.length - 1 || i == field.length - 2) {
                        if (null != field[i].get(object)) {
                            sb.append(field[i].getName() + "="
                                    + field[i].get(object));
                        }
                    } else {
                        if (null != field[i].get(object)) {
                            if ("packageValue".equals(field[i].getName())) {
                                sb.append("package" + "="
                                        + field[i].get(object) + "&");

                            } else {
                                sb.append(field[i].getName() + "="
                                        + field[i].get(object) + "&");
                            }
                        }
                    }
                }
                return sb.toString().replace("\\n", "");
            }
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 发送给微信服务器的xml格式的字符串
     *
     * @param object
     * @return
     */
    public static String getXml(Object object) {
        try {
            if (null == object) {
                return null;
            } else {
                // 获取此类所有声明的字段
                Field[] field = object.getClass().getDeclaredFields();

                // 用来拼接所需保存的字符串
                StringBuffer sb = new StringBuffer();
                sb.append("<xml>");
                // 循环此字段数组，获取属性的值
                for (int i = 0; i < field.length && field.length > 0; i++) {

                    field[i].setAccessible(true);


                    if (null != field[i].get(object)) {
                        sb.append("<" + field[i].getName() + ">"
                                + "<![CDATA[" + field[i].get(object) + "]]>" + "</" + field[i].getName() + ">");

                    }

                }
                sb.append("</xml>");
                return sb.toString();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成云家政请求的字符串(优先使用此类)
     *
     * @param object
     * @return
     */
    public static String getYumParams(Object object) {
        try {
            if (null == object) {
                return null;
            } else {
                // 获取此类所有声明的字段
                Field[] field = object.getClass().getDeclaredFields();

                Field[] supField = object.getClass().getSuperclass().getDeclaredFields();

                // 用来拼接所需保存的字符串
                StringBuffer sb = new StringBuffer();

                for (int i = 0; i < supField.length; i++) {
                    supField[i].setAccessible(true);
                    if (null != supField[i].get(object)) {
                        sb.append(supField[i].getName() + "="
                                + supField[i].get(object) + "&");
                    }
                }

                // 循环此字段数组，获取属性的值
                for (int i = 0; i < field.length && field.length > 0; i++) {
                    field[i].setAccessible(true);
                    if (null != field[i].get(object)) {


                        sb.append(field[i].getName() + "="
                                + field[i].get(object) + "&");

                    }

                }

                return sb.toString().replace("\\n", "");
            }
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成云家政需要签名(优先使用此类)
     *
     * @param object
     * @return
     */
    public static String getYumSign(Object object) {
        try {
            if (null == object) {
                return null;
            } else {
                // 获取此类所有声明的字段
                Field[] field = object.getClass().getDeclaredFields();
                Field[] supField = object.getClass().getSuperclass().getDeclaredFields();
                // 用来拼接所需保存的字符串
                StringBuffer sb = new StringBuffer();
                TreeMap<String, String> treeMap = new TreeMap<String, String>();
                // 循环此字段数组，获取属性的值
                for (int i = 0; i < field.length && field.length > 0; i++) {

                    field[i].setAccessible(true);


                    if (null != field[i].get(object)) {
                        treeMap.put(field[i].getName(), (String) field[i].get(object));
                    }

                }
                for (int i = 0; i < supField.length; i++) {
                    supField[i].setAccessible(true);
                    if (null != supField[i].get(object)) {
                        treeMap.put(supField[i].getName(), (String) supField[i].get(object));
                    }
                }
                Iterator iterator = treeMap.entrySet().iterator();
                while (iterator.hasNext()) {

                    Map.Entry entry = (Map.Entry) iterator.next();
                    String key = (String) entry.getKey();
                    String value = (String) entry.getValue();
                    sb.append(key).append(value);
                }
                return sb.toString().replace("\\n", "");
            }
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 解析request请求参数,生成实体对象
     *
     * @param map
     * @return null or 有属性对象 (null可能请求无参数或者无对应实体对象,)
     */
    public static Object mapToBean(Map map, Class c) {
        Object object = null;
        try {
            if (map != null && map.size() > 0) {
                object = c.newInstance();
                Field[] fields = c.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    if (map.containsKey(fields[i])) {
                        fields[i].set(object, ((String[]) (map.get(fields[i])))[0]);
                    }

                }
            }

        } catch (InstantiationException e) {
            //开发环境便于观察异常.现网应该注释

            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {

            e.printStackTrace();
            return null;
        }


        return object;
    }


    /**
     * 采用第三方jar 方法   map转成对象
     *
     * @return
     */
    public static Object mapTobean(Map map, Object o) {
        try {
            BeanUtils.populate(o, map);

        } catch (Exception e) {
            e.printStackTrace();
//            logger.error("mapTobean,转换失败:", e);
            return o;
        }


        return o;
    }

    public static String getOrderNum() {
        String date = sdf.format(new Date());
        String random = getRandomString(6);

        String sb = date + random;
        return sb;
    }

    public static String getOrderNum(final String code) {
        String date = sdf.format(new Date());
        String random = getRandomString(6);

        String sb = code + date + random;
        return sb;
    }

    public static String getBusinessNum(String str) {
        String date = sdf.format(new Date());
        String random = getRandomString(6);

        String sb = str + date + random;
        return sb;
    }


    /**
     * 订单随机字符串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) { // length表示生成字符串的长度

        String numBase = "0123456789";

        Random random = new Random();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(numBase.length());
            sb.append(numBase.charAt(number));
        }
        return sb.toString();
    }


    /**
     * 生成微信支付随机字符串
     *
     * @return
     */
    public static String getRandomString() {

        Random random = new Random();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 24; i++) {
            int number = random.nextInt(strBase.length());
            sb.append(strBase.charAt(number));
        }
        return sb.toString();
    }


    /**
     * 生成验证码
     *
     * @return
     */
    public static int getSms() {
        Random r = new Random();
        int sms;
        do {
            sms = r.nextInt(10000);
        }
        while (sms < 1000);
        return sms;

    }


    public static String getCron(String dateTime) {

        String cron = null;
        try {

            calendar.setTime(SimpleThreadLocal.parse(dateTime, "yyyy-MM-dd HH:mm:ss"));

            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);

            cron = sec + " " + minute + " " + hour + " " + day + " " + " " + month + " ? *";

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cron;
    }

    /**
     * 获取表达式
     *
     * @param dateTime type is [String]
     * @param hourMid  时间间隔
     * @return
     */
    public static String getCron(String dateTime, int hourMid) {

        String cron = null;
        try {
            calendar.setTime(SimpleThreadLocal.parse(dateTime, "yyyy-MM-dd HH:mm:ss"));

            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);

            cron = sec + " " + minute + " " + hour + hourMid + " " + day + " " + " " + month + " ? *";

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cron;

    }

    /**
     * 获取时间表达式
     *
     * @param dateTime type is  [Date]
     * @param hourMid  小时单位
     * @return
     */
    public static String getCron(Date dateTime, int hourMid) {

        String cron = null;
        try {
            calendar.setTime(SimpleThreadLocal.parse(SimpleThreadLocal.format(dateTime, "yyyy-MM-dd HH:mm:ss"),
                    "yyyy-MM-dd HH:mm:ss"));

            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            int realHour = hour + hourMid;
            if (realHour >= 24) {
                if (day + 1 > calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                    day = 1;
                    month = month + 1;
                } else {
                    day = day + 1;
                }
                realHour = realHour - 24;
            }

            cron = sec + " " + minute + " " + realHour + " " + day + " " + " " + month + " ? *";

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cron;

    }


    public static String getCronByMinute(Date date, int minMid) {

        Calendar calendar = Calendar.getInstance();
        String cron = null;
        try {
//            Date str = SimpleThreadLocal.parse(SimpleThreadLocal.format(), "yyyy-MM-dd HH:mm:ss");
            calendar.setTime(SimpleThreadLocal.parse(SimpleThreadLocal.format(date, "yyyy-MM-dd HH:mm:ss"),
                    "yyyy-MM-dd HH:mm:ss"));

            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);

            int realMin = minute + minMid;
            int maxMin = calendar.getActualMaximum(Calendar.MINUTE);

            int maxHour = calendar.getActualMaximum(Calendar.HOUR_OF_DAY);

            int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            int maxMonth = calendar.getActualMaximum(Calendar.MONTH);

            if (realMin > maxMin) {
                realMin = realMin - maxMin - 1;
                System.out.println(calendar.getActualMaximum(Calendar.MINUTE));
                System.out.println(realMin);
                hour = hour + 1;
                if (hour > maxHour) {
                    day = day + 1;
                    hour = hour - maxHour - 1;
                    if (day > maxDay) {
                        month = month + 1;
                        day = day - maxDay;
                        if (month > maxMonth) {

                            month = month - maxMonth - 1;
                        }
                    }


                }

            }

            cron = sec + " " + realMin
                    + " " + hour + " " + day + " " + " " + month + " ? *";
            System.out.println(cron);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cron;
    }

    /**
     * 获取所在日期的零点时间
     *
     * @param date 所在日期
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getNowDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return SimpleThreadLocal.format(cal.getTime(), "yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 生成拼团标识
     * 生成规则:用户id+活动id -->md5 +leng 位随机验证码
     *
     * @param length
     * @param uid
     * @param gid
     * @return
     */
    public static String getGroupMark(int length, String uid, String gid) {

        Random random = new Random();

        StringBuffer sb = new StringBuffer();
        sb.append(MD5.cell32(uid + gid).substring(0, 10));
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(strBase.length());
            sb.append(strBase.charAt(number));
        }
        return sb.toString();
    }


    /**
     * 检测配送日期是否符合截单设置
     */
    public static String checkDate(String date, int checkMaxDate, int checkMinDate) {

        try {
            Calendar nowDate = Calendar.getInstance();

            nowDate.setTime(new Date());
//            nowDate.setTime(SimpleThreadLocal.parse("2016-07-07 16:58:21", "yyyy-MM-dd HH:mm:ss"));

            int nowHour = nowDate.get(Calendar.HOUR_OF_DAY);
//            int minute = nowDate.get(Calendar.MINUTE);
            int nowDay = nowDate.get(Calendar.DAY_OF_YEAR);

            int allMin = nowHour * 100;
            if (checkMinDate >= allMin) {
                Calendar psDate = Calendar.getInstance();
                psDate.setTime(SimpleThreadLocal.parse(date, "yy-MM-dd"));
                int psDay = psDate.get(Calendar.DAY_OF_YEAR);
                if (psDay - nowDay >= 1) {

                    return date;
                } else {

                    Calendar updDate = Calendar.getInstance();
                    updDate.set(nowDate.get(Calendar.YEAR), nowDate.get(Calendar.MONTH), nowDate.get(Calendar.DAY_OF_MONTH) + 1);
                    return SimpleThreadLocal.format(updDate.getTime(), "yyyy-MM-dd");
                }

            } else if (allMin >= checkMaxDate) {
                Calendar psDate = Calendar.getInstance();
                psDate.setTime(SimpleThreadLocal.parse(date, "yy-MM-dd"));
                int psDay = psDate.get(Calendar.DAY_OF_YEAR);
                if (psDay - nowDay >= 2) {

                    return date;
                } else {

                    Calendar updDate = Calendar.getInstance();
                    updDate.set(nowDate.get(Calendar.YEAR), nowDate.get(Calendar.MONTH), nowDate.get(Calendar.DAY_OF_MONTH) + 2);
                    return SimpleThreadLocal.format(updDate.getTime(), "yyyy-MM-dd");
                }
            } else {
                return date;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }

    }


    /**
     * 获取当前时间后的间隔时间 =======》拼团获取失效时间
     *
     * @param amount
     * @return
     */
    public static String getDate(String amount) {

        Calendar date = Calendar.getInstance();

        System.out.println(SimpleThreadLocal.format(date.getTime(), "yyyyMMddHHmmssSSS"));

        date.add(Calendar.HOUR_OF_DAY, 11);
        System.out.println(SimpleThreadLocal.format(date.getTime(), "yyyyMMddHHmmssSSS"));
//        calendar.se
        return null;
    }


    private static HashMap<Integer, String> map = new HashMap<Integer, String>(2, 0.75f);

    public static void main(String[] args) {

//        System.out.println(".." + getRandomString());
//        System.out.println(getCron("2016-12-1 18:13:21"));
        System.out.println(UtilToString.getNowDate(new Date()));


        System.out.println(UtilToString.getOrderNum());

        System.out.println("20161125163834495796622".length());
        System.out.println("20161219170527552464744".length());
//        getDate("2");
//        System.out.println(UtilToString.checkDate("2016-07-12", 17 * 100 + 59 * 1, 9 * 100));
//        System.out.println(1 << 30);

//        try {
//            ObjectInputStream ob = new ObjectInputStream(new ByteArrayInputStream("".getBytes()));
//
//            ob.readUTF();
//            Class c= Class.forName("UtilToString");
//            Method method= c.getMethod("getSms",c);
//            method.invoke("","");
////            c.get
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
