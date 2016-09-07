package jp.co.test.batch.test;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.test.batch.main.BatchTest06;

public class BatchTest06Test {

	@Test
	public void testExecute() {
//		fail("まだ実装されていません");
		BatchTest06 test = new BatchTest06();

		int ret;

		ret = test.execute();
		assertEquals(0, ret);
	}

}
