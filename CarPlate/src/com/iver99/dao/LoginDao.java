package com.iver99.dao;

import org.hibernate.SessionFactory;

public interface LoginDao {
	
	//public final SessionFactory sessionFactory=null;
	public boolean checkLogin(String username,String password);

}
