package com.epes.anudip.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.epes.anudip.entity.KPI;
import com.epes.anudip.entity.PerformanceReview;
import com.epes.anudip.util.HibernatUtil;

public class PerformanceReviewDAO {
	
	
	// Save multiple performance reviews
    public void savePerformanceReview(List<PerformanceReview> reviews) {
        Transaction transaction = null;
        try (Session session = HibernatUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            for (PerformanceReview review : reviews) {
                session.save(review);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Get performance reviews for an employee in a given year
    public List<PerformanceReview> getReviewsByEmployeeAndYear(int empId, int year) {
        try (Session session = HibernatUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM PerformanceReview WHERE employee.id = :empId AND YEAR(reviewDate) = :year", PerformanceReview.class)
                          .setParameter("empId", empId)
                          .setParameter("year", year)
                          .list();
        }
    }
	
	
}
