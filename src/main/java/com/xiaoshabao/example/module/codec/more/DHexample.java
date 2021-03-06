package com.xiaoshabao.example.module.codec.more;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;

/**
 * DH加密算法
 */
public class DHexample {

	private String src = "manxx";

	/**
	 * DH加解密操作
	 * 
	 * @throws Exception
	 */
	@Test
	public void getJDK_DH() throws Exception {
		// 1、初始化发送方密钥
		KeyPairGenerator sendKeyPairGenerator = KeyPairGenerator
				.getInstance("DH");
		sendKeyPairGenerator.initialize(512); // 初始化大小
		KeyPair senderKeyPair = sendKeyPairGenerator.generateKeyPair();

		// 发送发公钥，发送给接收放（通过网络、文件等）
		byte[] senderPublicKeyEnc = senderKeyPair.getPublic().getEncoded();

		// 2、初始化接收方密钥
		KeyFactory receiverkeyFactory = KeyFactory.getInstance("DH");
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
				senderPublicKeyEnc);
		PublicKey receiverPublicKey = receiverkeyFactory
				.generatePublic(x509EncodedKeySpec);
		DHParameterSpec dhParameterSpec = ((DHPublicKey) receiverPublicKey)
				.getParams();
		KeyPairGenerator receiverKeyPairGenerator = KeyPairGenerator
				.getInstance("DH");
		receiverKeyPairGenerator.initialize(dhParameterSpec);
		KeyPair receiverKeyPair = receiverKeyPairGenerator.generateKeyPair();
		PrivateKey receiverPrivateKey = receiverKeyPair.getPrivate();
		byte[] receiverPublicKeyEnc = receiverKeyPair.getPublic().getEncoded();

		// 密钥构建
		KeyAgreement receiverKeyAgreement = KeyAgreement.getInstance("DH");
		receiverKeyAgreement.init(receiverPrivateKey);
		receiverKeyAgreement.doPhase(receiverPublicKey, true);
		SecretKey receiverDesKey = receiverKeyAgreement.generateSecret("DES");

		KeyFactory senderKeyFactory = KeyFactory.getInstance("DH");
		x509EncodedKeySpec = new X509EncodedKeySpec(receiverPublicKeyEnc);
		PublicKey senderPublicKey = senderKeyFactory
				.generatePublic(x509EncodedKeySpec);
		KeyAgreement senderKeyAgreement = KeyAgreement.getInstance("DH");
		senderKeyAgreement.init(senderKeyPair.getPrivate());
		senderKeyAgreement.doPhase(senderPublicKey, true);
		SecretKey senderDesKey = senderKeyAgreement.generateSecret("DES");// 发送方的本地密钥

		if (Objects.equals(receiverDesKey, senderDesKey)) {
			System.out.println("密码相同，表示密码对创建成功");
		}

		// 加密
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, senderDesKey);
		byte[] result = cipher.doFinal(src.getBytes());

		System.out.println("JDK DH加密后：" + Base64.encodeBase64String(result));

		// 解密
		cipher.init(Cipher.DECRYPT_MODE, receiverDesKey);
		result = cipher.doFinal(result);

		System.out.println("JDK DH解密后：" + new String(result));

	}

}
