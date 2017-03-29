/**
 * @Title: WareDao
 * @Package cn.tc.ulife.platform.server.ware.dao
 * @Description: 商品模块dao层
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


import cn.tc.ulife.platform.server.shop.entity.RechargeEntity;
import cn.tc.ulife.platform.server.shop.entity.ScAgentEntity;
import cn.tc.ulife.platform.server.shop.entity.ScStoreEntity;
import cn.tc.ulife.platform.server.shop.entity.WareEntity;
import cn.tc.ulife.platform.server.shop.page.RechargePage;
import cn.tc.ulife.platform.server.sys.model.SysAllCodeEntity;
import cn.tc.ulife.platform.server.user.model.StoreEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author cxs
 * @ClassName: WareDao
 * @Description: 商品模块dao层
 * @date 2017/2/20 14:20
 */
public interface WareDao
{

    /**
     * 新增商品信息
     * @param entity
     * @return
     */
    public int addWare(WareEntity entity);

    /**
     * 删除商品信息
     * @param map
     * @return
     */
    public int delWare(Map<String, Object> map);

    /**
     * 删除商品信息
     * @param map
     * @return
     */
    public int delWareList(Map<String, Object> map);

    /**
     * 修改商品信息
     * @param entity
     * @return
     */
    public int updWare(WareEntity entity);/**

     * 修改商品信息列表
     * @param entityList
     * @return
     */
    public int updWareList(List<WareEntity> entityList);

    /**
     * 查询商品信息
     * @param map
     * @return
     */
    public WareEntity queryWareEntity(Map<String, Object> map);

    /**
     * 查询商品信息列表
     * @param map
     * @return
     */
    public List<WareEntity> queryAll(Map<String, Object> map);

    /**
     * 充值商品同步日志表
     * @param entityList
     * @return
     */
    public int addRechargeLogList(List<RechargeEntity> entityList);

    /**
     * 添加充值商品
     * @param entityList
     * @return
     */
    public int addRechargeList(List<RechargeEntity> entityList);

    /**
     * 清空充值商品
     * @return
     */
    public int delRechargeAll();

    /**
     * 充值商品列表
     * @param map
     * @return
     */
    public List<RechargePage> listRecharge(Map<String, Object> map);

    public String countRecharge(Map<String, Object> map);

    /**
     * 获取充值商品的浮动值
     * @return
     */
    public SysAllCodeEntity getRechargeFloat();

    /**
     * 设置充值商品的浮动值
     * @param floatValue
     * @return
     */
    int updRechargeFloat(String floatValue);

    int addRechargeFloat(SysAllCodeEntity entity);

    RechargeEntity getRechargeByKey(Map<String, Object> map);

    int updRecharge(RechargeEntity entity);

    /**
     * 查询登录账号下的商家ID
     * @param map
     * @return 返回多商家已逗号隔开
     */
    String listStoreId(Map<String, Object> map);

    /**
     * 统计商家商品数量
     * @param storeid 商家ID 多商家以逗号隔开，如“1,2,3”
     * @param spxz 商品性质，0：生鲜，1：拼团，2：服务，3：充值，4：宅配，5：积分
     * @return
     */
    String countWare(Map<String, Object> map);

    /**
     * 查询登录账号下的商家
     * @param map
     * @return
     */
    List<StoreEntity> listStore(Map<String, Object> map);

    /**
     * 统计商家商品数量
     * @param uid 代理商ID 多代理商以逗号隔开，如“1,2,3”
     * @param sjxz 商品性质，0：生鲜，1：拼团，2：服务，3：充值，4：宅配，5：积分
     * @return
     */
    String countStore(@Param("uid")String uid, @Param("sjxz")String sjxz);

    List listPLine(@Param("uid")String account, @Param("xqid")String xqid, @Param("ofset")Integer ofset, @Param("psize")Integer psize);

    String getWareType(String flid);

    String getWareStore(String sid);

    List<?> listStoreSort(String account);

    ScStoreEntity getStoreIdByUid(String uid);

    List<?> listAgentCom(@Param("uid")String account, @Param("rcode")String rcode);

    ScAgentEntity getAgentIdByUid(String account);
}
