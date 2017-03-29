package cn.tc.ulife.platform.quartz.QuartzService.impl;

import cn.tc.ulife.platform.quartz.quartzmanage.QuartzManager;
import cn.tc.ulife.platform.server.remote.IQuartzOrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.QuartzService.impl
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/11/15 0015
 * </p>
 * Time: 下午 3:33
 * </p>
 * Detail:
 * </p>
 */
@Service
public class QuartzOrderServiceImpl implements IQuartzOrderService {

    @Autowired
    QuartzManager quartzManager;


    Logger logger = Logger.getLogger(this.getClass());


    @Override
    public String processOrderJobByReturn(String orderNo, String time) {
        logger.info("orderNo:" + orderNo + ",time:" + time + ":开启订单超时任务...");
        try {
//            quartzManager.addJob(orderNo, OrderJob.class, time);

            logger.info("orderNo:" + orderNo + ",time:" + time + ":开启订单超时任务成功");
        } catch (Exception e) {

            logger.error("orderNo:" + orderNo + ",time:" + time + ":开启订单超时任务失败", e);
            return "ERROR";

        }
        return "SUCCESS";
    }

    @Override
    public String processGroupOrderJobByReturn(String orderNo, String allSprice, String time) {
        logger.info("orderNo:" + orderNo + ",+allSprice:" + allSprice + ",time:" + time + ":开启拼团活动超时解散任务...");
        try {
//            quartzManager.addJob(orderNo + "-" + allSprice, GroupOrderJob.class, time);

            logger.info("orderNo:" + ",+allSprice:" + allSprice + ",time:" + time + ":开启组团超时任务成功");
        } catch (Exception e) {

            logger.error("orderNo:" + orderNo + ",+allSprice:" + allSprice + ",time:" + time + ":开启组团超时任务失败", e);
            return "ERROR";

        }

        return "SUCCESS";
    }

    @Override
    public String removeJob(String orderNo) {
        logger.info("orderNo:" + orderNo + "移除订单超时任务...");
        try {
            quartzManager.removeJob(orderNo);
            logger.info("orderNo:" + orderNo + "移除订单超时任务成功...");
        } catch (Exception e) {
            logger.info("orderNo:" + orderNo + "移除订单超时任务失败...");
            return "ERROR";

        }
        return "SUCCESS";
    }

}
