package com.arief.hibernate.model.entity;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee{

    @Id
    @Column(name="employee_id")
    @GeneratedValue
    private int employeeId;


    @Column(name="employee_name")
    private String employeeName;

    @Column(name="employee_address")
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(mappedBy = "employee",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.REMOVE})
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}