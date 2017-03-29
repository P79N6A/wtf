package cn.tc.ulife.platform.server.authorization.service.manage.impl;

import cn.tc.ulife.platform.server.authorization.dao.SysRootMapper;
import cn.tc.ulife.platform.server.authorization.model.EntityModel;
import cn.tc.ulife.platform.server.authorization.model.GroupRootRole;
import cn.tc.ulife.platform.server.authorization.model.ResourceFront;
import cn.tc.ulife.platform.server.authorization.model.SysRoot;
import cn.tc.ulife.platform.server.authorization.service.manage.SysRootService;
import cn.tc.ulife.platform.util.jedis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.service.manage.impl
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/14 0014
 * </p>
 * Time: 下午 1:51
 * </p>
 * Detail:
 * </p>
 */
@Service("sysRootService")
public class SysRootServiceImpl implements SysRootService {

    @Autowired
    SysRootMapper sysRootMapper;


    @Override
    public int insertRoot(SysRoot sysRoot) {
        return sysRootMapper.insertRoot(sysRoot);
    }

    @Override
    public SysRoot selectByPrimaryKey(String id) {
        return sysRootMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<GroupRootRole> selectAuthMenuList(String opeid,String uid) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("uid", opeid);
        paramMap.put("authUid", uid);
        return sysRootMapper.selectAuthMenuList(paramMap);
    }

    @RedisCache(key = "LOGIN_MENU_LIST", classType = ResourceFront.class, level = 1, returnType = 1, getType = "2")
    @Override
    public List<ResourceFront> selectUserLoginAuthMenuList(String uid) {

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("uid", uid);
        return sysRootMapper.selectUserLoginAuthMenuList(paramMap);
    }


    @Override
    public EntityModel selectEntityModelByCodeAndUid(String uid, String code, String tableName) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("uid", uid);
        paramMap.put("code", code);
        paramMap.put("tableName", tableName);
        return sysRootMapper.selectEntityModelByCodeAndUid(paramMap);
    }

    @Override
    public GroupRootRole queryResouceRootByCode(String code) {

        return sysRootMapper.queryResouceRootByCode(code);
    }


    @Override
    public EntityModel selectNaturalPersonComm(String uid, String code) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("uid", uid);
        paramMap.put("code", code);
        return sysRootMapper.selectNaturalPersonComm(paramMap);
    }

    @Override
    public List<String> selectGroupRoleByComm(String code, String[] comids) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("comids", comids);
        paramMap.put("code", code);

        return sysRootMapper.selectGroupRoleByComm(paramMap);
    }

    @Override
    public List<GroupRootRole> selectAdminAuthMenuList(String uid) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("uid", uid);
        return sysRootMapper.selectAdminAuthMenuList(paramMap);
    }

    @Override
    public int deleteUserRootByCodeAndUid(String uid, String rcode) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("uid", uid);
        paramMap.put("rcode", rcode);
        sysRootMapper.deleteUserRootByCodeAndUid(paramMap);
        return sysRootMapper.deleteButtonByCodeAndUid(paramMap);
    }

    @Override
    public String queryEntityResId(String tableName, String id) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("tableName", tableName);
        paramMap.put("id", id);
        return sysRootMapper.queryEntityResId(paramMap);
    }

    @Override
    public GroupRootRole queryResouceRootById(String id) {
        return sysRootMapper.queryResouceRootById(id);
    }
}
