package com.xiaoshabao.example.module.base.thread.warexample;

/**
 * 军队线程类<br/>
 * 模拟作战双方的行为
 */
public class ArmyRunnable implements Runnable{

	//volatile保证了线程可以正确读取其他线程写入的值
	volatile boolean keepRunning=true;

	@Override
	public void run() {
		while(keepRunning){
			//发动5连击
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
				
				//通过这个方法，让出了处理器时间。所有进程重新争夺cpu，下次谁进攻不一定
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"结束战斗！");
	}
	

}
