package cn.tc.ulife.platform.util;
import org.apache.log4j.Logger;

import cn.tc.ulife.platform.util.logger.LogManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author lpf
 */
public final class SendSMS {
    private static Logger logger = LogManager.getLogManager().getRunLog();


//	public static String sendTemplateMsgByPost1(String recevie, String text)

    /**
     * 发送模版短信(短信模版的创建参考客户端操作手册)
     *
     * 模版：@1@会员，动态验证码@2@(五分钟内有效)。请注意保密，勿将验证码告知他人。 参数值:@1@=member,@2@=4293
     * 最终短信内容：【短信签名】member会员，动态验证码4293(五分钟内有效)。请注意保密，勿将验证码告知他人。
     *
     * @param mobile
     *            手机号码
     * @param tempId
     *            模版编号，对应客户端模版编号
     * @param content
     *            各参数值，以英文逗号隔开，如：@1@=member,@2@=4293
     * @return
     * @throws Exception
     */
//	public static String sendTemplateSms(String mobile, String content)
//	{
//		String address = ConfigUtil.getProperties("SEND_URL")
//				+ "/service/httpService/httpInterface.do?method=sendMsg";
//
//		StringBuilder params = new StringBuilder();
//		params.append("username=").append("JSM41047");
//		params.append("&password=")
//				.append(ConfigUtil.getProperties("SEND_PWD"));
//		params.append("&veryCode=").append("3c3zrefo4ewq");
//		params.append("&mobile=").append(mobile);
//		params.append("&content=").append(content);
//		params.append("&msgtype=").append("2");
//		params.append("&tempid=").append(ConfigUtil.getProperties("TEMPID"));
//		params.append("&code=").append("utf-8");
//		try
//		{
//			URL url = new URL(address);
//			URLConnection connection = url.openConnection();
//			connection.setDoOutput(true);
//			OutputStreamWriter out = new OutputStreamWriter(
//					connection.getOutputStream(), "utf-8");
//			out.write(params.toString()); // post的关键所在！
//			out.flush();
//			out.close();
//			String temp = "";
//			String result = "";
//			InputStream is = connection.getInputStream();
//			BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//			while ((temp = br.readLine()) != null)
//			{
//				result += temp;
//			}
//			params.indexOf(" Send Msg : ", 0);
//			params.append(" /r/n Response Msg : ").append(result);
//			logger.debug(params.toString());
//
//			return result;
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			logger.error("send msg error", e);
//		}
//		return "";
//	}
//	
//	public static String sendTemplateMsgByPost(String recevie, String text)
// 
//	{
//		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//		nvps.add(new BasicNameValuePair("username", "JSMB260803"));
//		nvps.add(new BasicNameValuePair("scode", ConfigUtil
//				.getProperties("SEND_PWD")));
//
//		try
//		{
//			nvps.add(new BasicNameValuePair("content", text
//					+ new String(ConfigUtil.getProperties("SEND_BODY")
//							.getBytes("ISO-8859-1"), "UTF-8")));
//			nvps.add(new BasicNameValuePair("mobile", recevie));
//			// nvps.add(new BasicNameValuePair("tempid", "123456"));
//			DefaultHttpClient httpClient = new DefaultHttpClient();
//			HttpPost httpPost = new HttpPost(
//					ConfigUtil.getProperties("SEND_URL"));
//			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));// ,
//																		// Constants.ZST_CHARSET
//
//			HttpResponse resp = httpClient.execute(httpPost);
//			if (resp.getStatusLine().getStatusCode() == 200)
//			{// 请求成功
//				String responseXmlStr = null;// 群发请求对方响应内容（XML格式字符串）
//				HttpEntity entity = resp.getEntity();
//				responseXmlStr = EntityUtils.toString(entity, "UTF-8").trim();
//				EntityUtils.consume(entity);
//				logger.info("返回值:" + responseXmlStr);
//				return responseXmlStr;
//			}
//			else
//			{
//				logger.info("----------------Status not 200------>"
//						+ resp.getStatusLine().getStatusCode());
//			}
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//		return "0";
//	}
//
//	/**
//	 * 发送普通短信
//	 * 
//	 * @param mobile
//	 *            手机号码, 多个号码以英文逗号隔开,最多支持100个号码
//	 * @param content
//	 *            短信内容
//	 * @return
//	 * @throws Exception
//	 */
//	public static String sendTextSms(String mobile, String content)
//
//	{
//
//		String address = ConfigUtil.getProperties("SEND_URL")
//				+ "/service/httpService/httpInterface.do?method=sendUtf8Msg";
//		String result = "";
//		try
//		{
//
//			StringBuilder params = new StringBuilder();
//			params.append("username=").append("JSM41047");
//			params.append("&password=").append(
//					ConfigUtil.getProperties("SEND_PWD"));
//			params.append("&veryCode=").append("3c3zrefo4ewq");
//			params.append("&mobile=").append(mobile);
//			params.append("&content=").append(
//					content
//							+ new String(ConfigUtil.getProperties("SEND_BODY")
//									.getBytes("ISO-8859-1"), "UTF-8"));
//			params.append("&msgtype=").append("1");
//			params.append("&code=").append("utf-8");
//			// params.append("&sendtime=").append("20151001113000"); //发送定时短信
//			// System.out.println(params.toString());
//			URL url = new URL(address);
//			URLConnection connection = url.openConnection();
//			connection.setDoOutput(true);
//			OutputStreamWriter out = new OutputStreamWriter(
//					connection.getOutputStream(), "utf-8");
//			out.write(params.toString()); // post的关键所在！
//			out.flush();
//			out.close();
//			String temp = "";
//
//			InputStream is = connection.getInputStream();
//			BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//			while ((temp = br.readLine()) != null)
//			{
//				result += temp;
//			}
//
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//
//		return result;
//	}

    /**
     * 发送模版短信(短信模版的创建参考客户端操作手册)
     * <p/>
     * 模版：@1@会员，动态验证码@2@(五分钟内有效)。请注意保密，勿将验证码告知他人。 参数值:@1@=member,@2@=4293
     * 最终短信内容：【短信签名】member会员，动态验证码4293(五分钟内有效)。请注意保密，勿将验证码告知他人。
     *
     * @param mobile  手机号码
     * @param tempId  模版编号，对应客户端模版编号
     * @param content 各参数值，以英文逗号隔开，如：@1@=member,@2@=4293
     * @return
     * @throws Exception
     */
    public static String sendTemplateSms(String mobile, String tempId, String content) {
        String address = ConfigUtil.getProperties("SEND_URL")
                + "/service/httpService/httpInterface.do?method=sendMsg";

        StringBuilder params = new StringBuilder();
        params.append("username=").append("JSM41047");
        params.append("&password=")
                .append(ConfigUtil.getProperties("SEND_PWD"));
        params.append("&veryCode=").append("3c3zrefo4ewq");
        params.append("&mobile=").append(mobile);
        params.append("&content=").append(content);
        params.append("&msgtype=").append("2");
        params.append("&tempid=").append(tempId);
        params.append("&code=").append("utf-8");
        try {
            URL url = new URL(address);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(
                    connection.getOutputStream(), "utf-8");
            out.write(params.toString()); // post的关键所在！
            out.flush();
            out.close();
            String temp = "";
            StringBuffer result = new StringBuffer();
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while ((temp = br.readLine()) != null) {
                result.append(temp);
            }
            params.indexOf(" Send Msg : ", 0);
            params.append(" /r/n Response Msg : ").append(result);
            logger.debug(params.toString());

            return result.toString();
        } catch (Exception e) {

            e.printStackTrace();
            logger.error("send msg error", e);
        } finally {

        }
        return "";
    }
    // public static void main(String[] args)
    // {
    // try
    // {
    // postSmsText("18061462502", "的石头色");
    // }
    // catch (IOException e)
    // {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
}
