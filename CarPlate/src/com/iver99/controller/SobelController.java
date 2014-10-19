package com.iver99.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.iver99.dao.SobelDao;
import com.iver99.dao.impl.SobelDaoImpl;

public class SobelController extends AbstractController{

	private String successView;
	private String failView;
	
	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

	public String getFailView() {
		return failView;
	}

	public void setFailView(String failView) {
		this.failView = failView;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String oldPicName=(String)(request.getSession().getAttribute("pictureName"));
		String newPicName=System.currentTimeMillis()+".jpg";
		
		
		SobelDao sobelDao=new SobelDaoImpl(50);
		sobelDao.readImage(oldPicName);
		sobelDao.createEdgeImage(newPicName);
		request.getSession().setAttribute("pictureName", newPicName);
		
		return new ModelAndView(getSuccessView());
	}
	

}
