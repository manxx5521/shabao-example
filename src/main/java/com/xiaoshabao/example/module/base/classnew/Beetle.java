package com.xiaoshabao.example.module.base.classnew;
/**
 * 变量创建，实例1。的子类
 */
/*
 * 4、初始化完父类，进行子类初始化。
 * 	初始化静态变量，输出static Beetle.x2 initialized。
 * 	3和4两步实在执行静态方法的时候触发的，不是Beetle b = new Beetle();触发，所以去掉这个创建也会触发
 */
public class Beetle extends Insect {
	protected int k = printInit("Beetle.k initialized");
	protected static int x2 = printInit("static Beetle.x2 initialized");
	
	/*
	 * 7、执行自己的构造方法。执行默认的Beetle();
	 * 	在堆上创建类实例对象，实例对象空间清零，创建非静态变量k,执行赋值语句k = printInit("Beetle.k initialized");
	 */
	
	
	/*
	 *1、执行住方法。main方法是static方法，
	 *	在执行类的static方法的时候，如果该类没有初始化，则要进行初始化。
	 *2、在子类初始化的时候，又有一个约束：虚拟机会保证在子类的static{}方法执行之前（没有static块会自动添加一个），
	 *	父类的static{}方法已经执行完毕。所以，在执行完解析之后，会先执行3父类的初始化
	 */
	public static void main(String[] args) {
		
		/*
		 * 5、实例化Beetle类
		 * 	子类构造时会自动调用父类构造
		 */
		@SuppressWarnings("unused")
		Beetle b = new Beetle();
		
	}
}
