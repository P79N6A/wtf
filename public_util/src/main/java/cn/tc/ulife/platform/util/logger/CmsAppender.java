package cn.tc.ulife.platform.util.logger;

import org.apache.log4j.Layout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * Title: CMSAppender.java
 * </p>
 * <p>
 * Description: log4j 打印日志用的，用于定制日志文件命名格式等
 * </p>
 */
public class CmsAppender extends RollingFileAppender
{
	private String extName;
	private String logPath;

	public CmsAppender()
	{
		logPath = "..\\logs\\";
	}

	public CmsAppender(Layout layout, String filename) throws IOException
	{
		super(layout, filename);
		logPath = "..\\logs\\";
	}

	public CmsAppender(Layout layout, String filename, boolean append)
			throws IOException
	{
		super(layout, filename, append);
		logPath = "..\\logs\\";
	}

	/**
	 * 文件翻转。先关闭当前日志文件，再新建下个日志文件。 生成文件名，然后调用this.setFile方法翻转文件。
	 */
	@Override
	public void rollOver()
	{
		fileName = createFileName();
		File file = new File(fileName);
		if (file.exists())
		{
			file.delete();
		}
		try
		{
			setFile(fileName, false, bufferedIO, bufferSize);
		}
		catch (IOException e)
		{
			LogLog.error("setFile(" + fileName + ", false) call failed.", e);
		}
	}

	/**
	 * 产生文件名。 根据配置的文件名前缀、后缀加上路径，规则如下： 路径 ＋ 文件名前缀 ＋ "_" ＋ 时间（yyyyMMddHHmmss）＋ "."
	 * ＋ 文件名后缀
	 * 
	 * @return
	 */
	public String createFileName()
	{
		File dir = new File(logPath);
		if (!dir.exists())
		{
			dir.mkdirs();
		}
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		String time = date.format(new Date());
		StringBuffer tmpSb = new StringBuffer();
		tmpSb.append(logPath).append(extName).append(time).append(".log");
		return tmpSb.toString();
	}

	/**
	 * 翻转文件。如果文件是以append的方式打开，则CountingQuietWriter要加上文件的大小
	 * 
	 * @param fileName
	 *            文件名
	 * @param append
	 *            是否以增加的形式打开文件
	 * @param bufferedIO
	 *            是否缓存输出
	 * @param bufferSize
	 *            缓存大小
	 */
	@Override
	public void setFile(String file)
	{
		String tempFileName = file.trim();
		if (file.indexOf("/") > -1)
		{
			logPath = file.substring(0, file.lastIndexOf("/"));
			tempFileName = file.substring(file.lastIndexOf("/"));
		}
		extName = tempFileName;
		fileName = createFileName();
	}

	/**
	 * 覆盖父类的方法，写日志之前先判断是否已达到翻转条件，有两个翻转条件： 1、日期已改变
	 * 2、文件大小加上将要写的这条记录的大小大于maxFileSize 二者满足其一即关闭当前文件，写到新文件中
	 * 
	 * @see org.apache.log4j.WriterAppender#subAppend(org.apache.log4j.spi.LoggingEvent)
	 */
	@Override
	protected void subAppend(LoggingEvent event)
	{
		if (fileName != null && !compareFileNameWithSysDate(fileName))
		{
			rollOver();
		}
		super.subAppend(event);
	}

	/**
	 * 判断日志文件名， 日期是否为当前日期，如果是就不创建新文件
	 * 
	 * @param fileName
	 * @return
	 */
	private boolean compareFileNameWithSysDate(String fileName)
	{
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		String sDate = date.format(new Date());
		int index = fileName.lastIndexOf("_");
		String dateOfFileName = fileName.substring(index + 1, index + 9);
		return dateOfFileName.equals(sDate);
	}
}