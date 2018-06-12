package com.xiaoshabao.example.module.base.模式设计.工厂模式.methodFactory;

/**
 * 工厂方法<br>
 * 所有的具体工厂角色都需要实现这个接口
 */
public interface ExportFactory {
	/**
	 * 导出方法
	 * @param type 导出的类型
	 * @return
	 */
	public ExportFile factory(String type);
}
