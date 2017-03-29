package cn.tc.ulife.platform.door.dao;
import cn.tc.ulife.platform.door.mode.RkeAffichecontentEntity;
import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * RkeAffichecontent Data Access Object.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public interface RkeAffichecontentDao {

	Integer insert(RkeAffichecontentEntity entity);

	Integer deleteByPrimaryKey(String id);

	Integer update(RkeAffichecontentEntity entity);

	RkeAffichecontentEntity selectByPrimaryKey(String id);

    List<RkeAffichecontentEntity> selectByConditions(String condition);

    Integer getCount(String condition);
}