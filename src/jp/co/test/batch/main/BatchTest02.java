package jp.co.test.batch.main;

import java.io.IOException;

import jp.co.test.batch.resource.TestResource02;

public class BatchTest02 extends BatchTest00 {

	public int execute() {
	    try (TestResource02 test = new TestResource02()) {
	    	test.execute("test");
	        System.out.println(test);
	    } catch (IOException | NullPointerException ex) {
	    	System.err.println(ex.getMessage());
	    }

	    System.out.println("BatchTest02 bye!");

		return 0;
	}

}
