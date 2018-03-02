package com.xiaoshabao.example.module.base.file;

import java.io.File;

import org.junit.Test;
/**
 * 文件常用方法
 */
public class FileTest {
	/**
	 * 父级目录
	 */
	@Test
	public void testParent(){
		String path = getClass().getResource("").toString();
		File file=new File(path+"img01.jpg");
		System.out.println("路径:"+file.getPath());
		System.out.print("父级:"+file.getParent());
	}

}
