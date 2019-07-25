package com.knits.tms.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

//@Configuration
//@EnableTransactionManagement
//@ComponentScan({"com.knits.tms.service,com.knits.tms.dao","com.knits.tms.service", "com.knits.tms.util", "com.knits.tms.beans"})
//@PropertySource("classpath:database.properties")
public class AppConfig {

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
		  HikariDataSource ds = new HikariDataSource();
	      ds.setMaximumPoolSize(100);
	      ds.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
	      ds.addDataSourceProperty("url", env.getProperty(URL));
	      ds.addDataSourceProperty("user",  env.getProperty(USER));
	      ds.addDataSourceProperty("password", env.getProperty(PASSWORD));
	      ds.addDataSourceProperty("cachePrepStmts", true);
	      ds.addDataSourceProperty("prepStmtCacheSize", 250);
	      ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
	      ds.addDataSourceProperty("useServerPrepStmts", true);
	      return ds;	 
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
}
