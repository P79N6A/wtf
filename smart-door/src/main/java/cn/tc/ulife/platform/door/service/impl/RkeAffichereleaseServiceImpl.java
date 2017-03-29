package cn.tc.ulife.platform.door.service.impl;
import cn.tc.ulife.platform.door.dao.RkeAffichereleaseDao;
import cn.tc.ulife.platform.door.service.RkeAffichereleaseService;

import cn.tc.ulife.platform.door.mode.page.RkeAffichereleasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * RkeAffichereleaseServiceImpl Service Object, this class extends RkeAffichereleaseService and
 * is intended for application programmers to add new methods for business needs.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
@Service("RkeAffichereleaseService")
public class RkeAffichereleaseServiceImpl implements RkeAffichereleaseService {

    @Autowired
    private RkeAffichereleaseDao RkeAffichereleaseDao;

    @Override
    public boolean saveRkeAfficherelease(RkeAffichereleasePage page) {
        return false;
    }

    @Override
    public boolean delRkeAfficherelease(RkeAffichereleasePage page) {
        return false;
    }

    @Override
    public boolean updRkeAfficherelease(RkeAffichereleasePage page) {
        return false;
    }

    @Override
    public RkeAffichereleasePage getRkeAfficherelease(RkeAffichereleasePage page) {
        return null;
    }

    @Override
    public List<RkeAffichereleasePage> listRkeAfficherelease(String condition) {
        return null;
    }

    @Override
    public Integer countRkeAfficherelease(String condition) {
        return null;
    }

}