package cn.tc.ulife.platform.door.service.impl;
import cn.tc.ulife.platform.door.dao.RkeAdReleaseDao;
import cn.tc.ulife.platform.door.service.RkeAdReleaseService;

import cn.tc.ulife.platform.door.mode.page.RkeAdReleasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * RkeAdReleaseServiceImpl Service Object, this class extends RkeAdReleaseService and
 * is intended for application programmers to add new methods for business needs.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
@Service("RkeAdReleaseService")
public class RkeAdReleaseServiceImpl implements RkeAdReleaseService {

    @Autowired
    private RkeAdReleaseDao RkeAdReleaseDao;

    @Override
    public boolean saveRkeAdRelease(RkeAdReleasePage page) {
        return false;
    }

    @Override
    public boolean delRkeAdRelease(RkeAdReleasePage page) {
        return false;
    }

    @Override
    public boolean updRkeAdRelease(RkeAdReleasePage page) {
        return false;
    }

    @Override
    public RkeAdReleasePage getRkeAdRelease(RkeAdReleasePage page) {
        return null;
    }

    @Override
    public List<RkeAdReleasePage> listRkeAdRelease(String condition) {
        return null;
    }

    @Override
    public Integer countRkeAdRelease(String condition) {
        return null;
    }

}