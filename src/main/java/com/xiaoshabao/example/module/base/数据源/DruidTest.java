package com.xiaoshabao.example.module.base.数据源;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.alibaba.druid.pool.DruidDataSource;

public class DruidTest {

	@Test
	public void test() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (// 1,创建Druid连接池对象
				DruidDataSource dataSource = new DruidDataSource();){
			
			// 2,为数据库添加配置文件
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/first?useUnicode=true&characterEncoding=utf8");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			// 用Druid来连接
			conn = dataSource.getConnection();
			// 2,执行数据库语句
			String sql = "SELECT * FROM user";
			// 3,用prepareStatement获取sql语句
			ps = conn.prepareStatement(sql);
			// 4,执行sql语句,查询用executeQuery,增删改用executeUpdate
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("loginname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
