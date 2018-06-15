package com.xiaoshabao.example.module.io;

import java.io.File;

/**
 * 声明式接口，不同实现测试方法
 */
public interface IOInterface {
  
  void toInputStrean();
  /**根据文件目录,*/
  void toInputStreanByPath(String path);
  /**根据文件读取目录*/
  void toInputStrean(File file);
  /**字符串直接读取到输入流**/
  void toInputStreanByString(String content);
  
  /**
   * 将输入流InputStream写入文件
   */
  void writeInputStreamToFile();
  
  

}
