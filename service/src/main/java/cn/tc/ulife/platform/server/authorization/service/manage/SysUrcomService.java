package cn.tc.ulife.platform.server.authorization.service.manage;

import cn.tc.ulife.platform.server.authorization.model.AuthCommModel;
import cn.tc.ulife.platform.server.authorization.model.SysUrcom;

import java.util.List;
import java.util.Map;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.service
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/13 0013
 * </p>
 * Time: 上午 10:24
 * </p>
 * Detail:
 * </p>
 */
public interface SysUrcomService {


    int deleteByPrimaryKey(String id);

    int insertSysUrcom(SysUrcom sysUrcom);

    SysUrcom selectByPrimaryKey(String id);

    List<SysUrcom> selectByKey(SysUrcom sysUrcom);


    List<AuthCommModel> queryAuthCommList(String rcode, String entityId, String areaId);


    List<AuthCommModel> queryStoreAuthCommList(String rcode, String entityId, String areaId);


}
