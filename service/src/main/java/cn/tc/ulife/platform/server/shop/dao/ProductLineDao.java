/**
 * @Title: WareDao
 * @Package cn.tc.ulife.platform.server.ware.dao
 * @Description: 产品线管理dao层
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

import cn.tc.ulife.platform.server.shop.entity.PLineSpflEntity;
import cn.tc.ulife.platform.server.shop.entity.ProductLineEntity;

import java.util.List;
import java.util.Map;

/**
 * @author cxs
 * @ClassName: WareDao
 * @Description: 产品线管理dao层
 * @date 2017/2/20 14:20
 */
public interface ProductLineDao {

    /**
     * 新增产品线信息
     * @param entity
     * @return
     */
    public int addProductLine(ProductLineEntity entity);

    /**
     * 删除产品线信息
     * @param map
     * @return
     */
    public int delProductLine(Map<String, Object> map);

    /**
     * 修改产品线信息
     * @param entity
     * @return
     */
    public int updProductLine(ProductLineEntity entity);

    /**
     * 查询产品线信息
     * @param map
     * @return
     */
    public ProductLineEntity queryProductLineEntity(Map<String, Object> map);

    /**
     * 查询产品线信息列表
     * @param map
     * @return
     */
    public List<ProductLineEntity> queryAll(Map<String, Object> map);

    /**
     * 产品线绑定商品分类
     * @param entity
     * @return
     */
    public int addPLineSpfl(List<PLineSpflEntity> entity);

    /**
     * 删除产品线与商品分类的绑定关系
     * @param entity
     * @return
     */
    public int delPLineSpfl(List<PLineSpflEntity> entity);

    /**
     * 查询产品线与商品分类的绑定关系
     * @param plid
     * @return
     */
    public List<PLineSpflEntity> queryPLineSpflList(String plid);

    String getProductLineTotal();

    /**
     * 查询当前用户的产品线
     * 日期 2017年2月24日
     * 时间 下午3:32:18
     * 创建者 Lcc
     * @param productLineBean
     * @return
     */
    public List<ProductLineEntity> getLeadProductLineYxTypeTree(ProductLineEntity productLineBean);

    /**
     * 绑定产品线和用户
     * @param account
     * @param plid
     * @param uid
     * @return
     */
    boolean addPLineUser(String account, String plid, String uid);
}
