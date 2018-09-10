package com.xiaoshabao.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.xiaoshabao.base.mybatis.BaseMybatisApplicaiton;

@SpringBootApplication
//开启缓存注解
@EnableCaching 
//@MapperScan(basePackages="com.xiaoshabao.**.mapper")
public class ApplicationExample extends BaseMybatisApplicaiton{

	public static void main(String[] args) {

		SpringApplication.run(ApplicationExample.class, args);

	}

}
