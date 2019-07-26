package com.knits.tms.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
@PropertySource("classpath:database-int-test.properties")
@EnableAutoConfiguration
public class AppConfigIntegrationTestEnv {

	/*
	private final String URL = "url";
	private final String USER = "dbuser";
	private final String DRIVER = "driver";
	private final String PASSWORD = "dbpassword";
	private final String HIBERNATE_DIALECT = "dialect";
	private final String HIBERNATE_DDL = "hibernate.ddl";
	private final String HIBERNATE_SHOW_SQL = "hibernate.showsql";

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(env.getProperty(URL));
		driverManagerDataSource.setUsername(env.getProperty(USER));
		driverManagerDataSource.setPassword(env.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(env.getProperty(DRIVER));
		return driverManagerDataSource;
	}

	 @Bean
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em= new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan(new String[] { "com.knits.tms.model" });
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(hibernateProperties());
	 
	      return em;
	   }
	
	@Bean
    public PlatformTransactionManager hibernateTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
 
    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(org.hibernate.cfg.Environment.DIALECT, env.getProperty(HIBERNATE_DIALECT));
        hibernateProperties.setProperty(org.hibernate.cfg.Environment.HBM2DDL_AUTO,env.getProperty(HIBERNATE_DDL));//"hibernate.hbm2ddl.auto"
        hibernateProperties.setProperty(org.hibernate.cfg.Environment.SHOW_SQL,env.getProperty(HIBERNATE_SHOW_SQL));
        hibernateProperties.setProperty(org.hibernate.cfg.Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
        return hibernateProperties;
    }
    */
}
