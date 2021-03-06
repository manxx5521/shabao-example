package com.xiaoshabao.example.module.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Test;

/**
 * JDK发HTTP请求
 */
public class HttpJdkTest {

	/**
	 * 发送HTTP请求
	 */
	@Test
	public void doGetHTTP() {
		String urlString = "http://www.baidu.com";

		StringBuilder sb = new StringBuilder();
		HttpURLConnection connection = null;// http链接
		try {
			URL url = new URL(urlString);// url创建
			connection = (HttpURLConnection) url.openConnection();// 打开链接
			connection.setRequestMethod("GET");// 设置请求方法。还可以设置其他参数

			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(30000);
			connection.setUseCaches(false);
			// connection.setRequestProperty("Content-Type", "application/json");
			/*发送值
			String output = null;
			if (output != null) {
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(output);
				out.flush();
				out.close();
			}
			 */
			connection.connect();// 正式链接请求
			InputStream in = connection.getInputStream();// 正确返回结果，获得输入流

			// 读取内容
			InputStreamReader isr = new InputStreamReader(in/* ,"UTF-8" */);
			BufferedReader br = new BufferedReader(isr);// 按行读取
			String temp = null;
			while ((temp = br.readLine()) != null) {// 读取内容
				sb.append(temp);
			}
			br.close();
			isr.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭链接
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}
