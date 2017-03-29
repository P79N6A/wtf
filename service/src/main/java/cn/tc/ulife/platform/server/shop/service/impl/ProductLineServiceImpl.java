/**
 * @Title: ProductLineServiceImpl
 * @Package cn.tc.ulife.platform.server.ware.service.impl
 * @Description: 产品线service实现层
 * @author cxs
 * @date 2017/2/20 14:38
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.service.impl;

import cn.tc.ulife.platform.server.shop.dao.ProductLineDao;
import cn.tc.ulife.platform.server.shop.entity.PLineSpflEntity;
import cn.tc.ulife.platform.server.shop.entity.ProductLineEntity;
import cn.tc.ulife.platform.server.shop.page.ProductLinePage;
import cn.tc.ulife.platform.server.shop.service.ProductLineService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxs
 * @ClassName: ProductLineServiceImpl
 * @Description: 产品线service实现层
 * @date 2017/2/20 14:38
 */
@Service("ProductLineService")
public class ProductLineServiceImpl implements ProductLineService {

    @Autowired
    private ProductLineDao productLineDao;

    @Override
    public boolean addProductLineInfo(String account, String app, ProductLinePage page) {
        ProductLineEntity entity = new ProductLineEntity();

        Map<String, Object> map = new HashMap<>();
        map.put("name", page.getName());
        List list = productLineDao.queryAll(map);
        // 产品线名称若存在不允许插入
        if (list == null || list.size() <= 0) {
            BeanUtils.copyProperties(page, entity);
            productLineDao.addProductLine(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean delProductLineInfo(String account, String app, String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        productLineDao.delProductLine(map);

        return true;
    }

    @Override
    public boolean updProductLineInfo(String account, String app, ProductLinePage page) {
        ProductLineEntity entity = new ProductLineEntity();
        Map<String, Object> map = new HashMap<>();
        map.put("id", page.getId());
        ProductLineEntity productLineEntity = productLineDao.queryProductLineEntity(map);
        // 产品线若不存在不允许修改
        if (productLineEntity != null) {
            BeanUtils.copyProperties(page, entity);
            productLineDao.updProductLine(entity);
            return true;
        }
        return false;
    }

    @Override
    public ProductLinePage queryProductLineInfo(String account, String app, String id) {
        ProductLinePage page = new ProductLinePage();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        ProductLineEntity entity = productLineDao.queryProductLineEntity(map);
        BeanUtils.copyProperties(entity, page);
        return page;
    }

    @Override
    public List<ProductLinePage> queryAll(String account, String app, String name, Integer ofset, Integer psize) {
        Map<String, Object> map = new HashMap<>();
        List<ProductLinePage> pageList = new ArrayList<ProductLinePage>();
        List<ProductLineEntity> entityList = new ArrayList<ProductLineEntity>();

        map.put("name", name);
        map.put("ofset", ofset);
        map.put("psize", psize);

        entityList = productLineDao.queryAll(map);
        for (ProductLineEntity entity : entityList) {
            ProductLinePage page = new ProductLinePage();
            BeanUtils.copyProperties(entity, page);
            pageList.add(page);
        }
        return pageList;
    }

    @Override
    public boolean addPLineWSort(String account, String app, String plid, String flid) {
        List<PLineSpflEntity> addList = new ArrayList<>();
        List<PLineSpflEntity> delList = new ArrayList<>();

        // 查询该产品线已绑定的商品分类
        List<PLineSpflEntity> list = productLineDao.queryPLineSpflList(plid);
        // 重新提交的商品分类
        List<PLineSpflEntity> entityList = new ArrayList<>();
        String[] flids = flid.split(",");

        if (flids.length <= 0) {
            productLineDao.delPLineSpfl(list);
            return true;
        }

        for (String id : flids) {
            PLineSpflEntity entity = new PLineSpflEntity();
            entity.setFlid(id);
            entity.setPlid(plid);
            entityList.add(entity);
        }

        Map<String, Object> map = new HashMap<>();
        for (PLineSpflEntity entity : entityList) {
            map.put(entity.getFlid(), entity);
            // 重新提交的加入新增列表
            addList.add(entity);
        }

        for (PLineSpflEntity entity : list) {
            // 已经绑定的商品分类如果不存在于新增列表，则加入删除列表，反之则从新增列表去除
            if (!map.containsKey(entity.getFlid())) {
                delList.add(entity);
            } else {
                addList.remove(map.get(entity.getFlid()));
            }
        }

        if (CollectionUtils.isNotEmpty(addList)) {
            productLineDao.addPLineSpfl(addList);
        }

        if (CollectionUtils.isNotEmpty(delList)) {
            productLineDao.delPLineSpfl(delList);
        }
        return true;

    }

    @Override
    public String getProductLineTotal()
    {
        return productLineDao.getProductLineTotal();
    }

    @Override
	public List<ProductLineEntity> getLeadProductLineYxTypeTree(ProductLineEntity productLineBean) {
		return this.productLineDao.getLeadProductLineYxTypeTree(productLineBean);
	}

    @Override
    public boolean addPLineUser(String account, String app, String plid, String uid) {
        return productLineDao.addPLineUser(account, plid, uid);
    }
}
