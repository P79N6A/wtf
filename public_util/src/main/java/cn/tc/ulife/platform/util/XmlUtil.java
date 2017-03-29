package cn.tc.ulife.platform.util;
import org.apache.log4j.Logger;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created with ULife. </p> PackageName:cn.tc.ulife.util </p> User: wangyue </p>
 * Date: 2015/12/3 0003 </p> Time: 下午 1:27 </p> Detail: xml 工具类 </p>
 */
public class XmlUtil {

    static Logger logger = Logger.getLogger(XmlUtil.class);

    /**
     * 获取xml某一个值
     *
     * @param xml
     * @param name
     * @return
     */
    public static String dom4jPars(String xml, String name) {

        try {
            System.out.println(xml);
            Document doc = DocumentHelper.parseText(xml);
            Element root = doc.getRootElement();
            Node node = doc.selectSingleNode("//mt");
            System.out.println(node.asXML());
            System.out.println(node.getName());
            Element e = (Element) root.elements().get(0);
            e = (Element) e.elements().get(0);
            System.out.println(e.getName());
            System.out.println(e.getText());
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 解析xml字符串,返回java bean
     *
     * @param str    xml字符串
     * @param object 返回对象实例
     * @return
     * @throws Exception 调用者处理
     */
    public static Object parseXml(String str, Object object) {

        logger.info("parseXml-str:" + str);
        try {
            Document document = DocumentHelper.parseText(str);

            Element e = document.getRootElement();

            Iterator iterator = e.elementIterator();

            Field[] field = object.getClass().getDeclaredFields();

            while (iterator.hasNext()) {
                Element user = (Element) iterator.next();

                for (int i = 0; i < field.length; i++) {

                    if (field[i].getName().equals(user.getName())) {
                        field[i].setAccessible(true);
                        field[i].set(object, user.getText());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        logger.info("parseXml-object:" + object);
        return object;
    }

    /**
     * @param xml    xml字符串
     * @param c      对象的类
     * @param decode 目标编码,如utf-8
     * @return
     * @throws
     * @Title: parseXml
     * @Description: 解析话费充值返回的xml
     * @author cxs
     */
    public static List<?> parseXml(String xml, Class<?> c, String decode) {
        List<Object> resultList = new ArrayList<Object>();
        try {
            // 加载xml
            Document document = DocumentHelper.parseText(xml);
            // 根节点
            Element root = document.getRootElement();
            Iterator<?> iterator = root.elementIterator();
            while (iterator.hasNext()) {
                Object obj = c.newInstance();
                Element child = (Element) iterator.next();

                String proName = null, proValue = null;
                List<Element> childList = child.elements();
                for (Element e : childList) {
                    proName = e.attributeValue("name");
                    proValue = java.net.URLDecoder.decode(e.attributeValue("value"), decode);
                    String setMethodName = "set" + proName.substring(0, 1).toUpperCase() + proName.substring(1);
                    obj.getClass().getMethod(setMethodName, String.class).invoke(obj, proValue);
                }
                resultList.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return resultList;
    }

    // public static Object convertMap(Class type, Map map)
    // throws IntrospectionException, IllegalAccessException,
    // InstantiationException, InvocationTargetException {
    // BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
    // Object obj = type.newInstance(); // 创建 JavaBean 对象
    //
    // // 给 JavaBean 对象的属性赋值
    // PropertyDescriptor[] propertyDescriptors =
    // beanInfo.getPropertyDescriptors();
    // for (int i = 0; i< propertyDescriptors.length; i++) {
    // PropertyDescriptor descriptor = propertyDescriptors[i];
    // String propertyName = descriptor.getName();
    //
    // if (map.containsKey(propertyName)) {
    // // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
    // Object value = map.get(propertyName);
    //
    // Object[] args = new Object[1];
    // args[0] = value;
    //
    // descriptor.getWriteMethod().invoke(obj, args);
    // }
    // }
    // return obj;
    // }

    // 后台异步回调返回对象
    public static String createXml(String code, String msg) {
        // 创建dom对象
        Document document = DocumentHelper.createDocument();
        // 生成根节点
        Element element = document.addElement("xml");

        // code节点
        Element codeElement = element.addElement("result_code");

        codeElement.addText("![CDATA[" + "222" + "]");

        // msg节点
        Element msgElement = element.addElement("return_msg");

        msgElement.addText("ok");

        // 格式化
        OutputFormat format = OutputFormat.createCompactFormat();

        StringWriter writer = new StringWriter();
        XMLWriter output = new XMLWriter(writer, format);
        try {
            output.write(element);
            writer.close();
            output.close();
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }

    }

    public static void main(String[] args) {
        String xml = "<sms><mt><status>0</status><msgid>dc1bc4f603714d2cb2b914002060a800</msgid></mt></sms>";
//		SmsMsg sm = (SmsMsg) parseXml(xml, new SmsMsg());
//		System.out.println(sm.toString());
        dom4jPars(xml, "status");

//		connf
    }

    public static void main1(String[] args) throws Exception {
        String str = "<xml>\n"
                + "  <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n"
                + "  <attach><![CDATA[支付测试]]></attach>\n"
                + "  <bank_type><![CDATA[CFT]]></bank_type>\n"
                + "  <fee_type><![CDATA[CNY]]></fee_type>\n"
                + "  <is_subscribe><![CDATA[Y]]></is_subscribe>\n"
                + "  <mch_id><![CDATA[10000100]]></mch_id>\n"
                + "  <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>\n"
                + "  <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>\n"
                + "  <out_trade_no><![CDATA[1409811653]]></out_trade_no>\n"
                + "  <result_code><![CDATA[SUCCESS]]></result_code>\n"
                + "  <return_code><![CDATA[SUCCESS]]></return_code>\n"
                + "  <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>\n"
                + "  <sub_mch_id><![CDATA[10000100]]></sub_mch_id>\n"
                + "  <time_end><![CDATA[20140903131540]]></time_end>\n"
                + "  <total_fee>1</total_fee>\n"
                + "  <trade_type><![CDATA[JSAPI]]></trade_type>\n"
                + "  <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>\n"
                + "</xml>";

        // PrepayBean prepayBean = new PrepayBean();
        // // prepayBean.setAppid("wxd0f55d37d871324b");
        // prepayBean.setBody("苹果");
        // // prepayBean.setMch_id("1290707001");
        // prepayBean.setNonce_str("5K8264ILTKCH16CQ2502SI8Z67");
        // prepayBean.setOut_trade_no("124");
        // prepayBean.setSpbill_create_ip("192.168.0.1");
        // prepayBean.setTotal_fee("1");
        // prepayBean.setTrade_type("APP");
        // prepayBean.setNotify_url("http://121.40.35.3/test");
        // // prepayBean.setKey(ConfigUtil.getProperties("key"));
        //
        // System.out.println(prepayBean.toString());

//		PrepayBean prepayBean = new PrepayBean();
//		prepayBean.setTrade_type("APP");
//		prepayBean.setBody("我的撒的是");
//		prepayBean.setTotal_fee("1");
//		prepayBean.setOut_trade_no("432413");
//		prepayBean.setSpbill_create_ip("192.168.0.1");
//		System.out.println("ss" + System.getProperty("file.encoding"));
//		prepayBean.setNotify_url("http://121.40.35.3/test");
//		prepayBean.setProduct_id("11");
//
//		try
//		{
//			System.out.println(prepayBean.toXml(""));
//			// String callbackStr =
//			// HttpUtil.sentPostXml(prepayBean.toXml(),ConfigUtil.getProperties("PREPAY_URL"));
//			// System.out.println(callbackStr);
//			// PrepayCallBackBean prepayCallBackBean = new PrepayCallBackBean();
//			// XmlUtil.parseXml(callbackStr, prepayCallBackBean);
//			// System.out.println(callbackStr);
//			// System.out.println(prepayCallBackBean.getPrepay_id());
//			// System.out.println(prepayCallBackBean);
//			// System.out.println();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}

    }
}

