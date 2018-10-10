package com.xiaoshabao.example.module.base.数据源.简易实现;

import java.sql.ResultSet;
import java.sql.SQLException;
 
/**
 * <p>Description: 测试类</p>
 */
public class TestPool {
	
	/**
	 * 获取连接池容器实现类
	 */
	private static MyPoolImpl poolImpl = PoolManager.getInstace();
	
	/**
	 * 单个连接查询测试
	 */
	public synchronized static void selectData(){
		PooledConnection connection = poolImpl.getConnection();
		ResultSet rs = connection.queryBySql("select * from class");
		try {
			while(rs.next()){
				System.out.print(rs.getString("ID") + "\t\t");
				System.out.print(rs.getString("NAME") + "\t\t");
				System.out.print(rs.getString("TEACHER") + "\t\t");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			connection.close();
		}
	}
	
	/**
	 * <p>Discription:测试2000个线程</p>
	 * @param args
	 */
	public static void main(String[] args){
		for (int i = 0; i < 2000; i++) {
			new Thread(new Runnable() {
				public void run() {
					selectData();
					System.out.println();
				}
			}).start();
		}
		
	}
}
