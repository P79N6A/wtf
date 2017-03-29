package cn.tc.ulife.platform.server.shop.dao;


import cn.tc.ulife.platform.server.shop.page.IntegralWareSortPage;

import java.util.List;
import java.util.Map;

public interface IntegralWareSortDao {


    /**
     * 新增积分商品分类
     * @param page
     */
    public void insert(IntegralWareSortPage page);

    /**
     * 删除积分商品分类
     * @param id
     */
    public void deleteByPrimaryKey(String id);

    /**
     * 修改积分商品分类
     * @param page
     */
    public void update(IntegralWareSortPage page);

    /**
     * 获取积分商品分类
     * @param id
     */
    public IntegralWareSortPage getDataById(String id);

    /**
     * 获取积分商品分类
     * @param page
     */
    public IntegralWareSortPage getData(IntegralWareSortPage page);

    /**
     * 获取积分商品分类列表
     * @param map
     */
    public List<IntegralWareSortPage> getDataList(Map<String, Object> map);

    /**
     * 获取积分商品分类数量
     * @param map
     */
    public String getDataCount(Map<String, Object> map);

    String getWareType(String flid);

    String getWareStore(String sid);
}
