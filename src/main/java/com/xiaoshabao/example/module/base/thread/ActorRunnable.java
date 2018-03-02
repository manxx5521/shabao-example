package com.xiaoshabao.example.module.base.thread;

/**
 * 演员类<br/>
 * 通过实现Runnable接口来得到进程
 */
public class ActorRunnable implements Runnable {

	@Override
	public void run() {
		// getName获得的是Thread的静态方法获得当前线程，再获得名字
		System.out.println(Thread.currentThread().getName() + "是一个演员");

		// 用来记录演出次数
		int count = 0;
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println(Thread.currentThread().getName() + "登台演出：" + (++count));
			if (count == 100) {
				keepRunning = false;
			}

			// 没当是10的倍数
			if (count % 10 == 0) {
				try {
					// 睡眠1秒
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println(Thread.currentThread().getName() + "的演出结束");

	}

}
