package com.xiaoshabao.example.module.base.map;

import java.util.*;

public class MapDemo2 {
	public static void main(String[] args) 
	{
		Map<String,String> map=new HashMap<String,String>();
		//添加元素
		map.put("04","zhangsan4");
		map.put("02","zhangsan2");
		map.put("01","zhangsan1");
		map.put("03","zhangsan3");
		//keySet()获取map集合的所有键，存入Set集合
		Set<String> keySet=map.keySet();
		//有了Set集合,就可获取迭代器
		Iterator<String> it=keySet.iterator();
		while(it.hasNext())
		{
			String key=it.next();
			//map集合的get方法获取键对应的值
			String value=map.get(key);
			System.out.println("key:"+key+",value:"+value);
		}
	}
}
