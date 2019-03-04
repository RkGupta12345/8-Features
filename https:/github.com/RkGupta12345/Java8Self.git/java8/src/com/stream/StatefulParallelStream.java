package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StatefulParallelStream {

	public static void main(String[] args) {
	
		List<Integer> ss=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
		List<Integer> result=new ArrayList<>();
		Stream<Integer> stream=ss.parallelStream();
		stream.map(s->
		{
			synchronized (result) {
				if(result.size()<10)
				{
					result.add(s);
				}
				
			}
			System.out.println("Return::");
			return s;
		}).forEach(System.out::println);
		

	}

}