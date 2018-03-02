package com.xiaoshabao.example.module.base.factory.abstrFactory;

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
