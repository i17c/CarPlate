package com.iver99.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class ApplicationContextFactory {
	
	public static ApplicationContext getApplicationContext()
	{
		return  new ClassPathXmlApplicationContext("applicationContext.xml");
	}

}
