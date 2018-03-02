package com.xiaoshabao.example.module.base.abstractpAndExtends;

public class MenPeople extends People implements WorkInterface{
	
	@SuppressWarnings("unused")
	private String name="能重写父类属性值";
	
	@Override
	public void sex() {
		System.out.println("男人们");
	}

	@Override
	public void work() {
		System.out.println("都要工作呀");
	}

}
