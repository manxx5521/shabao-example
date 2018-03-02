package com.xiaoshabao.example.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 时间工具类
 * @author mxv
 *
 */
public class DateUtil {
	/**
	 * 通过日历类获得年份
	 * */
	public String getYear(){
		//获得日历类
		Calendar cal = Calendar.getInstance();  
		//格式成年
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy");
		//转换成字符串
		String datetemp=dateformat.format(cal.getTime());
		return datetemp;
	}
	
	/**
	 * 返回时间的16位数
	 * @return
	 */
	public String getDateNumber(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//定义格式，不显示毫秒
		Timestamp now = new Timestamp(System.currentTimeMillis());//获取系统当前时间
		return df.format(now);
	}
	
	/**
	 * 返回当前时间的字符串
	 * @return
	 */
	public String getDate(){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");  //格式化日期   yyyy/MM/dd HH:mm:ss
		String currentTime=sdf.format(date);  //存到字符串
		return currentTime;
	}
	
	public static void main(String[] args) {
		DateUtil d=new DateUtil();
		System.out.println(d.getDate());

	}

}
