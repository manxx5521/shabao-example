package com.xiaoshabao.example.module.base.数据源.简易实现;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 * <p>Title      : 存储连接池中对象属性</p>
 * <p>Description: [子应用名]_[模块名]</p>
 */
public class PooledConnection {
	
	/**
	 * 连接管道对象
	 */
	private Connection conn;
	
	/**
	 * 连接状态，true-繁忙，false-空闲
	 */
	private boolean isBusy = false;
	
	public PooledConnection(Connection conn, boolean isBusy){
		this.conn = conn;
		this.isBusy = isBusy;
	}
	
	public void close(){
		this.isBusy = false;
	}
 
	public Connection getConn() {
		return conn;
	}
 
	public void setConn(Connection conn) {
		this.conn = conn;
	}
 
	public boolean isBusy() {
		return isBusy;
	}
 
	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}
 
	/**
	 * <p>Discription:创建查询方法,用于测试使用</p>
	 * @param sql
	 */
	public ResultSet queryBySql(String sql){
		ResultSet rs = null;
		Statement sm = null;
		try {
			sm = conn.createStatement();
			rs = sm.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
}

