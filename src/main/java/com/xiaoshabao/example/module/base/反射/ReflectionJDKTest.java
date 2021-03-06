package com.xiaoshabao.example.module.base.反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ReflectionJDKTest {

	@Test
	public void test() {
		try {
			// 加载
			Class<?> clazz = Class.forName("com.xiaoshabao.example.module.base.反射.Student");
			// 实例
			Object obj = clazz.newInstance();

			//执行的方法
			Method method = clazz.getDeclaredMethod("say",List.class);

			List<String> param=new ArrayList<String>();
			param.add("这是一句话");
			method.invoke(obj,param);// 父类的bMethod调用父类的getObjectName()

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
