package com.arief.hibernate.model.dao.impl;

import com.arief.hibernate.model.dao.DepartmentDAO;
import com.arief.hibernate.model.entity.Department;
import com.arief.hibernate.model.entity.Employee;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import java.util.logging.Logger;

public class DepartmentDAOImpl implements DepartmentDAO {

    private SessionFactory sessionFactory;


    private static final Logger LOGGER  = Logger.getLogger(DepartmentDAOImpl.class.getName());

    public DepartmentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Department d) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(d);
            session.getTransaction().commit();
            LOGGER.info("committed save() ....");
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("rollback transaction save() ....");
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Department> findAll() {
        Session session = sessionFactory.openSession();
        List<Department> departmentList = session.createQuery("from Department").list();
        session.close();
        return departmentList;
    }

    public Department findOne(String departmentId) {
        Session session = sessionFactory.openSession();
        Department d = session.get(Department.class,departmentId);
        Hibernate.initialize(d.getEmployeeList());
        session.close();
        return d;
    }



    public void delete(Department d) {
         Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(d);
            session.getTransaction().commit();
            LOGGER.info("commited delete() ...");
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("rollback transaction delete() ...");
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void update(Department d) {
         Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(d);
            session.getTransaction().commit();
            LOGGER.info("committed update() ....");
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("rollback transaction update() ...");
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void removeEmployee(int employeeId , String departmentId) {
         Session session = sessionFactory.openSession();
         try {
             session.beginTransaction();

             Department department = session.get(Department.class,departmentId);
             Employee e = session.get(Employee.class,employeeId);

             department.getEmployeeList().remove(e);

             session.getTransaction().commit();
             LOGGER.info("committed removeEmployee() ...");
         }catch (Exception ex){
             if(session.getTransaction()!=null)session.getTransaction().rollback();
             LOGGER.info("rollback transaction removeEmployee() ...");
             ex.printStackTrace();
         }finally {
             session.close();
         }
    }
}
