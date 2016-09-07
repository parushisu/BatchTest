package jp.co.test.batch.resource;

import java.io.Closeable;
import java.io.IOException;

public class TestResource05 implements Closeable {

    public void close() {
        System.out.println("close!");
    }

    public String toString() {
        return "This is a TestResource05 Object";
    }

    public int execute(String key) throws IOException, NullPointerException {
    	int ret = 0;

    	switch (key) {
    	case "test":
    		break;
    	case "ztest":
    		throw new IOException("TestResource05 ztest error!");
    	default:
    		throw new NullPointerException("TestResource05 default error!");
    	}
    	return ret;
    }

}
