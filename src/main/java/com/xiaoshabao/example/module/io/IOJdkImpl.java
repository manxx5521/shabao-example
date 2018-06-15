package com.xiaoshabao.example.module.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 * JDK实现方式
 */
public class IOJdkImpl implements IOInterface {

	@Override
	public void toInputStrean() {
	}

	// 理论上就是先生成文件
	@Override
	public void toInputStreanByPath(String path) {
		try (InputStream inputStrean = new FileInputStream(path)) {
			// 此处获得输入流

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void toInputStrean(File file) {
		try (InputStream inputStrean = new FileInputStream(file)) {
			// 此处获得输入流

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void toInputStreanByString(String content) {

		new ByteArrayInputStream(content.getBytes());

	}

	@Test
	@Override
	public void writeInputStreamToFile() {
		//源输入流
		InputStream in= getInputStream();
		//目标路径
		String dist="E:\\test\\new.ftl";
		
		int index;  
	    byte[] bytes = new byte[1024];  
	    try(InputStream input=in;
	    	FileOutputStream out = new FileOutputStream(dist);	) {
		    while ((index = input.read(bytes)) != -1) {  
		    	out.write(bytes, 0, index);  
		    	out.flush();  
		    }  
	    } catch (IOException e) {
			e.printStackTrace();
		}
	    
	}

	private InputStream getInputStream() {
		return this.getClass().getResourceAsStream("/templates/demo.ftl");
	}
}
