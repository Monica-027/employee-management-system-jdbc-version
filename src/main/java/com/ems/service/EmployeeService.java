package com.ems.service;

import java.util.List;

import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;

//Service layer for Business Logic
public class EmployeeService {
	
	EmployeeRepository repository = new EmployeeRepository();

	public void addEmployee(Employee emp) {
		boolean added = repository.insertEmployee(emp);

		if(added){
			System.out.println("Employee added successfully");
		}else {
			System.out.println("Failed to add Employee");
		}	
	}
	
	public void fetchEmployees() {
		
		List<Employee> employees = repository.viewAllEmployees();	
		if(!employees.isEmpty()) {
			System.out.println("---------Employees----------");
			for(Employee emp: employees) {
				System.out.println(emp);
			}
			System.out.println("**************");
			System.out.println("All Employee records fetched");
		}else {
			System.out.println("No Employee data found");		
		}
	}
	
	public void searchEmployee(int id) {
		Employee emp = repository.findById(id);
		if(emp!=null) {
			System.out.println(emp);
		}else {
			System.out.println("Employee not found");
		}
	}
	
	public void updateEmployee(Employee updatedEmp) {
		boolean updated = repository.updateEmployee(updatedEmp);
		if(updated) {
			System.out.println("Employee with Eid: " + updatedEmp.getEid() + " is updated");
		}else {
			System.out.println("Employee with Eid: " + updatedEmp.getEid() + " is not updated");
		}
	}
	
	public void deleteEmployee(int eid) {
		boolean deleted = repository.deleteEmployee(eid);
		if(deleted) {
			System.out.println("Employee with Eid: " + eid + " is deleted");
		}else {
			System.out.println("Employee with Eid: " + eid + " not found");
		}
	}
	
	public void deleteAll(String answer) {
		boolean deleteAll = repository.deleteAll(answer);
		if(deleteAll) {
			System.out.println("****All Employees Deleted******");
		}else {
			System.out.println("Employee data can't be deleted");
		}
	}

}
