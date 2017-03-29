package cn.tc.ulife.platform.server.shop.quatz;


import cn.tc.ulife.platform.server.SpringContextUtil;
import cn.tc.ulife.platform.server.shop.service.SpeGroupService;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeansException;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.quartz
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/8/04
 * </p>
 * Time: 上午 10:07
 * </p>
 * Detail: 用于处理参与参团成功,超过有效期却未组团成功
 * </p>
 */
public class GroupOrderJob implements Job {

    private Logger logger = Logger.getLogger(GroupOrderJob.class);



    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String params = null;
        QuartzManager quartzManager = (QuartzManager) SpringContextUtil.getBean("quartzManager");
        try {
            logger.info("判断参团发起人活动超时.....");

            SpeGroupService speGroupService = (SpeGroupService) SpringContextUtil.getBean("speGroupService");

            //待处理数据 |包含 主订单id 和最终支付价格
            params = jobExecutionContext.getJobDetail().getName();

            logger.info("处理数据:" + params);
            String[] str = params.split("-");


            logger.info("超时参团活动处理成功:" + params);
        } catch (BeansException e) {

            logger.error("超时参团活动处理失败:" + params, e);
//            QuartzManager.removeJob(jobExecutionContext.getJobDetail().getName(), groupRedisKey);

        } finally {
            quartzManager.removeJob(jobExecutionContext.getJobDetail().getName());
        }


    }


}
