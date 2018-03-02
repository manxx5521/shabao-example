package com.xiaoshabao.example.module.base.abstractpAndExtends;

public class TestAbstract {
	
	public static void main(String[] args){
		//People people=new People();抽象类无法实例化
		
		//直接创建子类
		MenPeople men=new MenPeople();
		men.sex();
		
		//使用父类代理子类
		People people=new MenPeople();
		people.sex();
	}

}
