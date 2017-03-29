package cn.tc.ulife.platform.server.remote;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.QuartzService
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/11/15 0015
 * </p>
 * Time: 下午 3:31
 * </p>
 * Detail:
 * </p>
 */
public interface IQuartzOrderService {


    /**
     * 订单超时设置
     *
     * @param orderNo 订单编号
     * @return
     */
    String processOrderJobByReturn(String orderNo, String time);


    /**
     * 移除超时订单任务
     *
     * @param jobName
     * @return
     */
    String removeJob(String jobName);
//    String processOrderjob

    /**
     * 拼团活动自动解散
     *
     * @param orderNo   订单编号
     * @param allSprice 拼团标识
     * @return
     */
    String processGroupOrderJobByReturn(String orderNo, String allSprice, String time);


}
