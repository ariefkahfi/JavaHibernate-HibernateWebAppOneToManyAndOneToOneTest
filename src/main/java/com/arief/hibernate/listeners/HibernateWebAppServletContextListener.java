package com.arief.hibernate.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.arief.hibernate.model.dao.DepartmentDAO;
import com.arief.hibernate.model.dao.EmployeeDAO;
import com.arief.hibernate.model.dao.ProjectDAO;
import com.arief.hibernate.model.dao.impl.DepartmentDAOImpl;
import com.arief.hibernate.model.dao.impl.EmployeeDAOImpl;
import com.arief.hibernate.model.dao.impl.ProjectDAOImpl;
import com.arief.hibernate.setup.HibernateSetup;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;

public class HibernateWebAppServletContextListener implements ServletContextListener {


	private SessionFactory sessionFactory;

	
	private static final Logger LOGGER = Logger.getLogger(HibernateWebAppServletContextListener.class.getName());
	
	public void contextDestroyed(ServletContextEvent arg0) {
		LOGGER.info("Context destroyed ....");
		if(sessionFactory!=null){
			sessionFactory.close();
			LOGGER.info("SessionFactory closed ....");
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		LOGGER.info("Context initialized ...");

		LOGGER.info("get sessionFactory from HibernateSetup");
		sessionFactory = HibernateSetup.sessionFactoryInstance();

		LOGGER.info("instantiate DepartmentDAO class....");
		DepartmentDAO departmentDAO = new DepartmentDAOImpl(sessionFactory);

		LOGGER.info("instantiate EmployeeDAO class....");
		EmployeeDAO employeeDAO = new EmployeeDAOImpl(sessionFactory);

		LOGGER.info("instantiate ProjectDAO class....");
		ProjectDAO projectDAO = new ProjectDAOImpl(sessionFactory);

		LOGGER.info("inject departmentDAO to servletContextAttribute ...");
		arg0.getServletContext()
				.setAttribute("departmentDAO",departmentDAO);

		LOGGER.info("inject employeeDAO to servletContextAttribute ...");
		arg0.getServletContext()
				.setAttribute("employeeDAO",employeeDAO);

		LOGGER.info("inject projectDAO to servletContextAttribute ...");
		arg0.getServletContext()
				.setAttribute("projectDAO",projectDAO);

	}

}
