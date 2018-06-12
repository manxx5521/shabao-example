package com.xiaoshabao.example.module.base.模式设计.单例;

/**
 * 双重校验锁实现的单例模式
 */
public class Singleton {

	private volatile static Singleton instance;

	private Singleton() {
		// 私有构造方法
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
