package com.xiaoshabao.example.module.base.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class DocumentedExample {
	
	/*
	 *Documented用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化。
	 *Documented是一个标记注解，没有成员。 
	 * */
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	public @interface Column {
	    public String name() default "fieldName";
	    public String setFuncName() default "setField";
	    public String getFuncName() default "getField"; 
	    public boolean defaultDBValue() default false;
	}
}
