/**
 * @Title: ExpressDao
 * @Package cn.tc.ulife.platform.server.express.dao
 * @Description: 快递模块dao层
 * @author alliswell008
 * @date 2017/2/16 14:59
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.dao;

import cn.tc.ulife.platform.server.shop.entity.ExpressEntity;

import java.util.List;
import java.util.Map;

/**
 * @author alliswell008
 * @ClassName: ExpressDao
 * @Description: 快递模块dao层
 * @date 2017/2/16 14:59
 */
public interface ExpressDao {

    /**
     * 新增快递公司信息
     * @param entity
     * @return
     */
    public int addExpressInfo(ExpressEntity entity);

    /**
     * 删除快递公司信息
     * @param map
     * @return
     */
    public int delExpressInfo(Map<String, Object> map);

    /**
     * 修改快递公司信息
     * @param entity
     * @return
     */
    public int updExpressInfo(ExpressEntity entity);

    /**
     * 查询快递公司信息
     * @param map
     * @return
     */
    public ExpressEntity queryExpressEntity(Map<String, Object> map);

    /**
     * 查询快递公司信息列表
     * @param map
     * @return
     */
    public List<ExpressEntity> queryAll(Map<String, Object> map);


}
