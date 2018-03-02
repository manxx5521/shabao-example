package com.xiaoshabao.example.module.base;

import org.junit.Test;

/**
 * 静态方法测试类
 */
public class StaticTest {
	
	
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
	}

}
