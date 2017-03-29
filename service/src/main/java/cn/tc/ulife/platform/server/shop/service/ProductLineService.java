/**
 * @Title: ProductLineService
 * @Package cn.tc.ulife.platform.server.shop.service
 * @Description: 产品线service接口层
 * @author cxs
 * @date 2017/2/20 13:59
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.service;


import cn.tc.ulife.platform.server.shop.entity.ProductLineEntity;
import cn.tc.ulife.platform.server.shop.page.ProductLinePage;

import java.util.List;

/**
 * @author cxs
 * @ClassName: ProductLineService
 * @Description: 产品线service接口层
 * @date 2017/2/20 13:59
 */
public interface ProductLineService {
    /**
     * 增加产品线
     * @param account
     * @param app
     * @param page
     * @return
     */
    public boolean addProductLineInfo(String account, String app, ProductLinePage page);

    /**
     * 删除产品线
     * @param account
     * @param app
     * @param id
     * @return
     */
    public boolean delProductLineInfo(String account, String app, String id);

    /**
     * 修改产品线
     * @param account
     * @param app
     * @param page
     * @return
     */
    public boolean updProductLineInfo(String account, String app, ProductLinePage page);

    /**
     * 查询产品线
     * @param account
     * @param app
     * @param id
     * @return
     */
    public ProductLinePage queryProductLineInfo(String account, String app, String id);

    /**
     * 查询产品线列表
     * @param account
     * @param app
     * @param name
     * @param ofset
     * @param psize
     * @return
     */
    public List<ProductLinePage> queryAll(String account, String app, String name, Integer ofset, Integer psize);

    /**
     * 绑定产品线和商品分类
     * @param account
     * @param app
     * @param plid
     * @param flid
     * @return
     */
    public boolean addPLineWSort(String account, String app, String plid, String flid);


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
     * @param app
     * @param plid
     * @param uid
     * @return
     */
    boolean addPLineUser(String account, String app, String plid, String uid);
}
