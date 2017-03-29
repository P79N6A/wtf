package cn.tc.ulife.platform.util.thread;

import org.apache.log4j.Logger;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with uApp.
 * </p>
 * PackageName:cn.tc.ulife.thread
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/6/15 0015
 * </p>
 * Time: 上午 10:12
 * </p>
 * Detail:
 * </p>
 */
public class CustomThreadPool {

    private static Logger logger = Logger.getLogger(CustomThreadPool.class);

    private static ThreadPoolExecutor executors;

    private static int initThread = 5;

    private static int maxThread = 20;

    private static long keepTime = 10L;

    private static TimeUnit unit = TimeUnit.SECONDS;

    private static LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>(1000);

    private static CustomThreadPool customThreadPool = null;

    private CustomThreadPool() {

    }


    public static void execute(Runnable runnable) {

        if (customThreadPool == null) {

            synchronized (CustomThreadPool.class) {
                if (customThreadPool == null) {
                    logger.info("线程池第一次初始化.....");
                    customThreadPool = new CustomThreadPool();
                    executors = new ThreadPoolExecutor(initThread, maxThread, keepTime, unit, linkedBlockingQueue);
                }
            }
        }
        try {
            executors.execute(runnable);
        } catch (Exception e) {
//            e.printStackTrace();
            logger.error("线程池执行失败{}", e);

        }

    }


    public static void main(String[] args) {
//        PayBillRunnable payBillRunnable = new PayBillRunnable();
//        OrderServiceImpl o = new OrderServiceImpl();
//        payBillRunnable.setPayOrderBean(o.getPayOrder("1", "1", "1", "2",
//                new PlatOrder(), "4", "^"));
        CustomThreadPool.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println("111");
            }
        });
        CustomThreadPool.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println("111");
            }
        });
        CustomThreadPool.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println("111");
            }
        });
    }

}
