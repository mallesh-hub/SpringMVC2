package com.mallesh.lc.config;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorApplicationInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		System.out.println("the custom class startup method got called mallesh");
		
		
		/*
		 * XmlWebApplicationContext applicationContext=new XmlWebApplicationContext();
		 * applicationContext.setConfigLocation("classpath:application-context.xml");
		 */
		AnnotationConfigWebApplicationContext  applicationContext=new AnnotationConfigWebApplicationContext();
		applicationContext.register(LoveCalculatorAppConfig.class);

		DispatcherServlet dispatcherServlet=new DispatcherServlet(applicationContext);
		ServletRegistration.Dynamic mycustomdispatcherservlet=servletContext.addServlet("mydispatcherservlet", dispatcherServlet);
		mycustomdispatcherservlet.setLoadOnStartup(1);
		mycustomdispatcherservlet.addMapping("/mywebsit.com/*");
		
	}

}
