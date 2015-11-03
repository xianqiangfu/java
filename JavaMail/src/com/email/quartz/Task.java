package com.email.quartz;


import java.util.TimerTask;

public class Task extends TimerTask {
	public void run() {
		System.out.println("定时发邮件"); 
		
		//定时发邮件功能
		MailSenderInfo mailInfo = new MailSenderInfo();
		SimpleMailSender simpleMailSender=new SimpleMailSender();
		simpleMailSender.sendHtmlMail(mailInfo);
		System.out.print("成功发送邮件");		
	}
}

