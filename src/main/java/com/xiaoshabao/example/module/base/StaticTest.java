package com.xiaoshabao.example.module.base;

import org.junit.Test;

/**
 * 静态方法测试类
 */
public class StaticTest {
	
	static {
		System.out.println("静态块初始化");
	}
	
	/*修饰变量*/
	public static int count=0;
	
	/*修饰内部类，修饰后可以不创建外部类直接使用*/
	public static class Type{
		public static final String HTTP="POST";
	}
	
	/**
	 * 测试静态方法里的内容读取几回
	 * <p><p>
	 */
	public static void testStatic(){
		System.out.println("hello");
	}
	
	@Test
	public void testS(){
		StaticTest.testStatic();
		
		//直接使用static声明的内部类
		new StaticTest.Type();//创建
		System.out.println(StaticTest.Type.HTTP);
	}

}


