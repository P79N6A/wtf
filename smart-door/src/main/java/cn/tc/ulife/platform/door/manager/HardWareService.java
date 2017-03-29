/**
 * 
 */
package cn.tc.ulife.platform.door.manager;

import java.io.IOException;
import java.util.Map;

import org.json.JSONObject;

import cn.tc.ulife.platform.util.HttpUtil;
import cn.tc.ulife.platform.util.thread.CustomThreadPool;

/**
 * @author lpf
 *
 */
public final class HardWareService {
	// private static HardWareService tcService = new HardWareService();

	private HardWareService() {

	}

	// public synchronized static HardWareService getInstance()
	// {
	// return tcService;
	// }

	public static JSONObject getHardService(String url, String data) {

		try {
			String result = HttpUtil.sendHttpPostXml(url, data, "application/json");
			if (result.indexOf("code") != -1) {
				return new JSONObject(result);

			}
		} catch (Exception e) {

		}

		return null;
	}

	/**
	 * 不需要返回结果的推送数据
	 * 
	 * @param url
	 * @param data
	 */
	public static void sendHardService(final String url, final String data) {
		CustomThreadPool.execute(new Runnable() {

			@Override
			public void run() {
				try {
					HttpUtil.sendHttpPostXml(url, data, "application/json");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		String result;
		try {
			result = HttpUtil.sendHttpPostXml("http://xljiulang.imwork.net/v1/Intercom/CreateAccount", "","");
			System.out.println(result);
			JSONObject json = new JSONObject(result);
			System.out.println(json.get("code"));
			System.out.println(json.getJSONObject("data"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
