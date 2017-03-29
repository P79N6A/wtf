/**
 * @Title: PictureService
 * @Package cn.tc.ulife.platform.server.sys.service
 * @Description: 业务图片信息service接口层
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
package cn.tc.ulife.platform.server.sys.service;

import cn.tc.ulife.platform.server.sys.dao.PictureDao;
import cn.tc.ulife.platform.server.sys.model.PictureEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author alliswell
 * @Title: PictureService
 * @Package cn.tc.ulife.platform.server.sys.service
 * @Description: 业务图片信息service接口层
 * @date 2017/2/27 14:28
 */
public interface PictureService
{
    boolean delPictureByKey(String id);

    boolean delPicture(String tid, String tname);

    boolean addPicture(String account, String tid, String tname, String img);

    List<PictureEntity> listPicture(String tid, String tname);
}
