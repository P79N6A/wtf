package cn.tc.ulife.platform.server.shop.quatz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class TestJob implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        System.out.println("TestJob:" + Thread.currentThread().getName() + "正在执行");
    }
}
