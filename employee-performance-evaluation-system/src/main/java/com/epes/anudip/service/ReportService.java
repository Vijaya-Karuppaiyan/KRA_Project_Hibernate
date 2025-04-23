package com.epes.anudip.service;

import java.util.Calendar;
import java.util.List;

import com.epes.anudip.dao.ReportDAO;
import com.epes.anudip.entity.Report;
import com.epes.anudip.util.ConsoleColors;


public class ReportService {

	private ReportDAO reportDAO = new ReportDAO();

    // Generate performance report for a specific employee
    public void generatePerformanceReport(int empId) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Report> reports = reportDAO.getReportsByEmployeeAndYear(empId, currentYear);

        if (reports.isEmpty()) {
            System.out.println(ConsoleColors.BOLD_RED + "No performance reports found for this employee." + ConsoleColors.RESET);
            return;
        }

        System.out.println(ConsoleColors.BOLD_CYAN + "\n===== Performance Reports for Employee ID: " + empId + " =====" + ConsoleColors.RESET);
        for (Report report : reports) {
            System.out.println(ConsoleColors.BOLD_YELLOW + "Year: " + report.getYear() + " | Half-Year: " + report.getHalfYear() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_GREEN + "Final Score: " + report.getOverallScore() + ConsoleColors.RESET);
            System.out.println("Performance Rating: " + ConsoleColors.BOLD_WHITE + report.getComments() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_BLUE + "-------------------------------------" + ConsoleColors.RESET);
        }
    }

    // Generate performance reports for all employees in a given year
    public void generateYearlyReport(int year) {
        List<Report> reports = reportDAO.getAllReportsByYear(year);

        if (reports.isEmpty()) {
            System.out.println(ConsoleColors.BOLD_RED + "No performance reports found for the year " + year + ConsoleColors.RESET);
            return;
        }

        System.out.println(ConsoleColors.BOLD_CYAN + "\n===== Performance Reports for Year: " + year + " =====" + ConsoleColors.RESET);
        for (Report report : reports) {
            System.out.println(ConsoleColors.BOLD_YELLOW + "Employee ID: " + report.getEmp().getEmployeeId() + ConsoleColors.RESET);
            System.out.println("Half-Year: " + report.getHalfYear());
            System.out.println(ConsoleColors.BOLD_GREEN + "Final Score: " + report.getOverallScore() + ConsoleColors.RESET);
            System.out.println("Performance Rating: " + ConsoleColors.BOLD_PURPLE + report.getComments() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_BLUE + "-------------------------------------" + ConsoleColors.RESET);
        }
    }
}
