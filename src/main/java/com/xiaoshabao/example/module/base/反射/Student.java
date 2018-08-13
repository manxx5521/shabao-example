package com.xiaoshabao.example.module.base.反射;

import java.util.List;

public class Student {

	public boolean say(List<String> data) {
		data.forEach(h->{
			System.out.println(h);
		});
		return true;
	}
}
