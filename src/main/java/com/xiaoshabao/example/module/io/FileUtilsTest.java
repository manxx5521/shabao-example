package com.xiaoshabao.example.module.io;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 文件操作类<br>
 * 通过common的io包进行对文件的操作
 */
public class FileUtilsTest {

	private String basePath = null;

	@Before
	public void setUp() {
		// basePath = System.getProperty("user.dir") +
		// File.separator+"file"+File.separator;
		basePath = "D:\\test\\";
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 拷贝文件(内容)<br/>
	 * 将srcFile下的文件内容拷贝到destFile文件内
	 * 
	 * @throws IOException
	 */
	@Test
	public void testCopy() throws IOException {
		File srcFile = new File(basePath + "a.txt");
		File destFile = new File(basePath + "b.txt");
		FileUtils.copyFile(srcFile, destFile);
	}

	/**
	 * 删除文件
	 * 
	 * @throws IOException
	 */
	@Test
	public void testDelete() throws IOException {
		File delFile = new File(basePath + "b.txt");
		FileUtils.forceDelete(delFile);
		// FileUtils.forceMkdir(delFile);
	}

	/**
	 * 比较文件内容
	 * 
	 * @throws IOException
	 */
	@Test
	public void testCompareFile() throws IOException {
		File srcFile = new File(basePath + "a.txt");
		File destFile = new File(basePath + "b.txt");
		boolean result = FileUtils.contentEquals(srcFile, destFile);
		System.out.println(result);
	}

	/**
	 * 移动文件
	 * 
	 * @throws IOException
	 */
	@Test
	public void testMoveFile() throws IOException {
		File srcFile = new File(basePath + "b.txt");
		File destDir = new File(basePath + "move");
		FileUtils.moveToDirectory(srcFile, destDir, true);
	}

	/**
	 * 读取文件内容<br/>
	 * 分为读成列表和读成String
	 * 
	 * @throws IOException
	 */
	@Test
	public void testRead() throws IOException {
		File srcFile = new File(basePath + "a.txt");
//		FileUtils.readFileToByteArray(file)
		String content = FileUtils.readFileToString(srcFile,"UTF-8");
		List<String> contents = FileUtils.readLines(srcFile,"UTF-8");
		System.out.println(content);
		System.out.println("******************");
		for (String string : contents) {
			System.out.println(string);
		}
	}

	/**
	 * 读取文件使用迭代器
	 * 
	 * @throws IOException
	 */
	@Test
	public void testIterator() throws IOException {
		File file = new File(basePath + "a.txt");
		LineIterator li = FileUtils.lineIterator(file);
		while (li.hasNext()) {
			System.out.println(li.nextLine());
		}
	}

	/**
	 * 写入文件内容
	 * 
	 * @throws IOException
	 */
	@Test
	public void testWrite() throws IOException {
		File srcFile = new File(basePath + "a.txt");
		FileUtils.writeStringToFile(srcFile, "\nyes文件", CharsetNames.UTF_8);
	}

}
