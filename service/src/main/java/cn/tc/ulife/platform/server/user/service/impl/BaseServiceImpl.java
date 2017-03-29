/**
 *
 */
package cn.tc.ulife.platform.server.user.service.impl;

import cn.tc.ulife.platform.server.exception.DefaultException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * @author wy
 */
@Service("baseService")
public class BaseServiceImpl {

    public Map<String, Object> checkPage(String ofset, String psize) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        int n = 0;
        int s = 0;

        try {
            n = Integer.valueOf(ofset == null || "".equals(ofset) ? "1" : ofset);
            s = Integer.valueOf(psize == null || "".equals(psize) ? "10" : psize);
        } catch (NumberFormatException e) {
            throw new DefaultException("000001");
        }

        if (n <= 0 || s <= 0) {
            throw new DefaultException("000002");
        } else {
            map.put("ofset", (n - 1) * s);
            map.put("psize", s);
            return map;
        }
    }

}
