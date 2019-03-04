package com.stream.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class EmployeeTest {

	public static void main(String[] args) {

        EmployeeModel e6 = new EmployeeModel(6,15,"M","David","Feezor");
        EmployeeModel e7 = new EmployeeModel(7,68,"F","Melissa","Roy");
        EmployeeModel e8 = new EmployeeModel(8,79,"M","Alex","Gussin");
        EmployeeModel e9 = new EmployeeModel(9,15,"F","Neetu","Singh");
        EmployeeModel e10 = new EmployeeModel(10,45,"M","Naveen","Jain");
         
        List<EmployeeModel> EmployeeModels = new ArrayList<EmployeeModel>();
        EmployeeModels.addAll(Arrays.asList(new EmployeeModel[]{e6,e7,e8,e9,e10}));
		
		Predicate<EmployeeModel> EmployeeModelModel=EmployeeService.isAdultMale();
		System.out.println("isAdultMale:::->"+EmployeeModelModel);
        //System.out.println( EmployeeService.filteredEmployee(EmployeeModels , isAdultMale()) );
	

	}

	

}
