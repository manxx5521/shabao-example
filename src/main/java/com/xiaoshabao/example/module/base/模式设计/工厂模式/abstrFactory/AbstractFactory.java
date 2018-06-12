package com.xiaoshabao.example.module.base.模式设计.工厂模式.abstrFactory;

/**
 * 抽象工厂类
 * @author mxv
 *
 */
public interface AbstractFactory {
    /**
     * 创建CPU对象
     * @return CPU对象
     */
    public Cpu createCpu();
    /**
     * 创建主板对象
     * @return 主板对象
     */
    public Mainboard createMainboard();
}
