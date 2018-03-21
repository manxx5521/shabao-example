package com.xiaoshabao.example.module.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.comparator.CompositeFileComparator;
import org.apache.commons.io.comparator.DirectoryFileComparator;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.comparator.PathFileComparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 文件比较类<br/>
 * 比较名字，路径等
 */
public class ComparatorTest {

	private String basePath = null;

	@Before
	public void setUp() throws Exception {
		// basePath = System.getProperty("user.dir") + "\\file\\";
		basePath = "D:\\test\\";
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 文件名称比较器
	 * 
	 * @throws IOException
	 */
	@Test
	public void testNameFileComparator() throws IOException {
		File f1 = new File(basePath + "a.txt");
		File f2 = new File(basePath + "c.txt");
		int result = NameFileComparator.NAME_COMPARATOR.compare(f1, f2);
		System.out.println(result);
	}

	/**
	 * 文件路径比较器
	 * 
	 * @throws IOException
	 */
	@Test
	public void testPathFileComparator() throws IOException {
		File f1 = new File(basePath + "a.txt");
		File f2 = new File(basePath + "c.txt");
		int result = PathFileComparator.PATH_COMPARATOR.compare(f1, f2);
		System.out.println(result);
	}

	/**
	 * 组合比较器
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCompositeFileComparator() throws IOException {
		File dir = new File(basePath);
		File[] files = dir.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
		}
		CompositeFileComparator cfc = new CompositeFileComparator(
				DirectoryFileComparator.DIRECTORY_COMPARATOR,
				NameFileComparator.NAME_COMPARATOR);
		cfc.sort(files);
		System.out.println("*****after sort*****");
		for (File file : files) {
			System.out.println(file.getName());
		}
	}
}