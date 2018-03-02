package com.xiaoshabao.example.module.base.priorityqueue;

/**
 * 实现Event类，并指定它实现参数化为Event类的Comparable接口
 */
public class Event implements Comparable<Event> {

	// 声明一个私有的、int类型的属性thread，用来存储已创建事件的线程数。
	private int thread;
	// 声明一个私有的、int类型的属性priority，用来存储事件的优先级。
	private int priority;

	// 实现这个类的构造器，并初始化它的属性。
	public Event(int thread, int priority) {
		this.thread = thread;
		this.priority = priority;
	}

	/**
	 * 实现getPriority()方法，用来返回priority(优先级)属性的值
	 * 
	 * @return
	 */
	public int getPriority() {
		return priority;
	}

	// 实现getThread()方法，用来返回thread(线程数)属性的值
	public int getThread() {
		return thread;
	}

	/**
	 * 如果当前事件的优先级更大，则返回-1，如果这两个优先级相等，则返回0，如果当前事件的优先级更小，则返回1。注意，这与大多数Comparator.
	 * compareTo()的实现是相反的。
	 */
	@Override
	public int compareTo(Event e) {
		if (this.priority > e.getPriority()) {
			return -1;
		} else if (this.priority < e.getPriority()) {
			return 1;
		} else {
			return 0;
		}
	}

}
