/**
 * 
 */
package cn.tc.ulife.platform.agent.controller.social;

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
@RequestMapping("social")
public class SocialController {

	Logger runlogger = LogManager.getLogManager().getRunLog();

	@RequestMapping("/list")
	@ResponseBody
	public String viewMain() {
		TreeNode treeNode = new TreeNode();
		treeNode.setCode("ADMIN");
//		treeNode.setUserroleId("6000");
//		treeNode.setJsid("1");
		treeNode.setId("1");
		System.out.println("hello");
		runlogger.debug(treeNode.toString());

		LoggerModel loggerModel = new LoggerModel();
		loggerModel.setClassName(this.getClass().getName());
		loggerModel.setDateTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS));
		loggerModel.setMainName("add");
		loggerModel.setOprs("add");
		loggerModel.setParams("[sd,fsdf]");
		loggerModel.setResMsg("ok");
		loggerModel.setExcMsg("error");
		loggerModel.setText("test logsss");

		UserOperatorFactory.getInstance().writeUserLogger(loggerModel);

		return loggerModel.toString();
	}
}
