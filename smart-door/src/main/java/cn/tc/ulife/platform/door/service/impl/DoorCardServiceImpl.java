package cn.tc.ulife.platform.door.service.impl;

import cn.tc.ulife.platform.door.dao.DoorCardDao;
import cn.tc.ulife.platform.door.mode.DoorCardEntity;
import cn.tc.ulife.platform.door.service.DoorCardService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */

/**
 * RkeCardServiceImpl Service Object, this class extends RkeCardService and
 * is intended for application programmers to add new methods for business needs.
 *
 * @author taichuan Platform Group
 * @create 2017-03-13
 */
@Service("RkeCardService")
public class DoorCardServiceImpl implements DoorCardService {

    @Autowired
private DoorCardDao doorCardDao;


    @Override
    public boolean saveRkeCard(DoorCardEntity entity) {
        doorCardDao.insert(entity);
        return true;
    }

    @Override
    public boolean delRkeCard(DoorCardEntity entity) {
        doorCardDao.deleteByPrimaryKey(entity.getCdautoId());
        return true;
    }

    @Override
    public boolean updRkeCard(DoorCardEntity entity) {
        doorCardDao.update(entity);
        return true;
    }

    @Override
    public DoorCardEntity getRkeCard(DoorCardEntity entity) {
        return doorCardDao.selectByPrimaryKey(entity.getCdautoId());
    }

    @Override
    public List<DoorCardEntity> listRkeCard(String condition) {
        return doorCardDao.selectByConditions(condition);
    }

    @Override
    public Integer countRkeCard(String condition) {
        return doorCardDao.getCount(condition);
    }

    @Override
    public boolean checkDoorCard(DoorCardEntity entity) {
        Integer num = doorCardDao.checkDoorCard(entity);
        if (Integer.compare(num, 0) == 1) {
            return true;
        }
        return false;
    }
}