/**
 * @Title: WareService
 * @Package cn.tc.ulife.platform.server.ware
 * @Description: 商品service接口层
 * @author cxs
 * @date 2017/2/20 14:03
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.service;

import cn.tc.ulife.platform.server.shop.entity.ScAgentEntity;
import cn.tc.ulife.platform.server.shop.entity.ScStoreEntity;
import cn.tc.ulife.platform.server.shop.model.RechareDTO;
import cn.tc.ulife.platform.server.shop.page.RechargePage;
import cn.tc.ulife.platform.server.shop.page.WarePage;
import cn.tc.ulife.platform.server.user.model.StoreEntity;

import java.util.List;

/**
 * @author cxs
 * @ClassName: WareService
 * @Description: 商品service接口层
 * @date 2017/2/20 14:03
 */
public interface WareService {

    /**
     * 增加商品
     * @param account
     * @param app
     * @param page
     * @return
     */
    public boolean addWareInfo(String account, String app, WarePage page);

    /**
     * 删除商品
     * @param account
     * @param app
     * @param id
     * @return
     */
    public boolean delWareInfo(String account, String app, String id);

    /**
     * 修改商品
     * @param account
     * @param app
     * @param page
     * @return
     */
    public boolean updWareInfo(String account, String app, WarePage page);

    /**
     * 查询商品
     * @param account
     * @param app
     * @param id
     * @return
     */
    public WarePage queryWareInfo(String account, String app, String id, String type);

    /**
     * 查询商品列表
     * @param account
     * @param app
     * @param type 用户类型，0：平台管理员，1：代理商，2：商家
     * @param spxz 商品性质，0：生鲜，1：拼团，2：服务，3：充值，4：宅配，5：积分
     * @param ofset
     * @param psize
     * @return
     */
    public List<WarePage> queryAll(String account, String app, String type, String spxz, WarePage page, Integer ofset, Integer psize);

    boolean shelveWare(String account, String app, String spid, String issj, String spxz);

    boolean delPicture(String account, String app, String id);

    boolean shelveSpecification(String account, String app, String ggid, String issj, String spxz);

    boolean auditWare(String account, String app, String spid);

    boolean syncRecharge(String uid);

    List<RechargePage> listRecharge(String uid, String recsprice, Integer ofset, Integer psize);

    boolean saveRecharge(List<RechareDTO> rechareList, String uid);

    String countRecharge(String recsprice);

    boolean saveRechargeFloat(String uid, String floatValue);

    String countWare(String uid, String roleType, String spxz, WarePage page);

    List<StoreEntity> listStore(String account, String app, String type, String sjxz, Integer ofset, Integer psize);

    String countStore(String account, String type, String sjxz);

    List listPLine(String account, String xqid, Integer ofset, Integer psize);

    ScStoreEntity getStoreIdByUid(String account);

    List<?> listAgentCom(String account);

    ScAgentEntity getAgentIdByUid(String account);
}
