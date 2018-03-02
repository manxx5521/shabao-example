package com.xiaoshabao.example.module.base.map;

import java.util.*;

public class MapDemo {
	public static void main(String[] args) 
	{
		HashMap<Student,String> h=new HashMap<Student,String>();
		//添加元素。学生是键，归属地为值
		h.put(new Student("zhangsan1",21),"beijing");
		h.put(new Student("zhangsan2",30),"hefei");
		h.put(new Student("zhangsan2",30),"nanjing");
		h.put(new Student("zhangsan3",27),"guangzhou");
		h.put(new Student("zhangsan4",25),"qingdao");
		//第一种取出方式 keySet
		//keySet()获取map集合的所有键，存入Set集合
		Set<Student> keySet=h.keySet();
		//有了Set集合,就可获取迭代器
		Iterator<Student> it=keySet.iterator();
		while(it.hasNext())
		{
			Student stu=it.next();
			//map集合的get方法获取键对应的值
			String adrs=h.get(stu);
			System.out.println(stu+":"+adrs);
		}
		//第二种取出方式 entrySet
		//取出映射关系，存入Set集合
		Set<Map.Entry<Student,String>> entrySet=h.entrySet();
		//迭代器获取映射关系
		Iterator<Map.Entry<Student,String>> it1=entrySet.iterator();
		while (it1.hasNext())
		{
			//Map.Entry中存的是映射关系
			Map.Entry<Student,String> me=it1.next();
			//获取键和值
			Student stu = me.getKey();
			String adrs = me.getValue();
			System.out.println(stu+"....."+adrs);
		}	

	}

}
