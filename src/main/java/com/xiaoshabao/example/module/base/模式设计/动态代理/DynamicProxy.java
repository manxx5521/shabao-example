package com.xiaoshabao.example.module.base.模式设计.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现动态代理（必须实现InvocationHandler）
 * <p>动态代理可以实现类似aop的功能，可以在代理类执行方法之前或者之后做通用操作</p>
 */
public class DynamicProxy implements InvocationHandler {
	// 　这个就是我们要代理的真实对象
	private Object subject;

	// 构造方法，给我们要代理的真实对象赋初值
	public DynamicProxy(Object subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object object, Method method, Object[] args)
			throws Throwable {
		// 　　在代理真实对象前我们可以添加一些自己的操作
		System.out.println("before rent house");

		System.out.println("Method:" + method);

		// 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
		method.invoke(subject, args);

		// 　　在代理真实对象后我们也可以添加一些自己的操作
		System.out.println("after rent house");

		return null;
	}

}
