package com.xiaoshabao.example.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoshabao.example.entity.DemoEntity;
import com.xiaoshabao.example.service.CacheService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 缓存使用
 *<p>缓存使用的是代理模式，类内互相调用不走缓存，并且返回值要实现序列化接口	</p>
 */
@Api(value = "缓存使用", tags = { "缓存使用" })
@RestController
@RequestMapping(value = "/cache")
public class CacheController extends BaseController{
	@Autowired
	private CacheService cacheService;

	// 缓存管理
	@Autowired
	private CacheManager cacheManager;

	@ApiOperation(value = "获取值", notes = "获取本地缓存")
	@GetMapping("/get")
	public DemoEntity getDemoEntity() {
		return cacheService.getDemoEntity(1);
	}
	
	@ApiOperation(value = "删除缓存", notes = "删除缓存")
	@GetMapping("/delete")
	public Integer delete() {
		return cacheService.delete(1);
	}
	@ApiOperation(value = "更新缓存", notes = "更新缓存")
	@GetMapping("/update")
	public DemoEntity update() {
		return cacheService.update(new DemoEntity(1,"张三"));
	}
	

	
	@ApiOperation(value = "清空所有缓存", notes = "去除缓存名字baseCache")
	@RequestMapping(value = "/clear", method = RequestMethod.GET)
	public boolean clearCache() {
		cacheManager.getCache("baseCache").clear();
		return true;
	}
	
	//redis使用
	
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
	
	@ApiOperation(value = "Redis设置缓存", notes = "Redis设置缓存")
	@GetMapping("/setRedis")
	public String setRedis() {
		String result="测试数据";
		stringRedisTemplate.opsForValue().set("cachetest1-key", result, 10, TimeUnit.SECONDS);
		return result;
	}
	
	@ApiOperation(value = "Redis获取缓存", notes = "Redis获取缓存")
	@GetMapping("/deleteRedis")
	public String deleteRedis() {
		String result=stringRedisTemplate.opsForValue().get("cachetest1-key");
		return result;
	}
}
