package jdbcTemplateTest1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

// http://www.cnblogs.com/wanggd/p/3140506.html
class Customer 
{
	private String Id;
	private String Name;
	
	public void setId(String id) {
		this.Id = id;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public String getId() {
		return Id;
	}
	
	public String getName() {
		return Name;
	}
}

public class jdbctest {

	private static ApplicationContext  ctx = new ClassPathXmlApplicationContext("bean.xml");
	private static void testOne() {
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx
	            .getBean("jdbcTemplate");
		
		List<Customer> customerList = (List)jdbcTemplate.query("select * from table1", new ResultSetExtractor(){

			@Override
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Customer> customers = new ArrayList<Customer>();
				while(rs.next())
				{
					Customer customer = new Customer();
					customer.setId(rs.getString(1));
					customer.setName(rs.getString(2));
					customers.add(customer);
				}
				return customers;
			}});
		
		Iterator<Customer> iterator = customerList.iterator();
    	
   	 	while (iterator.hasNext()) {
   	 	Customer map4 = (Customer) iterator.next();             
            System.out.println("ID = " + map4.getId());
            System.out.println("Name = " + map4.getName());
        }
	}
	
	private static void testTwo() {
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx
	            .getBean("jdbcTemplate");
		
		List<Customer> customerList = jdbcTemplate.query("select * from table1", new RowMapper(){

			public Object mapRow(ResultSet rs, int rowNumber) throws SQLException {
				Customer customer = new Customer();
				customer.setId(rs.getString(1));
				customer.setName(rs.getString(2));
				return customer;
			}});
		
		Iterator<Customer> iterator = customerList.iterator();
    	
   	 	while (iterator.hasNext()) {
   	 	Customer map4 = (Customer) iterator.next();             
            System.out.println("ID = " + map4.getId());
            System.out.println("Name = " + map4.getName());
        }
	}
	
	private static void testThree() {
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx
	            .getBean("jdbcTemplate");
		
		final List<Customer> customerList = new ArrayList<Customer>();

		jdbcTemplate.query("select * from table1", new RowCallbackHandler(){

			public void processRow(ResultSet rs) throws SQLException {
				Customer customer = new Customer();
				customer.setId(rs.getString(1));
				customer.setName(rs.getString(2));
				customerList.add(customer);
			}});
		
		
		Iterator<Customer> iterator = customerList.iterator();
    	
   	 	while (iterator.hasNext()) {
   	 	Customer map4 = (Customer) iterator.next();             
            System.out.println("ID = " + map4.getId());
            System.out.println("Name = " + map4.getName());
        }
		
	}
	
	public static void testPpreparedStatement1() {  
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx
	            .getBean("jdbcTemplate");
		  int count = jdbcTemplate.execute(new PreparedStatementCreator() {  
		     @Override  
		     public PreparedStatement createPreparedStatement(Connection conn)  
		         throws SQLException {  
		         return conn.prepareStatement("select count(*) from table1");  
		     }}, new PreparedStatementCallback<Integer>() {  
		     @Override  
		     public Integer doInPreparedStatement(PreparedStatement pstmt)  
		         throws SQLException, DataAccessException {  
		         pstmt.execute();  
		         ResultSet rs = pstmt.getResultSet(); 
		         //System.out.println("Id = " + rs.getString(1));
		         //System.out.println("Name = " + rs.getString(2));
		         rs.next();  
		         return rs.getInt(1);  
		      }});
		  
		  System.out.println("count = " + count);
		}  
	
	
	
	public static void testPpreparedStatement2() {  
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx
	            .getBean("jdbcTemplate");
		  List<Customer> customerList = jdbcTemplate.execute(new PreparedStatementCreator() {  
		     @Override  
		     public PreparedStatement createPreparedStatement(Connection conn)  
		         throws SQLException {  
		         return conn.prepareStatement("select * from table1");  
		     }}, new PreparedStatementCallback<List<Customer>>() {  
		     @Override  
		     public List<Customer> doInPreparedStatement(PreparedStatement pstmt)  
		         throws SQLException, DataAccessException {  
		         pstmt.execute();  
		         ResultSet rs = pstmt.getResultSet(); 
		         List<Customer> customers = new ArrayList<Customer>();
					while(rs.next())
					{
						Customer customer = new Customer();
						customer.setId(rs.getString(1));
						customer.setName(rs.getString(2));
						customers.add(customer);
					}
					return customers; 
		      }});
		  
		  Iterator<Customer> iterator = customerList.iterator();
	    	
	   	 	while (iterator.hasNext()) {
	   	 	Customer map4 = (Customer) iterator.next();             
	            System.out.println("ID = " + map4.getId());
	            System.out.println("Name = " + map4.getName());
	        }
		}  
	
	
	
	public static void testPreparedStatement4() {  
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx
	            .getBean("jdbcTemplate");
		  String insertSql = "insert into table1(ID, Name) values (?, ?)";  
		  int count = jdbcTemplate.update(insertSql, new PreparedStatementSetter() {  
		      @Override  
		      public void setValues(PreparedStatement pstmt) throws SQLException {  
		          pstmt.setObject(1, "12344321"); 
		          pstmt.setObject(2, "����ǿ");
		  }});     
//		  String deleteSql = "delete from test where name=?";  
//		  count = jdbcTemplate.update(deleteSql, new Object[] {"name4"});  
		}  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Test one!!!!");
//		testOne();
//		System.out.println("============================");
//		System.out.println("Test two!!!!");
//		testTwo();
//		System.out.println("============================");
//		System.out.println("Test three!!!!");
//		testThree();
//		System.out.println("============================");
		
//		testPpreparedStatement2();
		testPreparedStatement4();

	}

}
