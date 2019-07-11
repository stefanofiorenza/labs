package com.knits.tms.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import com.knits.tms.config.AppConfig;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

	
	@Override
	public void onStartup(final ServletContext servletContext)
			throws ServletException {
		registerDispatcherServlet(servletContext);
	}

	private void registerDispatcherServlet(final ServletContext servletContext) {
		WebApplicationContext dispatcherContext = createContext(MySmvcInitializer.class, AppConfig.class);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(
				dispatcherContext);		
		
		ServletRegistration.Dynamic dispatcher =  servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

	private WebApplicationContext createContext(
			final Class<?>... annotatedClasses) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(annotatedClasses);
		return context;
	}

}
