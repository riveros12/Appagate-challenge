package com.appagate.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.appagate.controller",
		"com.appagate.business",
		"com.appagate.app",
		"com.appagate.domain.service",
		"com.appagate.domain.impl",
		"com.appagate.domain.exception"
})
public class AppagateChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppagateChallengeApplication.class, args);
	}

}
