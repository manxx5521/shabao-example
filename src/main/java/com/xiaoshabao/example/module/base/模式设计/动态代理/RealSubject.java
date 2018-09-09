package com.xiaoshabao.example.module.base.模式设计.动态代理;

/**
 * 实现类
 */
public class RealSubject implements Subject {
	@Override
	public void rent() {
		System.out.println("I want to rent my house");
	}

	@Override
	public void hello(String str) {
		System.out.println("hello: " + str);
	}
}
