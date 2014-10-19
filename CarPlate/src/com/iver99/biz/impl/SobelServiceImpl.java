package com.iver99.biz.impl;

import org.springframework.context.ApplicationContext;

import com.iver99.biz.SobelService;
import com.iver99.dao.SobelDao;
import com.iver99.dao.impl.SobelDaoImpl;
import com.iver99.util.ApplicationContextFactory;

public class SobelServiceImpl implements SobelService {

	@Override
	public void readImage(String picName) throws Exception {
		// TODO Auto-generated method stub
		/*ApplicationContext ac=ApplicationContextFactory.getApplicationContext();
				SobelDao sobelDao=null;
		sobelDao=(SobelDaoImpl)(ac.getBean("sobelDao"));*/
		SobelDao sobelDao=new SobelDaoImpl(50);
		sobelDao.readImage(picName);
	}

	@Override
	public void createEdgeImage(String newPicName) throws Exception {
		// TODO Auto-generated method stub
		/*ApplicationContext ac = ApplicationContextFactory
				.getApplicationContext();
		SobelDao sobelDao = null;
		sobelDao = (SobelDaoImpl) (ac.getBean("sobelDao"));*/
		SobelDao sobelDao=new SobelDaoImpl(50);
		sobelDao.createEdgeImage(newPicName);
	}

}
