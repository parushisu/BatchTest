package jp.co.test.batch.main;

import jp.co.test.batch.utils.BatchTestLog;

public abstract class BatchTest00 {

	protected BatchTestLog log = null;

	protected void init() {
		log = BatchTestLog.getInstance();
	}

	public abstract int execute();

}
