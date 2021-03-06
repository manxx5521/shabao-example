package com.xiaoshabao.example.module.base.排序;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 使用比较器类排序
 *
 */
public class ComparatorSort {
	protected static List<Persion> list = new ArrayList<>();

	static {
		list.add(new Persion("李四", 15));
		list.add(new Persion("张三", 11));
		list.add(new Persion("王二", 21));
	}
	
	@Test
	public void test() {
		
		list.sort((o1,o2)->o1.getAge()>o2.getAge()?1:o1.getAge()<o2.getAge()?-1:0);
		
		list.forEach(o1->System.out.println(o1.getName()));
		
	}
	
	
	

}

class Persion {
	private String name;
	private int age;

	public Persion(String name, int age) {
		this.name = name;
		this.age = age;
	}

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

