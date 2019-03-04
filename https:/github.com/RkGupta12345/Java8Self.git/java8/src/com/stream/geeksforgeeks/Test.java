package com.stream.geeksforgeeks;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		//////// map ////////////
		List<Integer> number=Arrays.asList(2,3,4,5);
		List square=number.stream().map(i->i*i).collect(Collectors.toList());
		System.out.println("Square Is::=>"+square);
		
		System.out.println("==================");
		
		//////////// reduce //////////////
		List<Integer> no=Arrays.asList(2,3,4,5,6,7,8);
		Integer even=no.stream().filter(i->i%2==0).reduce(0,(ans,i)->ans+i);
		System.out.println("Even::=>"+even);
		// Here ans variable is assigned 0 as the initial value and i is added to it 
		
		System.out.println("==================");
		
		
	}

}
