package com.stream.dzone;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaWithoutStreamExample {

	private static List<Product> productsList = new ArrayList<Product>();

	public static void main(String[] args) {

		productsList.add(new Product(1, "HP Laptop", 25000));
		productsList.add(new Product(2, "Dell Laptop", 30000));
		productsList.add(new Product(3, "Lenevo Laptop", 28000));
		productsList.add(new Product(4, "Sony Laptop", 28000));
		productsList.add(new Product(5, "Apple Laptop", 90000));

		withoutStreamAPI();
		System.out.println("withStreamApi()==============");
		
		withStreamApi();
	}

	private static void withoutStreamAPI() {
		// without Stream API's
		List<Float> productPriceList = new ArrayList<>();
		// filtering data of list
		for (Product product : productsList) {
			if (product.getPrice() > 30000) {
				// adding price to a productPriceList
				productPriceList.add(product.getPrice());
			}

		}
		// displaying data
		for (Float price : productPriceList) {
			System.out.println("product price::=>" + price);
		}

	}
	
	private static void withStreamApi()
	{
		List<Product> productPriceList=productsList.stream().filter((product)->product.getPrice()>25000).collect(Collectors.toList());
		productPriceList.forEach(System.out::println);
		System.out.println("==================");
		
		List<Float> productPriceList1=productsList.stream().filter((product)->product.getPrice()>25000).map((product)->product.getPrice()).collect(Collectors.toList());
		System.out.println("product price::=>"+productPriceList1);
		
		System.out.println("==============");
		
		double totalPrice3 = productsList.stream()  
                .collect(Collectors.summingDouble(product->product.getPrice()));  
         System.out.println("Total Price Of Product::==>"+totalPrice3);
         
		double  totalProductPrice=productsList.stream().filter((product)->product.getPrice()>29000).collect(Collectors.summingDouble((product)->product.getPrice()));
		System.out.println("Filter Product::==>"+totalProductPrice);
		
		System.out.println("===================");
		
		 // max() method to get max Product price
		
		Product productA=productsList.stream().max((product1,product2)->product1.getPrice()>product2.getPrice() ? 1:-1).get();
		System.out.println("Max Product Price::==>"+productA);
		
		// min() method to get min Product price
		
		Product productB=productsList.stream().max((product1,product2)->product1.getPrice()<product2.getPrice() ? 1:-1).get();
		System.out.println("Min Product Price::==>"+productB.getId());
		
		System.out.println("==================");
		
		// Converting Product List into a Map
		
		Map<Integer, String> listToMap=productsList.stream().collect(Collectors.toMap(Product::getId,Product::getName));
		System.out.println("listToMap::==>"+listToMap);
		
		System.out.println("=======================");
		
		// Using Method References in Stream
		
		List<Float> productPriceList2 = productsList.stream()
				  .filter(p -> p.getPrice() > 30000)// filtering data 
				  .map(Product::getPrice) // fetching price by referring getPrice method
				  .collect(Collectors.toList()); // collecting as list
				  System.out.println("Instance Method::==>"+productPriceList2);
				 }
		
		
	}


