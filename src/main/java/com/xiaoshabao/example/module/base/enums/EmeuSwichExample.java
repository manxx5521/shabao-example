package com.xiaoshabao.example.module.base.enums;

import org.junit.Test;

public class EmeuSwichExample {
	
	public enum DaoType {
		HIBERNATE("hibernate"), JDBC("jdbc"), MYBATIS("mybatis");

		private String jdbcType;

		// 构造函数，用来构造枚举类型，存储什么东西
		private DaoType(String type) {
			this.jdbcType = type;
		}

		public String toString() {
			return this.jdbcType;
		}

		public String getValue() {
			return this.jdbcType;
		}
	}
	
	//测试swich方法
	@Test
	public void testSwich(){
		DaoType type=DaoType.JDBC;
		String message=null;
		switch (type) {
		case JDBC:
			message=type.name();;
			break;
		case HIBERNATE:
			message="hibernate";
			break;
		default:
			message="not";
			break;
		}
		
		System.out.println(message);
		
	}

}
