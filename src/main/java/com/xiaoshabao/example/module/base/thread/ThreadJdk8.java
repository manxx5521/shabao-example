package com.xiaoshabao.example.module.base.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

public class ThreadJdk8 {

	/**
	 * CompletableFuture 变量的创建 使用runAsync 创建不带返回值的参数
	 * 							，supplyAsync创建带返回值参数
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		//异步操作
		CompletableFuture<Integer> future = CompletableFuture
				.supplyAsync(() -> {
					//简单睡1s
					ThreadJdk8.sleep();
//					int a=1/0;
					return 100;
				});
		
		//如果有异常会走如下方法
		Future<Integer> re=future.exceptionally((e)->{
			System.out.println("执行异常方法");
			return 0;
		});
		System.out.println("结果（无异常正常返回，有异常返回异常结果）："+re.get());
		
		
		//执行完成时调用的方法v上次异步返回值，e异常信息
		Future<Integer> f = future.whenComplete((v, e) -> {
            System.out.println("完成调用（第一次调用）");
            System.out.println(v);
            System.out.println(e);
        });
		f.get();
		
		//接着第一个异步程序执行，执行本此异步调用
		CompletableFuture<String> fj =  future.thenApplyAsync(i -> i * 10).thenApply(i -> i.toString());
		System.out.println("二次异步调用结果"+fj.get()); 
		
		//主的应该最后执行，方便加载其他异步程序
		Integer result=future.get();
		System.out.println("执行结果："+result);

	}
	
	public static void sleep(){
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
