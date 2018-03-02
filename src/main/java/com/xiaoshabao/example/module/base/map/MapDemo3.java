package com.xiaoshabao.example.module.base.map;

import java.util.*;

public class MapDemo3 {
	public static void main(String[] args) 
	{
		Map<String,String> map=new HashMap<String,String>();
		//添加元素
		map.put("04","zhangsan4");
		map.put("02","zhangsan2");
		map.put("01","zhangsan1");
		map.put("03","zhangsan3");
		//取出映射关系，存入Set集合
		Set<Map.Entry<String,String>> entrySet=map.entrySet();
		//迭代器获取映射关系
		Iterator<Map.Entry<String,String>> it=entrySet.iterator();
		while (it.hasNext())
		{
			//Map.Entry中存的是映射关系
			Map.Entry<String,String> me=it.next();
			//获取键和值
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key+":"+value);
		}	
	}

}
