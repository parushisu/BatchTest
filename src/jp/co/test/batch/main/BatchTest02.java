package jp.co.test.batch.main;

import java.io.Closeable;
import java.io.IOException;

import jp.co.hello.batch.main.HelloBatchMain;
import jp.co.hello.batch.utils.HelloBatchLog;

public class BatchTest02 extends HelloBatchMain {

	private class TestResource02 implements Closeable {

	    public void close() {
			HelloBatchLog log = HelloBatchLog.getInstance();
			log.debug("close!");
	    }

	    public String toString() {
	        return "This is a TestResource02 Object";
	    }

	    public int execute(String key) throws IOException, NullPointerException {
	    	int ret = 0;

	    	if (key == null) {
	    		key = "";
	    	}

	    	switch (key) {
	    	case "test":
	    		break;
	    	case "ztest":
	    		throw new IOException("TestResource02 ztest error!");
	    	default:
	    		throw new NullPointerException("TestResource02 default error!");
	    	}

	    	return ret;
	    }

	}

	private String execKey = null;

	public void setExecKey(String key) {
		this.execKey = key;
	}

	public int execute() {
		init();

		int ret = 0;

	    try (TestResource02 test = new TestResource02()) {
	    	log.info(test.toString());
	    	test.execute(execKey);
	    } catch (IOException | NullPointerException ex) {
	    	log.error(ex.getMessage());
	    	if (ex instanceof IOException) {
	    		ret = -1;
	    	} else {
	    		ret = -2;
	    	}
	    }

	    log.info("BatchTest02 bye!");

		return ret;
	}

}
