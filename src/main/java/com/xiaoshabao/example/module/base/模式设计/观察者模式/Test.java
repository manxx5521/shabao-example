package com.xiaoshabao.example.module.base.模式设计.观察者模式;

public class Test {
	public static void main(String[] args) {
		Subject subject = new Subject();
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		subject.setState(15);
		System.out.println("Second state change: 10");
		subject.setState(10);
	}
}
