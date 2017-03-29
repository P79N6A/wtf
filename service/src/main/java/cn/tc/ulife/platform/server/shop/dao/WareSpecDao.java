/**
 * @Title: WareDao
 * @Package cn.tc.ulife.platform.server.ware.dao
 * @Description: 商品规格dao层
 * @author cxs
 * @date 2017/2/20 14:20
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.dao;


import cn.tc.ulife.platform.server.shop.entity.WareSpecEntity;

import java.util.List;
import java.util.Map;

/**
 * @author cxs
 * @ClassName: WareDao
 * @Description: 商品规格dao层
 * @date 2017/2/20 14:20
 */
public interface WareSpecDao
{

    int addSpecification(List<WareSpecEntity> wareSpecificationPageList);

    int addSpecificationPage(WareSpecEntity wareSpecificationPage);

    int delSpecification(Map<String, Object> map);

    int updSpecificationPage(WareSpecEntity spage);

    List<WareSpecEntity> listWareSpecification(Map<String, Object> map);

    WareSpecEntity getWareSpecification(Map<String, Object> map);
}
