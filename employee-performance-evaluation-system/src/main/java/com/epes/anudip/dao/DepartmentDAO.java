package com.epes.anudip.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.epes.anudip.entity.Department;
import com.epes.anudip.util.HibernatUtil;

public class DepartmentDAO {
	// add a department
	public void saveDepartment(Department dept)
	{
		Transaction tobj = null;
        try (Session sobj = HibernatUtil.getSessionFactory().openSession()) {
            tobj = sobj.beginTransaction();
            sobj.save(dept);
            tobj.commit();
        } catch (Exception e) {
            if (tobj != null) {
                tobj.rollback();
            }
            e.printStackTrace();
        }
	}
   
	// Get Department by ID
    public Department getDepartmentById(int departmentId) {
        try (Session sobj = HibernatUtil.getSessionFactory().openSession()) {
            return sobj.get(Department.class, departmentId);
        }
    }

    // Get all Departments
    public List<Department> getAllDepartments() {
        try (Session sobj = HibernatUtil.getSessionFactory().openSession()) {
            return sobj.createQuery("FROM Department", Department.class).list();
        }
    }
}
