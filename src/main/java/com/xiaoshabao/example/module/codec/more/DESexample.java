package com.xiaoshabao.example.module.codec.more;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

/**
 * DES加密算法
 * <p>这是一个对称的加密算法，<br/>
 * 这个算法出现的最早，已经不安全了</p>
 */
public class DESexample {
	
	private String src="man xiaoxu";
	
	/**
	 * jdk实现DES加解密算法
	 * @throws Exception
	 */
	@Test
	public void getJDK_DES() throws Exception{
		//生成key
		KeyGenerator keyGenerator=KeyGenerator.getInstance("DES");
		//初始化大小
		keyGenerator.init(56);
		SecretKey secreKey=keyGenerator.generateKey();
		byte[] bytesKey=secreKey.getEncoded();
		
		//KEY转换
		DESKeySpec desKeySpec=new DESKeySpec(bytesKey);
		SecretKeyFactory factory=SecretKeyFactory.getInstance("DES");
		Key convertSecretKey=factory.generateSecret(desKeySpec); //根据生成的这个key加密
		
		//以上为初始化密码生成器，加解密都需要以上代码
		
		//加密
		Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
		byte[] result=cipher.doFinal(src.getBytes());
		
		System.out.println("jdk DES加密码后为："+Hex.encodeHexString(result));//将结果转换16进制，再转换成字符串
		
		//解密
		cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
		result=cipher.doFinal(result); //解密
		System.out.println("jdk DES解密后为："+new String(result));
		
	}
}
