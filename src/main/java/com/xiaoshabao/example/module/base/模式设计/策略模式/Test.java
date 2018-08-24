package com.xiaoshabao.example.module.base.模式设计.策略模式;

public class Test {
	
	public static void main(String[] args) {
		//选择策略
		Strategy strategy=new ConcreteStrategyA();
		
		///创建环境
		Context context=new Context(strategy);
		
		//使用实际业务
		context.contextInterface();
	}

}
