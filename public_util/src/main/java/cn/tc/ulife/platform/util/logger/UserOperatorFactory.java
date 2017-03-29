/**
 * 
 */
package cn.tc.ulife.platform.util.logger;

import org.apache.log4j.Logger;

import cn.tc.ulife.platform.util.thread.CustomThreadPool;

/**
 * @author lpf
 *
 */
public final class UserOperatorFactory {
	private static UserOperatorFactory userOperator;

	private UserOperatorFactory() {

	}

	public static synchronized UserOperatorFactory getInstance() {
		if (null == userOperator) {
			userOperator = new UserOperatorFactory();
		}
		return userOperator;
	}

	public void writeUserLogger(final LoggerModel model) {
		
		CustomThreadPool.execute(new Runnable() {
			
			Logger uLog = LogManager.getLogManager().getUserLog();
			
			@Override
			public void run() {				 
				 uLog.info(model.toString());
			}
		});
	}
}
