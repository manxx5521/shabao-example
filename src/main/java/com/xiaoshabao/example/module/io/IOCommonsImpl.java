package com.xiaoshabao.example.module.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

/**
 * 辅助包实现方式
 */
public class IOCommonsImpl implements IOInterface {
	/*
	 * 将文件读取成 字符串
	 */
	@Override
	public void test_readTxtToString() {
		
	}
	@Override
	public void toInputStrean() {
		// TODO Auto-generated method stub
	}

	@Override
	public void toInputStreanByPath(String path) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toInputStrean(File file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toInputStreanByString(String content) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeInputStreamToFile() {
		// 源输入流
		InputStream in = getInputStream();
		// 目标路径
		String dist = "E:\\test\\new.ftl";

		try {
			FileUtils.copyInputStreamToFile(in, new File(dist));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private InputStream getInputStream() {
		return this.getClass().getResourceAsStream("/templates/demo.ftl");
	}

}
