package cn.tc.ulife.platform.door.service;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */import cn.tc.ulife.platform.door.mode.page.RkeAdReleasePage;

import java.util.List;

/**
 * RkeAdRelease Service Object.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public interface RkeAdReleaseService {

	boolean saveRkeAdRelease(RkeAdReleasePage page);

	boolean delRkeAdRelease(RkeAdReleasePage page);

	boolean updRkeAdRelease(RkeAdReleasePage page);

    RkeAdReleasePage getRkeAdRelease(RkeAdReleasePage page);

	List<RkeAdReleasePage> listRkeAdRelease(String condition);

	Integer countRkeAdRelease(String condition);

}