package com.xiaoshabao.example.module.base;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


/**
 * 循环的使用，锚的使用
 */
public class ForTest {
	
	/**
	 * 演示锚点的使用
	 */
	@Test
	public void mao() {
		ma: for (int i = 1; i < 8; i++) {
			System.out.println("i:" + i);
			mb: for (int j = 9; j < 12; j++) {
				System.out.println("j:" + j);
				
				if (j == 10) {
					System.out.println("跳出本次循环:" + j);
					continue;
				}
				if (i == 4) {
					System.out.println("跳出j循环:" + j);
					break mb;
				}

				if (i == 6) {
					System.out.println("跳出i循环:" + j);
					break ma;
				}
				System.out.println("操作j循环:" + j);
			}
			System.out.println("操作i循环:" + i);
		}
		System.out.println("所有操作完成");
	}
	
	
	
	/**
	 * 循环内创建类的不同方式测试（test2写法更好）
	 */
	@Test
	public void test1() {
		List<PersionBean> list=new ArrayList<PersionBean>();
		for(int i=0,size=100000;i<size;i++) {
			PersionBean bean=new PersionBean();
			bean.setAge(i);
			bean.setName("我是"+i);
			list.add(bean);
		}
		System.out.println("测试完成");
		
	}
	
	@Test
	public void test2() {
		List<PersionBean> list=new ArrayList<PersionBean>();
		PersionBean bean=null;
		for(int i=0,size=100000;i<size;i++) {
			bean=new PersionBean();
			bean.setAge(i);
			bean.setName("我是"+i);
			list.add(bean);
		}
		System.out.println("测试完成");
		
	}
	

	
	
	
	
	class PersionBean {
		private String name = "张三";
		private int age = 10;
		
		private List<PersionBean> guanxi=new ArrayList<PersionBean>(30);

		@Override
		public String toString() {
			return "名字:" + name + "--年龄:" + age+";关系："+guanxi.size();
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


}
