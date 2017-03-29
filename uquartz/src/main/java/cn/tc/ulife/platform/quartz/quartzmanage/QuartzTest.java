package cn.tc.ulife.platform.quartz.quartzmanage;

import java.util.Date;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.quartz
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/15 0015
 * </p>
 * Time: 上午 10:07
 * </p>
 * Detail:
 * </p>
 */
public class QuartzTest {

    public static void main(String[] args) {
        try {
            String job_name = "动态任务调度";



//            System.out.println("【系统启动】开始(每1秒输出一次)...");
//            QuartzManager.addJob(job_name, OrderJob.class, "0/1 * * * * ?");
//            QuartzManager.addJob(job_name+"1", OrderJob.class, "0/1 * * * * ?");
////            QuartzManager.addJob(job_name+"2", OrderJob.class, "0/1 * * * * ?");
////            QuartzManager.addJob(job_name+"3", OrderJob.class, "0/1 * * * * ?");
//            QuartzManager.removeJob(job_name);
//            System.out.println("【移除定时】成功");
//            Thread.sleep(5000);
//            System.out.println("【修改时间】开始(每2秒输出一次)...");
//            QuartzManager.modifyJobTime(job_name, "10/2 * * * * ?");
//            Thread.sleep(6000);
//            System.out.println("【移除定时】开始...");
//            QuartzManager.removeJob(job_name);
//            System.out.println("【移除定时】成功");
//
//            System.out.println("【再次添加定时任务】开始(每10秒输出一次)...");
//            QuartzManager.addJob(job_name, OrderJob.class, "*/10 * * * * ?");
//            Thread.sleep(60000);
//            System.out.println("【移除定时】开始...");
//            QuartzManager.removeJob(job_name);
//            System.out.println("【移除定时】成功");
            String cron = UtilToString.getCron(new Date(), 12);
//            QuartzManager.addJob(job_name, OrderJob.class, cron);
            System.out.println(cron);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
