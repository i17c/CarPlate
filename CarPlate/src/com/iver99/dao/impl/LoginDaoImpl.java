package com.iver99.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.iver99.dao.LoginDao;
import com.iver99.util.ApplicationContextFactory;
import com.iver99.vo.User;

public class LoginDaoImpl implements LoginDao{
	
	
	@Override
	public void checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		//ApplicationContext ac = new FileSystemXmlApplicationContext("applicationContext.xml");
		ApplicationContext ac=ApplicationContextFactory.getApplicationContext();
		//HibernateTemplate hibernateTemplate=(HibernateTemplate)(ac.getBean("hibernateTemplateFactory"));
		HibernateTemplate hibTemplate=new HibernateTemplate((SessionFactory)(ac.getBean("sessionFactory")));
		User user=(User)(ac.getBean("user"));
		user.setPassword(password);
		user.setUsername(username);
		//��һ�����Ը�ֵ
		//List list =hibernateTemplate.findByExample(user);
		//System.out.println("Dao��checklogin.."+list);
		
	}
	

}
