package cn.tc.ulife.platform.door.service;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */import cn.tc.ulife.platform.door.mode.page.RkeAffichecontentPage;

import java.util.List;

/**
 * RkeAffichecontent Service Object.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public interface RkeAffichecontentService {

	boolean saveRkeAffichecontent(RkeAffichecontentPage page);

	boolean delRkeAffichecontent(RkeAffichecontentPage page);

	boolean updRkeAffichecontent(RkeAffichecontentPage page);

    RkeAffichecontentPage getRkeAffichecontent(RkeAffichecontentPage page);

	List<RkeAffichecontentPage> listRkeAffichecontent(String condition);

	Integer countRkeAffichecontent(String condition);

}