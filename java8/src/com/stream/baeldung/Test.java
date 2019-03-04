package com.stream.baeldung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.oracle.tools.packager.Log;



public class Test {

	public static void main(String[] args) {

		Collection<String> collection = Arrays.asList("a", "ab", "abc");
		Stream<String> listOfCollection = collection.stream();
		listOfCollection.forEach(System.out::println);

		System.out.println("======================");

		String[] arr = new String[] { "ab", "abc", "abcd" };
		Stream<String> arrayOfStream = Arrays.stream(arr);
		arrayOfStream.forEach(System.out::println);

		System.out.println("==================");

		Stream<String> arrayOfStream1 = Arrays.stream(arr, 2, 3);
		arrayOfStream1.forEach(System.out::println);

		System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		System.out.println("==================");
		///////////////// Stream.builder() ////////////////
		Stream<String> builder = Stream.<String>builder().add("ab").add("abcd").build();
		// System.out.println("Stream.builder()::==>"+builder.collect(Collectors.toList()));
		builder.forEach(System.out::println);

		System.out.println("==================");

		Stream<String> generate = Stream.generate(() -> "GENERATE").limit(2);
		generate.forEach(System.out::println);

		System.out.println("==================");
		///////////////// Stream.iterate() /////////////////
		Stream<Integer> iterate = Stream.iterate(18, n -> n + 2).limit(4).filter(n -> n % 2 == 0);
		iterate.forEach(System.out::println);

		System.out.println("==================");

		IntStream string = "abc".chars();
		string.forEach(System.out::println);

		System.out.println("==================");

		Stream<String> onceModifiedStream = Stream.of("abcd", "bbcd", "cbcd").filter(n -> n.contains("d")).skip(1)
				.map(element -> element.substring(0, 2));
		onceModifiedStream.forEach(System.out::println);

		System.out.println("===================");

		List<String> list = Arrays.asList("abc1", "abc2", "abc3");
		Stream<String> size = list.stream().skip(1).map(element -> element.substring(0, 3)).sorted().distinct();
		size.forEach(System.out::println);

		System.out.println("===================");
		
		///////////////////  reduce() Method ///////////////////
		OptionalInt reduced=IntStream.range(2,6).reduce((a,b)->a*b);
		if(reduced.isPresent())
		{
			System.out.println("REDUCE::==>"+reduced.getAsInt());
		}
		//------------------------------------------------------------------------
		
		int reduced1=IntStream.range(2, 5).reduce(10, (a,b)->a*b);
		System.out.println("REDUCE1::--==>"+reduced1);
		
		//----------------------------------------------------------------------------
		
		int reduced2=Stream.of(2,3,4).reduce(10,(a,b) -> a+b,(a,b)->{
		return a+b;
		});
		System.out.println("reduced2::--==>"+reduced2);
		//----------------------------------------------------------------------------
		
//		int reduced3=Arrays.asList(2,3,4).parallelStream().reduce(10,(a,b) -> a+b,(a,b)->{
//			return a+b;
//			});
		int reduced3=Arrays.asList(2,3,4).parallelStream().reduce(10,(a,b) -> a+b);
			
			System.out.println("REDUCED 3::--==>"+reduced3);
		
		System.out.println("===================");
		
		/////////// collect() Method /////////////////
		
		List<Product> productList=Arrays.asList(new Product(23, "potatoes"),
				 new Product(14, "orange"),
				 new Product(13, "lemon"),
				  new Product(23, "bread"),
				  new Product(13, "sugar"));
		
		List<Float> name=productList.stream().map(Product::getPrice).collect(Collectors.toList());
		System.out.println("Product Price::-->>"+name);
		
		String name1=productList.stream().map(Product::getName).collect(Collectors.joining(",","{","}"));
		System.out.println("PRODUCT NAME::--=>>"+name1);
		
		Double name2=productList.stream().collect(Collectors.averagingDouble(Product::getPrice));
		System.out.println("Average Product Price::--==>>"+name2);

		Double name3 = productList.stream().collect(Collectors.summingDouble(Product::getPrice));
		System.out.println("Sum Of Product Price::--==>>"+name3);
		
		DoubleSummaryStatistics report=productList.stream().collect(Collectors.summarizingDouble(Product::getPrice));
		System.out.println("Summary Report Of Product::--==>>"+report);
		
		Map<Float, List<Product>> grouping=productList.stream().collect(Collectors.groupingBy(Product::getPrice));
		System.out.println("Grouping::--==>>"+grouping);
		
		Map<Boolean, List<Product>> mapPartioned=productList.stream().collect(Collectors.partitioningBy(n->n.getPrice()>15));
		System.out.println("Partitioned::--==>>"+mapPartioned);
		
		Set<Product> unmodifiableSet = productList.stream().collect(Collectors.collectingAndThen(Collectors.toSet(),Collections::unmodifiableSet));
		System.out.println("Unmodiable Set::--==>>"+unmodifiableSet);
		
		System.out.println("===================");
		
		//-----------------https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/-----------------------------------------------------------
		
		
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o2.compareTo(o1) ;
			}
		});
		System.out.println("Sorting::--==>"+names);
		
		List<String> names1 = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names1, ( String s1,String s2 )->{
			return s2.compareTo(s1);
		});
		System.out.println("Sorting1::--==>"+names1);
		
		Collections.sort(names1, ( s1, s2)->s1.compareTo(s2));
		System.out.println("Sorting2::--==>"+names1);
		
		System.out.println("===================");
		
		Arrays.stream(new int[] {1, 2, 3})
	    .map(n -> 2 * n + 1)
	    .average()
	    .ifPresent(System.out::println);
		
		System.out.println("===================");
		
		Stream.of("a13","a24","a32")
		.map(i->i.substring(1,3))
		.mapToInt(Integer::parseInt)
		.max()
		.ifPresent(System.out::println);
		
		IntStream.range(1, 3)
		.mapToObj(i->"A"+i)
		.findFirst()
		.ifPresent(System.out::println);
		
		System.out.println("===================");
		
		Stream.of("d2", "b3", "c")
		.map(s->{ System.out.println("map::=>"+s);
			return s.toUpperCase();
			})
		.anyMatch(s->{ System.out.println("anyMatch::=>"+s);
		return s.startsWith("B");
			});
		
		System.out.println("===================");
		
		Stream.of("d2", "a2", "b1", "b3", "c")
		.filter(s->{
			System.out.println("Filter:=>"+s);
			return s.startsWith("a");
		})
		.map(s->{
			System.out.println("Map:=>"+s);
			return s.toUpperCase();
					
		}).forEach(s->System.out.println("For-Each::=>"+s));
		
		System.out.println("======= Grouping By ============");
		
		List<Person> persons=Arrays.asList(new Person("Max", 18),
		        new Person("Peter", 23),
		        new Person("Pamela", 33),
		        new Person("David", 12));
		
		List<Person> filtered=persons.stream().filter(s->s.name.startsWith("P")).collect(Collectors.toList());
	    System.out.println("Filtered Name::=>"+filtered);
	    
	    Map<Integer, List<Person>> personByAge=persons.stream().collect(Collectors.groupingBy(p->p.age));
		personByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
		
		System.out.println("===================");
		
		Map<Integer, String> map=persons.stream().filter(p->p.age>20).collect(Collectors.toMap(p->p.age, p->p.name));
		System.out.println("Map::==>"+map);
		
		Collector<Person, StringJoiner, String> personCollector = Collector.of(
				()->new StringJoiner(" | "),                 // supplier
				(i,j)->i.add(j.name.toLowerCase()),			// accumulator
				(k,l)->k.merge(l), 							// combiner
				StringJoiner::toString);					// finisher
			
			String person=persons.stream().collect(personCollector);
			System.out.println("Collector::==>>"+person);
			
	    System.out.println("=======Reduce#============");	
	    persons.stream().reduce(
	    		(p1,p2)->p1.age > p2.age ? p1:p2)
	    .ifPresent(System.out::println);
	    
		System.out.println("===================");
		
		Person result=persons.stream()
				.reduce(new Person("", 0), 
				(p1,p2)->{
					p1.age+=p2.age;
					p1.name+=p2.name;
					
					return p1;
				});

		
	System.out.format("Name=%s ,Age=%s\n", result.name,result.age);
	System.out.println("===================");
	
	Integer sumOfAge=persons.stream().reduce(0,
			(sum,p)->sum+=p.age, 
			(sum1,sum2)->sum1+sum2);
	System.out.println("Sum Of Age::=>"+sumOfAge);
			
	System.out.println("========  ===========");
	
	
	
	
	    
				
	    
	    
				
				
			}

}
