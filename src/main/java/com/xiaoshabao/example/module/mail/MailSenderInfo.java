package com.xiaoshabao.example.module.mail;

/** 
 * 发送邮件需要使用的基本信息 
 */
import java.util.Properties;

public class MailSenderInfo {
	/**
	 * 发送邮件的服务器的IP和端口 
	 * */
	private String mailServerHost;
	/**
	 * 默认服务接口
	 */
	private String mailServerPort = "25";
	/** 
	 * 邮件发送者的地址
	 *  */
	private String fromAddress;
	/** 
	 * 邮件接收者的地址 
	 * */
	private String toAddress;
	/** 
	 * 登陆邮件发送服务器的用户名
	 * */
	private String userName;
	/** 
	 * 登陆邮件发送服务器的密码 
	 * */
	private String password;
	/** 
	 * 是否需要身份验证
	 *  */
	private boolean validate = false;
	/** 
	 * 邮件主题 
	 * */
	private String subject;
	/** 
	 * 邮件的文本内容 
	 * */
	private String content;
	/** 
	 * 邮件附件的文件名 
	 * */
	private String[] attachFileNames;

	/**
	 * 获得邮件会话属性
	 */
	public Properties getProperties() {
		Properties p = new Properties();
		p.put("mail.smtp.host", this.mailServerHost);
		p.put("mail.smtp.port", this.mailServerPort);
		p.put("mail.smtp.auth", validate ? "true" : "false");
		return p;
	}
	
	/**
	 * 用来获得host路径
	 */
	public String getMailServerHost() {
		return mailServerHost;
	}
	/**
	 * 用来设置host路径<br/>
	 * 比如163邮箱设置为：smtp.163.com
	 */
	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	public String getMailServerPort() {
		return mailServerPort;
	}
	/**
	 * 设置端口<br/>
	 * 默认端口25
	 */
	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	public boolean isValidate() {
		return validate;
	}
	
	/**
	 * 是否需要验证
	 * @param validate 默认false,不验证
	 */
	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String[] getAttachFileNames() {
		return attachFileNames;
	}

	public void setAttachFileNames(String[] fileNames) {
		this.attachFileNames = fileNames;
	}

	public String getFromAddress() {
		return fromAddress;
	}
	/**
	 * 设置邮件发送者地址
	 */
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 设置邮件接收人地址
	 * @return
	 */
	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getSubject() {
		return subject;
	}
	
	/**
	 * 设置邮件主题
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}
	/**
	 * 设置右键内容
	 * @param textContent
	 */
	public void setContent(String textContent) {
		this.content = textContent;
	}
}
