package com.xiaoshabao.example.module.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 通过Comparable实现compareTo方法对类排序<br>
 * compareTo 返回
 * 大于0的数（1），说明当前类在比较类的后边
 * 小于0的数（-1），说明当前类在比较类的前边
 * （大于或小于多少没有本质区别，返回1和返回100一样）
 */
//要排序的类实现Comparable接口，然后重写compareTo()方法
public class CompareToSimple implements Comparable<CompareToSimple>{
	private String name;
    private int age;

    public CompareToSimple() {
    }
    public CompareToSimple(String name, int age) {
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
    
    /**
     * 排序方法
     */
    @Override
    public int compareTo(CompareToSimple o) {
        // 先按age排序
    	
    	//如果当前类的age大于比较的age   12>5
        if (this.age > o.getAge()) {
        	//返回15-5=10，返回一个大于0的数。说明这个类的字典顺序在传入的后边
            return (this.age - o.getAge());
        }
        //如果当前类的age小于比较的age 6<11
        if (this.age < o.getAge()) {
        	//返回6-11=-5，返回一个小于0的数。说明这个类的字典顺序在传入的前边
            return (this.age - o.getAge());
        }
        
        // 如果两个类的年龄一样，按name排序
        /*this.name.compareTo(o.getName())这个已经实现了字符串的字典排序
        	其实直接输出大小就可以。输出1和-1也可以 */
        if (this.name.compareTo(o.getName()) > 0) {
            return 1;
        }
        if (this.name.compareTo(o.getName()) < 0) {
            return -1;
        }
        
        //说明属性一样
        return 0;
    }
    
    public static void main(String[] args) {

    	CompareToSimple f1 = new CompareToSimple("atony", 11);
    	CompareToSimple f2 = new CompareToSimple("jack", 11);
    	CompareToSimple f3 = new CompareToSimple("tom", 11);
    	CompareToSimple f4 = new CompareToSimple("jason", 44);

        List<CompareToSimple> list = new ArrayList<CompareToSimple>();
        list.add(f1);
        list.add(f3);
        list.add(f4);
        list.add(f2);
        
        //实现列表的字典排序
        Collections.sort(list);

        for (CompareToSimple o : list) {
            System.out.println(o.getAge() + "-->" + o.getName());
        }
    }
}
