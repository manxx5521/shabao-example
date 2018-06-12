package com.xiaoshabao.example.module.base.模式设计.工厂模式.methodFactory;

/**
 * 方法模式，比简单模式高级
 * 针对的是一个产品等级结构
 */
public class Test {
	
	/*
	 * 假设有个导出设计，需要导出pdf和html等不同类型的文件，
	 * 不管什么类型的文件都要满足是否根据财务需求进行格式化
	 */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String data = "";
        
        /*
         * 根据导出文件类型的不同（html和pdf），创建不同的工厂角色 
         */
        ExportFactory exportFactory = new ExportHtmlFactory();
        
        
        ExportFile ef = exportFactory.factory("financial");
        ef.export(data);
    }

}
