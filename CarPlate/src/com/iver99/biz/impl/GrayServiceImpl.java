package com.iver99.biz.impl;

import org.springframework.context.ApplicationContext;

import com.iver99.biz.GrayService;
import com.iver99.dao.GrayDao;
import com.iver99.dao.impl.GrayDaoImpl;
import com.iver99.util.ApplicationContextFactory;

public class GrayServiceImpl implements GrayService {

	@Override
	public String grayService(String picName)throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext ac=ApplicationContextFactory.getApplicationContext();
		GrayDao grayDao=(GrayDaoImpl)(ac.getBean("grayDao"));
		//boolean flag=false;
		return grayDao.grayImage(picName);
		
		//return false;
	}

}
