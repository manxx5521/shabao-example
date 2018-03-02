package com.xiaoshabao.example.module.base.thread.warexample;

/**
 * 舞台类
 */
public class StageThread extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("欢迎观看隋唐演绎");

			Thread.sleep(5000);

			// 隋朝军队
			ArmyRunnable armyTasksui = new ArmyRunnable();
			// 起义军队
			ArmyRunnable armyTaskfan = new ArmyRunnable();

			// 使用runnable接口创建军队进程
			Thread armysui = new Thread(armyTasksui, "隋军");
			Thread armyfan = new Thread(armyTaskfan, "起义军");

			// 启动进程，让军队开始作战
			armysui.start();
			armyfan.start();

			// 舞台线程休眠，专心看军队厮杀
			Thread.sleep(50);

			// 调用一个线程的join方法，结束进程
//			armyfan.join();

			System.out.println("双方激战正酣，半路杀出个程咬金");

			Thread cheng = new KeyPersonThread();
			cheng.setName("程咬金");
			System.out.println("程咬金的报复是，结束战争");

			// 让军队停止厮杀，停止线程
			armyTasksui.keepRunning = false;
			armyTaskfan.keepRunning = false;
			Thread.sleep(2000);

			// 舞台给关键任务
			cheng.start();

			// 登台程咬金完成线程
			cheng.join();

			System.out.println("结束战争，百姓安居乐业");
			System.out.println("谢谢观看");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new StageThread().start();
	}

}
