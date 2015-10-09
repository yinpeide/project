package com.itcast.util;

import com.itcast.util.mail.MailSenderInfo;
import com.itcast.util.mail.SimpleMailSender;

/**
 * @author 尹培德
 * @time 2015年8月5日下午1:16:54
 */
public class MailUtils {
	
	/**
	 * 发送文本格式的邮件
	 * @param mailInfo
	 * @return
	 */
	public static boolean sendTextMail(MailSenderInfo mailInfo){
		return SimpleMailSender.sendTextMail(mailInfo);
	}
	
	/**
	 * 发送HTML格式的邮件
	 * @param mailInfo
	 * @return
	 */
	public static boolean sendHtmlMail(MailSenderInfo mailInfo){
		return SimpleMailSender.sendHtmlMail(mailInfo);
	}
	
	
//	 public static void main(String[] args){
//	        //这个类主要是设置邮件  
//	     MailSenderInfo mailInfo = new MailSenderInfo();   
//	     mailInfo.setMailServerHost("smtp.126.com");   
//	     mailInfo.setMailServerPort("25");   
//	     mailInfo.setValidate(true);   
//	     mailInfo.setUsername("ypdmail@126.com");   
//	     mailInfo.setPassword("**********");//您的邮箱密码   
//	     mailInfo.setFromAddress("ypdmail@126.com");   
//	     mailInfo.setToAddress("974935950@qq.com");   
//	     mailInfo.setSubject("设置邮箱标题");   
//	     mailInfo.setContent("设置邮箱内容");   
//	        //这个类主要来发送邮件  
//	     SimpleMailSender.sendTextMail(mailInfo);
//	     SimpleMailSender.sendHtmlMail(mailInfo);
//	 }

}
