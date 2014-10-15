package com.iver99.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.iver99.dao.LoginDao;
import com.iver99.util.ApplicationContextFactory;
import com.iver99.vo.User;

public class LoginDaoImpl implements LoginDao{
	
	
	@Override
	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		ApplicationContext ac=ApplicationContextFactory.getApplicationContext();
		HibernateTemplate hibTemplate=new HibernateTemplate((SessionFactory)(ac.getBean("sessionFactory")));
		User user=(User)(ac.getBean("user"));
		user.setPassword(password);
		user.setUsername(username);
		
		List list =hibTemplate.findByExample(user);
		if(list.size()==0)
			return false;
		else
			return true;
					
		
	}
	

}
