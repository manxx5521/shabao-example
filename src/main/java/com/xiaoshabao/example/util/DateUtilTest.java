package com.xiaoshabao.example.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DateUtilTest {
	private static DateUtil bean = new DateUtil();

	@Before
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
