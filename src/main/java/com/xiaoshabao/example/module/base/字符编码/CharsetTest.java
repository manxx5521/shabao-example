package com.xiaoshabao.example.module.base.字符编码;

import org.junit.jupiter.api.Test;

public class CharsetTest {

	/**
	 * 统计汉字
	 */
	@Test
	public void countFont() {
		String str="我是1个人。";
		char[] arrays=str.toCharArray();
		int count = 0;
		String regex="[\\u4E00-\\u9FA5]|[0-9]+";
		for (int i = 0; i <arrays.length ; i++) {
			if (Character.toString(arrays[i]).matches(regex)) {
				count++;
			}
		}
		
		System.out.println("总计字数："+count);

	}

}
