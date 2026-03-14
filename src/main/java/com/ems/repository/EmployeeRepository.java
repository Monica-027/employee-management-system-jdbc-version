package com.ems.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.Employee;
import com.ems.util.DBConnection;

// Repository Layer responsible for DB operations
public class EmployeeRepository {
	
	
	//INSERTS NEW EMPLOYEE RECORD INTO DB
	public boolean insertEmployee(Employee emp) {
		String query = "Insert into employee(name,department,salary) values(?,?,?)";
		try(Connection conn = DBConnection.createConnection();
			PreparedStatement pstm = conn.prepareStatement(query)) {
			
			pstm.setString(1, emp.getName());
			pstm.setString(2, emp.getDepartment());
			pstm.setDouble(3, emp.getSalary());
			
			int rows = pstm.executeUpdate();
			//Returns true if at least one row inserted 
			return rows > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//RETRIEVES ALL EMPLOYEE RECORDS FROM DB
	public List<Employee> viewAllEmployees() {	
		List<Employee> employees = new ArrayList<>();
		String query = "Select * from employee";
		try(Connection conn = DBConnection.createConnection();
			PreparedStatement pstm = conn.prepareStatement(query)) {
			ResultSet rs = pstm.executeQuery();
			
			//Iterate through result set and map each row to an Employee object
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				String name = rs.getString("name");
				String department = rs.getString("department");
				Double salary = rs.getDouble("salary");
				
				Employee emp = new Employee(eid, name, department, salary);
				employees.add(emp);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees; 
	}
	
	
	//RETRIEVE AN EXISTING RECORD BASED ON ID
	public Employee findById(int id) {
		String query = "Select * from employee where eid = ?";
		
		try(Connection conn = DBConnection.createConnection();
			PreparedStatement pstm = conn.prepareStatement(query)) {
		
			pstm.setInt(1, id); //setting id to query
			ResultSet rs = pstm.executeQuery();
				if(rs.next()) {
					
					int eid = rs.getInt("eid");
					String name = rs.getString("name");
					String department = rs.getString("department");
					Double salary = rs.getDouble("salary");
					
					Employee emp = new Employee(eid, name, department, salary);
					return emp;
				}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//UPDATE AN EXISTING RECORD 
	public boolean updateEmployee(Employee updatedEmp) {
		String query = "Update employee set name = ?, department = ?, salary = ? where eid = ?";

		try(Connection conn = DBConnection.createConnection();
			PreparedStatement pstm = conn.prepareStatement(query)) {

			//updatedEmp stores the updated data (received from Employee main.java through EmployeeService)
			//add updatedEmp data to the database
			pstm.setString(1, updatedEmp.getName());
			pstm.setString(2, updatedEmp.getDepartment());
			pstm.setDouble(3, updatedEmp.getSalary());
			pstm.setInt(4, updatedEmp.getEid());
		
			int rows = pstm.executeUpdate();
			//Returns true if a row is updated
			return rows > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//DELETE A RECORD BASED ON ID
	public boolean deleteEmployee(int eid) {
		String query = "Delete from employee where eid = ?";
		try (Connection conn = DBConnection.createConnection();
			PreparedStatement pstm = conn.prepareStatement(query)){

			pstm.setInt(1, eid);
			int rows = pstm.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//DELETES ALL EMPLOYEE & RESET THE AUTO-INC ID 
	public boolean deleteAll(String answer) {
		
		String query = "Truncate table employee Restart identity";
		try(Connection conn = DBConnection.createConnection();
			PreparedStatement pstm = conn.prepareStatement(query)) {
			
				pstm.executeUpdate(); 
				return true;  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}		
}
