package com.xiaoshabao.example.module.codec.more;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
/**
 * 3重DES加密算法
 * <p>这是一个对称的加密算法，<br/>
 * 因为DES不安全，所以推出了这个</p>
 */
public class DES3example {
private String src="man xiaoxu";
	
	/**
	 * jdk实现3DES加解密算法
	 * @throws Exception
	 */
	@Test
	public void getJDK_3DES() throws Exception{
		//生成key
		KeyGenerator keyGenerator=KeyGenerator.getInstance("DESede");
		//初始化大小
//		keyGenerator.init(168);
		keyGenerator.init(new SecureRandom()); //根据加密算法生成默认长度的key，和上一行代码作用一样
		SecretKey secreKey=keyGenerator.generateKey();
		byte[] bytesKey=secreKey.getEncoded();
		
		//KEY转换
		DESedeKeySpec desKeySpec=new DESedeKeySpec(bytesKey);
		SecretKeyFactory factory=SecretKeyFactory.getInstance("DESede");
		Key convertSecretKey=factory.generateSecret(desKeySpec); //根据生成的这个key加密
		
		//以上为初始化密码生成器，加解密都需要以上代码
		
		//加密
		Cipher cipher=Cipher.getInstance("DESede/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
		byte[] result=cipher.doFinal(src.getBytes());
		
		System.out.println("jdk 3DES加密码后为："+Hex.encodeHexString(result));//将结果转换16进制，再转换成字符串
		
		//解密
		cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
		result=cipher.doFinal(result); //解密
		System.out.println("jdk 3DES解密后为："+new String(result));
		
	}

}
