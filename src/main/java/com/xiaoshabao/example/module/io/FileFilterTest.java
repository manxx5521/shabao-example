package com.xiaoshabao.example.module.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 文件过滤类<br/>
 * 根据一定条件，过滤指定目录下的文件
 */
public class FileFilterTest {

	private String basePath = null;

	@Before
	public void setUp() throws Exception {
//		basePath = System.getProperty("user.dir") + "\\file\\";
		basePath = "D:\\test\\";
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 空内容文件过滤器<br>
	 * 读取指定文件夹下的非空文件和文件夹
	 * @throws IOException
	 */
	@Test
	public void testEmptyFileFilter() throws IOException {
		File dir = new File(basePath);
		String[] files = dir.list(EmptyFileFilter.NOT_EMPTY);
		for (String file : files) {
			System.out.println(file);
		}
	}

	/**
	 * 文件名称后缀过滤器
	 * 
	 * @throws IOException
	 */
	@Test
	public void testSuffixFileFilter() throws IOException {
		File dir = new File(basePath);
		String[] files = dir.list(new SuffixFileFilter("txt"));
		for (String file : files) {
			System.out.println(file);
		}
	}
	@Test
	public void test1(){
		/*File srcFile = */new File("C:\\Users\\mxv\\Desktop\\Chromestable_52.0.2743.82.exe");
	}

}