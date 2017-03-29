package cn.tc.ulife.platform.server.user.service;

import cn.tc.ulife.platform.server.authorization.model.EntityModel;
import cn.tc.ulife.platform.server.authorization.model.ResourceFront;
import cn.tc.ulife.platform.server.user.model.UserFront;

import java.util.List;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.user
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/3/3 0003
 * </p>
 * Time: 下午 12:17
 * </p>
 * Detail:
 * </p>
 */
public interface UserCacheService {

    /**
     * 获取当前用户关联商家实体信息
     *
     * @param uid
     * @return
     */
    EntityModel getStoreInfo(String uid);

    /**
     * 获取当前用户关联代理商实体信息
     *
     * @param uid
     * @return
     */
    EntityModel getAgentInfo(String uid);

    /**
     * 获取当前用户关联物业实体信息
     *
     * @param uid
     * @return
     */
    EntityModel getPropertyInfo(String uid);

    /**
     * 获取当前用户关联小站信息
     *
     * @param uid
     * @return
     */
    EntityModel getSmallStationInfo(String uid);

    /**
     * 获取当前用户对应人物信息(如财务这种直接使用用户信息的类型)
     *
     * @param uid
     * @return
     */
    EntityModel getNaturalPersonInfo(String uid);


    /**
     * 获取当前用户基础信息
     *
     * @param uid
     * @return
     */
    UserFront getUserInfo(String uid);

    /**
     * 获取当前用户菜单信息
     *
     * @param uid
     * @return
     */
    List<ResourceFront> getResourceFront(String uid);
}
