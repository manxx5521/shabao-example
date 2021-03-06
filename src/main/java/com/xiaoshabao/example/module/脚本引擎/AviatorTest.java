package com.xiaoshabao.example.module.脚本引擎;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.xiaoshabao.example.entity.test.PersionBean;
/**
 * 
 * https://github.com/killme2008/aviator/wiki
 * https://github.com/killme2008/aviator
 * 
 * 备选https://blog.csdn.net/wyzdeng/article/details/78953516
 *
 */
public class AviatorTest implements ScriptYQ{

	@Override
	@Test
	public void test_jisan1() {
		Double result = (Double) AviatorEvaluator.execute("1000+100.0*99-(600-3*15)%(((68-9)-3)*2-100)+10000%7*71");
        System.out.println(result);//11181.0
	}
	/*
	 * 传递参数  a=1,b=2,c=3 表达式 a+b*c
	 */
	@Override
	@Test
	public void test_jisan2() {
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("a", 1);
        env.put("b", 2);
        env.put("c", 3);
        Long result = (Long) AviatorEvaluator.execute("a+b*c", env);
        System.out.println(result);  // 7		
	}
	/*
	 * 访问java变量
	 */
	@Override
	@Test
	public void test_jisan3() {
		PersionBean foo = new PersionBean("张三",16);
		Map<String, Object> env = new HashMap<String, Object>();
		env.put("foo", foo);
		System.out.println(AviatorEvaluator.execute("foo.name+'今年'+foo.age+'岁,明年'+(foo.age+1)+'岁'", env)); // 张三今年16岁,明年17岁
	}
	/*
	 * 使用多行命令或js函数（暂未发现）
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
		//注册函数
        AviatorEvaluator.addFunction(new AddFunction());
        System.out.println(AviatorEvaluator.execute("add(1, 2)"));           // 3.0
        System.out.println(AviatorEvaluator.execute("add(add(1, 2), 100)")); // 103.0
	}
	
	class AddFunction extends AbstractFunction {
	    @Override
	    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
	        Number left = FunctionUtils.getNumberValue(arg1, env);
	        Number right = FunctionUtils.getNumberValue(arg2, env);
	        return new AviatorDouble(left.doubleValue() + right.doubleValue());
	    }
	    public String getName() {
	        return "add";
	    }
	}

	
	
	

}
