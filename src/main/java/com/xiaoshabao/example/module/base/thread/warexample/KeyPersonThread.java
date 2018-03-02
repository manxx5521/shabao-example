package com.xiaoshabao.example.module.base.thread.warexample;

/**
 * 关键任务进程
 * <p>关键人物出场后、其他任务要停止攻击</p>
 */
public class KeyPersonThread extends Thread {

	@Override
	public void run() {
		System.out.println(getName()+"开始战斗了！");
		for(int i=0;i<10;i++){
			System.out.println(getName()+"左突右杀，攻击隋军...");
		}
		System.out.println(getName()+"结束战斗！");
	}
	
	

}
