package com.stream.distinct;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaStreamDistinctExamples {

	public static void main(String[] args) {
		Employee lokesh = new Employee(1, "Lokesh", "Gupta");
		Employee brian = new Employee(2, "Brian", "Clooney");
		Employee alex = new Employee(3, "Alex", "Kolen");

		// Add some random Employees
		Collection<Employee> list = Arrays.asList(lokesh, brian, alex, lokesh, brian, lokesh);
		// System.out.println(list);
		List<Employee> distinctObject = list.stream().filter(distinctByKey(p -> p.getId()))
				.collect(Collectors.toList());
		System.out.println("Distinct::=>" + distinctObject);

	}

	// Utility Function
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {

		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

}
