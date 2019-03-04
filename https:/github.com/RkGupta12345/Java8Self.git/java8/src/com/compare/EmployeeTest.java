package com.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeTest {

	public static void main(String[] args) {
		List<Employee> employees = getEmployee();
		employees.sort(Comparator.comparing(e -> e.getFirstName()));
		System.out.println(employees);
		System.out.println("************");

		employees.sort(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName));
		System.out.println(employees);

		employees.sort(Comparator.comparing(Employee::getAge));
		System.out.println(employees);
		
		 Comparator<Employee> comparator = Comparator.comparing(e -> e.getFirstName());
		    employees.sort(comparator.reversed());
		    System.out.println(employees);

	}

	private static List<Employee> getEmployee() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(12, "r", "kumar", 23));
		employees.add(new Employee(11, "a", "k", 20));
		employees.add(new Employee(18, "r", "anand", 13));
		employees.add(new Employee(16, "t", "vivek", 22));
		return employees;
	}
	
	

}
