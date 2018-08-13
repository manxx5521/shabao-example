package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.alibaba.fastjson.JSONObject;

public class Test{
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String time = String.valueOf(System.currentTimeMillis());
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digest = md.digest((time+"jjbfsxx2018").getBytes());
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
          String tempStr = Integer.toHexString(digest[i] & 0xff);
          if (tempStr.length() == 1) {
            buf.append("0").append(tempStr);
          } else {
            buf.append(tempStr);
          }
        }
        String sha = buf.toString().toLowerCase();
        JSONObject json=new JSONObject();
        json.put("PWD_TIME", time);
        json.put("PWD_VALUE", sha);
        json.put("ROW_ID", "4D079A1A877348FB9F693EA9B9BC45A2");
        json.put("STATUS", "2");
        
        
        String rs=doHttp("http://10.15.0.187:8001/PD/JjbMessage",json.toJSONString());
		System.out.println(rs);
		
	}

	public static String doHttp(String urlStr, String output) {
	    StringBuilder sb = new StringBuilder();
	    HttpURLConnection connection = null;//http链接
	    try {
	      URL url = new URL(urlStr);//url创建
	      connection = (HttpURLConnection) url.openConnection();//打开链接
	      connection.setRequestMethod("POST");//设置请求方法。还可以设置其他参数
	      connection.setDoOutput(true);
	      connection.setDoInput(true);
	      connection.setConnectTimeout(5000);
	      connection.setReadTimeout(30000);
	      connection.setUseCaches(false);
	      connection.setRequestProperty("Content-Type", "application/json");
	      if (output != null) {
	        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
	        out.write(output);
	        out.flush();
	        out.close();
	      }
	      connection.connect();//正式链接请求

	      InputStream in = connection.getInputStream();//正确返回结果，获得输入流

	      //读取内容
	      InputStreamReader isr = new InputStreamReader(in, "UTF-8");
	      BufferedReader br = new BufferedReader(isr);//按行读取
	      String temp = null;
	      while ((temp = br.readLine()) != null) {//读取内容
	        sb.append(temp);
	      }
	      br.close();
	      isr.close();
	      in.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	      throw new RuntimeException("未能正常连接到消息方服务！", e);
	    } finally {
	      //关闭链接
	      if (connection != null) {
	        connection.disconnect();
	      }
	    }
	    return sb.toString();
	  }
}
