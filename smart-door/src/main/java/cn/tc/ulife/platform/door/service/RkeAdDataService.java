package cn.tc.ulife.platform.door.service;

/*
 * Powered By [taichuan]
 * Web Site: http://nj.taichuan.com/
 * Since 2015 - 2017
 */import cn.tc.ulife.platform.door.mode.page.RkeAdDataPage;

import java.util.List;

/**
 * RkeAdData Service Object.
 * @author taichuan Platform Group
 * @create 2017-03-20 */
public interface RkeAdDataService {

	boolean saveRkeAdData(RkeAdDataPage page);

	boolean delRkeAdData(RkeAdDataPage page);

	boolean updRkeAdData(RkeAdDataPage page);

    RkeAdDataPage getRkeAdData(RkeAdDataPage page);

	List<RkeAdDataPage> listRkeAdData(String condition);

	Integer countRkeAdData(String condition);

}