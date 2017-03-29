package cn.tc.ulife.platform.server.shop.runnable;

import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.HttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.task
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/6/30 0030
 * </p>
 * Time: 上午 9:08
 * </p>
 * Detail:  用于向客服服务发送,增加推广人积分
 * </p>
 */
public class SendServerRunnable implements Runnable {


    private String type;

    private String serviceId;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public void run() {
        try {
            Map<String, String> map = new HashMap<String,String>();
            map.put("type", type);
            map.put("serviceId", serviceId);

            //发送到客服,请求为该客服增加推广积分
            HttpUtil.sendHttpPost(ConfigUtil.getProperties("SNED_SERVER_URL"),
                    map);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
