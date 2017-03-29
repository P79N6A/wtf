package cn.tc.ulife.platform.door.service.impl;
import cn.tc.ulife.platform.door.dao.RkeAdLocationDao;
import cn.tc.ulife.platform.door.service.RkeAdLocationService;

import cn.tc.ulife.platform.door.mode.page.RkeAdLocationPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * RkeAdLocationServiceImpl Service Object, this class extends RkeAdLocationService and
 * is intended for application programmers to add new methods for business needs.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
@Service("RkeAdLocationService")
public class RkeAdLocationServiceImpl implements RkeAdLocationService {

    @Autowired
    private RkeAdLocationDao rkeAdLocationDao;

    @Override
    public boolean saveRkeAdLocation(RkeAdLocationPage page) {
        Integer num = rkeAdLocationDao.insert(page);
        if (num > 0) {
        }
        return false;
    }

    @Override
    public boolean delRkeAdLocation(RkeAdLocationPage page) {
        return false;
    }

    @Override
    public boolean updRkeAdLocation(RkeAdLocationPage page) {
        return false;
    }

    @Override
    public RkeAdLocationPage getRkeAdLocation(RkeAdLocationPage page) {
        return null;
    }

    @Override
    public List<RkeAdLocationPage> listRkeAdLocation(String condition) {
        return null;
    }

    @Override
    public Integer countRkeAdLocation(String condition) {
        return null;
    }

}