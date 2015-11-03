package employeeTest;
import java.io.*;


public class EmploueeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee empOne = new Employee("Jim");
		Employee empTwo = new Employee("Tom");
		
		empOne.empAge(26);
		empOne.empDesignation("Senior Software Engineer");
		empOne.empSalary(1000);
		empOne.printEmployee();
		
		System.out.println("===============");
		empTwo.empAge(21);
		empTwo.empDesignation("Software Engineer");
		empTwo.empSalary(500);
		empTwo.printEmployee();
	}

}
