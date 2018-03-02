package com.xiaoshabao.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//开启缓存注解
@EnableCaching 
@MapperScan(basePackages="com.xiaoshabao.**.mapper")
public class ApplicationExample {

	public static void main(String[] args) {

		SpringApplication.run(ApplicationExample.class, args);

	}

}
