package jp.co.test.batch.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BatchTest03 extends BatchTest00 {

	/**
	 * 数値の計算処理を行う
	 */
	@FunctionalInterface
	public interface Operator {
	    public int apply(int x, int y);
	}

	public int execute() {
		System.out.println("##### Lambda #####");

		String[] array = { "C", "a", "B" };
		Arrays.sort(array, (a, b) -> a.compareToIgnoreCase(b));
		System.out.println("Test1 : array = " + Arrays.asList(array));

		Operator plus = (x, y) -> x + y;
		Operator minus = (x, y) -> x - y;
		Operator multiply = (x, y) -> x * y;
		Operator divide = (x, y) -> x / y;
	    System.out.println("Test2 : plus = " + plus.apply(1, 2) + ", minus = " + minus.apply(3, 1) + ", multiply = " + multiply.apply(3, 4) + ", divide = " + divide.apply(5, 2));

	    System.out.println("Test3 : list =");
	    List<String> list = Arrays.asList("a", "b", "c", "d");
	    list.forEach(System.out::println);

	    System.out.println("\nTest4 : stringList =");
	    List<String> stringList = new ArrayList<String>();
	    stringList.add("japan");
	    stringList.add("usa");
	    stringList.add("england");
	    stringList.forEach(string -> System.out.println(string));

	    System.out.println("\nTest5 : stringArray =");
	    String[] stringArray = { "japan", "usa", "england" };
	    Arrays.asList(stringArray).forEach(string -> System.out.println(string));

	    System.out.println("\nTest6 : stringMap =");
	    Map<String, String> stringMap = new HashMap<String, String>();
	    stringMap.put("japan", "japanese");
	    stringMap.put("usa", "english");
	    stringMap.put("england", "english");
	    stringMap.forEach((key, value) -> {
	        System.out.println(key + " = " + value);
	    });

	    System.out.println("\nTest7 : stringList7 =");
	    List<String> stringList7 = new ArrayList<String>();
	    stringList7.add("japan");
	    stringList7.add("usa");
	    stringList7.add("england");
	    stringList7.add("");
	    stringList7.add(null);
	    System.out.println(stringList7);

	    System.out.println("\nTest8 : filterList =");
	    List<String> filterList = stringList.stream().filter(string -> string != null && !string.isEmpty()).collect(Collectors.toList());
	    System.out.println(filterList);

	    System.out.println("\nTest9 : filterList9 =");
	    Comparator<String> comparator = (p, o) -> p.compareTo(o);
	    comparator = comparator.thenComparing((p, o) -> o.compareTo(p));
	    List<String> filterList9 = stringList.stream().sorted(comparator).collect(Collectors.toList());
	    System.out.println(filterList9);

	    List<Long> longList = new ArrayList<Long>();
	    longList.add(1L);
	    longList.add(2L);
	    longList.add(3L);
	    Long count = longList.stream().reduce((base, value) -> base + value).get();
	    System.out.println("\nTest10 : longList = " + longList + ", count = " + count);

	    List<String> stringList11 = new ArrayList<String>();
	    stringList11.add("1");
	    stringList11.add("2");
	    stringList11.add("3");
	    List<Long> longList11 = stringList11.stream().map(string -> Long.valueOf(string)).collect(Collectors.toList());
	    System.out.println("\nTest11 : longList11 = " + longList11);

	    List<String> stringList12 = new ArrayList<>();
	    stringList12.add("1");
	    stringList12.add("2");
	    stringList12.add("3");
	    boolean result = stringList12.stream().anyMatch(string -> "1".equals(string));
	    System.out.println("\nTest12 : result = " + result);

		System.out.println("\nBatchTest03 bye!");

		return 0;
	}

}
