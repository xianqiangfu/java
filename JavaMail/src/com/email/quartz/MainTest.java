package com.email.quartz;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest{
	
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("Test start.");
        ApplicationContext context = new ClassPathXmlApplicationContext("quartz-config.xml");
        //如果配置文件中将startQuertz bean的lazy-init设置为false 则不用实例化
        //context.getBean("startQuertz");
        //上面的代码会挂起，等到指定时间时执行 		
        //然后执行下面的代码
        
        System.out.println("Waiting......");
    }
}