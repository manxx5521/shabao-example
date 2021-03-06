package com.xiaoshabao.example.module.configuration;

import java.io.InputStream;
import java.util.Properties;

import org.junit.jupiter.api.Test;

/**
 * 读取配置文件properties方法
 */
public class JdkLoadProperties {

	// startdate和totalweek是配置属性
	private static String startdate = null;
	private static String totalweek = null;
	static {
		loads();
	}

	synchronized static public void loads() {
		if (startdate == null || totalweek == null) {
			Properties dbProps = new Properties();
			try (InputStream is = JdkLoadProperties.class.getResourceAsStream("test.properties");) {
				dbProps.load(is);
				// 读取属性
				startdate = dbProps.getProperty("startdate");
				totalweek = dbProps.getProperty("totalweek");
			} catch (Exception e) {
				System.err.println("不能读取属性文件. " + "请确保db.properties在CLASSPATH指定的路径中"); 
				e.printStackTrace();
			}
		}
	}

	public static String getStartdate() {
		if (startdate == null)
			loads();
		return startdate;
	}

	public static String getTotalweek() {
		if (startdate == null)
			loads();
		return totalweek;
	}

	@Test
	public void test() {
		System.out.println("输出totalweek: " + JdkLoadProperties.getTotalweek());
	}

}
