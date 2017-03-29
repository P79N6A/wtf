package njtc.spegroup;

import cn.tc.ulife.platform.server.shop.service.OrderService;
import cn.tc.ulife.platform.util.GsonUtil;
import cn.tc.ulife.platform.util.HttpUtil;
import njtc.ResponseMsg;
import njtc.test.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with platform.
 * </p>
 * PackageName:spegroup
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/8/11 0011
 * </p>
 * Time: 下午 2:11
 * </p>
 * Detail:
 * </p>
 */
public class SpeGroupCtrlTest extends BaseTest {

    static Map<String, String> paramMap;

    static String url = "http://127.0.0.1:8080/uApp/app/speGro/";

    static ResponseMsg responseMsg;

    static String retStr = "";


    @Autowired
    OrderService oService;


    @Before
    public void injeceParam() {
        paramMap = new HashMap<String, String>();

    }

    @After
    public void soutResult() throws Exception {
        responseMsg = GsonUtil.jsonToObject(retStr, ResponseMsg.class);
        if (null != responseMsg) {
            System.out.println(retStr);
            System.out.println(responseMsg.getMsg());
            if (responseMsg.getResultCode().equals("0")) {

                if (null != responseMsg.getData()) {

                    System.out.println(responseMsg.getData());
                }

            } else {

            }
        } else {
            System.out.println("请求失败");
            throw new Exception();
        }
    }


    @Test
    public void queryDevice() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "1");
        map.put("comId", "54");

    }

    /**
     * 获取拼团商品列表
     */
    @Test
    public void getGroListTest() {
//        System.out.println(Integer.parseInt("ss"));
        try {
            paramMap.put("ofset", "1");
            paramMap.put("psize", "6");
            paramMap.put("app", "1");
            retStr = HttpUtil.sendHttpPost(url + "getGroList", paramMap);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取拼团详情
     */
    @Test
    public void getGroDtlTest() {
        try {
            paramMap.put("gid", "11");
            paramMap.put("app", "1");
            retStr = HttpUtil.sendHttpPost(url + "getGroDtl", paramMap);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 测试添加拼团收货地址
     */
    @Test
    public void addGroupRecAddressTest() {
        try {
            paramMap.put("account", "18501400771");
            paramMap.put("province", "江苏");
            paramMap.put("city", "南京");
            paramMap.put("area", "雨花台");
            paramMap.put("dtlAddr", "京妆商务");
            paramMap.put("uname", "测试1");
            paramMap.put("tel", "1850140771");
            paramMap.put("isdef", "0");
            retStr = HttpUtil.sendHttpPost(url + "addRecAddr", paramMap);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 测试获取拼团收货地址列表
     */
    @Test
    public void queryRecAddressListTest() {
        try {
            paramMap.put("account", "18501400771");

            retStr = HttpUtil.sendHttpPost(url + "addRecAddr", paramMap);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 拼团部分回调逻辑测试
     */
    @Test
    public void specallBack() {
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("id", "16");
        testMap.put("ozt", "0");
//        speGroupDao.updUserGroupByFk(testMap);
//        System.out.println(speGroupDao.queryGroupClusterPerson("8B0DC65F99URZUS4"));
    }


    @Test
    public void canlleOrder() {
        paramMap.put("", "");

    }

    public static String getTest(String a) {

        a = "2222";
        return a;
    }

    public static void main(String[] args) {
        String a = "33";
        System.out.println(getTest(a));
    }
}
