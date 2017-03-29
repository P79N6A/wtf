package cn.tc.ulife.platform.door.dao;
import cn.tc.ulife.platform.door.mode.RkeAffichetypeEntity;
import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * RkeAffichetype Data Access Object.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public interface RkeAffichetypeDao {

	Integer insert(RkeAffichetypeEntity entity);

	Integer deleteByPrimaryKey(String id);

	Integer update(RkeAffichetypeEntity entity);

	RkeAffichetypeEntity selectByPrimaryKey(String id);

    List<RkeAffichetypeEntity> selectByConditions(String condition);

    Integer getCount(String condition);
}