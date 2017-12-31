//package com.arief.hibernate.model.dao.impl;
//
//import com.arief.hibernate.model.dao.EmployeeDAO;
//import com.arief.hibernate.model.entity.Employee;
//import com.arief.hibernate.model.transaction.SessionTransaction;
//import com.arief.hibernate.model.transaction.Transaction;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import java.util.List;
//
//@Deprecated
//class EmployeeTransaction implements Transaction<Employee>{
//
//    private SessionFactory  sessionFactory;
//
//    public EmployeeTransaction(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public SessionFactory getSessionFactory() {
//        return this.sessionFactory;
//    }
//
//    public void save(Employee o) {
//        sessionFactory.getCurrentSession().save(o);
//    }
//
//    public void update(Employee o) {
//        sessionFactory.getCurrentSession().update(o);
//    }
//}
//
//@Deprecated
//public  class EmployeeDAOTransaction extends SessionTransaction<Employee> implements EmployeeDAO{
//
//
//    private Transaction<Employee> employeeTransaction;
//    public EmployeeDAOTransaction(SessionFactory sessionFactory) {
//        this.employeeTransaction = new EmployeeTransaction(sessionFactory);
//    }
//
//    public void save(Employee e) {
//        doSaveTransaction(employeeTransaction.getSessionFactory().openSession(),employeeTransaction,e);
//    }
//
//    public List<Employee> findAll() {
//        return null;
//    }
//
//    public void update(Employee e) {
//        doUpdateTransaction(
//                employeeTransaction.getSessionFactory().openSession()
//                ,employeeTransaction,
//                e);
//    }
//}
