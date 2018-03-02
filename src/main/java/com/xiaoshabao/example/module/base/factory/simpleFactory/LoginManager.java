package com.xiaoshabao.example.module.base.factory.simpleFactory;
/**
 * 登录工厂类<br>
 * 最简单的工厂模式<br>
 * 	这个用来管理，Login接口的实现类。DomainLogin和PasswordLogin
 *	根据调用者不同的要求，创建出不同的登录对象并返回
 */
public class LoginManager {
    public static Login factory(String type){
        if(type.equals("password")){
            
            return new PasswordLogin();
            
        }else if(type.equals("passcode")){
            
            return new DomainLogin();
            
        }else{
            /**
             * 这里抛出一个自定义异常会更恰当
             */
            throw new RuntimeException("没有找到登录类型");
        }
    }
}
