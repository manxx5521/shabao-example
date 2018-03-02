package com.xiaoshabao.example.module.base.classnew;

/**
 * 体验内部类和变量的创建顺序
 */
public class Base {
	private String name = "hello";
	
	//4、父类的构造方法
	public Base() {
		callName();  //5、执行这个callName方法
	}
	
	//6、应该执行这个输出，但是因为子类重写了这个方法，所以会调用子类的方法
	public void callName() {
		System.out.println(name);
	}
	
	//1、先执行这个主方法,主方法为静态方法，会先静态变量的初始化，但是没有静态变量所以什么都不做
	public static void main(String[] args) {
		new Sub();   //2、创建子类对象
	}
}

//3、创建子类时，先调用父类构方法，再调用子类构造方法。
class Sub extends Base {
	private String name = "world";
	
	
	//7、调用这个输出，但是由于是父类构造中调用的，还没有经过子类的构造方法，所以子类中的name还是null。所以输出的时候会输出null
	public void callName() {
		System.out.println(name);
	}
}
