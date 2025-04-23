package com.epes.anudip.service;

import java.util.List;

import com.epes.anudip.dao.EmployeeDAO;
import com.epes.anudip.entity.Employee;

public class EmployeeService {
	
	EmployeeDAO empDAO = new EmployeeDAO();
	
	// Add a new employee
	public void addEmployee(Employee emp)
	{
		empDAO.saveEmployee(emp);
		System.out.println("Employee added successfully:"+emp.getName());
	}
	
	// Get a Employee by id
	public Employee getEmployeeById(int empId)
	{
		return empDAO.getEmployeeById(empId);
	}
	
	// Get All Employees
	public List<Employee> getAllEmployees()
	{
		return empDAO.getAllEmployee();
	}
	// update an employee
	public void updateEmployee(Employee emp) {
        empDAO.updateEmployee(emp);
    }
     // delete an employee by id
    public void deleteEmployee(int empId) {
        empDAO.deleteEmployee(empId);
    }
}
