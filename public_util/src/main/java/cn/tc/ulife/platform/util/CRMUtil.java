/**
 * 
 */
package cn.tc.ulife.platform.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cn.tc.ulife.platform.util.logger.LogManager;

/**
 * @author lwy
 *	工具类
 */
public class CRMUtil
{
	public static Logger logger = LogManager.getLogManager().getRunLog();
	
	public static Map<String,String> map;
	
	/**
	 * 判断字符串是否是乱码
	 * 日期 2016-12-12
	 * 时间 下午2:31:34
	 * 创建者 lwy
	 * @param s
	 * @return
	 */
	public static boolean isMessyCode(String s) {  
		java.nio.charset.Charset.forName("UTF-8").newEncoder().canEncode(s);
		
		return true;

	}
	
	public static void main(String[] args)
	{
		//System.out.println(java.nio.charset.Charset.forName("UTF-8").newEncoder().canEncode("Ã©Å¸Â©Ã©Â¡ÂºÃ¥Â¹Â³"));
		
		
		System.out.println(toGb2312("Ã©Å¸Â©Ã©Â¡ÂºÃ¥Â¹Â³"));
		
	}
	private  static  String  toGb2312(String  str)  {   
        if  (str  ==  null)  return  null;   
        String  retStr  =  str;   
        byte  b[];   
        try  {   
                b  =  str.getBytes("UTF-8");  
                for  (int  i  =  0;  i  <  b.length;  i++)  {   
                        byte  b1  =  b[i];   
                        if  (b1  ==  63)   
                                break;    //1   
                        else  if  (b1  >  0)   
                                continue;//2   
                        else  if  (b1  <  0)  {        //不可能为0，0为字符串结束符  
//小于0乱码  
                                retStr  =  new  String(b,  "UTF-8");   
                                break;   
                        }   
                }   
        }  catch  (UnsupportedEncodingException  e)  {   
                //  e.printStackTrace();    
        }   
        return  retStr;   
}

	
  /**
    * 过滤非法参数
    * 日期 2016-11-1
    * 时间 下午3:10:02
    * 创建者 lwy
    * @param value
    * @return
    */
   public static String filterDangerString(String value){
	   if (null==value) {
           return null;
       }
	   if ("".equals(value)) {
           return "";
       }
	   value = value.replaceAll("'", "‘");
	   return value;
   }
	/**
	 * 数组里元素量大时判断数组中是否包含某个元素
	 * 日期 2016-5-24
	 * 时间 下午5:45:19
	 * 创建者 lwy
	 * @param arr 数组
	 * @param targetValue 元素
	 * @return
	 */
	public static String formatDate(String date) {  
	     if(StringUtils.isNotEmpty(date)){
	    	 date =date.substring(0,date.length()-2);
	     } 
	     return date;
	 } 
	
	/**
	 * 数组里元素量大时判断数组中是否包含某个元素
	 * 日期 2016-5-24
	 * 时间 下午5:45:19
	 * 创建者 lwy
	 * @param arr 数组
	 * @param targetValue 元素
	 * @return
	 */
	public static boolean bigArraysSearch(String[] arr, String targetValue) {  
	     int a = Arrays.binarySearch(arr, targetValue);  
	     if (a > 0) {  
	         return true;  
	     } else {  
	         return false;  
	     }  

	 } 
	/**
	 * 数组里元素量小时判断数组中是否包含某个元素
	 * 日期 2016-5-24
	 * 时间 下午5:45:19
	 * 创建者 lwy
	 * @param arr 数组
	 * @param targetValue 元素
	 * @return
	 */
	public static boolean smallArraysSearch(String[] arr, String targetValue) {  
	     for (String s : arr) {  
	         if (s.equals(targetValue)) {  
	             return true;  
	         }  
	     }  
	     return false;  
	 } 

	/**
	 * 获取系统当前时间之后的时间
	 * @param ts 天数间隔
	 * @return 时间
	 */
	public static String getSysAddTime(int ts) {
		java.util.Calendar rightNow = java.util.Calendar.getInstance(); 
        java.text.SimpleDateFormat sim = new java.text.SimpleDateFormat(Constants.DATA_YMDHMS);
        rightNow.add(java.util.Calendar.DAY_OF_MONTH, ts); 
        String date = sim.format(rightNow.getTime()); 
		return date;
	}
	/**
	 * 获取系统当前时间
	 * @param sdf 时间格式
	 * @return
	 */
	public static String getSysTime(SimpleDateFormat sdf) {
		String time="";
		if(null!=sdf){
			time= sdf.format(new Date());
		}
		return time;
	}
	/**
	 * 自定义sql转map通用方法
	 * @param sql SQL语句
	 * @return mybatis可以执行map对象
	 */
	public static Map<String,String>getMap(String sql){
		 map=new HashMap<String,String>();
		 map.put("sql", sql.toString().trim());
		 return map;
	}
	/**
	 * 自定义sql转map通用方法
	 * @param sql SQL语句
	 * @return mybatis可以执行map对象
	 */
	public static Map<String,String>getMapTwo(String sql){
		 Map<String,String> map=new HashMap<String,String>();
		 sql=sql.replaceAll("null", "");
		 map.put("sql", sql.toString().trim());
		 return map;
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
	  * 判断字符串是否是数字
	  */
	 public static boolean isNumber(String value) {
	  return isInteger(value) || isDouble(value);
	 }
	 /**
	  * 判断字符串是否是浮点数
	  */
	 public static boolean isDouble(String value) {
	  try {
	   Double.parseDouble(value);
	   	if (value.contains("."))
	   		return true;
	   		return false;
	  } catch (NumberFormatException e) {
		  return false;
	  }
	 }
	 /**
	  * 判断字符串是否是整数
	  */
	 public static boolean isInteger(String value) {
	  try {
		  Integer.parseInt(value);
	   return true;
	  } catch (NumberFormatException e) {
		  return false;
	  }
	}
	 /**
	  * 获取当前时间
	  * @param format 日期格式
	  * @return 日期
	  */
	 public static String getDate(String format){
		//设置日期格式
		 if(StringUtils.isEmpty(format)){
			 format="yyyy-MM-dd";
		 }
		 SimpleDateFormat df = new SimpleDateFormat(format);
		 return df.format(new Date());
	 }
	 /**
	  * 获取随机数
	  * @param length 随机数位数
	  * @return
	  */
	 public static String getRandomString(int length){
		String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < length; i++)
		{
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	/**
	 * Excel表头样式
	 * 
	 * @param workBook
	 * @return
	 */
	 public static HSSFCellStyle getHeadStyle(HSSFWorkbook workBook) {
		HSSFCellStyle headCellStyle = workBook.createCellStyle();
		// 列头加粗
		HSSFFont headFont = workBook.createFont();
		headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headCellStyle.setFont(headFont);
		// 设置边缘实线
		headCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// if(index == 1){
		// //指标名称列需要靠右
		// headCellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		// }
		// else
		// headCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		headCellStyle.setWrapText(true);// 自动换行
		return headCellStyle;
	}
	 
 /**
	 * Excel表头样式
	 * 
	 * @param workBook
	 * @return
	 */
	public static HSSFCellStyle getTopHeadStyle(HSSFWorkbook workBook) {
		HSSFCellStyle headCellStyle = workBook.createCellStyle();
		// 列头加粗
		HSSFFont headFont = workBook.createFont();
		headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headCellStyle.setFont(headFont);
		// 设置边缘实线
		headCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		return headCellStyle;
	}
	
	/**
	 * Excel表头样式
	 * 
	 * @param workBook
	 * @return
	 */
	public static HSSFCellStyle getTopHeadStyleOne(HSSFWorkbook workBook) {
		HSSFCellStyle headCellStyle = workBook.createCellStyle();
		// 列头加粗
		HSSFFont headFont = workBook.createFont();
		headFont.setFontHeightInPoints((short)12);
		headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headCellStyle.setFont(headFont);
		// 设置边缘实线
		headCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		return headCellStyle;
	}
	/**
	 * 表单内容样式
	 * 
	 * @param workBook
	 * @return
	 */
	 public static HSSFCellStyle getBodyStyle(HSSFWorkbook workBook) {
		HSSFCellStyle bodyStyle = workBook.createCellStyle();
		// 列头加粗
		HSSFFont headFont = workBook.createFont();
//		headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		bodyStyle.setFont(headFont);
		// 设置边缘实线
		bodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		bodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		bodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		bodyStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		bodyStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		bodyStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		bodyStyle.setWrapText(true);// 自动换行
		return bodyStyle;
	}
}
