package com.wefed.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.wefed.mybatis.dao"})
public class Application {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
	}
}
