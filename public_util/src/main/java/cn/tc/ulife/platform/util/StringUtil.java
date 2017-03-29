package cn.tc.ulife.platform.util;
import java.util.Random;

/**
 * 工具类
 * 
 * @author lpf
 * 
 */
public final class StringUtil
{
	public static boolean isEmpty(String str)
	{
		if (null == str || "".equals(str.trim())) { return true; }
		return false;
	}

	public static int getSms()
	{
		Random r = new Random();
		int sms;
		do
		{
			sms = r.nextInt(10000);
		}
		while (sms < 1000);
		return sms;

	}

    /**
     * 判断字符串是否是正整数，是 返回 转型整数 ，否返回-1
     *
     * @param str
     * @return
     */
    public static Integer strToInt(String str) {
        if (isEmpty(str)) {
            return -1;
        }
        try {
            Integer i = Integer.parseInt(str);
            return i;
        } catch (NumberFormatException e) {
            return -1;

        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(getSms());
        }
    }
}
