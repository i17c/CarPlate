package com.iver99.biz.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.iver99.biz.UploadPictureService;
import com.iver99.dao.UploadPictureDao;
import com.iver99.dao.impl.UploadPictureDaoImpl;
import com.iver99.util.ApplicationContextFactory;

public class UploadPictureServiceImpl implements UploadPictureService
		{

	

	@Override
	public boolean uploadPictureService(MultipartFile file,String picName)throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		ApplicationContext ac=ApplicationContextFactory.getApplicationContext();
		UploadPictureDao upPicDao=(UploadPictureDaoImpl)(ac.getBean("uploadPictureDao"));
		
		return flag=upPicDao.uploadPicture(file,picName);
		
		
	}

}
