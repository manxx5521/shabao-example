package com.xiaoshabao.example.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RenMingBiUtilTest {
	private static RenMingBiUtil bean = new RenMingBiUtil();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(bean.transComb(103.10));
	}

}
