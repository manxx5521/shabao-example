package com.xiaoshabao.example.module.base.classnew;

import org.junit.Test;

/**
 * static静态块测试
 * <p>由此看出static只进行一次初始化</p>
 */
public class  StaticExample{
	
	static{
		System.out.println("static块，初始化一次");
	}
	
	@Override
	public String toString(){
		return null;
	}
	
	@Test
	public void testRun(){
		for(int i=0;i<10;i++){
			StaticExample a =new StaticExample();
			a.toString();
		}
	}

}
