package com.xiaoshabao.example.module.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

/**
 * SHA安全散列算法
 * <p>
 * 固定长度，包括SHA-1、SHA-2(SHA-224、SHA-256、SHA-348、SHA-512)<br/>
 * 主要用来做验证比如微信
 * </p>
 */
public class SHATest {

	/**
	 * 通过Commons codec实现SHA1
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	@Test
	public void testCommonsSHA1() {
		String src = "manxx";
		String sha1 = DigestUtils.sha1Hex(src);
		System.out.println("commons实现SHA1:  " + sha1);
	}

	/**
	 * 通过jdk实现SHA1
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	@Test
	public void testJdkSHA1() throws NoSuchAlgorithmException {
		long time=System.currentTimeMillis();
		System.out.println(time);
		String src = time+"jjbfsxx2018";
		// 实现SHA1，这个和md5的一样。实现SHA1传入SHA
		MessageDigest md = MessageDigest.getInstance("SHA-1");
//		md.update(src.getBytes());//此方法会导致不同的结果
		byte[] digest = md.digest(src.getBytes());

		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < digest.length; i++) {
			String tempStr = Integer.toHexString(digest[i] & 0xff);
			if (tempStr.length() == 1) {
				buf.append("0").append(tempStr);
			} else {
				buf.append(tempStr);
			}
		}
		String sha1 = buf.toString().toLowerCase();
		System.out.println("jdk实现SHA1:  " + sha1);
	}

}
