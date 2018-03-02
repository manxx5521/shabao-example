package com.xiaoshabao.example.module.base.classnew;
/**
 * 变量创建，实例1
 */
/*
 *3、父类进行初始化，本次初始化触发new、getstatic、putstatic、或者invokestatic 这4条字节码。
 *	初始化的时候会先整理静态变量，将静态变量创建到堆里。此时会输出static Insect.x1 initialized。如果有static{} 也会执行。
 *	3步执行静态变量的初始化时，会按先后顺序创建
 *	初始化的时候不执行构造方法，构造方法在实例话的时候执行
 */
public class Insect {
	private int i = 9;
	protected int j;
	protected static int x1 = printInit("static Insect.x1 initialized");
	
	static{
		System.out.println("222");
	}
	
	/*
	 * 6、执行父类构造
	 */
	Insect() {
		System.out.println("基类构造函数阶段： i = " + i + ", j = " + j);
		j = 39;
	}

	static int printInit(String s) {
		System.out.println(s);
		return 47;
	}
}
