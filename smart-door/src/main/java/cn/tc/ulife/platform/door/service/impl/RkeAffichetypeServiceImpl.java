package cn.tc.ulife.platform.door.service.impl;
import cn.tc.ulife.platform.door.dao.RkeAffichetypeDao;
import cn.tc.ulife.platform.door.service.RkeAffichetypeService;

import cn.tc.ulife.platform.door.mode.page.RkeAffichetypePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * RkeAffichetypeServiceImpl Service Object, this class extends RkeAffichetypeService and
 * is intended for application programmers to add new methods for business needs.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
@Service("RkeAffichetypeService")
public class RkeAffichetypeServiceImpl implements RkeAffichetypeService {

    @Autowired
    private RkeAffichetypeDao RkeAffichetypeDao;

    @Override
    public boolean saveRkeAffichetype(RkeAffichetypePage page) {
        return false;
    }

    @Override
    public boolean delRkeAffichetype(RkeAffichetypePage page) {
        return false;
    }

    @Override
    public boolean updRkeAffichetype(RkeAffichetypePage page) {
        return false;
    }

    @Override
    public RkeAffichetypePage getRkeAffichetype(RkeAffichetypePage page) {
        return null;
    }

    @Override
    public List<RkeAffichetypePage> listRkeAffichetype(String condition) {
        return null;
    }

    @Override
    public Integer countRkeAffichetype(String condition) {
        return null;
    }

}