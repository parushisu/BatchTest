package jp.co.test.batch.test;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.test.batch.main.BatchTest02;

public class BatchTest02Test {

	@Test
	public void testExecute01() {
		BatchTest02 test = new BatchTest02();

		int ret;

		ret = test.execute();
		assertEquals(-2, ret);
	}

	@Test
	public void testExecute02() {
		BatchTest02 test = new BatchTest02();

		int ret;

		test.setExecKey("test");
		ret = test.execute();
		assertEquals(0, ret);
	}

	@Test
	public void testExecute03() {
		BatchTest02 test = new BatchTest02();

		int ret;

		test.setExecKey("ztest");
		ret = test.execute();
		assertEquals(-1, ret);
	}

}
