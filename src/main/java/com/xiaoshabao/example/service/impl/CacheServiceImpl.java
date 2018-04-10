package com.xiaoshabao.example.service.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xiaoshabao.example.entity.DemoEntity;
import com.xiaoshabao.example.service.CacheService;
@CacheConfig(cacheNames="baseCache")
@Service
public class CacheServiceImpl implements CacheService {
	
	private static DemoEntity person=new DemoEntity(1,"王二");
	
	@Override
	@CachePut(key="#entity.id")
	public DemoEntity update(DemoEntity entity) {
		return entity;
	}

	@Override
	@Cacheable
	public DemoEntity getDemoEntity(Integer id) {
		return person;
	}

	@Override
	@CacheEvict
	public int delete(Integer id) {
		return 0;
	}

}
