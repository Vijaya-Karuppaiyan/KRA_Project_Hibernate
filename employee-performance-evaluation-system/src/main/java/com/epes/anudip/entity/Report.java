package com.epes.anudip.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee emp;

    @Min(value = 2000, message = "Year must be a valid 4-digit number")
    @Max(value = 2100, message = "Year must be within reasonable range")
    private int year;

    @NotBlank(message = "Half-year value must not be blank")
    @Pattern(regexp = "H1|H2", message = "Half-year must be either 'H1' or 'H2'")
    private String halfYear;

    @DecimalMin(value = "0.0", message = "Score must be 0 or more")
    @DecimalMax(value = "100.0", message = "Score must not exceed 100")
    private double overallScore;

    @Size(max = 200, message = "Comments should not exceed 200 characters")
    private String comments;

    public Report() {}

    public Report(int reportId, Employee emp, int year, double overallScore, String halfYear, String comments) {
        this.reportId = reportId;
        this.emp = emp;
        this.year = year;
        this.halfYear = halfYear;
        this.overallScore = overallScore;
        this.comments = comments;
    }

    // Getters and Setters

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getHalfYear() {
        return halfYear;
    }

    public void setHalfYear(String halfYear) {
        this.halfYear = halfYear;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
