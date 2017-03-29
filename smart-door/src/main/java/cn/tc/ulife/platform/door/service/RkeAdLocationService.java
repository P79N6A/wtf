package cn.tc.ulife.platform.door.service;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */import cn.tc.ulife.platform.door.mode.page.RkeAdLocationPage;

import java.util.List;

/**
 * RkeAdLocation Service Object.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public interface RkeAdLocationService {

	boolean saveRkeAdLocation(RkeAdLocationPage page);

	boolean delRkeAdLocation(RkeAdLocationPage page);

	boolean updRkeAdLocation(RkeAdLocationPage page);

    RkeAdLocationPage getRkeAdLocation(RkeAdLocationPage page);

	List<RkeAdLocationPage> listRkeAdLocation(String condition);

	Integer countRkeAdLocation(String condition);

}