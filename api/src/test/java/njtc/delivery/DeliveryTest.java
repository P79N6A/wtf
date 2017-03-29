package njtc.delivery;

import cn.tc.ulife.platform.util.HttpUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with platform.
 * </p>
 * PackageName:njtc.delivery
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/8/23 0023
 * </p>
 * Time: 下午 2:10
 * </p>
 * Detail:
 * </p>
 */
public class DeliveryTest  {

    private static final String url="http://127.0.0.1:8080/uApp/app" ;
//    private static final String url="http://192.168.0.254:8080/uApp/app" ;

    @Test
    public void queryComList() throws IOException {
        System.out.println(HttpUtil.sendHttpPost(url + "/delivery/queryComList", new HashMap<String, String>()));

    }

    @Test
    public void queryComDtl() throws IOException {
        Map<String,String> map =new HashMap<String, String>();
        map.put("cid","9");

        System.out.println(HttpUtil.sendHttpPost(url + "/delivery/queryComDtl", map));
    }

    @Test
    public void searchComDtl() throws IOException {
        Map<String,String> map =new HashMap<String, String>();
        map.put("text","苹果");
        System.out.println(HttpUtil.sendHttpPost(url + "/delivery/searchCom", map));
    }


    @Test
    public void addOrder() throws IOException {

//        PlatOrder platOrder=new PlatOrder();
//        platOrder.setUname("哈哈");
//        platOrder.setIscx("0");
//        platOrder.setIsyhj("0");
//        platOrder.setZhzj("10");
//        platOrder.setZffs("2");
//        platOrder.setPsfs("1");
//
//        StoreOrder storeOrder= new StoreOrder();
//        storeOrder.setSjid("18");
//        storeOrder.setUname("哈哈");
//        storeOrder.setIsyhj("0");
//        storeOrder.setZhzj("10");
//        storeOrder.setZffs("2");
//        storeOrder.setPsfs("10");
//        storeOrder.setPsrq("2016-08-25");
//        storeOrder.setPsf("2016-08-25");
//        CommodityOrder commodityOrder= new CommodityOrder();
//        commodityOrder.setDgsl("1");
//        commodityOrder.setGgdw("发");
//        commodityOrder.setGgsz("1");
//        commodityOrder.setIscx("1");
//        commodityOrder.setIsyhj("0");
//        commodityOrder.setSpid("14");
//        commodityOrder.setSpname("请求");
//        commodityOrder.setSprice("1");
//        commodityOrder.setZhzj("1");
//        commodityOrder.setYwjje("1");
//        commodityOrder.setGgid("37");
//        commodityOrder.setRemark("sdsdasdasd");
//        List<CommodityOrder> commodityOrders =new ArrayList<CommodityOrder>();
//        List<StoreOrder> storeOrders = new ArrayList<StoreOrder>();
//        commodityOrders.add(commodityOrder);
//        storeOrders.add(storeOrder);
//        storeOrder.setCommodityOrders(commodityOrders);
//        platOrder.setStoreOrderList(storeOrders);

        Map<String,String> map =new HashMap<String, String>();
        map.put("account","18501400771");
//        map.put("orders", GsonUtil.objectToJson(platOrder));
        System.out.println(HttpUtil.sendHttpPost(url + "/delivery/addOrder", map));
    }


    @Test
    public void queryOrderList() throws IOException {
        Map<String,String> map =new HashMap<String, String>();
        map.put("account","13905152065");
        map.put("ofset","1");
        map.put("psize","10");
        map.put("ozt","5");
        System.out.println(HttpUtil.sendHttpPost(url + "/delivery/getOrderList", map));
    }
    @Test
    public void getOrderDtl() throws IOException {
        Map<String,String> map =new HashMap<String, String>();
        map.put("account","15951885402");
//        ALTER TABLE `t_sc_order`
//        CHANGE COLUMN `ZTD` `ZTD` VARCHAR(50) NULL DEFAULT NULL AFTER `GGSZ`;
        map.put("orderId","374350");
        System.out.println(HttpUtil.sendHttpPost(url + "/delivery/getOrderDtl", map));
    }

    @Test
    public void getSendHistory() throws IOException {
        Map<String,String> map =new HashMap<String, String>();
        map.put("account","18963618570");

        map.put("orderId","373757");

        // hmset count::user:total: 10001:10l
        System.out.println(HttpUtil.sendHttpPost(url + "/delivery/getSendHistory", map));
    }




    @Test
    public void getTest() throws IOException {
        Map<String,String> map =new HashMap<String, String>();

        // hmset count::user:total: 10001:10
        System.out.println(HttpUtil.sendHttpPost(url + "/delivery/test", map));
    }
}
