package com.xiaoshabao.example.module.base.接口.able;

public interface interfaceAble {
	/**
	 * 添加public修饰符，所有范围可以调用
	 */
	public void interface1();
	/**
	 * 不加修饰符，所有范围可以调用
	 */
	void interface2();
	
	
	/**
	 * 1.8以后接口，可以有默认实现
	 */
	default void interface3(){
		System.out.println("接口默认实现");
	}
	
	

}
