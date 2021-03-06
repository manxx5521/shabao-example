package com.xiaoshabao.example.module.codec;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

/**
 * AES加密算法
 */
public class AESTest {
	
private String src="man xiaoxu";
	
	/**
	 * jdk实现AES加解密算法
	 * @throws Exception
	 */
	@Test
	public void getJDK_AES() throws Exception{
		//生成key
		KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
		//初始化大小
		keyGenerator.init(128);
//		keyGenerator.init(new SecureRandom()); //根据加密算法生成默认长度的key，和上一行代码作用一样
		SecretKey secreKey=keyGenerator.generateKey();
		byte[] bytesKey=secreKey.getEncoded();
		
		//KEY转换
		Key key=new SecretKeySpec(bytesKey,"AES");
		
		//加解密都需要以上代码
		
		//加密
		Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] result=cipher.doFinal(src.getBytes());
		
		System.out.println("jdk AES加密码后为："+Hex.encodeHexString(result));//将结果转换16进制，再转换成字符串
		
		//解密
		cipher.init(Cipher.DECRYPT_MODE, key);
		result=cipher.doFinal(result); //解密
		System.out.println("jdk AES解密后为："+new String(result));
		
	}

}
