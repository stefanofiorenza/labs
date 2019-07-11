package com.knits.tms.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lombok.extern.slf4j.Slf4j;


@Configuration 
@EnableWebMvc 
@ComponentScan(value={"com.knits.tms.web.controllers"})
@Slf4j
public class MySmvcInitializer  {

	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setOrder(2);
		internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
		internalResourceViewResolver.setSuffix(".jsp");		
		return internalResourceViewResolver;
	}

	/*
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		if(converters.isEmpty()){
			log.info("[configureMessageConverters]: No Converters found");
		}		
		// add converters here
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		for (HttpMessageConverter<?>defaultMsgConverter : converters){
			log.info("[extendMessageConverters]: Configured MessageConverter: {} supported media types: {} ",defaultMsgConverter.getClass().getName(),defaultMsgConverter.getSupportedMediaTypes().toString() );
		}
	}
	
	*/

	
	
}
