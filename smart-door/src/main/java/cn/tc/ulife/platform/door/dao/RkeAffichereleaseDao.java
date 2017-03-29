package cn.tc.ulife.platform.door.dao;
import cn.tc.ulife.platform.door.mode.RkeAffichereleaseEntity;
import java.util.List;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */
/**
 * RkeAfficherelease Data Access Object.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public interface RkeAffichereleaseDao {

	Integer insert(RkeAffichereleaseEntity entity);

	Integer deleteByPrimaryKey(String id);

	Integer update(RkeAffichereleaseEntity entity);

	RkeAffichereleaseEntity selectByPrimaryKey(String id);

    List<RkeAffichereleaseEntity> selectByConditions(String condition);

    Integer getCount(String condition);
}