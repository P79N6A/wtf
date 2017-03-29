/**
 * @Title: SysDao
 * @Package cn.tc.ulife.platform.server.sys.dao
 * @Description: 系统公共模块dao层
 * @author cxs
 * @date 2017/2/14 14:03
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.sys.dao;

import cn.tc.ulife.platform.server.sys.model.AppSignedEntity;
import cn.tc.ulife.platform.server.sys.model.FwMsgEntity;

import java.util.List;
import java.util.Map;

/**
 * @author cxs
 * @ClassName: SysDao
 * @Description: 系统公共模块dao层
 * @date 2017/2/14 14:03
 */
public interface SysDao {

    /**
     * 查询系统公告
     * @param map
     */
    public List<FwMsgEntity> querySysNotice(Map<String, Object> map);

    /**
     * 添加系统公告
     * @param map
     * @return
     */
    public int addSysNotice(Map<String, Object> map);

    /**
     * 修改系统公告
     * @param map
     * @return
     */
    public int updateSysNotice(Map<String, Object> map);

    /**
     * 查询系统公告总数
     * @return
     */
    public String getSysNoticeTotal();

    /**
     * 查询积分规则
     * @param map
     * @return
     */
    public List<AppSignedEntity> queryIntegralRules(Map<String, Object> map);

    /**
     * 查询积分规则总数
     * @return
     */
    public String getIntegralRuleTotal();

    /**
     * 修改积分规则
     * @param map
     * @return
     */
    public int updateIntegralRule(Map<String, Object> map);
}
