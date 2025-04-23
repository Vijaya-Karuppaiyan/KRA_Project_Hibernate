package com.epes.anudip.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.epes.anudip.entity.Report;
import com.epes.anudip.util.HibernatUtil;

public class ReportDAO {
    // Add a report
	public void saveReport(Report report) {
        Transaction tobj = null;
        try (Session sobj = HibernatUtil.getSessionFactory().openSession()) {
            tobj = sobj.beginTransaction();
            sobj.save(report);
            tobj.commit();
        } catch (Exception e) {
            if (tobj != null) {
                tobj.rollback();
            }
            e.printStackTrace();
        }
    }
	// Fetch reports for a specific employee in a given year
    public List<Report> getReportsByEmployeeAndYear(int empId, int year) {
        try (Session session = HibernatUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Report WHERE emp.employeeId = :empId AND year = :year", Report.class)
                          .setParameter("empId", empId)
                          .setParameter("year", year)
                          .list();
        }
    }

    // Fetch all reports for a given year
    public List<Report> getAllReportsByYear(int year) {
        try (Session session = HibernatUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Report WHERE year = :year", Report.class)
                          .setParameter("year", year)
                          .list();
        }
    }
}
