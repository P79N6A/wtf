package cn.tc.ulife.platform.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class KeyedDigestMD5 {
    
	public static byte[] getKeyedDigest(byte[] buffer, byte[] key) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(buffer);
            return md5.digest(key);
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }
	
		
	public static String getKeyedDigest(String strSrc, String key) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(strSrc.getBytes("UTF8"));
            
            String result="";
            byte[] temp;
            temp=md5.digest(key.getBytes("UTF8"));
    		for (int i=0; i<temp.length; i++){
    			result+=Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6);
    		}
    		
    		return result;
    		
        } catch (NoSuchAlgorithmException e) {
        	
        	e.printStackTrace();
        	
        }catch(Exception e)
        {
          e.printStackTrace();
        }
        return null;
    }

	/**
	 * 
	 * @Title: getVerifyString
	 * @Description: 将map中的key-value转化为key2=%value2&key1=%value1&key3=%value3字符串,再对字符串KeyedDigestMD5加密
	 * @author cxs
	 * @param map
	 * @param num 0表示号段查询、充值产品查询，1下单直冲、订单结果查询，2充值产品查询
	 * @return
	 * @throws
	 */
	public static String getVerifyString(Map<String, String> map, int num) {
		
		String verifyString = null;
		// 决定拼接参数的顺序，不同顺序生成的KeyedDigestMD5加密值不同
		String[][] s = {
                // 充值产品查询
                {"agentid", "source", "merchantKey"},
				// 号段查询、充值产品查询
				{ "agentid", "source", "mobilenum", "merchantKey" },
				// 下单直冲、订单结果查询
				{ "prodid", "agentid", "backurl", "returntype", "orderid",
						"mobilenum", "source", "mark", "merchantKey" } };
		
		if(num < s.length && num > -1){
			
			StringBuffer sb = new StringBuffer();
			for (String key : s[num]) {
				if(map.containsKey(key))
					sb.append(key).append("=").append(map.get(key)).append("&");
			}
			
			verifyString = KeyedDigestMD5.getKeyedDigest(sb.substring(0, sb.length()-1),"");
		}
		
		return verifyString;
	}
	
	/**
	 * @Title: getVerifyParams
	 * @Description: 设置确认码参数
	 * @author cxs
	 * @param map
	 * @return
	 * @throws
	 */
	public static Map<String, String> getVerifyParams(Map<String, String> map, int num) {
		map.put("verifystring", KeyedDigestMD5.getVerifyString(map,num));	
		return map;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mi;
        String s = "hf1000";
        
        //第二个参数请填空字符串
		mi=KeyedDigestMD5.getKeyedDigest(s,"");
		
		System.out.println("mi:"+mi);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("agentid", "111");
		map.put("source", "222");
		map.put("mobilenum", "333");
		
		mi = KeyedDigestMD5.getVerifyString(map,0);
		System.out.println("mi:"+mi);
		
		mi=KeyedDigestMD5.getKeyedDigest("agentid=111&source=222&mobilenum=333","");
		System.out.println("mi:"+mi);
		
		System.out.println(getVerifyParams(map,0));
	}

}