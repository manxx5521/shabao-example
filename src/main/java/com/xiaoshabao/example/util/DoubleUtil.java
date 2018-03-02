package com.xiaoshabao.example.util;

import java.text.DecimalFormat;

public class DoubleUtil {
	/**
	 * 将double转换成百分形式
	 * */
	public String doubleForB(Double num){
		DecimalFormat df=new DecimalFormat("###,##0.00");
		String st=df.format(num*100);
		if(num<0.0001)
			st="0"+st;
		return st+"%";
	}

	public static void main(String[] args) {
		DoubleUtil bean=new DoubleUtil();
		System.out.println(bean.doubleForB(1992554447777.00));
		DecimalFormat df=new DecimalFormat("###,##0.00");
		String st=df.format(1992554447777.00);
		System.out.println("cd:"+st);
	}

}
