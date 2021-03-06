package com.xiaoshabao.example.module.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
/**
 * 实现消息摘要算法的MD方式
 * <p>主要是MD5，其他还有MD2、MD5</p>
 */
public class MD5Test {
	/**
	 * Commons包提供的加密方法
	 */
	@Test
	public void testCommons() {
		String md5 = DigestUtils.md5Hex("620105ai620105AI");
		System.out.println(md5);
	}
	
	/**
	 * 实现jdk的md5算法
	 * @throws NoSuchAlgorithmException
	 */
	@Test
	public void testJdkMD5() throws NoSuchAlgorithmException{
		String src="manxx";
		//jdk提供MD5和MD2实现
		MessageDigest md=MessageDigest.getInstance("MD5");
		byte[] md5Byte=md.digest(src.getBytes());
		//jdk只能转换成byte数组，通过commons的codec转换成字符串
		String md5String=Hex.encodeHexString(md5Byte);
		
		System.out.println("JDK md5加密："+md5String);
	}

}
