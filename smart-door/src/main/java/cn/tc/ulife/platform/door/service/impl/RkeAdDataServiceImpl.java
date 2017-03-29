package cn.tc.ulife.platform.door.service.impl;
import cn.tc.ulife.platform.door.dao.RkeAdDataDao;
import cn.tc.ulife.platform.door.service.RkeAdDataService;

import cn.tc.ulife.platform.door.mode.page.RkeAdDataPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * RkeAdDataServiceImpl Service Object, this class extends RkeAdDataService and
 * is intended for application programmers to add new methods for business needs.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
@Service("RkeAdDataService")
public class RkeAdDataServiceImpl implements RkeAdDataService {

    @Autowired
    private RkeAdDataDao RkeAdDataDao;

    @Override
    public boolean saveRkeAdData(RkeAdDataPage page) {
        return false;
    }

    @Override
    public boolean delRkeAdData(RkeAdDataPage page) {
        return false;
    }

    @Override
    public boolean updRkeAdData(RkeAdDataPage page) {
        return false;
    }

    @Override
    public RkeAdDataPage getRkeAdData(RkeAdDataPage page) {
        return null;
    }

    @Override
    public List<RkeAdDataPage> listRkeAdData(String condition) {
        return null;
    }

    @Override
    public Integer countRkeAdData(String condition) {
        return null;
    }

}