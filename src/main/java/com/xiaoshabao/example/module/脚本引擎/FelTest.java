package com.xiaoshabao.example.module.脚本引擎;

import org.junit.jupiter.api.Test;

import com.greenpineyu.fel.Expression;
import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.CommonFunction;
import com.greenpineyu.fel.function.Function;
import com.xiaoshabao.example.entity.test.PersionBean;
/**
 * https://blog.csdn.net/chichengjunma/article/details/56012272
 *
 */
public class FelTest implements ScriptYQ{

	@Override
	@Test
	public void test_jisan1() {
		FelEngine fel = new FelEngineImpl();    
		Object result = fel.eval("1000+100.0*99-(600-3*15)%(((68-9)-3)*2-100)+10000%7*71");    
        System.out.println(result);//11181.0
	}
	/*
	 * 传递参数  a=1,b=2,c=3 表达式 a+b*c
	 */
	@Override
	@Test
	public void test_jisan2() {
		FelEngine fel = new FelEngineImpl();
		FelContext ctx = fel.getContext();    
		ctx.set("a", 1);    
		ctx.set("b", 2);    
		ctx.set("c", 3);    
		Object result = fel.eval("a+b*c");    
        System.out.println(result);  // 7		
	}
	/*
	 * 访问java变量
	 */
	@Override
	@Test
	public void test_jisan3() {
		PersionBean foo = new PersionBean("张三", 16);

		FelEngine fel = new FelEngineImpl();
		FelContext ctx = fel.getContext();
		ctx.set("foo", foo);

		Object result = fel.eval("foo.name+'今年'+foo.age+'岁,明年'+(foo.age+1)+'岁'");
		System.out.println(result); // 张三今年16岁,明年17岁
	}
	/*
	 * 使用js脚本或多行命令
	 */
	@Override
	@Test
	public void test_zdyhs1() {
		
	}
	/*
	 * 使用自定义函数
	 */
	@Override
	@Test
	public void test_zdyhs2() {
		// 定义hello函数
		Function fun = new CommonFunction() {

			public String getName() {
				return "add";
			}

			@Override
			public Integer call(Object[] arguments) {
				return Integer.valueOf(arguments[0].toString())+Integer.valueOf(arguments[1].toString());
			}

		};
		FelEngine e = new FelEngineImpl();
		// 添加函数到引擎中。
		e.addFun(fun);
		String exp = "add(1, 2)";
		// 解释执行
		Object eval = e.eval(exp);
		System.out.println(eval);//3
		// 编译执行
		Expression compile = e.compile(exp, null);
		eval = compile.eval(null);
		System.out.println(eval);
	}

	
	
	

}
