package cn.tc.ulife.platform.server.shop.quatz;


import cn.tc.ulife.platform.server.SpringContextUtil;
import cn.tc.ulife.platform.server.shop.service.OrderService;
import cn.tc.ulife.platform.util.jedis.JedisTool;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeansException;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;

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
        int code = 0;
        try {
            logger.debug("开始处理超时订单.....");
            OrderService oService = (OrderService) SpringContextUtil.getBean("oService");

            //待处理订单编号
            orderNum = jobExecutionContext.getJobDetail().getName();

            logger.debug("超时订单号:" + orderNum);



            logger.debug("超时订单处理成功:" + orderNum);
        } catch (BeansException e) {
//            //表示拼团订单,拼团订单自己操作任务移除
//            if (code != 999) {
            QuartzManager.removeJob(jobExecutionContext.getJobDetail().getName());
            logger.error("超时订单处理失败:" + orderNum, e);
//            }


        }
//        if (code != 999) {
        QuartzManager.removeJob(jobExecutionContext.getJobDetail().getName());
//            logger.info("订单" + orderNum + "取消成功");
//        }


    }

    public static void main(String[] args) {
        Jedis jedis = JedisTool.getJedis();
        try {

//            jedis.lt
//        jedis.lpush("order","111");
//        jedis.lpush("order","222");
//        jedis.lpush("order","333");
//        System.out.println(jedis.lrange("order", 0, 1));
//
//        jedis.lpush("order","444");  jedis.lpush("order","www");
//        jedis.lpush("order","qqq");
//        System.out.println(jedis.lrange("order", 0, 1));
//
//        jedis.rpush("order", "sss");
            System.out.println(jedis.lrange("order", 0, -1));
            jedis.ltrim("order", 1, 2);
            System.out.println(jedis.lrange("order", 0, -1));
        } finally {
            JedisTool.returnResource(jedis);
        }


        System.out.println(new BigDecimal("20.54").multiply(new BigDecimal("4")));

        System.out.println(new BigDecimal("20.54").divide(new BigDecimal("4"), 0, BigDecimal.ROUND_HALF_UP));
    }


}
