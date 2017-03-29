package cn.tc.ulife.platform.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author wy
 */
public class ExceptionUtil {
	private static Resource resource = new ClassPathResource(
			"/conf/exception.properties");

	private static Properties props = null;

	public static String getProperties(String key) {
		if (null == props) {
			try {

				props = PropertiesLoaderUtils.loadProperties(resource);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return props.getProperty(key);

	}

	public static int combie(int pm1, int pm2) {
		if (pm1 > 0 && pm2 > 0) {
			float pmv = Math.abs(pm1 - pm2);
			float pmmin = (pm1 > pm2 ? pm2 : pm1);
			if (pmv / pmmin >= 0.5) {
				return (pm1 > pm2 ? pm1 : pm2);
			} else {
				return (int) ((pm1 + pm2) / 2 + 0.5);
			}
		} else {
			return (pm1 + pm2);
		}
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		return (null == str || "".equals(str.trim())) ? true : false;
	}

}
