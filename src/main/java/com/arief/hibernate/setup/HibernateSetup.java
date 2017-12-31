package com.arief.hibernate.setup;

import com.arief.hibernate.config.HibernateConfiguration;
import com.arief.hibernate.model.entity.Department;
import com.arief.hibernate.model.entity.Employee;
import com.arief.hibernate.model.entity.Project;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSetup {
	private static SessionFactory setUpSessionFactory() {
		Configuration config = new Configuration()
				.addAnnotatedClass(Department.class)
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Project.class)
				.setProperties(HibernateConfiguration.getHibernateProps());
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		return sessionFactory;
	}
	
	public static SessionFactory sessionFactoryInstance() {
		return setUpSessionFactory();
	}
}
