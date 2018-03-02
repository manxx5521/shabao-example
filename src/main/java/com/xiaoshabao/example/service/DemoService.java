package com.xiaoshabao.example.service;

import java.util.List;

import com.xiaoshabao.example.entity.DemoEntity;

public interface DemoService {
	
	/**
	 * 获得全部列表
	 * @return
	 */
	public List<DemoEntity> getDemoList();
	
	/**
	 * 添加
	 * @param demoEntity
	 * @return
	 */
	public boolean insert(DemoEntity demoEntity);

}
