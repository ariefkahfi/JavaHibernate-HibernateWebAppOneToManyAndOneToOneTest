package com.arief.hibernate.model.dao;

import com.arief.hibernate.model.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee e);
    List<Employee> findAll();
    void delete(int employeeId);
    void update(Employee e);
    Employee findOne(int i);
}
