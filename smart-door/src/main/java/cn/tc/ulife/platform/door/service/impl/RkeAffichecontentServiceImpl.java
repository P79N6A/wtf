package cn.tc.ulife.platform.door.service.impl;
import cn.tc.ulife.platform.door.dao.RkeAffichecontentDao;
import cn.tc.ulife.platform.door.service.RkeAffichecontentService;

import cn.tc.ulife.platform.door.mode.page.RkeAffichecontentPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * RkeAffichecontentServiceImpl Service Object, this class extends RkeAffichecontentService and
 * is intended for application programmers to add new methods for business needs.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
@Service("RkeAffichecontentService")
public class RkeAffichecontentServiceImpl implements RkeAffichecontentService {

    @Autowired
    private RkeAffichecontentDao RkeAffichecontentDao;

    @Override
    public boolean saveRkeAffichecontent(RkeAffichecontentPage page) {
        return false;
    }

    @Override
    public boolean delRkeAffichecontent(RkeAffichecontentPage page) {
        return false;
    }

    @Override
    public boolean updRkeAffichecontent(RkeAffichecontentPage page) {
        return false;
    }

    @Override
    public RkeAffichecontentPage getRkeAffichecontent(RkeAffichecontentPage page) {
        return null;
    }

    @Override
    public List<RkeAffichecontentPage> listRkeAffichecontent(String condition) {
        return null;
    }

    @Override
    public Integer countRkeAffichecontent(String condition) {
        return null;
    }

}