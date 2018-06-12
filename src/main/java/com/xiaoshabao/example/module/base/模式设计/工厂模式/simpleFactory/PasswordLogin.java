package com.xiaoshabao.example.module.base.模式设计.工厂模式.simpleFactory;

public class PasswordLogin implements Login {

    @Override
    public boolean verify(String name, String password) {
        /**
         * 业务逻辑
         */
        return true;
    }

}
