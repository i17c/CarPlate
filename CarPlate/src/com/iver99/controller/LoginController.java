package com.iver99.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.iver99.biz.LoginService;
import com.iver99.biz.impl.LoginServiceImpl;
import com.iver99.vo.User;

public class LoginController extends AbstractController{
	
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("username.."+username+"..password.."+password);	
		
		
		//ModelAndView mav=new ModelAndView(getSuccessView());
		//mav.addObject("msg", "login success!!!");
		Boolean flag=true;
		LoginService loginService=new LoginServiceImpl();
		flag=loginService.verifyLogin(username, password);
		//test
		//ApplicationContext ac=ApplicationContextFactory.getApplicationContext();
		//ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//User user=(User)(ac.getBean("user"));
		//System.out.println("....ac(controller)..."+ac);
		
		
		
		if(flag==true)
		{	
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("password", password);
			ModelAndView mav=new ModelAndView(getSuccessView());
			return mav;
		}else
		{
			ModelAndView mav=new ModelAndView(getFailView());
			return mav;
		}
			
	
	}

	
}
