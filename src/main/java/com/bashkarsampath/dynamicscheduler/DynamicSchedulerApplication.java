package com.bashkarsampath.dynamicscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = "com.bashkarsampath.dynamicscheduler.*")
@EnableTransactionManagement
public class DynamicSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicSchedulerApplication.class, args);
	}

}
