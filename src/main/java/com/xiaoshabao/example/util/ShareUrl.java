package com.xiaoshabao.example.util;

import java.net.URLEncoder;

public class ShareUrl {
	public static void main(String args[]) {
		try {
			String shareurl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxdad5b2abc4ba726f&redirect_uri="
					+ URLEncoder.encode(
							"http://aa.kongjianweb.com/signin/init.jhtml",
							"utf-8")
					+ "&response_type=code&scope=snsapi_base&state=21#wechat_redirect";

			System.out.print(shareurl);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
