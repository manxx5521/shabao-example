package com.xiaoshabao.example.module.base.factory.simpleFactory;

public class PasswordLogin implements Login {

    @Override
    public boolean verify(String name, String password) {
        /**
         * 业务逻辑
         */
        return true;
    }

}
