package com.xiaoshabao.example.custom.security;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 我们将确保`WebSecurityConfig`在我们现有的ApplicationInitializer中加载
 */
@Order(2)
public class MessageSecurityWebApplicationInitializer extends
		AbstractSecurityWebApplicationInitializer {
}