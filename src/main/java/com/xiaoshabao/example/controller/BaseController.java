package com.xiaoshabao.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象Controller方法
 * <p>
 * 所有的Controller都要继承这个类
 * </p>
 */
public abstract class BaseController {
	
	public BaseController() {
		// 统一添加日志
		logger = LoggerFactory.getLogger(getClass());
	}

	protected Logger logger;
}