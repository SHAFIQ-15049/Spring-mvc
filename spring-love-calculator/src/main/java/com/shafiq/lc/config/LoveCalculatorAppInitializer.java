package com.shafiq.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorAppInitializer //implements WebApplicationInitializer
{

	//@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
//		XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
//		webApplicationContext.setConfigLocation("classpath:config.xml");
//		
		
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalculatorAppConfig.class);
		
		
		//create ds object
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		//resgister ds with servletcontext
		ServletRegistration.Dynamic mycustomdispatcher = servletContext.addServlet("mydispatcher", dispatcherServlet);
		
		mycustomdispatcher.setLoadOnStartup(1);
		mycustomdispatcher.addMapping("/mywebsite.com/*");
		
		
		
	}
	
	

}
