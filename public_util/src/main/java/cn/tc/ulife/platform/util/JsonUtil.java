package cn.tc.ulife.platform.util;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import cn.tc.ulife.platform.util.logger.LogManager;

/**
 * @author lwy
 *
 */
public class JsonUtil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9095977263546135727L;
	public static Logger logger = LogManager.getLogManager().getRunLog();
	
	/**
	 * 页面保存返回json共用方法
	 * @param msg 提示信息
	 * @return json
	 */
	public static JSONObject formatJsonResult(String msg,boolean flag){
		JSONObject json =new JSONObject();
		json.put("flag", flag);
		json.put("msg", msg);
		return json;
	}
	
	public static JSONObject formatJsonResult(String msg,boolean flag,Object object){
		JSONObject json =new JSONObject();
		json.put("flag", flag);
		json.put("msg", msg);
		json.put("data", object);
		return json;
	}
	
}
