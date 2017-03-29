package cn.tc.ulife.platform.door.dao;
import cn.tc.ulife.platform.door.mode.RkeAdLocationEntity;
import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * RkeAdLocation Data Access Object.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public interface RkeAdLocationDao {

	Integer insert(RkeAdLocationEntity entity);

	Integer deleteByPrimaryKey(String id);

	Integer update(RkeAdLocationEntity entity);

	RkeAdLocationEntity selectByPrimaryKey(String id);

    List<RkeAdLocationEntity> selectByConditions(String condition);

    Integer getCount(String condition);
}