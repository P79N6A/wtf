package cn.tc.ulife.platform.quartz.quartzmanage;
import org.apache.log4j.Logger;
import org.quartz.Scheduler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.quartzmanage
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/11/15 0015
 * </p>
 * Time: 下午 7:37
 * </p>
 * Detail:
 * </p>
 */
public class AplicationListener implements ServletContextListener {

    private Logger logger = Logger.getLogger(this.getClass());

    public static Scheduler scheduler = null;

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        this.logger.info("The application start...");

        /* 注册定时任务 */
        try {
//            QuartzManager.addJob("ss" + "1", OrderJob.class, "0/1 * * * * ?");
            this.logger.info("The scheduler register...");
        } catch (Exception se) {
            logger.error(se.getMessage(), se);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        this.logger.info("The application stop...");

        /* 注销定时任务 */
        try {
            // 关闭Scheduler
//            scheduler.shutdown();

            this.logger.info("The scheduler shutdown...");
        } catch (Exception se) {
            logger.error(se.getMessage(), se);
        }
    }

}