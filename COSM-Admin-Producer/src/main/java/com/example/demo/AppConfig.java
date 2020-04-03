package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.config.AdminConfig;



@EnableAutoConfiguration
@Configuration
@PropertySource("classpath:database.properties")
@ComponentScan({"com.example"})
@Import({AdminConfig.class})
public class AppConfig {

	@Autowired
	Environment environment;

	private final String URL = "db.url";
	private final String USER = "db.username";
	private final String DRIVER = "db.driver-class-name";
	private final String PASSWORD = "db.password";

	@Bean
	@Autowired
	DataSource dataSource_mydb() {

		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(URL));
		driverManagerDataSource.setUsername(environment.getProperty(USER));
		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
		return driverManagerDataSource;
	}
	
    @Bean
@Autowired
@Qualifier("datasource_mydb")
public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    	
    return new JdbcTemplate(dataSource);
}

	
	
}
