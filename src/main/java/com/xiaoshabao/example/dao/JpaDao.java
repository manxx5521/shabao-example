/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package com.xiaoshabao.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xiaoshabao.example.entity.DemoEntity;

/**
 * jpaDao
 */
public interface JpaDao extends JpaRepository<DemoEntity, Long>, JpaSpecificationExecutor<DemoEntity> {
	
}
