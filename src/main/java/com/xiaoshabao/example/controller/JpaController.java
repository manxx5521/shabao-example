package com.xiaoshabao.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * jpa的使用
 * <p>
 * orm框架，数据处理
 * </p>
 */
@Api(value = "jpa的使用", tags = { "jpa的使用" })
@RestController
@RequestMapping(value = "/jpa")
public class JpaController extends BaseController {

}
