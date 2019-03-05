package com.xiaoshabao.example.module.脚本引擎;

import org.junit.Test;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.xiaoshabao.example.entity.test.PersionBean;
/**
 * https://github.com/alibaba/QLExpress
 * 阿里巴巴开源的脚本引擎
 */
public class QLExpressTest implements ScriptYQ{

	@Override
	@Test
	public void test_jisan1() {
		ExpressRunner runner = new ExpressRunner();
		DefaultContext<String, Object> context = new DefaultContext<String, Object>();
		try {
			Object result = runner.execute("1000+100.0*99-(600-3*15)%(((68-9)-3)*2-100)+10000%7*71", context, null, true, false);
			System.out.println(result);//11181.0
		} catch (Exception e) {
			e.printStackTrace();
		}    
        
	}
	/*
	 * 传递参数  a=1,b=2,c=3 表达式 a+b*c
	 */
	@Override
	@Test
	public void test_jisan2() {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a",1);
        context.put("b",2);
        context.put("c",3);
        String express = "a+b*c";
        Object r;
		try {
			r = runner.execute(express, context, null, true, false);
			System.out.println(r);//7
		} catch (Exception e) {
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
		
		
		ExpressRunner runner = new ExpressRunner();
		DefaultContext<String, Object> context = new DefaultContext<String, Object>();
		context.put("foo", foo);
		try {
			Object result = runner.execute("foo.name+'今年'+foo.age+'岁,明年'+(foo.age+1)+'岁'", context, null, true, false);
			System.out.println(result);/// 张三今年16岁,明年17岁
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	
	/*
	 * 使用js脚本或者多行命令
	 */
	@Override
	@Test
	public void test_zdyhs1() {
		ExpressRunner runner = new ExpressRunner();
		DefaultContext<String, Object> context = new DefaultContext<String, Object>();
		
		try {//是以一种类js形式实现
			String exp="function add(int a, int b){"
					+" int n=a;"
					+"  return  n+b;"
					+ "};"
					+ "return  add(1,2)";
			Object result = runner.execute(exp, context, null, false, false);
			System.out.println(result);// 3
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/*
	 * 使用自定义函数
	 */
	@Override
	@Test
	public void test_zdyhs2() {
		ExpressRunner runner = new ExpressRunner();
		DefaultContext<String, Object> context = new DefaultContext<String, Object>();
		
		try {
			runner.addFunctionOfClassMethod("add", QLExpressTest.class.getName(),
					"call", new String[] { "Integer", "Integer"}, null);
			Object result = runner.execute("add(1,2)", context, null, false, false);
			System.out.println(result);// 3
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static Integer call(Integer a,Integer b) {
    	return Integer.valueOf(a.toString())+Integer.valueOf(b.toString());
    }

}

