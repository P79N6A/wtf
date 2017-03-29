/**
 * @Title: SysServiceImpl
 * @Package cn.tc.ulife.platform.server.sys.service.impl
 * @Description: 系统公共模块service实现层
 * @author cxs
 * @date 2017/2/14 13:59
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.sys.service.impl;

import cn.tc.ulife.platform.server.sys.dao.SysDao;
import cn.tc.ulife.platform.server.sys.model.AppSignedEntity;
import cn.tc.ulife.platform.server.sys.model.FwMsgEntity;
import cn.tc.ulife.platform.server.sys.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxs
 * @ClassName: SysServiceImpl
 * @Description: 系统公共模块service实现层
 * @date 2017/2/14 13:59
 */
@Service("SysService")
public class SysServiceImpl implements SysService {

    @Autowired
    private SysDao sysDao;

    @Override
    public List<FwMsgEntity> querySysNotice(String type, Integer ofset, Integer psize) {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("ofset", ofset);
        map.put("psize", psize);
        return sysDao.querySysNotice(map);
    }

    @Override
    public int addSysNotice(String uid, String title, String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("msg", msg);
        map.put("uid", uid);
        return sysDao.addSysNotice(map);
    }

    @Override
    public int updateSysNotice(String id, String zt) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("zt", zt);
        return sysDao.updateSysNotice(map);
    }

    @Override
    public String getSysNoticeTotal() {
        return sysDao.getSysNoticeTotal();
    }

    @Override
    public List<AppSignedEntity> queryIntegralRules() {
        Map<String, Object> map = new HashMap<>();
        return sysDao.queryIntegralRules(map);
    }

    @Override
    public String getIntegralRuleTotal() {
        Map<String, Object> map = new HashMap<>();
        return sysDao.getIntegralRuleTotal();
    }

    @Override
    public int updateIntegralRule(String id, String integral) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("integral", integral);
        return sysDao.updateIntegralRule(map);
    }
}
