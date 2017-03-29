package cn.tc.ulife.platform.server.pay.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tc.ulife.platform.server.pay.dao.UpayDao;
import cn.tc.ulife.platform.server.pay.model.PayOrderBean;
import cn.tc.ulife.platform.server.pay.model.UpayFsBean;
import cn.tc.ulife.platform.server.pay.service.UpayService;
import cn.tc.ulife.platform.server.shop.model.OrderBean;
import cn.tc.ulife.platform.server.shop.model.OrderLogBean;

@Service("uPayService")
public class UpayServiceImpl implements UpayService
{

	@Autowired
	private UpayDao payDao;
	/**
	 * 获取订单日志
	 * 日期 2016-11-14
	 * 时间 下午2:58:27
	 * 创建者 lwy
	 * @param id
	 * @return
	 */
	public List<OrderLogBean> getOrderLog(OrderBean bean){
		return payDao.getOrderLog(bean);
	}
	/**
	 * 订单明细
	 * 日期 2016-6-2
	 * 时间 下午1:31:02
	 * 创建者 wbx
	 * @param param
	 * @return
	 */
	public List<OrderBean> getOrderGoodsInfo(OrderBean bean){
		return payDao.getOrderGoodsInfo(bean);
	}
	/**
	 * 订单进度查询
	 * 日期 2016-8-24
	 * 时间 下午4:19:33
	 * 创建者 wbx
	 * @param bean
	 * @return
	 */
	public OrderBean getOrderProgress(OrderBean bean){
		return payDao.getOrderProgress(bean);
	}
	/**
	 * 获取订单详情
	 * 日期 2016-11-14
	 * 时间 下午2:52:29
	 * 创建者 lwy
	 * @param bean
	 * @return
	 */
	public OrderBean getOrderByOrderBh(OrderBean bean){
		return payDao.getOrderByOrderBh(bean);
	}
	
	@Override
	public List<UpayFsBean> queryPayment(UpayFsBean ufb)
	{
		return payDao.queryPayment(ufb);
	}

	public int queryPaymentTotal(UpayFsBean ufb){
		return payDao.queryPaymentTotal(ufb);
	}
	
	@Override
	public int savePayFs(UpayFsBean ufb)
	{
		return payDao.savePayFs(ufb);
	}
	@Override
	public int updPayFs(UpayFsBean ufb)
	{
		return payDao.updPayFs(ufb);
	}

	@Override
	public List<PayOrderBean> queryPayOrder(PayOrderBean pob)
	{
		return payDao.queryPayOrder(pob);
	}
	
	
	@Override
	public int queryPayOrderTotal(PayOrderBean pob)
	{
		return payDao.queryPayOrderTotal(pob);
	}
	
	
	/**
	 * 交易记录
	 * 
	 * @return
	 */
	public List<PayOrderBean> queryPayOrderExport(PayOrderBean pob){
		return payDao.queryPayOrderExport(pob);
	}
}
