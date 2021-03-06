package jp.co.test.batch.main;

import java.util.ArrayList;

import jp.co.hello.batch.db.HelloBatchOracleDB;
import jp.co.hello.batch.main.HelloBatchMain;
import jp.co.hello.batch.utils.HelloBatchException;
import jp.co.hello.batch.utils.HelloBatchMessage;
import jp.co.test.batch.bean.CarData;

public class BatchTest05 extends HelloBatchMain implements HelloBatchOracleDB.MyClassCallbacks {

	public static final String PROP_NAME_MSG = "jp/co/test/batch/conf/settings.properties";
	public static final String PROP_NAME_SQL = "jp/co/test/batch/conf/sql.properties";

	int columnCount = 0;
	ArrayList<CarData> resultList = null;

	public void callbackColumnCount(int cnt) {
		if (resultList == null) {
			columnCount = cnt;

			resultList = new ArrayList<CarData>();
		}
	}

	public void callbackOneData(int row, int col, Object obj) {
    	CarData sl = null;
    	if (col == 1) {
    		sl = new CarData();
    		sl.setCarKatasiki(obj.toString());
    		resultList.add(sl);
    	} else if (col == 2) {
    		sl = resultList.get(row - 1);
    		sl.setCarName(obj.toString());
    	}
    }

	public void init(HelloBatchOracleDB db) throws HelloBatchException {
		super.init();

//		HelloBatchMessage msg = HelloBatchMessage.getInstance();
		HelloBatchMessage msg = new HelloBatchMessage(PROP_NAME_MSG);
    	String message = msg.getString("app.menu.001");
    	log.info(message);

    	log.info(db.toString());

    	db.setCallbacks(this);

    	db.init(PROP_NAME_SQL);
	}

	public int execute() {
	    try (HelloBatchOracleDB db = new HelloBatchOracleDB()) {
	    	init(db);

	    	db.connect();

	    	String sql = db.getSQL("sql.sel.001");

	    	int cnt = db.select(sql);
	    	log.debug("Data Count = " + cnt);

	    	for (int i = 0; i < cnt; i++) {
	    		CarData data = resultList.get(i);
	    		String carKatasiki = data.getCarKatasiki();
	    		String carName = data.getCarName();
		    	log.debug(carKatasiki + ", " + carName);
	    	}
	    } catch (HelloBatchException ex) {
	    	log.error(ex.getMessage());
	    }

    	log.info("BatchTest05 bye!");

		return 0;
	}

}
