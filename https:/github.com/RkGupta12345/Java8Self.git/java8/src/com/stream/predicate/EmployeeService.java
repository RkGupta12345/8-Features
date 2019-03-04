package com.stream.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeService {
   public static Predicate<EmployeeModel> isAdultMale()
   {
	return t->t.getAge() >30 && t.getGender().equalsIgnoreCase("male");
	   
   }
   
   public static Predicate<EmployeeModel> isAdultFemale()
   {
	return t->t.getAge() >30 && t.getGender().equalsIgnoreCase("female");
	   
   }
   
   public static List<EmployeeModel> filteredEmployee(List<EmployeeModel> employeeModels,Predicate<EmployeeModel> predicate )
   {
	return employeeModels.stream().filter(predicate).collect(Collectors.<EmployeeModel>toList());
	   
   }
}
