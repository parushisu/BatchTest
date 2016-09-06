package jp.co.test.batch.main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class BatchTest04 extends BatchTest00 {

	public interface Collection<E> extends Iterable<E> {
	    default Stream<E> stream() {
	        return StreamSupport.stream(spliterator(), false);
	    }
	}

	public int execute() {
		List<String> list = Arrays.asList("C", "C++", "Java", "Scala", "Ruby");

	    System.out.println("##### Stream #####");

	    long count = list.stream()
                .filter(s -> s.startsWith("C"))
                .mapToInt(s -> s.length())
                .sum();
	    System.out.println("Test1 : count = " + count);

	    String[] words = Stream.of("C", "C++", "Java", "Scala", "Ruby")
                .map(s -> s.toUpperCase())
                .sorted()
                .toArray(String[]::new);
	    System.out.println("Test2 : words = " + Arrays.asList(words));

	    IntSummaryStatistics stats = IntStream.generate(() -> (int)(Math.random() * 100))
                .filter(n -> n >= 80)
                .distinct()
                .limit(3)
                .summaryStatistics();
	    System.out.println("Test3 : stats = " + stats);

	    List<String> fizzBuzz = IntStream.rangeClosed(1, 100)
                .mapToObj(n ->
                        (n % 15 == 0) ? "FizzBuzz" :
                        (n % 3 == 0) ? "Fizz" :
                        (n % 5 == 0) ? "Buzz" :
                        String.valueOf(n))
                .collect(Collectors.toList());
	    System.out.println("Test4 : fizzBuzz = " + fizzBuzz);

	    long count2 = list.parallelStream()
                .filter(s -> s.startsWith("C"))
                .mapToInt(s -> s.length())
                .sum();
	    System.out.println("Test5 : count2 = " + count2);

	    System.out.println("\n##### Optional #####");

	    Optional<String> value = getConfigValue("lang");
	    String lang = value.orElse("en");
	    System.out.println("Test1 : lang = " + lang);

	    Optional<String> value2 = getConfigValue("lang2");
	    String lang2 = value2.orElseGet(() -> {
	        // more complicated logic
	        return "en";
	    });
	    System.out.println("Test2 : lang2 = " + lang2);

	    String lang3 = "en";
	    Optional<String> value3 = getConfigValue("lang3");
	    if (value3.isPresent()) {
	        lang3 = value3.get();
	    }
	    System.out.println("Test3 : lang3 = " + lang3);

	    System.out.println("\n##### Misc #####");

	    System.out.println("Test1 : interfaceのdefault/staticメソッド");

	    String join1 = String.join(", ", "A", "B", "C");
	    String join2 = String.join(", ", new String[]{"A", "B", "C"});
	    String join3 = String.join(", ", Arrays.asList("A", "B", "C"));
	    System.out.println("Test2 : join1 = " + join1 + ", join2 = " + join2 + ", join3 = " + join3);

	    String username = "username";
	    String password = "password";
	    Base64.Encoder encoder = Base64.getEncoder();
	    String original = username + ":" + password;
	    String encoded = encoder.encodeToString(original.getBytes(StandardCharsets.UTF_8));
	    System.out.println("Test3 : encoded = " + encoded);

	    System.out.println("Test4 : lines =");
	    Path path = Paths.get("/tmp/changes.log");
	    try (Stream<String> lines = Files.lines(path)) {
	        lines.forEach(System.out::println);
	    } catch (IOException e) {
	    }

	    System.out.println("\nBatchTest04 bye!");

		return 0;
	}

	private Optional<String> getConfigValue(String key) {
	    if (!containsKey(key)) {
	        return Optional.empty();
	    }
	    return Optional.of(getValue(key));
	}

	private boolean containsKey(String key) {
		return (key != null) ? true : false;
	}

	private String getValue(String key) {
		return (key != null) ? key : "";
	}

}
