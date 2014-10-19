package com.iver99.biz.impl;

import org.springframework.context.ApplicationContext;

import com.iver99.biz.BinaryService;
import com.iver99.dao.BinaryDao;
import com.iver99.dao.impl.BinaryDaoImpl;
import com.iver99.util.ApplicationContextFactory;

public class BinaryServiceImpl implements BinaryService {

	@Override
	public String binaryService(String picName)throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext ac=ApplicationContextFactory.getApplicationContext();
		BinaryDao binaryDao=(BinaryDaoImpl)(ac.getBean("binaryDao"));
		
		return binaryDao.binaryImage(picName);
	}

}
