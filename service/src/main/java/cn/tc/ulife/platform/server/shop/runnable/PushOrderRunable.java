package cn.tc.ulife.platform.server.shop.runnable;


import cn.tc.ulife.platform.server.SpringContextUtil;
import cn.tc.ulife.platform.server.shop.model.MessageModel;
import cn.tc.ulife.platform.server.shop.service.OrderService;
import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.HttpUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with uApp.
 * </p>
 * PackageName:cn.tc.ulife.task
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/6/15 0015
 * </p>
 * Time: 上午 10:56
 * </p>
 * Detail:
 * </p>
 */
public class PushOrderRunable implements Runnable {

    private Map<String, String> keyMap;

    /**
     * 订单编号
     */
    private String orderNum;

    /**
     * 类型    0: 派送订单   2:服务订单  3:快递订单
     */
    private String type;

    private String fid;

    private String comId;

    public Map<String, String> getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(Map<String, String> keyMap) {
        this.keyMap = keyMap;
    }


    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    @Override
    public void run() {
        if (null != keyMap) {
//            String orderNum = keyMap.get("orderNum");
//
//            //type 暂定     0: 派送订单   2:服务订单  3:快递订单
//            String type = keyMap.get("type");
//
//            //服务商id  ，服务订单时必需
//            String fid = keyMap.get("fid");
//
//            //小区id
//            String comId = keyMap.get("comId");

            OrderService orderService = (OrderService) SpringContextUtil.getBean("oService");


            List<String> devTokens = orderService.getDeviceTokens(keyMap);
            if (null != devTokens) {

                StringBuffer sb = new StringBuffer();
                for (String devToken : devTokens) {
                    sb.append(devToken + ",");
                }
                MessageModel messageModel = new MessageModel();
                try {
//                    messageModel.setTittle(new String(ConfigUtil.getProperties(
//                            "APP_TITTLE").getBytes("ISO-8859-1"), "UTF-8"));
                    messageModel.setTittle(new String("U家客服".getBytes("UTF-8"), "UTF-8"));

//                    messageModel.setDescription(new String(ConfigUtil
//                            .getProperties("APP_DESCRIPTION").getBytes(
//                                    "ISO-8859-1"), "UTF-8"));
//                    messageModel.setTicker(new String(ConfigUtil.getProperties(
//                            "APP_TICKER").getBytes("ISO-8859-1"), "UTF-8"));
//                    messageModel.setText(new String(ConfigUtil.getProperties(
//                            "APP_TEXT").getBytes("ISO-8859-1"), "UTF-8"));
                    messageModel.setDescription(new String("您有一条新的订单".getBytes(
                            "ISO-8859-1"), "UTF-8"));
                    messageModel.setTicker(new String("U家客服".getBytes("UTF-8"), "UTF-8"));
                    messageModel.setText(new String("您有一条新的订单".getBytes("UTF-8"), "UTF-8"));
                    messageModel.setDeviceTokens(sb.toString());
                    Gson gson = new Gson();
                    String message = gson.toJson(messageModel);
                    //
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("app", "2");
                    map.put("type", "2");
                    map.put("messageModel", message);
                    HttpUtil.sendHttpPost(ConfigUtil.getProperties("PUSH_URL"),
                            map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            switch (type) {
//                case "1":
//
//                    try {
//                        messageModel.setTittle(new String(ConfigUtil.getProperties(
//                                "APP_TITTLE").getBytes("ISO-8859-1"), "UTF-8"));
//
//                        messageModel.setDescription(new String(ConfigUtil
//                                .getProperties("APP_DESCRIPTION").getBytes(
//                                        "ISO-8859-1"), "UTF-8"));
//                        messageModel.setTicker(new String(ConfigUtil.getProperties(
//                                "APP_TICKER").getBytes("ISO-8859-1"), "UTF-8"));
//                        messageModel.setText(new String(ConfigUtil.getProperties(
//                                "APP_TEXT").getBytes("ISO-8859-1"), "UTF-8"));
//
//                        messageModel.setDeviceTokens(sb.toString());
//                    } catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                case "2":
//                    try {
//
//                        messageModel.setTittle(new String(ConfigUtil.getProperties(
//                                "APP_TITTLE").getBytes("ISO-8859-1"), "UTF-8"));
//
//                        messageModel.setDescription(new String(ConfigUtil
//                                .getProperties("APP_DESCRIPTION").getBytes(
//                                        "ISO-8859-1"), "UTF-8"));
//                        messageModel.setTicker(new String(ConfigUtil.getProperties(
//                                "APP_TICKER").getBytes("ISO-8859-1"), "UTF-8"));
//                        messageModel.setText(new String(ConfigUtil.getProperties(
//                                "APP_TEXT").getBytes("ISO-8859-1"), "UTF-8"));
//
//                        messageModel.setDeviceTokens(sb.toString());
//                    } catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                    }
//
//                    break;
//                case "3":
//
//                    try {
//                        messageModel.setTittle(new String(ConfigUtil.getProperties(
//                                "APP_TITTLE").getBytes("ISO-8859-1"), "UTF-8"));
//
//                        messageModel.setDescription(new String(ConfigUtil
//                                .getProperties("APP_DESCRIPTION").getBytes(
//                                        "ISO-8859-1"), "UTF-8"));
//                        messageModel.setTicker(new String(ConfigUtil.getProperties(
//                                "APP_TICKER").getBytes("ISO-8859-1"), "UTF-8"));
//                        messageModel.setText(new String(ConfigUtil.getProperties(
//                                "APP_TEXT").getBytes("ISO-8859-1"), "UTF-8"));
//
//                        messageModel.setDeviceTokens(sb.toString());
//                    } catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                    }
//
//                    break;
//
//            }
//            Gson gson = new Gson();
//            String message = gson.toJson(messageModel);
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("app", "2");
//            map.put("type", "3");
//            map.put("messageModel", message);
//            try {
//                HttpUtil.sendHttpPost(ConfigUtil.getProperties("PUSH_URL"),
//                        map);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        }
    }
}
