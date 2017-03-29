package cn.tc.ulife.platform.server.authorization.service.manage.impl;

import cn.tc.ulife.platform.server.authorization.dao.SysUrcomMapper;
import cn.tc.ulife.platform.server.authorization.model.AuthCommModel;
import cn.tc.ulife.platform.server.authorization.model.SysUrcom;
import cn.tc.ulife.platform.server.authorization.service.manage.SysUrcomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
 * Date: 2017/2/13 0013
 * </p>
 * Time: 上午 10:26
 * </p>
 * Detail:
 * </p>
 */
@Service("sysUrcomService")
public class SysUrcomServiceImpl implements SysUrcomService {

    @Autowired
    SysUrcomMapper sysUrcomMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return sysUrcomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSysUrcom(SysUrcom sysUrcom) {
        return sysUrcomMapper.insertSysUrcom(sysUrcom);
    }

    @Override
    public SysUrcom selectByPrimaryKey(String id) {
        return sysUrcomMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<SysUrcom> selectByKey(SysUrcom sysUrcom) {
        return sysUrcomMapper.selectByKey(sysUrcom);
    }

    @Override
    public List<AuthCommModel> queryAuthCommList(String rcode, String entityId, String areaId) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("rcode", rcode);
        paramMap.put("entityId", entityId);
        paramMap.put("areaId", areaId);

        return sysUrcomMapper.queryAuthCommList(paramMap);
    }

    @Override
    public List<AuthCommModel> queryStoreAuthCommList(String rcode, String entityId, String areaId) {


        String agentId = sysUrcomMapper.queryAgentIdByStoreId(entityId)  ;
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("rcode", "DLS");
        paramMap.put("entityId", agentId);
        paramMap.put("areaId", areaId);

        List<AuthCommModel> authCommModels = sysUrcomMapper.queryAuthCommList(paramMap);
        List<AuthCommModel> authCommModelsTemp = new ArrayList<>();
        for (AuthCommModel authCommModel : authCommModels) {

            if (authCommModel.getIsCheck().equals("1")) {
                authCommModel.setIsCheck("0");
                authCommModelsTemp.add(authCommModel);
            }
        }

        paramMap.put("rcode", rcode);
        paramMap.put("entityId", entityId);
        List<String> strings = sysUrcomMapper.queryStoreAuthCommList(paramMap);
        for (AuthCommModel authCommModel : authCommModelsTemp) {
            for (String str : strings) {
                if (authCommModel.getId().equals(str)) {
                    authCommModel.setIsCheck("1");
                }
            }
        }
        return authCommModelsTemp;
    }

    public static void main(String[] args) {
//        AuthCommModel authCommModel = new AuthCommModel();
//        authCommModel.set
    }
}
