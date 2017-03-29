/**
 * 
 */
package cn.tc.ulife.platform.agent.controller.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tc.ulife.platform.server.tree.model.TreeNode;
import cn.tc.ulife.platform.util.DateStyle;
import cn.tc.ulife.platform.util.DateUtil;
import cn.tc.ulife.platform.util.logger.LogManager;
import cn.tc.ulife.platform.util.logger.LoggerModel;
import cn.tc.ulife.platform.util.logger.UserOperatorFactory;

/**
 * @author lpf
 *
 */
@Controller
@RequestMapping("logger")
public class TestLoggerController {
	
	// 系统运行的日志，主要是定时任务， 线程池 异步流程
	private Logger runlog = LogManager.getLogManager().getRunLog();
	
	// 用户操作日志，记录debug， error，info等 跟踪日志
	private Logger optLog = LogManager.getLogManager().getOperateLog();
	
	@RequestMapping("/log")
	@ResponseBody
	public String viewMain() {
		 

		LoggerModel loggerModel = new LoggerModel();
		// 类名
		loggerModel.setClassName(this.getClass().getName());
		// 操作时间
		loggerModel.setDateTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS));
		// 操作函数
		loggerModel.setMainName("add");
		// 操作类型 add query
		loggerModel.setOprs("add");
		// 请求参数
		loggerModel.setParams("[sd,fsdf]");
		// 返回结果
		loggerModel.setResMsg("ok");
		// 一次结果
		loggerModel.setExcMsg("error");
		// 操作描述
		loggerModel.setText("test logsss");

		// 用户行为日志，记录用户 操作从controller到dao 然后返回结果的一个完整事物流程
		UserOperatorFactory.getInstance().writeUserLogger(loggerModel);

		return loggerModel.toString();
	}
}
