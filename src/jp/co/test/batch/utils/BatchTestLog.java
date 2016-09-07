package jp.co.test.batch.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BatchTestLog {

	private static final BatchTestLog log = new BatchTestLog();

	private Logger logger = null;

	public static BatchTestLog getInstance() {
		if (log.logger == null) {
			log.logger = LogManager.getLogger(BatchTestLog.class);
		}

		return log;
	}

	private BatchTestLog() {

	}

	public void debug(String msg) {
		if (logger == null) {
			return;
		}

		logger.debug(msg);
	}

	public void debug(String msg, Object... arg) {
		if (logger == null) {
			return;
		}

		logger.debug(msg, arg);
	}

	public void info(String msg) {
		if (logger == null) {
			return;
		}

		logger.info(msg);
	}

	public void info(String msg, Object... arg) {
		if (logger == null) {
			return;
		}

		logger.info(msg, arg);
	}

	public void warn(String msg) {
		if (logger == null) {
			return;
		}

		logger.warn(msg);
	}

	public void warn(String msg, Object... arg) {
		if (logger == null) {
			return;
		}

		logger.warn(msg, arg);
	}

	public void error(String msg) {
		if (logger == null) {
			return;
		}

		logger.error(msg);
	}

	public void error(String msg, Object... arg) {
		if (logger == null) {
			return;
		}

		logger.error(msg, arg);
	}

	public void fatal(String msg) {
		if (logger == null) {
			return;
		}

		logger.fatal(msg);
	}

	public void fatal(String msg, Object... arg) {
		if (logger == null) {
			return;
		}

		logger.fatal(msg, arg);
	}

}
