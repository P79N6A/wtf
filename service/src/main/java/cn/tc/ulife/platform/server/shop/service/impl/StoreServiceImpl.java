package cn.tc.ulife.platform.server.shop.service.impl;


import cn.tc.ulife.platform.server.shop.dao.StoreDao;
import cn.tc.ulife.platform.server.shop.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.spring.wap.service
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/18 0018
 * </p>
 * Time: 下午 3:37
 * </p>
 * Detail:
 * </p>
 */
@Service("storeService")
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;




}
