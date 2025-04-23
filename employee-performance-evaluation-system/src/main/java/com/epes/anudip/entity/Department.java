package com.epes.anudip.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @NotBlank(message = "Department name is required")
    @Size(min = 2, max = 50, message = "Department name must be between 2 and 50 characters")
    @Column(length=50)
    private String name;

    @OneToMany(mappedBy = "dept")
    private List<Employee> emp;

    // Constructors
    public Department() {}

    public Department(int departmentId, String name, List<Employee> emp) {
        this.departmentId = departmentId;
        this.name = name;
        this.emp = emp;
    }

    // Getters & Setters
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmp() {
        return emp;
    }

    public void setEmp(List<Employee> emp) {
        this.emp = emp;
    }
}
