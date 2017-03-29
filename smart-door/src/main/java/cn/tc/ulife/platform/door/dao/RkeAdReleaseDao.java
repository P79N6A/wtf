package cn.tc.ulife.platform.door.dao;
import cn.tc.ulife.platform.door.mode.RkeAdReleaseEntity;
import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * RkeAdRelease Data Access Object.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public interface RkeAdReleaseDao {

	Integer insert(RkeAdReleaseEntity entity);

	Integer deleteByPrimaryKey(String id);

	Integer update(RkeAdReleaseEntity entity);

	RkeAdReleaseEntity selectByPrimaryKey(String id);

    List<RkeAdReleaseEntity> selectByConditions(String condition);

    Integer getCount(String condition);
}