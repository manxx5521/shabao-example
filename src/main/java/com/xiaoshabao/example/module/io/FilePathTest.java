package com.xiaoshabao.example.module.io;

import java.io.File;

import org.junit.jupiter.api.Test;

public class FilePathTest {

	public final static String FILE_NAME = "fileTestTxt.txt";

	/**
	 * 当前项目根目录（编译后实际位置）
	 */
	@Test
	public void test_CurrentPathFile() {
		String path = FilePathTest.class.getClass().getResource("/").getPath();
		System.out.println(path);//输出 /E:/workss/shabao/shabao-example/target/test-classes/
	}
	/**
	 * 当前目录下的文件路径
	 */
	@Test
	public void test_当前目录下的文件路径() {
		String path=this.getClass().getResource(FILE_NAME).getPath();
		System.out.println(path);
	}
	
	/**
	 * 工程目录
	 */
	@Test
	public void test_userDir() {
		String path= System.getProperty("user.dir");
		System.out.println(path);//输出 E:\workss\shabao\shabao-example
	}

	/**
	 * windows的分隔符
	 * <p>
	 * 对于windows来说，/和\\都能识别
	 * <p>
	 */
	@Test
	public void winPathSp() {
		String path = "D:\\workspaces\\test\\src\\test\\file\\";
		// String path="D:/workspaces/test/src/test/file/";

		File file = new File(path + FILE_NAME);
		if (!file.exists()) {
			throw new RuntimeException("文件读取异常");
		}

	}
	
	/**
	 * 获得当前classPath目录下的文件
	 */
	@Test
	public void test_classpath() {
		this.getClass().getResourceAsStream("/templates/demo.ftlh");
//		FileUtils.copyInputStreamToFile(source, destination);
	}
	@Test
	public void test() {
		File file=new File("E:\\test");
		System.out.println("11->"+file.isAbsolute());
		System.out.println("22是否是文件夹->"+file.isDirectory());
	}


}
