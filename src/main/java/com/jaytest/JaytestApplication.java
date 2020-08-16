package com.jaytest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mapper
//@MapperScan("com.jaytest.mapper")
public class JaytestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaytestApplication.class, args);
	}

}
