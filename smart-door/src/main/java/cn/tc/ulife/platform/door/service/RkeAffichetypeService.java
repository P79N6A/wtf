package cn.tc.ulife.platform.door.service;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */import cn.tc.ulife.platform.door.mode.page.RkeAffichetypePage;

import java.util.List;

/**
 * RkeAffichetype Service Object.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public interface RkeAffichetypeService {

	boolean saveRkeAffichetype(RkeAffichetypePage page);

	boolean delRkeAffichetype(RkeAffichetypePage page);

	boolean updRkeAffichetype(RkeAffichetypePage page);

    RkeAffichetypePage getRkeAffichetype(RkeAffichetypePage page);

	List<RkeAffichetypePage> listRkeAffichetype(String condition);

	Integer countRkeAffichetype(String condition);

}