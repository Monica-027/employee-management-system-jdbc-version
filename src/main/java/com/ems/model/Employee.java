package com.ems.model;

public class Employee {
	private int eid;
	private String name;
	private String department;
	private double salary;
	
	//Default Constructor
	public Employee() {}
	
	//Constructor to Insert employee
	public Employee(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	//Constructor to retrieve Employee from DB
	public Employee(int eid, String name, String department, double salary) {
		this.eid = eid;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	public int getEid() {
		return eid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
	    return "Employee [eid=" + eid +
	            ", name=" + name +
	            ", department=" + department +
	            ", salary=" + salary + "]";
	}
	
	
}
