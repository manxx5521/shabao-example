package com.xiaoshabao.example.module.base.annotation;

import java.lang.annotation.Inherited;

public class InheritedExample {
	//@Inherited 元注解是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。
	
	@Inherited
	public @interface Greeting {
	    public enum FontColor{ BULE,RED,GREEN};
	    String name();
	    FontColor fontColor() default FontColor.GREEN;
	}

}
