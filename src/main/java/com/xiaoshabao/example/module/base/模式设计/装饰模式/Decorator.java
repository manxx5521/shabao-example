package com.xiaoshabao.example.module.base.模式设计.装饰模式;

/**
 * 装饰类
 */
public class Decorator implements Beverage {
	private String description = "我只是装饰器，不知道具体的描述";
	@Override
	public String getDescription() {
		return description;
	}
	@Override
	public double getPrice() {
		return 0;		//价格由子类来决定
	}
 
}
