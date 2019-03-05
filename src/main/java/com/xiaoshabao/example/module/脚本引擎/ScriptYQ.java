package com.xiaoshabao.example.module.脚本引擎;

public interface ScriptYQ {
	
	/**
	 * 计算 1000+100.0*99-(600-3*15)%(((68-9)-3)*2-100)+10000%7*71
	 */
	public void test_jisan1();
	
	/**
	 * 传递参数  a=1,b=2,c=3 表达式 a+b*c
	 */
	public void test_jisan2();
	
	/**
	 * 访问java变量
	 */
	public void test_jisan3();
	
	/**
	 * 使用js或多行函数
	 */
	public void test_zdyhs1();
	
	/**
	 * 使用自定义函数
	 */
	public void test_zdyhs2();

}
