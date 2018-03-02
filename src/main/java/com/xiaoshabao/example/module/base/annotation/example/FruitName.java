package com.xiaoshabao.example.module.base.annotation.example;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 水果名称注解
 */
@Target(ElementType.FIELD)  //描述域
@Retention(RetentionPolicy.RUNTIME)  //运行时有效
@Documented		//可以被文档化
public @interface FruitName {
    String value() default "";
}
