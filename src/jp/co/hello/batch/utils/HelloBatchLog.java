package jp.co.hello.batch.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello Batch Framework - Log
 *
 * @author palsysuser
 */
public class HelloBatchLog {

	/** このクラスの単一インスタンス */
	private static final HelloBatchLog log = new HelloBatchLog();

	/** Logger */
	private Logger logger = null;

	/**
	 * 単一インスタンスを取得する。
	 *
	 * @return HelloBatchLogのインスタンス
	 */
	public static HelloBatchLog getInstance() {
		if (log.logger == null) {
			log.logger = LogManager.getLogger(HelloBatchLog.class);
		}

		return log;
	}

	/**
	 * コンストラクタ
	 *   単一インスタンスなので、privateとする
	 */
	private HelloBatchLog() {}

	/**
	 * ログ出力を行う。 (Level = debug)
	 *
	 * @param msg 出力するメッセージ
	 */
	public void debug(String msg) {
		if (logger == null) {
			return;
		}

		logger.debug(msg);
	}

	/**
	 * ログ出力を行う。 (Level = debug)
	 *
	 * @param msg 出力するメッセージ
	 * @param arg メッセージの引数
	 */
	public void debug(String msg, Object... arg) {
		if (logger == null) {
			return;
		}

		logger.debug(msg, arg);
	}

	/**
	 * ログ出力を行う。 (Level = info)
	 *
	 * @param msg 出力するメッセージ
	 */
	public void info(String msg) {
		if (logger == null) {
			return;
		}

		logger.info(msg);
	}

	/**
	 * ログ出力を行う。 (Level = info)
	 *
	 * @param msg 出力するメッセージ
	 * @param arg メッセージの引数
	 */
	public void info(String msg, Object... arg) {
		if (logger == null) {
			return;
		}

		logger.info(msg, arg);
	}

	/**
	 * ログ出力を行う。 (Level = warn)
	 *
	 * @param msg 出力するメッセージ
	 */
	public void warn(String msg) {
		if (logger == null) {
			return;
		}

		logger.warn(msg);
	}

	/**
	 * ログ出力を行う。 (Level = warn)
	 *
	 * @param msg 出力するメッセージ
	 * @param arg メッセージの引数
	 */
	public void warn(String msg, Object... arg) {
		if (logger == null) {
			return;
		}

		logger.warn(msg, arg);
	}

	/**
	 * ログ出力を行う。 (Level = error)
	 *
	 * @param msg 出力するメッセージ
	 */
	public void error(String msg) {
		if (logger == null) {
			return;
		}

		logger.error(msg);
	}

	/**
	 * ログ出力を行う。 (Level = error)
	 *
	 * @param msg 出力するメッセージ
	 * @param arg メッセージの引数
	 */
	public void error(String msg, Object... arg) {
		if (logger == null) {
			return;
		}

		logger.error(msg, arg);
	}

	/**
	 * ログ出力を行う。 (Level = fatal)
	 *
	 * @param msg 出力するメッセージ
	 */
	public void fatal(String msg) {
		if (logger == null) {
			return;
		}

		logger.fatal(msg);
	}

	/**
	 * ログ出力を行う。 (Level = fatal)
	 *
	 * @param msg 出力するメッセージ
	 * @param arg メッセージの引数
	 */
	public void fatal(String msg, Object... arg) {
		if (logger == null) {
			return;
		}

		logger.fatal(msg, arg);
	}

}
