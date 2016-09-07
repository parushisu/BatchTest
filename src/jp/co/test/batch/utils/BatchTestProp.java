package jp.co.test.batch.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BatchTestProp {

	private static final BatchTestProp prop = new BatchTestProp();

	private Properties properties = null;

	public static BatchTestProp getInstance() throws BatchTestException {
		if (prop.properties == null) {
	    	prop.loadProperties("jp/co/test/batch/conf/settings.properties");
		}

		return prop;
	}

	private BatchTestProp() {

	}

	public void loadProperties(String path) throws BatchTestException {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(path));
		} catch (IOException ex) {
			throw new BatchTestException(ex.getMessage());
		}
	}

	public void loadPropertiesByXml(String path) throws BatchTestException {
		properties = new Properties();
		try {
			properties.loadFromXML(new FileInputStream(path));
		} catch (IOException ex) {
			throw new BatchTestException(ex.getMessage());
		}
	}

	public String getProperty(String key) {
		if (properties == null) {
			return "";
		}

		return properties.getProperty(key);
	}

}
