package com.stream.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class EmployeeTest {

	public static void main(String[] args) {
		 List<Employee> employees=getEmployee();
//		Comparator<Employee> sorting=Comparator.comparing(Employee::getlName);
//		Employee sort=employees.stream().min(sorting).get();
		 
		 System.out.println("Before Sorting::");
		 for(Employee sort: employees) {
			 	System.out.println("Sort::->>"+sort);
		 }
		 System.out.println("After Sorting::");
		 
		 employees.sort((Employee e1, Employee e2)->e1.getfName().compareTo(e2.getfName()));
		 employees.forEach((sort)->System.out.println(sort));
		 
		 
		 
//============================================================================		
		List<Employee> list=new ArrayList<>();
		list.add(new Employee(1, "ravi", "kumar"));
		list.add(new Employee(2, "rajesh", "kumar"));
		list.add(new Employee(3, "rk", "kumar"));
		list.add(new Employee(4, "raju", "singh"));
		
		Comparator<Employee> comparator=Comparator.comparing(Employee::getlName);
		Employee max=list.stream().max(comparator).get();
		Employee min=list.stream().min(comparator).get();
//		System.out.println("max-->"+max);
//		System.out.println("min::->"+min);
		
		System.out.println("--------------------------------------------");
		
	
	}
	
	private static List<Employee> getEmployee()
	{
		List<Employee> list=new ArrayList<>();
		list.add(new Employee(1, "ravi", "kumar"));
		list.add(new Employee(2, "rajesh", "kumar"));
		list.add(new Employee(3, "rk", "kumar"));
		list.add(new Employee(4, "raju", "singh"));
		
		return list;
		
	}

}
