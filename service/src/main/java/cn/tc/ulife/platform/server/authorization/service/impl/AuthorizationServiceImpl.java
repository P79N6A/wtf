package cn.tc.ulife.platform.server.authorization.service.impl;

import cn.tc.ulife.platform.server.authorization.model.*;
import cn.tc.ulife.platform.server.authorization.service.AuthorizationService;
import cn.tc.ulife.platform.server.authorization.service.manage.*;
import cn.tc.ulife.platform.server.exception.PageException;
import cn.tc.ulife.platform.server.user.model.StoreEntity;
import cn.tc.ulife.platform.server.user.model.UserFront;
import cn.tc.ulife.platform.server.user.service.manage.StoreEntityService;
import cn.tc.ulife.platform.util.constance.Constance;
import cn.tc.ulife.platform.util.constance.SysConstance;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.service.impl
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/13 0013
 * </p>
 * Time: 上午 10:32
 * </p>
 * Detail:
 * </p>
 */
@Service("authorizationService")
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    SysUrcomService sysUrcomService;


    @Autowired
    SysUserRootService sysUserRootService;


    @Autowired
    SysUrActionService sysUrActionService;


    @Autowired
    SysRootService sysRootService;

    @Autowired
    EntityPLineRelationService entityPLineRelationService;

    @Autowired
    StoreEntityService storeEntityService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int bindCommunity(String uid, String[] comIds, String rcode) {
        SysUrcom sysUrcom = new SysUrcom();
        for (String comId : comIds) {


            sysUrcom.setComId(comId);
            sysUrcom.setRcode(rcode);
            sysUrcom.setUid(uid);
            sysUrcom.setIsDef("0");
            sysUrcom.setIsReg("0");
            List<SysUrcom> sysUrcoms = sysUrcomService.selectByKey(sysUrcom);
            if (null == sysUrcomService.selectByKey(sysUrcom) || sysUrcoms.size() == 0) {

                sysUrcomService.insertSysUrcom(sysUrcom);
            }
        }
        return 0;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int bindMenuAndResource(String uid, String opId, List<UserMenuFront> userMenuFronts) {
//        List<GroupRootRole> groupRootRoles = sysRootService.selectAuthMenuList(uid);

        //因为页面设计的是一组资源,所以菜单里任意一个元素的code都是一致的
        UserMenuFront rcodeMenuFront = userMenuFronts.get(0);
        //先删除所有绑定的资源
        sysRootService.deleteUserRootByCodeAndUid(uid, rcodeMenuFront.getRcode());


        //如果菜单为空表示全部删除
        if (CollectionUtils.isEmpty(userMenuFronts)) {
            return 0;
        }
        for (UserMenuFront userMenuFront : userMenuFronts) {

            //判断资源是否可以下发
            checkRootBind(userMenuFront, opId);

            userMenuFront.setUid(uid);
            userMenuFront.setCid(opId);


            //新增
//            if (Constance.DEFAULT_ONE.equals(userMenuFront.getType())) {
            sysUserRootService.insertRoot(userMenuFront);

            if (CollectionUtils.isEmpty(userMenuFront.getButtonFronts())) {
                continue;
            }
            for (ButtonFront buttonFront : userMenuFront.getButtonFronts()) {
                buttonFront.setRid(userMenuFront.getRid());
                buttonFront.setUid(uid);
                //新增按钮
                if (Constance.DEFAULT_ONE.equals(buttonFront.getType())) {

                    buttonFront.setCid(opId);
                    sysUrActionService.insertButton(buttonFront);
                }

            }


        }
        return 0;
    }

    @Override
    public List<GroupRootRole> selectAuthMenuList(String opeId, String uid) {

        return sysRootService.selectAuthMenuList(opeId, uid);
    }

    @Override
    public List<GroupRootRole> selectAdminAuthMenuList(String opeId, String userId) {
        return sysRootService.selectAdminAuthMenuList(userId);
    }

    @Override
    public int bindMenuAndResource(String uid, String opId, List<UserMenuFront> userMenuFronts, EntityModel entityModel) {


        //授权
        bindMenuAndResource(uid, opId, userMenuFronts);


        //判断是否有对应表名,如果有判断是否已经创建过
        if (null != entityModel.getTableName()) {

            int checkStatus = sysUserRootService.checkUserIsBind(uid, entityModel.getTableName(), entityModel.getRcode());
            //表示已经创建过实体只是修改实体菜单权限
            if (checkStatus > 0) {
                return 0;
            }

        }

        //新建
        if (!StringUtils.isNotEmpty(entityModel.getId())) {
            entityModel.setAddress(uid);
            entityModel.setName(uid);
            entityModel.setPhone(uid);
            entityModel.setCid(opId);
            //设置第一个实体绑定人为负责人
            entityModel.setResponsible(uid);
            //新增实体
            sysUserRootService.insertEntity(entityModel);


            //TODO 页面分开做了,暂时取消,做另外的判断
            //绑定实体与社区关系
//            for (String comId : entityModel.getComIds()) {
//                entityModel.setComId(comId);
//                sysUserRootService.insertUserComEntity(entityModel);
//            }

        }


        //绑定实体与负责人关系
        Map<String, String> userEntity = new HashMap<>();
        userEntity.put("uid", uid);
        userEntity.put("oid", entityModel.getId());
        userEntity.put("rcode", entityModel.getRcode());
        sysUserRootService.insertUserEntity(userEntity);
        return 0;
    }


    @Override
    public List<EntityModel> queryEntityList(UocomEntity opeUocomEntity, UocomEntity useUocomEntity) {

////        //通过操作人id和资源类型找出拥有社区资源
//        List<String> comIds = sysUserRootService.selectUocomComidsByKey(opeUocomEntity);
////
//        //通过社区和类型找出绑定实体对象
//        useUocomEntity.setComids(comIds);
//        List<String> ids = sysUserRootService.selectUocomOidByKey(useUocomEntity);

        //获取对应类型绑定表名
        GroupRootRole groupRootRole = sysRootService.queryResouceRootByCode(useUocomEntity.getRcode());


        if (null == groupRootRole) {

            if (Constance.DEFAULT_ZERO.equals(groupRootRole.getCreateTable())) {


                //自然人资源
                return sysUserRootService.selectNaturalPersonByIds(useUocomEntity.getRcode(), opeUocomEntity.getOid());
            } else {
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("cid", opeUocomEntity.getOid());
                //获取实体资源
                paramMap.put("tableName", Constance.DEFAULT_ENTITY_TABLE);
                return sysUserRootService.selectEntityModelByPrimaryKey(paramMap);
            }

        } else {
            return null;
        }
        //返回对应的实体列表

    }

    @Override
    public List<EntityModel> queryEntityList(String opeUid, String opeCode, String code) {
        //操作人对象
        UocomEntity opeUocomEntity = new UocomEntity();
        opeUocomEntity.setOid(opeUid);
        opeUocomEntity.setRcode(opeCode);

        //查询资源类型
        UocomEntity uocomEntity = new UocomEntity();
        uocomEntity.setRcode(code);

        return queryEntityList(opeUocomEntity, uocomEntity);
    }


    @Transactional
    @Override
    public int bindEntityComm(String entityId, String[] comIds, String rcode, String opeId) {

        GroupRootRole groupRootRole = sysRootService.queryResouceRootByCode(rcode);

        //表示一个社区只能同时存在一个资源组
        if (Constance.DEFAULT_ONE.equals(groupRootRole.getChangeShare())) {
            List<String> commNames = sysRootService.selectGroupRoleByComm(rcode, comIds);
            if (null != commNames && commNames.size() > 0) {

                //TODO logger  表示已经该小区已经拥有该资源了


                throw new PageException(commNames.toString() + "已经有相同角色:" + rcode + "绑定");
            }
        }

        UocomEntity uocomEntity = new UocomEntity();
        uocomEntity.setOid(entityId);
        uocomEntity.setRcode(rcode);
        uocomEntity.setCid(opeId);
        for (String comId : comIds) {

            uocomEntity.setComid(comId);
            sysUserRootService.insertUserComEntity(uocomEntity);
        }
        return 0;
    }


    @Override
    public BackGroundUser getLoginAttr(UserFront baseUser) {
        BackGroundUser backGroundUser = new BackGroundUser();
        try {
            BeanUtils.copyProperties(backGroundUser, baseUser);
        } catch (Exception e) {
            return null;
        }
        //获取菜单,按钮
        List<ResourceFront> resouceFronts = sysRootService.selectUserLoginAuthMenuList(baseUser.getId());

//        new JedisProxy().getJedisProxy().hset()

        backGroundUser.setResouceFronts(resouceFronts);
        //获取资源组类型
        Set<String> codeSet = new HashSet<>();
        for (ResourceFront resouceFront : resouceFronts) {
            //获取id --应该是获取code
            codeSet.add(resouceFront.getResouceGroupId());
        }

        for (String code : codeSet) {
            GroupRootRole rootRole = sysRootService.queryResouceRootById(code);
            if (null == rootRole) {
                continue;
            } else {
                if (Constance.DEFAULT_ZERO.equals(rootRole.getCreateTable())) {
                    //根据拥有资源组类型去寻找对应实体对象属性及社区绑定
                    EntityModel entityModel = sysRootService.selectEntityModelByCodeAndUid(baseUser.getId(), rootRole.getRoleCode(), rootRole.getTableName());
                    backGroundUser.setEntityModel(rootRole.getRoleCode(), entityModel);

                } else {

                    EntityModel entityModel = sysRootService.selectNaturalPersonComm(baseUser.getId(), rootRole.getRoleCode());
                    backGroundUser.setNaturalPerson(entityModel);
                }
            }

        }

        return backGroundUser;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int bindProductLine(String cid, List<EntityPLineRelation> pLineRelations, String rcode, Boolean flag) {

        int maxSize = 0;
        for (EntityPLineRelation entityPLineRelation : pLineRelations) {
            //新增
            if (Constance.DEFAULT_ZERO.equals(entityPLineRelation.getZt())) {
                maxSize++;
                entityPLineRelation.setCid(cid);
                entityPLineRelation.setRcode(rcode);

                if (flag) {
                    if (maxSize > 1) {
                        throw new PageException("只能绑定一条产品线");
                    }
                    int maxCount = entityPLineRelationService.queryPLRelationExit(entityPLineRelation.getUid());
                    if (maxCount > 0) {
                        throw new PageException("只能绑定一条产品线");
                    }
                }

                int count = entityPLineRelationService.checkPLisExit(entityPLineRelation);
                if (count > 0) {
                    entityPLineRelationService.updatePLRelationByPrimaryKey(entityPLineRelation);
                } else {
                    entityPLineRelationService.insertPLRelation(entityPLineRelation);
                }


            }
            //不是新增就是删除
            else {
                entityPLineRelation.setCid(cid);
                entityPLineRelation.setRcode(rcode);
                entityPLineRelationService.delectPlByKey(entityPLineRelation);

            }
        }


        return 0;
    }


    @Override
    public List<EntityPLineRelation> selectPLineRelation(EntityPLineRelation entityPLineRelation) {


        return entityPLineRelationService.selectPLineRelation(entityPLineRelation);
    }


    @Override
    public int bindMenuAndResource(String uid, String opId, List<UserMenuFront> userMenuFronts,
                                   EntityModel entityModel, Boolean add) {
        // 如果为true表示不需要创建实体 ---目前适用场景有管理员给代理商授权商家,物业等需要创建实体的菜单
        if (add) {
            //授权
            bindMenuAndResource(uid, opId, userMenuFronts);
        } else {
            //授权加绑定实体
            bindMenuAndResource(uid, opId, userMenuFronts, entityModel);
        }
        return 0;
    }


    @Override
    public List<AuthCommModel> queryAuthCommList(String entityId, String rcode, String areaId) {
        return sysUrcomService.queryAuthCommList(rcode, entityId, areaId);
    }


    @Transactional
    @Override
    public int configEntityComm(String entityId, String[] comIds, String rcode, String opeId, Boolean check) {

        if (check) {
            //绑定社区
            bindEntityComm(entityId, comIds, rcode, opeId);

        } else {
            UocomEntity uocomEntity = new UocomEntity();
            uocomEntity.setOid(entityId);
            uocomEntity.setRcode(rcode);
            uocomEntity.setCid(opeId);
            for (String comId : comIds) {
                uocomEntity.setComid(comId);
                sysUserRootService.deleteCommRelation(uocomEntity);
            }
        }
        return 0;
    }


    @Override
    public List<AuthCommModel> queryStoreAuthCommList(String entityId, String rcode, String areaId) {
        return sysUrcomService.queryStoreAuthCommList(rcode, entityId, areaId);
    }

    @Override
    public List<EntityPLineRelation> selectPLineRelationAgent(EntityPLineRelation entityPLineRelation) {
        return entityPLineRelationService.selectPLineRelationAgent(entityPLineRelation);
    }

    /**
     * @param userMenuFront
     */
    private void checkRootBind(UserMenuFront userMenuFront, String opId) {
        SysRoot sysRoot = sysRootService.selectByPrimaryKey(userMenuFront.getRid());
        if (null != sysRoot) {
            if (sysRoot.getIssued().equals("1")) {

                throw new PageException(sysRoot.getName() + "不可下发");

            } else if (sysRoot.getIssued().equals("2")) {
                //TODO 暂时不判断
            }
        }
    }

    public static void main(String[] args) {

    }
}
