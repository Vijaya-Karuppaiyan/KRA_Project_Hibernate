package com.epes.anudip.service;
import com.epes.anudip.util.ConsoleColors;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.epes.anudip.dao.EmployeeDAO;
import com.epes.anudip.dao.KPIDAO;
import com.epes.anudip.dao.PerformanceReviewDAO;
import com.epes.anudip.dao.ReportDAO;
import com.epes.anudip.entity.Employee;
import com.epes.anudip.entity.KPI;
import com.epes.anudip.entity.PerformanceReview;
import com.epes.anudip.entity.Report;

public class PerformanceService {
	
	 private PerformanceReviewDAO reviewDAO = new PerformanceReviewDAO();
	    private KPIDAO kpiDAO = new KPIDAO();
	    private ReportDAO reportDAO = new ReportDAO();

	    // Add Performance Review for an Employee
	    public void addPerformanceReview(Employee employee) {
	        Scanner scanner = new Scanner(System.in);
	        List<KPI> kpis = kpiDAO.getAllKPIs();

	        if (kpis.isEmpty()) {
	            System.out.println(ConsoleColors.BOLD_RED + "No KPIs found. Please add KPIs first." + ConsoleColors.RESET);
	            return;
	        }

	        System.out.print(ConsoleColors.BOLD_CYAN + "Enter the half of the year (H1 for Jan-Jun, H2 for Jul-Dec): " + ConsoleColors.RESET);
	        String halfYear = scanner.next().toUpperCase();

	        List<PerformanceReview> reviews = new ArrayList<>();
	        double totalScore = 0;
	        int totalWeightage = 0;

	        for (KPI kpi : kpis) {
	            System.out.print(ConsoleColors.BOLD_BLUE + "Enter score for KPI (" + kpi.getName() + "): " + ConsoleColors.RESET);
	            int score = scanner.nextInt();

	            PerformanceReview review = new PerformanceReview();
	            review.setEmp(employee);
	            review.setKpi(kpi);
	            review.setScore(score);
	            review.setReviewDate(LocalDate.now());

	            reviews.add(review);

	            totalScore += score * kpi.getWeightage();
	            totalWeightage += kpi.getWeightage();
	        }

	        reviewDAO.savePerformanceReview(reviews);

	        double finalScore = totalWeightage > 0 ? (totalScore / totalWeightage) : 0;
	        String comments = getPerformanceComments(finalScore);

	        Report report = new Report();
	        report.setEmp(employee);
	        report.setOverallScore(finalScore);
	        report.setYear(Calendar.getInstance().get(Calendar.YEAR));
	        report.setHalfYear(halfYear);
	        report.setComments(comments);

	        reportDAO.saveReport(report);

	        System.out.println(ConsoleColors.BOLD_GREEN + "\n✔ Performance review added and report generated successfully!" + ConsoleColors.RESET);
	    }

	    // Generate Comments based on Score
	    private String getPerformanceComments(double score) {
	        if (score >= 85) return "Excellent";
	        if (score >= 70) return "Good";
	        if (score >= 50) return "Satisfactory";
	        return "Needs Improvement";
	    }

	    // Generate Performance Report for a Specific Employee
	    public void generatePerformanceReport(int empId) {
	        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	        List<Report> reports = reportDAO.getReportsByEmployeeAndYear(empId, currentYear);

	        if (reports.isEmpty()) {
	            System.out.println(ConsoleColors.BOLD_RED + "No performance reports found for this employee." + ConsoleColors.RESET);
	            return;
	        }

	        System.out.println(ConsoleColors.BOLD_YELLOW + "\n===== Performance Reports for Employee ID: " + empId + " =====" + ConsoleColors.RESET);
	        System.out.printf(ConsoleColors.BOLD_WHITE + "%-10s %-10s %-15s %-20s\n" + ConsoleColors.RESET, "Year", "Half", "Final Score", "Performance Rating");
	        System.out.println(ConsoleColors.WHITE + "-------------------------------------------------------------" + ConsoleColors.RESET);

	        for (Report report : reports) {
	            System.out.printf("%-10d %-10s %-15.2f %-20s\n",
	                report.getYear(),
	                report.getHalfYear(),
	                report.getOverallScore(),
	                report.getComments());
	        }
	    }

	    // Generate Performance Reports for All Employees in a Given Year
	    public void generateYearlyReport(int year) {
	        List<Report> reports = reportDAO.getAllReportsByYear(year);

	        if (reports.isEmpty()) {
	            System.out.println(ConsoleColors.BOLD_RED + "No performance reports found for the year " + year + ConsoleColors.RESET);
	            return;
	        }

	        System.out.println(ConsoleColors.BOLD_YELLOW + "\n===== Performance Reports for Year: " + year + " =====" + ConsoleColors.RESET);
	        System.out.printf(ConsoleColors.BOLD_BLUE + "%-12s %-10s %-15s %-20s\n" + ConsoleColors.RESET, "Employee ID", "Half", "Final Score", "Performance Rating");
	        System.out.println(ConsoleColors.WHITE + "-------------------------------------------------------------------" + ConsoleColors.RESET);

	        for (Report report : reports) {
	            System.out.printf("%-12d %-10s %-15.2f %-20s\n",
	                report.getEmp().getEmployeeId(),
	                report.getHalfYear(),
	                report.getOverallScore(),
	                report.getComments());
	        }
	    }
}
