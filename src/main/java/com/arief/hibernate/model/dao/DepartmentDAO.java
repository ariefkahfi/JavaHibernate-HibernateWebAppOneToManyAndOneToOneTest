package com.arief.hibernate.model.dao;

import com.arief.hibernate.model.entity.Department;
import com.arief.hibernate.model.entity.Employee;

import java.util.List;

public interface DepartmentDAO {
    void save(Department d);
    List<Department> findAll();
    Department findOne(String departmentId);
    void delete(Department d);
    void update(Department d);
    void removeEmployee(int employeeId,String departmentId);
}
