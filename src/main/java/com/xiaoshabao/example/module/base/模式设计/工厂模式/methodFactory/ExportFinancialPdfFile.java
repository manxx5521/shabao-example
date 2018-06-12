package com.xiaoshabao.example.module.base.模式设计.工厂模式.methodFactory;

public class ExportFinancialPdfFile implements ExportFile{

    @Override
    public boolean export(String data) {
        // TODO Auto-generated method stub
        /**
         * 业务逻辑
         */
        System.out.println("导出财务版PDF文件");
        return true;
    }

}
