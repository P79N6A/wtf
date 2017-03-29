package cn.tc.ulife.platform.util.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * <p>
 * Title: LogManager.java
 * </p>
 * <p>
 * Description:
 * </p>
 */
public class LogManager {
	private Logger userLog = Logger.getLogger("userLog");// 用户日志对象
	private Logger runLog = Logger.getLogger("runLog");// 运行日志对象
	private Logger operateLog = Logger.getLogger("operateLog");// 操作日志对象

	// private Logger sercurityLog = Logger.getLogger("securityLog");// 安全日志对象
	private static LogManager logManager = null;

	private LogManager() {
	}

	public static synchronized LogManager getLogManager() {
		if (null == logManager) {
			logManager = new LogManager();
		}
		return logManager;
	}

	public void updateConfig() {
		PropertyConfigurator.configure("/log4j.properties");
	}

	/**
	 * @return Returns the runLog.
	 */
	public Logger getRunLog() {
		return runLog;
	}

	/**
	 * @param runLog
	 *            The runLog to set.
	 */
	public void setRunLog(Logger runLog) {
		this.runLog = runLog;
	}

	/**
	 * @return the operateLog
	 */
	public Logger getOperateLog() {
		return operateLog;
	}

	/**
	 * @param operateLog
	 *            the operateLog to set
	 */
	public void setOperateLog(Logger operateLog) {
		this.operateLog = operateLog;
	}

	/**
	 * @return the userLog
	 */
	public Logger getUserLog() {
		return userLog;
	}

	/**
	 * @param userLog
	 *            the userLog to set
	 */
	public void setUserLog(Logger userLog) {
		this.userLog = userLog;
	}

}
