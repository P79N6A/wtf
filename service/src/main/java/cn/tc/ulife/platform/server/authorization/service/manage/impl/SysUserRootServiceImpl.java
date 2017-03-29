package cn.tc.ulife.platform.server.authorization.service.manage.impl;

import cn.tc.ulife.platform.server.authorization.dao.SysUserRootMapper;
import cn.tc.ulife.platform.server.authorization.model.EntityModel;
import cn.tc.ulife.platform.server.authorization.model.UocomEntity;
import cn.tc.ulife.platform.server.authorization.model.UserMenuFront;
import cn.tc.ulife.platform.server.authorization.service.manage.SysUserRootService;
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
 * Time: 上午 10:34
 * </p>
 * Detail:
 * </p>
 */
@Service("sysUserRootService")
public class SysUserRootServiceImpl implements SysUserRootService {

    @Autowired
    SysUserRootMapper sysUserRootMapper;


    @Override
    public int deleteByPrimaryKey(String id) {
        return sysUserRootMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertRoot(UserMenuFront userMenuFront) {
        return sysUserRootMapper.insertRoot(userMenuFront);
    }

    @Override
    public UserMenuFront selectByPrimaryKey(String id) {
        return sysUserRootMapper.selectByPrimaryKey(id);
    }


    @Override
    public int insertEntity(EntityModel entityModel) {
        return sysUserRootMapper.insertEntity(entityModel);
    }

    @Override
    public int insertUserEntity(Map<String, String> userEntityMap) {
        return sysUserRootMapper.insertUserEntity(userEntityMap);
    }

    @Override
    public List<String> selectUocomComidsByKey(UocomEntity uocomEntity) {
        return sysUserRootMapper.selectUocomComidsByKey(uocomEntity);
    }

    @Override
    public List<String> selectUocomOidByKey(UocomEntity uocomEntity) {
        return sysUserRootMapper.selectUocomOidByKey(uocomEntity);
    }

    @Override
    public List<EntityModel> selectEntityModelByPrimaryKey(Map<String, Object> paramMap) {
        return sysUserRootMapper.selectEntityModelByPrimaryKey(paramMap);
    }

    @Override
    public int insertUserComEntity(UocomEntity uocomEntity) {
        return sysUserRootMapper.insertUserComEntity(uocomEntity);
    }

    @Override
    public List<EntityModel> selectNaturalPersonByIds(String code, String cid) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("code", code);
        paramMap.put("cid", cid);

        return sysUserRootMapper.selectNaturalPersonByIds(paramMap);
    }

    @Override
    public int checkUserIsBind(String uid, String tableName,String rcode) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("uid", uid);
        paramMap.put("tableName", tableName);
        paramMap.put("rcode", rcode);
        return sysUserRootMapper.checkUserIsBind(paramMap);
    }

    @Override
    public void deleteCommRelation(UocomEntity uocomEntity) {
        sysUserRootMapper.deleteCommRelation(uocomEntity);
    }
}
