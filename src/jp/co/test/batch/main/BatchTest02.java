package jp.co.test.batch.main;

import java.io.IOException;

import jp.co.test.batch.resource.TestResource02;

public class BatchTest02 extends BatchTest00 {

	public int execute() {
		init();

	    try (TestResource02 test = new TestResource02()) {
	    	test.execute("test");
	    	log.info(test.toString());
	    } catch (IOException | NullPointerException ex) {
	    	log.error(ex.getMessage());
	    }

	    log.info("BatchTest02 bye!");

		return 0;
	}

}
