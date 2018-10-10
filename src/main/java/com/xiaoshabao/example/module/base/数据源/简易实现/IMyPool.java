package com.xiaoshabao.example.module.base.数据源.简易实现;


/**
 * <p>Description: 连接池接口</p>
 */
public interface IMyPool {
	
	/**
	 * <p>创建连接</p>
	 */
	public void createConnection(int count);
	
	/**
	 * <p>获取连接</p>
	 */
	public PooledConnection getConnection();
 
}

