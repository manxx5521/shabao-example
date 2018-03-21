package com.xiaoshabao.example.module.codec;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * RSA加密算法
 */
public class RSATest {
	
	/**
	 * JDK RSA 加密算法
	 */
	@Test
	public void testJdkRSA() throws Exception{
		try {
			String src="manxx";
			//1、初始化密钥
			KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(512);//初始化大小64的倍数
			KeyPair keyPair=keyPairGenerator.generateKeyPair();
			RSAPublicKey rsaPublicKey=(RSAPublicKey)keyPair.getPublic();//获得公钥
			RSAPrivateKey rsaPrivateKey=(RSAPrivateKey)keyPair.getPrivate();//获得私钥
			
			//2、私钥加密 
			//加密
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec=new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
			KeyFactory keyFactory=KeyFactory.getInstance("RSA");
			PrivateKey privateKey=keyFactory.generatePrivate(pkcs8EncodedKeySpec);
			Cipher cipher=Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			byte[] result=cipher.doFinal(src.getBytes()); //获得加密后的byte数组
			
			System.out.println("JDK RSA加密："+Base64.encodeBase64String(result));
			
			//3、公钥解密
			X509EncodedKeySpec x509EncodedKeySpec=new X509EncodedKeySpec(rsaPublicKey.getEncoded());
			keyFactory=KeyFactory.getInstance("RSA");
			PublicKey publicKey=keyFactory.generatePublic(x509EncodedKeySpec);
			 cipher=Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			result=cipher.doFinal(result);
			
			System.out.println("JDK RSA解密："+new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * RSA的签名算法
	 * @throws Exception 
	 */
	@Test
	public void testJdkQMRSA() throws Exception{
		String src="manxx";
		//1.初始化密钥
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(512);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();
		
		//2.执行签名
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Signature signature = Signature.getInstance("MD5withRSA");
		signature.initSign(privateKey);
		signature.update(src.getBytes());
		byte[] result = signature.sign();
		System.out.println("签名 : " + Hex.encodeHexString(result));
		
		//3.验证签名
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
		keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		signature = Signature.getInstance("MD5withRSA");
		signature.initVerify(publicKey);
		signature.update(src.getBytes());
		boolean bool = signature.verify(result);
		System.out.println("验证：" + bool);
	}

}
