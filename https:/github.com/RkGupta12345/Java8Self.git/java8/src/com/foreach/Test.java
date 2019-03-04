package com.foreach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		List<Integer> number=new ArrayList<>(Arrays.asList(1,3,5,7,8));
		//Consumer<Integer> even=System.out::println;
		number.stream().filter(e->e%2==0).forEach(System.out::println);
		System.out.println("****************");
		
		HashMap<String, Integer> map=new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		
		map.keySet().stream().forEach(System.out::println);
		map.entrySet().stream().forEach(System.out::println);
		map.values().stream().forEach(System.out::println);

		Stream<Integer> stream=Stream.of(1,2,34,56,67);
		stream.forEach(System.out::println);
		
		System.out.println("************");
		List<Integer> list=new ArrayList<>();
		for(int i=0; i<=12;i++) {
			list.add(i);
		}
		Stream<Integer> number1=list.stream();
		System.out.println("PRINTED");
		number1.forEach(System.out::println);
		
		Stream<Date> stream2=Stream.generate(()->
				{
					return new Date();
					});
		//stream2.forEach(System.out::println);
		

	}

}
