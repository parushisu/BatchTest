package jp.co.test.batch.test;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.test.batch.main.BatchTest01;

public class BatchTest01Test {

	@Test
	public void testExecute() {
//		fail("まだ実装されていません");
		BatchTest01 test = new BatchTest01();
		int ret = test.execute();
		assertEquals(0, ret);
	}

}
