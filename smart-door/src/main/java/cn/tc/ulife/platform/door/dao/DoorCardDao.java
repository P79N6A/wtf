package cn.tc.ulife.platform.door.dao;
import cn.tc.ulife.platform.door.mode.DoorCardEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * RkeCard Data Access Object.
 * @author taichuan Platform Group
 * @create 2017-03-13 */
public interface DoorCardDao {

	Integer insert(DoorCardEntity entity);

	Integer deleteByPrimaryKey(String id);

	Integer update(DoorCardEntity entity);

    DoorCardEntity selectByPrimaryKey(String id);

    List<DoorCardEntity> selectByConditions(@Param("condition") String condition);

    Integer getCount(@Param("condition") String condition);

    Integer checkDoorCard(DoorCardEntity entity);
}