package com.xiaoshabao.example.util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RenMingBiUtilTest {
	private static RenMingBiUtil bean = new RenMingBiUtil();

	@BeforeAll
	public void setUp() throws Exception {
	}

	@AfterAll
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(bean.transComb(103.10));
	}

}
