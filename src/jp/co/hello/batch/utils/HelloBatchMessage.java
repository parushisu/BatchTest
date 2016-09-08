package jp.co.hello.batch.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Hello Batch Framework - Message
 *
 * @author palsysuser
 */
public class HelloBatchMessage {

	/** このクラスの単一インスタンス */
	private static final HelloBatchMessage msg = new HelloBatchMessage();

	/** ResourceBundle */
	private ResourceBundle rb = null;

	/**
	 * 単一インスタンスを取得する。
	 *
	 * @return HelloBatchMessageのインスタンス
	 * @throws HelloBatchException
	 */
	public static HelloBatchMessage getInstance() throws HelloBatchException {
		if (msg.rb == null) {
			msg.init();
		}

		return msg;
	}

	/**
	 * コンストラクタ
	 *   単一インスタンスなので、privateとする
	 */
	private HelloBatchMessage() {}

	/**
	 * 初期化を行う。
	 *
	 * @throws HelloBatchException
	 */
	public void init() throws HelloBatchException {
		if (rb == null) {
	    	HelloBatchProp prop = HelloBatchProp.getInstance();
	    	String baseName = prop.getProperty("message.basename");
	    	Locale loc = Locale.getDefault();
	    	if (loc == null) {
	    		loc = Locale.ENGLISH;
	    	}
	    	rb = ResourceBundle.getBundle(baseName, loc);
		}
	}

	/**
	 * リソースから文字列を取得する。
	 *
	 * @param key リソースのキー
	 * @return キーに対応する文字列
	 */
	public String getString(String key) {
		if (rb == null) {
			return null;
		}

		String str = rb.getString(key);

		return str;
	}

}
