/**
*
*/
package cn.tc.ulife.platform.util.jobutil;

import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.MD5;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.time.FastDateFormat;

import java.util.Date;

/**
 * @author wy
 *
 */
public class TokenUtil {
	private static final String PRIVATE_KEY = ConfigUtil.getProperties("PRIVATE_KEY");

	private static final FastDateFormat fdf = FastDateFormat.getInstance("yyyyMMddHH");

	public static String getToken(String publicKey, String date) {

		return Hashing.md5().newHasher().putString(publicKey, Charsets.UTF_8)
				// .putString(date, Charsets.UTF_8)
				.putString(PRIVATE_KEY, Charsets.UTF_8).hash().toString();

	}

	public static String getToken(String publicKey, Date date) {
		return Hashing.md5().newHasher().putString(publicKey, Charsets.UTF_8)
				/* .putString(getDate(date), Charsets.UTF_8) */
				.putString(PRIVATE_KEY, Charsets.UTF_8).hash().toString();
	}

	public static String getToken(String publicKey) {
		return Hashing.md5().newHasher().putString(publicKey, Charsets.UTF_8)
				// .putString(getDate(), Charsets.UTF_8)
				.putString(PRIVATE_KEY, Charsets.UTF_8).hash().toString();

	}

	public static boolean validateToken(String token, String publicKey) {

		String validateValue = getToken(publicKey);
		if (validateValue.equals(token)) {
			return true;
		}

		return false;
	}

	public static String getDate() {
		Date date = new Date(System.currentTimeMillis());
		return fdf.format(date);
	}

	public static String getDate(Date now) {
		return fdf.format(now);
	}

	public static String getNextDate(Date nextDate) {

		Date date = new Date(
				nextDate.getTime() + Integer.parseInt(ConfigUtil.getProperties("TIME_OUT")) * 60 * 60 * 1000);
		return fdf.format(date);
	}

	/**
	 * 门口机登录后token 设置
	 * 
	 * @param publicKey
	 * @param date
	 *            有效期 系统时间 timestamp 秒钟 123388939
	 * @return
	 */
	public static String getEquipmentToken(String publicKey, String date) {

		StringBuffer token = new StringBuffer();
		token.append(date).append(":");
		token.append(MD5.encryption(publicKey));

		return Base64.encodeBase64String(token.toString().getBytes());

	}

	public static void main(String[] args) {
		// String token = getToken("18501400771");
//		String token = getToken("123456");
//		System.out.println(token);

		// String token = getToken("18501400771", new Date());
		// System.out.println("加密token：" + token);
		// String token1 = getToken("123456", new Date());
		// System.out.println("token1:" + token1);
		// boolean flag = validateToken("fd4c090a15c18ddbce462a0e4c4b495c",
		// "18501400771");
		// System.out.println("比对结果 :" + flag);
		
		System.out.println(getEquipmentToken("23232", System.currentTimeMillis()+""));

	}

}
