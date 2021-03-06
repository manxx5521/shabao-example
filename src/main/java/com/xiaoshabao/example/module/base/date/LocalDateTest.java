package com.xiaoshabao.example.module.base.date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import org.junit.jupiter.api.Test;

public class LocalDateTest {
	
	@Test
	public void testLocalDate(){
		// 取当前日期：2018-04-08
		LocalDate today = LocalDate.now();
		System.out.println("取当前日期："+today);
		
		// 根据年月日取日期，12月就是12：
		LocalDate crischristmas = LocalDate.of(2014, 12, 25);
		System.out.println("构造日期："+crischristmas);
		
		// 根据字符串取：yyyy-MM-dd方式，解析一个有效日期，
		// 如果是无效日期比如2014-02-29报错DateTimeParseException: Invalid date
		LocalDate endOfFeb = LocalDate.parse("2014-02-28"); 
		System.out.println("字符串构造日期："+endOfFeb);
		
		// 取本月第1天：
		today.with(TemporalAdjusters.firstDayOfMonth());
		// 取本月第2天：
		today.withDayOfMonth(2); // 2014-12-02
		// 取本月最后一天，再也不用计算是28，29，30还是31：
		today.with(TemporalAdjusters.lastDayOfMonth()); // 2014-12-31
		// 取下一天：
		today.plusDays(1);
		// 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
		LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2015-01-05
		
	}
	
	@Test
	public void testLocalTime(){
		//取时间 11:09:09.240
		LocalTime now = LocalTime.now(); // 
		System.out.println("当前时间："+now);

		//清除毫秒数：11:09:09
		LocalTime now2 = LocalTime.now().withNano(0); 
		System.out.println("当前时间(去除毫秒)："+now2);
		
		//构造时间：00:00:00
		LocalTime.of(0, 0, 0); 
		//字符串构造12:00:00
		LocalTime.parse("12:00:00");
	}
	@Test
	public void testLocalDateTime(){
		//取时间 2018-04-08T10:28:01.076
		LocalDateTime now = LocalDateTime.now();
		System.out.println("当前时间："+now);
		
		//格式化指定日期：2018-04-08 10:33:09
		String formatDate=now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println("输出格式化日期："+formatDate);
		
		System.out.println("添加了5分钟："+now.plusSeconds(5*60).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		
		//计算过去了 多少秒
		Instant.now().toEpochMilli();
		Instant.now().getEpochSecond();
		
		
	}

}
