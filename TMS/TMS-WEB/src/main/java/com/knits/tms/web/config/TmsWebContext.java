package com.knits.tms.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import lombok.extern.slf4j.Slf4j;


@Configuration 
@EnableWebMvc 
@ComponentScan(value={"com.knits.tms.web.controllers"})	
public class TmsWebContext implements WebMvcConfigurer {

	
	@Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] { 
        			"/WEB-INF/tiles-templates.xml",
        		  	"/WEB-INF/tiles-views.xml"});
        tilesConfigurer.setCheckRefresh(true);
         
        return tilesConfigurer;
    }
     
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
       registry.viewResolver(new TilesViewResolver());
    }
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**") //uri pattern (in views)
          .addResourceLocations("/static/");  // dir from web app root
    }
    
   

	
	
}
