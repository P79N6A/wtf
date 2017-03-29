/**
 * 
 */
package cn.tc.ulife.platform.util;

/**
 * @author lwy 常量类
 */
public class Constants
{
	/*********** 微信公众号消息推送 ****************/
	/**
	 * token
	 */
	public static String TOKEN = "TOKEN";

	/**
	 * 有效期
	 */
	public static String MAXTIME = "MAXTIME";

	/*** session用户信息节点 ****/
	public static final String USERINFO = "USERINFO";
	/*** 登录界面url ****/
	public static final String LOGINURL = "/page/login/login.jsp";
	/*** 登录界面url ****/
	public static final String MAINURL = "/page/main/main.jsp";
	/*** JDBC链接信息 ****/
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mysql://192.168.0.254:3306/ut?useUnicode=true&characterEncoding=utf-8";
	public static final String JDBC_USER = "root";
	public static final String JDBC_PWD = "root";
	/*** JDBC链接信息 ****/
	/*** 数据状态-有效 **/
	public static final String ZT_YX = "0";
	/*** 数据状态-无效 **/
	public static final String ZT_WX = "1";

	/*** 账号状态-启用 **/
	public static final String AZT_QY = "0";
	/*** 账号状态-停用 **/
	public static final String AZT_TY = "1";
	/*** 账号状态-注销 **/
	public static final String AZT_ZX = "2";
	/*** 账号状态-重置密码 **/
	public static final String AZT_RESET = "3";
	/*** 时间格式-精确到年月日时分秒毫秒 **/
	public static final String DATA_YMDHMSS = "yyyy-MM-dd HH:mm:ss SSS";
	/*** 时间格式-精确到年月日时分秒 **/
	public static final String DATA_YMDHMS = "yyyy-MM-dd HH:mm:ss";
	/*** 时间格式-精确到年月日 **/
	public static final String DATA_YMD = "yyyy-MM-dd";
	/*** 管理员角色编码-------------------start **/
	/*** 管理员角色编码-系统管理员 **/
	public static final String R_ADMIN = "ADMIN";
	/*** 管理员角色编码-代理商 **/
	public static final String R_CJYYS = "DLS";
	/*** 管理员角色编码-商家管理员 **/
	public static final String R_SJGULY = "SJGULY";
	/*** 管理员角色编码-商家客服**/
	public static final String R_SJKF = "SJKF";
	/*** 管理员角色编码-小站管理员 **/
	public static final String R_XZGLY = "XZGLY";
	/*** 管理员角色编码-物业管理员 **/
	public static final String R_WYGLY = "WYGLY";
	/*** 管理员角色编码-财务管理员 **/
	public static final String R_CWGLY = "CWGLY";
	/*** 管理员角色编码-供应商管理员 **/
	public static final String R_GYS = "GYS";
	/*** 管理员角色编码-小站客服 **/
	public static final String R_XZKF = "XZKF";
	/*** 管理员角色编码-采购管理员 **/
	public static final String R_CGGLY = "CGGLY";
	/*** 管理员角色编码-分拣管理员 **/
	public static final String R_FJZX = "FJZX";
	/*** 管理员角色编码-------------------end **/
	/** 会员账号状态 -启用 */
	public static final String MEMBER_QY = "0";
	/** 会员账号状态-禁用 */
	public static final String MEMBER_JY = "1";
	/** 会员账号数据状态-有效 */
	public static final String MEMBER_DATE_YX = "0";
	/** 会员账号数据状态-无效 */
	public static final String MEMBER_DATE_WX = "1";
	/*** 营销管理常量-----start-------------- **/
	/** 优惠卷规则-直降 */
	public static final String YX_YHJGZ_YHJZJ = "YHJZJ";
	/** 优惠卷规则-满减 */
	public static final String YX_YHJGZ_YHJMJ = "YHJMJ";

	/** 促销规则-直降促销 */
	public static final String YX_CXGZ_ZJCX = "ZJCX";
	/** 促销规则-买送优惠券促销 */
	public static final String YX_CXGZ_MSYHJCX = "MSYHJCX";
	/** 促销规则-买折促销 */
	public static final String YX_CXGZ_MAIZCX = "MAIZCX";
	/** 促销规则-满减促销 */
	public static final String YX_CXGZ_MANJCX = "MANJCX";
	/** 促销规则-满送优惠券促销 */
	public static final String YX_CXGZ_MANSYHJCX = "MANSYHJCX";
	/** 促销规则-满折促销 */
	public static final String YX_CXGZ_MANZCX = "MANZCX";
	/** 促销规则-限购 */
	public static final String YX_CXGZ_XIANGOU = "XIANGOU";
	/** 促销规则-团购 */
	public static final String YX_CXGZ_TUANGOU = "TUANGOU";
	/** 促销规则-抢购 */
	public static final String YX_CXGZ_QIANGGOU = "QIANGGOU";
	/** 促销规则-包邮 */
	public static final String YX_CXGZ_BAOYOU = "BAOYOU";
	/** 促销规则-买够件数打折 */
	public static final String YX_CXGZ_MAIGJSDZ = "MAIGJSDZ";
	/** 促销规则-买够件数多少钱 */
	public static final String YX_CXGZ_MAIGJSSQ = "MAIGJSSQ";
	/** 促销规则-折扣促销 */
	public static final String YX_CXGZ_ZHEKCX = "ZHEKCX";
	/** 买赠促销 */
	public static final String YX_CXGZ_MAIZENG = "MAIZENGCX";

	/*** 营销管理常量--end----------------- **/

	/**
	 * 版本管理-ios
	 */
	public static final String BBGL_IOS = "1";
	/**
	 * 版本管理-Android
	 */
	public static final String BBGL_ANAROID = "4";

	/**
	 * 消息推送 发给所有人
	 */
	public static final String MSG_TO_ALL = "ALL";
	/*********************订单状态************************/
	/**
	 * 订单来源-小站后台
	 */
	public static final String O_LY_7 = "7";
	/**
	 * 订单来源-小站已确认
	 */
	public static final String O_ZT_31 = "31";
	/**
	 * 是否全网 0否1是
	 */
	public static final String ISPT = "0";
	public static final String ISNOTPT = "1";
	
	public static final String ISVIP ="1";//会员折扣不参加
	public static final String ISPTHD="1";//平台优惠不参加
	public static final String ISHD="0";//营销方式不限
	public static final String ZFFS="1";//线上支付
	public static final String SMJSZ="1";//售卖方式默认1计重
	public static final String ISSJ="1";//是否上架默认1上架
}
