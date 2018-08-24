package com.xiaoshabao.example.module.rpc;

import java.io.IOException;

/**
 * 服务中心接口
 */
public interface Server {
    public void stop();
 
    public void start() throws IOException;
 
    public void register(Class<?> serviceInterface, Class<?> impl);
 
    public boolean isRunning();
 
    public int getPort();
}
