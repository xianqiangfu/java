package com.test.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class quartzMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test start...");
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		System.out.println("Test end...");
	}
}
