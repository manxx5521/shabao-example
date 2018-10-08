package com.xiaoshabao.example.module.spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringStartTest {
	
	@Test
	public void test() {
		try {
			@SuppressWarnings("resource")
			BeanFactory beanFactory=new FileSystemXmlApplicationContext(new String[]{"src\\main\\java\\com\\xiaoshabao\\example\\module\\spring\\applicationContext-test.xml"});

		    SpringTestBean bean= beanFactory.getBean("springTestBean",SpringTestBean.class);
		    
		    System.out.println(bean.getName());
		} catch (Exception e) {
			e.printStackTrace();
			assert false;
		}

	    
	}

}
