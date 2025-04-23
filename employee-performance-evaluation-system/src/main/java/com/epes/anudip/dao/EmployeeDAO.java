package com.epes.anudip.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.epes.anudip.entity.Employee;
import com.epes.anudip.util.HibernatUtil;

public class EmployeeDAO {
   
	// save  i.e insert a employee details
	public void saveEmployee(Employee emp)
	{
		Transaction tobj= null;
		try(Session sobj = HibernatUtil.getSessionFactory().openSession()){
			tobj=sobj.beginTransaction();
			sobj.save(emp);
			tobj.commit();
		}
		catch(Exception e)
		{
			if(tobj!=null)
				tobj.rollback();
			e.printStackTrace();
		}
	}	
	
	// Retrieve an employee by id
	public Employee getEmployeeById(int empId)
	{
		try(Session sobj=HibernatUtil.getSessionFactory().openSession()){
			return sobj.get(Employee.class, empId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	//Retrieve all employees
	
	public List<Employee> getAllEmployee()
	{
		try(Session sobj = HibernatUtil.getSessionFactory().openSession()){
			return sobj.createQuery("FROM Employee", Employee.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	// Update an employee record
	public void updateEmployee(Employee emp) {
        Transaction tx = null;
        try (Session session = HibernatUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(emp);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    // Delete an employee record
    public void deleteEmployee(int empId) {
        Transaction tx = null;
        try (Session session = HibernatUtil.getSessionFactory().openSession()) {
            Employee emp = session.get(Employee.class, empId);
            if (emp != null) {
                tx = session.beginTransaction();
                session.delete(emp);
                tx.commit();
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
