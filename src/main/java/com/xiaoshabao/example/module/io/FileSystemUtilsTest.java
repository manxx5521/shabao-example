package com.xiaoshabao.example.module.io;
import java.io.IOException;

import org.apache.commons.io.FileSystemUtils;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 对文件系统的相关操作
 */
@SuppressWarnings("deprecation")
public class FileSystemUtilsTest {
	@BeforeAll
	public void setUp() throws Exception {
	}

	@AfterAll
	public void tearDown() throws Exception {
	}

	/**
	 * 获取磁盘空余空间
	 * @throws IOException
	 */
	@Test
	public void testFreeSpace() throws IOException {
		// 以字节为单位
		System.out.println(FileSystemUtils.freeSpace("c:\\") / 1024 / 1024 / 1024);
		System.out.println(FileSystemUtils.freeSpace("d:\\") / 1024 / 1024 / 1024);
		// 以k为单位
		System.out.println(FileSystemUtils.freeSpaceKb("e:\\") / 1024 / 1024);
		System.out.println(FileSystemUtils.freeSpaceKb("f:\\") / 1024 / 1024);
		
	}

}
