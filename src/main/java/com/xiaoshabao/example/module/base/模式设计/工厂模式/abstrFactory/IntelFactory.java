package com.xiaoshabao.example.module.base.模式设计.工厂模式.abstrFactory;
/**
 * 创建Intel家族的工厂类
 */
public class IntelFactory implements AbstractFactory {

    @Override
    public Cpu createCpu() {
        // TODO Auto-generated method stub
        return new IntelCpu(755);
    }

    @Override
    public Mainboard createMainboard() {
        // TODO Auto-generated method stub
        return new IntelMainboard(755);
    }

}
