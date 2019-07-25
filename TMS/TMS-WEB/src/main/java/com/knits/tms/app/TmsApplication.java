package com.knits.tms.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.knits.tms.config.TmsCoreContext;
import com.knits.tms.web.config.TmsWebContext;


@SpringBootApplication
@Import(value = {TmsWebContext.class, TmsCoreContext.class})
public class TmsApplication {

	public static void main(String[] args) {
		 SpringApplication.run(TmsApplication.class, args);
	}

}
