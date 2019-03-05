package com.xiaoshabao.example.module.脚本引擎;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

import com.xiaoshabao.example.entity.test.PersionBean;

/**
 * jdk8自带的脚本引擎
 * https://www.cnblogs.com/top8/p/6207945.html
 */
public class NashornTest  implements ScriptYQ{
	@Override
	@Test
	public void test_jisan1() {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			Object result=engine.eval("1000+100.0*99-(600-3*15)%(((68-9)-3)*2-100)+10000%7*71"); 
			System.out.println(result);//11181.0
		} catch (ScriptException e) {
		}
		
        
	}
	/*
	 * 传递参数  a=1,b=2,c=3 表达式 a+b*c
	 */
	@Override
	@Test
	public void test_jisan2() {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			engine.eval(" var fun1=function(a,b,c){return a+b*c}");
			Invocable invocable = (Invocable) engine;

			Object result = invocable.invokeFunction("fun1", 1,2,3);
			System.out.println(result);
			System.out.println(result.getClass());//7.0
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 访问java变量
	 */
	@Override
	@Test
	public void test_jisan3() {
		PersionBean foo = new PersionBean("张三", 16);
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			engine.eval(" var fun1=function(foo){return foo.name+'今年'+foo.age+'岁,明年'+(foo.age+1)+'岁'}");
			Invocable invocable = (Invocable) engine;

			Object result = invocable.invokeFunction("fun1",foo);
			System.out.println(result);//张三今年16岁,明年17岁
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 使用js函数或者多行命令
	 */
	@Override
	@Test
	public void test_zdyhs1() {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			String exp="var add=function(a,b){"
					+" var n=a;"
					+" return n+b"
					+ "}";
			engine.eval(exp);
			Invocable invocable = (Invocable) engine;

			Object result = invocable.invokeFunction("add", 1,2);
			System.out.println(result);//3.0
		} catch (Exception e) {
		}
	}
	
	/*
	 * 使用自定义函数,可以通过调用java静态方法的形式实现
	 */
	@Override
	@Test
	public void test_zdyhs2() {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			engine.eval(" var add=function(a,b){return a+b}");
			Invocable invocable = (Invocable) engine;

			Object result = invocable.invokeFunction("add", 1,2);
			System.out.println(result);//7.0
		} catch (Exception e) {
		}
	}
	
	public static Integer CommonFunction(Object a,Object b) {
		return Integer.valueOf(a.toString())+Integer.valueOf(b.toString());
	};


}
