package com.email.quartz;


import javax.mail.*;  
/**
 * @param 认证模块
 * @author dj
 *
 */

public class MyAuthenticator extends Authenticator {
	       String userName=null;  
	       String password=null;  
	        
	     public MyAuthenticator(){  
	     }  
	     public MyAuthenticator(String username, String password) {   
	         this.userName = username;   
	         this.password = password; 
	     }   
	     @Override
		protected PasswordAuthentication getPasswordAuthentication(){  
	         return new PasswordAuthentication(userName, password);  
	     }  


}
