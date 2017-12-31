package com.arief.hibernate.model.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="department")
public class Department {
	
	@Id
	@Column(name="department_id")
	private String departmentId;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="department_location")
	private String departmentLocation;
	
	@OneToMany(mappedBy="department",orphanRemoval = true)
	private List<Employee> employeeList;

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
}