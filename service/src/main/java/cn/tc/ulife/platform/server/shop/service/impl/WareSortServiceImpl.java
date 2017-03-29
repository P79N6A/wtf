/**
 * @Title: WareSortServiceImpl
 * @Package cn.tc.ulife.platform.server.ware.service.impl
 * @Description: 商品分类service实现层
 * @author cxs
 * @date 2017/2/20 14:37
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.service.impl;

import cn.tc.ulife.platform.server.shop.dao.IntegralWareSortDao;
import cn.tc.ulife.platform.server.shop.dao.WareSortDao;
import cn.tc.ulife.platform.server.shop.entity.ScStoreEntity;
import cn.tc.ulife.platform.server.shop.entity.WareSortEntity;
import cn.tc.ulife.platform.server.shop.page.IntegralWareSortPage;
import cn.tc.ulife.platform.server.shop.page.WareSortPage;
import cn.tc.ulife.platform.server.shop.service.WareSortService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxs
 * @ClassName: WareSortServiceImpl
 * @Description: 商品分类service实现层
 * @date 2017/2/20 14:37
 */
@Service("WareSortService")
public class WareSortServiceImpl implements WareSortService {

    @Autowired
    private WareSortDao wareSortDao;

    @Autowired
    private IntegralWareSortDao integralWareSortDao;

    @Override
    public boolean addWareSortInfo(String account, String app, WareSortPage page) {
        WareSortEntity entity = new WareSortEntity();

        Map<String, Object> map = new HashMap<>();
        map.put("name", page.getName());
        List list = wareSortDao.queryAll(map);
        // 产品线名称若存在不允许插入
        if (list == null || list.size() <= 0) {
            BeanUtils.copyProperties(page, entity);
            wareSortDao.addWareSort(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean delWareSortInfo(String account, String app, String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        wareSortDao.delWareSort(map);

        return true;
    }

    @Override
    public boolean updWareSortInfo(String account, String app, WareSortPage page) {
        WareSortEntity entity = new WareSortEntity();
        Map<String, Object> map = new HashMap<>();
        map.put("id", page.getId());
        WareSortEntity wareSortEntity = wareSortDao.queryWareSortEntity(map);
        // 产品线若不存在不允许修改
        if (wareSortEntity != null) {
            BeanUtils.copyProperties(page, entity);
            wareSortDao.updWareSort(entity);
            return true;
        }
        return false;
    }

    @Override
    public WareSortPage queryWareSortInfo(String account, String app, String id) {
        WareSortPage page = new WareSortPage();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        WareSortEntity entity = wareSortDao.queryWareSortEntity(map);
        BeanUtils.copyProperties(entity, page);
        return page;
    }

    @Override
    public List<WareSortPage> queryAll(String account, String app, String pid, Integer ofset, Integer psize) {
        Map<String, Object> map = new HashMap<>();
        List<WareSortPage> pageList = new ArrayList<WareSortPage>();
        List<WareSortEntity> entityList = new ArrayList<WareSortEntity>();

        map.put("pid", pid);
        map.put("ofset", ofset);
        map.put("psize", psize);

        entityList = wareSortDao.queryAll(map);
        for (WareSortEntity entity : entityList) {
            WareSortPage page = new WareSortPage();
            BeanUtils.copyProperties(entity, page);
            pageList.add(page);
        }
        return pageList;
    }

    @Override
    public String getWareSortTotal(String pid)
    {
        return wareSortDao.getWareSortTotal(pid);
    }

    @Override
    public List<?> listStoreSort(ScStoreEntity storeEntity) {
        return wareSortDao.listStoreSort(storeEntity);
    }

    @Override
    public boolean addIntegralWareSort(IntegralWareSortPage page) {
        integralWareSortDao.insert(page);
        return true;
    }

    @Override
    public boolean delIntegralWareSort(IntegralWareSortPage page) {
        integralWareSortDao.deleteByPrimaryKey(page.getId());
        return true;
    }

    @Override
    public boolean updIntegralWareSort(IntegralWareSortPage page) {
        integralWareSortDao.update(page);
        return true;
    }

    @Override
    public List<IntegralWareSortPage> getIntegralWareSortList(IntegralWareSortPage page) {
        Map<String, Object> map = new HashMap<>();
        map.put("cid", page.getCid());
        return integralWareSortDao.getDataList(map);
    }

    @Override
    public String getIntegralWareSortCount(IntegralWareSortPage page) {
        Map<String, Object> map = new HashMap<>();
        map.put("cid", page.getCid());
        return integralWareSortDao.getDataCount(map);
    }
}
