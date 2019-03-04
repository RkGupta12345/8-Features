package com.mkyong;

import java.io.BufferedReader;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class Test {

	public static void main(String[] args) {
		Map<String, Integer> items=new HashMap<>();
		
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		
		if(items.containsKey("A") && items.containsValue(40))
		{
			System.out.println("Key-->"+items.put("E",50));
		}
		for(Map.Entry<String, Integer> entry: items.entrySet())
		{
			System.out.println("Map Entry:: "+entry.getKey()+ "  KeySet:: "+entry.getValue());
		}
		
		System.out.println("=================================");
		
		//items.forEach((k,v)->System.out.println("key-->"+k+ " value-->"+v));
		
		items.forEach((k,v)->{
			System.out.println("key-->"+k+ " value-->"+v);
			if("D".equals(k))
			{
				System.out.println("Hello");
			}
			
		});
		
		System.out.println("=================================");
		
		List<String> list=new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		//list.forEach(a->System.out.println(a));
		list.forEach((item)->{
			if("F".equals(item))
			{
				//System.out.println(item);
				//method reference
				list.forEach(System.out::println);
			}
			else {
				System.out.println("Failed");
			}
			
		});
		
		//Stream and filter
		
		List<String> list1=list.stream().filter((s)->s.contains("D")).collect(Collectors.toList());
		list1.forEach(System.out::println);
		
		System.out.println("===========Streams filter examples Streams filter() and collect() ======================");
		
		
		List<String> subject=Arrays.asList("Spring","Java","Hibernate");
		List<String> filter=getFilteredSubject(subject, "Sprin");
		for(String data:filter)
		{
			System.out.println("Filtered Subject::=>"+data);
		}
		
		System.out.println("====By Using Java8====");
		
		List<String> subject1=Arrays.asList("Spring","Java","Hibernate");
		//List<String> result=subject1.stream().filter(line->!"Spring".contains(line)).collect(Collectors.toList());
		List<String> result=subject1.stream().filter(line->!"Spring".equals(line)).collect(Collectors.toList());
		System.out.println("By Using Java8::==>"+result);
		
		System.out.println("==== Streams filter(), findAny() and orElse() ====");
		
		// Before Java 8, you get a Person by name like this :
		List<Person> persons=Arrays.asList(
				new Person("Kumar", 26),
				new Person("Ankit", 25),
				new Person("Gaurav", 35)
				);
		
		Person result1=getPersonByName(persons, "Kumar");
		System.out.println(result1);
		
		System.out.println("====By Using Java8====");
		
		Person result2=persons.stream().filter(data->"Kuma".equals(data.getName())).findAny().orElse(null);
		System.out.println("By Using Java8==>"+result2);
		
		///// For multiple condition./////////////////
		
		Person multipleCondition=persons.stream().filter(data->"Ankit"
									.equals(data.getName()) && 25==data.getAge())
									.findAny().orElse(null);
		
		System.out.println(" For multiple condition By Using Java8==>"+multipleCondition);
		Person result3=persons.stream()
				.filter(p->{
					if("Gaurav".equals(p.getName()) && 65==p.getAge())
					{
						return true;
					}
					else {
						System.out.println("Condition Failed::");
						return false;
					}
				}).findAny().orElse(null);
		
		System.out.println(" For multiple condition By Using Java8==>"+result3);
		
		System.out.println("==========Streams filter() and map()====");
		
		Integer name=persons.stream().filter(n->"Kumar".contains(n.getName())).map(Person::getAge).findAny().orElse(null);
		System.out.println("Map==>"+name);
		
		Set<String> person=persons.stream()
				.map(Person::getName ).collect(Collectors.toSet());
		
		System.out.println("Person Name::==>"+person);
		
		Double average=persons.stream().limit(2).collect(Collectors.averagingInt(Person::getAge));
		System.out.println("Average Of Age::==>"+average);
				
		System.out.println("=========================");
		List<Integer> no=Arrays.asList(2,3,4,5,6,7,8);
		List<Integer> evenSquare=no.stream()
				.filter(n->{
					System.out.println(" Even Number are::=>>"+n);
					return n%2==0;
				}).map(n->{
					System.out.println("Square is::==>"+n);
					return n*n;
				}).limit(2).collect(Collectors.toList());
		System.out.println("Even Square::==>"+evenSquare);
		
		System.out.println("=========================");
		
		List<String> words = Arrays.asList("Oracle", "Java", "Magazine");
		 List<Integer> wordLengths = 
				 	words.stream()
				 	.map(String::length)
				 	.collect(Collectors.toList());
		System.out.println("WordLengths :=>"+wordLengths);
		System.out.println("=========================");
		
		List<Integer> integers=Arrays.asList(2,3,4,5,6);
		Integer sum=integers.stream().reduce(1,(a,b)->a+b);// Reduce--> For Performing repetitive operation.
		
		System.out.println("Sum::==>"+sum);
		
		Integer max=integers.stream().reduce(1,Integer::max);
		System.out.println("max::==>"+max);
		
		IntStream oddNumber=IntStream.rangeClosed(10, 20)
				.filter(n->n%2==1);
		//oddNumber.forEach(System.out::println);
		oddNumber.forEach(n->System.out.println(n));
		System.out.println("=========================");
		
		Stream<Integer> iterate=Stream.iterate(0, n->n+10);
		iterate.limit(5).forEach(n->System.out.println(n));
		
		System.out.println("=========== Java 8 Streams map() examples ==============");
		
		List<String> alpha = Arrays.asList("a", "b", "c", "d");
		
		List<String> alphabet=new ArrayList<>();
		for(String s:alpha)
		{
			alphabet.add(s.toUpperCase());
			
		}
		System.out.println("UpperCase::=>"+alphabet);
		
		System.out.println("=========================");
		
	List<String> upperCase=	alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
	System.out.println("Using Java8::=>"+upperCase);
	
	 List<Integer> num = Arrays.asList(1,2,3,4,5);
	 List<Integer> number = num.stream().map(n->n*2).collect(Collectors.toList());
	 System.out.println("Num==>"+number);
	 
	 System.out.println("==========    List of objects -> List of other objects   ===============");
	
	 

     List<Staff> staff = Arrays.asList(
             new Staff("mkyong", 30, new BigDecimal(10000)),
             new Staff("jack", 27, new BigDecimal(20000)),
             new Staff("lawrence", 33, new BigDecimal(30000))
     );
     
     List<StaffPublic> convert=convertToStaffPublic(staff);
     System.out.println("Conversion::==>"+convert);
     
     System.out.println("====By Using Java8====");
     
     List<StaffPublic> result11=staff.stream().map(temp->{
    	 StaffPublic staffPublic=new StaffPublic();
    	 staffPublic.setName(temp.getName());
    	 staffPublic.setAge(temp.getAge());
    	 
    	if("jack" .equals(temp.getName()))
    	{
    		staffPublic.setExtra("Convert");
    		
    	}
    	return staffPublic;
     }).collect(Collectors.toList());
     
     result11.forEach(System.out::println);
     
     
     System.out.println("========== ==Group By, Count and Sort =========================");
     
     List<String> items1 =
             Arrays.asList("apple", "apple", "banana",
                     "apple", "orange", "banana", "papaya");
     Map<String, Long> result111=items1.stream()
    		 					.collect(Collectors.groupingBy
    		 							(Function.identity(),Collectors.counting()));
     
     System.out.println("Count::=>"+result111);
     
   //Sort a map and add to finalMap
     
     Map<String, Long> finalMap= new HashMap<>();
     
     result111.entrySet().stream().sorted
     (Map.Entry.<String,Long>comparingByValue()
    		 .reversed()).forEachOrdered(n->finalMap.put(n.getKey(), n.getValue()));
     System.out.println("FinalMap::==>"+finalMap);
     
     System.out.println("=============Group by the name + Count or Sum the Qty.========================");
     
     List<Item> items12 = Arrays.asList(
             new Item("apple", 10, new BigDecimal("9.99")),
             new Item("banana", 20, new BigDecimal("19.99")),
             new Item("orang", 10, new BigDecimal("29.99")),
             new Item("watermelon", 10, new BigDecimal("29.99")),
             new Item("papaya", 20, new BigDecimal("9.99")),
             new Item("apple", 10, new BigDecimal("9.99")),
             new Item("banana", 10, new BigDecimal("19.99")),
             new Item("apple", 20, new BigDecimal("9.99"))
     );
     
     Map<String,Long> counting=items12.stream().collect(Collectors.groupingBy(Item::getName,Collectors.counting()));
     
     Map<String, Integer> sumOf=items12.stream().collect(Collectors.groupingBy(Item::getName,Collectors.summingInt(Item::getQty)));
     
     System.out.println("Counting::==>>"+counting);
     System.out.println("Sum Of::==>>"+sumOf);
     
     System.out.println("=====// group by price, uses 'mapping' to convert List<Item> to Set<String>====");
     Map<BigDecimal, Set<String>> set=items12.stream()
    		 .collect(Collectors.groupingBy
    				 (Item::getPrice, Collectors.mapping
    						 (Item::getName, Collectors.toSet())));
     
     System.out.println("Group By Price::==>>"+set);
     
     System.out.println("===================Sort by Keys========================");
     
     Map<String, Integer> unsortMap = new HashMap<>();
     unsortMap.put("z", 10);
     unsortMap.put("b", 5);
     unsortMap.put("a", 6);
     unsortMap.put("c", 20);
     unsortMap.put("d", 1);
     unsortMap.put("e", 7);
     unsortMap.put("y", 8);
     unsortMap.put("n", 99);
     System.out.println("Original");
     System.out.println(unsortMap);
     
  // sort by keys, a,b,c..., and return a new LinkedHashMap
     // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
     
     Map<String, Integer> results=unsortMap.entrySet()
    		 .stream().sorted(Map.Entry.comparingByKey())
    		 .collect(Collectors.toMap(Map.Entry::getKey ,Map.Entry::getValue,
    				 (oldVaue,newValue)->oldVaue, LinkedHashMap::new ));
     System.out.println("Sorted By key-->"+results);
     
     Map<String, Integer> sortByValue= unsortMap.entrySet()
    		 .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
    		 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(oldValue,newValue)->oldValue,LinkedHashMap::new));
     
     System.out.println("Sorted By value::=>"+sortByValue);
    	
     // To solve the duplicated key issue above, pass in the third mergeFunction argument like this
     
    Map<String, Integer> listToMap=items12.stream()
    		.collect(Collectors.toMap(Item::getName, Item::getQty,(oldValue, newValue)->newValue)); // (oldValue, newValue) -> oldValue ==> If the key is duplicated,
    System.out.println("listToMap::===>"+listToMap);
    
    List<Integer> square=Arrays.asList(2,3);
   List<Integer> st= square.stream().map(x->x*x).collect(Collectors.toList());
   System.out.println("Square::==>"+st);
   
   System.out.println("============Filter A Map ==============================="); 
     
   Map<Integer, String> HOSTING = new HashMap<>();
   HOSTING.put(1, "linode.com");
   HOSTING.put(2, "heroku.com");
   HOSTING.put(3, "digitalocean.com");
   HOSTING.put(4, "aws.amazon.com");

   // Before Java 8
   
   String result12="";
   for(Map.Entry<Integer,String> entry: HOSTING.entrySet())
   {
	   if("linode.com".equals(entry.getValue()))
			   {
		   			result12=entry.getValue();
			   }
   }
   
   System.out.println("Before Java8::==>"+result12);
   
 //Map -> Stream -> Filter -> String
   
   result12=HOSTING.entrySet().stream()
		   .filter(x->"linode.com".equals(x.getValue()))
		   .map(s->s.getValue())
		   .collect(Collectors.joining());
   System.out.println("Using Java8::==>"+result12);
		
   //Map -> Stream -> Filter -> Map
   
   Map<Integer, String> collect=HOSTING.entrySet().stream()
		   .filter(map->map.getKey()==2)
		   .collect(Collectors.toMap(p->p.getKey(), p->p.getValue()));
   System.out.println("Collect::==>"+collect);
   
   Map<Integer,String> collects=HOSTING.entrySet()
		   .stream().filter(m->m.getKey()<=3)
		   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
   
   System.out.println("Collects::-->"+collects);
   
   System.out.println("==========Generic Map filterbyvalue, with predicate============");
   
   Map<Integer,String> filter1=filterByValue(HOSTING, x->(x.contains("linode.com") || x.contains("aws.amazon.com")));
   Map<Integer,String> filter2=filterByValue(HOSTING, x->(x.length()>10));
   
   System.out.println("Filetr data::==>"+filter1);
   System.out.println("Filetr data::==>"+filter2);
   
   
   System.out.println("================= FlatMap =========================");
   
   String[][] data=new String[][] {{"a","b"},{"c","d"},{"c","a"}};
   Stream<String> stream = Arrays.stream(data)
           .flatMap(x -> Arrays.stream(x))
           .filter(x -> "a".equals(x.toString()));
   	stream.forEach(c->System.out.println(c));
  
   	System.out.println("======== Map To List =========");
   	
   	Map<Integer, String> map = new HashMap<>();
    map.put(10, "apple");
    map.put(20, "orange");
    map.put(30, "banana");
    map.put(40, "watermelon");
    map.put(50, "dragonfruit");
    
    List<String> values=new ArrayList<>(map.values());
    values.forEach(c->System.out.println(c));
    
    List<String> value=map.values().stream().collect(Collectors.toList());
    System.out.println("Value::==>"+value);
    
    List<Integer> key=new ArrayList<>(map.keySet());
    System.out.println("Key::==>"+key);
    
    //System.out.println("\n1");
    
   	System.out.println("========== Optional ==================");
   	
   	Optional<String> nonEmptyGender=Optional.of("Male");
   	Optional<String> empty=Optional.empty();   // To Create Empty Optional Object
   	
   	System.out.println("Non-Empty==>"+nonEmptyGender.map(String::toUpperCase));
   	System.out.println("Empty::-->"+empty.map(String::toLowerCase));
   	System.out.println(nonEmptyGender.filter(x->x.equals("male")));
   	System.out.println(nonEmptyGender.filter(x->x.equalsIgnoreCase("male")));
   	
   	System.out.println("==========================");
   	
   	List<String> lists = Arrays.asList("java", "python", "nodejs", "ruby");
   	String list11=lists.stream().collect(Collectors.joining(" , ","{" ,"}"));
   	System.out.println("String Joiner::==>"+list11);
   	
   	System.out.println("============= Read a file line by line =================");
   	
   String file=	"/Users/ravi.kumar/Desktop";
   List<String> reader=new ArrayList<>();
   
   
   try {
	   Stream<String> readFile=Files.lines(Paths.get(file, "data.txt"));
	   reader=readFile.filter(line->!line.startsWith("L"))
			   .map(s->s.toUpperCase())
			   .collect(Collectors.toList());
	 
	   //readFile.forEach(System.out::println);
	
} catch (Exception e) {
	e.printStackTrace();
	}
   reader.forEach(System.out::println);
   
  System.out.println("===///  BufferedReader + Stream===="); ///  BufferedReader + Stream
  // A new method lines() has been added since 1.8, it lets BufferedReader returns content as Stream.
   
   try (BufferedReader reader1=Files.newBufferedReader(Paths.get(file, "data.txt"))){
	   
	 //reader1 returns as stream and convert it into a List
	  reader=reader1.lines().filter(s->s.contains("Lokesh")).collect(Collectors.toList());
	
} catch (Exception e) {
	
	e.printStackTrace();
	}
   reader.forEach(System.out::println);
   
   System.out.println("////// By using Buffered Reader");////// By using Buffered Reader
   
   String file1=	"/Users/ravi.kumar/Desktop/date copy";
   try {
	   
	   BufferedReader br=new BufferedReader(new java.io.FileReader(file1));
	   String line1;
	   while((line1=br.readLine())!=null)
			   {
		   			System.out.println(line1);
			   }
	
} catch (Exception e) {
	e.printStackTrace();
}
   
   System.out.println("========== By Using Scanner ============");
   
   try {
	
	   Scanner sc=new Scanner(new File(file1));
	   while(sc.hasNext())
	   {
		   System.out.println(sc.nextLine());
	   }
} catch (Exception e) {
}
   
   System.out.println("========== How to join Arrays ================");
  
   String[] s1 = new String[]{"a", "b", "c"};
   String[] s2 = new String[]{"d", "e", "f"};
   
   String[] array=Stream.of(s1,s2)
		   .flatMap(Stream::of).toArray(String[]::new);
   System.out.println(Arrays.toString(array));
   
   int [] int1 = new int[]{1,2,3};
   int[] int2 = new int[]{4,5,6};
   int[] ints=IntStream.concat(Arrays.stream(int1), Arrays.stream(int2)).toArray();
   System.out.println(Arrays.toString(ints));
   
   System.out.println("============= How to convert String to Char Array ============");
   
   String password="pass123";
   
   char[] pass=password.toCharArray();
   for(char temp:pass)
   {
	   System.out.println("Convert String to Char-->"+temp);
   }
   
   System.out.println("==By Using java8====");
	//  For Java 8, you can uses .chars() to get the IntStream, and convert it to Stream Char via .mapToObj
   password.chars().mapToObj(x->(char)x).forEach(System.out::println);
   
   System.out.println("====  How to convert a primitive Array to List ======");
   int[] integer= {2,3,4,56,67};
   
   List<Integer> numbers=convertIntArrayToList(integer);
   System.out.println(""+numbers);
   List<Integer> nos=Arrays.stream(integer).boxed().collect(Collectors.toList());
   System.out.println("no==>"+nos);
   
   System.out.println("====Check if Array contains a certain value?======");
  
   int[] number2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
   
   boolean nos1=IntStream.of(number2).anyMatch(x->x==39);
   if(nos1)
   {
	   System.out.println("Print");
   }
   else
   {
	   System.out.println("no is not there");
   }
   
   String[] alphabets = new String[]{"A", "B", "C"};
   
   List<String> strings=Arrays.asList(alphabets);
   
   if(strings.contains("A"))
   {
	   System.out.println("print A");
   }
   
   strings.forEach(System.out::println);
  
	}
	
	

	private static List<String> getFilteredSubject(List<String> subject,String filter)
	{
		List<String> result=new ArrayList<>();
		for(String line:subject)
		{
			if(!filter.equals(line))
			{
				result.add(line);
			}
		}
		return result;
		
	}
	
	private static Person getPersonByName(List<Person> persons, String name)
	{
		Person result=null;
		for(Person filter:persons)
		{
			if(name.equals(filter.getName()))
			{
				System.out.println("Filter Data::=>"+filter.getName());
				result=filter;
			}
		}
		return result;
	}
	
	
	private static List<StaffPublic> convertToStaffPublic(List<Staff> staff)
	{
		List<StaffPublic> result=new ArrayList<>();
		
		for(Staff temp:staff)
		{
			StaffPublic staffPublic=new StaffPublic();
			staffPublic.setName(temp.getName());
			staffPublic.setAge(temp.getAge());
			
			if("mkyong" .equals(temp.getName()))
			{
				staffPublic.setExtra("Conversion Of Staff To StaffPublic::");
			}
			result.add(staffPublic);
		}
		return result;
	}
	
	
	// Generic Map filterbyvalue, with predicate
	
	private static <K, V> Map<K, V> filterByValue(Map<K, V> map,Predicate<V> predicate)
	{
		return map.entrySet()
				.stream()
				.filter(x->predicate.test(x.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}
	
	private static List<Integer> convertIntArrayToList(int[] input)
	{
		List<Integer> integers=new ArrayList<>();
		for(int temp:input)
		{
			integers.add(temp);
		}
		return integers;
	}
	
	

}
