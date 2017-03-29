/**
 * @Title: WareSortService
 * @Package cn.tc.ulife.platform.server.shop.service
 * @Description: 商品分类service接口层
 * @author cxs
 * @date 2017/2/20 13:52
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.service;

import cn.tc.ulife.platform.server.shop.entity.ScStoreEntity;
import cn.tc.ulife.platform.server.shop.page.IntegralWareSortPage;
import cn.tc.ulife.platform.server.shop.page.WareSortPage;

import java.util.List;

/**
 * @author cxs
 * @ClassName: WareSortService
 * @Description: 商品分类service接口层
 * @date 2017/2/20 13:52
 */
public interface WareSortService {

    /**
     * 增加商品分类
     * @param account
     * @param app
     * @param page
     * @return
     */
    public boolean addWareSortInfo(String account, String app, WareSortPage page);

    /**
     * 删除商品分类
     * @param account
     * @param app
     * @param id
     * @return
     */
    public boolean delWareSortInfo(String account, String app, String id);

    /**
     * 修改商品分类
     * @param account
     * @param app
     * @param page
     * @return
     */
    public boolean updWareSortInfo(String account, String app, WareSortPage page);

    /**
     * 查询商品分类
     * @param account
     * @param app
     * @param id
     * @return
     */
    public WareSortPage queryWareSortInfo(String account, String app, String id);

    /**
     * 查询商品分类列表
     * @param account
     * @param app
     * @param pid
     * @param ofset
     * @param psize
     * @return
     */
    public List<WareSortPage> queryAll(String account, String app, String pid, Integer ofset, Integer psize);

    /**
     * 查询子分类条数
     * @param pid
     * @return
     */
    public String getWareSortTotal(String pid);

    /**
     * 查询商家分类列表
     * @param storeEntity
     * @return
     */
    public List<?> listStoreSort(ScStoreEntity storeEntity);

    /**
     * 增加积分商品分类
     * @param page
     */
    public boolean addIntegralWareSort(IntegralWareSortPage page);

    /**
     * 删除积分商品分类
     * @param page
     */
    public boolean delIntegralWareSort(IntegralWareSortPage page);

    /**
     * 修改积分商品分类
     * @param page
     */
    public boolean updIntegralWareSort(IntegralWareSortPage page);

    /**
     * 获取积分商品分类列表
     * @param page
     */
    public List<IntegralWareSortPage> getIntegralWareSortList(IntegralWareSortPage page);

    /**
     * 获取积分商品分类条数
     * @param page
     * @return
     */
    public String getIntegralWareSortCount(IntegralWareSortPage page);
}
