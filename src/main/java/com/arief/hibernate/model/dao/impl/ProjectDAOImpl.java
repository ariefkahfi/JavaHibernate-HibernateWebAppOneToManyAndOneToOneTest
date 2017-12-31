package com.arief.hibernate.model.dao.impl;

import com.arief.hibernate.model.dao.ProjectDAO;
import com.arief.hibernate.model.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.logging.Logger;

public class ProjectDAOImpl implements ProjectDAO {

    private static final Logger LOGGER = Logger.getLogger(ProjectDAOImpl.class.getName());
    private SessionFactory sessionFactory;

    public ProjectDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Project p) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
            LOGGER.info("committed save_project() ....");
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("rollback transaction save_project() ....");
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Project> findAll() {
        Session session = sessionFactory.openSession();
        List<Project> projectList = session.createQuery("from Project").list();
        session.close();
        return projectList;
    }

    public void update(Project p) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(p);
            session.getTransaction().commit();
            LOGGER.info("committed update_project() ....");
        }catch (Exception ex){
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("rollback transaction update_project() ....");
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public Project findOne(String projectId) {
        Session session = sessionFactory.openSession();
        Project p = session.get(Project.class,projectId);
        session.close();
        return p;
    }
}
