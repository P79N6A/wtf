/**
 * @Title: SysService
 * @Package cn.tc.ulife.platform.server.sys
 * @Description: 系统公共模块service接口层
 * @author cxs
 * @date 2017/2/14 13:58
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.sys.service;

import cn.tc.ulife.platform.server.sys.model.AppSignedEntity;
import cn.tc.ulife.platform.server.sys.model.FwMsgEntity;

import java.util.List;

/**
 * @author cxs
 * @ClassName: SysService
 * @Description: 系统公共模块service接口层
 * @date 2017/2/14 13:58
 */
public interface SysService {

    /**
     * 查询系统公告列表
     * @param type
     * @param ofset
     * @param psize
     * @return
     */
    public List<FwMsgEntity> querySysNotice(String type, Integer ofset, Integer psize);

    /**
     * 添加系统公告
     * @param uid
     * @param title
     * @param msg
     * @return
     */
    public int addSysNotice(String uid, String title, String msg);

    /**
     * 修改系统公告，仅修改公告状态 0：新建，1：发布生效，2：停用无效
     * @param id
     * @param zt
     * @return
     */
    public int updateSysNotice(String id, String zt);

    /**
     * 查询系统公告总数
     * @return
     */
    public String getSysNoticeTotal();

    /**
     * 查询积分规则
     * @return
     */
    public List<AppSignedEntity> queryIntegralRules();

    /**
     * 查询积分规则总数
     * @return
     */
    public String getIntegralRuleTotal();

    /**
     * 修改积分规则
     * @return
     */
    public int updateIntegralRule(String id, String integral);
}
