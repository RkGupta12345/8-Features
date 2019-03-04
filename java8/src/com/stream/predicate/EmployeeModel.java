package com.stream.predicate;

public class EmployeeModel {

	private Integer id;
	private Integer age;
	private String gender;
	private String firstName;
	private String lastName;

	public EmployeeModel(Integer id, Integer age, String gender, String firstName, String lastName) {
		super();
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	

	public EmployeeModel() {
		
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", age=" + age + ", gender=" + gender + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

}
