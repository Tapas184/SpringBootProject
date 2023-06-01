package com.nt.mysqlconfig;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.nt.model.repo.offers", 
                       entityManagerFactoryRef ="mysqlEntityManagerFactoryBean",
                       transactionManagerRef ="mysqlTxnm" )
@EnableTransactionManagement
public class MysqlDSConfig {
	//for oracle data base configuration
	@Bean(name = "mysqlds")

	//configuration with properties file
	@ConfigurationProperties(prefix = "mysql.datasource")
	 DataSource createMysqlDs() {
		return DataSourceBuilder
				.create()
				.build();
	}//end of createOracleDs()
	
	//configure LocalContainerEntityManagerFactoryBean
	@Bean(name = "mysqlEntityManagerFactoryBean")
	
	LocalContainerEntityManagerFactoryBean 
	createLCEMFB(EntityManagerFactoryBuilder builder) {
		//create map object having hibernate properties
		Map<String,Object> pros = new HashMap();
				pros.put("hibernate.dilect", "org.hibernate.dialect.MYSQL8Dialect");
		        pros.put("hibernate.hbm2ddl.auto", "update");
		return builder.dataSource(createMysqlDs())
				.packages("com.nt.model.offers")
				.properties(pros)
				.build();
	}//createLCEMFB
	
	//configure for TranxactionManager
	@Bean(name = "mysqlTxnm")
	PlatformTransactionManager createmysqlPTM(@Qualifier("mysqlEntityManagerFactoryBean")
	                            EntityManagerFactory factory) {
		return new JpaTransactionManager();
	}
	
}
