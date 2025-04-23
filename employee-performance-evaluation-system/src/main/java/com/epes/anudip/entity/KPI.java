package com.epes.anudip.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "kpis")
public class KPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kpiId;

    @NotBlank(message = "KPI name is required")
    @Size(min = 3, max = 50, message = "KPI name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 5, max = 200, message = "Description must be between 5 and 200 characters")
    private String description;

    @Min(value = 1, message = "Weightage must be at least 1")
    @Max(value = 100, message = "Weightage must be at most 100")
    private int weightage;

    // Constructors
    public KPI() {}

    public KPI(int kpiId, String name, String description, int weightage) {
        this.kpiId = kpiId;
        this.name = name;
        this.description = description;
        this.weightage = weightage;
    }

    // Getters & Setters
    public int getKpiId() {
        return kpiId;
    }

    public void setKpiId(int kpiId) {
        this.kpiId = kpiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeightage() {
        return weightage;
    }

    public void setWeightage(int weightage) {
        this.weightage = weightage;
    }
}
