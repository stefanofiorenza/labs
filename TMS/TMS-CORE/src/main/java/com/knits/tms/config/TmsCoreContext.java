package com.knits.tms.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.knits.tms.service,com.knits.tms.dao","com.knits.tms.service"})
@EntityScan( basePackages = {"com.knits.tms.model"} )
public class TmsCoreContext {

}
