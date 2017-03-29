package cn.tc.ulife.platform.door.dao;
import cn.tc.ulife.platform.door.mode.RkeAdDataEntity;
import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * RkeAdData Data Access Object.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public interface RkeAdDataDao {

	Integer insert(RkeAdDataEntity entity);

	Integer deleteByPrimaryKey(String id);

	Integer update(RkeAdDataEntity entity);

	RkeAdDataEntity selectByPrimaryKey(String id);

    List<RkeAdDataEntity> selectByConditions(String condition);

    Integer getCount(String condition);
}