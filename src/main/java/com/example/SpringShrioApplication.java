package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringShrioApplication {

	protected static final Logger logger = LoggerFactory.getLogger(SpringShrioApplication.class);
	
	public static void main(String[] args) {
		logger.info("SpringBoot开始加载");
		SpringApplication.run(SpringShrioApplication.class, args);
		logger.info("SpringBoot加载完毕");
	}
}
