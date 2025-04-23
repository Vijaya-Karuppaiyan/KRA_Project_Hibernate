package com.epes.anudip.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Designation is required")
    @Size(min = 2, max = 50, message = "Designation should be between 2 and 50 characters")
    private String designation;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    @NotNull(message = "Department is required")
    private Department dept;

    // Constructors
    public Employee() {}

    public Employee(int employeeId, String name, String email, String designation, Department dept) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.dept = dept;
    }

    // Getters & Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}
