package com.xiaoshabao.example.module.base.技巧;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class 链表转为逗号拼接 {
	/**
	 * 此为jdk8之后方式
	 */
	@Test
	public void test2() {
		List<String> names = Arrays.asList("Jack", "Jill", "Nate", "Kara", "Kim", "Jullie", "Paul", "Peter");
		
		String str=names.stream()
			    .filter(name -> name.length() == 4)
			    .collect(Collectors.joining(", "));
		 
		System.out.println(str);
	}
	 
	/**
	 * 此为jdk8之前拼接方式
	 */
	@Test
	public void test1() {
		List<String> names = Arrays.asList("Jack");
		
		List<String> subList = new ArrayList<>();
		for(String name : names) {
		  if(name.length() == 4)
		    subList.add(name);
		}
		 
		StringBuilder namesOfLength4 = new StringBuilder();
		for(int i = 0; i < subList.size() - 1; i++) {
		  namesOfLength4.append(subList.get(i));
		  namesOfLength4.append(", ");
		}
		        
		if(subList.size() > 0) {
			namesOfLength4.append(subList.get(subList.size() - 1));
		}
		 
		System.out.println(namesOfLength4);
	}

}
