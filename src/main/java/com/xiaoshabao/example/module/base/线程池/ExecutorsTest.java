package com.xiaoshabao.example.module.base.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ExecutorsTest {
	
	private ExecutorService pool=Executors.newFixedThreadPool(10);
	
	@Test
	public void test01() {
		
		for(int i=0;i<10;i++) {
			int time=i*10;
			pool.execute(()->{
				try {
					TimeUnit.SECONDS.sleep(time);
					System.out.println("执行完成"+time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		
		pool.shutdown();
		
		//次检查之前要先shutdown
		while(true) {
			//关闭后所有任务都已完成,则返回true
			if(pool.isTerminated()) {
				break;
			}
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("程序结束");
		
	}

}
