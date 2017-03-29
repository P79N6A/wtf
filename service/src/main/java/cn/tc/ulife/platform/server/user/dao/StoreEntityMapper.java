package cn.tc.ulife.platform.server.user.dao;

import cn.tc.ulife.platform.server.user.model.StoreEntity;

import java.util.List;
import java.util.Map;

public interface StoreEntityMapper {


    int insertStore(StoreEntity storeEntity);

    StoreEntity selectByPrimaryKey(String id);

    int updateStoreByPrimaryKey(StoreEntity storeEntity);


    List<StoreEntity> selectStore(Map<String, Object> paramMap);

    int selectStoreCount(String cid);

    int checkStoreNameUnique(Map<String, String> paramMap);


}