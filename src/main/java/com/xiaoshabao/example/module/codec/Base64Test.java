package com.xiaoshabao.example.module.codec;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.junit.jupiter.api.Test;
/**
 * Base64是一种用64个字符来表示任意二进制数据的方法。
 */
public class Base64Test {
	
	/**
	 * 使用commons 进行base64加密
	 */
	@Test
	public void testCommonsBase64(){
		String src="manxx";
		//加密
		byte[] encodeBytes=org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());
		//解密
		byte[] decodeBytes=org.apache.commons.codec.binary.Base64.decodeBase64(encodeBytes);
		
		System.out.println("加密encode:"+new String(encodeBytes));
		System.out.println("解密decode:"+new String(decodeBytes));
	}
	
	/**
	 * jdk实现Base64加密(需要1.8版本以上)
	 * @throws IOException 
	 */
	@Test
	public void testJdKBase64() {
		String src="manxx";
		//加密
	    String desc = Base64.getEncoder().encodeToString(src.getBytes(StandardCharsets.UTF_8));  
	    //解密
	    String unDecodeStr=new String(Base64.getDecoder().decode(desc),StandardCharsets.UTF_8); 
	    
	    System.out.println("加密后的字符串为:"+desc);
	    System.out.println("解密后的字符串为"+unDecodeStr);  
	}
	
	
	/**
	 * jdk实现Base64加密,历史版本加密方式，已经不适用于1.8
	 * @throws IOException 
	 */
	@Test
	public void testJdKBase64ForOld() throws Exception{
		/*String src="manxx";
		
		//实现加密
		BASE64Encoder encoder=new BASE64Encoder();
		String encode=encoder.encode(src.getBytes());
		
		//实现解密
		BASE64Decoder decoder=new BASE64Decoder();
		String yuan=new String(decoder.decodeBuffer(encode));
		
		System.out.println("encode:"+encode);
		System.out.println("yuan:"+yuan);*/
	}

}
