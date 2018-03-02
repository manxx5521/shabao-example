package com.xiaoshabao.example.module.base.map;
/*
每个学生都有对应的归属地。
学生Student，地址String
学生属性：姓名，年龄
注意：姓名和年龄都相同的视为同一个学生
保证学生的唯一性。
1 描述学生
2 定义map容器，将学生作为键，地址作为值存入
3 获取map集合的元素
*/

//处理元素被存入二叉树时的情况
//实现Comparable，覆盖compareTo方法。
public class Student {
	private String name;
	private int age;
	Student(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public int compareTo(Student s)
	{
		int num=new Integer(this.age).compareTo(new Integer(s.age));
		if(num==0)
			return this.name.compareTo(s.name);
		return num;
			
	}
	//元素若被存入哈希表结构，要保证元素唯一性，
	//就要覆盖两个方法hashCode和equals
	public int hashCode()
	{
		return name.hashCode()+age*34;
	}
	public boolean equals(Object obj)
	{
		//扔进去的不是学生时，比较无意义
		//于是直接抛异常
		if(!(obj instanceof Student))
			throw new ClassCastException("类型不匹配");
		Student s=(Student)obj;
		return this.name.equals(s.name)&& this.age==s.age;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String toString()
	{
		return name+":"+age;
	}

}
