package com.xiaoshabao.example.service;

import com.xiaoshabao.example.entity.DemoEntity;

public interface CacheService {
	
	DemoEntity update(DemoEntity entity);
	
	DemoEntity getDemoEntity(Integer id);
	
	int delete(Integer id);
	

}
