package com.xiaoshabao.example.module.rpc;
/**
 * HelloServices接口实现类
 */
public class HelloServiceImpl implements HelloService {
	 
    public String sayHi(String name) {
        return "Hi, " + name;
    }
 
}
