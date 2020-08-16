package com.jaytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication

// 允许使用定时器
@EnableScheduling
public class JaytestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaytestApplication.class, args);
	}

}
