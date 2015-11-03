package stl1;
import java.util.*;

public class stltest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection collection = new ArrayList();
		
		collection.add("Hello");
		collection.add(new Person("f1", 18));
		collection.add(new Integer(100));
		System.out.println(collection.size());
		System.out.println(collection);
	}

}

class Person 
{
	private String name;
	private int age;
	
	public Person(String name, int age)
	{
		this.name = name;
		this.age  = age;
	}
}
