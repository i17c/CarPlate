package com.iver99.biz.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.iver99.biz.LoginService;
import com.iver99.dao.LoginDao;
import com.iver99.util.ApplicationContextFactory;

public class LoginServiceImpl implements LoginService{

	@Override
	public boolean verifyLogin(String username, String password) {
		// TODO Auto-generated method stub
		//ApplicationContext ac = new XmlWebApplicationContext(); 
		ApplicationContext ac=ApplicationContextFactory.getApplicationContext();
		System.out.println("....ac(service)..."+ac);
		boolean flag=false;
		LoginDao loginDao=(LoginDao)(ac.getBean("loginDao"));
		flag=loginDao.checkLogin(username, password);
		if(flag==false)
			return false;
		else
			return true;
	}

}
