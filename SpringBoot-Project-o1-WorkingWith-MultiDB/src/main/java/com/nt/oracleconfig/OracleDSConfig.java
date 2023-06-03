package com.nt.oracleconfig;





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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.nt.model.repo.product", 
                       entityManagerFactoryRef ="oracleEntityManagerFactoryBean",
                       transactionManagerRef ="oracleTxnm" )
@EnableTransactionManagement
public class OracleDSConfig {
	//for oracle data base configuration
	@Bean(name = "oracleds")
	@Primary
	//configuration with properties file
	@ConfigurationProperties(prefix = "oracle.datasource")
	 DataSource createOracleDs() {
		return DataSourceBuilder.create().build();
	}//end of createOracleDs()
	
	//configure LocalContainerEntityManagerFactoryBean
	@Bean(name = "oracleEntityManagerFactoryBean")
	@Primary
	LocalContainerEntityManagerFactoryBean 
	createLCEMFB(EntityManagerFactoryBuilder builder) {
		//create map object having hibernate properties
		Map<String,Object> pros = new HashMap<>();
				pros.put("hibernate.dilect", "org.hiernate.dialect.Oracle10gDialect");
		pros.put("hibernate.hbm2ddl.auto", "update");
		return builder.dataSource(createOracleDs())
				.packages("com.nt.model.product")
				.properties(pros).build();
	}//createLCEMFB
	
	//configure for TranxactionManager
	@Bean(name = "oracleTxnm")
	@Primary
	PlatformTransactionManager createOraclePTM(@Qualifier("oracleEntityManagerFactoryBean")
	                            EntityManagerFactory factory) {
		return new JpaTransactionManager();
	}
	
}
