package com.epes.anudip.service;

import java.util.List;

import com.epes.anudip.dao.DepartmentDAO;
import com.epes.anudip.entity.Department;

public class DepartmentService {
    
	DepartmentDAO deptDAO = new DepartmentDAO();
	
	// Add a new Department
	public void addDepartment(Department dept)
	{
		deptDAO.saveDepartment(dept);
		System.out.println("Department added successfully:"+dept.getName());	
	}
	
	// Get department by ID
    public Department getDepartmentById(int deptId) {
        return deptDAO.getDepartmentById(deptId);
    }

    // Get all departments
    public List<Department> getAllDepartments() {
        return deptDAO.getAllDepartments();
    }
}
