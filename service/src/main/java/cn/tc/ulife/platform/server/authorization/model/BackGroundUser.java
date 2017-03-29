package cn.tc.ulife.platform.server.authorization.model;

import cn.tc.ulife.platform.server.user.model.UserFront;
import cn.tc.ulife.platform.util.GsonUtil;
import cn.tc.ulife.platform.util.UtilToString;
import cn.tc.ulife.platform.util.constance.CacheConstance;
import cn.tc.ulife.platform.util.constance.SysConstance;
import cn.tc.ulife.platform.util.jedis.JedisProxy;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.user.model
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/21 0021
 * </p>
 * Time: 上午 10:45
 * </p>
 * Detail:
 * </p>
 */
public class BackGroundUser extends UserFront {


//

    /**
     * 菜单按钮
     */
    private List<ResourceFront> resouceFronts;


    /**
     * 商家实体
     */
    @JsonIgnore
    private EntityModel storeEntity;

    /**
     * 物业实体
     */
    @JsonIgnore
    private EntityModel propertyEntity;


    /**
     * 小站实体
     */
    @JsonIgnore
    private EntityModel smallStationEntity;

    /**
     * 代理商
     */
    @JsonIgnore
    private EntityModel agentEntity;

    /**
     * 自然人
     */
    @JsonIgnore
    private EntityModel naturalPerson;


    public void setCache() {
       // super.setCache();

        if (null != this.storeEntity) {
            new JedisProxy().getJedisProxy().hset(CacheConstance.USER_STORE_KEY, this.getId(), GsonUtil.objectToJson(this.storeEntity));
        }
        if (null != this.propertyEntity) {
            new JedisProxy().getJedisProxy().hset(CacheConstance.USER_PROPERTY_KEY, this.getId(), GsonUtil.objectToJson(this.propertyEntity));
        }
        if (null != this.smallStationEntity) {
            new JedisProxy().getJedisProxy().hset(CacheConstance.USER_STATION_KEY, this.getId(), GsonUtil.objectToJson(this.smallStationEntity));
        }
        if (null != this.agentEntity) {
            new JedisProxy().getJedisProxy().hset(CacheConstance.USER_AGENT_KEY, this.getId(), GsonUtil.objectToJson(this.agentEntity));
        }
        if (null != this.naturalPerson) {
            new JedisProxy().getJedisProxy().hset(CacheConstance.USER_NATURAL_KEY, this.getId(), GsonUtil.objectToJson(this.agentEntity));
        }
        if (null != this.resouceFronts) {
            new JedisProxy().getJedisProxy().hset(CacheConstance.USER_MENU_KEY, this.getId(), GsonUtil.objectToJson(this.resouceFronts));
        }
    }

    public EntityModel getNaturalPerson() {
        return naturalPerson;
    }

    public void setNaturalPerson(EntityModel naturalPerson) {
        this.naturalPerson = naturalPerson;
    }

    public List<ResourceFront> getResouceFronts() {
        return resouceFronts;
    }

    public void setResouceFronts(List<ResourceFront> resouceFronts) {
        this.resouceFronts = resouceFronts;
    }

    public EntityModel getStoreEntity() {
        return storeEntity;
    }


    public EntityModel getPropertyEntity() {
        return propertyEntity;
    }


    public EntityModel getSmallStationEntity() {
        return smallStationEntity;
    }


    public void setEntityModel(String code, EntityModel entityModel) {
        if (code.equals(SysConstance.SJGLY.getValue())) {
            this.storeEntity = entityModel;
        } else if (code.equals(SysConstance.XZGLY.getValue())) {
            this.smallStationEntity = entityModel;
        } else if (code.equals(SysConstance.WYGLY.getValue())) {
            this.propertyEntity = entityModel;
        } else if (code.equals(SysConstance.DLS.getValue())) {
            this.agentEntity = entityModel;
        }
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
