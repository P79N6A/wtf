package cn.tc.ulife.platform.agent.controller.pay;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.server.pay.model.PayOrderBean;
import cn.tc.ulife.platform.server.pay.model.UpayFsBean;
import cn.tc.ulife.platform.server.pay.service.UpayService;
import cn.tc.ulife.platform.server.shop.model.OrderBean;
import cn.tc.ulife.platform.server.shop.model.OrderLogBean;
import cn.tc.ulife.platform.server.user.model.UserFront;
import cn.tc.ulife.platform.server.user.service.UserCacheService;
import cn.tc.ulife.platform.server.utils.Snippet;
import cn.tc.ulife.platform.server.utils.model.UtileBean;
import cn.tc.ulife.platform.server.utils.service.UtileService;

@Controller
@RequestMapping("/upay")
public class UpayController
{
	@Autowired
	private UpayService payService;
	
	@Autowired
	private UtileService utileService;
	
	@Autowired
	private UserCacheService userCacheService;
	

	/**
	 * 新增支付方式
	 * 日期 2017年3月28日
	 * 时间 上午10:47:47
	 * 创建者 Lcc
	 * @param ZID
	 * @param zmc 方式名称
	 * @param zfee 手续费
	 * @param zt 0启用1停用
	 * @return
	 */
	@RequestMapping("/savePayment")
	@ResponseBody
	public ReturnMsg savePayfs(String ZID, String zmc, String zfee, String zt,@RequestParam String uid){
		UpayFsBean ufb = new UpayFsBean();
		ufb.setZID(ZID);
		ufb.setZmc(zmc);
		UserFront userInfo = userCacheService.getUserInfo(uid);
		ufb.setUid(userInfo.getId());
		ufb.setZfee(zfee);
		ufb.setZt(zt); 
		//修改
		if (StringUtils.isNotEmpty(ZID)){
			int rtn = payService.updPayFs(ufb);
			if (rtn > 0) { 
				return AppResponseMsg.success(); 
			}
		}else{//保存
			int rtn = payService.savePayFs(ufb);
			if (rtn > 0) { 
				return AppResponseMsg.success(); 
			}
		}
		return AppResponseMsg.faild();
	}

	
	/**
	 * 获取支付方式列表
	 * 日期 2017年3月28日
	 * 时间 下午1:12:52
	 * 创建者 Lcc
	 * @param name 
	 * @return
	 */
	@RequestMapping("/listOfPayment")
	@ResponseBody
	public ReturnMsg queryPayfs(UpayFsBean bean)
	{
		return AppResponseMsg.success(payService.queryPayment(bean));
	}

	/**
	 * 交易记录
	 * 日期 2017年3月28日
	 * 时间 下午1:51:37
	 * 创建者 Lcc
	 * @param pob
	 * @return
	 */
	@RequestMapping("/payOrder")
	@ResponseBody
	public ReturnMsg queryPayOrder(PayOrderBean pob)
	{
		return AppResponseMsg.success(payService.queryPayOrder(pob),String.valueOf(payService.queryPayOrderTotal(pob)));
	}
	
	
	/**
	 * 
	 * 日期 2016-10-27
	 * 时间 上午10:37:20
	 * 创建者 lcc
	 * @param response
	 * @param gb
	 * @throws IOException 
	 */
	@RequestMapping("exportDealRecord")
	@ResponseBody
	public ReturnMsg Export(HttpServletResponse response, PayOrderBean pob) throws IOException {
		if(pob.getArid().equals("null")){
			pob.setArid(null);
		}
		List<PayOrderBean> queryPayOrder = payService.queryPayOrderExport(pob);
		Snippet.exportDealRecord(response, queryPayOrder);
		return AppResponseMsg.success();
	}
	
	
	
	/**
	 * 流水查看订单详情
	 * 日期 2016-11-14
	 * 时间 下午2:47:12
	 * 创建者 lwy
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/getZfOrderDetail")
	public String getCwOrderDetail(ModelMap model,OrderBean orderBean)
	{
		//获取订单详情
		OrderBean bean = payService.getOrderByOrderBh(orderBean);
		//订单进度
		OrderBean progress=payService.getOrderProgress(orderBean);
		//订单商品信息
		List<OrderBean> list = payService.getOrderGoodsInfo(orderBean);
		//订单优惠券
		StringBuffer sql =new StringBuffer();
		sql.append("SELECT Y.JJE ID,Y.NAME FROM T_SC_ORDER O ");
		sql.append("INNER JOIN t_u_useryhj UJ ON O.HDYHJID=UJ.ID ");
		sql.append("INNER JOIN t_yx_yhj Y ON UJ.YID=Y.ID ");
		sql.append("WHERE  O.ID  = '").append(orderBean.getOrderbh()).append("'");
		List <UtileBean> yhlist=utileService.getListData(sql.toString());
		if(CollectionUtils.isNotEmpty(yhlist)){
			bean.setYhjxx(yhlist.get(0).getNAME());
		}
		List<OrderLogBean> listlog =payService.getOrderLog(orderBean);
		model.put("listlog", listlog);
		model.put("goods", list);
		model.put("bean", bean);
		model.put("progress", progress);
		return "upay/orderdetail";
		
	}

}
