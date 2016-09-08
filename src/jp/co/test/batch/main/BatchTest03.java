package jp.co.test.batch.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jp.co.hello.batch.main.HelloBatchMain;

public class BatchTest03 extends HelloBatchMain {

	/**
	 * 数値の計算処理を行う
	 */
	@FunctionalInterface
	public interface Operator {
	    public int apply(int x, int y);
	}

	public int execute() {
		init();

		log.info("##### Lambda #####");

		String[] array = { "C", "a", "B" };
		Arrays.sort(array, (a, b) -> a.compareToIgnoreCase(b));
		log.info("Test1 : array = " + Arrays.asList(array));

		Operator plus = (x, y) -> x + y;
		Operator minus = (x, y) -> x - y;
		Operator multiply = (x, y) -> x * y;
		Operator divide = (x, y) -> x / y;
	    log.info("Test2 : plus = " + plus.apply(1, 2) + ", minus = " + minus.apply(3, 1) + ", multiply = " + multiply.apply(3, 4) + ", divide = " + divide.apply(5, 2));

	    log.info("Test3 : list =");
	    List<String> list = Arrays.asList("a", "b", "c", "d");
	    list.forEach(string -> log.info("  " + string));

	    log.info("Test4 : stringList =");
	    List<String> stringList = new ArrayList<String>();
	    stringList.add("japan");
	    stringList.add("usa");
	    stringList.add("england");
	    stringList.forEach(string -> log.info("  " + string));

	    log.info("Test5 : stringArray =");
	    String[] stringArray = { "japan", "usa", "england" };
	    Arrays.asList(stringArray).forEach(string -> log.info("  " + string));

	    log.info("Test6 : stringMap =");
	    Map<String, String> stringMap = new HashMap<String, String>();
	    stringMap.put("japan", "japanese");
	    stringMap.put("usa", "english");
	    stringMap.put("england", "english");
	    stringMap.forEach((key, value) -> {
	        log.info("  " + key + " = " + value);
	    });

	    log.info("Test7 : stringList7 =");
	    List<String> stringList7 = new ArrayList<String>();
	    stringList7.add("japan");
	    stringList7.add("usa");
	    stringList7.add("england");
	    stringList7.add("");
	    stringList7.add(null);
	    log.info("  " + stringList7.toString());

	    log.info("Test8 : filterList =");
	    List<String> filterList = stringList.stream().filter(string -> string != null && !string.isEmpty()).collect(Collectors.toList());
	    log.info("  " + filterList.toString());

	    log.info("Test9 : filterList9 =");
	    Comparator<String> comparator = (p, o) -> p.compareTo(o);
	    comparator = comparator.thenComparing((p, o) -> o.compareTo(p));
	    List<String> filterList9 = stringList.stream().sorted(comparator).collect(Collectors.toList());
	    log.info("  " + filterList9.toString());

	    List<Long> longList = new ArrayList<Long>();
	    longList.add(1L);
	    longList.add(2L);
	    longList.add(3L);
	    Long count = longList.stream().reduce((base, value) -> base + value).get();
	    log.info("Test10 : longList = " + longList + ", count = " + count);

	    List<String> stringList11 = new ArrayList<String>();
	    stringList11.add("1");
	    stringList11.add("2");
	    stringList11.add("3");
	    List<Long> longList11 = stringList11.stream().map(string -> Long.valueOf(string)).collect(Collectors.toList());
	    log.info("Test11 : longList11 = " + longList11);

	    List<String> stringList12 = new ArrayList<>();
	    stringList12.add("1");
	    stringList12.add("2");
	    stringList12.add("3");
	    boolean result = stringList12.stream().anyMatch(string -> "1".equals(string));
	    log.info("Test12 : result = " + result);

		log.info("BatchTest03 bye!");

		return 0;
	}

}
