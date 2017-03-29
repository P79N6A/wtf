package cn.tc.ulife.platform.util.payutil;

/**
 * @author wy
 */

public class AlipayConfig {

    // ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    // 合作身份者ID，以2088开头由16位纯数字组成的字符串
    public static String partner = "2088021653385023";

    // 收款支付宝账号
    public static String seller_email = "2088021653385023";

    // 商户的私钥
    public static String key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKVColdImSz3zofvrwquFoKjb2ZMMhaHSgKyKP/H0kbb0+1j6qf2WHFCb29O8nR67oUXiN0UCmab3I55mVngSBGna+JnKypciAAygzpticPrV3bfjFJ4KmiAF9N5NS+Z7c+F1ZY6cHMVr6ZWaKaexSKHApmRSR68+XubMgK6QmVVAgMBAAECgYBpqLG8lnkArCtK9C546JcRzUaTJBI+Hx9tm9TkvDAwB6p2s5Q68SDYwP4YL2SKnnJTe5mQp5iCxBH+sbYfJWtNfqAkOuwoi6mfiL+/exQQDJyp+sQqjLx1T4BhhGNKYFTkD+G4Q2gd6VuMDv8lM9sk4m0V6thVdkDLSgIt2cYjoQJBANvpkneyMGkRDfkFOI4EsK1wur0TECUjIhkZycYwHOxSPhLQsluM7QozTgWC8jN58NJQFvIeg8WEphUmjhzKdz0CQQDAYSZm1x+AgS9LVKTGhzA1p7EovDNR1LSKgOG+YPnAzXNyPQfcnRiJ9WSJvwkfhqYN6RLF40X/DJHcTct7dMf5AkADe6mUN8BIibqc7RY+OZjKxnROtlSVIf9SQnRNrUln/M164s9QX+UJOlLMB4zqf83uptIWN6GCqV0wDJJHpnVJAkBagtrAc+IcYatQs+g6h4xFEjqlwbYbgAnZSD3thk67SW5RhylVwIu1DMFalYjDTmR+EvSEKiPalZ1imy9rTExxAkEAixNflSmGiINqyd1VWaHbpFtlg8RTvE9cQNHJytStPcYRovF2TCbPiNV6yNCxJvgA6rx7tpfJfItaYcC2YyfeTA==";

    // ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    // 调试用，创建TXT日志文件夹路径
    public static String log_path = "D:\\";

    // 字符编码格式 目前支持 gbk 或 utf-8
    public static String input_charset = "utf-8";

    // 签名方式 不需修改
    public static String sign_type = "RSA";


}
