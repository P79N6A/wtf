package cn.tc.ulife.platform.server.authorization.dao;


import cn.tc.ulife.platform.server.authorization.model.AuthCommModel;
import cn.tc.ulife.platform.server.authorization.model.SysUrcom;

import java.util.List;
import java.util.Map;


public interface SysUrcomMapper {

    int deleteByPrimaryKey(String id);

    int insertSysUrcom(SysUrcom sysUrcom);

    SysUrcom selectByPrimaryKey(String id);

    List<SysUrcom> selectByKey(SysUrcom sysUrcom);


    List<AuthCommModel> queryAuthCommList(Map<String, String> paramMap);

    List<String> queryStoreAuthCommList(Map<String, String> paramMap);

    String queryAgentIdByStoreId(String id);

}