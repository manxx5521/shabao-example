package com.xiaoshabao.example.module.base.接口;

import org.junit.jupiter.api.Test;

import com.xiaoshabao.example.module.base.接口.able.interfaceAble;

public class interfaceTest {
	
	@Test
	public void test(){
		interfaceAble able=new interfaceAble(){
			@Override
			public void interface1() {
			}
			@Override
			public void interface2() {
			}
		};
		
		
		//接口无需添加修饰符号，默认public final
		able.interface1();
		able.interface2();
		
		//接口可以添加默认实现
		able.interface3();
		
	}

}
