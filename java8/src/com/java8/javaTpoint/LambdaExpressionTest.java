package com.java8.javaTpoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExpressionTest {

	public static void main(String[] args) {
		
		System.out.println("=====Lambda Expression:::===");
		int draw=10;
		// Without lambda
		Drawable d=new Drawable() {
			
			@Override
			public void draw() {
				System.out.println("Draw::+>"+draw);
				
			}
		};
		d.draw();
		
		// With lambda
		
		Drawable d2=()->{
			System.out.println("Draw::==>"+draw);
			
		};
		d2.draw();
		
	// Lambda expression with single parameter. 
		Sayable s1=(name)->{
			return "Hello "+name;
			
		};
		System.out.println(s1.say("Kumar"));
		
		// Multiple Parameters
	    // Lambda expression with return keyword.  
		Addable a1=(a,b)->{
			return a+b;
		};
		System.out.println(a1.add(12, 12));
		
	    // Lambda expression with return keyword.  
		
		Addable a2=(int a, int b)->(a+b);
		System.out.println("Addition:=>"+a2.add(13, 13));
		
		  // You can pass multiple statements in lambda expression  
		Sayable s2=(msg)->{
			String s4="Hello ";
			String s3=s4+msg;
			return s3;
		};
		System.out.println("Msg==>"+s2.say("Good Morning::"));

		 //Thread Example without lambda  
		
		Runnable r=new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread1 is running...........");
			}
		};
		
		Thread t1=new Thread(r);
		t1.start();
		
		 //Thread Example with lambda  
		
		Runnable r1=()->{
			
			System.out.println("Thread 2 is running....");
		};
		Thread t2=new Thread(r1);
		t2.start();
		
		// Comparator
		
		 List<Product> list=new ArrayList<Product>();  
         
	        //Adding Products  
	        list.add(new Product(1,"HP Laptop",25000f));  
	        list.add(new Product(3,"Keyboard",300f));  
	        list.add(new Product(2,"Dell Mouse",150f));  
	          
	        System.out.println("Sorting on the basis of name..."); 
	        Collections.sort(list, (n1,n2)->{
	        	return n1.name.compareTo(n2.name);
	        	
	        });
	        
	        for(Product p:list)
	        {
	        	System.out.println(p.id+" "+p.name+" "+p.price);
	        }
	        // Filter Condition
	        List<Product> product=list.stream().filter(p->p.price>300f).collect(Collectors.toList());
	       // System.out.println(product);
	        System.out.println("Filter Condition.............");
	        product.forEach(p->System.out.println(p.name+" "+p.price));
	        //=========================================
	        Float sum=list.stream()
	        		.map(products->products.price)
	        		.reduce(0.0f,Float::sum);
	        double totalPrice=list.stream()
	        		.collect(Collectors.summingDouble(p->p.price));
	        
	        
	        System.out.println("Total Price::==>"+totalPrice);
	        System.out.println("Sum Of Product::=>"+sum);
	        
	        // Method Reference in stream
	        
	        List<Float> productPriceList=list
	        		.stream()
	        		.filter(p->p.price>200f)  // filtering data
	        		.map(Product::getPrice)   // fetching price by referring getPrice method  
	        		.collect(Collectors.toList());
	        
	        System.out.println("Method  Reference::==>"+productPriceList);
	        
	        //  Convert List into Map
	        
	        Map<Integer, String> listToMap=list
	        		.stream()
	        		.filter(p->p.price>200f)
	        		.collect(Collectors.toMap(p->p.id,p->p.name));
	        System.out.println("listToMap::==>"+listToMap);
	        	
	        // Find Max and Min Product Price
	        
	        Product product2=list.stream()
	        		.max((product1,product3)->
	        		product1.price > product3.price ? 1 :-1).get();
	        System.out.println(product2.id+" "+product2.name+" "+product2.price);
	        
	        Product p=list.stream()
	        		.min((product1,product3)->
	        		product1.price > product3.price ? 1 :-1).get();
	        System.out.println(p.id+" "+p.name+" "+p.price);
	        
	        System.out.println("==========Iterating Example================");
	        
	        Stream.iterate(1, element->element+1)
	        .filter(element->element%3==0)
	        .limit(5)
	        .forEach(System.out::println);
	     
	      // Java Optional Example: If Value is not Present
	        
	        String[] str=new String[10];
	        str[5]="java optional class example::";  //  Setting value for 5th index  
	        Optional<String> string=Optional.ofNullable(str[5]);
	        if(string .isPresent())  //  It Checks, value is present or not  
	        {
	        	String uppercase=str[5].toUpperCase();
	        	System.out.println("Handling Null pointer Exception::=>"+uppercase);
	        }
	        else {
				System.out.println("String value is not present");
			}
	        
	        System.out.println("Check Null::==>"+string.get()); // printing value by using get method 
	        string.ifPresent(System.out::println);  //  printing value by using method reference  
	        
	        
//	        String[] str1=new String[10];    // Without Optional
//	        String up=str1[5].toLowerCase();
//	        System.out.println("error-->"+up);
	        
	        
	        
	        
	        
		
	}

}
