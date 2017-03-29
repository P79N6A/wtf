package cn.tc.ulife.platform.server.user.service.manage.impl;

import cn.tc.ulife.platform.server.user.dao.StoreEntityMapper;
import cn.tc.ulife.platform.server.user.model.StoreEntity;
import cn.tc.ulife.platform.server.user.service.manage.StoreEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.user.service.manage.impl
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/23 0023
 * </p>
 * Time: 下午 4:10
 * </p>
 * Detail:
 * </p>
 */
@Service("storeEntityService")
public class StoreEntityServiceImpl implements StoreEntityService {

    @Autowired
    StoreEntityMapper storeEntityMapper;

    @Override
    public int insertStore(StoreEntity storeEntity) {
        return storeEntityMapper.insertStore(storeEntity);
    }

    @Override
    public StoreEntity selectByPrimaryKey(String id) {
        return storeEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateStoreByPrimaryKey(StoreEntity storeEntity) {
        return storeEntityMapper.updateStoreByPrimaryKey(storeEntity);
    }

    @Override
    public List<StoreEntity> selectStore(Map<String, Object> paramMap) {
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("ofset", ofest);
//        paramMap.put("psize", psize);
        return storeEntityMapper.selectStore(paramMap);
    }

    @Override
    public int selectStoreCount(String cid) {
        return storeEntityMapper.selectStoreCount(cid);
    }


    @Override
    public int checkStoreNameUnique(String name, String id) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("name", name);
        paramMap.put("id", id);
        return storeEntityMapper.checkStoreNameUnique(paramMap);
    }
}
