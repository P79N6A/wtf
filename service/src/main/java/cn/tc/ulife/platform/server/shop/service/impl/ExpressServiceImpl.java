/**
 * @Title: ExpressServiceImpl
 * @Package cn.tc.ulife.platform.server.express.service.impl
 * @Description: 快递模块service实现层
 * @author alliswell008
 * @date 2017/2/16 14:57
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.service.impl;

import cn.tc.ulife.platform.server.shop.dao.ExpressDao;
import cn.tc.ulife.platform.server.shop.entity.ExpressEntity;
import cn.tc.ulife.platform.server.shop.page.ExpressPage;
import cn.tc.ulife.platform.server.shop.service.ExpressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alliswell008
 * @ClassName: ExpressServiceImpl
 * @Description: 快递模块service实现层
 * @date 2017/2/16 14:57
 */
@Service("ExpressService")
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private ExpressDao expressDao;

    @Override
    public boolean addExpressInfo(String account, String app, ExpressPage page) {
        ExpressEntity entity = new ExpressEntity();

        BeanUtils.copyProperties(entity, page);
        expressDao.addExpressInfo(entity);
        return true;
    }

    @Override
    public boolean delExpressInfo(String account, String app, String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        ExpressEntity entity = new ExpressEntity();

        map.put("id", id);
        expressDao.delExpressInfo(map);
        return true;
    }

    @Override
    public boolean updExpressInfo(String account, String app, ExpressPage page) {
        ExpressEntity entity = new ExpressEntity();

        BeanUtils.copyProperties(entity, page);
        expressDao.addExpressInfo(entity);
        return true;
    }

    @Override
    public ExpressPage queryExpressInfo(String account, String app, String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        ExpressPage expressPage = new ExpressPage();

        map.put("id", id);
        ExpressEntity expressEntity = expressDao.queryExpressEntity(map);
        BeanUtils.copyProperties(expressPage, expressEntity);
        return expressPage;
    }

    @Override
    public List<ExpressPage> queryAll(String account, String app, String kdmc, Integer ofset, Integer psize) {
        Map<String, Object> map = new HashMap<>();
        List<ExpressPage> pageList = new ArrayList<ExpressPage>();
        List<ExpressEntity> entityList = new ArrayList<ExpressEntity>();

        map.put("kdmc", kdmc);
        map.put("ofset", ofset);
        map.put("psize", psize);

        entityList = expressDao.queryAll(map);
        BeanUtils.copyProperties(pageList, entityList);
        return pageList;
    }
}
