package com.xiaoshabao.example.module.base.factory.simpleFactory;
/*
 * 多种登录方式如：口令认证、域认证（口令认证通常是去数据库中验证用户，
 * 而域认证则是需要到微软的域中验证用户）。
 * 那么自然的做法就是建立一个各种登录方式都适用的接口
 */
public interface Login {
	//登录验证方法
	public boolean verify(String name , String password);
}
