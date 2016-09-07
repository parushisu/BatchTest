package jp.co.test.batch.test;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.test.batch.main.BatchTest04;

public class BatchTest04Test {

	@Test
	public void testExecute() {
//		fail("まだ実装されていません");
		BatchTest04 test = new BatchTest04();

		int ret;

		ret = test.execute();
		assertEquals(0, ret);
	}

}
