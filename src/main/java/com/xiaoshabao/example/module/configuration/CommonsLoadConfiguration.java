package com.xiaoshabao.example.module.configuration;

import java.io.File;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Test;
/**
 * commons读取配置文件
 * <p>包括读取properties、xml、ini等文件类型</p>
 */
public class CommonsLoadConfiguration {
	
	/**
	 * 读取配置文件方法
	 */
	@Test
	public void load() throws Exception {
		/*读取配置文件可以使用以下配置类
		properties文件--PropertiesConfiguration类
		xml文件--XMLConfiguration
		.ini文件--INIConfiguration
		.plist文件--PropertyListConfiguration
		还可以从JNDI中读取properties--JNDIConfiguration
		当然还可以使用system的properties--SystemConfiguration
		*/
		File file=new File( System.getProperty("user.dir")+"\\src\\main\\java\\com\\xiaoshabao\\example\\module\\configuration\\test.properties");
		// 注意路径默认指向的是classpath的根目录
//		Configuration config = new PropertiesConfiguration("test.properties");
		Configuration config = new PropertiesConfiguration(file);
		String ip = config.getString("ip");
		int port = config.getInt("port");
		String title = config.getString("application.title");
		// 再举个Configuration的比较实用的方法吧,在读取配置文件的时候有可能这个键值对应的值为空，那么在下面这个方法中
		// 你就可以为它设置默认值。比如下面这个例子就会在test.properties这个文件中找id的值，如果找不到就会给id设置值为123
		// 这样就保证了java的包装类不会返回空值。虽然功能很简单，但是很方便很实用。
		Integer id = config.getInteger("id", new Integer(123));
		// 如果在properties 文件中有如下属性keys=cn,com,org,uk,edu,jp,hk
		// 可以实用下面的方式读取：
		String[] keys1 = config.getStringArray("keys");
		
		@SuppressWarnings("rawtypes")
		List keys2 = config.getList("keys");
		
		System.out.println("属性读取："+ip+"\n"+port+"\n"+title+"\n"+id+"\n"+keys1+"\n"+keys2);
	}

}
