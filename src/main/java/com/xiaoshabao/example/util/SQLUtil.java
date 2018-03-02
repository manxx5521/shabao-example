package com.xiaoshabao.example.util;

public class SQLUtil {
	/**
	 * 输出虚拟列--用于报表画界面
	 * @param size SQL虚拟列大小
	 * @return String SQL字符串
	 * */
	public static String printSql(Integer size){
		String str="SELECT ";
		for(int i=0;i<size;i++){
			int temp=i+1;
			if(temp!=size){
				str=str+temp+" n"+temp+",";
			}else{
				str=str+temp+" n"+temp;
			}
		}
		str=str+" FROM DUAL";
		return str;
	}
	public static void main(String[] args) {
		System.out.print(SQLUtil.printSql(17));
	}

}
