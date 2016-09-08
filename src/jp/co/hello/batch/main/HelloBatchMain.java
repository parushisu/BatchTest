package jp.co.hello.batch.main;

import jp.co.hello.batch.utils.HelloBatchLog;

/**
 * Hello Batch Framework - Main
 *
 * @author palsysuser
 */
public abstract class HelloBatchMain {

	/** Hello Batch Framework - Log */
	protected HelloBatchLog log = null;

	/**
	 * 初期化を行う。
	 */
	protected void init() {
		log = HelloBatchLog.getInstance();
	}

	/**
	 * クラスのメイン処理を実行する。
	 *
	 * @return 終了コード
	 */
	public abstract int execute();

}
