package com.xiaoshabao.example.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import springfox.documentation.annotations.ApiIgnore;

/**
 * 模仿登录
 */
@RestController
@RequestMapping("/security")
public class LoginController extends BaseController{
	
	
	@GetMapping("/login")
	public ModelAndView getList(@ApiIgnore() ModelMap model) {
		return new ModelAndView("security/login", model);
	}
}
