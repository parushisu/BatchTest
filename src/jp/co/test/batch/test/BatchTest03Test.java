package jp.co.test.batch.test;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.test.batch.main.BatchTest03;

public class BatchTest03Test {

	@Test
	public void testExecute() {
//		fail("まだ実装されていません");
		BatchTest03 test = new BatchTest03();

		int ret;

		ret = test.execute();
		assertEquals(0, ret);
	}

}
