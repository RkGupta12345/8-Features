package com.stream.java9;

import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		List<String> list=List.of("abcd","bd","c","d","e","f");
		List<String> list2=list.stream().takeWhile(e->!e.equals("d")).collect(Collectors.toList());
		System.out.println(list2);
		
		System.out.println("----------------------");
		List<String> list3=list.stream().dropWhile(e->!e.equals("d")).collect(Collectors.toList());
		System.out.println(list3);

	}

}
