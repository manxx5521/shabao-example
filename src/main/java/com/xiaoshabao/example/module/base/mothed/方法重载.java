package com.xiaoshabao.example.module.base.mothed;

import org.junit.Test;

public class 方法重载 {
	@Test
	public void test1(){
		方法重载 test=new 方法重载();
		
		/**
		 * 会对当前类型优先匹配，不匹配才会匹配父类
		 */
		test.say("测试说话");
		test.say(new SubMessage("测试"));
		test.say(new Message("测试"));
	}
	
	public void say(String message){
		System.out.println("String:"+message);
	}
	public void say(Message message){
		System.out.println("Message:"+message);
	}
	public void say(SubMessage message){
		System.out.println("SubMessage:"+message);
	}
	
	
	class Message{
		String msg;
		Message(String msg){
			this.msg=msg;
		}
	}
	
	class SubMessage extends Message{
		public SubMessage(String msg){
			super(msg);
		}
	}

}
