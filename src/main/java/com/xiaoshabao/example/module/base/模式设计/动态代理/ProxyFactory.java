package com.xiaoshabao.example.module.base.模式设计.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

/**
 * 第二种方式，直接通过匿名类 完成动态代理的创建
 *
 */
public class ProxyFactory {
	// 维护一个目标对象
	private Object target;

	public ProxyFactory(Object target) {
		this.target = target;
	}

	// 给目标对象生成代理对象
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						System.out.println("开始事务2");
						// 执行目标对象方法
						Object returnValue = method.invoke(target, args);
						System.out.println("提交事务2");
						return returnValue;
					}
				});
	}
}
