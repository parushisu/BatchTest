package jp.co.hello.batch.db;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import jp.co.hello.batch.utils.HelloBatchException;
import jp.co.hello.batch.utils.HelloBatchLog;
import jp.co.hello.batch.utils.HelloBatchProp;

/**
 * Hello Batch Framework - DB
 *
 * @author palsysuser
 */
public abstract class HelloBatchDB implements Closeable {

	protected static final int INDEX_ORACLE = 1;
	protected static final int INDEX_DB2 = 2;
//	protected enum Index {
//		INDEX_ORACLE,
//		INDEX_DB2
//	}

	private static final String PROP_NAME = "jp/co/hello/batch/conf/db.properties";

    /**
     * リソースをクローズする。
     *
     * @see java.io.Closeable#close()
     */
    public void close() {
    	try {
    		disconnect();
    	} catch (HelloBatchException ex) {
    		ex.printStackTrace();
    	}

		HelloBatchLog log = HelloBatchLog.getInstance();
		log.debug("close!");
    }

    /**
     * オブジェクトを文字列にする。
     *
     * @see java.lang.Object#toString()
     * @return オブジェクトを文字列にしたもの
     */
    public String toString() {
        return "This is a BatchTestDB Object";
    }

    public interface MyClassCallbacks {
    	public void callbackColumnCount(int cnt);
        public void callbackOneData(int row, int col, Object obj);
    }

    private MyClassCallbacks _myClassCallbacks;

    public void setCallbacks(MyClassCallbacks myClassCallbacks){
        _myClassCallbacks = myClassCallbacks;
    }

    private int index = 0;

    private HelloBatchProp prop = null;

    private String driver = null;
	private String url = null;
	private String user = null;
	private String password = null;

    private Connection conn = null;

	/**
	 * コンストラクタ
	 *
	 * @param index リソースのインデックス
	 */
	protected HelloBatchDB(int index) {
		this.index = index;
	}

    /**
     * 初期化を行う。
     *
	 * @param path SQL定義プロパティ・ファイルのパス
     * @throws HelloBatchException
     */
    public void init(String path) throws HelloBatchException {
//    	prop = HelloBatchProp.getInstance();
    	HelloBatchProp propdb = new HelloBatchProp(PROP_NAME);

    	driver = propdb.getProperty("db" + index + ".driver");
    	url = propdb.getProperty("db" + index + ".url");
    	user = propdb.getProperty("db" + index + ".user");
    	password = propdb.getProperty("db" + index + ".password");

    	prop = new HelloBatchProp(path);
    }

    /**
     * DBに接続する。
     *
     * @throws HelloBatchException
     */
    public void connect() throws HelloBatchException {
    	String msg = null;

    	try {
		    // Oracle JDBC Driverのロード
		    Class.forName(driver);

		    // Oracle8iに接続
		    conn = DriverManager.getConnection(url, user, password);
    	} catch (SQLException | ClassNotFoundException ex) {
    		msg = ex.getMessage();
    		throw new HelloBatchException(msg);
    	}
	}

    /**
     * DBの接続を解除する。
     *
     * @throws HelloBatchException
     */
    public void disconnect() throws HelloBatchException {
    	String msg = null;

    	if (conn == null) {
    		return;
    	}

    	try {
		    // 接続をクローズ
		    conn.close();
    	} catch (SQLException ex) {
    		msg = ex.getMessage();
    		throw new HelloBatchException(msg);
    	}

	    conn = null;
    }

	/**
	 * クエリを実行する。
	 *
	 * @param sql 実行するSQL
	 * @return 取得した件数
	 * @throws HelloBatchException
	 */
	public int select(String sql) throws HelloBatchException {
//		StringBuffer result = null;
    	String msg = null;
    	Statement stmt = null;
    	ResultSet rset = null;
    	ResultSetMetaData meta = null;
    	int row = 0;
    	int cnt = 0;

	   	try {
		    // ステートメントを作成
		    stmt = conn.createStatement();

		    // 問合せの実行
		    rset = stmt.executeQuery(sql);

		    // 問合せ結果の表示
//		    result = new StringBuffer();
		    row = 0;
		    while (rset.next()) {
		    	meta = rset.getMetaData();
		    	cnt = meta.getColumnCount();
		    	_myClassCallbacks.callbackColumnCount(cnt);
		    	for (int i = 1; i <= cnt; i++) {
		    		_myClassCallbacks.callbackOneData(row + 1, i, rset.getObject(i));
			    	// 列番号による指定
//			    	result.append(rset.getString(i));
//			    	result.append(rset.getObject(i));
//			    	if (i < cnt) {
//			    		result.append("\t");
//			    	}
		    	}
//		    	result.append("\n");

		    	row++;
	        }
    	} catch (SQLException ex) {
    		msg = ex.getMessage();
    		throw new HelloBatchException(msg);
    	} finally {
		    // 結果セットをクローズ
    		if (rset != null) {
    			try {
    				rset.close();
    				rset = null;
    			} catch (SQLException ex) {
    	    		msg = ex.getMessage();
    	    		throw new HelloBatchException(msg);
    			}
    		}
		    // ステートメントをクローズ
    		if (stmt != null) {
    			try {
	    			stmt.close();
	    			stmt = null;
    			} catch (SQLException ex) {
    	    		msg = ex.getMessage();
    	    		throw new HelloBatchException(msg);
    			}
    		}
    	}

//	    return result.toString();
	   	return row;
	}

	/**
	 * リソースからSQLを取得する。
	 *
	 * @param key SQLのキー
	 * @return キーに対応するSQL
	 */
	public String getSQL(String key) {
		if (prop == null) {
			return null;
		}

		return prop.getProperty(key);
	}

}
