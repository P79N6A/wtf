package cn.tc.ulife.platform.agent.base;


import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public abstract class BaseController {

    protected static Logger logger = LoggerFactory.getLogger(BaseController.class);
    protected static final Map<String, String> roleCodeMap = new HashMap<>();

    {

        //程序中默认给定资源分组分级别 1 2对应为各自系统中的管理员
        roleCodeMap.put("ADMIN", "1");
        roleCodeMap.put("DLS", "2");
        roleCodeMap.put("SJGULY", "3");
        roleCodeMap.put("XZGLY", "4");
        roleCodeMap.put("WYGLY", "5");
        roleCodeMap.put("CGGLY", "6");
        roleCodeMap.put("GYS", "7");
        roleCodeMap.put("FJZX", "8");
        roleCodeMap.put("USER", "10");

    }

    protected static final Integer MAX_ADD_SIZE = 100;

    protected static final String DEFAUL_NULL = null;

    protected static final String CHANGE_DEFAUL = "0";


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
