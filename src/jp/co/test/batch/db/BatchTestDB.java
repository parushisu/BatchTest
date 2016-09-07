package jp.co.test.batch.db;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import jp.co.test.batch.utils.BatchTestException;
import jp.co.test.batch.utils.BatchTestLog;
import jp.co.test.batch.utils.BatchTestProp;

public class BatchTestDB implements Closeable {

    public void close() {
    	try {
    		disconnect();
    	} catch (BatchTestException ex) {
    		ex.printStackTrace();
    	}

//        System.out.println("close!");
		BatchTestLog log = BatchTestLog.getInstance();
		log.debug("close!");
    }

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

    private BatchTestProp prop = null;

    private String driver = null;
	private String url = null;
	private String user = null;
	private String password = null;

    private Connection conn = null;

    public void init(String path) throws BatchTestException {
//    	BatchTestProp prop = new BatchTestProp();
    	prop = BatchTestProp.getInstance();

//    	prop.loadProperties(path);

    	driver = prop.getProperty("db.driver");
    	url = prop.getProperty("db.url");
    	user = prop.getProperty("db.user");
    	password = prop.getProperty("db.password");
    }

    public void connect() throws BatchTestException {
    	String msg = null;

    	try {
		    // Oracle JDBC Driverのロード
		    Class.forName(driver);	//("oracle.jdbc.driver.OracleDriver");

		    // Oracle8iに接続
		    conn = DriverManager.getConnection(url, user, password);	//("jdbc:oracle:thin:@192.168.0.22:1521:xe", "pmc_tool", "as54gfjo1");
    	} catch (SQLException ex) {
    		msg = ex.getMessage();
    		throw new BatchTestException(msg);
    	} catch (ClassNotFoundException ex) {
    		msg = ex.getMessage();
    		throw new BatchTestException(msg);
    	}
	}

    public void disconnect() throws BatchTestException {
    	String msg = null;

    	if (conn == null) {
    		return;
    	}

    	try {
		    // 接続をクローズ
		    conn.close();
    	} catch (SQLException ex) {
    		msg = ex.getMessage();
    		throw new BatchTestException(msg);
    	}

	    conn = null;
    }

	public int select(String sql) throws BatchTestException {
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
    		throw new BatchTestException(msg);
    	} finally {
		    // 結果セットをクローズ
    		if (rset != null) {
    			try {
    				rset.close();
    				rset = null;
    			} catch (SQLException ex) {
    	    		msg = ex.getMessage();
    	    		throw new BatchTestException(msg);
    			}
    		}
		    // ステートメントをクローズ
    		if (stmt != null) {
    			try {
	    			stmt.close();
	    			stmt = null;
    			} catch (SQLException ex) {
    	    		msg = ex.getMessage();
    	    		throw new BatchTestException(msg);
    			}
    		}
    	}

//	    return result.toString();
	   	return row;
	}

	public String getSQL(String key) {
		if (prop == null) {
			return null;
		}

		return prop.getProperty(key);
	}

}
