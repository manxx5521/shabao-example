package com.xiaoshabao.example.module.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 *	下边的注解可以为单独的类
 */
public class targetExample {
	
	
	/*
	 * 作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
	取值(ElementType)有：

　　　　1.CONSTRUCTOR:用于描述构造器
　　　　2.FIELD:用于描述域
　　　　3.LOCAL_VARIABLE:用于描述局部变量
　　　　4.METHOD:用于描述方法
　　　　5.PACKAGE:用于描述包
　　　　6.PARAMETER:用于描述参数
　　　　7.TYPE:用于描述类、接口(包括注解类型) 或enum声明
	 */
	@Target(ElementType.TYPE)
	public @interface Table {
	    /**
	     * 数据表名称注解，默认值为类名称
	     * @return
	     */
	    public String tableName() default "className";
	}

	@Target(ElementType.FIELD)
	public @interface NoDBColumn {

	}
	
	//注解Table 可以用于注解类、接口(包括注解类型) 或enum声明,而注解NoDBColumn仅可用于注解类的成员变量。

}
