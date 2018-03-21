package com.xiaoshabao.example.module.mail;

public class Testmail {
	public static void main(String[] args){  
        //这个类主要是设置邮件  
     MailSenderInfo mailInfo = new MailSenderInfo();   
     mailInfo.setMailServerHost("smtp.163.com");   
     mailInfo.setMailServerPort("25");   
     mailInfo.setValidate(true);   
     mailInfo.setUserName("manxx5521@163.com");   
     //163现在登录为授权密码，需要通过网易邮箱获取
     mailInfo.setPassword("uljbpgpjqihneled");//您的邮箱密码   
     mailInfo.setFromAddress("manxx5521@163.com");   
     mailInfo.setToAddress("382752556@qq.com");   
     mailInfo.setSubject("设置邮箱标题");   
     mailInfo.setContent("设置邮箱内容");   
        //这个类主要来发送邮件  
     SimpleMailSender sms = new SimpleMailSender();
         sms.sendTextMail(mailInfo);//发送文体格式   
         sms.sendHtmlMail(mailInfo);//发送html格式  
   }  
}
