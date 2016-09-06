package jp.co.test.batch.main;

public class BatchTest {

	public static void main(String[] args) {
		int ret;

//		ret = test01();
//		ret = test02();
		ret = test03();
//		ret = test04();

		System.exit(ret);
	}

	public static int test01() {
		BatchTest01 test = new BatchTest01();

		int ret = test.execute();

		return ret;
	}

	public static int test02() {
		BatchTest02 test = new BatchTest02();

		int ret = test.execute();

		return ret;
	}

	public static int test03() {
		BatchTest03 test = new BatchTest03();

		int ret = test.execute();

		return ret;
	}

	public static int test04() {
		BatchTest04 test = new BatchTest04();

		int ret = test.execute();

		return ret;
	}

}
