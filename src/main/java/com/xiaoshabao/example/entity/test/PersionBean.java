package com.xiaoshabao.example.entity.test;

public class PersionBean {
	private String name = "张三";
	private int age = 10;
	
	public PersionBean() {
	}
	public PersionBean(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "名字:" + name + "--年龄:" + age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// @JSONField(name="csage") //这个注解可以在转换时输出成指定的csage 列明
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
