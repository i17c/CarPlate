package com.iver99.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.iver99.biz.UploadPictureService;
import com.iver99.biz.impl.UploadPictureServiceImpl;

public class UploadPictureController extends AbstractController{

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
		// 转型为MultipartHttpRequest：     
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;     
        // 获得文件：     
        MultipartFile file = multipartRequest.getFile("upload");   
        //file可以得到原图片名称
		if(file==null)
			return new ModelAndView(getFailView());
		boolean flag=false;
		String picName=System.currentTimeMillis()+".jpg";
		
		UploadPictureService uploadSer=new UploadPictureServiceImpl();
		flag=uploadSer.uploadPictureService(file,picName);//传入带后缀的图片名称
		
		if(flag==true)
		{
			request.getSession().setAttribute("pictureName", picName);
			request.getSession().setAttribute("originalPictureName", picName);
			return new ModelAndView(getSuccessView());
		}else
		{
			System.out.println("上传图片出错（uploadPicController)");
			return new ModelAndView(getFailView());
			
		}
				
	
	}
	

}
