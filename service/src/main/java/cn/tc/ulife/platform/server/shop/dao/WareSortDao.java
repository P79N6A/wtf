/**
 * @Title: WareDao
 * @Package cn.tc.ulife.platform.server.ware.dao
 * @Description: 商品分类dao层
 * @author cxs
 * @date 2017/2/20 14:20
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.dao;


import cn.tc.ulife.platform.server.shop.entity.ScStoreEntity;
import cn.tc.ulife.platform.server.shop.entity.WareSortEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author cxs
 * @ClassName: WareDao
 * @Description: 商品分类dao层
 * @date 2017/2/20 14:20
 */
public interface WareSortDao {

    /**
     * 新增商品分类信息
     * @param entity
     * @return
     */
    public int addWareSort(WareSortEntity entity);

    /**
     * 删除商品分类信息
     * @param map
     * @return
     */
    public int delWareSort(Map<String, Object> map);

    /**
     * 修改商品分类信息
     * @param entity
     * @return
     */
    public int updWareSort(WareSortEntity entity);

    /**
     * 查询商品分类信息
     * @param map
     * @return
     */
    public WareSortEntity queryWareSortEntity(Map<String, Object> map);

    /**
     * 查询商品分类信息列表
     * @param map
     * @return
     */
    public List<WareSortEntity> queryAll(Map<String, Object> map);

    String getWareSortTotal(@Param("pid")String pid);

    List<?> listStoreSort(ScStoreEntity storeEntity);
}
