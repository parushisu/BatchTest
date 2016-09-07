package jp.co.test.batch.main;

import java.util.ArrayList;

import jp.co.test.batch.bean.HelloData;
import jp.co.test.batch.db.BatchTestDB;
import jp.co.test.batch.utils.BatchTestException;
import jp.co.test.batch.utils.BatchTestMessage;

public class BatchTest05 extends BatchTest00 implements BatchTestDB.MyClassCallbacks {

	public static final String PROP_NAME = "jp/co/test/batch/conf/settings.properties";

	int columnCount = 0;
	ArrayList<HelloData> resultList = null;

	public void callbackColumnCount(int cnt) {
		if (resultList == null) {
			columnCount = cnt;

			resultList = new ArrayList<HelloData>();
		}
	}

	public void callbackOneData(int row, int col, Object obj) {
    	HelloData sl = null;
    	if (col == 1) {
    		sl = new HelloData();
    		sl.setCarKatasiki(obj.toString());
    		resultList.add(sl);
    	} else if (col == 2) {
    		sl = resultList.get(row - 1);
    		sl.setCarName(obj.toString());
    	}
    }

	public void init(BatchTestDB db) throws BatchTestException {
		BatchTestMessage msg = BatchTestMessage.getInstance();
    	String message = msg.getString("app.menu.001");
    	System.out.println(message);

    	System.out.println(db);

    	db.setCallbacks(this);

    	db.init(PROP_NAME);
	}

	public int execute() {
	    try (BatchTestDB db = new BatchTestDB()) {
	    	init(db);

	    	db.connect();

	    	String sql = db.getSQL("sql.sel.001");

	    	int cnt = db.select(sql);
	    	System.out.println("Data Count = " + cnt);

	    	for (int i = 0; i < cnt; i++) {
	    		HelloData data = resultList.get(i);
	    		String carKatasiki = data.getCarKatasiki();
	    		String carName = data.getCarName();
	    		System.out.println(carKatasiki + ", " + carName);
	    	}
	    } catch (BatchTestException ex) {
	    	System.err.println(ex.getMessage());
	    }

	    System.out.println("BatchTest05 bye!");

		return 0;
	}

}
