package com.xiaoshabao.example.module.codec.more;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * PBE加密算法
 */
public class PBEexample {
	private String src="manxx";
	
	/**
	 * PBE的jdk算法
	 * @throws Exception
	 */
	@Test
	public void getJDK_PBE() throws Exception{
		//初始化盐
		SecureRandom random=new SecureRandom();
		byte[] salt=random.generateSeed(8);//盐值的位数
		
		//口令与密钥
		String password="imooc";
		PBEKeySpec pbeKeySpec=new PBEKeySpec(password.toCharArray());
		SecretKeyFactory factory=SecretKeyFactory.getInstance("PBEWITHMD5andDES");
		Key key=factory.generateSecret(pbeKeySpec);
		
		//加密
		//创建PBE加密参数，添加盐值和迭代次数
		PBEParameterSpec parameterSpec=new PBEParameterSpec(salt,100);
		Cipher cipher=Cipher.getInstance("PBEWITHMD5andDES");
		cipher.init(Cipher.ENCRYPT_MODE, key,parameterSpec);
		byte[] result=cipher.doFinal(src.getBytes());
		
		System.out.println("jdk PBE加密:"+Base64.encodeBase64String(result));
		
		//解密
		cipher.init(Cipher.DECRYPT_MODE, key,parameterSpec);
		result=cipher.doFinal(result);
		System.out.println("jdk PBE解密："+new String(result));
	}

}
