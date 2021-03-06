package com.xiaoshabao.example.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DateUtilTest {
	private static DateUtil bean = new DateUtil();

	@BeforeAll
	public void setUp() throws Exception {
	}

	@Test
	public void testGetYear() {
		bean.getYear();

		// 期待的结果,一样通过
		assertEquals("2015", bean.getYear());
	}

	@Test
	public void testGetDateNumber() {
		bean.getDateNumber();
	}

	@Test
	public void testGetDate() {
		bean.getDate();
	}

}
