package jp.co.test.batch.main;

import jp.co.hello.batch.main.HelloBatchMain;

public class BatchTest01 extends HelloBatchMain {

	public int execute() {
		init();

		log.info("BatchTest01 bye!");

		return 0;
	}

}
