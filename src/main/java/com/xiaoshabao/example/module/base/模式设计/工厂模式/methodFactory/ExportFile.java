package com.xiaoshabao.example.module.base.模式设计.工厂模式.methodFactory;

/**
 * 导出角色类<br>
 * 导出类的统一接口，主要在导出工厂除做统一返回值，并提供共同导出方法
 */
public interface ExportFile {
    public boolean export(String data);
}
