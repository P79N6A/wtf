package cn.tc.ulife.platform.door.service;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */import cn.tc.ulife.platform.door.mode.page.RkeAffichereleasePage;

import java.util.List;

/**
 * RkeAfficherelease Service Object.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public interface RkeAffichereleaseService {

	boolean saveRkeAfficherelease(RkeAffichereleasePage page);

	boolean delRkeAfficherelease(RkeAffichereleasePage page);

	boolean updRkeAfficherelease(RkeAffichereleasePage page);

    RkeAffichereleasePage getRkeAfficherelease(RkeAffichereleasePage page);

	List<RkeAffichereleasePage> listRkeAfficherelease(String condition);

	Integer countRkeAfficherelease(String condition);

}