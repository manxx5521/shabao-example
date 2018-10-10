package com.xiaoshabao.example.module.base.数据源.简易实现;

/**
 * <p>Title      : 利用内部类单例模式解决多线程问题</p>
 * <p>Description: [子应用名]_[模块名]</p>
 */
public class PoolManager {
	
	private static class creatPool{
		private static MyPoolImpl poolImpl = new MyPoolImpl();
	}
	
	//多个线程在加载内部类的时候线程是互斥的，所以用单例模式的内部类形式避免线程混乱
	public static MyPoolImpl getInstace(){
		return creatPool.poolImpl;
	}
 
}
