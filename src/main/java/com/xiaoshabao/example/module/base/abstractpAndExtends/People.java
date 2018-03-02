package com.xiaoshabao.example.module.base.abstractpAndExtends;

/**
 * 抽象类可以实现接口，并且不需要实现所有方法。
 * 继承这个类的子类，也相当于实现了这个接口。 但是子类也可以实现这个接口。可以同时实现
 */
public abstract class People implements WorkInterface{
	private String name;
	private int age;
	/**
	 * 普通方法
	 */
	public void say(){
		System.out.println("谁都会说话");
	}
	
	/**
	 * 不能重写的方法
	 */
	public final void big(){
		System.out.println("只能有固定的年龄");
	}
	
	/**
	 * 抽象方法，需要每一类人都要有实现性别方法
	 */
	public abstract void sex();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
