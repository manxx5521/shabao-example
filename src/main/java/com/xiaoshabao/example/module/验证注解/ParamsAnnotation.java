package com.xiaoshabao.example.module.验证注解;


import org.junit.jupiter.api.Test;
import org.springframework.lang.NonNull;


/**
 * 参数验证
 */
public class ParamsAnnotation {
  
  @Test
  public void test() {
    testNotNull(null);
  }
  
  /**
   * 做标识 @NonNull 不可以为空  @Nullable可以为可空
   */
  public void testNotNull(@NonNull String name) {
    System.out.println("通过测试："+name);
  }

}
