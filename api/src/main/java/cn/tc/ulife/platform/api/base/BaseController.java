package cn.tc.ulife.platform.api.base;


import cn.tc.ulife.platform.api.msg.ReturnMsg;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.controller
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/22 0022
 * </p>
 * Time: 下午 3:30
 * </p>
 * Detail:
 * </p>
 */
public class BaseController {

    protected static Logger logger = Logger.getLogger(BaseController.class);


    public Map<String, Object> checkPage(String ofset, String psize) {
        Map<String, Object> map = new HashMap<String, Object>();
        int n = 0;
        int s = 0;

        try {
            n = Integer.valueOf(ofset);
            s = Integer.valueOf(psize == null || "".equals(psize) ? "10" : psize);


        } catch (NumberFormatException e) {
            map.put("code", ReturnMsg.FALID);
            map.put("msg", "分页参数错误");
            return map;
        }
        if (n <= 0 || s <= 0) {
            map.put("code", ReturnMsg.FALID);
            map.put("msg", "分页参数错误");
            return map;
        } else {

            map.put("code", ReturnMsg.SUCCESSS);
            map.put("ofset", (n - 1) * s);
            map.put("psize", s);
            return map;
        }
    }



}
