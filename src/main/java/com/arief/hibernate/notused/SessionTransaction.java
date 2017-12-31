//package com.arief.hibernate.model.transaction;
//
//import com.arief.hibernate.model.dao.EmployeeDAO;
//import com.arief.hibernate.model.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//@Deprecated
//public abstract class SessionTransaction<A> {
//
//
//    protected void doUpdateTransaction(Session session,Transaction<A> transactionA , A a){
//        try {
//            session.beginTransaction();
//            transactionA.update(a);
//            session.getTransaction().commit();
//        }catch (Exception ex){
//            if(session.getTransaction()!=null)session.getTransaction().rollback();
//            ex.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//    protected void doSaveTransaction(Session session, Transaction<A> transactionA , A a){
//        try {
//            session.beginTransaction();
//            transactionA.save(a);
//            session.getTransaction().commit();
//        }catch (Exception ex){
//            if(session.getTransaction()!=null)session.getTransaction().rollback();
//            ex.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//}
