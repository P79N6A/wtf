package cn.tc.ulife.platform.agent.controller.authorization;

import cn.tc.ulife.platform.agent.base.BaseController;
import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.server.authorization.model.EntityModel;
import cn.tc.ulife.platform.server.authorization.model.EntityPLineRelation;
import cn.tc.ulife.platform.server.authorization.model.GroupRootRole;
import cn.tc.ulife.platform.server.authorization.model.UserMenuFront;
import cn.tc.ulife.platform.server.authorization.service.AuthorizationService;
import cn.tc.ulife.platform.server.authorization.service.manage.SysUserRootService;
import cn.tc.ulife.platform.util.GsonUtil;
import cn.tc.ulife.platform.util.constance.Constance;
import cn.tc.ulife.platform.util.constance.SysConstance;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.agent.controller.authorization
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/13 0013
 * </p>
 * Time: 上午 10:35
 * </p>
 * Detail:
 * </p>
 */
@RestController
@RequestMapping("/auth")
public class AuthorizationController extends BaseController {


    @Autowired
    AuthorizationService authorizationService;

    @Autowired
    SysUserRootService sysUserRootService;


    /**
     * @param uid    用户id
     * @param comIds 社区id,以","分割
     * @param rcode
     * @param opeId
     * @return
     */
    @RequestMapping("/userBindCommunity")
    public ReturnMsg userAuthCommunity(@RequestParam String uid, @RequestParam String comIds,
                                       @RequestParam String opeId) {
        //TODO 判断操作用户是否登录
//        BaseUser baseUser = new BaseUser();
        String[] comIdArray = comIds.split("\\,");

        if (comIdArray.length > MAX_ADD_SIZE) {
            return AppResponseMsg.faild("最大操作条数不能超过" + MAX_ADD_SIZE);
        }

        authorizationService.bindCommunity(uid, comIdArray, SysConstance.USER.getValue());

        return AppResponseMsg.success("绑定成功");
    }


    /**
     * 绑定菜单
     *
     * @param opeId        操作者id
     * @param uid          被授权的用户id
     * @param menuResource 授权菜单信息
     * @param entity       实体
     * @return
     */
    @RequestMapping("/bindMenu")
    public ReturnMsg bindMenuAndResource(@RequestParam String opeId, @RequestParam String uid
            , @RequestParam String menuResource, String entity) {

        List<UserMenuFront> userMenuFronts = null;
        EntityModel entityModel = null;

        try {
            //转换数据
            Gson gson = new Gson();
            userMenuFronts = gson.fromJson(menuResource, new TypeToken<List<UserMenuFront>>() {
            }.getType());

//            userMenuFronts= GsonUtil.jsonToList(menuResource);

            entityModel = GsonUtil.jsonToObject(entity, EntityModel.class);
        } catch (Exception e) {
            logger.info("数据格式不正确", e);
            return AppResponseMsg.faild("数据格式不正确");

        }
        //表示不能给自己授权
        if (opeId.equals(uid)) {
            return AppResponseMsg.faild("不能给自己授权");
        }
        //开始授权
        if (!CollectionUtils.isEmpty(userMenuFronts)) {
            authorizationService.bindMenuAndResource(uid, opeId, userMenuFronts, entityModel);

            return AppResponseMsg.success("授权成功");
        } else {
            return AppResponseMsg.success("授权菜单为空");
        }
    }


    /**
     * 代理商查询授权菜单
     *
     * @param opeId 登录用户id
     * @param uid   被授权用户id
     * @return
     */
    @RequestMapping("/queryAuthMenu")
    public ReturnMsg queryAuthMenu(String opeId, String uid, String rcode, String entityId) {
        List<GroupRootRole> groupRootRoles = null;
        if (StringUtils.isNotEmpty(entityId) && StringUtils.isNotEmpty(rcode)) {


        } else {
            groupRootRoles = authorizationService.selectAuthMenuList(opeId, uid);
        }
        return AppResponseMsg.success(groupRootRoles);
    }


    /**
     * 实体授权小区
     *
     * @param entityId
     * @param comIds
     * @param rcode
     * @param opeId
     * @return
     */
    @RequestMapping("/entityBindCommunity")
    public ReturnMsg authCommunity(@RequestParam String entityId, @RequestParam String comIds,
                                   @RequestParam String rcode, @RequestParam String opeId) {


        String[] comIdArray = comIds.split("\\,");

        if (comIdArray.length > MAX_ADD_SIZE) {
            return AppResponseMsg.faild("最大操作条数不能超过" + MAX_ADD_SIZE);
        }

        authorizationService.configEntityComm(entityId, comIdArray, rcode, opeId, true);
        return AppResponseMsg.success("绑定成功");
    }

    /**
     * 实体解绑小区
     *
     * @param entityId
     * @param comIds
     * @param rcode
     * @param opeId
     * @return
     */
    @RequestMapping("/entityUnBindCommunity")
    public ReturnMsg unAuthCommunity(@RequestParam String entityId, @RequestParam String comIds,
                                     @RequestParam String rcode, @RequestParam String opeId) {


        String[] comIdArray = comIds.split("\\,");

        if (comIdArray.length > MAX_ADD_SIZE) {
            return AppResponseMsg.faild("最大操作条数不能超过" + MAX_ADD_SIZE);
        }

        authorizationService.configEntityComm(entityId, comIdArray, rcode, opeId, false);
        return AppResponseMsg.success("解绑成功");
    }

    /**
     * 查询授权小区列表
     *
     * @param opeId
     * @param entityId
     * @param rcode
     * @return
     */
    @RequestMapping("/queryAuthComm")
    public ReturnMsg queryAuthCommunityList(@RequestParam String opeId, @RequestParam String entityId
            , @RequestParam String rcode, @RequestParam String areaId) {


        return AppResponseMsg.success(authorizationService.queryAuthCommList(entityId, rcode, areaId));
    }

    /**
     * ??? 页面换了没用了
     *
     * @param opeId
     * @param searchCode
     * @return
     */
    @RequestMapping("/queryEntityList")
    public ReturnMsg queryEntityList(@RequestParam String opeId, String searchCode) {


        List<EntityModel> entityModels = authorizationService.queryEntityList(opeId, "", searchCode);


        return AppResponseMsg.success(entityModels);
    }


    /**
     * 代理商查询产品线
     *
     * @param plRelation {
     *                   uid :   被授权的用户id
     *                   cid :   创建者的id
     *                   }
     * @return
     */
    @RequestMapping("/queryPLineByAgent")
    public ReturnMsg queryProductLineByAgent(@RequestParam String plRelation) {


        //业务对象
        EntityPLineRelation entityPLineRelation = GsonUtil.jsonToObject(plRelation, EntityPLineRelation.class);

        //返回对象
        List<EntityPLineRelation> entityPLineRelations = authorizationService.selectPLineRelationAgent(entityPLineRelation);

        return AppResponseMsg.success(entityPLineRelations);
    }


    @RequestMapping("/authStorePLine")
    public ReturnMsg authStoreProductLine(String cid, @RequestParam String plRelation) {

        Gson gson = new Gson();
        List<EntityPLineRelation> entityPLineRelations = gson.fromJson(plRelation, new TypeToken<List<EntityPLineRelation>>() {
        }.getType());
        if (CollectionUtils.isEmpty(entityPLineRelations)) {

            return AppResponseMsg.faild("数据为空");
        }
        //授权产品线  true 表示只能绑定一条
        authorizationService.bindProductLine(cid, entityPLineRelations, SysConstance.DLS.getValue(), true);

        return AppResponseMsg.success();
    }

    @RequestMapping("/queryAuthStoreComm")
    public ReturnMsg queryAuthStoreComm(@RequestParam String opeId, @RequestParam String entityId
            , @RequestParam String rcode, @RequestParam String areaId) {


        return AppResponseMsg.success(authorizationService.queryStoreAuthCommList(entityId, rcode, areaId));
    }

    @RequestMapping("/authProductLineAgent")
    public ReturnMsg authProductLineAgent(@RequestParam String cid, @RequestParam String plRelation) {

        Gson gson = new Gson();
        List<EntityPLineRelation> entityPLineRelations = gson.fromJson(plRelation, new TypeToken<List<EntityPLineRelation>>() {
        }.getType());
        if (CollectionUtils.isEmpty(entityPLineRelations)) {

            return AppResponseMsg.faild("数据为空");
        }
        //授权产品线
        authorizationService.bindProductLine(cid, entityPLineRelations, SysConstance.SJGLY.getValue(), true);

        return AppResponseMsg.success();
    }

    //  ----------------crm---------

    /**
     * 管理员获取可授权菜单列表
     *
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/queryAuthMenuByAdmin")
    public ReturnMsg queryAuthMenuByAdmin(String opeId, @RequestParam String userId) {


        List<GroupRootRole> groupRootRoles = authorizationService.selectAdminAuthMenuList(opeId, userId);
        return AppResponseMsg.success(groupRootRoles);
    }

    /**
     * 授权产品线
     *
     * @param cid        操作用户id
     * @param plRelation {
     *                   //          id  :   对于已经授权过的产品线是有id标识的
     *                   //          uid :   被授权的用户id
     *                   //          cid :   当前创建人的id
     *                   //          pid :   产品线id
     *                   //          zt  :  0:新增 1：删除
     *                   // }
     * @return
     */
    @RequestMapping("/authProductLine")
    public ReturnMsg authProductLine(@RequestParam String cid, @RequestParam String plRelation) {

        Gson gson = new Gson();
        List<EntityPLineRelation> entityPLineRelations = gson.fromJson(plRelation, new TypeToken<List<EntityPLineRelation>>() {
        }.getType());
        if (CollectionUtils.isEmpty(entityPLineRelations)) {

            return AppResponseMsg.faild("数据为空");
        }
        //授权产品线
        authorizationService.bindProductLine(cid, entityPLineRelations, SysConstance.DLS.getValue(), false);

        return AppResponseMsg.success();
    }



    /**
     * 管理员查询产品线
     *
     * @param plRelation plRelation {
     *                   uid :   被授权的用户id
     *                   cid :   创建者的id
     *                   }
     * @return
     */
    @RequestMapping("/queryPLine")
    public ReturnMsg queryProductLine(@RequestParam String plRelation) {


        //业务对象
        EntityPLineRelation entityPLineRelation = GsonUtil.jsonToObject(plRelation, EntityPLineRelation.class);

        //返回对象
        List<EntityPLineRelation> entityPLineRelations = authorizationService.selectPLineRelation(entityPLineRelation);

        return AppResponseMsg.success(entityPLineRelations);
    }


    /**
     * 绑定菜单
     *
     * @param opeId        操作者id
     * @param uid          被授权的用户id
     * @param menuResource 授权菜单信息
     * @param entity       实体
     * @return
     */
    @RequestMapping("/bindMenuByAdmin")
    public ReturnMsg bindMenuAndResourceByAdmin(@RequestParam String opeId, @RequestParam String uid
            , @RequestParam String menuResource, String entity) {

        List<UserMenuFront> userMenuFronts = null;
        EntityModel entityModel = null;

        try {
            //转换数据
            Gson gson = new Gson();
            userMenuFronts = gson.fromJson(menuResource, new TypeToken<List<UserMenuFront>>() {
            }.getType());

            entityModel = GsonUtil.jsonToObject(entity, EntityModel.class);
        } catch (Exception e) {
            logger.info("数据格式不正确", e);
            return AppResponseMsg.faild("数据格式不正确");

        }

        //开始授权
//        if (!CollectionUtils.isEmpty(userMenuFronts)) {
        Boolean add = false;
        if (!(roleCodeMap.get(entityModel.getRcode()) == (Constance.DEFAULT_TWO))) {
            add = true;
        }
        authorizationService.bindMenuAndResource(uid, opeId, userMenuFronts, entityModel, add);
        return AppResponseMsg.success("授权成功");
//        } else {
//            return AppResponseMsg.success("授权菜单为空");
//        }
    }

    public static void main(String[] args) {

        int shift = 24;
        shift <<= 1;
        System.out.println(shift);
//        List<UserMenuFront> menuFronts = new ArrayList<>();
//        UserMenuFront u1 = new UserMenuFront();
//        u1.setRcode("rcode");
//        u1.setType(" 1：新增 2：删除");
//        u1.setCid("opeId");
//        u1.setRid("rid-菜单id");
//        u1.setUid("被授权的用户id");
//        UserMenuFront u2 = new UserMenuFront();
//        u2.setRcode("rcode");
//        u2.setType(" 1：新增 2：删除");
//        u2.setCid("opeId");
//        u2.setRid("rid-菜单id");
//        u2.setUid("被授权的用户id");
//        ButtonFront b1 = new ButtonFront();
//        b1.setCid("opeId");
//        b1.setUid("被授权的用户id");
//        b1.setRid("rid-菜单id");
//        b1.setType(" 1：新增 2：删除");
//        b1.setAid("按钮id");
//        ButtonFront b2 = new ButtonFront();
//        b2.setCid("opeId");
//        b2.setUid("被授权的用户id");
//        b2.setRid("rid-菜单id");
//        b2.setType(" 1：新增 2：删除");
//        b2.setAid("按钮id");
//        List<ButtonFront> buttonFronts = new ArrayList<>();
//        buttonFronts.add(b1);
//        buttonFronts.add(b2);
//        u2.setButtonFronts(buttonFronts);
//        menuFronts.add(u1);
//        menuFronts.add(u2);
//        System.out.println(GsonUtil.objectToJson(menuFronts));
//
//
////        List<UserMenuFront> menuFronts1 = GsonUtil.jsonToList(n1);
//        Gson gson = new Gson();
//

        String t1 = "[{\"rcode\":\"rcode\",\"uid\":\"被授权的用户id\",\"rid\":\"rid-菜单id\",\"cid\":\"opeId\",\"type\":\" 1：新增 2：删除\"},{\"rcode\":\"rcode\",\"uid\":\"被授权的用户id\",\"rid\":\"rid-菜单id\",\"cid\":\"opeId\",\"type\":\" 1：新增 2：删除\",\"buttonFronts\":[{\"rid\":\"rid-菜单id\",\"uid\":\"被授权的用户id\",\"cid\":\"opeId\",\"aid\":\"按钮id\",\"type\":\" 1：新增 2：删除\"},{\"rid\":\"rid-菜单id\",\"uid\":\"被授权的用户id\",\"cid\":\"opeId\",\"aid\":\"按钮id\",\"type\":\" 1：新增 2：删除\"}]}]";
        List<UserMenuFront> m3 = GsonUtil.jsonToList(t1, new UserMenuFront());
        System.out.println(m3.get(0).getRcode());
//        List<UserMenuFront> menuFronts2 = gson.fromJson(t1, new TypeToken<List<UserMenuFront>>() {
//        }.getType());
//        System.out.println(menuFronts2.get(0).getRcode());


    }
}
