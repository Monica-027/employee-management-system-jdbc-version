package com.ems.main;

import java.util.Scanner;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

public class EmployeeMain {

	public static void main(String[] args) {

		EmployeeService service = new EmployeeService();

		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while(choice != 7) {
			
			//MENU CODE
			System.out.println("1. Add Employee");
			System.out.println("2. View all Employee");
			System.out.println("3. Find Employee by ID");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Delete All Employees");
			System.out.println("7. Exit");
			System.out.println("Enter the operation you want to perform: ");
			choice = sc.nextInt();
			sc.nextLine();
		
			switch (choice) {
			case 1:
				System.out.println("Enter Name:");
				String name = sc.nextLine();
	
				System.out.println("Enter Department:");
				String department =sc.nextLine();
				
				System.out.println("Enter Salary:");
				double salary = sc.nextDouble();
				sc.nextLine();
				
				Employee emp = new Employee(name, department, salary);
				service.addEmployee(emp);
				break;
			case 2:
				service.fetchEmployees();
				break;
			case 3:
				System.out.println("Enter Eid for Search");
				int eid = sc.nextInt();
				sc.nextLine();
				service.searchEmployee(eid);
				break;
			case 4:
				System.out.println("Enter eid of employee to update");
				int id = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Updated Name:");
				String updatedName =sc.nextLine();
	
				System.out.println("Enter Updated Department:");
				String updatedDepartment = sc.nextLine();
				
				System.out.println("Enter Updated Salary:");
				double updatedSalary = sc.nextDouble();
				sc.nextLine();
				
				Employee updatedEmp = new Employee(id, updatedName, updatedDepartment, updatedSalary);
				
				service.updateEmployee(updatedEmp);
				break;
			case 5:
				System.out.println("Enter eid of employee to delete");
				int deleteId = sc.nextInt();
				sc.nextLine();
				
				service.deleteEmployee(deleteId);
				break;
			case 6:
				System.out.println("Are you sure you want to delete all Employee data?");
				System.out.println("Type Yes to confirm");
				String answer = sc.nextLine();
				if(answer.equalsIgnoreCase("yes")) {
					service.deleteAll(answer);	
				}
				break;
			case 7:
				System .out.println("Program exited");
				System.out.println("To start the program again! Re-run");
				break;
			default:
				System.out.println("Enter correct operation Number");
				break;
			}
		}	
		sc.close();
	}

}
