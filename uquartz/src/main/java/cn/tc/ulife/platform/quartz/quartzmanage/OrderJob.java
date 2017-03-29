package cn.tc.ulife.platform.quartz.quartzmanage;

import cn.tc.ulife.platform.server.SpringContextUtil;
import cn.tc.ulife.platform.server.shop.service.OrderService;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.quartz
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/5/11
 * </p>
 * Time: 上午 10:07
 * </p>
 * Detail: 用于处理订单超时未支付自动取消
 * </p>
 */
public class OrderJob implements Job {

    private Logger logger = Logger.getLogger(OrderJob.class);


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String orderNum = null;
        QuartzManager quartzManager = (QuartzManager) SpringContextUtil.getBean("quartzManager");
        try {
            logger.debug("开始处理超时订单.....");
            OrderService oService = (OrderService) SpringContextUtil.getBean("oService");


            //待处理订单编号
            orderNum = jobExecutionContext.getJobDetail().getName();

            logger.debug("超时订单号:" + orderNum);
            quartzManager.removeJob(jobExecutionContext.getJobDetail().getName());
////
//            Map<String, Object> retMap = oService.updateOrder("-1", OrderConstance.EXPTIME_ORDER_INTEGER, "8", "127.0.0.1,",
//                    orderNum, SysConstance.PayWay.DEFAULT_PAY.getValue(), "");
//            if (null != retMap) {
//                logger.info("超时订单处理成功:" + orderNum);
//            } else {
//                logger.error("超时订单处理失败:" + orderNum);
//            }
        } catch (Exception e) {
            //表示拼团订单,拼团订单自己操作任务移除
//            if (code != 999) {
            quartzManager.removeJob(jobExecutionContext.getJobDetail().getName());
            logger.error("超时订单处理失败:" + orderNum, e);
//            }


        }
//        if (code != 999) {
        quartzManager.removeJob(jobExecutionContext.getJobDetail().getName());
        logger.info("订单" + orderNum + "取消成功");
//        }


    }

    public static void main(String[] args) {

    }


}
