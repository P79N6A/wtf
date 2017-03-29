package cn.tc.ulife.platform.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import cn.tc.ulife.platform.util.constance.Constance;
import cn.tc.ulife.platform.util.logger.LogManager;

/**
 * Created by wy on 2015/10/30 0030.
 */
public class HttpUtil {

	private static final String connectionTime = "3000";
	private static final String sockTimeout = "5000";

	private static Logger logger = LogManager.getLogManager().getRunLog();

	private static final String APPLICATION_JSON  = "application/json";
	
	private static final String CONTENT_TYPE_TEXT_JSON  = "text/json";
	
	private static final String HEARD_AUTHORIZATION = "Authorization";
	
	/**
	 * @param url
	 *            url
	 * @param map
	 *            map对象，参数 ：参数值
	 * @return
	 * @throws java.io.IOException
	 */
	public static String sendHttpPost(String url, Map<String, String> map) throws IOException {

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();

		if (null != map && !map.isEmpty()) {
			for (Map.Entry<String, String> entry : map.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));

		DefaultHttpClient httpClient = new DefaultHttpClient();

		HttpResponse resp = httpClient.execute(httpPost);

		// 连接时间
		httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connectionTime);
		// 数据传输时间
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, sockTimeout);
		// 请求成功
		if (resp.getStatusLine().getStatusCode() == 200) {

			String responseStr = null;
			HttpEntity entity = resp.getEntity();
			responseStr = EntityUtils.toString(entity, "UTF-8").trim();
			EntityUtils.consume(entity);

			if (null != responseStr) {
				// Gson gson = new Gson();
				// ResponseMsg responseMsg = gson.fromJson(responseStr,
				// ResponseMsg.class);

				logger.info("返回码:" + resp.getStatusLine().getStatusCode() + "\n" + "请求成功..." + "\n" + "返回数据为:"
						+ responseStr.toString());
				return responseStr;
			}

			logger.info("返回码:" + resp.getStatusLine().getStatusCode() + "\n" + "请求成功..." + "\n" + "返回数据为空");
			return null;

		} else {
			logger.error("返回码:" + resp.getStatusLine().getStatusCode() + "\n" + "请求失败,失败错误可能为参数处理异常...");
			return null;
		}

	}

	/**
	 * @param url
	 *            url
	 * @param xml
	 *            xml格式字符串
	 * @return
	 * @throws java.io.IOException
	 */
	public static String sendHttpPostXml(String url, String json, String type) throws IOException {

		// List<NameValuePair> nvps = new ArrayList<NameValuePair>();

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(json, "UTF-8"));

		// httpPost.setHeader("AppId",
		// "app001");//ConfigUtil.getProperties("HARDWARE_CLOUD_APPID"));
		// httpPost.setHeader("Token",
		// "token001");//ConfigUtil.getProperties("HARDWARE_CLOUD_TOKEN"));

		long time = System.currentTimeMillis() / 1000 + 30 * 60;
		// System.out.println(time);
		String token = Base64.encodeBase64String(
				(time + ":" + MD5.encryption(Constance.HARDWARE_CLOUD_TOKEN+ time)).getBytes());
		httpPost.setHeader(HEARD_AUTHORIZATION, Constance.HARDWARE_CLOUD_APPID + " " + token);

		httpPost.setHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
		StringEntity se = new StringEntity(json);
        se.setContentType(CONTENT_TYPE_TEXT_JSON);
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
        httpPost.setEntity(se);

		DefaultHttpClient httpClient = new DefaultHttpClient();

		HttpResponse resp = httpClient.execute(httpPost);
		// 连接时间
		httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connectionTime);
		// 数据传输时间
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, sockTimeout);
		// 请求成功
		if (resp.getStatusLine().getStatusCode() == 200) {

			String responseStr = null;
			HttpEntity entity = resp.getEntity();
			responseStr = EntityUtils.toString(entity, "UTF-8").trim();
			EntityUtils.consume(entity);

			if (null != responseStr) {
				// Gson gson = new Gson();
				// ResponseMsg responseMsg = gson.fromJson(responseStr,
				// ResponseMsg.class);

				logger.info("返回码:" + resp.getStatusLine().getStatusCode() + "\n" + "请求成功..." + "\n" + "返回数据为:"
						+ responseStr.toString());
				return responseStr;
			}

			logger.info("返回码:" + resp.getStatusLine().getStatusCode() + "\n" + "请求成功..." + "\n" + "返回数据为空");
			return null;

		} else {
			logger.error("返回码:" + resp.getStatusLine().getStatusCode() + "\n" + "请求失败,失败错误可能为参数处理异常...");
			return null;
		}

	}

	public static String sentPostXml(String urlStr, String str) throws Exception {

		URL url = new URL(urlStr);
		URLConnection con = url.openConnection();
		con.setDoOutput(true);
		con.setRequestProperty("Pragma:", "no-cache");
		con.setRequestProperty("Cache-Control", "no-cache");
		con.setRequestProperty("Content-Type", "text/xml");

		OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());

		out.write(str);
		out.flush();
		out.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String line = "";
		StringBuffer sb = new StringBuffer();
		for (line = br.readLine(); line != null; line = br.readLine()) {
			sb.append(line);
		}

		logger.debug(sb.toString());
		return sb.toString();
	}

	public static void main(String args[]) {

		System.out.println(1 >>> 3);
		System.out.println(1 << 16);
		System.out.println(1 << 30);
		// Map<String, String> map = new HashMap<String, String>();
		// map.put("app", "1");
		//// String url = "http://192.168.0.136:8087/message/sendMsg";
		// String url = "http://192.168.0.254/uApp/app/order/queryPayWay";
		// HttpUtil h = new HttpUtil();
		// try {
		// String s = HttpUtil.sendHttpPost(url, map);
		// System.out.println(s);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

	}
}
