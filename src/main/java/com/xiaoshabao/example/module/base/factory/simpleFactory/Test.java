package com.xiaoshabao.example.module.base.factory.simpleFactory;

public class Test {
    public static void main(String[] args) {
        String loginType = "password";
        String name = "name";
        String password = "password";
        
        /*
         * 这个里根据loginType类型的不同创建不同Login对象
         */
        Login login = LoginManager.factory(loginType);
        boolean bool = login.verify(name, password);
        if (bool) {
            /**
             * 业务逻辑
             */
        } else {
            /**
             * 业务逻辑
             */
        }
    }
}
