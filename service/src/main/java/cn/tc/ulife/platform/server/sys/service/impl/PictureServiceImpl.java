/**
 * @Title: PictureServiceImpl
 * @Package cn.tc.ulife.platform.server.sys.service.impl
 * @Description: 业务图片信息service实现层
 * @author alliswell
 * @date 2017/2/27 14:28
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.tc.ulife.platform.server.sys.service.impl;

import cn.tc.ulife.platform.server.sys.dao.PictureDao;
import cn.tc.ulife.platform.server.sys.model.PictureEntity;
import cn.tc.ulife.platform.server.sys.service.PictureService;
import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alliswell
 * @Title: PictureServiceImpl
 * @Package cn.tc.ulife.platform.server.sys.service.impl
 * @Description: 业务图片信息service实现层
 * @date 2017/2/27 14:28
 */
@Service("PictureService")
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pictureDao;

    @Override
    public boolean delPictureByKey(String id) {
        pictureDao.delPictureByKey(id);
        return true;
    }

    @Override
    public boolean delPicture(String tid, String tname) {
        Map<String, Object> map = new HashMap<>();
        map.put("tid", tid);
        map.put("tname", tname);
        pictureDao.delPicture(map);
        return true;
    }

    @Override
    public boolean addPicture(String account, String tid, String tname,
                                 String imgs) {
        // 上传成功保存图片URL
        List<PictureEntity> entityList = new ArrayList<>();
        PictureEntity entity;
        if (!"".equals(imgs)) {
            String[] urls = imgs.split(",");
            for (String url : urls)
            {
                entity = new PictureEntity();
                entity.setTid(tid);
                entity.setTname(tname);
                entity.setUrl(url);
                entity.setUid(null);
                entity.setType(null);
                entityList.add(entity);
            }
        }
        pictureDao.addPictureList(entityList);
        return true;
    }

    @Override
    public List<PictureEntity> listPicture(String tid, String tname) {
        Map<String, Object> map = new HashMap<>();
        map.put("tid", tid);
        map.put("tname", tname);
        return pictureDao.listPicture(map);
    }
}
