package com.knits.tms.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.knits.tms.service"})
@EnableJpaRepositories(basePackages = "com.knits.tms.dao")
@EntityScan( basePackages = {"com.knits.tms.model"} )
public class TmsCoreContext {

}
