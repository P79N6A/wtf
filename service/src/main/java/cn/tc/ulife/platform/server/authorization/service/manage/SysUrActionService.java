package cn.tc.ulife.platform.server.authorization.service.manage;

import cn.tc.ulife.platform.server.authorization.model.ButtonFront;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.service.manage
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/14 0014
 * </p>
 * Time: 上午 10:54
 * </p>
 * Detail:
 * </p>
 */
public interface SysUrActionService {

    int deleteByPrimaryKey(String id);

    int insertButton(ButtonFront buttonFront);


    ButtonFront selectByPrimaryKey(String id);
    int deleteByKey(ButtonFront buttonFront);
}
