package cn.tc.ulife.platform.server.user.service.manage;

import cn.tc.ulife.platform.server.user.model.StoreEntity;

import java.util.List;
import java.util.Map;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.user.service.manage
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/23 0023
 * </p>
 * Time: 下午 4:09
 * </p>
 * Detail:
 * </p>
 */
public interface StoreEntityService {


    int insertStore(StoreEntity storeEntity);

    StoreEntity selectByPrimaryKey(String id);

    int updateStoreByPrimaryKey(StoreEntity storeEntity);


    List<StoreEntity> selectStore(Map<String, Object> paramMap);

    int selectStoreCount(String cid);

    int checkStoreNameUnique(String name, String id);


}
