package com.iver99.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.iver99.biz.GrayService;
import com.iver99.biz.impl.GrayServiceImpl;
import com.iver99.util.ApplicationContextFactory;

public class GrayController extends AbstractController{

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
		//String newPicName=System.currentTimeMillis()+".jpg";
		//�Ѵ�����ͼƬ���ƴ���session������ҳ���ϻ�ȡ
		String oldPicName=(String)(request.getSession().getAttribute("pictureName"));
		ApplicationContext ac=ApplicationContextFactory.getApplicationContext();
		//boolean flag=false;
		String newPicName;
		GrayService grayService=(GrayServiceImpl)(ac.getBean("grayService"));
		//���ص�newName������׺
		newPicName=grayService.grayService(oldPicName);
		
		//����ԭ����PictureName
		request.getSession().setAttribute("pictureName", newPicName+".jpg");
		
		return new ModelAndView(getSuccessView());
	}

}
