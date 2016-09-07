package jp.co.test.batch.resource;

import java.io.Closeable;
import java.io.IOException;

import jp.co.test.batch.utils.BatchTestLog;

public class TestResource02 implements Closeable {

//	private String key = null;
//
//	public TestResource02(String key) {
//		this.key = key;
//	}

    public void close() {
//		System.out.println("close!");
		BatchTestLog log = BatchTestLog.getInstance();
		log.debug("close!");
    }

    public String toString() {
        return "This is a TestResource02 Object";
    }

    public int execute(String key) throws IOException, NullPointerException {
    	int ret = 0;

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
