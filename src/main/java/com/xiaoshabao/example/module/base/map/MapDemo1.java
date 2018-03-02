package com.xiaoshabao.example.module.base.map;

import java.util.*;

public class MapDemo1 {
	public static void main(String[] args) 
	{
		Map<String,String> map=new HashMap<String,String>();
		//添加元素
		map.put("01","zhangsan1");
		map.put("02","zhangsan2");
		//添加的键重复时，键对应的新值覆盖旧值，put方法返回旧值
		System.out.println("put"+map.put("03","zhangsan3"));
		System.out.println("put"+map.put("03","wangwu"));
		//判断是否含有05键
		System.out.println("containsKey:"+map.containsKey("05"));
		/*也可通过get方法的返回值来判断一个键是否存在
		存在会获取具体值，不存在就返回null。
		HashMap支持null,Hashtable不支持null。
		*/
		map.put("04",null);
		System.out.println("get:"+map.get("023"));
		//删除02键并返回其对应的值
		System.out.println("remove:"+map.remove("02"));
		//获取map集合中所有的值。
		Collection<String> coll=map.values();
		System.out.println(coll);
		System.out.println(map);
	}

}
