package com.yingchong.service.data_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients(basePackages = { "com.yingchong" })
@MapperScan("com.yingchong")
@ComponentScan("com.yingchong")
@EnableSwagger2
@ComponentScan("com.yingchong")
@ServletComponentScan(basePackages = {"com.yingchong"})
//@EnableRedisHttpSession
public class DataServiceApplication {
	//spring 启动application
	public static void main(String[] args) {
		SpringApplication.run(DataServiceApplication.class, args);
	}
}
