package com.r.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");//��ȡbean.xml�е�����
        SpringTest p = ctx.getBean("person",SpringTest.class);//����bean�����ö���
        p.info();
	}

}
