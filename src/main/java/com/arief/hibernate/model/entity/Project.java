package com.arief.hibernate.model.entity;

import javax.persistence.*;

@Entity
@Table(name="project")
public class Project{
	@Id
    @Column(name = "project_id")
    private String projectId;

	@Column(name="project_name")
    private String projectName;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",unique = true)
    private Employee employee;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}