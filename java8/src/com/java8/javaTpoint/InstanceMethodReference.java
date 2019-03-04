package com.java8.javaTpoint;

public class InstanceMethodReference {
	
	public  String saySomething(String message)
	{
		System.out.println("Hello, this is non-static method.");
		return message;
	}
	
public static void main(String[] args) {
	InstanceMethodReference iReference=new InstanceMethodReference();// creating Object
    // Referring non-static method using reference  
	Sayable s=iReference::saySomething;
	 // Calling interface method  
	s.say("ravi");
	// Referring non-static method using anonymous object  
	Sayable s1=new InstanceMethodReference()::saySomething;// You can use anonymous object
	  // Calling interface method  
	s1.say("");
	
	
	// Reference to a Constructor
	//You can refer a constructor by using the new keyword. Here, we are referring constructor with the help of functional interface.
	Messageable messageable=Message::new;
	messageable.getMessage("hello");
	
}
}
