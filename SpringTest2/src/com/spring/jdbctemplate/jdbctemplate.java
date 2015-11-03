package com.spring.jdbctemplate;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
//http://www.cnblogs.com/Fskjb/archive/2009/11/18/1605622.html
public class jdbctemplate {

	 private JdbcTemplate jdbcT = (JdbcTemplate) SpringUtil
	            .getBean("jdbcTemplate");

	 public List findALL() {
	        String sql = "select * from table1";
	        return jdbcT.queryForList(sql);        
	    }
	    
	    public static void main(String[] args) {  
	    	jdbctemplate test = new jdbctemplate();
	    	List l = test.findALL();
	    	System.out.println("111111");
	    	Iterator iterator = l.iterator();
	    	
	    	 while (iterator.hasNext()) {
	             Map map4 = (Map) iterator.next();             
	             System.out.println("ID = " + map4.get("ID"));
	             System.out.println("Name = " + map4.get("Name"));
	         }
	    }

}