package com.iver99.util;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;



public class HibernateTemplateFactory {
	
	private static SessionFactory sessionFactory;
	
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		HibernateTemplateFactory.sessionFactory = sessionFactory;
	}


	public HibernateTemplate getHibernateTemplate()
	{
		return new HibernateTemplate(getSessionFactory());
	}

}
