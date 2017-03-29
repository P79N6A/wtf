package org.smart.door;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import cn.tc.ulife.platform.msg.http.util.HttpUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	public static void main(String[] args) {
		a();
	}

	public static void a() {

		String host = "http://sms.market.alicloudapi.com";
		String path = "/singleSendSms";
		String method = "GET";
		Map<String, String> headers = new HashMap<String, String>();
		// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
		// 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE 2852ec0118cd40f39e27e295fbc113a2");
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("ParamString", "{\"code\":\"123456\"}");
		querys.put("RecNum", "15895879252");
		querys.put("SignName", "U家社区");
		querys.put("TemplateCode", "SMS_57655013");

		try {
			/**
			 * 重要提示如下: HttpUtils请从
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
			 * 下载
			 *
			 * 相应的依赖请参照
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
			 */
			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
//			System.out.println(response.toString());
			// 获取response的body
			 System.out.println(EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main1(String[] args) {
		System.out.println(1l);
		System.out.println(1l << 65l);
	}
}
