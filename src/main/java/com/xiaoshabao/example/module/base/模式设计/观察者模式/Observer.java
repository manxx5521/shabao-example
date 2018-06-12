package com.xiaoshabao.example.module.base.模式设计.观察者模式;
/**
 * 一个观察者
 */
public abstract class Observer {
	
	protected Subject subject;

	public abstract void update();
}
