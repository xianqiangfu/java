package com.email.quartz;


public class QuartzJob {

	 public void work() {
	    System.out.println("Quartz的任务调度！");
	    MailSenderInfo mailInfo = new MailSenderInfo();  
	      mailInfo.setMailServerHost("email.hisoft.com");   
	      mailInfo.setMailServerPort("25");   
	      mailInfo.setValidate(true);   
	      mailInfo.setUserName("wuxi\\P0044886");  
	      mailInfo.setPassword("Pactera#40");//您的邮箱密码   
	      mailInfo.setFromAddress("dongjia.wang@pactera.com");   
	      mailInfo.setToAddress("dongjia.wang@pactera.com");   
	      mailInfo.setSubject("Test");   
	      mailInfo.setContent("ok");   
	      //这个类主要来发送邮件  
	      SimpleMailSender sms = new SimpleMailSender();  
	      sms.sendTextMail(mailInfo);//发送文体格式   
	     //sms.sendHtmlMail(mailInfo);//发送html格式
	    }
}
