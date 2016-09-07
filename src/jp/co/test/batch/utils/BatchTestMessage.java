package jp.co.test.batch.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class BatchTestMessage {

	private static final BatchTestMessage msg = new BatchTestMessage();

	private ResourceBundle rb = null;

	public static BatchTestMessage getInstance() throws BatchTestException {
		if (msg.rb == null) {
			msg.init();
		}

		return msg;
	}

	private BatchTestMessage() {

	}

	public void init() throws BatchTestException {
		if (rb == null) {
	    	BatchTestProp prop = BatchTestProp.getInstance();
	    	String baseName = prop.getProperty("message.basename");
	    	Locale loc = Locale.getDefault();
	    	if (loc == null) {
	    		loc = Locale.ENGLISH;
	    	}
	    	rb = ResourceBundle.getBundle(baseName, loc);
		}
	}

	public String getString(String key) {
		if (rb == null) {
			return null;
		}

		String str = rb.getString(key);

		return str;
	}

}
