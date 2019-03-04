package com.java8.javaTpoint;

import java.util.function.BiFunction;

public class MethodReference {
	public static void threadStatus() {
		System.out.println("Thraed Is Running:::::");
	}
	
	public static String saySomething(String message)
	{
		System.out.println("Refer to static method====");
		return message;
	}
	
	// we are using BiFunction interface and using it's apply() method.
	
	public static int add(int a,int b)
	{
		return a+b;
		
	}
	
	
	
	public static void main(String[] args) {
		Thread t=new Thread(MethodReference::threadStatus);
		t.start();
	//============================================	
		Sayable s=MethodReference::saySomething;
		s.say("kumar");
		
    // 	BiFunction 
		
		BiFunction<Integer, Integer, Integer> adder=MethodReference::add;
		int result=adder.apply(12, 10);
		System.out.println("result::==>"+result);
		
		
	}

}

