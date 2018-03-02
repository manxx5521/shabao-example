package com.xiaoshabao.example.module.base.priorityqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * PriorityQueue的一种实现类
 */
public class PriorityBlockingQueueTask implements Runnable {

	// 存储任务的数字标识
	private int id;

	// 声明一个私有的、参数化为Event类的PriorityBlockingQueue类型的属性queue，用来存储任务产生的事件。
	private PriorityBlockingQueue<Event> queue;

	public PriorityBlockingQueueTask(int id, PriorityBlockingQueue<Event> queue) {
		this.id = id;
		this.queue = queue;
	}

	// 实现run()方法。它存储100个事件到队列，使用它们的ID来标识创建事件的任务，并给予不断增加的数作为优先级。使用add()方法添加事件到队列中。
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			Event event = new Event(id, i);
			queue.add(event);
		}

	}

}
