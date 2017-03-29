package cn.tc.ulife.platform.server.user.service.impl;

import cn.tc.ulife.platform.server.authorization.model.EntityModel;
import cn.tc.ulife.platform.server.authorization.model.ResourceFront;
import cn.tc.ulife.platform.server.user.model.UserFront;
import cn.tc.ulife.platform.server.user.service.UserCacheService;
import cn.tc.ulife.platform.util.GsonUtil;
import cn.tc.ulife.platform.util.constance.CacheConstance;
import cn.tc.ulife.platform.util.jedis.JedisProxy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.user.service.impl
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/3/3 0003
 * </p>
 * Time: 下午 12:23
 * </p>
 * Detail:
 * </p>
 */
@Service("userCacheService")
public class UserCacheServiceImpl implements UserCacheService {

    @Override
    public EntityModel getStoreInfo(String uid) {
        return GsonUtil.jsonToObject(new JedisProxy().getJedisProxy()
                .hget(CacheConstance.USER_STORE_KEY, uid), EntityModel.class);
    }

    @Override
    public EntityModel getAgentInfo(String uid) {
        return GsonUtil.jsonToObject(new JedisProxy().getJedisProxy()
                .hget(CacheConstance.USER_AGENT_KEY, uid), EntityModel.class);
    }

    @Override
    public EntityModel getPropertyInfo(String uid) {
        return GsonUtil.jsonToObject(new JedisProxy().getJedisProxy()
                .hget(CacheConstance.USER_PROPERTY_KEY, uid), EntityModel.class);
    }

    @Override
    public EntityModel getSmallStationInfo(String uid) {
        return GsonUtil.jsonToObject(new JedisProxy().getJedisProxy()
                .hget(CacheConstance.USER_STATION_KEY, uid), EntityModel.class);
    }

    @Override
    public EntityModel getNaturalPersonInfo(String uid) {
        return GsonUtil.jsonToObject(new JedisProxy().getJedisProxy()
                .hget(CacheConstance.USER_NATURAL_KEY, uid), EntityModel.class);
    }

    @Override
    public UserFront getUserInfo(String uid) {
        return GsonUtil.jsonToObject(new JedisProxy().getJedisProxy()
                .hget(CacheConstance.USER_INFO_KEY, uid), UserFront.class);
    }

    @Override
    public List<ResourceFront> getResourceFront(String uid) {
        Gson gson = new Gson();
        return gson.fromJson(new JedisProxy().getJedisProxy()
                .hget(CacheConstance.USER_MENU_KEY, uid), new TypeToken<List<ResourceFront>>() {
        }.getType());

    }
}
