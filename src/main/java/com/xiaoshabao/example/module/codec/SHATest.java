package com.xiaoshabao.example.module.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
/**
 * SHA安全散列算法
 * <p>固定长度，包括SHA-1、SHA-2(SHA-224、SHA-256、SHA-348、SHA-512)<br/>
 * 主要用来做验证比如微信</p>
 */
public class SHATest {
	
	/**
	 * 通过Commons codec实现SHA1
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	public void testCommonsSHA1(){
		String src="manxx";
		String sha1=DigestUtils.sha1Hex(src);
		System.out.println("commons实现SHA1:  "+sha1);
	}
	
	/**
	 * 通过jdk实现SHA1
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	public void testJdkSHA1() throws NoSuchAlgorithmException{
		String src="manxx";
		//实现SHA1，这个和md5的一样。实现SHA1传入SHA
		MessageDigest md=MessageDigest.getInstance("SHA");
		md.update(src.getBytes());
		byte[] bytes1=md.digest(src.getBytes());
		String sha1=Hex.encodeHexString(bytes1);
		System.out.println("jdk实现SHA1:  "+sha1);
	}

}
