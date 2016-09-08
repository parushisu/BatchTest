package jp.co.hello.batch.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Hello Batch Framework - Property
 *
 * @author palsysuser
 */
public class HelloBatchProp {

//	/** このクラスの単一インスタンス */
//	private static final HelloBatchProp prop = new HelloBatchProp();

	/** Properties */
	private Properties properties = null;

//	/**
//	 * 単一インスタンスを取得する。
//	 *
//	 * @return HelloBatchPropのインスタンス
//	 * @throws HelloBatchException
//	 */
//	public static HelloBatchProp getInstance() throws HelloBatchException {
//		if (prop.properties == null) {
//	    	prop.loadProperties("jp/co/test/batch/conf/settings.properties");
//		}
//
//		return prop;
//	}

	/**
	 * コンストラクタ
	 *   プロパティ・ファイルのパスが必須なので、privateとする
	 */
	private HelloBatchProp() {
	}

	/**
	 * コンストラクタ
	 *
	 * @param path プロパティ・ファイルのパス
	 * @throws HelloBatchException
	 */
	public HelloBatchProp(String path) throws HelloBatchException {
		this();

		loadProperties(path);
	}

	/**
	 * プロパティ・ファイルをロードする。
	 *
	 * @param path プロパティ・ファイルのパス
	 * @throws HelloBatchException
	 */
	public void loadProperties(String path) throws HelloBatchException {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(path));
		} catch (IOException ex) {
			throw new HelloBatchException(ex.getMessage());
		}
	}

	/**
	 * プロパティ・ファイル(XML形式)をロードする。
	 *
	 * @param path プロパティ・ファイルのパス
	 * @throws HelloBatchException
	 */
	public void loadPropertiesByXml(String path) throws HelloBatchException {
		properties = new Properties();
		try {
			properties.loadFromXML(new FileInputStream(path));
		} catch (IOException ex) {
			throw new HelloBatchException(ex.getMessage());
		}
	}

	/**
	 * プロパティ・ファイルから文字列を取得する。
	 *
	 * @param key プロパティのキー
	 * @return キーに対応する文字列
	 */
	public String getProperty(String key) {
		if (properties == null) {
			return "";
		}

		return properties.getProperty(key);
	}

}
