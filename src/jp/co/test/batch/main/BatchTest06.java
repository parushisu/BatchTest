package jp.co.test.batch.main;

import jp.co.test.batch.utils.BatchTestLog;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class BatchTest06 extends BatchTest00 {

	public int execute() {
//		Logger logger = Logger.getLogger("Sample");
//
//		BasicConfigurator.configure();
//
////		logger.setLevel(Level.WARN);
//		logger.setLevel(Level.ALL);

//		Logger logger = LogManager.getLogger(BatchTest06.class);
//
//		logger.debug("debug!!!");
//		logger.info("info!!!");
//		logger.warn("warn!!!");
//		logger.error("error!!!");
//		logger.fatal("fatal!!!");

		BatchTestLog log = BatchTestLog.getInstance();

		log.debug("debug!!!");
		log.info("info {}!!!", "情報");
		log.warn("warn {}!!!", "警告");
		log.error("error!!!");
		log.fatal("fatal!!!");

//		System.out.println("BatchTest06!");
    	log.info("BatchTest06 bye!");

		return 0;
	}

}
