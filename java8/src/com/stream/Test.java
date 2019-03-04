package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		Test.sumOfNumber(Arrays.asList(1, 2, 3, 4, 9, 11));
		System.out.println("Total Sum::==" + Test.sumOfNumber(Arrays.asList(1, 2, 3, 4, 9, 11)));
		System.out.println("------------------");
		Stream<Integer> stream = Stream.of(1, 2, 34, 56, 77);
		stream.forEach(n -> System.out.println(n));

		System.out.println("----------");
		Stream<String> stream2 = Stream.of(new String[] { "rt", "pl", "rk" });
		stream2.forEach(System.out::println);

		System.out.println("------------");

		Stream<Date> stream3 = Stream.generate(() -> {
			return new Date();
		});
		stream3.limit(1).forEach(System.out::println);

		System.out.println("----------------");

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);

		}
		list.stream().filter(t -> t % 2 == 0).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("------------------");

		List<String> list2 = new ArrayList<>();
		list2.add("Ravi");
		list2.add("suraj");
		list2.add("vishal");
		list2.add("saurav");
		list2.add("arun");

		list2.stream().filter(e -> e.startsWith("s")).limit(1).map(String::toUpperCase).collect(Collectors.toList())
				.forEach(System.out::println);
		System.out.println("************");

		List<String> upper = list2.stream().sorted().filter(u -> u.endsWith("l")).map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println(upper);
		System.out.println("**************");
		long l = list2.stream().sorted().filter(u -> u.endsWith("l")).map(String::toUpperCase).count();
		System.out.println(l);

		System.out.println("-------------");

		Optional<String> optional = list2.parallelStream().reduce((a1, a2) -> a1 + "@" + a2);
		optional.ifPresent(System.out::println);

		System.out.println("--------------");

		Integer maxNumber = Stream.of(23, 45, 67, 34, 12).max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(maxNumber);

		String max = Stream.of("a", "abc", "t").max(Comparator.comparing(String::valueOf)).get();
		System.out.println("max->" + max);

		System.out.println("---------------");
		long count = Stream.of("how", "to", "do", "in", "java").count();
		System.out.printf("There are %s elements in the stream %n", count);

		System.out.println("----------------");

		List<String> list3 = new ArrayList<>(Arrays.asList("a", "a", "d", "d", "f"));
		List<String> repeat = list3.stream().distinct().collect(Collectors.toList());
		System.out.println(repeat);
		System.out.println("--------------------");

		Stream<String> stream21 = Stream.iterate("abc", (i) -> i).limit(2);
		stream21.forEach(System.out::println);

		System.out.println("---------------------------");

		//////////// FlatMap////////////////////

		Stream<List<String>> list4 = Stream.of(Arrays.asList("Ravi"), Arrays.asList("Ravi", "Suman"),
				Arrays.asList("Suraj", "Vishal"));

		Stream<String> flatmap = list4.flatMap(strList -> strList.stream());
		flatmap.forEach(System.out::println);

		System.out.println("======================");

		////////////// toArray()/////////////////

		Stream<Integer> integer = Stream.of(2, 4, 5, 9, 45);
		Integer[] intArray = integer.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArray));
		System.out.println("=====================");

		/////////////// Stream reduce() example//////////////

		Stream<Integer> no = Stream.of(1, 2, 3, 4, 5);
		Optional<Integer> intMultiplication = no.reduce((i, j) -> {
			return i * j;
		});
		if (intMultiplication.isPresent()) {
			System.out.println("Multiplication of::=>" + intMultiplication.get());
		}

		System.out.println("========================");

		/////////////// Stream match() examples ////////////////
		Stream<Integer> number1 = Stream.of(1, 2, 3, 4, 5, 6);
		System.out.println("Stream contains 4?==>" + number1.anyMatch(i -> i == 4));

		Stream<Integer> number2 = Stream.of(1, 2, 3, 4, 5, 6);
		System.out.println("Stream contains all elements less than 10?==>" + number2.allMatch(i -> i > 10));

		Stream<Integer> number3 = Stream.of(1, 2, 3, 4, 5, 6);
		System.out.println("Stream doesn't contain 10?==>" + number3.noneMatch(i -> i == 10));

		System.out.println("=========================");

		//////////////////// Stream findFirst() example: This is a short circuiting
		//////////////////// terminal operation /////////////////////////

		Stream<String> names4 = Stream.of("Pankaj", "Amit", "David", "Lisa");
		Optional<String> find = names4.filter(i -> i.startsWith("A")).findFirst();
		if (find.isPresent()) {
			System.out.println("Names Start With A ::=>" + find.get());
		}

		System.out.println("========================");

	}

	private static int sumOfNumber(List<Integer> list) {
		return list.stream().filter(i -> i < 10).mapToInt(i -> i).sum();

	}

}
