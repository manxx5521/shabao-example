package com.xiaoshabao.example.module.base.模式设计.装饰模式;

/**
 * 具体被装饰的对象类1
 */
public class CoffeeBean1 implements Beverage {
	private String description = "选了第一种咖啡豆";

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double getPrice() {
		return 50;
	}

}
