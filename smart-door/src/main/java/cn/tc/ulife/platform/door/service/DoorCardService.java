package cn.tc.ulife.platform.door.service;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */

import cn.tc.ulife.platform.door.mode.DoorCardEntity;

import java.util.List;

/**
 * RkeCard Service Object.
 * @author taichuan Platform Group
 * @create 2017-03-13 */
public interface DoorCardService {

	boolean saveRkeCard(DoorCardEntity entity);

	boolean delRkeCard(DoorCardEntity entity);

	boolean updRkeCard(DoorCardEntity entity);

    DoorCardEntity getRkeCard(DoorCardEntity entity);

	List<DoorCardEntity> listRkeCard(String condition);

	Integer countRkeCard(String condition);

    boolean checkDoorCard(DoorCardEntity entity);
}