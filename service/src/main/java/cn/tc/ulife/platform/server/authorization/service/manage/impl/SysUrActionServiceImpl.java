package cn.tc.ulife.platform.server.authorization.service.manage.impl;

import cn.tc.ulife.platform.server.authorization.dao.SysUrActionMapper;
import cn.tc.ulife.platform.server.authorization.model.ButtonFront;
import cn.tc.ulife.platform.server.authorization.service.manage.SysUrActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.server.authorization.service.manage.impl
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/14 0014
 * </p>
 * Time: 上午 10:55
 * </p>
 * Detail:
 * </p>
 */
@Service("sysUrActionService")
public class SysUrActionServiceImpl implements SysUrActionService {


    @Autowired
    SysUrActionMapper sysUrActionMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return sysUrActionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertButton(ButtonFront buttonFront) {
        return sysUrActionMapper.insertButton(buttonFront);
    }

    @Override
    public ButtonFront selectByPrimaryKey(String id) {
        return sysUrActionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByKey(ButtonFront buttonFront) {
        return sysUrActionMapper.deleteByKey(buttonFront);
    }
}
