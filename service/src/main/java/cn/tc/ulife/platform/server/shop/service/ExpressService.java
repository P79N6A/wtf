/**
 * @Title: ExpressService
 * @Package cn.tc.ulife.platform.server.express
 * @Description: 快递模块service接口层
 * @author alliswell008
 * @date 2017/2/16 14:54
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.service;

import cn.tc.ulife.platform.server.shop.page.ExpressPage;

import java.util.List;

/**
 * @author alliswell008
 * @ClassName: ExpressService
 * @Description: 快递模块service接口层
 * @date 2017/2/16 14:54
 */
public interface ExpressService {

    public boolean addExpressInfo(String account, String app, ExpressPage page);

    public boolean delExpressInfo(String account, String app, String id);

    public boolean updExpressInfo(String account, String app, ExpressPage page);

    public ExpressPage queryExpressInfo(String account, String app, String id);

    public List<ExpressPage> queryAll(String account, String app, String kdmc, Integer ofset, Integer psize);
}
