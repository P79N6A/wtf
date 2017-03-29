/**
 * @Title: PictureDao
 * @Package cn.tc.ulife.platform.server.sys.dao
 * @Description: 业务图片信息dao层
 * @author alliswell
 * @date 2017/2/27 14:30
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.tc.ulife.platform.server.sys.dao;

import cn.tc.ulife.platform.server.sys.model.PictureEntity;

import java.util.List;
import java.util.Map;

/**
 * @author alliswell
 * @Title: PictureDao
 * @Package cn.tc.ulife.platform.server.sys.dao
 * @Description: 业务图片信息dao层
 * @date 2017/2/27 14:30
 */
public interface PictureDao {
    int addPictureList(List<PictureEntity> entityList);

    int addPicture(PictureEntity entity);

    int delPictureByKey(String id);

    int delPicture(Map<String, Object> map);

    List<PictureEntity> listPicture(Map<String, Object> map);
}
