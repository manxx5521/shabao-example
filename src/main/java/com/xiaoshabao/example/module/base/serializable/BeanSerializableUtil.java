package com.xiaoshabao.example.module.base.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对java类进行序列化和反序列话
 */
public class BeanSerializableUtil {
	/**
	 * 序列化
	 * 
	 * @param object
	 * @return
	 * @throws IOException
	 */
	public static byte[] serialize(Object object) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ObjectOutputStream outputStream = new ObjectOutputStream(os);
		outputStream.writeObject(object);
		outputStream.flush();
		byte[] byteArray = os.toByteArray();
		outputStream.close();
		os.close();
		return byteArray;
	}

	/**
	 * 反序列化
	 * 
	 * @param buf
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deSerialize(byte[] buf) throws IOException, ClassNotFoundException {
		ByteArrayInputStream is = new ByteArrayInputStream(buf);
		ObjectInputStream inputStream = new ObjectInputStream(is);
		Object object = inputStream.readObject();
		inputStream.close();
		is.close();
		return object;
	}
}
