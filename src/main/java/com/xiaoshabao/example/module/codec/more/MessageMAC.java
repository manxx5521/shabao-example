package com.xiaoshabao.example.module.codec.more;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * 含有密钥的散列函数算法
 * <p>融合了MD和SHA<br>
 * 应用在Scrt客户端</p>
 * 
 */
public class MessageMAC {
	
	private String src="manxx";
	/**
	 * 通过jdk实现MACMD5
	 */
	@Test
	public void getJDK_macMD5() throws Exception{
		//实现HmacMD5，初始化KeyGenerator
		KeyGenerator keyGenerator=KeyGenerator.getInstance("HmacMD5");
		//产生密钥
		SecretKey secretKey=keyGenerator.generateKey();
		//获得密钥
		byte[] key=secretKey.getEncoded();
		
		//可以构建自己的密钥如下密钥为aa
//		byte[] key=Hex.decodeHex(new char[]{'a','a'});
		
		//还原密钥
		SecretKey restoreSecretKey=new SecretKeySpec(key, "HmacMD5");
		//实例化MAC
		Mac mac=Mac.getInstance(restoreSecretKey.getAlgorithm());
		//MAC进行初始化
		mac.init(restoreSecretKey);
		//执行摘要算法
		byte[] hmacMD5bytes=mac.doFinal(src.getBytes());
		String hmacMD5=Hex.encodeHexString(hmacMD5bytes);
		
		System.out.println("jdk实现HmacMD5:"+hmacMD5);
	}

}
