package com.xiaoshabao.example.module.base.thread;

public class Test {
	public static void main(String[] args) {
		// 线程1-->使用actorThread创建一个进程  
		Thread actorthread = new ActorThread();
		actorthread.setName("Mr Thread");
		actorthread.start();

		// 线程2-->ActorRunnable需要时使用Thread的构造方法来创建进程
		Thread actorRunnable = new Thread(new ActorRunnable(),"Ms Runnable");
		actorRunnable.start();
		
		/*
		 * 当系统实现以上两个进程时，
		 * 以上代码在线程1执行start后，无需等待，线程ActorThread的run()方法执行，直接后进行线程2的创建。
		 * 但是，两个线程都启动后，因为是线程1先start()所以cpu会先执行1线程(每一个cpu核心只能处理一个线程)
		 * 只有当线程1执行到sleep时，cpu才会有空间，然后开始执行线程2。当线程sleep后，系统会重新查看是否有需要执行的线程
		 */
	}
}
