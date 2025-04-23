package com.epes.anudip.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "performance_reviews")
public class PerformanceReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee emp;

    @ManyToOne
    @JoinColumn(name = "kpi_id", nullable = false)
    private KPI kpi;

    @Min(value = 0, message = "Score must be at least 0")
    @Max(value = 100, message = "Score must not exceed 100")
    private int score;

    @Size(max = 200, message = "Comments must not exceed 200 characters")
    private String comments;

    @NotNull(message = "Review date is required")
    private LocalDate reviewDate;

    // Constructors
    public PerformanceReview() {}

    public PerformanceReview(int reviewId, Employee emp, KPI kpi, int score, String comments, LocalDate reviewDate) {
        this.reviewId = reviewId;
        this.emp = emp;
        this.kpi = kpi;
        this.score = score;
        this.comments = comments;
        this.reviewDate = reviewDate;
    }

    // Getters & Setters
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public KPI getKpi() {
        return kpi;
    }

    public void setKpi(KPI kpi) {
        this.kpi = kpi;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }
}
