package com.xing.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.xing.mp.mapper")
public class SpringBootMpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMpApplication.class, args);
	}
}
