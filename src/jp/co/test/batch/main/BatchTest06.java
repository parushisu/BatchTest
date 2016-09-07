package jp.co.test.batch.main;

import jp.co.test.batch.utils.BatchTestLog;

public class BatchTest06 extends BatchTest00 {

	public int execute() {
		BatchTestLog log = BatchTestLog.getInstance();

		log.debug("debug!!!");
		log.info("info {}!!!", "情報");
		log.warn("warn {}!!!", "警告");
		log.error("error!!!");
		log.fatal("fatal!!!");

    	log.info("BatchTest06 bye!");

		return 0;
	}

}
