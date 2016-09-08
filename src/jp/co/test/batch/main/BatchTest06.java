package jp.co.test.batch.main;

import jp.co.hello.batch.main.HelloBatchMain;
import jp.co.hello.batch.utils.HelloBatchLog;

public class BatchTest06 extends HelloBatchMain {

	public int execute() {
		HelloBatchLog log = HelloBatchLog.getInstance();

		log.debug("debug!!!");
		log.info("info {}!!!", "情報");
		log.warn("warn {}!!!", "警告");
		log.error("error!!!");
		log.fatal("fatal!!!");

    	log.info("BatchTest06 bye!");

		return 0;
	}

}
