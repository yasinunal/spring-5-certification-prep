package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db.properties")
public class AppConfig {
 
	@Bean
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		return ds;
	}
	
	@Bean
	public TestDBPostProcessor testDBPostProcessor() {
		
		return new TestDBPostProcessor();
	}
	
	@Bean
	public TestBeanPostProcessor testBeanPostProcessor() {
		return new TestBeanPostProcessor();
	}
}
