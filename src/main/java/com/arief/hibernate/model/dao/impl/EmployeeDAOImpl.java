package com.arief.hibernate.model.dao.impl;

import com.arief.hibernate.model.dao.EmployeeDAO;
import com.arief.hibernate.model.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.hibernate.query.NativeQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeeDAOImpl  implements EmployeeDAO{

    private static final Logger LOGGER = Logger.getLogger(EmployeeDAOImpl.class.getName());
    private SessionFactory sessionFactory;


    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Employee e) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(e);
            session.getTransaction().commit();
            LOGGER.info("committed save_employee() ....");
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("rollback transaction save_employee() ....");
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Employee> findAll() {
        Session session = sessionFactory.openSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        session.close();
        return employeeList;
    }

    @Override
    public void delete(int employeeId) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            Employee e = findOne(employeeId);
            session.remove(e);

            session.getTransaction().commit();
            LOGGER.info("committed delete_employee() ....");
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("rollback transaction delete_employee() ....");
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void update(Employee e) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(e);
            session.getTransaction().commit();
            LOGGER.info("committed update_employee() ....");
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("rollback transaction update_employee() ....");
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public Employee findOne(int i) {
        Session session = sessionFactory.openSession();
        Employee e  = session.get(Employee.class,i);
        session.close();
        return e;
    }
}
