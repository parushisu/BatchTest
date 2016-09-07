package jp.co.test.batch.test;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.test.batch.main.BatchTest05;

public class BatchTest05Test {

	@Test
	public void testExecute() {
//		fail("まだ実装されていません");
		BatchTest05 test = new BatchTest05();

		int ret;

		ret = test.execute();
		assertEquals(0, ret);
	}

}
