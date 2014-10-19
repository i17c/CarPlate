package com.iver99.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.iver99.biz.BinaryService;
import com.iver99.biz.impl.BinaryServiceImpl;
import com.iver99.util.ApplicationContextFactory;

public class BinaryController extends AbstractController{
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
		ApplicationContext ac=ApplicationContextFactory.getApplicationContext();
		BinaryService binaryService=(BinaryServiceImpl)(ac.getBean("binaryService"));
		//返回的newName不带后缀
		String newPicName=binaryService.binaryService(oldPicName);
		
		//覆盖原来的PictureName
		request.getSession().setAttribute("pictureName", newPicName+".jpg");
		
		return new ModelAndView(getSuccessView());
	}

}
